package ec.kgalarza.bank;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAutoConfiguration
@ComponentScan(
        basePackages = "ec.kgalarza.bank",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Test$")
        })
public class TestConfiguration {
}
