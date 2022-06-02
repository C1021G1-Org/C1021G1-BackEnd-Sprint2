package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.*;
import com.example.carparkingmanagementbe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.carparkingmanagementbe.dto.EmployeeDto;
import com.example.carparkingmanagementbe.dto.EmployeeDtoCheck;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/employee")
public class EmployeeController {


    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IProvinceService iProvinceService;

    @Autowired
    private IDistrictService iDistrictService;

    @Autowired
    private IWardService iWardService;

    //thuanpd
    @GetMapping("/list")
    public ResponseEntity<Page<Employee>> getAllEmployee(@RequestParam(defaultValue = "0") int page) {
        Page<Employee> employeeList = iEmployeeService.getAllEmployee(PageRequest.of(page, 10));
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

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Employee>> getById(@PathVariable Long id) {
//        Optional<Employee> employeeOptional = iEmployeeService.findByEmployeeId(id);
//        if (!employeeOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(employeeOptional, HttpStatus.OK);
//    }

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
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
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
        Map<String, String> errorMap = new HashMap<>();
        new EmployeeDtoCheck().validate(employeeDto, bindingResult);
        if (iEmployeeService.findByEmailNot(employeeDto.getId(), employeeDto.getEmail()) > 0) {
            errorMap.put("email", "Email đã tồn tại!");
        }
        if (iEmployeeService.findByCodeNot(employeeDto.getId(), employeeDto.getCode()) > 0) {
            errorMap.put("code", "Mã nhân viên đã tồn tại!");
            System.out.println(employeeDto.getCode());
        }
        if (iEmployeeService.findByPhoneNot(employeeDto.getId(), employeeDto.getPhone()) > 0) {
            errorMap.put("phone", "Số điện thoại đã tồn tại!");
        }
        if (bindingResult.hasFieldErrors()) {
            Map<String, Object> response = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            response.put("error", errorMap);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
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

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDtoCheck employeeDtoCheck, BindingResult bindingResult) {
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
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/list-position")
    public ResponseEntity<List<Position>> getAllEmployee() {
        List<Position> positionList = iPositionService.getAllPosition();
        if (positionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }

    @GetMapping("/district-list/{id}")
    public ResponseEntity<List<District>> getAllDistrict(@PathVariable Long id) {
        List<District> districtList = iDistrictService.getAllDistrict(id);
        if (districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    @GetMapping("/province-list")
    public ResponseEntity<List<Province>> getAllProvince() {
        List<Province> provinceList = iProvinceService.getAllProvince();
        if (provinceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

    @GetMapping("/ward-list/{id}")
    public ResponseEntity<List<Ward>> getAllWard(@PathVariable Long id) {
        List<Ward> wardList = iWardService.getAllWard(id);
        if (wardList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wardList, HttpStatus.OK);
    }
}
