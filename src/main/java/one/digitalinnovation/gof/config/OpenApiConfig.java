package one.digitalinnovation.gof.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customApiConfig(){
        return new OpenAPI().
                info(new Info().
                        title("DIO Project").
                        version("v1").
                        description("Project from DIO").
                        termsOfService("https://www.linkedin.com/in/iveschiba/").
                        license(new License().
                                name("DIO").
                                url("https://www.linkedin.com/in/iveschiba/")));

    }
}
