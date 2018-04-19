package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Special Characters Validator check
 * Deny special characters !@#$%&*()_+=|<>?{}\\[\\]~-
 */
public class SpecialCharactersValidator implements ConstraintValidator<SpecialCharacters, String> {

	public void initialize(SpecialCharacters parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return false;
		}

		String regex = "[!@#$%&*()_+=|<>?{}\\[\\]~-]";// /^[a-zA-Z ]*$/
		
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(value);

		if (m.find()) {
			return false;
		} else {
			return true;
		}

	}

	private void validateParameters() {
		// Do nothing because don't have value need initialize
	}
}
