package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.AllowedCarParking;
import com.example.carparkingmanagementbe.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.example.carparkingmanagementbe.dto.LocationList;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    /*Find By Id Dùng Chung*/
    @Query(value = "SELECT location.id, location.code, location.description, " +
            " location.width, location.is_empty, location.number, " +
            " location.height, location.length, location.del_flag, " +
            " floor.name, customer.name, location.id_floor, " +
            " customer.phone, customer.birthday, customer.email, " +
            " car_type.name, car.car_company, car.name, car.car_plate " +
            "FROM location " +
            " JOIN floor on floor.id = location.id_floor " +
            " JOIN ticket on ticket.id_location = location.id " +
            " JOIN car on ticket.id_car = car.id " +
            " JOIN car_type on car_type.id = car.id_car_type " +
            " JOIN customer on customer.id = car.id_customer " +
            "WHERE location.id = ? ", nativeQuery = true)
    Location findLocationById(Long id);
    /*Find By Id Dùng Chung*/

    /*TuanPDCoding*/
    @Modifying
    @Query(value = "UPDATE location SET\n" +
            "       location.height = ?," +
            "       location.length = ?,\n" +
            "       location.width = ?\n" +
            "       WHERE location.id  = ?", nativeQuery = true)
    void editLocationById(Double height, Double length, Double width, Long id);

    @Modifying
    @Query(value = "INSERT INTO location" +
            "(location.code, location.number, location.del_flag, location.is_empty, location.height, location.length," +
            " location.width, location.description, location.id_floor) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
    void createLocation(String code, Long number, Boolean del_flag, Boolean is_empty,
                        Double height, Double length, Double width, String description, Long id_floor);

    @Modifying
    @Query(value = "UPDATE location_allowed_car_parking SET \n" +
            " location.id = ?" +
            " allow_car_parking_id\n" +
            "WHERE location.id = ?", nativeQuery = true)
    void editAllowParkingById(Long id, Set<AllowedCarParking> allowCarParking);

    @Modifying
    @Query(value = "INSERT INTO location_allowed_car_parking \n" +
            "(location_id, allowed_car_parking_id) \n" +
            "VALUES (LAST_INSERT_ID(), ?1)", nativeQuery = true)
    void createAllowParking(Long id_floor, Set<AllowedCarParking> allowCarParking);
    /*TuanPDCoding*/

    /*TinhHDCoding*/
    @Transactional
    @Query(value = "SELECT location.id,location.code,location.id_floor as floorId , floor.name as floorName FROM location JOIN floor on  location.id_floor = floor.id where location.code like %?1% and id_floor like %?2%  and location.del_flag = 1", nativeQuery = true)
    List<LocationList> findByList(String code, String id);
   /*TinhHDCoding*/
}
