package io.fantasy.bank.backend.rest.service;

import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import io.fantasy.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserServiceAdapter userServiceAdapter;


    public RegistrationService(UserServiceAdapter userServiceAdapter) {
        this.userServiceAdapter = userServiceAdapter;
    }

    public void registration(RegistrationDTO registrationDTO) {
        userServiceAdapter.saveUser(registrationDTO);
    }

}
