package com.example.studyTime.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    User,
    Teacher,
    Admin;

    @Override
    public String getAuthority() {
        return name();
    }
}
