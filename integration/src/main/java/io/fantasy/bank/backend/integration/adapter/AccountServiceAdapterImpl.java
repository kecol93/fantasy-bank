package io.fantasy.bank.backend.integration.adapter;

import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.model.user.UserDTO;
import io.fantasy.bank.backend.rest.service.adapter.AccountServiceAdapter;
import io.fantasy.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceAdapterImpl implements AccountServiceAdapter {

    @Override
    public void exchange(String personalNumber, ExchangeDTO exchangeDTO) {

    }
}
