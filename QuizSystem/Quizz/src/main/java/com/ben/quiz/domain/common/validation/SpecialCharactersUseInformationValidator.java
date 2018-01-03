package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Special Characters Validator check
 * Deny special characters !@#$%&*()+=|<>?{}\\[\\]~-
 */
public class SpecialCharactersUseInformationValidator implements ConstraintValidator<SpecialCharactersUserInformation, String> {

	public void initialize(SpecialCharactersUserInformation parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return false;
		}

		String regex = "[^1-9a-zA-Z._]";
		
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
