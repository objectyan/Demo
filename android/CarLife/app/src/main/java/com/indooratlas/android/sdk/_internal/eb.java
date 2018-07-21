package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.indooratlas.android.sensors.wifi.AbstractWifiScanSensor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class eb
  implements db
{
  public static final String a = eb.class.getSimpleName() + ".scanCacheSize";
  public static final String b = eb.class.getSimpleName() + ".getLatestScanResults";
  private static cw g = new de.a().a(-100).a();
  private static cw h = new de.a().a(-101).a();
  dz c;
  dy d;
  public final dw e = new dw();
  public Context f;
  private ea i;
  private WifiManager j;
  
  public eb(Context paramContext)
  {
    this(paramContext, (WifiManager)paramContext.getSystemService("wifi"), new ea.a());
  }
  
  private eb(Context paramContext, @NonNull WifiManager paramWifiManager, @NonNull ea paramea)
  {
    this.f = paramContext;
    this.i = paramea;
    this.j = paramWifiManager;
  }
  
  private void a(boolean paramBoolean, cy paramcy, cw paramcw, da paramda)
  {
    Object localObject = null;
    int k;
    int m;
    int n;
    int i1;
    for (;;)
    {
      dv localdv;
      synchronized (this.e)
      {
        k = this.e.a(g);
        m = this.e.a(h);
        if (paramBoolean)
        {
          localdv = this.e.a(paramcy, paramcw, paramda);
          paramcy = (cy)localObject;
          n = this.e.a(g);
          i1 = this.e.a(h);
          if (localdv != null)
          {
            localdv.a();
            paramda = paramda.b;
            if ((paramda != null) && (paramda.getBoolean(b, false))) {
              localdv.a(a(paramcw.a(), this.j.getScanResults()));
            }
          }
          if (paramcy == null) {
            break;
          }
          paramcy = paramcy.iterator();
          if (!paramcy.hasNext()) {
            break;
          }
          ((dv)paramcy.next()).b();
        }
      }
      if (paramcw == null)
      {
        paramcy = this.e.a(paramcy);
        localdv = null;
      }
      else
      {
        paramcy = this.e.a(paramcy, paramcw);
        localdv = null;
      }
    }
    if ((n > 0) && (n != k))
    {
      int i2 = this.e.a(-100);
      if (this.c == null) {
        this.c = new dz(this, this.j);
      }
      this.c.a(i2 / 1000);
    }
    if ((i1 > 0) && (m == 0))
    {
      if (this.d == null) {
        this.d = new dy(this, this.j);
      }
      this.d.a(0L);
    }
    if ((n == 0) && (k > 0)) {
      this.c.a();
    }
    if ((i1 == 0) && (m > 0)) {
      this.d.a();
    }
  }
  
  public final cw a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -100: 
      return g;
    }
    return h;
  }
  
  public final cx a(int paramInt, List<ScanResult> paramList)
  {
    Object localObject1;
    Object localObject2;
    if (paramList.isEmpty())
    {
      localObject1 = paramList;
      localObject2 = new cx();
      ((cx)localObject2).d = SystemClock.elapsedRealtime();
      if (paramInt != -100) {
        break label166;
      }
    }
    for (((cx)localObject2).a = g;; ((cx)localObject2).a = h)
    {
      ((cx)localObject2).c = dx.a((List)localObject1);
      if ((Build.VERSION.SDK_INT < 17) || (paramList.isEmpty())) {
        break label207;
      }
      ((cx)localObject2).b = ((ScanResult)paramList.get(0)).timestamp;
      return (cx)localObject2;
      localObject1 = new ArrayList(paramList.size());
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ScanResult localScanResult = (ScanResult)((Iterator)localObject2).next();
        if ((Build.VERSION.SDK_INT < 17) || (this.i.a(localScanResult) > 0)) {
          ((ArrayList)localObject1).add(localScanResult);
        }
      }
      break;
      label166:
      if (paramInt != -101) {
        break label183;
      }
    }
    label183:
    throw new IllegalArgumentException("Unknown sensor integer type: " + paramInt);
    label207:
    ((cx)localObject2).b = (SystemClock.elapsedRealtime() * 1000L);
    return (cx)localObject2;
  }
  
  public final List<cw> a()
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(g);
    localArrayList.add(h);
    return localArrayList;
  }
  
  public final List<cx> a(cw paramcw)
  {
    return null;
  }
  
  public final void a(cy paramcy)
  {
    a(false, paramcy, null, null);
  }
  
  public final void a(cy paramcy, cw paramcw)
  {
    a(false, paramcy, paramcw, null);
  }
  
  public final void a(cy paramcy, cw paramcw, da paramda)
  {
    a(true, paramcy, paramcw, paramda);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/eb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */