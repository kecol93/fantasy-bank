package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/exchange")
    public ResponseEntity<String> exchange(@RequestBody ExchangeDTO exchangeDTO) {
        accountService.exchange("12345678910", exchangeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("exchanged");

    }

}
