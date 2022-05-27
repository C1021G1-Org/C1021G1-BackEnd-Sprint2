package com.example.carparkingmanagementbe.dto;

import com.example.carparkingmanagementbe.model.Account;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Ward;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

public class CustomerDtoDoCheck {

    private Long id;
    private String code;
    private String name;
    private String birthday;
    private String idCard;
    private String email;
    private String phone;
    private String address;
    private Boolean gender;
    private Boolean delFlag;
    private Ward ward;
}
