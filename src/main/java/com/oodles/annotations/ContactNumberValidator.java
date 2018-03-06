package com.oodles.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {
 
    @Override
    public void initialize(ContactNumberConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) 
    {
        return contactField != null && contactField.matches("[0-9]+")&& (contactField.length() >= 10) && (contactField.length() <= 11);
    }
}