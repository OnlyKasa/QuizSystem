package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthMinValidator implements ConstraintValidator<LengthMin, String> {
	private int min;

	public void initialize(LengthMin parameters) {
		min = parameters.min();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}
		int length = value.length();

		return length >= min;
	}

	private void validateParameters() {
		if (min < 0) {
			throw new IllegalArgumentException("The min parameter cannot be negative.");
		}

	}

}
