package uz.elpo.wallet.mapper.dto;

import org.mapstruct.Mapper;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.DtoMapper;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.model.dto.WalletDto;
import uz.elpo.wallet.model.entity.Wallet;

@Mapper(config = AppMapperConfig.class)
public interface WalletMapper extends DtoMapper<WalletDto, Wallet>, EntityMapper<Wallet, WalletDto> {
}
