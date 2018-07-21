package com.baidu.navisdk.util.cache;

import com.baidu.navisdk.logic.RspData;
import java.io.Serializable;

public abstract interface Cacheable
{
  public abstract RspData deserializeCache(Serializable paramSerializable);
  
  public abstract String getCacheKey();
  
  public abstract Serializable serializeCache(RspData paramRspData);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/cache/Cacheable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */