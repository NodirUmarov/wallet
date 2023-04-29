package uz.elpo.wallet.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link uz.elpo.wallet.model.entity.Wallet} entity
 */
public record WalletDto(Long id,
                        String name,
                        BigDecimal funds,
                        Boolean isActive,
                        List<TransactionDto> transactions,
                        @JsonIgnore AuthDetailsDto createdBy,
                        @JsonIgnore AuthDetailsDto lastModifiedBy,
                        @JsonIgnore LocalDateTime createdDate,
                        @JsonIgnore LocalDateTime lastModifiedDate) implements Serializable {
}