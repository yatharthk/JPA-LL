package com.keysoft.services;

import com.keysoft.entity.Ticket;

import java.util.List;

public interface ITicketService {
    Ticket getTicketById(Integer id);

    List<Ticket> getAllTickets();

    void addTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    void deleteTicket(Integer id);

    void closeTicket(Integer id);
}
