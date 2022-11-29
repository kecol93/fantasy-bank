package io.fantasy.bank.backend.rest.service;

import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import io.fantasy.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @Mock
    private UserServiceAdapter adapter;

    @InjectMocks
    private RegistrationService registrationService;

    @Test
    public void shouldRegisterUser() {
        //given
        RegistrationDTO expected = getRegistrationDTO();
        ArgumentCaptor<RegistrationDTO> valueCapture = ArgumentCaptor.forClass(RegistrationDTO.class);
        doNothing().when(adapter).saveUser(valueCapture.capture());
        //when
        registrationService.registration(expected);
        RegistrationDTO actual = valueCapture.getValue();
        //then
        assertEquals(expected, actual);
    }

    public static RegistrationDTO getRegistrationDTO() {
        return RegistrationDTO.builder()
                .firstName("Thomas")
                .lastName("Anderson")
                .personalNumber("99061877218")
                .amount(BigDecimal.valueOf(467.20))
                .build();
    }
}