package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LowerCaseValidator  implements ConstraintValidator<LowerCase, String> {

    public void initialize(LowerCase lowerCase) {
        validateParameters();
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)) {
            return true;
        }

        String regex = "^[A-Z]*$";// /^[a-zA-Z ]*$/

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
