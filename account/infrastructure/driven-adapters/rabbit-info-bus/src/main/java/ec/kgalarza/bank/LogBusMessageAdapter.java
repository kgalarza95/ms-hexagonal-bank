package ec.kgalarza.bank;

import com.kgalarza.bank.entity.Log;
import com.kgalarza.bank.gateway.ILogBusMessageGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogBusMessageAdapter implements ILogBusMessageGateway {

    private final RabbitTemplate rabbitTemplate;

    @Value("${amqp.exchange.log}")
    private String exchange;

    @Value("${amqp.routing.key.log}")
    private String routingKey;


    public LogBusMessageAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(Log log) {
        rabbitTemplate.convertAndSend(exchange,
                routingKey,
                log);
    }
}
