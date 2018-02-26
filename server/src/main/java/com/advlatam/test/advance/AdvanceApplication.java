package com.advlatam.test.advance;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UsuarioRepository repository) {
		return args -> {};
	}
}
