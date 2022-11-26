package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @PostMapping("/exchange")
    public ResponseEntity<String> exchange(@RequestBody ExchangeDTO exchangeDTO) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("logout");

    }

}
