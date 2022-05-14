package io.slimmens.entregafinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;


@Component
@EnableJpaAuditing
@SpringBootApplication
public class EntragaFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntragaFinalApplication.class, args);
	}

}
