package com.baidu.navisdk.util.statistic;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.baidu.navisdk.BNaviModuleManager;

public class MemStat
{
  ActivityManager mActivityMan;
  int[] mPid = { Process.myPid() };
  
  private MemStat()
  {
    if (BNaviModuleManager.getContext() != null) {
      this.mActivityMan = ((ActivityManager)BNaviModuleManager.getContext().getSystemService("activity"));
    }
  }
  
  public static MemStat getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public int getProfileVal()
  {
    if ((this.mActivityMan == null) && (BNaviModuleManager.getContext() != null))
    {
      this.mPid = new int[] { Process.myPid() };
      this.mActivityMan = ((ActivityManager)BNaviModuleManager.getContext().getSystemService("activity"));
    }
    if (this.mActivityMan == null) {
      return 0;
    }
    try
    {
      Debug.MemoryInfo localMemoryInfo = this.mActivityMan.getProcessMemoryInfo(this.mPid)[0];
      if (localMemoryInfo == null) {
        return 0;
      }
      int i = localMemoryInfo.getTotalPss();
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  private static class LazyHolder
  {
    private static MemStat sInstance = new MemStat(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/MemStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */