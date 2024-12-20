package com.blog.api.root.config.validation.is_array;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;

public class IsArrayValidator implements ConstraintValidator<IsArray, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value instanceof String) { return false; }

        if (((String) value).isEmpty()) {
            return false;
        }

        return value instanceof Collection;
    }
}