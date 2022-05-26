package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    /*TuanPDCoding*/
    @Query(value = "SELECT  location.id, location.code, location.description,\n" +
            "\t\tlocation.width, location.is_empty, location.number,\n" +
            "\t\tlocation.height, location.length, location.del_flag,\n" +
            "\t\tfloor.name, customer.name,\n" +
            "\t\tcustomer.phone, customer.birthday, customer.email,\n" +
            "\t\tcar_type.name, car.car_company, car.name, car.car_plate\n" +
            "FROM location\n" +
            "\tJOIN floor on floor.id = location.id_floor\n" +
            "\tJOIN ticket on ticket.id_location = location.id\n" +
            "\tJOIN car on ticket.id_car = car.id\n" +
            "\tJOIN car_type on car_type.id = car.id_car_type\n" +
            "\tJOIN customer on customer.id = car.id_customer\n" +
            "WHERE location.id = ? ", nativeQuery = true)
    Location findLocationById(Long id);

    @Modifying
    @Query(value = "UPDATE location SET\n" +
            "       location.height = ?," +
            "       location.length = ?,\n" +
            "       location.width = ?\n" +
            "       WHERE location.id  = ?", nativeQuery = true)
    void editLocationById(Double height, Double length, Double width, Long id);
    /*TuanPDCoding*/
}
