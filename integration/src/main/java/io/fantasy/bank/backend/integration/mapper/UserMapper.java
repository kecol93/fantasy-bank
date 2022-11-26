package io.fantasy.bank.backend.integration.mapper;

import io.fantasy.bank.backend.common.CurrencyType;
import io.fantasy.bank.backend.integration.entity.Account;
import io.fantasy.bank.backend.integration.entity.User;
import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import io.fantasy.bank.backend.rest.model.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.Set;

@Mapper(imports = BigDecimal.class, uses = {AccountMapper.class})
public interface UserMapper {

    String CREATE_ACCOUNT = "CREATE_ACCOUNT";

    UserDTO mapUserToUserDTO(User user);

    @Mapping(source = "registrationDTO.amount", target = "accounts", qualifiedByName = CREATE_ACCOUNT)
    User mapRegistrationDTOtoUser(RegistrationDTO registrationDTO);

    @Named(CREATE_ACCOUNT)
    default Set<Account> createAccount(BigDecimal amount) {
        return Set.of(Account.builder().amount(amount).currency(CurrencyType.PLN).build());
    }
}
