package io.fantasy.bank.backend.integration.service;

import io.fantasy.bank.backend.integration.entity.User;
import io.fantasy.bank.backend.integration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserEntityService {
    UserRepository userRepository;

    public UserEntityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByPersonalNumber(String personalNumber) {
        return userRepository.findByPersonalNumber(personalNumber).get(0);
    }

    public void saveUser(User user, BigDecimal amount) {
        
    }
}


