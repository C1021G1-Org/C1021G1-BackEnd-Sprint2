package com.example.carparkingmanagementbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carparkingmanagementbe.model.Car;
import org.springframework.data.jpa.repository.Modifying;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    //TrongHD thêm mới xe
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Car(code,name,car_plate,car_company,id_customer,id_car_type,del_flag)" +
            " VALUES(?1,?2,?3,?4,?5,?6, ?7) ", nativeQuery = true)
    void createCar(String code, String name, String carPlate, String carCompany,
                      Long idCustomer, Long idCarType, Boolean delFlag);

    //    tronghd lấy giá trị validate trùng nhau
    @Query(value = "select count(code) from car where code = ?", nativeQuery = true)
    Integer finByCodeCar(String code);

    //    tronghd lấy giá trị validate trùng nhau
    @Query(value = "select count(car_plate) from car where car_plate = ?", nativeQuery = true)
    Integer finByCarPlate(String carPlate);

    //BaoND lấy thông tin xe
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
            "where customer.id = ? and car.del_flag = 1;",nativeQuery = true)
    List<Car> selectCustomerAndCar(Long id);

    //TrongHD lấy thông tin khách hàng
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
    List<Car> findByIdCustomer(Long id);

}
