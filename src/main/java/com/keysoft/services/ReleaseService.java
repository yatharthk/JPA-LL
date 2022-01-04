package com.keysoft.services;

import com.keysoft.dao.IReleaseDao;
import com.keysoft.entity.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseService implements IReleaseService {

    @Autowired
    private IReleaseDao releaseDao;

    @Override
    public void addRelease(Release release) {
        releaseDao.addRelease(release);
    }

    @Override
    public void addApplication(Integer appId, Integer releaseId) {
        releaseDao.addApplication(appId,releaseId);
    }
}
