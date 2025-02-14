package com.kgalarza.bank.exception;

public class GeneralAccountValidationException extends RuntimeException {
    public GeneralAccountValidationException(String mensaje) {
        super(mensaje);
    }
}
