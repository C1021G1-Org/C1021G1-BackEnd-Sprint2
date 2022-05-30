package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Account;
import com.example.carparkingmanagementbe.model.Role;
import com.example.carparkingmanagementbe.repository.AccountRepository;
import com.example.carparkingmanagementbe.repository.RoleRepository;
import com.example.carparkingmanagementbe.service.IAccountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        //address,birthday,confirm_password,email,full_name,gender,id_card,password,phone,country_id
//        accountRepository.saveAccount(acc.getAddress(), acc.getBirthday(), acc.getConfirmPassword(),acc.getEmail(),
//                acc.getFullName(),acc.getGender(),acc.getIdCard(), acc.getPhone(), acc.getPassword(), acc.getCountry());
//    }
        accountRepository.save(acc);
    }
}
