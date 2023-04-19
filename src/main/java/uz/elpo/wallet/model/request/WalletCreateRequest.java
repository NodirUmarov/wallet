package uz.elpo.wallet.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletCreateRequest {

    private String name;
    private BigDecimal funds;
}
