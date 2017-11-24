package com.ben.quiz.domain.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = HalfAlphaNumericValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface HalfAlphaNumeric {

	String name() default "";

	String message() default "Please input {name} with half-width alphanumeric characters.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	/**
	 * Defines several {@code @Length} annotations on the same element.
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		HalfAlphaNumeric[] value();
	}
}
