package com.sunrise.sunriseapp.model;

public enum Roles {
    USER("USER"),
    VENDOR("VENDOR"),
    ADMIN("ADMIN");

    private final String role;

    Roles(String role) {
        this.role = role;
    }
}
