package uz.elpo.wallet.model.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link uz.elpo.wallet.model.entity.AuthDetails} entity
 */
public record AuthDetailsDto(Long id,
                             String username,
                             String password,
                             Boolean isEnabled,
                             Boolean isAccountNonLocked,
                             Boolean isAccountNonExpired,
                             Boolean isCredentialsNonExpired,
                             RoleDto role) implements Serializable {
}