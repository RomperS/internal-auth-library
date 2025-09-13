package com.olo.internalauthlibrary.exceptions.permissions;

import com.olo.internalauthlibrary.exceptions.PermissionException;

public class TitleDefaultNotFoundException extends PermissionException {
    public TitleDefaultNotFoundException(String message) {
        super(message);
    }
    public TitleDefaultNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
