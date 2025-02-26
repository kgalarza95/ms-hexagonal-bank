package com.kgalarza.bank.exception;

public class AccountAlreadyExistsException extends RuntimeException {
    public AccountAlreadyExistsException(String mensaje) {
        super(mensaje);
    }
}
