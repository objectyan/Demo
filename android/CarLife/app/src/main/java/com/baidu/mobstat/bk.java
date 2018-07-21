package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

abstract class bk
{
  public int a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext).getInt(paramString, paramInt);
  }
  
  public long a(Context paramContext, String paramString, long paramLong)
  {
    return a(paramContext).getLong(paramString, paramLong);
  }
  
  public abstract SharedPreferences a(Context paramContext);
  
  public String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).getString(paramString1, paramString2);
  }
  
  public boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(paramContext).getBoolean(paramString, paramBoolean);
  }
  
  public void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext).edit().putInt(paramString, paramInt).commit();
  }
  
  public void b(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext).edit().putLong(paramString, paramLong).commit();
  }
  
  public void b(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext).edit().putString(paramString1, paramString2).commit();
  }
  
  public void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public void g(Context paramContext, String paramString)
  {
    a(paramContext).edit().remove(paramString).commit();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */