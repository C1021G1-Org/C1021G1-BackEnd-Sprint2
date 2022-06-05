package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Employee;
import com.example.carparkingmanagementbe.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // thuanpd
     @Query(value ="SELECT " +
             "id," +
             "name," +
             "code,address," +
             "phone,gender," +
             "del_flag," +
             "birthday," +
             "id_position," +
             "account_id," +
             "id_ward" +
             " FROM  `employee` WHERE del_flag = true ",nativeQuery = true)
    Page<Employee> getAllEmployee(Pageable pageable);

     @Query(value = "SELECT " +
             "id,name," +
             "code,address," +
             "phone,gender," +
             "del_flag,birthday" +
             ",id_position" +
             ",account_id,id_ward FROM  `employee` WHERE id = ? AND del_flag = true",nativeQuery = true)
    Optional<Employee> findByEmployeeId(Long id);

     @Modifying
     @Query(value = "UPDATE employee SET del_flag = false WHERE  id =?",nativeQuery = true )
     void deleteEmployee(Long id);


//     @Query(value = "SELECT id,name,code,address,phone,gender,del_flag,birthday,id_position,account_id,id_ward \n" +
//             "FROM employee  WHERE del_flag = TRUE " +
//             "AND birthday BETWEEN ?1 AND ?2 \n" +
//             "AND name LIKE %?3% " +
//             "AND code LIKE %?4% " +
//             "AND address LIKE %?5%",countQuery = "select count(*) from employee",nativeQuery = true)
//     Page<Employee> findEmployeeByElemetContaining(String fromDate,String toDate, String name,String code,String address,Pageable pageable);


    @Query(value = "SELECT employee.id,employee.`name`,employee.`code`,\n" +
            "employee.address,employee.phone,employee.gender,employee.del_flag,employee.birthday,\n" +
            "employee.id_position,employee.account_id,employee.id_ward \n" +
            "FROM employee \n" +
            "INNER JOIN ward ON employee.id_ward = ward.id \n" +
            "INNER JOIN district ON ward.id_district = district.id\n" +
            "INNER JOIN province ON ward.id_province = province.id\n" +
            "WHERE del_flag = TRUE AND birthday BETWEEN ?1 AND ?2\n" +
            "AND employee.`name` LIKE %?3% AND\n" +
            "employee.`code` LIKE %?4% AND CONCAT(employee.address,ward.name,district.name,province.name) like %?5%",countQuery = "SELECT COUNT(*) FROM employee",nativeQuery = true)
    Page<Employee> findEmployeeByElemetContaining(String fromDate,String toDate, String name,String code,String address,Pageable pageable);





  //PhuHDQ
    @Modifying
    @Query(value = "INSERT INTO account (account.email, account.password, account.is_enabled)" +
            "VALUES (?,?,1)", nativeQuery = true)
    void createAccount(String email, String password);

    @Modifying
    @Query(value = "INSERT INTO employee (employee.code, employee.name, employee.gender, employee.birthday, employee.phone, employee.id_position, employee.id_ward, employee.address,employee.del_flag,employee.account_id)" +
            "VALUES (?,?,?,?,?,?,?,?,1,LAST_INSERT_ID())", nativeQuery = true)
    void createEmployee(String code, String name, Boolean gender, String birthday, String phone, Long idPosition, Long idWard, String address);

    @Query(value = "SELECT id, code, name, gender, birthday, phone, id_position, id_ward, address, del_flag, account_id " +
            "FROM employee WHERE employee.id = ? AND del_flag = true", nativeQuery = true)
    Optional<Employee> findEmployeeById(Long id);

    @Modifying
    @Query(value = "UPDATE account SET email=?, password=? " +
            "WHERE id = ?", nativeQuery = true)
    void updateAccount(String email, String password, Long id);

    @Modifying
    @Query(value = "UPDATE employee SET name=?, gender=?, birthday=?, phone=?, id_position=?, id_ward=?, address=? " +
            "WHERE id = ?", nativeQuery = true)
    void updateEmployee(String name, Boolean gender, String birthday, String phone, Long idPosition, Long idWard, String address, Long id);

    @Query(value = "SELECT COUNT(email) FROM account WHERE NOT id =? and email = ?", nativeQuery = true)
    Integer findByEmailNot(Long id, String email);

    @Query(value = "SELECT COUNT(phone) FROM employee WHERE NOT id =? and phone = ?", nativeQuery = true)
    Integer findByPhoneNot(Long id, String phone);

    @Query(value = "SELECT COUNT(code) FROM employee WHERE NOT id =? and code = ?", nativeQuery = true)
    Integer findByCodeNot(Long id, String code);
}
