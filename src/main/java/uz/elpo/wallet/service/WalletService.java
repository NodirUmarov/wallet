package uz.elpo.wallet.service;

import uz.elpo.wallet.model.dto.WalletDto;
import uz.elpo.wallet.model.request.WalletCreateRequest;

public interface WalletService {

    WalletDto create(WalletCreateRequest request);

    WalletDto getOne(Long id);

    WalletDto delete(Long id);
}
