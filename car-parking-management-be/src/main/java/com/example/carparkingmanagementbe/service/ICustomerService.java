package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.CustomerDto;
import com.example.carparkingmanagementbe.dto.CustomerDtoCheck;
public interface ICustomerService {

    void createCustomer(CustomerDto customerDto);
    void updateCustomer(CustomerDtoCheck customerDtoCheck);

}
