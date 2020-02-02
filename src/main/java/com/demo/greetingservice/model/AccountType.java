package com.demo.greetingservice.model;

public enum AccountType {

    PERSONAL("personal"),
    BUSINESS("business");

    private String value;

    AccountType(String type) {
        this.value = type;
    }

    public String getValue() {
        return value;
    }
}
