package uz.elpo.wallet.mapper.request;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.model.entity.AuthDetails;
import uz.elpo.wallet.model.entity.Wallet;
import uz.elpo.wallet.model.request.WalletCreateRequest;

@Mapper(config = AppMapperConfig.class)
public interface WalletCreateMapper extends EntityMapper<Wallet, WalletCreateRequest> {

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "transactions", ignore = true)
    Wallet toEntity(WalletCreateRequest request);

}
