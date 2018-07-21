package com.indooratlas.android.sdk._internal;

import java.util.Date;

public final class hq
{
  public final gk a;
  public final gm b;
  
  private hq(gk paramgk, gm paramgm)
  {
    this.a = paramgk;
    this.b = paramgm;
  }
  
  public static boolean a(gm paramgm, gk paramgk)
  {
    switch (paramgm.c)
    {
    }
    do
    {
      return false;
    } while (((paramgm.a("Expires") == null) && (paramgm.h().e == -1) && (!paramgm.h().g) && (!paramgm.h().f)) || (paramgm.h().d) || (paramgk.f().d));
    return true;
  }
  
  public static final class a
  {
    public final long a;
    public final gk b;
    public final gm c;
    public Date d;
    public String e;
    public Date f;
    public String g;
    public Date h;
    public long i;
    public long j;
    public String k;
    public int l = -1;
    
    public a(long paramLong, gk paramgk, gm paramgm)
    {
      this.a = paramLong;
      this.b = paramgk;
      this.c = paramgm;
      if (paramgm != null)
      {
        paramgk = paramgm.f;
        int m = 0;
        int n = paramgk.a.length / 2;
        if (m < n)
        {
          paramgm = paramgk.a(m);
          String str = paramgk.b(m);
          if ("Date".equalsIgnoreCase(paramgm))
          {
            this.d = hu.a(str);
            this.e = str;
          }
          for (;;)
          {
            m += 1;
            break;
            if ("Expires".equalsIgnoreCase(paramgm))
            {
              this.h = hu.a(str);
            }
            else if ("Last-Modified".equalsIgnoreCase(paramgm))
            {
              this.f = hu.a(str);
              this.g = str;
            }
            else if ("ETag".equalsIgnoreCase(paramgm))
            {
              this.k = str;
            }
            else if ("Age".equalsIgnoreCase(paramgm))
            {
              this.l = hr.a(str, -1);
            }
            else if (hy.b.equalsIgnoreCase(paramgm))
            {
              this.i = Long.parseLong(str);
            }
            else if (hy.c.equalsIgnoreCase(paramgm))
            {
              this.j = Long.parseLong(str);
            }
          }
        }
      }
    }
    
    public static boolean a(gk paramgk)
    {
      return (paramgk.a("If-Modified-Since") != null) || (paramgk.a("If-None-Match") != null);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */