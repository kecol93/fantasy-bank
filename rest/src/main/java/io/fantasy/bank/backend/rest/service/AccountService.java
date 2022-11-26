package io.fantasy.bank.backend.rest.service;

import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.model.user.UserDTO;
import io.fantasy.bank.backend.rest.service.adapter.AccountServiceAdapter;
import io.fantasy.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountServiceAdapter accountServiceAdapter;

    public AccountService(AccountServiceAdapter accountServiceAdapter) {
        this.accountServiceAdapter = accountServiceAdapter;
    }

    public void exchange(String personalNumber, ExchangeDTO exchangeDTO) {
        try {
            accountServiceAdapter.exchange(personalNumber, exchangeDTO);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
