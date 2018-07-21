package com.baidu.navi.favorite.database;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AppFavorite
{
  private FavoriteDao mFavoriteDao = null;
  private AtomicInteger mUseCounter = new AtomicInteger();
  
  public boolean add(String paramString1, String paramString2)
  {
    return this.mFavoriteDao.add(paramString1, paramString2);
  }
  
  public boolean addAll(Map<String, String> paramMap)
  {
    return this.mFavoriteDao.addAll(paramMap);
  }
  
  public boolean clear()
  {
    return this.mFavoriteDao.clear();
  }
  
  public void create()
  {
    if (this.mUseCounter.incrementAndGet() == 1) {
      this.mFavoriteDao = new FavoriteDao(FavoriteDataBaseManager.getInstance().openDataBase());
    }
  }
  
  public void destory()
  {
    if (this.mUseCounter.decrementAndGet() == 0)
    {
      FavoriteDataBaseManager.getInstance().closeDataBase();
      this.mFavoriteDao = null;
    }
  }
  
  public List<String> getAllKey()
  {
    return this.mFavoriteDao.getAllKey();
  }
  
  public String getValue(String paramString)
  {
    return this.mFavoriteDao.getValue(paramString);
  }
  
  public boolean isExist(String paramString)
  {
    return this.mFavoriteDao.isExist(paramString);
  }
  
  public boolean remove(String paramString)
  {
    return this.mFavoriteDao.remove(paramString);
  }
  
  public boolean removeAll(List<String> paramList)
  {
    return this.mFavoriteDao.removeAll(paramList);
  }
  
  public boolean update(String paramString1, String paramString2)
  {
    return this.mFavoriteDao.update(paramString1, paramString2);
  }
  
  public boolean updateAll(Map<String, String> paramMap)
  {
    return this.mFavoriteDao.updateAll(paramMap);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/database/AppFavorite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */