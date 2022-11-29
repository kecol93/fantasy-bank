package io.fantasy.bank.backend.integration.mapper;

import io.fantasy.bank.backend.integration.entity.Account;
import io.fantasy.bank.backend.rest.model.account.AccountDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    AccountDTO mapAccountToAccountDTO(Account account);

}
