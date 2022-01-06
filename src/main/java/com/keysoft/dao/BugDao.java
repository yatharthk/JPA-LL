package com.keysoft.dao;

import com.keysoft.entity.Bug;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BugDao implements IBugDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBug(Bug bug) {
        entityManager.persist(bug);
    }

    @Override
    public List<Bug> getSevereBugs() {
        //named query method starts with the DTO/Entity name + dot + name for query
        return (List<Bug>)entityManager.createNamedQuery("Bug.findSevereBugs").getResultList();
    }
}
