package com.baidu.navisdk.util.cache;

import com.baidu.navisdk.logic.RspData;
import java.io.Serializable;

public interface CacheManager {

    public static class CacheResult {
        public Serializable extraData;
        public boolean isExpired;
        public RspData msg;
    }

    void clear();

    void delete(Cacheable cacheable);

    CacheResult get(Cacheable cacheable);

    CacheResult get(Cacheable cacheable, long j);

    void put(Cacheable cacheable, RspData rspData, Serializable serializable);
}
