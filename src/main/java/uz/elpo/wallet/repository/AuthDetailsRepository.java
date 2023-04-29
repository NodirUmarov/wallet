package uz.elpo.wallet.repository;

import jakarta.persistence.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.elpo.wallet.model.entity.AuthDetails;

import java.util.Optional;

@Repository
public interface AuthDetailsRepository extends JpaRepository<AuthDetails, Long> {
    Optional<AuthDetails> findByUsername(String username);
}