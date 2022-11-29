package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.exception.model.FantasyError;
import io.fantasy.bank.backend.rest.model.account.ExchangeDTO;
import io.fantasy.bank.backend.rest.service.AccountService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204", description = "NO_CONTENT",
                    content = {@Content(schema = @Schema())}
            ),
            @ApiResponse(
                    responseCode = "400", description = "BAD_REQUEST",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FantasyError.class))}
            ),
            @ApiResponse(
                    responseCode = "500", description = "INTERNAL_SERVER_ERROR",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FantasyError.class))}
            )
    })
    @PostMapping("/exchange/{personalNumber}")
    public ResponseEntity<Void> exchange(@Parameter(example = "97043064379", required = true) @PathVariable String personalNumber, @Parameter(required = true) @RequestBody ExchangeDTO exchangeDTO) {
        accountService.exchange(personalNumber, exchangeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
