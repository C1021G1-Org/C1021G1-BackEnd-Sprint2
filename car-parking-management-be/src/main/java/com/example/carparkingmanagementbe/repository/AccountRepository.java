package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT id, email, `password`, is_enabled FROM `account` WHERE email = ?;",nativeQuery = true)
    Optional<Account> findAccountByEmail(String email);

//    @Modifying
//    @Query(value = "INSERT INTO accounts (`address`, `birthday`, `confirm_password`, `email`, `full_name`, `gender`, `id_card`, `phone`,`password`, `country_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",nativeQuery = true)
//    void saveAccount(String address, String birthday, String confirm_password, String email, String full_name, boolean gender, String id_card, String phone, String password, Countries country_id);

//    @Query(value = "SELECT id,address, birthday, confirm_password, email, full_name, gender," +
//            "id_card,password, phone, country_id FROM accounts WHERE confirm_password =?",nativeQuery = true)
//    Optional<Account> findAccountByPassword(String password);

}
