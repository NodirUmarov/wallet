package uz.elpo.wallet.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.Builder;

@Builder
public record AuthDetailsDto(Long id,
                             @Email String username,
                             @JsonIgnore String password,
                             @JsonIgnore Boolean isEnabled,
                             @JsonIgnore Boolean isAccountNonLocked,
                             @JsonIgnore Boolean isAccountNonExpired,
                             @JsonIgnore Boolean isCredentialsNonExpired) {
}