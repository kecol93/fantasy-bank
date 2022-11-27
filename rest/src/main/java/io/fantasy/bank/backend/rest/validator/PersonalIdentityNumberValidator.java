package io.fantasy.bank.backend.rest.validator;

import io.fantasy.bank.backend.rest.validator.annotation.PersonalIdentityNumberValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DateTimeException;
import java.time.LocalDate;

public class PersonalIdentityNumberValidator implements ConstraintValidator<PersonalIdentityNumberValidation, String> {

    public boolean isValid(String personalIdentityNumber, ConstraintValidatorContext cxt) {
        if (personalIdentityNumber.length() != 11) {
            return false;
        }

        return isAdult(personalIdentityNumber);
    }

    private boolean isAdult(String personalIdentityNumber) {
        byte[] pin = new byte[11];
        for (int i = 0; i < 11; i++) {
            pin[i] = Byte.parseByte(personalIdentityNumber.substring(i, i + 1));
        }
        int year = pin[2] > 1 ? 2000 + 10 * pin[0] + pin[1] : 1900 + 10 * pin[0] + pin[1];
        int month = pin[2] > 1 ? 10 * pin[2] + pin[3] - 20 : 10 * pin[2] + pin[3];
        int day = 10 * pin[4] + pin[5];
        try {
            LocalDate dateOfBirth = LocalDate.of(year, month, day);
            LocalDate adultDate = LocalDate.now().minusYears(18);

            return dateOfBirth.isBefore(adultDate) || dateOfBirth.isEqual(adultDate);
        } catch (DateTimeException e) {
            return false;
        }

    }
}
