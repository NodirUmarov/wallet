package uz.elpo.wallet.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@Table(name = "auth_details")
@NoArgsConstructor
public class AuthDetails extends AbstractPersistable<Long> {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean isEnabled;

    @Column(nullable = false)
    private Boolean isAccountNonLocked;

    @Column(nullable = false)
    private Boolean isAccountNonExpired;

    @Column(nullable = false)
    private Boolean isCredentialsNonExpired;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id", referencedColumnName = "id", nullable = false)
    private User user;

    @PrePersist
    private void onCreate() {
        isEnabled = true;
        isAccountNonExpired = true;
        isAccountNonLocked = true;
        isCredentialsNonExpired = true;
    }
}