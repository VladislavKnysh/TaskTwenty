package com.company.second.exception;

public class RequestDenialException extends RuntimeException {
    public RequestDenialException(String s) {
        super(s);
    }
}
