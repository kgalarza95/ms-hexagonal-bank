package ec.kgalarza.bank.adapter;

import ec.kgalarza.bank.entity.Log;
import ec.kgalarza.bank.gateway.ILogRepositoryGateway;
import ec.kgalarza.bank.mapper.LogRepoMapper;
import ec.kgalarza.bank.repository.ILogRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LogAdapter implements ILogRepositoryGateway {

    private final ILogRepository logRepository;

    public LogAdapter(ILogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Log save(Log log) {
        return Optional.of(log)
                .map(LogRepoMapper::toEntity)
                .map(logRepository::save)
                .map(LogRepoMapper::toDomain)
                .orElseThrow(null);
    }
}
