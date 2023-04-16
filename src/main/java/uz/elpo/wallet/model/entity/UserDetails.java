package uz.elpo.wallet.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user_details")
@NoArgsConstructor
public class UserDetails {

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

    @Transient
    private String fullName;

    @PrePersist
    @PostLoad
    @Transient
    private void onLoadAndPersist() {
        fullName = firstName + " " + lastName + " " + patronymic;
    }

}
