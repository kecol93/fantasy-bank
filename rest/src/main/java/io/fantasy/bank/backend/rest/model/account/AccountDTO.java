package io.fantasy.bank.backend.rest.model.account;

import io.fantasy.bank.backend.common.type.CurrencyType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AccountDTO {
    @Schema(description = "Amount", example = "123.00")
    private BigDecimal amount;
    @Schema(description = "Currency", example = "PLN")
    private CurrencyType currency;
}
