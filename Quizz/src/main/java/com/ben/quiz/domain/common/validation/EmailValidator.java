package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 19/09/2017.
 */
public class EmailValidator implements ConstraintValidator<Email, String> {

    public void initialize(Email email) {
        validateParameters();
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)) {
            return true;
        }

        String regex = "/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/";
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
