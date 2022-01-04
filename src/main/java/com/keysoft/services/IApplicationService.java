package com.keysoft.services;

import com.keysoft.entity.Application;

public interface IApplicationService {
    boolean addApplication(Application application);

    Application getApplicationById(int id);

    Application updateApplication(Application application);

    void deleteApplicationById(int id);
}
