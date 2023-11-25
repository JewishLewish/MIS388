package mis.jewishlewish.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafeDemoApplication {

	public static void main(String[] args) {
		startup();
		SpringApplication.run(ThymeleafeDemoApplication.class, args);
	}

	public static void startup() {
		json.readJson();
		DataSQL.test();
	}

}
