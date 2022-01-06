package com.keysoft.services;

import com.keysoft.dao.IEnhancementDao;
import com.keysoft.entity.Enhancement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnhancementService implements IEnhancementService{

    @Autowired
    private IEnhancementDao enhancementDao;

    @Override
    public void addEnhancement(Enhancement enhancement) {
        enhancementDao.addEnhancement(enhancement);
    }
}
