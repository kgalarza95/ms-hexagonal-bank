package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Log;
import ec.kgalarza.bank.gateway.ILogBusMessageListenerGategway;
import ec.kgalarza.bank.usecase.SaveLogUseCase;
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
        System.out.println("llega el log: " + log);
        saveLogUseCase.execute(log);
    }

}
