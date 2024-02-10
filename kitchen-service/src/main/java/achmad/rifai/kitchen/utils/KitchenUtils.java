package achmad.rifai.kitchen.utils;

import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import achmad.rifai.kitchen.dto.KafkaMessage;
import achmad.rifai.kitchen.dto.RedisSaver;
import achmad.rifai.kitchen.models.Category;
import achmad.rifai.kitchen.models.Menu;
import lombok.SneakyThrows;

public class KitchenUtils {

	private KitchenUtils() {
		super();
	}

	@SneakyThrows
	public static KafkaMessage toMessage(String message) {
		return new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.readValue(message, KafkaMessage.class);
	}

	public static RedisSaver toSaver(Menu menu) {
		return RedisSaver.builder()
				.id("menu")
				.redisLocal(toMap(menu))
				.build();
	}

	private static Map<String, Object> toMap(Menu menu) {
		return Map.of("id", menu.getId().toString(), "category", menu.getCategory().getName(),
				"price", menu.getPrice().doubleValue(), "stock", menu.getStock(),
				"name", menu.getName());
	}

	public static RedisSaver toSaver(Category category) {
		return RedisSaver.builder()
				.id("category")
				.redisLocal(Map.of("id", category.getId().toString(), "name", category.getName(),
						"menus", category.getMenus().stream().map(KitchenUtils::toMap).toList()))
				.build();
	}

	public static RedisSaver toSaver(String message, String email) {
		return RedisSaver.builder()
				.id("error")
				.redisLocal(Map.of("message", message, "email", email))
				.build();
	}

	public static RedisSaver toSaver2(String message, String email) {
		return RedisSaver.builder()
				.id("Pesanan Siap Dikirim")
				.redisLocal(Map.of("message", message, "email", email))
				.build();
	}
}
