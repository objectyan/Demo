package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class ed
{
  @TargetApi(21)
  public static String a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {}
    do
    {
      return null;
      if (Build.VERSION.SDK_INT >= 12) {
        return paramBundle.getString(paramString, null);
      }
      paramBundle = paramBundle.getString(paramString);
    } while (paramBundle == null);
    return paramBundle;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */