package uz.elpo.wallet.service.impl;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.elpo.wallet.model.dto.AuthDetailsDto;
import uz.elpo.wallet.model.entity.AuthDetails;
import uz.elpo.wallet.repository.AuthDetailsRepository;
import uz.elpo.wallet.service.AuthDetailsService;

@Service
@RequiredArgsConstructor
public class AuthDetailsImpl implements AuthDetailsService {

    private final AuthDetailsRepository authDetailsRepository;

    @Override
    public AuthDetailsDto create(AuthDetailsDto authDetailsDto) {
        if (authDetailsRepository.existsByUsername(authDetailsDto.username())) {
            throw new EntityExistsException("For username='" + authDetailsDto.username() + "'");
        }

        AuthDetails authDetails = new AuthDetails();
        authDetails.setUsername(authDetailsDto.username());
        authDetails.setPassword(authDetailsDto.password());

        authDetailsRepository.save(authDetails);

        return AuthDetailsDto.builder()
                .id(authDetails.getId())
                .password(authDetails.getPassword())
                .username(authDetailsDto.username())
                .isAccountNonExpired(authDetails.getIsAccountNonExpired())
                .isAccountNonLocked(authDetails.getIsAccountNonLocked())
                .isCredentialsNonExpired(authDetails.getIsCredentialsNonExpired())
                .isEnabled(authDetails.getIsEnabled())
                .build();
    }
}
