package com.ben.quiz.domain.common.exception;

public class QuizException extends Exception {

    private static final long serialVersionUID = 458294886819840685L;
    private final int errorCode;

    public QuizException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public QuizException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
