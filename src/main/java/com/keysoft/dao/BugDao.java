package com.keysoft.dao;

import com.keysoft.entity.Bug;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class BugDao implements IBugDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBug(Bug bug) {
        entityManager.persist(bug);
    }
}
