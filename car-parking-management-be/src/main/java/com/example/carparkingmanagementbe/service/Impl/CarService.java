package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.CarDto;
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
    public void createCar(CarDto carDto) {
        carRepository.createCar(carDto.getCode(), carDto.getName(), carDto.getCarPlate(), carDto.getCarCompany(),
                carDto.getCustomer(), carDto.getCarType(), true);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Integer findByCodeCar(String code) {
        return carRepository.finByCodeCar(code);
    }

    @Override
    public Integer findByCarPlate(String carPlate) {
        return carRepository.finByCarPlate(carPlate);
    }

    @Override
    public List<Car> findByIdCustomer(Long id) {
        return carRepository.findByIdCustomer(id);
    }
}
