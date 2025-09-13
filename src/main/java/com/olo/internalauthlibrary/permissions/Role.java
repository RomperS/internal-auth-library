package com.olo.internalauthlibrary.permissions;

import com.olo.internalauthlibrary.exceptions.permissions.InvalidPermissionValueException;
import com.olo.internalauthlibrary.exceptions.permissions.TitleDefaultNotFoundException;


public enum Role {
    ADMIN,
    TEACHER,
    STUDENT,
    PARENT,
    SUPER_ADMIN,
    AUXILIARY_ADMIN,
    COUNSELOR;

    public static Role fromString(String role){
        try {
            return Role.valueOf(role);
        }catch (IllegalArgumentException e){
            throw new InvalidPermissionValueException("Invalid role value");
        }
    }

    public Title getDefaultTitle() {
        switch (this) {
            case TEACHER -> {
                return Title.TUTOR;
            }
            case STUDENT -> {
                return Title.PUPIL;
            }
            case PARENT -> {
                return Title.GUARDIAN;
            }
            case AUXILIARY_ADMIN -> {
                return Title.DIRECTORS_BOARD;
            }
            case COUNSELOR -> {
                return Title.SCHOOL_COUNSELOR;
            }
            default -> {
                throw new TitleDefaultNotFoundException("Role does not have a default title");
            }
        }
    }
}
