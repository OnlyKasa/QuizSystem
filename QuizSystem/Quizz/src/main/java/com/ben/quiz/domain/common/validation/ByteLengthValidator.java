package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.UnsupportedEncodingException;

public class ByteLengthValidator implements ConstraintValidator<ByteLength, String> {
	private int byteLength;
	private String encode;

	public void initialize(ByteLength parameters) {
		byteLength = parameters.byteLength();
		encode = parameters.encode();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		if (StringUtils.isBlank(value)) {
			return true;
		}
		
		try {
			return value.getBytes(encode).length <= byteLength;
		} catch (UnsupportedEncodingException e) {
			Logger.getLogger(ByteLengthValidator.class).error(e);
			return false;
		}
	}

	private void validateParameters() {
		if (byteLength < 0) {
			throw new IllegalArgumentException("The byteLength parameter cannot be negative.");
		}
	}
}
