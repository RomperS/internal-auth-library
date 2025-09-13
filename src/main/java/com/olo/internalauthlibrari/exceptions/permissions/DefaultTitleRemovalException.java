package com.olo.internalauthlibrari.exceptions.permissions;

import com.olo.internalauthlibrari.exceptions.PermissionException;

public class DefaultTitleRemovalException extends PermissionException {
    public DefaultTitleRemovalException(String message) {
        super(message);
    }
    public DefaultTitleRemovalException(String message, Throwable cause) {
        super(message, cause);
    }
}
