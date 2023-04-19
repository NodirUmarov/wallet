package uz.elpo.wallet.mapper.request;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.model.entity.Wallet;
import uz.elpo.wallet.model.request.WalletCreateRequest;

@Mapper(config = AppMapperConfig.class)
public interface WalletCreateMapper extends EntityMapper<Wallet, WalletCreateRequest> {

    @Override
    //@Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    //@Mapping(target = "lastModifiedBy", ignore = true)
    //@Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "transactions", ignore = true)

    Wallet toEntity(WalletCreateRequest request);
}
