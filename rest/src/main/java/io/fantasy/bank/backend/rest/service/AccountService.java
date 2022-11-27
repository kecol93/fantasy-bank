package io.fantasy.bank.backend.rest.service;

import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.provider.exchangerate.ExchangeRateService;
import io.fantasy.bank.backend.rest.service.adapter.AccountServiceAdapter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountServiceAdapter accountServiceAdapter;

    private final ExchangeRateService exchangeRateService;

    public AccountService(AccountServiceAdapter accountServiceAdapter, ExchangeRateService exchangeRateService) {
        this.accountServiceAdapter = accountServiceAdapter;
        this.exchangeRateService = exchangeRateService;
    }

    public void exchange(String personalNumber, ExchangeDTO exchangeDTO) {
        try {
            BigDecimal exchangeRate = exchangeRateService.getExchangeRate(exchangeDTO.getFromCurrency(), exchangeDTO.getToCurrency());
            accountServiceAdapter.exchange(personalNumber, exchangeDTO, exchangeRate);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
