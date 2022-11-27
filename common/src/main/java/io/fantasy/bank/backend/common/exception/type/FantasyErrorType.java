package io.fantasy.bank.backend.common.exception.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum FantasyErrorType {

    FB_001("FB_001", "Invalid field", HttpStatus.BAD_REQUEST),
    FB_002("FB_002", "Cannot create record", HttpStatus.BAD_REQUEST),
    FB_499("FB_499", "Wrong data", HttpStatus.BAD_REQUEST),
    FB_597("FB_597", "API return unexpected object", HttpStatus.INTERNAL_SERVER_ERROR),
    FB_598("FB_598", "Object is null or empty", HttpStatus.INTERNAL_SERVER_ERROR),
    FB_599("FB_599", "Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String value;
    private final String description;
    private final HttpStatus status;

}
