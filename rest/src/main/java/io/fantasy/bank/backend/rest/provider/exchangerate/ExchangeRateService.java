package io.fantasy.bank.backend.rest.provider.exchangerate;

import io.fantasy.bank.backend.common.CurrencyType;
import io.fantasy.bank.backend.rest.provider.exchangerate.config.ExchangeRateConfig;
import io.fantasy.bank.backend.rest.provider.exchangerate.model.ExchangeRateDTO;
import io.fantasy.bank.backend.rest.provider.exchangerate.model.ExchangeRateDTO.Rate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeRateService {

    private final ExchangeRateConfig exchangeRateConfig;
    private final RestTemplate restTemplate = new RestTemplate();

    public ExchangeRateService(ExchangeRateConfig exchangeRateConfig) {
        this.exchangeRateConfig = exchangeRateConfig;
    }

    public BigDecimal getExchangeRate(CurrencyType from, CurrencyType to){
        if(exchangeRateConfig.getMainCurrency().equals(from) && exchangeRateConfig.getMainCurrency().equals(to) == false) {
            return new BigDecimal(1).divide(getExchangeRate(to).getBid(), 2, RoundingMode.HALF_EVEN);
        }

        if(exchangeRateConfig.getMainCurrency().equals(to) && exchangeRateConfig.getMainCurrency().equals(from) == false) {
            return getExchangeRate(from).getAsk();
        }

        throw new RuntimeException();
    }

    private Rate getExchangeRate(CurrencyType currencyType) {

        ExchangeRateDTO exchangeRateDTO = restTemplate.getForObject(exchangeRateConfig.buildUrl(currencyType.toString()), ExchangeRateDTO.class);

        if(exchangeRateDTO == null || exchangeRateDTO.getRates() == null || exchangeRateDTO.getRates().isEmpty()) {
            throw new RuntimeException();
        }

        return exchangeRateDTO.getRates().stream().findFirst().orElseThrow(RuntimeException::new);

    }
}
