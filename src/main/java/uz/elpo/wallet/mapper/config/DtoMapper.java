package uz.elpo.wallet.mapper.config;

public interface DtoMapper <T, S> {

    T toDto(S entity);
}
