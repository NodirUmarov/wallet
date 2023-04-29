package uz.elpo.wallet.mapper.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.DtoMapper;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.model.dto.RoleDto;
import uz.elpo.wallet.model.entity.Role;

@Mapper(config = AppMapperConfig.class, uses = {PermissionMapper.class})
public interface RoleMapper extends DtoMapper<RoleDto, Role>, EntityMapper<Role, RoleDto> {
    Role toEntity(RoleDto roleDto);

}