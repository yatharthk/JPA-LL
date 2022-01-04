package com.keysoft.dao;

import com.keysoft.entity.Application;

public interface IApplicationDAO {
   void addApplication(Application application);
   boolean applicationExists(String applicationName,String owner);

   Application getApplicationById(Integer id);

   Application updateApplication(Application application);

    void deleteApplicationById(Integer id);
}
