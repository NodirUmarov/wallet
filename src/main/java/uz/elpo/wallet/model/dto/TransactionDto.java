package uz.elpo.wallet.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * A DTO for the {@link uz.elpo.wallet.model.entity.Transaction} entity
 */
public record TransactionDto(Long id,
                             AuthDetailsDto createdBy,
                             LocalDateTime createdDate,
                             AuthDetailsDto lastModifiedBy,
                             LocalDateTime lastModifiedDate,
                             WalletDto withdrawFrom,
                             WalletDto to,
                             BigDecimal amount,
                             String description) implements Serializable {
}