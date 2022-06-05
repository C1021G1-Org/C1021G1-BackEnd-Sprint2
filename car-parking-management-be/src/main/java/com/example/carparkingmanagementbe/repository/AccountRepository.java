package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT id, email, `password`, is_enabled FROM `account` WHERE email = ?;",nativeQuery = true)
    Optional<Account> findAccountByEmail(String email);

}
