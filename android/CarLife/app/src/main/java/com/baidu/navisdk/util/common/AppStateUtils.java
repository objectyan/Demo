package com.baidu.navisdk.util.common;

import java.util.ArrayList;
import java.util.List;

public class AppStateUtils
{
  private static AppStateUtils sInstance = null;
  private List<AppStateListener> mAppStateListener = new ArrayList();
  private boolean mIsForeground = true;
  private int mPhoneStatus = 0;
  
  public static AppStateUtils getInstance()
  {
    if (sInstance == null) {
      sInstance = new AppStateUtils();
    }
    return sInstance;
  }
  
  public void addAppStateListener(AppStateListener paramAppStateListener)
  {
    if ((paramAppStateListener != null) && (!this.mAppStateListener.contains(paramAppStateListener))) {
      this.mAppStateListener.add(paramAppStateListener);
    }
  }
  
  public int getPhoneStatus()
  {
    return this.mPhoneStatus;
  }
  
  public boolean isForeground()
  {
    return this.mIsForeground;
  }
  
  public void removeAppStateListener(AppStateListener paramAppStateListener)
  {
    if ((paramAppStateListener != null) && (this.mAppStateListener.contains(paramAppStateListener))) {
      this.mAppStateListener.remove(paramAppStateListener);
    }
  }
  
  public void setForeground(boolean paramBoolean)
  {
    this.mIsForeground = paramBoolean;
    int i = 0;
    if (i < this.mAppStateListener.size())
    {
      AppStateListener localAppStateListener = (AppStateListener)this.mAppStateListener.get(i);
      if (this.mIsForeground) {}
      for (int j = 1;; j = 0)
      {
        localAppStateListener.onAppStateChanged(1, j, 0, null);
        i += 1;
        break;
      }
    }
  }
  
  public void setPhoneStatus(int paramInt)
  {
    this.mPhoneStatus = paramInt;
  }
  
  public static abstract interface AppStateListener
  {
    public static final int State_Type_Fore_Back_Changed = 1;
    
    public abstract void onAppStateChanged(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/AppStateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */