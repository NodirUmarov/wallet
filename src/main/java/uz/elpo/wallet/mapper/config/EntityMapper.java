package uz.elpo.wallet.mapper.config;

public interface EntityMapper<T, S> {
    T toEntity(S dto);
}
