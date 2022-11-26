package io.fantasy.bank.backend.integration.adapter;

import io.fantasy.bank.backend.integration.entity.User;
import io.fantasy.bank.backend.integration.mapper.UserMapper;
import io.fantasy.bank.backend.integration.service.UserEntityService;
import io.fantasy.bank.backend.rest.model.user.UserDTO;
import io.fantasy.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAdapterImpl implements UserServiceAdapter {

    private final UserEntityService userEntityService;
    private final UserMapper userMapper;

    public UserServiceAdapterImpl(UserEntityService userEntityService, UserMapper userMapper) {
        this.userEntityService = userEntityService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserByPersonalNumber(String personalNumber) {
        User user = userEntityService.findUserByPersonalNumber(personalNumber);
        return userMapper.mapUserToUserDTO(user);
    }
}
