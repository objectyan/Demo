package com.baidu.speech.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class PreferenceSetting
{
  private static final String FILE_NAME = "bdvrsetting";
  private static final String FILE_NAME_MD5 = Util.toMd5("bdvrsetting".getBytes(), false);
  private static final String VTLN_KEY = "vtln";
  private static final int VTLN_LIMIT = 255;
  private static final String VTLN_SECRET_KEY = "BDVRVtln*!Secret";
  
  public static boolean getBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences(FILE_NAME_MD5, 0).getBoolean(paramString, paramBoolean);
  }
  
  public static String getString(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences(FILE_NAME_MD5, 0).getString(paramString1, paramString2);
  }
  
  public static int getVtlnWithCheckSum(Context paramContext)
  {
    int j = -1;
    paramContext = getString(paramContext, "vtln", "");
    int i = j;
    if (paramContext.indexOf("||") != -1)
    {
      Object localObject = paramContext.split("\\|\\|");
      i = j;
      if (localObject.length >= 2)
      {
        paramContext = localObject[1];
        localObject = localObject[0];
        i = j;
        if (Util.toMd5(((String)localObject + "BDVRVtln*!Secret").getBytes(), false).equals(paramContext)) {
          i = Integer.parseInt((String)localObject);
        }
      }
    }
    return i;
  }
  
  public static void removeString(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences(FILE_NAME_MD5, 0).edit().remove(paramString).commit();
  }
  
  public static void setBoolean(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext.getSharedPreferences(FILE_NAME_MD5, 0).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static void setString(Context paramContext, String paramString1, String paramString2)
  {
    paramContext.getSharedPreferences(FILE_NAME_MD5, 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static boolean setVtlnWithCheckSum(Context paramContext, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 255)) {
      return false;
    }
    String str = Util.toMd5((paramInt + "BDVRVtln*!Secret").getBytes(), false);
    setString(paramContext, "vtln", paramInt + "||" + str);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/utils/PreferenceSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */