package uz.elpo.wallet.service.impl;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.elpo.wallet.mapper.dto.WalletMapper;
import uz.elpo.wallet.mapper.request.WalletCreateMapper;
import uz.elpo.wallet.model.dto.WalletDto;
import uz.elpo.wallet.model.entity.AuthDetails;
import uz.elpo.wallet.model.entity.Wallet;
import uz.elpo.wallet.model.request.WalletCreateRequest;
import uz.elpo.wallet.repository.AuthDetailsRepository;
import uz.elpo.wallet.repository.WalletRepository;
import uz.elpo.wallet.service.WalletService;


@Slf4j
@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final AuthDetailsRepository authDetailsRepository;
    private final WalletMapper walletMapper;
    private final WalletRepository walletRepository;
    private final WalletCreateMapper walletCreateMapper;

    @Override
    public WalletDto create(WalletCreateRequest request, String username) {
        log.info("Creating wallet... ");

        if (request.getName() == null) {
            throw  new RuntimeException("Wallet name is null");
        }

        if (request.getFunds().signum() < 0) {
            throw new RuntimeException("The funds cannot be negative");
        }

        AuthDetails authDetails = authDetailsRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("For username='" + username + "'"));

        Wallet wallet = walletCreateMapper.toEntity(request);
        wallet.setIsActive(true);
        wallet.setCreatedBy(authDetails);
        wallet.setLastModifiedBy(authDetails);
        wallet.setCreatedDate(LocalDateTime.now());
        wallet.setLastModifiedDate(LocalDateTime.now());
        walletRepository.save(wallet);
        return walletMapper.toDto(wallet);
    }

    @Override
    public WalletDto getOne(Long id) {
        log.info("Getting wallet... ");
        Wallet wallet = walletRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (!wallet.getIsActive()) {
            throw new EntityNotFoundException("Wallet is not active");
        }
        return walletMapper.toDto(wallet);
    }

    @Override
    public WalletDto delete(Long id) {
        log.info("Deleting wallet... ");
        Wallet wallet = walletRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (wallet.getFunds().signum() < 0) {
            throw new RuntimeException("Can not delete wallet with negative funds");
        }

        wallet.setIsActive(false);
        walletRepository.save(wallet);
        return walletMapper.toDto(wallet);
    }
}
