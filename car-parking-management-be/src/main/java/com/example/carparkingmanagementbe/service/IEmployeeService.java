package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Employee;
import com.example.carparkingmanagementbe.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.carparkingmanagementbe.dto.EmployeeDto;

import java.util.Date;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    //Thuanpd
  
    Page<Employee> getAllEmployee(Pageable pageable);
  
    Optional<Employee> findByEmployeeId(Long id);
  
    void deleteEmployee(Long id);

    Page<Employee> findEmployeeByElemetContaining(String fromDate,String toDate, String name, String code, String address, Pageable pageable);


    //PhuHDQ

    void createEmployee(EmployeeDto employeeDto);

    Optional<Employee> findEmployeeById(Long id);

    void updateEmployee(EmployeeDto employeeDto);

    Integer findByEmailNot(Long id, String email);

    Integer findByPhoneNot(Long id, String phone);

    Integer findByCodeNot(Long id, String phocodene);
}
