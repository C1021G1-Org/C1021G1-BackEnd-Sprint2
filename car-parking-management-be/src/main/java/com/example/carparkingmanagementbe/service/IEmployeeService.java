package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.EmployeeDto;
import com.example.carparkingmanagementbe.model.Employee;

import java.util.Optional;

public interface IEmployeeService {
    void createEmployee(EmployeeDto employeeDto);

    Optional<Employee> findEmployeeById(Long id);

    void updateEmployee(EmployeeDto employeeDto);

    Integer findByEmailNot(Long id, String email);

    Integer findByPhoneNot(Long id, String phone);

}
