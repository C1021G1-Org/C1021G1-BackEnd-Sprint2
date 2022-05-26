package com.example.carparkingmanagementbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
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
    private Long ward;
}
