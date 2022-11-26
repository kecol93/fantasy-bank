package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.model.user.LoginDTO;
import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.status(HttpStatus.OK).body("login");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("logout");

    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody RegistrationDTO registrationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body("registration");
    }


}
