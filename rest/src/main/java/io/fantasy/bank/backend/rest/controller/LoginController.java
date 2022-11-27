package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.model.user.LoginDTO;
import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import io.fantasy.bank.backend.rest.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        loginService.login();
        return ResponseEntity.status(HttpStatus.OK).body("login");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("logout");

    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationDTO registrationDTO) {
        loginService.registration(registrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("registration");
    }


}
