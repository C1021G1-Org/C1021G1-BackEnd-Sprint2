package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.repository.TicketRepository;
import com.example.carparkingmanagementbe.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    //    LongLT
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket findTicketById(Long id) {

        return ticketRepository.findByIdTicket(id);
    }
    @Override
    public void updateTicket(Long idLocation, Double sumPrice, Long idTicketType, String endDate, Long idTicket) {
        ticketRepository.updateTicket(idLocation, sumPrice, idTicketType, endDate, idTicket);
    }
//    LongLT
}
