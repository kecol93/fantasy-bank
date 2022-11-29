package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.common.type.CurrencyType;
import io.fantasy.bank.backend.rest.BaseUnitTest;
import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest()
@ContextConfiguration(classes = AccountController.class)
class AccountControllerTest extends BaseUnitTest {

    @MockBean
    private AccountService accountService;

    @Test
    public void shouldReturnNoContentStatus() throws Exception {
        //given
        doNothing().when(accountService).exchange(any(), any());
        MockHttpServletRequestBuilder mockHttp = post("/v1/account/exchange/12345678910")
                .content(jsonToString(getExchangeDTO()))
                .contentType(MediaType.APPLICATION_JSON);
        //when-then
        callApi(mockHttp, HttpStatus.NO_CONTENT);
    }

    public static ExchangeDTO getExchangeDTO() {
        return ExchangeDTO.builder()
                .amount(BigDecimal.valueOf(123))
                .fromCurrency(CurrencyType.PLN)
                .toCurrency(CurrencyType.USD)
                .build();
    }
}