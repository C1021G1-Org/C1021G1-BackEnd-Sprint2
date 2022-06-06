package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.CarDto;
import com.example.carparkingmanagementbe.dto.CarPlateDto;
import com.example.carparkingmanagementbe.dto.CarTicketDto;
import com.example.carparkingmanagementbe.model.Car;

import java.util.List;

public interface ICarService {
    List<Car> selectCar(Long id);
    void createCar(CarDto carDto);

    void createCarCustomerNull(CarDto carDto);

    List<Car> findAll();
    Integer findByCodeCar(String code);
    Integer findByCarPlate(String carPlate);
    List<Car> getListCarByEmail(String email);
    List<Car> findByIdCustomer(Long id);
    List<CarPlateDto> findCarModal(String name, String phone, String plate);
    List<CarTicketDto> chooseCar(String plate);
    List<Car> findCarByIdCustomer(Long id);
    List<Car> findCarByIdCustomerNull();

    void updateCarByIdCustomerNull(Long idCustomer);

    void deleteCarById(Long id);
    Car findCarById(Long id);

}
