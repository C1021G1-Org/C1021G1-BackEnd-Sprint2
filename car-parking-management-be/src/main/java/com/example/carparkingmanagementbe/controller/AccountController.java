package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CustomerDto;
import com.example.carparkingmanagementbe.dto.SignInDto;
import com.example.carparkingmanagementbe.model.*;
import com.example.carparkingmanagementbe.security.JwtTokenUtil;
import com.example.carparkingmanagementbe.security.userprinciple.AccountPrinciple;
import com.example.carparkingmanagementbe.service.ICustomerService;
import com.example.carparkingmanagementbe.service.IDistrictService;
import com.example.carparkingmanagementbe.service.IProvinceService;
import com.example.carparkingmanagementbe.service.Impl.AccountService;
import com.example.carparkingmanagementbe.service.Impl.RoleService;
import com.example.carparkingmanagementbe.service.Impl.WardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private WardService wardService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RoleService roleService;

    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private IDistrictService districtService;
    @Autowired
    ICustomerService customerService;

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
        account.setEnabled(true);
        account.setPassword(passwordEncoder.encode(signForm.getPassword()));
        account.setRoles(roles);
        accountService.save(account);

        customer.setAddress(signForm.getAddress());
        customer.setBirthday(signForm.getDateOfBirth());
        customer.setName(signForm.getName());
        customer.setPhone(signForm.getPhone());
        customer.setGender(signForm.getGender());
        customer.setEmail(account.getEmail());
        int code = (int) Math.floor((Math.random()*899) + 100);
        String codeRandom = String.valueOf(code);
        customer.setCode("KH-" + codeRandom);

        System.out.println(customer.getCode());

        customer.setIdCard(signForm.getIdCard());
        customer.setIdAccount(account.getId());

        System.out.println(account.getId());
        customer.setWard(ward.getId());
        customerService.signUpCustomer(customer);

        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }


    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody SignInDto signInDto) {
        System.out.println("sign in");
        Authentication authentication;
        if (!accountService.existAccountByEmail(signInDto.getEmail())) {
            return new ResponseEntity<>("emailError", HttpStatus.BAD_REQUEST);
        }
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInDto.getEmail(), signInDto.getPassword()));
        } catch (Exception e) {
            return new ResponseEntity<>("passwordError", HttpStatus.BAD_REQUEST);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.createToken(authentication);
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        return new ResponseEntity<>(new JwtReponse(token, accountPrinciple.getEmail(), accountPrinciple.getAuthorities()), HttpStatus.OK);
    }
}
