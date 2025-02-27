package ec.kgalarza.bank;

import ec.kgalarza.bank.entity.Log;
import ec.kgalarza.bank.gateway.ILogRepositoryGateway;

public class SaveLogUseCase {

    private final ILogRepositoryGateway logRepositoryGateway;

    public SaveLogUseCase(ILogRepositoryGateway logRepositoryGateway) {
        this.logRepositoryGateway = logRepositoryGateway;
    }

    public Log execute(Log log) {
        return logRepositoryGateway.save(log);
    }
}

