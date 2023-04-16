package uz.elpo.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elpo.wallet.model.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
