package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.CustomerDtoCheck;
import com.example.carparkingmanagementbe.repository.CustomerRepository;
import com.example.carparkingmanagementbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void updateCustomer(CustomerDtoCheck customerDtoCheck) {
        customerRepository.updateFlight(customerDtoCheck.getCode(), customerDtoCheck.getName(), customerDtoCheck.getBirthday(),
                customerDtoCheck.getIdCard(),customerDtoCheck.getEmail(), customerDtoCheck.getPhone(),
                customerDtoCheck.getAddress(), customerDtoCheck.getGender(), true, customerDtoCheck.getWard(),
                customerDtoCheck.getId());
    }
}
