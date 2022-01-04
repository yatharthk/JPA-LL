package com.keysoft.dao;

import com.keysoft.entity.Application;
import org.apache.tomcat.util.descriptor.web.ApplicationParameter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ApplicationDao  implements  IApplicationDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addApplication(Application application) {
        entityManager.persist(application);
    }

    @Override
    public boolean applicationExists(String applicationName, String owner) {

        //Note : application is the class name: not the table name;
        //class name is case-sensitive; use class field names -column names

        String jpql = "from Application as a where a.name=?0 and a.owner = ?1";
        Query query = entityManager.createQuery(jpql);
        int count= entityManager.createQuery(jpql).setParameter(0,applicationName).setParameter(1,owner).
                getResultList().size();
        return count >0;
    }

    @Override
    public Application getApplicationById(Integer id) {
        Application application = entityManager.find(Application.class,id);
        return  application;
    }

    @Override
    public Application updateApplication(Application application) {
        Application tempApplication = getApplicationById(application.getId());
        tempApplication.setName(application.getName());
        tempApplication.setDescription(application.getDescription());
        tempApplication.setOwner(application.getOwner());
        //entityManager.persist(tempApplication);
        entityManager.flush();
        return  application;
    }

    @Override
    public void deleteApplicationById(Integer id) {
        Application application = getApplicationById(id);
        entityManager.remove(application);
    }
}
