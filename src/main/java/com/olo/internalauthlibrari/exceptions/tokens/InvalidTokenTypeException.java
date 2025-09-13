package com.olo.internalauthlibrari.exceptions.tokens;

import com.olo.internalauthlibrari.exceptions.PermissionException;

public class InvalidTokenTypeException extends PermissionException {
    public InvalidTokenTypeException(String message) {
        super(message);
    }

    public InvalidTokenTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
