package com.indooratlas.android.sdk._internal;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;

public final class dp
  implements LocationListener
{
  private final LocationManager a;
  private final String b;
  private final cw c;
  private final dr d;
  private boolean e;
  
  public dp(LocationManager paramLocationManager, String paramString, cw paramcw, dr paramdr)
  {
    this.a = paramLocationManager;
    this.b = paramString;
    this.c = paramcw;
    this.d = paramdr;
    this.e = false;
  }
  
  public final cx a()
  {
    try
    {
      Object localObject = this.a.getLastKnownLocation(this.b);
      if (localObject != null)
      {
        cx localcx = new cx();
        localcx.d = SystemClock.elapsedRealtime();
        localcx.a = this.c;
        localObject = dq.a((Location)localObject);
        localcx.c = localObject;
        localcx.b = ((dq)localObject).i;
        return localcx;
      }
      return null;
    }
    catch (SecurityException localSecurityException) {}
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (paramInt2 != paramInt1) {
      if (paramInt1 > 0)
      {
        paramInt1 = 1;
        if (paramInt2 > 0) {
          paramInt2 = i;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 != 0) {}
      try
      {
        this.a.removeUpdates(this);
        this.e = false;
        if (paramInt2 == 0) {}
      }
      catch (SecurityException localSecurityException1)
      {
        for (;;)
        {
          try
          {
            String str = cz.a;
            this.a.requestLocationUpdates(this.b, paramInt3, 0.0F, this);
            this.e = true;
            return;
          }
          catch (SecurityException localSecurityException2)
          {
            ee.a(cz.a, "Could not request updates dues to security exception for " + this.b, new Object[0]);
            return;
          }
          localSecurityException1 = localSecurityException1;
          ee.a(cz.a, "Could not remove updates dues to security exception for " + this.b, new Object[0]);
        }
      }
      paramInt2 = 0;
      continue;
      paramInt1 = 0;
      break;
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    if (this.e)
    {
      dr localdr = this.d;
      cw localcw = this.c;
      paramLocation = dq.a(paramLocation);
      cx localcx = new cx();
      localcx.d = SystemClock.elapsedRealtime();
      localcx.a = localcw;
      localcx.b = paramLocation.i;
      localcx.c = paramLocation;
      localdr.a.a(localcx);
    }
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */