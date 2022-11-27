package io.fantasy.bank.backend.common.exception;

import io.fantasy.bank.backend.common.exception.type.FantasyErrorType;
import lombok.Getter;

@Getter
public class FantasyException extends RuntimeException {

    private FantasyErrorType fantasyErrorType;

    public FantasyException(FantasyErrorType fantasyErrorType) {
        super(fantasyErrorType.getValue());
        this.fantasyErrorType = fantasyErrorType;
    }
}
