package com.kgalarza.bank.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String mensaje) {
        super(mensaje);
    }
}
