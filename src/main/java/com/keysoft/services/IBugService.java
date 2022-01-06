package com.keysoft.services;

import com.keysoft.entity.Bug;

import java.util.List;

public interface IBugService {
    void addBug(Bug bug);

    List<Bug> getSevereBugs();
}
