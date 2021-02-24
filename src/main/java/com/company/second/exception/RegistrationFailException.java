package com.company.second.exception;

public class RegistrationFailException extends RuntimeException {
    public RegistrationFailException(String s) {
        super(s);
    }
}
