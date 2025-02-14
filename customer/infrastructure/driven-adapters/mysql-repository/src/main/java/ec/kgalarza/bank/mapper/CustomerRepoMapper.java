package ec.kgalarza.bank.mapper;

import ec.kgalarza.bank.entity.Customer;
import ec.kgalarza.bank.entity.CustomerEntity;

public class CustomerRepoMapper {

    public static Customer toDomain(CustomerEntity client) {
        if (client == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setCustomerId(client.getCustomerId());
        customer.setPassword(client.getPassword());
        customer.setStatus(client.isStatus());
        customer.setName(client.getName());
        customer.setGender(client.getGender());
        customer.setAge(client.getAge());
        customer.setIdentification(client.getIdentification());
        customer.setAddress(client.getAddress());
        customer.setPhone(client.getPhone());
        return customer;
    }

    public static CustomerEntity toEntity(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customer.getCustomerId());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setStatus(customer.isStatus());
        customerEntity.setName(customer.getName());
        customerEntity.setGender(customer.getGender());
        customerEntity.setAge(customer.getAge());
        customerEntity.setIdentification(customer.getIdentification());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPhone(customer.getPhone());


        return customerEntity;
    }
}
