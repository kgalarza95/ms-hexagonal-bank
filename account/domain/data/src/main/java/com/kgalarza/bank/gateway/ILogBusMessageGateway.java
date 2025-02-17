package com.kgalarza.bank.gateway;

import com.kgalarza.bank.entity.Log;

public interface ILogBusMessageGateway {
    void sendMessage(Log log);
}
