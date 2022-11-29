package io.fantasy.bank.backend.rest.provider.exchangerate.config;

import io.fantasy.bank.backend.common.type.CurrencyType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Configuration
@ConfigurationProperties(prefix = "api.exchange-rate")
@Getter
@Setter
public class ExchangeRateConfig {

    private String host;
    private String path;
    private MultiValueMap<String, String> queryParameters;

    private CurrencyType mainCurrency;

    public URI buildUrl(String content) {
        return UriComponentsBuilder.fromHttpUrl(host)
                .path(path)
                .path(content)
                .queryParams(queryParameters)
                .build()
                .toUri();
    }
}
