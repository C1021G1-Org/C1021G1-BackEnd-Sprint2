package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CustomerDto;
import com.example.carparkingmanagementbe.dto.EmployeeDto;
import com.example.carparkingmanagementbe.model.Account;
import com.example.carparkingmanagementbe.model.Role;
import com.example.carparkingmanagementbe.model.SignForm;
import com.example.carparkingmanagementbe.service.Impl.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @GetMapping("/accounts")
//    public ResponseEntity<List<Account>> getAccounts() {
//        return ResponseEntity.ok().body(accountService.getAccounts());
//    }
//
//    @PostMapping("/account/save")
//    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/account/save").toUriString());
//        return ResponseEntity.created(uri).body(accountService.saveAccount(account));
//    }
//
//    @PostMapping("/role/save")
//    public ResponseEntity<Role> saveRole (@RequestBody Role role) {
//        return ResponseEntity.ok().body(accountService.saveRole(role));
//    }

    @PostMapping(value = "api/signUp")
    public ResponseEntity<?> register(@Valid @RequestBody SignForm signForm) {
        CustomerDto customerDto = new CustomerDto();
        EmployeeDto employeeDto = new EmployeeDto();
        System.out.println("sign up");
        if (accountService.existAccountByPhone(signForm.getPhone())) {
            return new ResponseEntity<>("duplicate phone", HttpStatus.BAD_REQUEST);
        }
        if (accountService.existAccountByIdCard(signForm.getIdCard())) {
            return new ResponseEntity<>("duplicate idCard", HttpStatus.BAD_REQUEST);
        }
        if (accountService.existAccountByEmail(signForm.getEmail())) {
            return new ResponseEntity<>("duplicate email", HttpStatus.BAD_REQUEST);
        }
        Account acc = new Account();
        BeanUtils.copyProperties(signForm, acc);
        acc.setPassword(passwordEncoder.encode(signForm.getPassword()));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role(3L, RoleName.ROLE_CUSTOMER));
        if (acc.getEmail().equals("admin@gmail.com")) {
            roleSet.add(new Role(2L, RoleName.ROLE_EMPLOYEE));
            roleSet.add(new Role(1L, RoleName.ROLE_ADMIN));
        }
        if (acc.getEmail().equals("employee@gmail.com")) {
            roleSet.add(new Role(2L, RoleName.ROLE_EMPLOYEE));
        }
        acc.setRoles(roleSet);


        //employeeDto.getAddress_Employee(),employeeDto.getCode_Employee()
        //                ,true,employeeDto.getBirthday_Employee(),employeeDto.getEmail_Employee(),
        //                employeeDto.getGender_Employee(),employeeDto.getName_Employee(), employeeDto.getPhone_Employee(),
        //                employeeDto.getEmployee_Type_Id());
//        employeeDto.setAddress_Employee(acc.getAddress());
//        employeeDto.setCode_Employee(null);
//        employeeDto.setBirthday_Employee(acc.getBirthday());
//        employeeDto.setEmail_Employee(acc.getEmail());
//        employeeDto.setGender_Employee(acc.getGender());
//        employeeDto.setName_Employee(acc.getFullName());
//        employeeDto.setPhone_Employee(acc.getPhone());
        if (!acc.getEmail().equals("employee@gmail.com")) {
            customerDto.setNameCustomer(acc.getFullName());
            customerDto.setPhoneCustomer(acc.getPhone());
            customerDto.setBirthdayCustomer(acc.getBirthday());
            customerDto.setGenderCustomer(acc.getGender());
            customerDto.setEmailCustomer(acc.getEmail());
            customerDto.setIdCardCustomer(acc.getIdCard());
            customerDto.setAddressCustomer(acc.getAddress());
            customerDto.setCustomerType(4L);
            customerDto.setCountries(acc.getCountry().getId());
            customerService.save(customerDto);
            accountService.save(acc);

        }
        return new ResponseEntity<>(acc, HttpStatus.CREATED);
    }
}
