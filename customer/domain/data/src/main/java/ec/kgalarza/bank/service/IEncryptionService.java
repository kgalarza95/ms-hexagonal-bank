package ec.kgalarza.bank.service;

public interface IEncryptionService {
    String encrypt(String password);
    boolean matches(String rawPassword, String encryptedPassword);
}
