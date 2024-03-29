package achmad.rifai.waitres.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import achmad.rifai.waitres.dto.KafkaMessage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitresUtil {

	private WaitresUtil() {
		super();
	}

	public static void showError(Throwable e) {
		log.info(e.getLocalizedMessage(), e);
	}

	@SneakyThrows
	public static KafkaMessage toMessage(String message) {
		return new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.readValue(message, KafkaMessage.class);
	}

}
