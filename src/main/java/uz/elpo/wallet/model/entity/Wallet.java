package uz.elpo.wallet.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractAuditable;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "wallets")
@NoArgsConstructor
public class Wallet extends AbstractAuditable<AuthDetails, Long> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal funds;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wallet_has_transaction",
            joinColumns = @JoinColumn(name = "wallet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "id"))
    private List<Transaction> transactions;

}