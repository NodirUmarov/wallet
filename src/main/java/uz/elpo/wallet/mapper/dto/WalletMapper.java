package uz.elpo.wallet.mapper.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.DtoMapper;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.model.dto.WalletDto;
import uz.elpo.wallet.model.entity.AuthDetails;
import uz.elpo.wallet.model.entity.Wallet;

@Mapper(config = AppMapperConfig.class)
public interface WalletMapper extends DtoMapper<WalletDto, Wallet>, EntityMapper<Wallet, WalletDto> {

    @Override
    @Mapping(target = "transactions", ignore = true)
    Wallet toEntity(WalletDto dto);

    default LocalDateTime toLocalDateTime(Optional<LocalDateTime> optionalDate) {
        return optionalDate.orElseThrow(NullPointerException::new);
    }

    default AuthDetails toAuthDetails(Optional<AuthDetails> optionalAuthDetails) {
        return optionalAuthDetails.orElseThrow(NullPointerException::new);
    }

}