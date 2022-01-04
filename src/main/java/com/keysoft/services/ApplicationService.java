package com.keysoft.services;

import com.keysoft.dao.IApplicationDAO;
import com.keysoft.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements IApplicationService{

    @Autowired
    private IApplicationDAO applicationDAO;

    @Override
    public boolean addApplication(Application application) {
        if(applicationDAO.applicationExists(application.getName(),application.getOwner())){
            return  false;
        } else {
            applicationDAO.addApplication(application);
            return  true;
        }
    }

    @Override
    public Application getApplicationById(int id) {
        return applicationDAO.getApplicationById(id);
    }

    @Override
    public Application updateApplication(Application application) {
        return  applicationDAO.updateApplication(application);
    }

    @Override
    public void deleteApplicationById(int id) {
        applicationDAO.deleteApplicationById(id);
    }
}
