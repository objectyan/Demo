package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface eu
{
  public static final class a
    extends c<a>
  {
    public eu.b[] b = eu.b.d();
    public int d = 0;
    public boolean e = false;
    public boolean f = false;
    public a[] g = a.d();
    
    public a()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int m = 0;
      int j = super.a();
      int i = j;
      Object localObject;
      if (this.b != null)
      {
        i = j;
        if (this.b.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.b.length)
          {
            localObject = this.b[j];
            k = i;
            if (localObject != null) {
              k = i + b.c(1, (m)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.d != 0) {
        j = i + b.e(2, this.d);
      }
      int k = j;
      if (this.e) {
        k = j + (b.d(3) + 1);
      }
      i = k;
      if (this.f) {
        i = k + (b.d(4) + 1);
      }
      k = i;
      if (this.g != null)
      {
        k = i;
        if (this.g.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.g.length) {
              break;
            }
            localObject = this.g[j];
            k = i;
            if (localObject != null) {
              k = i + b.c(5, (m)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.b != null) && (this.b.length > 0))
      {
        i = 0;
        while (i < this.b.length)
        {
          localObject = this.b[i];
          if (localObject != null) {
            paramb.a(1, (m)localObject);
          }
          i += 1;
        }
      }
      if (this.d != 0) {
        paramb.b(2, this.d);
      }
      if (this.e) {
        paramb.a(3, this.e);
      }
      if (this.f) {
        paramb.a(4, this.f);
      }
      if ((this.g != null) && (this.g.length > 0))
      {
        i = j;
        while (i < this.g.length)
        {
          localObject = this.g[i];
          if (localObject != null) {
            paramb.a(5, (m)localObject);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
    
    public static final class a
      extends c<a>
    {
      private static volatile a[] e;
      public byte[] b = s.h;
      public int d = 0;
      
      public a()
      {
        this.a = null;
        this.c = -1;
      }
      
      public static a[] d()
      {
        if (e == null) {}
        synchronized (i.c)
        {
          if (e == null) {
            e = new a[0];
          }
          return e;
        }
      }
      
      protected final int a()
      {
        int j = super.a();
        int i = j;
        if (!Arrays.equals(this.b, s.h)) {
          i = j + b.b(1, this.b);
        }
        j = i;
        if (this.d != 0) {
          j = i + b.d(2, this.d);
        }
        return j;
      }
      
      public final void a(b paramb)
        throws IOException
      {
        if (!Arrays.equals(this.b, s.h)) {
          paramb.a(1, this.b);
        }
        if (this.d != 0) {
          paramb.a(2, this.d);
        }
        super.a(paramb);
      }
    }
  }
  
  public static final class b
    extends c<b>
  {
    private static volatile b[] d;
    public String b = "";
    
    public b()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static b[] d()
    {
      if (d == null) {}
      synchronized (i.c)
      {
        if (d == null) {
          d = new b[0];
        }
        return d;
      }
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (!this.b.equals("")) {
        i = j + b.b(1, this.b);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (!this.b.equals("")) {
        paramb.a(1, this.b);
      }
      super.a(paramb);
    }
  }
  
  public static final class c
    extends c<c>
  {
    public eu.a b = null;
    
    public c()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (this.b != null) {
        i = j + b.c(1, this.b);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != null) {
        paramb.a(1, this.b);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */