package achmad.rifai.kitchen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import achmad.rifai.kitchen.utils.KitchenUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@Autowired
	KitchenService service;

	@KafkaListener(topics = "cashier2kitchen", groupId = "my-group")
	public void fromCashier(String message, Acknowledgment acknowledgment) {
		try {
			log.info("Topic {} message {}", "cashier2kitchen", message);
			service.ordering(KitchenUtils.toMessage(message));
			log.info("cashier2kitchen done");
		} catch (Exception e) {
			log.info(e.getLocalizedMessage(), e);
		} finally {
			acknowledgment.acknowledge();
		}
	}

	@KafkaListener(topics = "supplier2kitchen", groupId = "my-group")
	public void fromSupplier(String message, Acknowledgment acknowledgment) {
		try {
			log.info("Topic {} message {}", "supplier2kitchen", message);
			service.supplying(KitchenUtils.toMessage(message));
			log.info("supplier2kitchen done");
		} catch (Exception e) {
			log.info(e.getLocalizedMessage(), e);
		} finally {
			acknowledgment.acknowledge();
		}
	}
}
