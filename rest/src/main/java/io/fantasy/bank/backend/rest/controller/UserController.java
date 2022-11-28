package io.fantasy.bank.backend.rest.controller;

import io.fantasy.bank.backend.rest.exception.model.FantasyError;
import io.fantasy.bank.backend.rest.model.user.UserDTO;
import io.fantasy.bank.backend.rest.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}
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
    @GetMapping("/{personalNumber}")
    public ResponseEntity<UserDTO> user(@Parameter(example = "97043064379", required = true) @PathVariable String personalNumber) {
        UserDTO userDTO = userService.getUser(personalNumber);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

}
