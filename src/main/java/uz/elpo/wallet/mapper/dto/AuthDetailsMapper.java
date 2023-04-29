package uz.elpo.wallet.mapper.dto;

import org.mapstruct.Mapper;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.DtoMapper;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.model.dto.AuthDetailsDto;
import uz.elpo.wallet.model.entity.AuthDetails;

@Mapper(config = AppMapperConfig.class)
public interface AuthDetailsMapper extends EntityMapper<AuthDetails, AuthDetailsDto>, DtoMapper<AuthDetailsDto, AuthDetails> {
}