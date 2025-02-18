package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Log;
import ec.kgalarza.bank.gateway.ILogBusMessageListenerGategway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class LogBusMessageListenerGategway implements ILogBusMessageListenerGategway {

    private final SaveLogUseCase saveLogUseCase;

    public LogBusMessageListenerGategway(SaveLogUseCase saveLogUseCase) {
        this.saveLogUseCase = saveLogUseCase;
    }

    @Override
    @RabbitListener(queues = "${amqp.queue.log}")
    public void receiveMsg(Log log) {
        saveLogUseCase.execute(log);
    }

}
