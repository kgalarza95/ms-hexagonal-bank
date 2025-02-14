package ec.kgalarza.bank.repository;

import ec.kgalarza.bank.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
    //Cliente findByClienteid(Long clienteid);
}
