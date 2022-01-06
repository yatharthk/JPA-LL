package com.keysoft.dao;

import com.keysoft.entity.Enhancement;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class EnhancementDao implements IEnhancementDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEnhancement(Enhancement enhancement) {
        entityManager.persist(enhancement);
    }
}
