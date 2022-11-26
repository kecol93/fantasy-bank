package io.fantasy.bank.backend.rest.service.adapter;

import io.fantasy.bank.backend.rest.model.user.LoginDTO;
import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import io.fantasy.bank.backend.rest.model.user.UserDTO;

import java.util.Optional;

public interface UserServiceAdapter {

    UserDTO getUserByPersonalNumber(String personalNumber);

    void saveUser(RegistrationDTO registrationDTO);
}
