package com.itv.petstore.validators;

import org.springframework.beans.BeanWrapperImpl;

import com.itv.petstore.validators.VerifyPassword.VerifyPasswod;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VerifyPasswordValidators implements ConstraintValidator<VerifyPasswod,Object>{
  private String filed;
  private String matchingfiled;
  public void initialize(VerifyPasswod ConstraintAnnotation)
  {
    this.filed=ConstraintAnnotation.Filed();
    this.matchingfiled=ConstraintAnnotation.matchingFiled();
  }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
    Object filedValue=new BeanWrapperImpl(value).getPropertyValue(filed);
    Object matchingFiledValue=new BeanWrapperImpl(value).getPropertyValue(matchingfiled);
    return filedValue.equals(matchingFiledValue);
    }
    
}