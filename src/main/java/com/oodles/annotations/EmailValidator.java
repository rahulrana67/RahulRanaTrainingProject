package com.oodles.annotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";        
	   
	Pattern pattern;
	Matcher matcher;
	
	 @Override
	 public void initialize(EmailConstraint constraintAnnotation) {       
	    }
	 @Override
	 public boolean isValid(String email, ConstraintValidatorContext context){   
	        return (validateEmail(email));
	    } 
	    private boolean validateEmail(String email) {
	       pattern = Pattern.compile(EMAIL_PATTERN);
	       matcher = pattern.matcher(email);
	       return matcher.matches();
	    }
	
}
