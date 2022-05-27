package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICustomerService {

    //ThangDBX lay list customer
    Page<Customer> findAllCustomer(Pageable pageable);

    //ThangDBX search full truong
    Page<Customer> searchFullDate(String datestart ,
                                  String enddate ,
                                  String code,
                                  String phone,
                                  String id_card,
                                  Pageable page);


    //ThangDBX delete customer
    void deleteCustomer(Long id);

    //ThangDBX kiem tra id co ton tai hay khong
    Optional<Customer> findCustomerById(Long id);
}
