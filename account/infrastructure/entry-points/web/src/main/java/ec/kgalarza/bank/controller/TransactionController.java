package ec.kgalarza.bank.controller;

import ec.kgalarza.bank.dto.TransactionInDTO;
import ec.kgalarza.bank.dto.TransactionOutDTO;
import ec.kgalarza.bank.handler.TransactionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/transaction")
public class TransactionController {
    private final TransactionHandler transactionHandler;

    public TransactionController(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }

    @GetMapping
    public ResponseEntity<List<TransactionOutDTO>> findAll() {
        return ResponseEntity.ok(transactionHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionOutDTO> findById(@PathVariable Long id) {
        TransactionOutDTO transaction = transactionHandler.findById(id);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TransactionOutDTO> save(@RequestBody TransactionInDTO transactionInDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionHandler.save(transactionInDTO));
    }
}
