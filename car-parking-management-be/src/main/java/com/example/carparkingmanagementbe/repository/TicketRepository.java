package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Ticket(code, " +
            "del_flag, " +
            "end_date, " +
            "img_car_in, " +
            "img_car_out, " +
            "is_doing, " +
            "start_date, " +
            "sum_price, " +
            "time_in, " +
            "time_out, " +
            "id_car, " +
            "id_location, " +
            "id_ticket_type, ) " +
            " VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13) ", nativeQuery = true)
    void createTicket( String code, Boolean delFlag, String startDate , String imgCarIn,
                      String imgCarOut, Boolean isDoing, String endDate , Double sumPrice, String timeIn,
                      String timeOut, Car car, Location location, TicketType ticketType);


    @Modifying
    @Query(value = "update ticket " +
            "join car on car.id = ticket.id_car " +
            "set ticket.time_in = ?1 " +
            "set ticket.time_out = ?2 " +
            "where car.car_plate = ticket.id_car",nativeQuery = true)
    void updateTicket(String timeIn, String timeOut);


    @Modifying
    @Query(value = "update ticket " +
            "set ticket.is_doing = ?1 " +
            "where car.car_plate = ticket.id_car",nativeQuery = true)
    void checking(Boolean isChecking);


}
