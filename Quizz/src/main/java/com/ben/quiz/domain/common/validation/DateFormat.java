package com.ben.quiz.domain.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = DateFormatValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface DateFormat {

	String name() default "";

	String format() default "yyyy/MM/dd";

	String message() default "The date format of {name} is invalid.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several {@code @Length} annotations on the same element.
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		DateFormat[] value();
	}
}
