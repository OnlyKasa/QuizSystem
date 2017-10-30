package com.ben.quiz.domain.common.exception;

import com.ben.quiz.domain.common.constant.Constant;

import javax.servlet.ServletException;

public class ErrorException extends ServletException {
    private static final long serialVersionUID = 1L;

    private String status;

    public ErrorException() {
    }

    public static ErrorException permissionDenied() {
        return new ErrorException(Constant.ctrlStatus.ERR_PERMISSION_DENIED, "Permission denied");
    }

    public ErrorException(String message) {
        super(message);
        this.status = Constant.ctrlStatus.ERR_EXCEPTION;
    }

    public ErrorException(String status, String message) {
        super(message);
        this.status = status;
    }

    public ErrorException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public ErrorException(Throwable rootCause) {
        super(rootCause);
    }

    public Throwable getRootCause() {
        return this.getCause();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

