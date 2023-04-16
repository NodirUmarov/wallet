package uz.elpo.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.elpo.wallet.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
