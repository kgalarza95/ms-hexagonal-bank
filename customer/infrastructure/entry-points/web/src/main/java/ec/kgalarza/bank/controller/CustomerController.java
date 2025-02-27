package ec.kgalarza.bank.controller;

import ec.kgalarza.bank.dto.CustomerInDTO;
import ec.kgalarza.bank.dto.CustomerOutDTO;
import ec.kgalarza.bank.dto.CustomerWithIdInDTO;
import ec.kgalarza.bank.handler.CustomerHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {

    private final CustomerHandler customerHandler;

    public CustomerController(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }

    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of customers"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<CustomerOutDTO>> findAll() {
        return new ResponseEntity<>(customerHandler.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get a customer by ID", description = "Retrieve customer information based on the customer ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved customer"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerOutDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(customerHandler.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Create a new customer", description = "Create a new customer using the provided customer details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<CustomerOutDTO> save(@Valid @RequestBody CustomerInDTO customerInDTO) {
        return new ResponseEntity<>(customerHandler.save(customerInDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing customer", description = "Update the details of an existing customer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated customer"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @PutMapping
    public ResponseEntity<CustomerOutDTO> update(@Valid @RequestBody CustomerWithIdInDTO customerInDTO) {
        return new ResponseEntity<>(customerHandler.update(customerInDTO), HttpStatus.OK);
    }
}
