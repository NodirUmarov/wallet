package uz.elpo.wallet.mapper.config;

import java.util.List;

public interface EntityMapper<T, S> {
    T toEntity(S dto);
    List<T> toEntityList(List<S> dtoList);
}