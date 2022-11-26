package io.fantasy.bank.backend.integration.mapper;

import io.fantasy.bank.backend.integration.entity.User;
import io.fantasy.bank.backend.rest.model.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTO mapUserToUserDTO(User user);
}
