package achmad.rifai.helper.services;

import java.util.List;
import java.util.Map;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

import achmad.rifai.helper.dto.KafkaMessage;
import achmad.rifai.helper.dto.RedisSaver;
import achmad.rifai.helper.modals.Category;
import achmad.rifai.helper.modals.Menu;
import achmad.rifai.helper.modals.Menu1;
import achmad.rifai.helper.repositories.CategoryRepository;
import achmad.rifai.helper.repositories.MenuRepository;
import achmad.rifai.helper.utils.HelperUtil;
import reactor.core.publisher.Mono;

@Service
public class HelperService {

	@Autowired
	ReactiveRedisTemplate<String, RedisSaver> template2;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	MenuRepository menuRepository;

	public Mono<Boolean> helperConsuming(String message) {
		return Mono.just(message)
				.map(HelperUtil::toMessage)
				.map(KafkaMessage::getId)
				.flatMap(template2.opsForValue()::getAndDelete)
				.flatMap(this::saving)
				.doOnError(HelperUtil::showError);
	}

	@SuppressWarnings("unchecked")
	private Mono<Boolean> saving(RedisSaver saver) {
		final var data = saver.getRedisLocal();
		if (saver.getId().equals("menu")) {
			return menuRepository.findById(String.valueOf(data.get("id")))
					.switchIfEmpty(Mono.just(Menu.builder().id(String.valueOf(data.get("id"))).build()))
					.flatMap(m -> {
						m.setCategory(String.valueOf(data.get("category")));
						m.setName(String.valueOf(data.get("name")));
						m.setStock((Integer) data.get("stock"));
						m.setPrice(Money.of(CurrencyUnit.of("IDR"), (Double) data.get("price")).toString());
						return menuRepository.save(m);
					})
					.map(v -> false);
		} else if (saver.getId().equals("category")) {
			return categoryRepository.findById(String.valueOf(data.get("id")))
					.switchIfEmpty(Mono.just(Category.builder().id(String.valueOf(data.get("id"))).build()))
					.flatMap(c -> {
						c.setName(String.valueOf(data.get("name")));
						final var menus = (List<Map<String, Object>>) data.get("menus");
						c.setMenus(menus.stream()
								.map(m -> Menu1.builder()
										.id(String.valueOf(m.get("id")))
										.category(String.valueOf(m.get("category")))
										.name(String.valueOf(m.get("name")))
										.stock((Integer) m.get("stock"))
										.price(Money.of(CurrencyUnit.of("IDR"), (Double) m.get("price")).toString())
										.build())
								.toList());
						return categoryRepository.save(c);
					}).map(v -> false);
		}
		return Mono.just(false);
	}

}
