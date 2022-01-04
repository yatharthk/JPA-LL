package com.keysoft.dao;

import com.keysoft.entity.Application;
import com.keysoft.entity.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ReleaseDao implements IReleaseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IApplicationDAO applicationDAO;

    @Override
    public void addRelease(Release release) {
        entityManager.persist(release);
    }

    public Release getReleaseById(Integer releaseId){
        return entityManager.find(Release.class,releaseId);
    }

    @Override
    public void addApplication(Integer appId, Integer releaseId) {
        Release release = getReleaseById(releaseId);
        Application application = applicationDAO.getApplicationById(appId);
        release.addApplication(application);
        entityManager.flush();
    }
}

