package achmad.rifai.cashier.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

@SpringBootApplication(exclude = RedisRepositoriesAutoConfiguration.class)
public class CashierServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashierServiceApplication.class, args);
	}

}
