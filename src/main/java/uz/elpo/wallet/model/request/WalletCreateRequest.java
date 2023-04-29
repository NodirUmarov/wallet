package uz.elpo.wallet.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletCreateRequest {

    @NotBlank
    private String name;

    @PositiveOrZero
    private BigDecimal funds;
}
