package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Employee;
import com.example.carparkingmanagementbe.repository.EmployeeRepository;
import com.example.carparkingmanagementbe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.getAllEmployee(pageable);
    }

    @Override
    public Optional<Employee> findByEmployeeId(Long id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }
}
