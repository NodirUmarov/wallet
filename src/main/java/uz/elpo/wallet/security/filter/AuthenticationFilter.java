package uz.elpo.wallet.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import uz.elpo.wallet.service.AuthDetailsService;

import java.io.IOException;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthDetailsService authDetailsService;

    private String secret;
    private Long duration;

    @Autowired
    public AuthenticationFilter(@Lazy AuthenticationManager authenticationManager, AuthDetailsService authDetailsService) {
        super(authenticationManager);
        this.authDetailsService = authDetailsService;
        this.setFilterProcessesUrl("api/login");
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        return super.getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        UserDetails details = (UserDetails) authResult.getPrincipal();

        Algorithm algorithm = Algorithm.HMAC256(secret);

        String generatedAccessToken = JWT.create()
                .withSubject(details.getUsername())
                .withIssuedAt(new Date())
                .withNotBefore(new Date())
                .withIssuer(request.getRequestURL().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + duration))
                .withClaim("authorities", details.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).toList())
                .withClaim("type_of_token", "access")
                .sign(algorithm);

        String refreshAccessToken = JWT.create()
                .withSubject(details.getUsername())
                .withIssuedAt(new Date())
                .withNotBefore(new Date(System.currentTimeMillis() + duration))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("authorities", details.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).toList())
                .withClaim("type_of_token", "refresh")
                .sign(algorithm);


        TokenResponse tokenResponse = TokenResponse
                .builder()
                .accessToken(generatedAccessToken)
                .refreshToken(refreshAccessToken)
                .build();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper()
                .writeValue(response.getOutputStream(), tokenResponse);

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
