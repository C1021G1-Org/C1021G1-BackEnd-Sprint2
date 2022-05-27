package com.example.carparkingmanagementbe.repository;


import com.example.carparkingmanagementbe.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;




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

    //ThangDBX kiem tra customer id co ton tai hay khong
    @Query(value = "select id, address, birthday, `code`, del_flag, email, gender, id_card, `name`, phone, account_id, id_ward\n" +
            "from customer\n" +
            "where del_flag = true \n" +
            "and id = ?", nativeQuery = true)
    Optional<Customer> findCustomerById(Long id);

//    @Query(value = "select id ,address, birthday,`code`, del_flag, email, gender, id_card, `name`, phone, account_id, id_ward\n" +
//            "from customer \n" +
//            "where `del_flag` = true \n" +
//            "and code like '%?1%'\n" +
//            "and phone like '%?2%'\n" +
//            "and id_card like '%?3%'\n" +
//            "and birthday between '?4' and '?5' \n" +
//            ";",countQuery = "SELECT count(*) FROM customer", nativeQuery = true)

    //ThangDBX search có full ngày
    @Query(value = "select id ,address, birthday,`code`, del_flag, email, gender, id_card, `name`, phone, account_id, id_ward\n" +
            "from customer \n" +
            "where `del_flag` = true \n" +
            "and birthday between ?1 and ?2 \n" +
            "and code like %?3% \n" +
            "and phone like %?4% \n" +
            "and id_card like %?5% "
            ,countQuery = "SELECT count(*) FROM customer", nativeQuery = true)
    Page<Customer> searchfullDate(String datestart ,
                                  String enddate ,
                                  String code,
                                  String phone,
                                  String id_card,
                                  Pageable page);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customer (`name`, email,`code`,gender,id_card,phone,birthday,del_flag,address,id_ward) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10);", nativeQuery = true)
    void createCustomer(String name,String email,String code,Boolean gender,String idCard,String phone,String birthday,
                        Boolean delFlag,String address,Long idWard);


    //tronghd tạo câu lệnh query chỉnh sửa thông tin khách hàng
    @Transactional
    @Modifying
    @Query(value = "UPDATE customer AS c SET c.code = ?1 , c.name = ?2, c.birthday = ?3, c.id_card = ?4," +
            "c.email = ?5, c.phone = ?6, c.address = ?7, c.gender = ?8, c.del_flag = ?9, c.id_ward = ?10 WHERE id = ?11", nativeQuery = true)
    void updateFlight(String code, String name, String birthday, String idCard,
                      String email, String phone, String address, Boolean gender, Boolean delFlag,Long ward, Long id);

}
