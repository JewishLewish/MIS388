package mis.jewishlewish.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafeDemoApplication {

	public static void main(String[] args) {
		json.readJson();
		SpringApplication.run(ThymeleafeDemoApplication.class, args);
	}

}
