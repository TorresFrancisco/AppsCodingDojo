package com.francisco.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}
	@RequestMapping("/")
	public String hello() {
		return "Hello World";
	}
	@RequestMapping("/random")
	public String otra() {
		return "Spring boot is great! So easy to just respond whit string";
	}
	

}
