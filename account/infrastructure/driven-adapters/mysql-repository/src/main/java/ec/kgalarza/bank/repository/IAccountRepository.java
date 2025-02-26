package ec.kgalarza.bank.repository;

import ec.kgalarza.bank.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}
