package com.example.carparkingmanagementbe.repository;


import com.example.carparkingmanagementbe.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
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
