package com.codingshuttle.prav.module2.annotation;

import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PrimeNumber {

	String message() default "Invalid Prime Number";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}

