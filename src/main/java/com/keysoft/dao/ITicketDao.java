package com.keysoft.dao;

import com.keysoft.entity.Ticket;

import java.util.List;

public interface ITicketDao {
    public Ticket getTicketById(Integer id);

    public List<Ticket> getAllTickets();

    public void addTicket(Ticket ticket);

    public void updateTicket(Ticket ticket);

    public void deleteTicket(Integer id);

    public void closeTicket(Integer id);
}
