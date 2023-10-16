package com.jewishlewish.mis388;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;


@SpringBootApplication
public class Mis388Application extends WebMvcAutoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(Mis388Application.class, args);
	}


}
