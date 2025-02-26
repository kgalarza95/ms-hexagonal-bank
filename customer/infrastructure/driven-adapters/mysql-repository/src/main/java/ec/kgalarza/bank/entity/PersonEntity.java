package ec.kgalarza.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonEntity {

    @Column(nullable = false)
    private String name;
    private String gender;
    private Integer age;
    @Column(nullable = false, unique = true)
    private String identification;
    private String address;
    private String phone;

}
