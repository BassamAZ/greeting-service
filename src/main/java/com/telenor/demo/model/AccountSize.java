package com.telenor.demo.model;

import lombok.Getter;

@Getter
public enum AccountSize {

    BIG("big"),
    SMALL("small");

    private String value;

    AccountSize(String type) {
        this.value = type;
    }

}
