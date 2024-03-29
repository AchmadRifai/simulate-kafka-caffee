package achmad.rifai.cashier.service.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.reactive.config.EnableWebFlux;

import achmad.rifai.cashier.service.dto.RedisSaver;

@Configuration
@EnableKafka
@EnableReactiveElasticsearchRepositories(basePackages = "achmad.rifai.cashier.service.repositories")
@EnableWebFlux
public class CashierConfig extends ReactiveElasticsearchConfiguration {

	@Value("${achmad.rifai.es.url}")
	private String elasticUrl;

	@Bean
    ReactiveRedisTemplate<String, RedisSaver> redisTemplate(ReactiveRedisConnectionFactory factory) {
        final var serializer = new Jackson2JsonRedisSerializer<>(RedisSaver.class);
        final RedisSerializationContext.RedisSerializationContextBuilder<String, RedisSaver> context =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        return new ReactiveRedisTemplate<>(factory, context.value(serializer).build());
    }

	@Override
	public ClientConfiguration clientConfiguration() {
		return ClientConfiguration.builder()
				.connectedTo(elasticUrl)
				.build();
	}

}
