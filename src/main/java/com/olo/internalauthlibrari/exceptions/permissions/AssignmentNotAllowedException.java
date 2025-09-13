package com.olo.internalauthlibrari.exceptions.permissions;

import com.olo.internalauthlibrari.exceptions.PermissionException;

public class AssignmentNotAllowedException extends PermissionException {
    public AssignmentNotAllowedException(String message) {
        super(message);
    }
    public AssignmentNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }
}
