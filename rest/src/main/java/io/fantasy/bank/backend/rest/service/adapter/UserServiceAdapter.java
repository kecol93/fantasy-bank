package io.fantasy.bank.backend.rest.service.adapter;

import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import io.fantasy.bank.backend.rest.model.user.UserDTO;

public interface UserServiceAdapter {

    UserDTO getUserByPersonalNumber(String personalNumber);

    void saveUser(RegistrationDTO registrationDTO);
}
