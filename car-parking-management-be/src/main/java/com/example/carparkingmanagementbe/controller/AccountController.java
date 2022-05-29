package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CustomerDto;
import com.example.carparkingmanagementbe.dto.EmployeeDto;
import com.example.carparkingmanagementbe.model.Account;
import com.example.carparkingmanagementbe.model.Role;
import com.example.carparkingmanagementbe.model.SignForm;
import com.example.carparkingmanagementbe.model.Ward;
import com.example.carparkingmanagementbe.service.ICustomerService;
import com.example.carparkingmanagementbe.service.IDistrictService;
import com.example.carparkingmanagementbe.service.IProvinceService;
import com.example.carparkingmanagementbe.service.Impl.AccountService;
import com.example.carparkingmanagementbe.service.Impl.RoleService;
import com.example.carparkingmanagementbe.service.Impl.WardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private WardService wardService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private IDistrictService districtService;
    @Autowired
    ICustomerService customerService;

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

    @PostMapping(value = "/signUp")
    public ResponseEntity<?> register(@Valid @RequestBody SignForm signForm) {


        if (accountService.existAccountByEmail(signForm.getEmail())) {
            return new ResponseEntity<>("duplicate email", HttpStatus.BAD_REQUEST);
        }
        Ward ward = new Ward();
        ward.setId(signForm.getIdWard());

        System.out.println("sign up");
        CustomerDto customer = new CustomerDto();
        Account account = new Account();
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findById(2L));
        account.setEmail(signForm.getEmail());
        account.setPassword(passwordEncoder.encode(signForm.getPassword()));
        account.setRoles(roles);
        accountService.save(account);

        customer.setAddress(signForm.getAddress());
        customer.setBirthday(signForm.getDateOfBirth());
        customer.setName(signForm.getName());
        customer.setPhone(signForm.getPhone());
        customer.setGender(signForm.getGender());
//        customer.setAccount(account);
        customer.setEmail(account.getEmail());
//        customer.setCarSet(null);
        customer.setWard(ward.getId());

        customerService.createCustomer(customer);


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
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
}
