package com.olo.internalauthlibrari.exceptions.permissions;

import com.olo.internalauthlibrari.exceptions.PermissionException;

public class InvalidPermissionValueException extends PermissionException {
    public InvalidPermissionValueException(String message) {
        super(message);
    }
    public InvalidPermissionValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
