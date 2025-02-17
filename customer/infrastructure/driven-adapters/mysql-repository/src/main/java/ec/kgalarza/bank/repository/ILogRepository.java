package ec.kgalarza.bank.repository;

import ec.kgalarza.bank.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogRepository extends JpaRepository<LogEntity, Long> {
}
