package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements ConstraintValidator<Length, String> {
	private int length;

	public void initialize(Length parameters) {
		length = parameters.length();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		return value.length() == length;
	}

	private void validateParameters() {
		if (length < 0) {
			throw new IllegalArgumentException("The length parameter cannot be negative.");
		}
	}
}
