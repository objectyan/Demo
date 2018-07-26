package com.baidu.navisdk.util.cache;

import com.baidu.navisdk.logic.RspData;
import java.io.Serializable;

public interface Cacheable {
    RspData deserializeCache(Serializable serializable);

    String getCacheKey();

    Serializable serializeCache(RspData rspData);
}
