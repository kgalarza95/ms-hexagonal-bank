package ec.kgalarza.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String password;
    private boolean status;

    public CustomerEntity(String name, String gender, Integer age, String identification, String address, String phone, Long customerId, String password, boolean status) {
        super(name, gender, age, identification, address, phone);
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

}
