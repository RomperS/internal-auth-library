package com.olo.internalauthlibrary.exceptions.permissions;

import com.olo.internalauthlibrary.exceptions.PermissionException;

public class DefaultTitleRemovalException extends PermissionException {
    public DefaultTitleRemovalException(String message) {
        super(message);
    }
    public DefaultTitleRemovalException(String message, Throwable cause) {
        super(message, cause);
    }
}
