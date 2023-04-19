package uz.elpo.wallet.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A DTO for the {@link uz.elpo.wallet.model.entity.Wallet} entity
 */
public record WalletDto(Long id,
                        Date createdDate,
                        Date lastModifiedDate,
                        String name,
                        BigDecimal funds) implements Serializable {
}