package cz.msebera.android.httpclient.i.c.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.a.g;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.e.f;
import cz.msebera.android.httpclient.e.t;
import cz.msebera.android.httpclient.i.c.ai;
import cz.msebera.android.httpclient.i.c.k;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Deprecated
@ThreadSafe
public class h
  implements c
{
  public cz.msebera.android.httpclient.h.b a;
  protected final cz.msebera.android.httpclient.e.c.j b;
  protected final a c;
  protected final e d;
  protected final cz.msebera.android.httpclient.e.e e;
  protected final g f;
  
  public h()
  {
    this(ai.a());
  }
  
  public h(cz.msebera.android.httpclient.e.c.j paramj)
  {
    this(paramj, -1L, TimeUnit.MILLISECONDS);
  }
  
  public h(cz.msebera.android.httpclient.e.c.j paramj, long paramLong, TimeUnit paramTimeUnit)
  {
    this(paramj, paramLong, paramTimeUnit, new g());
  }
  
  public h(cz.msebera.android.httpclient.e.c.j paramj, long paramLong, TimeUnit paramTimeUnit, g paramg)
  {
    cz.msebera.android.httpclient.o.a.a(paramj, "Scheme registry");
    this.a = new cz.msebera.android.httpclient.h.b(getClass());
    this.b = paramj;
    this.f = paramg;
    this.e = a(paramj);
    this.d = b(paramLong, paramTimeUnit);
    this.c = this.d;
  }
  
  @Deprecated
  public h(cz.msebera.android.httpclient.l.j paramj, cz.msebera.android.httpclient.e.c.j paramj1)
  {
    cz.msebera.android.httpclient.o.a.a(paramj1, "Scheme registry");
    this.a = new cz.msebera.android.httpclient.h.b(getClass());
    this.b = paramj1;
    this.f = new g();
    this.e = a(paramj1);
    this.d = ((e)a(paramj));
    this.c = this.d;
  }
  
  public int a(cz.msebera.android.httpclient.e.b.b paramb)
  {
    return this.d.c(paramb);
  }
  
  public cz.msebera.android.httpclient.e.c.j a()
  {
    return this.b;
  }
  
  protected cz.msebera.android.httpclient.e.e a(cz.msebera.android.httpclient.e.c.j paramj)
  {
    return new k(paramj);
  }
  
  public f a(cz.msebera.android.httpclient.e.b.b paramb, Object paramObject)
  {
    return new h.1(this, this.d.a(paramb, paramObject), paramb);
  }
  
  @Deprecated
  protected a a(cz.msebera.android.httpclient.l.j paramj)
  {
    return new e(this.e, paramj);
  }
  
  public void a(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.a.a()) {
      this.a.a("Closing connections idle longer than " + paramLong + " " + paramTimeUnit);
    }
    this.d.a(paramLong, paramTimeUnit);
  }
  
  public void a(cz.msebera.android.httpclient.e.b.b paramb, int paramInt)
  {
    this.f.a(paramb, paramInt);
  }
  
  public void a(t paramt, long paramLong, TimeUnit paramTimeUnit)
  {
    cz.msebera.android.httpclient.o.a.a(paramt instanceof d, "Connection class mismatch, connection not obtained from this manager");
    paramt = (d)paramt;
    boolean bool;
    if (paramt.z() != null)
    {
      if (paramt.w() != this) {
        break label58;
      }
      bool = true;
      cz.msebera.android.httpclient.o.b.a(bool, "Connection not obtained from this manager");
    }
    b localb;
    for (;;)
    {
      try
      {
        localb = (b)paramt.z();
        if (localb == null)
        {
          return;
          label58:
          bool = false;
          break;
        }
      }
      finally {}
      try
      {
        if ((paramt.c()) && (!paramt.q())) {
          paramt.f();
        }
        bool = paramt.q();
        if (this.a.a())
        {
          if (!bool) {
            break label140;
          }
          this.a.a("Released connection is reusable.");
        }
        paramt.u();
        this.d.a(localb, bool, paramLong, paramTimeUnit);
      }
      catch (IOException localIOException)
      {
        label140:
        if (!this.a.a()) {
          break label175;
        }
        this.a.a("Exception shutting down released connection.", localIOException);
        bool = paramt.q();
        if (!this.a.a()) {
          break label205;
        }
        if (!bool) {
          break label226;
        }
        this.a.a("Released connection is reusable.");
        for (;;)
        {
          paramt.u();
          this.d.a(localb, bool, paramLong, paramTimeUnit);
          break;
          this.a.a("Released connection is not reusable.");
        }
      }
      finally
      {
        bool = paramt.q();
        if (!this.a.a()) {
          break label270;
        }
        if (!bool) {
          break label291;
        }
        this.a.a("Released connection is reusable.");
      }
      return;
      this.a.a("Released connection is not reusable.");
    }
    for (;;)
    {
      label175:
      label205:
      label226:
      label270:
      paramt.u();
      this.d.a(localb, bool, paramLong, paramTimeUnit);
      throw ((Throwable)localObject);
      label291:
      this.a.a("Released connection is not reusable.");
    }
  }
  
  public int b(cz.msebera.android.httpclient.e.b.b paramb)
  {
    return this.f.a(paramb);
  }
  
  protected e b(long paramLong, TimeUnit paramTimeUnit)
  {
    return new e(this.e, this.f, 20, paramLong, paramTimeUnit);
  }
  
  public void b()
  {
    this.a.a("Closing expired connections");
    this.d.b();
  }
  
  public void b(int paramInt)
  {
    this.f.a(paramInt);
  }
  
  public void c()
  {
    this.a.a("Shutting down");
    this.d.d();
  }
  
  public int d()
  {
    return this.d.i();
  }
  
  public int e()
  {
    return this.d.k();
  }
  
  public int f()
  {
    return this.f.b();
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      c();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */