package com.kgalarza.bank.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String mensaje) {
        super(mensaje);
    }
}
