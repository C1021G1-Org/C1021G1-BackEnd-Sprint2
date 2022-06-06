package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService {


    // tam begin
    Page<Ticket> findAll(Pageable pageable);
    Page<Ticket> searchTicketPage(String floor,
                                  String ticketTypeName,
                                  String endDate,
                                  String nameCustomer,
                                  String phoneCustomer,
                                  Pageable pageable);
    void deleteTicketByDel(Long idTicket);

    Ticket getTicketById(Long idTicket);

    void updateUserEmail(String userEmail,Long idTicket);

    Ticket getTicketAction(Long idTicket,String userEmail);

    void updateNullUser(Long idTicket);
    // tam end


    //    LongLT
    Ticket findTicketById(Long id);

    void updateTicket(Long idLocation,
                      Double sumPrice,
                      Long idTicketType,
                      String endDate,
                      Long idTicket );
//    LongLT End

}