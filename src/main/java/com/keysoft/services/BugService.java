package com.keysoft.services;

import com.keysoft.dao.IBugDao;
import com.keysoft.entity.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugService implements IBugService{

    @Autowired
    private IBugDao bugDao;

    @Override
    public void addBug(Bug bug) {
        bugDao.addBug(bug);
    }

    @Override
    public List<Bug> getSevereBugs() {
        return bugDao.getSevereBugs();
    }
}
