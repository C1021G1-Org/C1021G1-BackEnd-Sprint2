package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customer (`name`, email,`code`,gender,id_card,phone,birthday,del_flag,address,id_ward) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10);", nativeQuery = true)
    void createCustomer(String name,String email,String code,Boolean gender,String idCard,String phone,String birthday,
                        Boolean delFlag,String address,Long idWard);

}
