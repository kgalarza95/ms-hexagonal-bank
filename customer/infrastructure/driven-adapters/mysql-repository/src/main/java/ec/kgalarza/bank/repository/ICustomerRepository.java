package ec.kgalarza.bank.repository;

import ec.kgalarza.bank.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByIdentification(String identification);
}
