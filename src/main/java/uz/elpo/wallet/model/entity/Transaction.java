package uz.elpo.wallet.model.entity;

import jakarta.persistence.Entity;
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

    private Wallet withdrawFrom;
    private Wallet to;
    private BigDecimal amount;
    private String description;
}