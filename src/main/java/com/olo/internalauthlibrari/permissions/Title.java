package com.olo.internalauthlibrari.permissions;

import com.olo.internalauthlibrari.exceptions.permissions.InvalidPermissionValueException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Title {
    PRINCIPAL(Role.SUPER_ADMIN),

    SECRETARY(Role.ADMIN),
    LIBRARIAN(Role.ADMIN),
    COORDINATOR(Role.ADMIN),

    TUTOR(Role.TEACHER),
    HOMEROOM_TEACHER(Role.TEACHER),
    DEPARTMENT_HEAD(Role.TEACHER),

    PUPIL(Role.STUDENT),
    GROUP_REPRESENTATIVE(Role.STUDENT),
    COMPTROLLER(Role.STUDENT),
    STUDENT_REPRESENTATIVE(Role.STUDENT),

    GUARDIAN(Role.PARENT),
    PARENTS_BOARD(Role.PARENT),

    DIRECTORS_BOARD(Role.AUXILIARY_ADMIN),

    SCHOOL_COUNSELOR(Role.COUNSELOR),
    PSYCHOLOGIST(Role.COUNSELOR),
    SOCIAL_WORKER(Role.COUNSELOR);

    private final Role role;

    public static Title fromString(String title){
        try {
            return Title.valueOf(title);
        }catch (IllegalArgumentException e){
            throw new InvalidPermissionValueException("Invalid title value");
        }
    }
}