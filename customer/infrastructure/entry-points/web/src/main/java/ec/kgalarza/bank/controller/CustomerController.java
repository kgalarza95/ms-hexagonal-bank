package ec.kgalarza.bank.controller;

import ec.kgalarza.bank.dto.CustomerInDTO;
import ec.kgalarza.bank.dto.CustomerOutDTO;
import ec.kgalarza.bank.handler.CustomerHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {

    CustomerHandler customerHandler;

    public CustomerController(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }

    @GetMapping
    public ResponseEntity<List<CustomerOutDTO>> findAll() {
        return new ResponseEntity<>(customerHandler.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOutDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(customerHandler.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerOutDTO> save(@Valid @RequestBody CustomerInDTO customerInDTO) {
        return new ResponseEntity<>(customerHandler.save(customerInDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerOutDTO> update(@Valid @RequestBody CustomerInDTO customerInDTO) {
        return new ResponseEntity<>(customerHandler.update(customerInDTO), HttpStatus.CREATED);
    }
}
