package io.fantasy.bank.backend.rest.service.adapter;

import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;

import java.math.BigDecimal;

public interface AccountServiceAdapter {

    void exchange(String personalNumber, ExchangeDTO exchangeDTO, BigDecimal exchangeRate);
}
