package achmad.rifai.waitres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

@SpringBootApplication(exclude = RedisRepositoriesAutoConfiguration.class)
public class WaitresServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaitresServiceApplication.class, args);
	}

}
