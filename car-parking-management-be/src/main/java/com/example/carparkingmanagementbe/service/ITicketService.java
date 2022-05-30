package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.Ticket;

public interface ITicketService {
    void createTicket(Ticket ticket);
    void updateTicket(Ticket ticket);

    void checking(Boolean isChecking);
}
