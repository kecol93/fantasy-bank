package io.fantasy.bank.backend.rest.validator.annotation;

import io.fantasy.bank.backend.rest.validator.PersonalIdentityNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonalIdentityNumberValidator.class)
public @interface PersonalIdentityNumberValidation {
    String message() default "Invalid date of birth";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
