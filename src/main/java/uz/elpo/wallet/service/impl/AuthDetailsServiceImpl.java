package uz.elpo.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.elpo.wallet.model.entity.AuthDetails;
import uz.elpo.wallet.repository.AuthDetailsRepository;
import uz.elpo.wallet.service.AuthDetailsService;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthDetailsServiceImpl implements AuthDetailsService {

    private final AuthDetailsRepository authDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthDetails authDetails = authDetailsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("For username='" + username + "'"));

        return authDetails;
    }
}
