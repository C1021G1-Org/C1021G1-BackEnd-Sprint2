package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    //Thuanpd
    Page<Employee> getAllEmployee(Pageable pageable);
    Optional<Employee> findByEmployeeId(Long id);
    void deleteEmployee(Long id);














    //End

}
