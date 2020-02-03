package com.telenor.demo.model;

import lombok.Getter;

@Getter
public enum AccountType {

    PERSONAL("personal"),
    BUSINESS("business");

    private String value;

    AccountType(String type) {
        this.value = type;
    }

}
