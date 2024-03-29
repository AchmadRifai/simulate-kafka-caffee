package achmad.rifai.supplier.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.reactive.config.EnableWebFlux;

import achmad.rifai.supplier.dto.RedisSaver;

@Configuration
@EnableKafka
@EnableWebFlux
public class SupplierConfig {

	@Bean
    ReactiveRedisTemplate<String, RedisSaver> redisTemplate(ReactiveRedisConnectionFactory factory) {
        final var serializer = new Jackson2JsonRedisSerializer<>(RedisSaver.class);
        final RedisSerializationContext.RedisSerializationContextBuilder<String, RedisSaver> context =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        return new ReactiveRedisTemplate<>(factory, context.value(serializer).build());
    }
}
