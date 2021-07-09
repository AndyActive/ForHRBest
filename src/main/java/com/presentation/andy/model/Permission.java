package com.presentation.andy.model;

public enum Permission {
    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write"),
    DEVELOPERS_SUPER("developers:redact");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
