package io.fantasy.bank.backend.rest.service;

import io.fantasy.bank.backend.common.type.CurrencyType;
import io.fantasy.bank.backend.rest.model.account.AccountDTO;
import io.fantasy.bank.backend.rest.model.user.UserDTO;
import io.fantasy.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserServiceAdapter adapter;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnUser() {
        //given
        UserDTO expected = getUser();
        given(adapter.getUserByPersonalNumber(any())).willReturn(expected);
        //when
        UserDTO actual = userService.getUser("97043064379");
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