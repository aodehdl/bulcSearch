package bulc.search.kr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BulcSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BulcSearchApplication.class, args);
	}
}
