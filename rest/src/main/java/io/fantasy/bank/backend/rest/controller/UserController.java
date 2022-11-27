package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.model.user.UserDTO;
import io.fantasy.bank.backend.rest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{personalNumber}")
    public ResponseEntity<UserDTO> user(@PathVariable String personalNumber) {
        UserDTO userDTO = userService.getUser(personalNumber);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

}
