package com.baidu.carlife.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.baidu.carlife.BaiduNaviApplication;
import java.util.HashMap;
import java.util.Map;

public class p
{
  private static final String a = "PreferenceUtil";
  private static p b = null;
  private SharedPreferences c = null;
  private SharedPreferences.Editor d = null;
  private Context e = null;
  private Map<String, Boolean> f = new HashMap();
  
  public static p a()
  {
    if (b == null)
    {
      b = new p();
      b.a(BaiduNaviApplication.getInstance().getApplicationContext());
    }
    return b;
  }
  
  private void a(Context paramContext)
  {
    this.e = paramContext;
    this.c = this.e.getSharedPreferences("CarLife_Temp", 0);
    this.d = this.c.edit();
  }
  
  public float a(String paramString, float paramFloat)
  {
    return this.c.getFloat(paramString, paramFloat);
  }
  
  public int a(String paramString, int paramInt)
  {
    return this.c.getInt(paramString, paramInt);
  }
  
  public long a(String paramString, long paramLong)
  {
    return this.c.getLong(paramString, paramLong);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.c.getString(paramString1, paramString2);
  }
  
  public void a(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.c.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public boolean a(String paramString)
  {
    return this.c.contains(paramString);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    return this.c.getBoolean(paramString, paramBoolean);
  }
  
  public SharedPreferences b()
  {
    return this.c;
  }
  
  public void b(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.c.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public boolean b(String paramString)
  {
    return this.c.contains(paramString);
  }
  
  public boolean b(String paramString, float paramFloat)
  {
    this.d.putFloat(paramString, paramFloat);
    return this.d.commit();
  }
  
  public boolean b(String paramString, int paramInt)
  {
    this.d.putInt(paramString, paramInt);
    return this.d.commit();
  }
  
  public boolean b(String paramString, long paramLong)
  {
    this.d.putLong(paramString, paramLong);
    return this.d.commit();
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    this.d.putString(paramString1, paramString2);
    return this.d.commit();
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    if (this.f.containsKey(paramString)) {
      return ((Boolean)this.f.get(paramString)).booleanValue();
    }
    paramBoolean = this.c.getBoolean(paramString, paramBoolean);
    this.f.put(paramString, Boolean.valueOf(paramBoolean));
    return paramBoolean;
  }
  
  public Map<String, ?> c()
  {
    return this.c.getAll();
  }
  
  public boolean c(String paramString)
  {
    this.d.remove(paramString);
    return this.d.commit();
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    this.d.putBoolean(paramString, paramBoolean);
    return this.d.commit();
  }
  
  public boolean d(String paramString, boolean paramBoolean)
  {
    this.d.putBoolean(paramString, paramBoolean);
    this.f.put(paramString, Boolean.valueOf(paramBoolean));
    return this.d.commit();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */