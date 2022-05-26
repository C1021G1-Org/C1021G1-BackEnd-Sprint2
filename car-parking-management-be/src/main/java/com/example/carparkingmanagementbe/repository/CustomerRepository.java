package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // ThangDBX lay list danh sach
    @Query(value = "SELECT id ,address, birthday,`code`, del_flag, email, gender, id_card, `name`, phone, account_id, id_ward FROM `customer` where del_flag = 1 ", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable page);

    //ThangDBX xoa phan tu trong danh sach khach hang
    @Modifying
    @Query(value = "update customer set del_flag = 0 where id = :id ;", nativeQuery = true)
    void deleteCustomer(Long id);


    //ThangDBX search có full ngày
    @Query(value = "select id ,address, birthday,`code`, del_flag, email, gender, id_card, `name`, phone, account_id, id_ward\n" +
            "from customer \n" +
            "where `del_flag` = true \n" +
            "and code like '%?1%'\n" +
            "and phone like '%?2%'\n" +
            "and id_card like '%?3%'\n" +
            "and birthday between '?4' and '?5' \n" +
            ";",countQuery = "SELECT count(*) FROM customer", nativeQuery = true)
    Page<Customer> searchfullDate(String code,String phone,String idCard,String datestart,String enddate,
                                  Pageable page);


}
