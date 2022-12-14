package io.fantasy.bank.backend.integration.adapter;

import io.fantasy.bank.backend.integration.service.AccountEntityService;
import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.service.adapter.AccountServiceAdapter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceAdapterImpl implements AccountServiceAdapter {

    private final AccountEntityService accountEntityService;

    public AccountServiceAdapterImpl(AccountEntityService accountEntityService) {
        this.accountEntityService = accountEntityService;
    }

    @Override
    public void exchange(String personalNumber, ExchangeDTO exchangeDTO, BigDecimal exchangeRate) {
        accountEntityService.exchange(personalNumber, exchangeDTO.getAmount(), exchangeDTO.getFromCurrency(), exchangeDTO.getToCurrency(), exchangeRate);
    }
}
