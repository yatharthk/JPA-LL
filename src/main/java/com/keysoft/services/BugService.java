package com.keysoft.services;

import com.keysoft.dao.IBugDao;
import com.keysoft.entity.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugService implements IBugService{

    @Autowired
    private IBugDao bugDao;

    @Override
    public void addBug(Bug bug) {
        bugDao.addBug(bug);
    }
}
