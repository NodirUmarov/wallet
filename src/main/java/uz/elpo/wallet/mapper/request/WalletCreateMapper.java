package uz.elpo.wallet.mapper.request;

import org.mapstruct.Mapper;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.model.entity.Wallet;
import uz.elpo.wallet.model.request.WalletCreateRequest;

@Mapper(config = AppMapperConfig.class)
public interface WalletCreateMapper extends EntityMapper<Wallet, WalletCreateRequest> {
    Wallet toEntity(WalletCreateRequest request);
}
