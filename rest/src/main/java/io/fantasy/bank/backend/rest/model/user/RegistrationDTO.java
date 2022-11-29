package io.fantasy.bank.backend.rest.model.user;

import io.fantasy.bank.backend.rest.validator.annotation.PersonalIdentityNumberValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class RegistrationDTO {
    @Schema(description = "First name", example = "Thomas")
    private String firstName;
    @Schema(description = "Last name", example = "Anderson")
    private String lastName;
    @PersonalIdentityNumberValidation()
    @Schema(description = "Personal number", example = "99061877218")
    private String personalNumber;
    @Schema(description = "Amount", example = "467.20")
    private BigDecimal amount;
}
