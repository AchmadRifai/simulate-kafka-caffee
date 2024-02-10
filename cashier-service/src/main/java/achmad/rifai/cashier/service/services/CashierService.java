package achmad.rifai.cashier.service.services;

import achmad.rifai.cashier.service.components.ProducerComponent;
import achmad.rifai.cashier.service.dto.ArrayRes;
import achmad.rifai.cashier.service.dto.CategoryDto;
import achmad.rifai.cashier.service.dto.InquiryPriceReq;
import achmad.rifai.cashier.service.dto.InquiryPriceRes;
import achmad.rifai.cashier.service.dto.MessageRes;
import achmad.rifai.cashier.service.dto.OrderReq;
import achmad.rifai.cashier.service.modals.Menu1;
import achmad.rifai.cashier.service.repositories.CategoryRepository;
import achmad.rifai.cashier.service.repositories.MenuRepository;
import achmad.rifai.cashier.service.utils.CashierUtils;

import java.util.HashMap;

import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CashierService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    ProducerComponent producerComponent;

    public Mono<ArrayRes<CategoryDto>> all() {
        return categoryRepository.findAll()
                .filter(c -> c.getMenus().stream().mapToInt(Menu1::getStock).sum() > 0)
                .collectList()
                .map(CashierUtils::toCategoryArrayRes)
                .doOnError(CashierUtils::showError);
    }

	public Mono<InquiryPriceRes> inquiryPrice(InquiryPriceReq req) {
		return Flux.fromIterable(req.getItems())
				.flatMap(i -> menuRepository.findById(i.getIdMenu())
						.map(s -> {
							var map = new HashMap<String, Object>();
							map.put("count", i.getQuantity());
							map.put("price", s.getPrice());
							return map;
						}))
				.map(CashierUtils::countPriceMenu)
				.collectList()
				.map(l -> InquiryPriceRes.builder()
						.totalPrice(Money.total(l).toString())
						.build())
				.doOnError(CashierUtils::showError);
	}

	public Mono<MessageRes> order(OrderReq req) {
		return Mono.just(req)
				.map(CashierUtils::toRedisSaver)
				.flatMap(producerComponent::cashierToKitchen)
				.map(r -> MessageRes.builder().message("Success").build())
				.doOnError(CashierUtils::showError);
	}
}
