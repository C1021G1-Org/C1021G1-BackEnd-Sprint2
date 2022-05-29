package com.example.carparkingmanagementbe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignForm {
    private String name;
    private String address;
    private Boolean gender;
    private String dateOfBirth;
    private String phone;
    private String email;
    private String password;
    private Long idWard;
}
