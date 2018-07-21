package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.Map;

public class PreferenceHelper
  implements PreferenceHelperConst
{
  private static PreferenceHelper mInstance;
  private SharedPreferences.Editor mEditor;
  private SharedPreferences mPreferences;
  
  private PreferenceHelper(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("navi", 0);
    this.mEditor = this.mPreferences.edit();
  }
  
  public static PreferenceHelper getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new PreferenceHelper(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public boolean contains(String paramString)
  {
    return this.mPreferences.contains(paramString);
  }
  
  public Map<String, ?> getAll()
  {
    return this.mPreferences.getAll();
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.mPreferences.getBoolean(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return this.mPreferences.getFloat(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.mPreferences.getInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.mPreferences.getLong(paramString, paramLong);
  }
  
  public SharedPreferences getPreferences()
  {
    return this.mPreferences;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.mPreferences.getString(paramString1, paramString2);
  }
  
  public boolean putBoolean(String paramString, boolean paramBoolean)
  {
    this.mEditor.putBoolean(paramString, paramBoolean);
    return this.mEditor.commit();
  }
  
  public boolean putFloat(String paramString, float paramFloat)
  {
    this.mEditor.putFloat(paramString, paramFloat);
    return this.mEditor.commit();
  }
  
  public boolean putInt(String paramString, int paramInt)
  {
    this.mEditor.putInt(paramString, paramInt);
    return this.mEditor.commit();
  }
  
  public boolean putLong(String paramString, long paramLong)
  {
    this.mEditor.putLong(paramString, paramLong);
    return this.mEditor.commit();
  }
  
  public boolean putString(String paramString1, String paramString2)
  {
    this.mEditor.putString(paramString1, paramString2);
    return this.mEditor.commit();
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.mPreferences.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public boolean remove(String paramString)
  {
    this.mEditor.remove(paramString);
    return this.mEditor.commit();
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    this.mPreferences.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/PreferenceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */