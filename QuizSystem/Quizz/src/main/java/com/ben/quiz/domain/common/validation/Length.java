package com.ben.quiz.domain.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = LengthValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface Length {

	String name() default "";

	int length() default Integer.MAX_VALUE;

	String message() default "Please input {name} in {length} digits.";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};

	/**
	 * Defines several {@code @Length} annotations on the same element.
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		Length[]value();
	}

}
