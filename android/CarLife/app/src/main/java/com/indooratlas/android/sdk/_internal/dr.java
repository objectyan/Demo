package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.location.LocationManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dr
  implements db
{
  final dw a = new dw();
  private final cw b = new de.a().a(65236).a();
  private final cw c = new de.a().a(65235).a();
  private final cw d = new de.a().a(65234).a();
  private final dp e;
  private final dp f;
  private final dp g;
  
  public dr(Context paramContext)
  {
    paramContext = (LocationManager)paramContext.getSystemService("location");
    this.e = new dp(paramContext, "gps", this.b, this);
    this.f = new dp(paramContext, "network", this.c, this);
    this.g = new dp(paramContext, "passive", this.d, this);
  }
  
  private void a(boolean paramBoolean, cy paramcy, cw paramcw, da paramda)
  {
    Object localObject = null;
    int i;
    int j;
    int k;
    for (;;)
    {
      synchronized (this.a)
      {
        i = this.a.a(this.b);
        j = this.a.a(this.c);
        k = this.a.a(this.d);
        if (paramBoolean)
        {
          paramcw = this.a.a(paramcy, paramcw, paramda);
          paramcy = (cy)localObject;
          if (paramcw != null) {
            paramcw.a();
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
        paramcy = this.a.a(paramcy);
        paramcw = null;
      }
      else
      {
        paramcy = this.a.a(paramcy, paramcw);
        paramcw = null;
      }
    }
    int m = this.a.a(this.b);
    int n = this.a.a(this.c);
    int i1 = this.a.a(this.d);
    int i2 = this.a.b(this.b);
    int i3 = this.a.b(this.c);
    this.e.a(i, m, i2 / 1000);
    this.f.a(j, n, i3 / 1000);
    this.g.a(k, i1, 0);
  }
  
  public final cw a(int paramInt)
  {
    if (paramInt == this.b.a()) {
      return this.b;
    }
    if (paramInt == this.c.a()) {
      return this.c;
    }
    if (paramInt == this.d.a()) {
      return this.d;
    }
    return null;
  }
  
  public final List<cw> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.b);
    localArrayList.add(this.c);
    localArrayList.add(this.d);
    return localArrayList;
  }
  
  public final List<cx> a(cw paramcw)
  {
    ArrayList localArrayList = new ArrayList();
    cx localcx = null;
    if (paramcw.a() == 65236) {
      localcx = this.e.a();
    }
    for (;;)
    {
      if (localcx != null) {
        localArrayList.add(localcx);
      }
      return localArrayList;
      if (paramcw.a() == 65235) {
        localcx = this.f.a();
      } else if (paramcw.a() == 65234) {
        localcx = this.g.a();
      }
    }
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */