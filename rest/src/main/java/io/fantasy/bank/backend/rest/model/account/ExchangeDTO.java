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
public class ExchangeDTO {
    @Schema(description = "Amount", example = "19.97")
    private BigDecimal amount;
    @Schema(description = "From account currency", example = "PLN")
    private CurrencyType fromCurrency;
    @Schema(description = "To account currency", example = "USD")
    private CurrencyType toCurrency;
}
