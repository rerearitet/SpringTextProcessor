package com.ithillel.persistence.entity;

public enum ClientType {

    ADMIN("*", true), USER("USER_ROLE", true), SYSTEM(null, false);

    private final String roles;
    private final boolean haveAccess;

    ClientType(String roles, boolean haveAccess) {
        this.roles = roles;
        this.haveAccess = haveAccess;
    }

    public String getRoles() {
        return roles;
    }

    public boolean isHaveAccess() {
        return haveAccess;
    }
}
