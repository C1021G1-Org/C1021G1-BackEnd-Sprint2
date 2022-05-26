package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.CustomerDto;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Customer;
import com.example.carparkingmanagementbe.repository.CustomerRepository;
import com.example.carparkingmanagementbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //    Bảo thêm mới
    @Override
    public void createCustomer(CustomerDto customerDto) {
        customerRepository.createCustomer(
                customerDto.getName(),
                customerDto.getEmail(),
                customerDto.getCode(),
                customerDto.getGender(),
                customerDto.getIdCard(),
                customerDto.getPhone(),
                customerDto.getBirthday(),
                true,
                customerDto.getAddress(),
                customerDto.getWard()
                );
    }

}
