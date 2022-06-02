package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Account;

public interface IAccountService {
    Account findAccountByEmail(String email);
    Boolean existAccountByEmail(String email);
    void save(Account acc);
}
