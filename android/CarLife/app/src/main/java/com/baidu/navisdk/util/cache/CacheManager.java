package com.baidu.navisdk.util.cache;

import com.baidu.navisdk.logic.RspData;
import java.io.Serializable;

public abstract interface CacheManager
{
  public abstract void clear();
  
  public abstract void delete(Cacheable paramCacheable);
  
  public abstract CacheResult get(Cacheable paramCacheable);
  
  public abstract CacheResult get(Cacheable paramCacheable, long paramLong);
  
  public abstract void put(Cacheable paramCacheable, RspData paramRspData, Serializable paramSerializable);
  
  public static class CacheResult
  {
    public Serializable extraData;
    public boolean isExpired;
    public RspData msg;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/cache/CacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */