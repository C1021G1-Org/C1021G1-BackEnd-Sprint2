package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.EmployeeDto;
import com.example.carparkingmanagementbe.model.Employee;
import com.example.carparkingmanagementbe.repository.EmployeeRepository;
import com.example.carparkingmanagementbe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        employeeRepository.createAccount(employeeDto.getEmail(),employeeDto.getPassword());
        employeeRepository.createEmployee(employeeDto.getCode(),employeeDto.getName(),employeeDto.getGender(),employeeDto.getBirthday(),
                employeeDto.getPhone(),employeeDto.getId_position(),employeeDto.getId_ward(),employeeDto.getAddress());
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        employeeRepository.updateAccount(employeeDto.getEmail(),employeeDto.getPassword(),employeeDto.getAccount_id());
        employeeRepository.updateEmployee(employeeDto.getName(),employeeDto.getGender(),employeeDto.getBirthday(),employeeDto.getPhone(),employeeDto.getId_position(),
                employeeDto.getId_ward(),employeeDto.getAddress(),employeeDto.getId());
    }

    @Override
    public Integer findByEmailNot(Long id, String email) {
        return employeeRepository.findByEmailNot(id, email);
    }

    @Override
    public Integer findByPhoneNot(Long id, String phone) {
        return employeeRepository.findByPhoneNot(id, phone);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
