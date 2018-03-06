package com.oodles.annotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

	private static final String PASSWORD_PATTERN="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	Pattern pattern;
	Matcher matcher;
	
	@Override
	public void initialize(PasswordConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	       matcher = pattern.matcher(password);
	       return matcher.matches();
	}
}
