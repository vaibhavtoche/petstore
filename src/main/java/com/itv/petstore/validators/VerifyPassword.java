package com.itv.petstore.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

public class VerifyPassword {
   @Constraint(validatedBy = VerifyPasswordValidators.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyPasswod {
    String message()default "password and confirm password both are not equal";
    Class<?>[]groups()default{};
    Class<? extends Payload>[]payload()default{}; 
    String Filed();
    String matchingFiled();
}
}
