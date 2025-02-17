package ec.kgalarza.bank.usecase;

import ec.kgalarza.bank.entity.Log;
import ec.kgalarza.bank.gateway.ILogRepositoryGateway;

public class SaveLogUseCase {

    ILogRepositoryGateway iLogRepositoryGateway;

    public SaveLogUseCase(ILogRepositoryGateway iLogRepositoryGateway) {
        this.iLogRepositoryGateway = iLogRepositoryGateway;
    }

    public Log execute(Log log) {
        return iLogRepositoryGateway.save(log);
    }
}
