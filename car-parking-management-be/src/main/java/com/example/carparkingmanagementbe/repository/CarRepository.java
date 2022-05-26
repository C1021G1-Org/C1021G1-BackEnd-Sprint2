package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query(value = "select car.id," +
            "car.car_company," +
            "car.car_plate," +
            "car.`code`," +
            "car.`name`," +
            "car.id_car_type," +
            "car.id_customer," +
            "car.id_employee," +
            "customer.address," +
            "customer.account_id," +
            "customer.birthday," +
            "customer.`code`," +
            "customer.email," +
            "customer.gender," +
            "customer.id_card," +
            "customer.`name`," +
            "customer.phone," +
            "customer.del_flag," +
            "customer.id_ward " +
            "from car " +
            "join customer " +
            "on car.id_customer = customer.id " +
            "where customer.id = ?;",nativeQuery = true)
    List<Car> selectCustomerAndCar(Long id);
}
