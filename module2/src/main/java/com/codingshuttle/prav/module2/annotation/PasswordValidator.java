package com.codingshuttle.prav.module2.annotation;

import jakarta.validation.ConstraintValidator;

public class PasswordValidator implements ConstraintValidator<PasswordValidation,String> {

	@Override
	public boolean isValid(String password, jakarta.validation.ConstraintValidatorContext context) {
		if (password == null) {
			return false;
		}
//		a. contains one uppercase letter
//		b. contains one lowercase letter
//		c. contains one special character
//		d. minimum length is 10 characters
		return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[^A-Za-z0-9]).{10,}$");

	}

}
