package com.baidu.navisdk.comapi.base;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

public class BNSubject
{
  private static final String TAG = "Common";
  protected BNObserver mObserver;
  protected final ArrayList<BNObserver> mObservers = new ArrayList();
  
  public void addObserver(BNObserver paramBNObserver)
  {
    if (paramBNObserver == null)
    {
      LogUtil.e("Common", "The BNObserver is null when addObserver");
      return;
    }
    synchronized (this.mObservers)
    {
      if (this.mObservers.contains(paramBNObserver))
      {
        LogUtil.e("Common", "BNObserver " + paramBNObserver + " is already added.");
        return;
      }
    }
    this.mObservers.add(paramBNObserver);
    LogUtil.e("BNSubject", "add " + this.mObservers.size() + " " + paramBNObserver);
  }
  
  public void deleteAllObserver()
  {
    LogUtil.e("BNSubject", "delete all");
    this.mObservers.clear();
  }
  
  public void deleteObserver(BNObserver paramBNObserver)
  {
    if (paramBNObserver == null) {
      LogUtil.e("Common", "The BNObserver is null.");
    }
    do
    {
      return;
      int i;
      synchronized (this.mObservers)
      {
        i = this.mObservers.indexOf(paramBNObserver);
        if (i == -1)
        {
          LogUtil.e("Common", "BNObserver " + paramBNObserver + " was not added.");
          return;
        }
      }
      LogUtil.e("BNSubject", "delete " + this.mObservers.size() + " " + paramBNObserver);
      this.mObservers.remove(i);
    } while ((this.mObserver == null) || (!this.mObserver.equals(paramBNObserver)));
    LogUtil.e("BNSubject", "remove " + paramBNObserver);
    this.mObserver = null;
  }
  
  public void notifyObservers(int paramInt1, int paramInt2, Object paramObject)
  {
    try
    {
      int i = this.mObservers.size() - 1;
      while ((i >= 0) && (this.mObservers.get(i) != null))
      {
        ((BNObserver)this.mObservers.get(i)).update(this, paramInt1, paramInt2, paramObject);
        i -= 1;
      }
      if (this.mObserver != null) {
        this.mObserver.update(this, paramInt1, paramInt2, paramObject);
      }
      return;
    }
    finally {}
  }
  
  public void setObserver(BNObserver paramBNObserver)
  {
    this.mObserver = paramBNObserver;
    LogUtil.e("BNSubject", "set " + paramBNObserver);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/base/BNSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */