package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Ticket;

public interface ITicketService {

    //    LongLT
    Ticket findTicketById(Long id);

    void updateTicket(Long idLocation,
                      Double sumPrice,
                      Long idTicketType,

                      String endDate,
                      Long idTicket );
//    LongLT End
}
