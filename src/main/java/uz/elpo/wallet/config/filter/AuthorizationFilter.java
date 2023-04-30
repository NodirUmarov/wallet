package uz.elpo.wallet.config.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.elpo.wallet.exception.BadTokenException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    private String secret;

    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestPath = request.getServletPath();
        String requestMethod = request.getMethod();

        if (requestPath.equals("/api/login") && requestMethod.equals("POST")) {
            filterChain.doFilter(request, response);
        } else {
            String token = request.getHeader("Authorization"); // Bearer
            if (token != null && !token.trim().isEmpty() && token.startsWith("Bearer ")) {
                token = token.substring("Bearer ".length());

                Algorithm algorithm = Algorithm.HMAC256(secret);

                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);

                String tokenType = decodedJWT.getClaim("type_of_token").asString();
                if (tokenType.equals("refresh") && !requestPath.equals("/api/refresh")) {
                    throw new BadTokenException("RefreshToken can be used only to generate new tokens");
                }

                List<? extends GrantedAuthority> authorities = decodedJWT.getClaim("authorities")
                        .asList(SimpleGrantedAuthority.class);

                String username = decodedJWT.getSubject();

                var usernameToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(usernameToken);

                filterChain.doFilter(request, response);
            }
        }
    }
}