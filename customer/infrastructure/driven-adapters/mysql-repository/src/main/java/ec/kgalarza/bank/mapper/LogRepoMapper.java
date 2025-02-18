package ec.kgalarza.bank.mapper;

import ec.kgalarza.bank.entity.Log;
import ec.kgalarza.bank.entity.LogEntity;

public class LogRepoMapper {

    public static Log toDomain(LogEntity logEntity) {
        if (logEntity == null) {
            return null;
        }
        Log log = new Log();
        log.setMessage(logEntity.getMessage());
        log.setDateTime(logEntity.getDateTime());
        return log;
    }

    public static LogEntity toEntity(Log log) {
        if (log == null) {
            return null;
        }
        LogEntity logEntity = new LogEntity();
        logEntity.setMessage(log.getMessage());
        logEntity.setDateTime(log.getDateTime());
        return logEntity;
    }
}
