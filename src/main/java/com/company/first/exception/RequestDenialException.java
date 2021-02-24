package com.company.first.exception;

public class RequestDenialException extends RuntimeException {
    public RequestDenialException(String s) {
        super(s);
    }
}
