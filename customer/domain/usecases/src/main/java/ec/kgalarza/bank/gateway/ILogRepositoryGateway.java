package ec.kgalarza.bank.gateway;

import ec.kgalarza.bank.entity.Log;

public interface ILogRepositoryGateway {
    Log save(Log log);
}
