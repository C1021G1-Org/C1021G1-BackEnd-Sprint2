package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.EmployeeDto;

import com.example.carparkingmanagementbe.dto.EmployeeDtoCheck;
import com.example.carparkingmanagementbe.model.Account;
import com.example.carparkingmanagementbe.model.Employee;
import com.example.carparkingmanagementbe.service.Impl.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<?> listEmployee() {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

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
        employeeService.createEmployee(employeeDto);
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
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDtoCheck employeeDtoCheck) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDtoCheck.setId(id);
        if (employeeService.findEmployeeById(id).isPresent()) {
            if (employeeService.findByEmailNot(employeeDtoCheck.getId(), employeeDtoCheck.getEmail()) == 0
                    && employeeService.findByPhoneNot(employeeDtoCheck.getId(), employeeDtoCheck.getPhone()) == 0) {
                System.out.println(employeeService.findByPhoneNot(employeeDtoCheck.getId(), employeeDtoCheck.getPhone()));
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
                employeeDto.setCode(employeeService.findEmployeeById(id).get().getCode());
                employeeDto.setAccount_id(employeeService.findEmployeeById(id).get().getAccount().getId());
                employeeService.updateEmployee(employeeDto);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        Map<String, String> errors = new HashMap<>();
        if (employeeService.findByEmailNot(employeeDtoCheck.getId(), employeeDtoCheck.getEmail()) > 0) {
            errors.put("email", "Email đã tồn tại!");
        }
        if (employeeService.findByPhoneNot(employeeDtoCheck.getId(), employeeDtoCheck.getPhone()) > 0) {
            errors.put("phone", "Số điện thoại đã tồn tại!");
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
