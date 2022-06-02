package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Account;
import com.example.carparkingmanagementbe.repository.AccountRepository;
import com.example.carparkingmanagementbe.service.IAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email).orElse(null);
    }

    @Override
    public Boolean existAccountByEmail(String email) {
        Account account = accountRepository.findAccountByEmail(email).orElse(null);
        if(account != null){
            return true;
        }
        return false;
    }

    @Override
    public void save(Account acc) {
        accountRepository.save(acc);
    }
}
