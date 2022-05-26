package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Customer;
import com.example.carparkingmanagementbe.repository.CustomerRepository;
import com.example.carparkingmanagementbe.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
   private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAllCustomer(pageable);
    }

    @Override
    public Page<Customer> searchfullDate(String code,String phone,String idCard,String datestart,String enddate,
                                         Pageable page) {
        return customerRepository.searchfullDate(code, phone, idCard, datestart, enddate, page);
    }
}
