package com.example.carparkingmanagementbe.dto;
import javax.persistence.Column;
public interface LocationDetailDto {
    Long getId();

    String getCode();

    String getNameFloor();

    String getNameCustomer();

    String getBirthday();

    String getEmail();

    String getPhone();

    String getNameTypeCar();

    String getCarCompany();

    String getNameCar();

    String getCarPlate();
}
