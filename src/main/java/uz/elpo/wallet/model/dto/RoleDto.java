package uz.elpo.wallet.model.dto;

import java.io.Serializable;
import java.util.List;
import uz.elpo.wallet.model.entity.Role;

/**
 * A DTO for the {@link Role} entity
 */
public record RoleDto(Long id,
                      String name,
                      List<PermissionDto> permissions) implements Serializable {
}