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

}