package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class dg
  implements db
{
  Handler a;
  df b;
  long c;
  final List<dh> d = new ArrayList();
  private final Context e;
  private cw f;
  private final dw g = new dw();
  private final Runnable h = new Runnable()
  {
    public final void run()
    {
      if (dg.this.b().a)
      {
        dg.this.c();
        dg.a(dg.this);
      }
    }
  };
  
  public dg(@NonNull Context paramContext)
  {
    this.e = paramContext;
    if ((this.e.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) && (Build.VERSION.SDK_INT >= 18))
    {
      this.f = new de.a().a(65336).a();
      this.a = new Handler();
      return;
    }
    paramContext = cz.a;
    new StringBuilder("Device doesn't have BLE support, Android version=").append(Build.VERSION.SDK_INT);
  }
  
  private void a(boolean paramBoolean, cy paramcy, cw arg3, da paramda)
  {
    Object localObject = null;
    if (this.f == null) {
      return;
    }
    int i;
    int j;
    synchronized (this.g)
    {
      i = this.g.a(this.f);
      if (paramBoolean)
      {
        ??? = this.g.a(paramcy, ???, paramda);
        paramcy = (cy)localObject;
        j = this.g.a(this.f);
        if (??? != null) {
          ???.a();
        }
        if ((j <= 0) || (j == i)) {
          break label192;
        }
      }
    }
    for (;;)
    {
      synchronized (this.d)
      {
        this.d.clear();
        b().a();
        d();
        if (paramcy == null) {
          break label247;
        }
        paramcy = paramcy.iterator();
        if (!paramcy.hasNext()) {
          break label247;
        }
        ((dv)paramcy.next()).b();
        continue;
        paramcy = finally;
        throw paramcy;
        if (??? == null)
        {
          paramcy = this.g.a(paramcy);
          ??? = null;
          break;
        }
        paramcy = this.g.a(paramcy, ???);
        ??? = null;
      }
      label192:
      if ((j == 0) && (i > 0))
      {
        b().b();
        synchronized (this.d)
        {
          this.d.clear();
          this.a.removeCallbacks(this.h);
        }
      }
    }
    label247:
  }
  
  private void d()
  {
    long l = this.g.a(65336) / 1000;
    if (l >= 100L) {}
    for (;;)
    {
      this.c = l;
      if (this.a != null)
      {
        this.a.removeCallbacks(this.h);
        if ((b().a) && (this.c >= 100L)) {
          this.a.postDelayed(this.h, this.c);
        }
      }
      return;
      l = 0L;
    }
  }
  
  public final cw a(int paramInt)
  {
    if (paramInt == 65336) {
      return this.f;
    }
    return null;
  }
  
  public final List<cw> a()
  {
    ArrayList localArrayList = new ArrayList(1);
    if (this.f != null) {
      localArrayList.add(this.f);
    }
    return localArrayList;
  }
  
  public final List<cx> a(cw paramcw)
  {
    return null;
  }
  
  public final void a(cy paramcy)
  {
    eg.a(paramcy, "listener cannot be null", new Object[0]);
    a(false, paramcy, null, null);
  }
  
  public final void a(cy paramcy, cw paramcw)
  {
    eg.a(paramcy, "listener cannot be null", new Object[0]);
    eg.a(paramcw, "sensor cannot be null", new Object[0]);
    a(false, paramcy, paramcw, null);
  }
  
  public final void a(cy paramcy, cw paramcw, da paramda)
  {
    eg.a(paramcy, "listener cannot be null", new Object[0]);
    eg.a(paramcw, "sensor cannot be null", new Object[0]);
    eg.a(paramda, "params cannot be null", new Object[0]);
    a(true, paramcy, paramcw, paramda);
  }
  
  final df b()
  {
    if (this.b == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label39;
      }
    }
    label39:
    for (this.b = new dj(aq.a(this.e), this);; this.b = new dk(aq.a(this.e), this)) {
      return this.b;
    }
  }
  
  final void c()
  {
    cx localcx1 = new cx();
    CopyOnWriteArrayList localCopyOnWriteArrayList;
    synchronized (this.d)
    {
      if (this.d.isEmpty()) {
        return;
      }
      Object localObject = this.d;
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        localCopyOnWriteArrayList.add((dh)((Iterator)localObject).next());
      }
    }
    localcx2.c = localCopyOnWriteArrayList;
    long l = ((dh)this.d.get(0)).j;
    this.d.clear();
    localcx2.a = this.f;
    localcx2.d = SystemClock.elapsedRealtime();
    localcx2.b = l;
    this.g.a(localcx2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */