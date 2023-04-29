package uz.elpo.wallet.mapper.dto;

import org.mapstruct.Mapper;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.DtoMapper;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.mapper.dto.AuthDetailsMapper;
import uz.elpo.wallet.mapper.dto.WalletMapper;
import uz.elpo.wallet.model.dto.UserDto;
import uz.elpo.wallet.model.entity.AuthDetails;
import uz.elpo.wallet.model.entity.User;

@Mapper(config = AppMapperConfig.class, uses = {AuthDetailsMapper.class, WalletMapper.class})
public interface UserMapper extends EntityMapper<User, UserDto>, DtoMapper<UserDto, User> {

}