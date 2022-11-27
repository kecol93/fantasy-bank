package io.fantasy.bank.backend.integration.service;

import io.fantasy.bank.backend.common.exception.FantasyException;
import io.fantasy.bank.backend.common.exception.type.FantasyErrorType;
import io.fantasy.bank.backend.integration.entity.User;
import io.fantasy.bank.backend.integration.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {
    UserRepository userRepository;

    public UserEntityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByPersonalNumber(String personalNumber) {
        return userRepository.findByPersonalNumber(personalNumber);
    }

    public void saveUser(User user) {
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new FantasyException(FantasyErrorType.FB_002);
        }
    }
}


