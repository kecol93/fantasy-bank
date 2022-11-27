package io.fantasy.bank.backend.rest.exception.utility;

import io.fantasy.bank.backend.common.exception.type.FantasyErrorType;
import io.fantasy.bank.backend.rest.exception.model.FantasyError;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Helper {

    private static final String PATTERN_FORMAT = "dd-MM-yyyy HH:mm:SS";

    public static String formatTime(Instant time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withLocale(Locale.getDefault())
                .withZone(ZoneId.systemDefault());
        return formatter.format(time);
    }

    public static FantasyError mapToFantasyError(FantasyErrorType fantasyErrorType, WebRequest request) {
        ServletWebRequest webRequest = (ServletWebRequest) request;

        return FantasyError.builder()
                .code(fantasyErrorType.getValue())
                .path(webRequest.getRequest().getRequestURI())
                .method(webRequest.getHttpMethod())
                .status(fantasyErrorType.getStatus())
                .time(formatTime(Instant.now()))
                .build();
    }
}
