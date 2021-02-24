package com.company.first.exception;

public class ReportFailException extends RuntimeException {
    public ReportFailException(String s) {
        super(s);
    }
}
