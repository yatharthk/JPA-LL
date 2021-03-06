package com.keysoft.dao;

import com.keysoft.entity.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class TicketDao implements ITicketDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ticket getTicketById(Integer id) {
        Ticket ticket = entityManager.find(Ticket.class,id);
        return ticket;
    }

    @Override
    public List<Ticket> getAllTickets() {
        //Note ticket is a class name ; not the table name;
        //class name is case-sensitive; use field names - column names
        String selectQuery = "Select t from Ticket t order by t.title";
        Query query =  entityManager.createQuery(selectQuery);
        return (List<Ticket>) query.getResultList();

    }

    @Override
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);

    }

    @Override
    public void updateTicket(Ticket ticket) {
        Ticket ticket1 = getTicketById(ticket.getId());
        ticket1.setDescription(ticket.getDescription());
        ticket1.setApplication(ticket.getApplication());
        ticket1.setTitle(ticket.getTitle());

        entityManager.flush();
    }

    @Override
    public void deleteTicket(Integer id) {
        entityManager.remove(getTicketById(id));
    }

    @Override
    public void closeTicket(Integer id) {
     Ticket ticket = getTicketById(id);
     ticket.setStatus("Resolved");
    }
}
