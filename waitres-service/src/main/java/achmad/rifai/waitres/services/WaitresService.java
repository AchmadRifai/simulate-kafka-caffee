package achmad.rifai.waitres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import achmad.rifai.waitres.dto.KafkaMessage;
import achmad.rifai.waitres.dto.RedisSaver;
import achmad.rifai.waitres.utils.WaitresUtil;
import lombok.SneakyThrows;
import reactor.core.publisher.Mono;

@Service
public class WaitresService {

	@Autowired
	ReactiveRedisTemplate<String, RedisSaver> redisTemplate;
	@Autowired
	Environment env;
	@Autowired
	JavaMailSender sender;

	public Mono<Boolean> sendEmail(String message) {
		return Mono.just(message)
				.map(WaitresUtil::toMessage)
				.map(KafkaMessage::getId)
				.flatMap(redisTemplate.opsForValue()::getAndDelete)
				.map(this::sendingEmail)
				.doOnError(WaitresUtil::showError);
	}

	@SneakyThrows
	private Boolean sendingEmail(RedisSaver v) {
		final var message = new SimpleMailMessage();
		message.setFrom(env.getProperty("spring.mail.username"));
		message.setSubject(v.getId());
		message.setTo(String.valueOf(v.getRedisLocal().get("email")));
		message.setText(String.valueOf(v.getRedisLocal().get("message")));
		sender.send(message);
		return true;
	}
}
