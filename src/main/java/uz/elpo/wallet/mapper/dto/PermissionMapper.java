package uz.elpo.wallet.mapper.dto;

import org.mapstruct.Mapper;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.DtoMapper;
import uz.elpo.wallet.model.dto.PermissionDto;
import uz.elpo.wallet.model.entity.Permission;

@Mapper(config = AppMapperConfig.class)
public interface PermissionMapper extends DtoMapper<PermissionDto, Permission> {
}