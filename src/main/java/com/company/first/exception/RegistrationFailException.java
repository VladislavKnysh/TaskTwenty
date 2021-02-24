package com.company.first.exception;

public class RegistrationFailException extends RuntimeException {
    public RegistrationFailException(String s) {
        super(s);
    }
}
