package com.indooratlas.android.sdk;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.indooratlas.android.sdk._internal.az.a;

public abstract class IALocationManager
{
  public static final int CALIBRATION_EXCELLENT = 2;
  public static final int CALIBRATION_GOOD = 1;
  public static final int CALIBRATION_POOR = 0;
  public static final String EXTRA_API_KEY = "com.indooratlas.android.sdk.intent.extras.apiKey";
  public static final String EXTRA_API_SECRET = "com.indooratlas.android.sdk.intent.extras.apiSecret";
  public static final String EXTRA_LOCATION = "com.indooratlas.android.sdk.intent.extras.location";
  public static final String EXTRA_PROXY_ADDRESS = "com.indooratlas.android.sdk.intent.extras.proxyAddress";
  public static final String EXTRA_PROXY_DISABLED = "com.indooratlas.android.sdk.intent.extras.proxyDisabled";
  public static final String EXTRA_PROXY_PORT = "com.indooratlas.android.sdk.intent.extras.proxyPort";
  public static final int STATUS_AVAILABLE = 2;
  public static final int STATUS_CALIBRATION_CHANGED = 11;
  public static final int STATUS_LIMITED = 10;
  public static final int STATUS_OUT_OF_SERVICE = 0;
  public static final int STATUS_TEMPORARILY_UNAVAILABLE = 1;
  
  public static IALocationManager create(@NonNull Context paramContext)
  {
    try
    {
      paramContext = new az.a(paramContext).a();
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static IALocationManager create(@NonNull Context paramContext, @android.support.annotation.Nullable android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 47	com/indooratlas/android/sdk/_internal/az$a
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 50	com/indooratlas/android/sdk/_internal/az$a:<init>	(Landroid/content/Context;)V
    //   11: astore_0
    //   12: aload_1
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: new 59	android/os/Bundle
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 62	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   25: putfield 66	com/indooratlas/android/sdk/_internal/az$a:b	Landroid/os/Bundle;
    //   28: aload_0
    //   29: invokevirtual 54	com/indooratlas/android/sdk/_internal/az$a:a	()Lcom/indooratlas/android/sdk/_internal/az;
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 66	com/indooratlas/android/sdk/_internal/az$a:b	Landroid/os/Bundle;
    //   43: goto -15 -> 28
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramContext	Context
    //   0	52	1	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   3	12	46	finally
    //   16	28	46	finally
    //   28	33	46	finally
    //   38	43	46	finally
  }
  
  @Deprecated
  public static String getVersion()
  {
    return "2.4.2";
  }
  
  public abstract void destroy();
  
  @NonNull
  public abstract IAExtraInfo getExtraInfo();
  
  public abstract boolean registerOrientationListener(@NonNull IAOrientationRequest paramIAOrientationRequest, @NonNull IAOrientationListener paramIAOrientationListener);
  
  public abstract boolean registerRegionListener(@NonNull IARegion.Listener paramListener);
  
  public abstract void removeLocationUpdates(@NonNull PendingIntent paramPendingIntent);
  
  public abstract boolean removeLocationUpdates(@NonNull IALocationListener paramIALocationListener);
  
  public abstract void requestLocationUpdates(@NonNull IALocationRequest paramIALocationRequest, @NonNull PendingIntent paramPendingIntent);
  
  public abstract boolean requestLocationUpdates(@NonNull IALocationRequest paramIALocationRequest, @NonNull IALocationListener paramIALocationListener);
  
  public abstract boolean requestLocationUpdates(@NonNull IALocationRequest paramIALocationRequest, @NonNull IALocationListener paramIALocationListener, Looper paramLooper);
  
  public abstract void setLocation(@NonNull IALocation paramIALocation);
  
  public abstract boolean unregisterOrientationListener(@NonNull IAOrientationListener paramIAOrientationListener);
  
  public abstract boolean unregisterRegionListener(@NonNull IARegion.Listener paramListener);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/indooratlas/android/sdk/IALocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */