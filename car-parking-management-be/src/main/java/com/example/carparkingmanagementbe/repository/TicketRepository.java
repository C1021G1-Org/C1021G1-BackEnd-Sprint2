package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Long> {

//    LongLT

    @Query(value = "select ticket.id, ticket.code, ticket.start_date,ticket.end_date, ticket.img_car_in, ticket.img_car_out,\n" +
            "            ticket.sum_price, ticket.time_in, ticket.time_out, ticket.is_doing, ticket.id_car, ticket.id_location, ticket.id_ticket_type, ticket.del_flag\n" +
            "            from ticket where ticket.id = ? ", nativeQuery = true)
    Ticket findByIdTicket(Long id);

    @Modifying
    @Query(value = "update ticket " +
            "join location on ticket.id_location = location.id " +
            "join ticket_type on ticket_type.id = ticket.id_ticket_type " +
            "join car on ticket.id_car = car.id " +
            "set ticket.id_location = :idLocation, " +
            "ticket.sum_price = :sumPrice, " +
            "ticket.id_ticket_type = :idTicketType, " +
            "ticket.end_date = :endDate " +
            "where ticket.id = :idTicket ",nativeQuery = true)
    void updateTicket(@Param("idLocation")Long idLocation,
                      @Param("sumPrice")Double sumPrice,
                      @Param("idTicketType")Long idTicketType,
                      @Param("endDate")String endDate,
                      @Param("idTicket")Long idTicket );
//    LongLT
}
