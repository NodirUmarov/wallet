package uz.elpo.wallet.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "user_details")
@NoArgsConstructor
public class User extends AbstractPersistable<Long> {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private String gender;

    @OneToMany
    @JoinColumn(name = "user_details_id", referencedColumnName = "id", nullable = false)
    private List<Wallet> wallet;

    @OneToOne
    @JoinColumn(name = "auth_details_id", referencedColumnName = "id")
    private AuthDetails authDetails;

    @Transient
    private String fullName;

    @PrePersist
    @PostLoad
    @Transient
    private void onLoadAndPersist() {
        fullName = firstName + " " + lastName + " " + patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(patronymic, user.patronymic) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(dob, user.dob) && Objects.equals(gender, user.gender) && Objects.equals(wallet, user.wallet) && Objects.equals(fullName, user.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, patronymic, phoneNumber, dob, gender, wallet, fullName);
    }
}
