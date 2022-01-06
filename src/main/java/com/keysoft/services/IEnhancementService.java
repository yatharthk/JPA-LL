package com.keysoft.services;

import com.keysoft.entity.Enhancement;

import java.util.List;

public interface IEnhancementService {
    void addEnhancement(Enhancement enhancement);

    List<Enhancement> getTicketsWithApps();
}
