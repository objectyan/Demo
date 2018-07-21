package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

public final class ej
{
  @TargetApi(17)
  public static long a()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return System.nanoTime();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */