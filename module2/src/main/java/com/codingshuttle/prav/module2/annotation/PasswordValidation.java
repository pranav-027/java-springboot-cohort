package com.codingshuttle.prav.module2.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordValidation {

	String message() default "Password should follow its constraints";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
