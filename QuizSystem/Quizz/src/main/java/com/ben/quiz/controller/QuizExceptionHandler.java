package com.ben.quiz.controller;

import com.ben.quiz.domain.common.exception.QuizSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class QuizExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(QuizExceptionHandler.class);

    @ExceptionHandler(QuizSystemException.class)
    protected ResponseEntity<Object> handleQuizException(HttpServletRequest request,
                                                           QuizSystemException ex) {
        logger.error(QuizSystemException.class.toString(), ex);
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<Object> handleArgumentsValidationException(HttpServletRequest request,
                                                                        MethodArgumentNotValidException ex) {
        logger.error(MethodArgumentNotValidException.class.toString(), ex);
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handleInvalidRequestBodyException(HttpServletRequest request,
                                                                       HttpMessageNotReadableException ex) {
        logger.error(HttpMessageNotReadableException.class.toString(), ex);
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(HttpServletRequest request,
                                                     Exception ex) {
        logger.error(Exception.class.toString(), ex);
        return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
