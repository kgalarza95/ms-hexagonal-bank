package ec.kgalarza.bank;

import ec.kgalarza.bank.service.IEncryptionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptEncryptionAdapter implements IEncryptionService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encrypt(String password) {
        return passwordEncoder.encode(password);
    }

}
