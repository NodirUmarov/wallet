package uz.elpo.wallet.model.entity;

import jakarta.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class CustomAuditable<U, PK extends Serializable> extends AbstractAuditable<U, PK> {

    @PrePersist
    private void onCreate() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        setCreatedDate(LocalDateTime.now());
        setLastModifiedDate(LocalDateTime.now());
    }

}
