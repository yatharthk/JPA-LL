package com.keysoft.services;

import com.keysoft.dao.ITicketDao;
import com.keysoft.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private ITicketDao ticketDao;

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketDao.getTicketById(id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketDao.addTicket(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketDao.updateTicket(ticket);
    }

    @Override
    public void deleteTicket(Integer id) {
        ticketDao.deleteTicket(id);
    }

    @Override
    public void closeTicket(Integer id) {
        ticketDao.closeTicket(id);
    }

    @Override
    public List<Ticket> findTicketsByReleaseId(int releaseId) {
        return ticketDao.findByReleaseId(releaseId);
    }
}
