package com.keysoft.dao;

import com.keysoft.entity.Enhancement;

import java.util.List;

public interface IEnhancementDao {
    void addEnhancement(Enhancement enhancement);
    public List<Enhancement> getTicketsWithApps();
}
