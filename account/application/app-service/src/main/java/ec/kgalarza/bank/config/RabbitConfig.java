package ec.kgalarza.bank.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${amqp.exchange.log}")
    public String EXCHANGE_NAME;
    @Value("${amqp.queue.log}")
    public String QUEUE_NAME;
    @Value("${amqp.routing.key.log}")
    public String ROUTING_KEY;

    @Bean(name = "logExchange")
    public DirectExchange logExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean(name = "logQueue")
    public Queue logQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Binding defaultBinding(@Qualifier("logQueue") Queue queue, @Qualifier("logExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}
