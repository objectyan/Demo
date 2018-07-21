package com.baidu.location.indoor;

import android.os.Handler;
import com.baidu.location.BDLocation;

public class i
{
  private a a;
  private long b = 450L;
  private BDLocation c;
  private b d = null;
  private b e = null;
  private b f = new b();
  private b g = new b();
  private b h = new b();
  private b i = new b();
  private long j = -1L;
  private boolean k = false;
  private Handler l = new Handler();
  private Runnable m = new Runnable()
  {
    public void run()
    {
      Object localObject = i.a(i.this, i.a(i.this));
      if ((localObject != null) && (i.b(i.this) != null))
      {
        i.b(i.this, i.a(i.this).b((i.b)localObject));
        long l = System.currentTimeMillis();
        if ((!((i.b)localObject).b(2.0E-6D)) && (l - i.c(i.this) > i.d(i.this)))
        {
          localObject = new BDLocation(i.e(i.this));
          ((BDLocation)localObject).setLatitude(i.a(i.this).a);
          ((BDLocation)localObject).setLongitude(i.a(i.this).b);
          i.b(i.this).a((BDLocation)localObject);
          i.a(i.this, l);
        }
      }
      i.g(i.this).postDelayed(i.f(i.this), 450L);
    }
  };
  
  private b a(b paramb)
  {
    if ((this.d == null) || (paramb == null)) {
      return null;
    }
    b localb1 = this.d.a(paramb);
    this.i = this.i.b(localb1);
    paramb = this.h.a(this.f);
    this.f = new b(this.h);
    this.h = new b(localb1);
    localb1 = localb1.a(0.2D);
    b localb2 = this.i.a(0.01D);
    paramb = paramb.a(-0.02D);
    return localb1.b(localb2).b(paramb);
  }
  
  public void a()
  {
    if (!this.k) {
      return;
    }
    this.k = false;
    this.l.removeCallbacks(this.m);
    b();
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(BDLocation paramBDLocation)
  {
    try
    {
      double d1 = paramBDLocation.getLatitude();
      double d2 = paramBDLocation.getLongitude();
      this.c = paramBDLocation;
      this.d = new b(d1, d2);
      if (this.e == null) {
        this.e = new b(d1, d2);
      }
      return;
    }
    finally
    {
      paramBDLocation = finally;
      throw paramBDLocation;
    }
  }
  
  public void a(a parama)
  {
    if (this.k) {
      return;
    }
    this.k = true;
    this.a = parama;
    this.l.postDelayed(this.m, 450L);
  }
  
  public void b()
  {
    this.j = -1L;
    this.e = null;
    this.d = null;
    this.f = new b();
    this.g = new b();
    this.h = new b();
    this.i = new b();
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public static abstract interface a
  {
    public abstract void a(BDLocation paramBDLocation);
  }
  
  private class b
  {
    public double a;
    public double b;
    
    public b()
    {
      this.a = 0.0D;
      this.b = 0.0D;
    }
    
    public b(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
    
    public b(b paramb)
    {
      this.a = paramb.a;
      this.b = paramb.b;
    }
    
    public b a(double paramDouble)
    {
      return new b(i.this, this.a * paramDouble, this.b * paramDouble);
    }
    
    public b a(b paramb)
    {
      return new b(i.this, this.a - paramb.a, this.b - paramb.b);
    }
    
    public b b(b paramb)
    {
      return new b(i.this, this.a + paramb.a, this.b + paramb.b);
    }
    
    public boolean b(double paramDouble)
    {
      double d1 = Math.abs(this.a);
      double d2 = Math.abs(this.b);
      return (d1 > 0.0D) && (d1 < paramDouble) && (d2 > 0.0D) && (d2 < paramDouble);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */