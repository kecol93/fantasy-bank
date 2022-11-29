package io.fantasy.bank.backend.rest.service;

import io.fantasy.bank.backend.common.type.CurrencyType;
import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.provider.exchangerate.ExchangeRateService;
import io.fantasy.bank.backend.rest.service.adapter.AccountServiceAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountServiceAdapter adapter;

    @Mock
    private ExchangeRateService exchangeRateService;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void shouldExchangeCurrency() {
        //given
        BigDecimal expected = BigDecimal.valueOf(4.4440);
        given(exchangeRateService.getExchangeRate(any(), any())).willReturn(expected);
        ArgumentCaptor<BigDecimal> valueCapture = ArgumentCaptor.forClass(BigDecimal.class);
        doNothing().when(adapter).exchange(any(), any(), valueCapture.capture());
        //when
        accountService.exchange("97043064379", getExchangeDTO());
        BigDecimal actual = valueCapture.getValue();
        //then
        assertEquals(expected, actual);
        //then
    }

    public static ExchangeDTO getExchangeDTO() {
        return ExchangeDTO.builder()
                .amount(BigDecimal.valueOf(123))
                .fromCurrency(CurrencyType.PLN)
                .toCurrency(CurrencyType.USD)
                .build();
    }
}