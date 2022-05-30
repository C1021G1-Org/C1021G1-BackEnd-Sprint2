package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Account;
import com.example.carparkingmanagementbe.model.Role;

import java.util.List;

public interface IAccountService {
    Account findAccountByEmail(String email);
    Boolean existAccountByEmail(String email);
    void save(Account acc);
}
