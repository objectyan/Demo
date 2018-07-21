package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import java.util.List;

public enum ao
{
  private int e;
  
  private ao(int paramInt)
  {
    this.e = paramInt;
  }
  
  public static ao a(int paramInt)
  {
    ao[] arrayOfao = values();
    int j = arrayOfao.length;
    int i = 0;
    while (i < j)
    {
      ao localao = arrayOfao[i];
      if (localao.e == paramInt) {
        return localao;
      }
      i += 1;
    }
    return b;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getRunningServices(Integer.MAX_VALUE);
        int i = 0;
        while ((paramContext != null) && (i < paramContext.size()))
        {
          boolean bool = "com.baidu.bottom.service.BottomService".equals(((ActivityManager.RunningServiceInfo)paramContext.get(i)).service.getClassName());
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramContext)
      {
        db.a(paramContext);
      }
    }
  }
  
  public abstract void a(Context paramContext);
  
  public String toString()
  {
    return String.valueOf(this.e);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */