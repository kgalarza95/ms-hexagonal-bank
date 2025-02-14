package ec.kgalarza.bank.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( basePackages = "com.kgalarza.bank",
includeFilters = {
        @ComponentScan.Filter(type= FilterType.REGEX, pattern = "^.+UseCase$")
})
public class UseCaseConfig {
}
