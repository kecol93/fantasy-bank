package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.common.type.CurrencyType;
import io.fantasy.bank.backend.rest.BaseUnitTest;
import io.fantasy.bank.backend.rest.model.account.AccountDTO;
import io.fantasy.bank.backend.rest.model.user.UserDTO;
import io.fantasy.bank.backend.rest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest()
@ContextConfiguration(classes = UserController.class)
class UserControllerTest extends BaseUnitTest {

    @MockBean
    private UserService userService;

    @Test
    public void shouldReturnUser() throws Exception {
        //given
        UserDTO expected = getUser();
        given(userService.getUser(any())).willReturn(expected);
        MockHttpServletRequestBuilder mockHttp = get("/v1/user/97043064379")
                .contentType(MediaType.APPLICATION_JSON);
        //when
        UserDTO actual = jsonToObject(callApi(mockHttp, HttpStatus.OK), UserDTO.class);
        //then
        assertEquals(expected, actual);

    }

    public static UserDTO getUser() {
        return UserDTO.builder()
                .firstName("John")
                .lastName("Wick")
                .personalNumber("97043064379")
                .accounts(List.of(AccountDTO.builder()
                        .amount(BigDecimal.valueOf(123))
                        .currency(CurrencyType.PLN)
                        .build())
                ).build();
    }
}