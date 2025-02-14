package ec.kgalarza.bank.repository;

import ec.kgalarza.bank.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {

//    Optional<AccountEntity> findByNumeroCuenta(String numeroCuenta);
//    boolean existsByNumeroCuenta(String numeroCuenta);
}
