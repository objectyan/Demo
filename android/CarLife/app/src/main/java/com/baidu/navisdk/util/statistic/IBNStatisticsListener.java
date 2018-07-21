package com.baidu.navisdk.util.statistic;

import android.content.Context;

public abstract interface IBNStatisticsListener
{
  public abstract void onEvent(Context paramContext, String paramString1, String paramString2);
  
  public abstract void onEvent(String paramString1, String paramString2);
  
  public abstract void onEventDuration(Context paramContext, String paramString1, String paramString2, int paramInt);
  
  public abstract void onEventDuration(String paramString1, String paramString2, int paramInt);
  
  public abstract void onEventEnd(Context paramContext, String paramString1, String paramString2);
  
  public abstract void onEventStart(Context paramContext, String paramString1, String paramString2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/IBNStatisticsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */