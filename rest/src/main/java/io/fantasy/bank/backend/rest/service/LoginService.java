package io.fantasy.bank.backend.rest.service;

import io.fantasy.bank.backend.rest.model.user.LoginDTO;
import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import io.fantasy.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserServiceAdapter userServiceAdapter;

    public LoginService(UserServiceAdapter userServiceAdapter) {
        this.userServiceAdapter = userServiceAdapter;
    }

    public void login() {

    }

    public void logout() {

    }

    public void registration(RegistrationDTO registrationDTO) {
        userServiceAdapter.saveUser(registrationDTO);
    }
}
