package com.indooratlas.android.sdk._internal;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IARegion;

public final class cp
{
  static
  {
    if (!cp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static IARegion a(fc.a parama, long paramLong)
  {
    if (parama == null) {
      return null;
    }
    if (parama.b != null)
    {
      parama = parama.b;
      if (TextUtils.isEmpty(parama.d)) {
        return IARegion.unknown();
      }
    }
    switch (parama.b)
    {
    default: 
      int i = parama.b;
      parama = parama.d;
      return IARegion.unknown();
    case 1: 
      return new IARegion(1, paramLong, parama.d, parama.e);
    }
    return new IARegion(2, paramLong, parama.d, parama.e);
  }
  
  public static ew.a a(IARegion paramIARegion)
  {
    if (paramIARegion == null) {
      return null;
    }
    ew.a locala = new ew.a();
    locala.d = paramIARegion.getId();
    switch (paramIARegion.getType())
    {
    default: 
      return null;
    }
    for (locala.b = 1;; locala.b = 2) {
      return locala;
    }
  }
  
  public static final String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 0: 
      return "UNKNOWN";
    case 3: 
      return "SYSTEM";
    case 2: 
      return "REST_OVER_WS";
    case 4: 
      return "EVENTS";
    }
    return "POSITIONING";
  }
  
  public static final String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return String.valueOf(paramInt2);
      return "UNKNOWN";
      switch (paramInt2)
      {
      default: 
        switch (paramInt2)
        {
        default: 
          switch (paramInt2)
          {
          default: 
            switch (paramInt2)
            {
            }
            break;
          }
          break;
        }
        break;
      }
    }
    return "UNKNOWN";
    return "COMPONENT_ERROR";
    return "UNKNOWN";
    return "REST_ERROR";
    return "REST_REQUEST";
    return "REST_RESPONSE";
    return "UNKNOWN";
    return "METRICS";
    return "ALTER";
    return "ERROR";
    return "INPUT";
    return "INPUT_SERVER_MODE";
    return "STATE";
    return "STATE_REQUEST";
    return "OUTPUT";
    return "SETUP";
    return "STOP";
  }
  
  public static boolean a(fc.c paramc)
  {
    return (paramc != null) && (paramc.b != null) && (paramc.b.b != null);
  }
  
  public static ey.b[] a(IALocation... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    ey.b[] arrayOfb = new ey.b[paramVarArgs.length];
    int i = 0;
    if (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      ey.b localb = new ey.b();
      if (((IALocation)localObject).hasFloorLevel())
      {
        localb.k = new h();
        localb.k.b = ((IALocation)localObject).getFloorLevel();
      }
      localObject = ((IALocation)localObject).toLocation();
      if (((Location)localObject).hasAccuracy()) {
        localb.f = ((Location)localObject).getAccuracy();
      }
      if (((Location)localObject).hasAltitude())
      {
        localb.g = new g();
        localb.g.b = ((float)((Location)localObject).getAltitude());
      }
      if (((Location)localObject).hasBearing()) {
        localb.i = ((Location)localObject).getBearing();
      }
      if (((Location)localObject).hasSpeed())
      {
        localb.h = new g();
        localb.h.b = ((Location)localObject).getSpeed();
      }
      if ((((Location)localObject).getLatitude() != 0.0D) || (((Location)localObject).getLongitude() != 0.0D))
      {
        localb.b = new ey.a();
        localb.b.b = ((Location)localObject).getLatitude();
        localb.b.d = ((Location)localObject).getLongitude();
      }
      localb.e = ((Location)localObject).getTime();
      Bundle localBundle = ((Location)localObject).getExtras();
      if ((localBundle != null) && (localBundle.containsKey("com.indooratlas.android.sdk.intent.extras.clientTime"))) {
        localb.d = localBundle.getLong("com.indooratlas.android.sdk.intent.extras.clientTime");
      }
      if ((localBundle != null) && (localBundle.containsKey("com.indooratlas.android.sdk.intent.extras.satelliteCount")))
      {
        localb.l = new h();
        localb.l.b = localBundle.getInt("com.indooratlas.android.sdk.intent.extras.satelliteCount");
      }
      localObject = ((Location)localObject).getProvider();
      if ("IndoorAtlas".equals(localObject)) {
        localb.j = 0;
      }
      for (;;)
      {
        arrayOfb[i] = localb;
        i += 1;
        break;
        if ("gps".equals(localObject))
        {
          localb.j = 4;
        }
        else if ("network".equals(localObject))
        {
          localb.j = 5;
        }
        else if ("passive".equals(localObject))
        {
          localb.j = 1;
        }
        else if ("fused".equalsIgnoreCase((String)localObject))
        {
          localb.j = 1;
        }
        else if ("com.indooratlas.android.sdk.intent.extras.groundTruth".equals(localObject))
        {
          localb.j = 3;
        }
        else if ("com.indooratlas.android.sdk.intent.extras.userInput".equals(localObject))
        {
          localb.j = 2;
        }
        else
        {
          ee.a("IACore", "Unknown provider in IALocation: " + (String)localObject, new Object[0]);
          localb.j = 2;
        }
      }
    }
    return arrayOfb;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */