package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.CarDto;
import com.example.carparkingmanagementbe.model.Car;

import java.util.List;

public interface ICarService {

    void createCar(CarDto carDto);

    List<Car> findAll();

    Integer findByCodeCar(String code);

    Integer findByCarPlate(String carPlate);

    List<Car> findByIdCustomer(Long id);
}
