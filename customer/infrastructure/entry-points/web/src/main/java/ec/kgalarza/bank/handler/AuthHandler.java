package ec.kgalarza.bank.handler;

import ec.kgalarza.bank.dto.AuthRequestDTO;
import ec.kgalarza.bank.dto.AuthResponseDTO;
import ec.kgalarza.bank.jwt.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthHandler {

    @Value("${app.security.user}")
    private String username;

    @Value("${app.security.password}")
    private String encodedPassword;

    @Value("${app.security.roles}")
    private String roles;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthHandler(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        if (!request.username().equals(username) || !new BCryptPasswordEncoder().matches(request.password(), encodedPassword)) {
            throw new RuntimeException("Invalid credentials");
        }

        UserDetails user = User.withUsername(username)
                .password(encodedPassword)
                .roles(roles)
                .build();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, request.password()));

        String jwtToken = jwtService.generateToken(user);
        return new AuthResponseDTO(jwtToken);
    }
}
