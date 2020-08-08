package com.program.core.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.program.core.security.ApplicationUserPermissions.*;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSES_READ, COURSES_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<ApplicationUserPermissions> permission;

    ApplicationUserRoles(Set<ApplicationUserPermissions> permission) {
        this.permission = permission;
    }
}
