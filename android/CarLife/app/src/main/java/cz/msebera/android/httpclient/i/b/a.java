package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.e.b.b;
import java.util.HashMap;
import java.util.Map;

public class a
  implements cz.msebera.android.httpclient.b.d
{
  private final cz.msebera.android.httpclient.m.d<b> a;
  private final l b;
  private final Map<b, Long> c;
  private final Map<b, Long> d;
  private long e = 5000L;
  private double f = 0.5D;
  private int g = 2;
  
  public a(cz.msebera.android.httpclient.m.d<b> paramd)
  {
    this(paramd, new av());
  }
  
  a(cz.msebera.android.httpclient.m.d<b> paramd, l paraml)
  {
    this.b = paraml;
    this.a = paramd;
    this.c = new HashMap();
    this.d = new HashMap();
  }
  
  private Long a(Map<b, Long> paramMap, b paramb)
  {
    paramb = (Long)paramMap.get(paramb);
    paramMap = paramb;
    if (paramb == null) {
      paramMap = Long.valueOf(0L);
    }
    return paramMap;
  }
  
  private int b(int paramInt)
  {
    if (paramInt <= 1) {
      return 1;
    }
    return (int)Math.floor(this.f * paramInt);
  }
  
  public void a(double paramDouble)
  {
    if ((paramDouble > 0.0D) && (paramDouble < 1.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.a.a(bool, "Backoff factor must be 0.0 < f < 1.0");
      this.f = paramDouble;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    cz.msebera.android.httpclient.o.a.a(paramInt, "Per host connection cap");
    this.g = paramInt;
  }
  
  public void a(long paramLong)
  {
    cz.msebera.android.httpclient.o.a.a(this.e, "Cool down");
    this.e = paramLong;
  }
  
  public void a(b paramb)
  {
    synchronized (this.a)
    {
      int i = this.a.b(paramb);
      Long localLong = a(this.d, paramb);
      long l = this.b.a();
      if (l - localLong.longValue() < this.e) {
        return;
      }
      this.a.a(paramb, b(i));
      this.d.put(paramb, Long.valueOf(l));
      return;
    }
  }
  
  public void b(b paramb)
  {
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        i = this.a.b(paramb);
        if (i >= this.g)
        {
          i = this.g;
          Long localLong1 = a(this.c, paramb);
          Long localLong2 = a(this.d, paramb);
          long l = this.b.a();
          if ((l - localLong1.longValue() < this.e) || (l - localLong2.longValue() < this.e)) {
            return;
          }
          this.a.a(paramb, i);
          this.c.put(paramb, Long.valueOf(l));
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */