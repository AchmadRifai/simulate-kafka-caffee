package achmad.rifai.supplier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import achmad.rifai.supplier.dto.MessageRes;
import achmad.rifai.supplier.dto.SupplyReq;
import achmad.rifai.supplier.utils.SupplierUtil;
import reactor.core.publisher.Mono;

@Service
public class SupplierService {

	@Autowired
	ProducerService producerService;

	public Mono<MessageRes> supplying(SupplyReq req) {
		return Mono.just(req)
				.map(SupplierUtil::toSaver)
				.flatMap(producerService::supplierToKitchen)
				.map(v -> MessageRes.builder().message("Success").build())
				.doOnError(SupplierUtil::showError);
	}

}
