package dev.sorn.fmp4j.http;

import static java.lang.String.format;

import dev.sorn.fmp4j.exceptions.FmpException;

public class FmpHttpException extends FmpException {
    public FmpHttpException(String message, Object... args) {
        super(message, args);
    }

    public FmpHttpException(Throwable t, String message, Object... args) {
        super(format(message, args), t);
    }
}
