package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.exception.model.FantasyError;
import io.fantasy.bank.backend.rest.model.user.RegistrationDTO;
import io.fantasy.bank.backend.rest.service.RegistrationService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "CREATED",
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
    @PostMapping("/registration")
    public ResponseEntity<Void> registration(@Parameter(required = true) @Valid @RequestBody RegistrationDTO registrationDTO) {
        registrationService.registration(registrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
