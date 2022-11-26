package io.fantasy.bank.backend.rest.model.account;

import io.fantasy.bank.backend.common.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private BigDecimal amount;
    private CurrencyType currency;
}
