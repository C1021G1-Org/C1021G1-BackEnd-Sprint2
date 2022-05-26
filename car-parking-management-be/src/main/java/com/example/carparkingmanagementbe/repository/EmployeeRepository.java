package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // thuanpd
     @Query(value ="SELECT " +
             "id," +
             "name," +
             "code,address," +
             "phone,gender," +
             "del_flag," +
             "birthday," +
             "id_position," +
             "account_id," +
             "id_ward" +
             " FROM  `employee` WHERE del_flag = true ",nativeQuery = true)
    Page<Employee> getAllEmployee(Pageable pageable);

     @Query(value = "SELECT " +
             "id,name," +
             "code,address," +
             "phone,gender," +
             "del_flag,birthday" +
             ",id_position" +
             ",account_id,id_ward FROM  `employee` WHERE id = ? AND del_flag = true",nativeQuery = true)
    Optional<Employee> findByEmployeeId(Long id);

     @Modifying
     @Query(value = "UPDATE employee SET del_flag = false WHERE  id =?",nativeQuery = true )
     void deleteEmployee(Long id);



}
