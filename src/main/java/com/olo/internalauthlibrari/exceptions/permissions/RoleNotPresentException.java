package com.olo.internalauthlibrari.exceptions.permissions;

import com.olo.internalauthlibrari.exceptions.PermissionException;

public class RoleNotPresentException extends PermissionException {
    public RoleNotPresentException(String message) {
        super(message);
    }
    public RoleNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
