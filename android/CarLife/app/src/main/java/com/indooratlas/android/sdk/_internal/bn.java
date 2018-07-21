package com.indooratlas.android.sdk._internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.indooratlas.algorithm.ClientProcessingManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class bn
{
  dd a;
  bf b;
  cz c;
  cw[] d;
  da[] e;
  cw f;
  cw g;
  cw h;
  ClientProcessingManager i;
  private long j;
  private long k;
  
  bn(bf parambf, cz paramcz, ClientProcessingManager paramClientProcessingManager)
  {
    this.b = parambf;
    this.c = paramcz;
    this.i = paramClientProcessingManager;
    this.a = new dd();
  }
  
  private void h()
  {
    if ((this.g != null) && (this.k > 0L) && (f() > 0L)) {
      i();
    }
  }
  
  private void i()
  {
    if (this.g != null)
    {
      long l = this.b.j.b.optLong("bleScanMaxNotifyInterval", 1000L);
      cz localcz = this.c;
      dd localdd = this.a;
      cw localcw = this.g;
      da.a locala = new da.a();
      locala.a = this.b.a.b;
      locala.c = ((int)(l * 1000L));
      localcz.a(localdd, localcw, locala.b());
    }
  }
  
  public final void a()
  {
    this.i.startPositioning();
    d();
    if (this.f != null)
    {
      cz localcz = this.c;
      dd localdd = this.a;
      cw localcw = this.f;
      da.a locala = new da.a();
      locala.a = this.b.a.b;
      String str = eb.b;
      locala.a();
      locala.b.putBoolean(str, true);
      str = eb.a;
      locala.a();
      locala.b.putInt(str, 500);
      localcz.a(localdd, localcw, locala.b());
    }
    h();
    if (this.h != null) {
      this.c.a(this.a, this.h, new da.a().b());
    }
  }
  
  public final void a(long paramLong)
  {
    if (this.g == null) {
      return;
    }
    this.k = paramLong;
    if (paramLong > 0L)
    {
      this.j = SystemClock.elapsedRealtime();
      i();
      return;
    }
    g();
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.g == null) {
      return;
    }
    if (paramBoolean)
    {
      h();
      return;
    }
    g();
  }
  
  public final void b()
  {
    e();
    if (this.f != null) {
      this.c.a(this.a, this.f);
    }
    g();
    if (this.h != null) {
      this.c.a(this.a, this.h);
    }
    this.i.stopPositioning();
  }
  
  public final void c()
  {
    Object localObject2 = this.c;
    dd localdd = this.a;
    synchronized (((cz)localObject2).b)
    {
      localObject2 = ((cz)localObject2).b.iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((db)((Iterator)localObject2).next()).a(localdd);
      }
    }
  }
  
  final void d()
  {
    int n = this.d.length;
    int m = 0;
    while (m < n)
    {
      cw localcw = this.d[m];
      da localda = this.e[m];
      this.c.a(this.a, localcw, localda);
      localcw.a();
      m += 1;
    }
  }
  
  final void e()
  {
    cw[] arrayOfcw = this.d;
    int n = arrayOfcw.length;
    int m = 0;
    while (m < n)
    {
      cw localcw = arrayOfcw[m];
      this.c.a(this.a, localcw);
      localcw.a();
      m += 1;
    }
  }
  
  protected final long f()
  {
    return this.k - (SystemClock.elapsedRealtime() - this.j);
  }
  
  protected final void g()
  {
    if (this.g != null) {
      this.c.a(this.a, this.g);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */