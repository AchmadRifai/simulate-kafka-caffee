package achmad.rifai.kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

@SpringBootApplication(exclude = RedisRepositoriesAutoConfiguration.class)
public class KitchenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitchenServiceApplication.class, args);
	}

}
