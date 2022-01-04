package com.keysoft.services;

import com.keysoft.entity.Application;
import com.keysoft.entity.Release;

public interface IReleaseService {
    void addRelease(Release release);
    void addApplication(Integer appId,Integer releaseId);
}
