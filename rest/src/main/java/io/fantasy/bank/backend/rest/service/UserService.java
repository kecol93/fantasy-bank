package io.fantasy.bank.backend.rest.service;

import io.fantasy.bank.backend.rest.model.user.UserDTO;
import io.fantasy.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserServiceAdapter userServiceAdapter;

    public UserService(UserServiceAdapter userServiceAdapter) {
        this.userServiceAdapter = userServiceAdapter;
    }

    public UserDTO getUser(String personalNumber) {
       return userServiceAdapter.getUserByPersonalNumber(personalNumber);
    }

}
