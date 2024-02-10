package achmad.rifai.waitres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumeService {

	@Autowired
	WaitresService service;

	@KafkaListener(topics = "kitchen2waitres", groupId = "my-group")
	public void consume(String message, Acknowledgment acknowledgment) {
		try {
			log.info("Topic {} message {}", "kitchen2waitres", message);
			service.sendEmail(message).subscribe();
			log.info("kitchen2waitres done");
		} catch (Exception e) {
			log.info(e.getLocalizedMessage(), e);
		} finally {
			acknowledgment.acknowledge();
		}
	}
}
