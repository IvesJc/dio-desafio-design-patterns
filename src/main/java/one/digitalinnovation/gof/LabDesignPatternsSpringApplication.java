package one.digitalinnovation.gof;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// HABILITAR o FEIGN NO PROJETO
@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition
public class LabDesignPatternsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabDesignPatternsSpringApplication.class, args);
	}

}
