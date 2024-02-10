package achmad.rifai.kitchen.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import achmad.rifai.kitchen.dto.KafkaMessage;
import achmad.rifai.kitchen.dto.RedisSaver;
import achmad.rifai.kitchen.models.Category;
import achmad.rifai.kitchen.models.Menu;
import achmad.rifai.kitchen.utils.KitchenUtils;

@Service
public class ProducerService {

	@Autowired
	KafkaTemplate<String, KafkaMessage> template;
	@Autowired
	ReactiveRedisTemplate<String, RedisSaver> template2;

	public void sendToHelper(Menu menu) {
		final var id = UUID.randomUUID();
		final var topic = "kitchen2helper";
		template2.opsForValue()
			.set(id.toString(), KitchenUtils.toSaver(menu))
			.map(b -> KafkaMessage.builder().id(id.toString()).build())
			.map(m -> template.send(topic, m))
			.subscribe();
	}

	public void sendToHelper2(Category category) {
		final var id = UUID.randomUUID();
		final var topic = "kitchen2helper";
		template2.opsForValue()
			.set(id.toString(), KitchenUtils.toSaver(category))
			.map(b -> KafkaMessage.builder().id(id.toString()).build())
			.map(m -> template.send(topic, m))
			.subscribe();
	}

	public void sendToWaitres(String message, String email) {
		final var id = UUID.randomUUID();
		final var topic = "kitchen2waitres";
		template2.opsForValue()
			.set(id.toString(), KitchenUtils.toSaver(message, email))
			.map(b -> KafkaMessage.builder().id(id.toString()).build())
			.map(m -> template.send(topic, m))
			.subscribe();
	}

	public void sendToWaitres2(String message, String email) {
		final var id = UUID.randomUUID();
		final var topic = "kitchen2waitres";
		template2.opsForValue()
			.set(id.toString(), KitchenUtils.toSaver2(message, email))
			.map(b -> KafkaMessage.builder().id(id.toString()).build())
			.map(m -> template.send(topic, m))
			.subscribe();
	}

}
