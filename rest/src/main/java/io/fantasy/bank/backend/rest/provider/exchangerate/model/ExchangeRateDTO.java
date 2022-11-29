package io.fantasy.bank.backend.rest.provider.exchangerate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ExchangeRateDTO {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @EqualsAndHashCode
    public static class Rate {
        private String no;
        private String effectiveDate;
        private BigDecimal bid;
        private BigDecimal ask;
    }
}
