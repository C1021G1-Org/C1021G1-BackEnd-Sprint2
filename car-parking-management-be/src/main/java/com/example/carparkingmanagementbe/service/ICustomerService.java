package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService {

    //ThangDBX lay list customer
    Page<Customer> findAllCustomer(Pageable pageable);

    //ThangDBX search full truong
    Page<Customer> searchfullDate(String code,String phone,String idCard,String datestart,String enddate,
                                  Pageable page);
}
