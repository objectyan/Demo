package com.baidu.navi.track.database;

import android.util.SparseArray;

public class DataCache
{
  private static DataCache mInstance;
  private int index = 0;
  private SparseArray<Object> mCacheArray = new SparseArray();
  
  public static DataCache getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataCache();
    }
    return mInstance;
  }
  
  public int addCache(Object paramObject)
  {
    if (this.mCacheArray == null) {
      return -1;
    }
    int i = this.index;
    this.index = (i + 1);
    this.mCacheArray.put(i, paramObject);
    return i;
  }
  
  public void clearAllCache()
  {
    if (this.mCacheArray != null) {
      this.mCacheArray.clear();
    }
  }
  
  public Object getCache(int paramInt)
  {
    if (this.mCacheArray == null) {
      return null;
    }
    return this.mCacheArray.get(paramInt);
  }
  
  public void removeCache(int paramInt)
  {
    if (this.mCacheArray == null) {
      return;
    }
    this.mCacheArray.remove(paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/track/database/DataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */