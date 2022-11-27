package io.fantasy.bank.backend.rest.model.user;

import io.fantasy.bank.backend.rest.validator.annotation.PersonalIdentityNumberValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    private String firstName;
    private String lastName;
    @PersonalIdentityNumberValidation()
    private String personalNumber;
    private BigDecimal amount;
}
