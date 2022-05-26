package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

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

}
