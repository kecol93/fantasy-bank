package io.fantasy.bank.backend.integration.service;

import io.fantasy.bank.backend.common.CurrencyType;
import io.fantasy.bank.backend.integration.entity.Account;
import io.fantasy.bank.backend.integration.entity.User;
import io.fantasy.bank.backend.integration.repository.AccountRepository;
import io.fantasy.bank.backend.integration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountEntityService {
    private AccountRepository accountRepository;
    private UserRepository userRepository;

    public AccountEntityService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void exchange(String personalNumber, BigDecimal amount, CurrencyType fromCurrencyAccount, CurrencyType toCurrencyAccount) {
        User user = userRepository.findByPersonalNumber(personalNumber).get(0);
        Account fromAccount = getAccountByCurrency(user.getAccounts(), fromCurrencyAccount).orElseThrow(RuntimeException::new);
        Account toAccount = getAccountByCurrency(user.getAccounts(), toCurrencyAccount).orElse(Account.builder().amount(BigDecimal.valueOf(0)).currency(toCurrencyAccount).user(user).build());

        doExchange(fromAccount, toAccount, amount);
    }

    private Optional<Account> getAccountByCurrency(Set<Account> accounts, CurrencyType currencyType) {
        return accounts.stream().filter(a -> currencyType.equals(a.getCurrency())).findFirst();
    }

    private void doExchange(Account fromAccount, Account toAccount, BigDecimal amount) {
        BigDecimal fromAccountAmount = fromAccount.getAmount().subtract(amount);
        BigDecimal toAccountAmount = toAccount.getAmount().add(amount);
        fromAccount.setAmount(fromAccountAmount);
        toAccount.setAmount(toAccountAmount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
