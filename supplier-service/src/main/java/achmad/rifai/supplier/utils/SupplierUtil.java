package achmad.rifai.supplier.utils;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import achmad.rifai.supplier.dto.RedisSaver;
import achmad.rifai.supplier.dto.SupplyReq;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SupplierUtil {

	private SupplierUtil() {
		super();
	}

	public static RedisSaver toSaver(SupplyReq req) {
		return RedisSaver.builder()
				.id(UUID.randomUUID().toString())
				.redisLocal(Map.of("email", req.getEmail(), "items", req.getItems().stream()
						.filter(Objects::nonNull)
						.map(m -> Map.of("name", m.getName(), "category", m.getCategory(),
								"price", m.getPrice(), "quantity", m.getQuantity()))
						.toList()))
				.build();
	}

	public static void showError(Throwable e) {
		log.info(e.getLocalizedMessage(), e);
	}

}
