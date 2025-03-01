package ec.kgalarza.bank.adapter;

import ec.kgalarza.bank.entity.Log;
import ec.kgalarza.bank.gateway.ILogRepositoryGateway;
import ec.kgalarza.bank.mapper.ILogRepoMapper;
import ec.kgalarza.bank.repository.ILogRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LogAdapter implements ILogRepositoryGateway {

    private final ILogRepository logRepository;
    private final ILogRepoMapper logRepoMapper;

    public LogAdapter(ILogRepository logRepository, ILogRepoMapper logRepoMapper) {
        this.logRepository = logRepository;
        this.logRepoMapper = logRepoMapper;
    }

    @Override
    public Log save(Log log) {
        return Optional.of(log)
                .map(logRepoMapper::toEntity)
                .map(logRepository::save)
                .map(logRepoMapper::toDomain)
                .orElseThrow(null);
    }
}
