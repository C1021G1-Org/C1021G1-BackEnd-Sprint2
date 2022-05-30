package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.repository.TicketRepository;
import com.example.carparkingmanagementbe.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void checking(Boolean isChecking) {
        ticketRepository.checking(isChecking);
    }

    @Override
    public void createTicket(Ticket ticket) {
//        ticketRepository.createTicket(ticket.getCode(),ticket.getDelFlag(),ticket.getEndDate(),
//                ticket.getImgCarIn(),ticket.getImgCarOut(),ticket.getIsDoing(),ticket.getStartDate() ,ticket.getSumPrice(),
//                ticket.getTimeIn(),ticket.getTimeOut(),ticket.getCar(),ticket.getLocation(),
//                ticket.getTicketType());
        ticketRepository.save(ticket);
    }
}
