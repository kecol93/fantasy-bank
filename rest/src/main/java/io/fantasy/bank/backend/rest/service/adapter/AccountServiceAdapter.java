package io.fantasy.bank.backend.rest.service.adapter;

import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.model.user.UserDTO;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountServiceAdapter {

    void exchange(String personalNumber, ExchangeDTO exchangeDTO, BigDecimal exchangeRate);
}
