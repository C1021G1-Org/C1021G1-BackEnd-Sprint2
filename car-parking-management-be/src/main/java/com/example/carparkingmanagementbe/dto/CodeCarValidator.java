package com.example.carparkingmanagementbe.dto;

import com.example.carparkingmanagementbe.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodeCarValidator implements ConstraintValidator<ValidationCodeCar, String> {

    @Autowired
    private ICarService carService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (carService.findByCodeCar(value) > 0) {
            return false;
        }
        return true;
    }
}
