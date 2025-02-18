package ec.kgalarza.bank.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "ec.kgalarza.bank")
@EntityScan(basePackages = "ec.kgalarza.bank.entity")
public class TestConfiguration {
}
