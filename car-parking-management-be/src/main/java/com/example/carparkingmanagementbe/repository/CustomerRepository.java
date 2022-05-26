package com.example.carparkingmanagementbe.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customer (`id`, `name`, email,`code`,gender,id_card,phone,birthday,del_flag,address,id_ward) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11);" , nativeQuery = true)
    void createCustomer(Long id,String name,String email,String code,Boolean gender,String idCard,String phone,String birthday,
                        Boolean delFlag,String address,Long idWard);
}
