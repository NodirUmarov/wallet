package uz.elpo.wallet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class CustomAuditable<PK extends Serializable> extends AbstractPersistable<PK> {

    @ManyToOne
    @JoinColumn(name = "created_by_id", referencedColumnName = "id", nullable = false)
    protected AuthDetails createdBy;

    @ManyToOne
    @JoinColumn(name = "last_modified_by_id", referencedColumnName = "id", nullable = false)
    protected AuthDetails lastModifiedBy;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(nullable = false)
    protected LocalDateTime lastModifiedDate;
//
//    @PrePersist
//    private void onCreate() {
//        createdBy = AuditUtils.getCurrentUser();
//        lastModifiedBy = AuditUtils.getCurrentUser();
//    }
//
//    @PreUpdate
//    private void onUpdate() {
//        lastModifiedBy = AuditUtils.getCurrentUser();
//    }

}