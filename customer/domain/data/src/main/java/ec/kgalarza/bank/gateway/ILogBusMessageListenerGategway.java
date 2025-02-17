package ec.kgalarza.bank.gateway;

import ec.kgalarza.bank.entity.Log;

public interface ILogBusMessageListenerGategway {
    void receiveMsg(Log log);
}
