package achmad.rifai.helper.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@Autowired
	HelperService service;

	@KafkaListener(topics = "kitchen2helper", groupId = "my-group")
	public void consume(String message, Acknowledgment acknowledgment) {
		try {
			log.info("Topic {} message {}", "kitchen2helper", message);
			service.helperConsuming(message).subscribe();
			log.info("kitchen2helper done");
		} catch (Exception e) {
			log.info(e.getLocalizedMessage(), e);
		} finally {
			acknowledgment.acknowledge();
		}
	}
}
