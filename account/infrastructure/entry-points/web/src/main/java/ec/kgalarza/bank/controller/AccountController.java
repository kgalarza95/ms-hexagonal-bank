package ec.kgalarza.bank.controller;

import ec.kgalarza.bank.dto.AccountInDTO;
import ec.kgalarza.bank.dto.AccountOutDTO;
import ec.kgalarza.bank.handler.AccountHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/account")
public class AccountController {

    private final AccountHandler accountHandler;

    public AccountController(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    @GetMapping
    public ResponseEntity<List<AccountOutDTO>> findAll() {
        return ResponseEntity.ok(accountHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountOutDTO> findById(@PathVariable Long id) {
        AccountOutDTO account = accountHandler.findById(id);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AccountOutDTO> save(@RequestBody AccountInDTO accountInDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountHandler.save(accountInDTO));
    }
}
