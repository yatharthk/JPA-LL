package com.keysoft.dao;

import com.keysoft.entity.Enhancement;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class EnhancementDao implements IEnhancementDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEnhancement(Enhancement enhancement) {
        entityManager.persist(enhancement);
    }

    @Override
    public List<Enhancement> getTicketsWithApps(){
        String nativeQuery = "Select t.id,t.description,t.status,a.app_name " +
                "From Applications a, Ticket t " +
                "where a.application_id = t.application_id and t.dtype = 'Bug'";

        //remove t.dtype='Bug' from query to get tickets associated with applications.
        return (List<Enhancement>) entityManager.createNativeQuery(nativeQuery).getResultList();
    }
}
