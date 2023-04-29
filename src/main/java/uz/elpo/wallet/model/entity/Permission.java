package uz.elpo.wallet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@Table(name = "permissions")
@NoArgsConstructor
public class Permission extends AbstractPersistable<Long> {

    @Column(unique = true, nullable = false)
    private String authority;

    @Column(nullable = false)
    private Boolean isEnabled;

}
