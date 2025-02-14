package ec.kgalarza.bank.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${amqp.exchange.default}")
    public String EXCHANGE_NAME;
    @Value("${amqp.queue.default}")
    public String QUEUE_NAME;
    @Value("${amqp.routing.key.default}")
    public String ROUTING_KEY;

    @Value("${amqp.exchange.customer}")
    private String EXCHANGE_CUSTOMER;
    @Value("${amqp.queue.customer}")
    private String QUEUE_CUSTOMER;
    @Value("${amqp.routing.key.customer}")
    private String ROUTINGKEY_CUSTOMER;


    @Bean(name = "defaultExchange")
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean(name = "defaultQueue")
    public Queue defaultQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Binding defaultBinding(@Qualifier("defaultQueue") Queue queue, @Qualifier("defaultExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean(name = "customerExchange")
    public DirectExchange customerExchange() {
        return new DirectExchange(EXCHANGE_CUSTOMER);
    }

    @Bean(name = "customerQueue")
    public Queue customerQueue() {
        return new Queue(QUEUE_CUSTOMER, true);
    }

    @Bean
    public Binding customerBinding(@Qualifier("customerQueue") Queue queue, @Qualifier("customerExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_CUSTOMER);
    }

}
