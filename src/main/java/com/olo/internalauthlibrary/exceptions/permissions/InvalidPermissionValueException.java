package com.olo.internalauthlibrary.exceptions.permissions;

import com.olo.internalauthlibrary.exceptions.PermissionException;

public class InvalidPermissionValueException extends PermissionException {
    public InvalidPermissionValueException(String message) {
        super(message);
    }
    public InvalidPermissionValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
