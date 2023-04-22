package uz.elpo.wallet.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "transactions")
@NoArgsConstructor
public class Transaction extends AbstractAuditable<AuthDetails, Long> {

    @ManyToOne
    @JoinColumn(name = "withdraw_wallet_id", referencedColumnName = "id")
    private Wallet withdrawFrom;

    @ManyToOne
    @JoinColumn(name = "to_wallet_id", referencedColumnName = "id")
    private Wallet to;

    private BigDecimal amount;
    private String description;
}