package uz.elpo.wallet.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import uz.elpo.wallet.mapper.request.WalletCreateMapper;
import uz.elpo.wallet.model.dto.WalletDto;
import uz.elpo.wallet.model.entity.Wallet;
import uz.elpo.wallet.model.request.WalletCreateRequest;
import uz.elpo.wallet.repository.WalletRepository;
import uz.elpo.wallet.service.WalletService;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletCreateMapper walletCreateMapper;
    private final WalletDto walletDto;

    @Modifying
    @Override
    public WalletDto create(WalletCreateRequest request) {
        log.info("Creating wallet... ");
        Wallet wallet = walletCreateMapper.toEntity(request);


        return null;
    }
}
