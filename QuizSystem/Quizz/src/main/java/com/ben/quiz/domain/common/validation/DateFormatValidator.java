package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * DateFormat validity check
 *
 */
public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

	private String dateFormat;

	public void initialize(DateFormat parameters) {
		validateParameters();
		this.dateFormat = parameters.format();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try {
			sdf.parse(value.toString());
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

	private void validateParameters() {
	}

}
