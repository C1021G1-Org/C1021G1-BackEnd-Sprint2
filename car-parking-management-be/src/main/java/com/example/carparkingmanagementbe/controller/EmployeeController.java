package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Employee;
import com.example.carparkingmanagementbe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EmployeeController {

    //thuanpd
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/list-employee")
    public ResponseEntity<Page<Employee>> getAllEmployee(@RequestParam(defaultValue = "0") int page) {
        Page<Employee> employeeList = iEmployeeService.getAllEmployee(PageRequest.of(page, 5));
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


    @GetMapping("/not-pagination")
    public ResponseEntity<Page<Employee>> getAllEmployeeNotPagination() {
        Page<Employee> employees = iEmployeeService.getAllEmployee(Pageable.unpaged());
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = iEmployeeService.findByEmployeeId(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeeOptional, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employeeOptional = iEmployeeService.findByEmployeeId(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iEmployeeService.deleteEmployee(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);

    }


}
