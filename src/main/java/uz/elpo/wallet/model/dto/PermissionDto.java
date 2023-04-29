package uz.elpo.wallet.model.dto;

import java.io.Serializable;
import uz.elpo.wallet.model.entity.Permission;

/**
 * A DTO for the {@link Permission} entity
 */
public record PermissionDto(Long id,
                            String authority,
                            Boolean isEnabled) implements Serializable {
}