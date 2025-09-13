package com.olo.internalauthlibrary.exceptions.permissions;

import com.olo.internalauthlibrary.exceptions.PermissionException;

public class AssignmentNotAllowedException extends PermissionException {
    public AssignmentNotAllowedException(String message) {
        super(message);
    }
    public AssignmentNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }
}
