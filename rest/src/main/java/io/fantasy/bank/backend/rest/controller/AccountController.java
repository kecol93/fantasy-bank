package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/exchange/{personalNumber}")
    public ResponseEntity<Void> exchange(@PathVariable String personalNumber, @RequestBody ExchangeDTO exchangeDTO) {
        accountService.exchange(personalNumber, exchangeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
