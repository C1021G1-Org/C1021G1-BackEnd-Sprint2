package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Car;

import java.util.List;

public interface ICarService {
    List<Car> selectCar(Long id);
}
