package com.ben.quiz.domain.common.validation;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxValidator implements ConstraintValidator<Max, String> {
    private long max;

    public void initialize(Max parameters) {
        max = parameters.value();
        validateParameters();
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(value)) {
            return true;
        }

        String regex = "^(\\d+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(value.trim());

        if (m.find()) {
            try {
                return Long.parseLong(value.trim()) <= max;
            } catch (Exception e) {
                Logger.getLogger(MaxValidator.class).error(e);
                return false;
            }
        } else {
            return false;
        }
    }

    private void validateParameters() {
    }

}
