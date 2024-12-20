package com.blog.api.root.config.validation.is_array;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = IsArrayValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsArray {
    String message() default "Array not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}