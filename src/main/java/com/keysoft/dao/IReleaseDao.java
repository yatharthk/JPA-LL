package com.keysoft.dao;

import com.keysoft.entity.Release;

public interface IReleaseDao {
    void addRelease(Release release);
    void addApplication(Integer appId, Integer releaseId);
}
