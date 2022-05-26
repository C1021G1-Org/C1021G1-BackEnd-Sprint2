package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.controller.CarController;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.repository.CarRepository;
import com.example.carparkingmanagementbe.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> selectCar(Long id) {
        return carRepository.selectCustomerAndCar(id);
    }
}
