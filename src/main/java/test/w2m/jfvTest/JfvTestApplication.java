package test.w2m.jfvTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JfvTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JfvTestApplication.class, args);
	}

}
