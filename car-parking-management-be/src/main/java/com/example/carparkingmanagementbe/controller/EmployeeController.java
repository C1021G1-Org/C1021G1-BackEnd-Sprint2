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
import com.example.carparkingmanagementbe.dto.EmployeeDto;
import com.example.carparkingmanagementbe.dto.EmployeeDtoCheck;
import com.example.carparkingmanagementbe.model.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeController {

    //thuanpd
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/list")
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

  //PhuHDQ
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        char[] charArray = employeeDto.getName().toCharArray();
        boolean foundSpace = true;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                if (foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }
        employeeDto.setName(String.valueOf(charArray));
        iEmployeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Optional<Employee> employee = iEmployeeService.findEmployeeById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDtoCheck employeeDtoCheck) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDtoCheck.setId(id);
        if (iEmployeeService.findEmployeeById(id).isPresent()) {
            if (iEmployeeService.findByEmailNot(employeeDtoCheck.getId(), employeeDtoCheck.getEmail()) == 0
                    && iEmployeeService.findByPhoneNot(employeeDtoCheck.getId(), employeeDtoCheck.getPhone()) == 0) {
                BeanUtils.copyProperties(employeeDtoCheck, employeeDto);
                employeeDto.setId(id);
                char[] charArray = employeeDto.getName().toCharArray();
                boolean foundSpace = true;
                for (int i = 0; i < charArray.length; i++) {
                    if (Character.isLetter(charArray[i])) {
                        if (foundSpace) {
                            charArray[i] = Character.toUpperCase(charArray[i]);
                            foundSpace = false;
                        }
                    } else {
                        foundSpace = true;
                    }
                }
                employeeDto.setName(String.valueOf(charArray));
                employeeDto.setCode(iEmployeeService.findEmployeeById(id).get().getCode());
                employeeDto.setAccount_id(iEmployeeService.findEmployeeById(id).get().getAccount().getId());
                iEmployeeService.updateEmployee(employeeDto);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        Map<String, String> errors = new HashMap<>();
        if (iEmployeeService.findByEmailNot(employeeDtoCheck.getId(), employeeDtoCheck.getEmail()) > 0) {
            errors.put("email", "Email đã tồn tại!");
        }
        if (iEmployeeService.findByPhoneNot(employeeDtoCheck.getId(), employeeDtoCheck.getPhone()) > 0) {
            errors.put("phone", "Số điện thoại đã tồn tại!");
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
