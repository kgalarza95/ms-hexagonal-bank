package ec.kgalarza.bank.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtExceptionHandlingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException ex) {
            handleJwtException(response, ex, "JWT token has expired.", HttpServletResponse.SC_UNAUTHORIZED);
        } catch (MalformedJwtException ex) {
            handleJwtException(response, ex, "Malformed JWT token.", HttpServletResponse.SC_BAD_REQUEST);
        } catch (SignatureException ex) {
            handleJwtException(response, ex, "JWT signature does not match.", HttpServletResponse.SC_UNAUTHORIZED);
        } catch (Exception ex) {
            handleJwtException(response, ex, "Invalid JWT.", HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private void handleJwtException(HttpServletResponse response, Exception ex, String message, int statusCode)
            throws IOException {
        response.setStatus(statusCode);
        response.setContentType("application/json");
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", statusCode);
        responseBody.put("message", message);
        responseBody.put("details", ex.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(responseBody));
        response.getWriter().flush();
    }
}
