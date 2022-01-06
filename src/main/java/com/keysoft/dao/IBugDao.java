package com.keysoft.dao;

import com.keysoft.entity.Bug;

import java.util.List;

public interface IBugDao {
    void addBug(Bug bug);

    List<Bug> getSevereBugs();
}
