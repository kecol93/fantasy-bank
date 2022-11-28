package io.fantasy.bank.backend.app;

import io.fantasy.bank.backend.app.config.YamlPropertySourceFactory;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"io.fantasy.bank"})
@EntityScan("io.fantasy.bank.backend.integration.entity")
@EnableJpaRepositories("io.fantasy.bank.backend.integration.repository")
@PropertySources({
        @PropertySource(value = "classpath:integration.yaml", factory = YamlPropertySourceFactory.class),
        @PropertySource(value = "classpath:rest.yaml", factory = YamlPropertySourceFactory.class)
})
@OpenAPIDefinition(info = @Info(title = "Fantasy-Bank API", version = "0.1", description = "Fantasy-Bank Information"))
public class Application {

    private static final String SPRING_CONFIG_NAME = "spring.config.name";
    private static final String APPLICATION_NAME = "fantasy";

    public static void main(String[] args) {
        System.setProperty(SPRING_CONFIG_NAME, APPLICATION_NAME);
        SpringApplication.run(Application.class, args);
    }
}