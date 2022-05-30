package com.example.carparkingmanagementbe.dto;

import com.example.carparkingmanagementbe.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarPlateValidator implements ConstraintValidator<ValidationCarPlate, String> {

    @Autowired
    private ICarService carService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (carService.findByCarPlate(value) > 0) {
            return false;
        }
        return true;
    }
}
