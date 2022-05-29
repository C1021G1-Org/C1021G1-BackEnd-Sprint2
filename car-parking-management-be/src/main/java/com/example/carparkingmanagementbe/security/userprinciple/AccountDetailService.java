package com.example.carparkingmanagementbe.security.userprinciple;

import com.example.carparkingmanagementbe.model.Account;
import com.example.carparkingmanagementbe.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class AccountDetailService implements UserDetailsService {
    @Autowired
    IAccountService accountService;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountService.findAccountByEmail(email);
        if(account == null){
            throw new UsernameNotFoundException("there is not email: "+ email);
        }
        return AccountPrinciple.build(account);
    }
}
