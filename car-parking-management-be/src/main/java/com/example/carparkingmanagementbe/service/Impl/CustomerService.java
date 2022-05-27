package com.example.carparkingmanagementbe.service.Impl;
import com.example.carparkingmanagementbe.dto.CustomerDto;


import com.example.carparkingmanagementbe.dto.CustomerDtoCheck;
import com.example.carparkingmanagementbe.model.Customer;
import com.example.carparkingmanagementbe.repository.CustomerRepository;
import com.example.carparkingmanagementbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
   private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public Page<Customer> searchFullDate(String datestart, String enddate, String code, String phone, String id_card, Pageable page) {
        return customerRepository.searchfullDate(datestart, enddate, code,phone,id_card ,page);
    }


    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

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

    @Override
    public void updateCustomer(CustomerDtoCheck customerDtoCheck) {
        customerRepository.updateFlight(customerDtoCheck.getCode(), customerDtoCheck.getName(), customerDtoCheck.getBirthday(),
                customerDtoCheck.getIdCard(),customerDtoCheck.getEmail(), customerDtoCheck.getPhone(),
                customerDtoCheck.getAddress(), customerDtoCheck.getGender(), true, customerDtoCheck.getWard(),
                customerDtoCheck.getId());
    }

}
