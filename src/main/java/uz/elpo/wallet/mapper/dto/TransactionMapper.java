package uz.elpo.wallet.mapper.dto;

import org.mapstruct.Mapper;
import uz.elpo.wallet.mapper.config.AppMapperConfig;
import uz.elpo.wallet.mapper.config.DtoMapper;
import uz.elpo.wallet.mapper.config.EntityMapper;
import uz.elpo.wallet.model.dto.TransactionDto;
import uz.elpo.wallet.model.entity.Transaction;

@Mapper(config = AppMapperConfig.class, uses = {WalletMapper.class, AuthDetailsMapper.class})
public interface TransactionMapper extends EntityMapper<Transaction, TransactionDto>, DtoMapper<TransactionDto, Transaction> {
}