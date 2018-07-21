package com.indooratlas.android.sdk._internal;

import android.location.Location;
import android.os.Bundle;

public final class dq
{
  public int a;
  public String b;
  public double c;
  public double d;
  public float e;
  public double f;
  public float g;
  public float h;
  public long i;
  public Integer j = null;
  
  public static dq a(Location paramLocation)
  {
    int k = 0;
    Object localObject = paramLocation.getProvider();
    if (((String)localObject).equals("gps")) {
      k = 65236;
    }
    if (((String)localObject).equals("network")) {
      k = 65235;
    }
    localObject = new dq();
    ((dq)localObject).a = k;
    ((dq)localObject).b = paramLocation.getProvider();
    ((dq)localObject).c = paramLocation.getLatitude();
    ((dq)localObject).d = paramLocation.getLongitude();
    ((dq)localObject).e = paramLocation.getAccuracy();
    ((dq)localObject).f = paramLocation.getAltitude();
    ((dq)localObject).g = paramLocation.getBearing();
    ((dq)localObject).h = paramLocation.getSpeed();
    ((dq)localObject).i = paramLocation.getTime();
    paramLocation = paramLocation.getExtras();
    if ((paramLocation != null) && (paramLocation.containsKey("satellites")) && ((paramLocation.get("satellites") instanceof Integer))) {
      ((dq)localObject).j = Integer.valueOf(paramLocation.getInt("satellites"));
    }
    return (dq)localObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */