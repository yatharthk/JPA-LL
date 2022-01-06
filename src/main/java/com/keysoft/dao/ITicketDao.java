package com.keysoft.dao;

import com.keysoft.entity.Ticket;

import java.util.List;

public interface ITicketDao {
     Ticket getTicketById(Integer id);

     List<Ticket> getAllTickets();

     void addTicket(Ticket ticket);

     void updateTicket(Ticket ticket);

     void deleteTicket(Integer id);

     void closeTicket(Integer id);

    List<Ticket> findByReleaseId(int releaseId);
}
