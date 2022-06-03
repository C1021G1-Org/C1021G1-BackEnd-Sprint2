package com.example.carparkingmanagementbe.security.userprinciple;

import com.example.carparkingmanagementbe.model.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AccountPrinciple implements UserDetails {

    private String email;
    private String password;
    private Boolean isEnabled;

    private Collection<? extends GrantedAuthority> roles;

    public AccountPrinciple() {
    }

    public AccountPrinciple(String email, String password, Boolean isEnabled, Collection<? extends GrantedAuthority> roles) {
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.roles = roles;
    }

    public static AccountPrinciple build(Account account){
        List<GrantedAuthority> authorityList = account.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoles().name())).collect(Collectors.toList());
        return new AccountPrinciple(
                account.getEmail(),
                account.getPassword(),
                account.isEnabled(),
                authorityList
        );
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
