package ec.kgalarza.bank.mapper;

import ec.kgalarza.bank.dto.CustomerInDTO;
import ec.kgalarza.bank.dto.CustomerOutDTO;
import ec.kgalarza.bank.entity.Customer;

public class CustomerMapper {

    public static Customer toDomain(CustomerInDTO customerInDTO) {
        if (customerInDTO == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setCustomerId(customerInDTO.getCustomerId());
        customer.setPassword(customerInDTO.getPassword());
        customer.setStatus(customerInDTO.isStatus());
        customer.setName(customerInDTO.getName());
        customer.setGender(customerInDTO.getGender());
        customer.setAge(customerInDTO.getAge());
        customer.setIdentification(customerInDTO.getIdentification());
        customer.setAddress(customerInDTO.getAddress());
        customer.setPhone(customerInDTO.getPhone());

        return customer;
    }

    public static CustomerOutDTO toOutDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerOutDTO customerOutDTO = new CustomerOutDTO();
        customerOutDTO.setCustomerId(customer.getCustomerId());
        customerOutDTO.setPassword(customer.getPassword());
        customerOutDTO.setStatus(customer.isStatus());
        customerOutDTO.setName(customer.getName());
        customerOutDTO.setGender(customer.getGender());
        customerOutDTO.setAge(customer.getAge());
        customerOutDTO.setIdentification(customer.getIdentification());
        customerOutDTO.setAddress(customer.getAddress());
        customerOutDTO.setPhone(customer.getPhone());

        return customerOutDTO;
    }
}
