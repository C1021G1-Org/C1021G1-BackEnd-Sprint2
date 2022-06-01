package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.CustomerDto;
import com.example.carparkingmanagementbe.dto.CustomerDtoCheck;
import com.example.carparkingmanagementbe.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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


    //ThangDBX search chi voi end Date
    Page<Customer> searchEndDate(String date,
                                 String code,
                                 String phone,
                                 String id_card,
                                 Pageable page);

    //ThangDBX search chi voi start date
    Page<Customer> searchStartDate(String date,
                                   String code,
                                   String phone,
                                   String id_card,
                                   Pageable page);

    //ThangDBX search khong co date
    Page<Customer> searchCustomerNoDate(String code,
                                        String phone,
                                        String id_card,
                                        Pageable page);

    //ThangDBX delete customer
    void deleteCustomer(Long id);

    //ThangDBX kiem tra id co ton tai hay khong
    Optional<Customer> findCustomerById(Long id);


    //BaoND tạo mới khách hàng
    void createCustomer(CustomerDto customerDto);
    void updateCustomer(CustomerDtoCheck customerDtoCheck);

    Customer save(Customer customer);
}
