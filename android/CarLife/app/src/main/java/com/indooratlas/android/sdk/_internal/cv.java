package com.indooratlas.android.sdk._internal;

import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.util.Locale;

public final class cv
{
  public static long a(String paramString)
  {
    paramString = paramString.replaceAll(":", "").replaceAll("-", "").toLowerCase(Locale.US);
    if (paramString.length() != 12) {
      return -1L;
    }
    return Long.parseLong(paramString, 16);
  }
  
  public static boolean a(WifiManager paramWifiManager)
  {
    if (paramWifiManager == null) {}
    do
    {
      return false;
      if (Build.VERSION.SDK_INT < 18) {
        break;
      }
    } while ((!paramWifiManager.isWifiEnabled()) && (!paramWifiManager.isScanAlwaysAvailable()));
    return true;
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */