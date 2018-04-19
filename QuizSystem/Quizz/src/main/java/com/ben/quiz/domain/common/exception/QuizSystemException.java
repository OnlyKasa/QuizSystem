package com.ben.quiz.domain.common.exception;

/**
 * Quiz system exception
 *
 */
public class QuizSystemException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QuizSystemException() {
		super();
	}

	public QuizSystemException(String message) {
		super(message);
	}

	public QuizSystemException(Throwable cause) {
		super(cause);
	}

	public QuizSystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
