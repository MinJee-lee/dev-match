package com.example.demo.common.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCd {

    WRONG_PASSWORD("wrong.password"),
    NOT_FOUND_USER("user.not.found")
    ;

    private final String messageKey;

}
