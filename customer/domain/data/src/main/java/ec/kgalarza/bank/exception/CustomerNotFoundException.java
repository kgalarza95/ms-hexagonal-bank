package ec.kgalarza.bank.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String mensaje) {
        super(mensaje);
    }
}
