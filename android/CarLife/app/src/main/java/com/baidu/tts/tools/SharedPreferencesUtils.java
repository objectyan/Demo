package com.baidu.tts.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtils
{
  public static String PREFERENCE_NAME = "AndroidTTS";
  
  private SharedPreferencesUtils()
  {
    throw new AssertionError();
  }
  
  public static boolean getBoolean(Context paramContext, String paramString)
  {
    return getBoolean(paramContext, paramString, false);
  }
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences(PREFERENCE_NAME, 0).getBoolean(paramString, paramBoolean);
  }
  
  public static float getFloat(Context paramContext, String paramString)
  {
    return getFloat(paramContext, paramString, -1.0F);
  }
  
  public static float getFloat(Context paramContext, String paramString, float paramFloat)
  {
    return paramContext.getSharedPreferences(PREFERENCE_NAME, 0).getFloat(paramString, paramFloat);
  }
  
  public static int getInt(Context paramContext, String paramString)
  {
    return getInt(paramContext, paramString, -1);
  }
  
  public static int getInt(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences(PREFERENCE_NAME, 0).getInt(paramString, paramInt);
  }
  
  public static long getLong(Context paramContext, String paramString)
  {
    return getLong(paramContext, paramString, -1L);
  }
  
  public static long getLong(Context paramContext, String paramString, long paramLong)
  {
    return paramContext.getSharedPreferences(PREFERENCE_NAME, 0).getLong(paramString, paramLong);
  }
  
  public static String getString(Context paramContext, String paramString)
  {
    return getString(paramContext, paramString, null);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(PREFERENCE_NAME, 0).getString(paramString1, paramString2);
  }
  
  public static boolean putBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences(PREFERENCE_NAME, 0).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    return paramContext.commit();
  }
  
  public static boolean putFloat(Context paramContext, String paramString, float paramFloat)
  {
    paramContext = paramContext.getSharedPreferences(PREFERENCE_NAME, 0).edit();
    paramContext.putFloat(paramString, paramFloat);
    return paramContext.commit();
  }
  
  public static boolean putInt(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(PREFERENCE_NAME, 0).edit();
    paramContext.putInt(paramString, paramInt);
    return paramContext.commit();
  }
  
  public static boolean putLong(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences(PREFERENCE_NAME, 0).edit();
    paramContext.putLong(paramString, paramLong);
    return paramContext.commit();
  }
  
  public static boolean putString(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(PREFERENCE_NAME, 0).edit();
    paramContext.putString(paramString1, paramString2);
    return paramContext.commit();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/tools/SharedPreferencesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */