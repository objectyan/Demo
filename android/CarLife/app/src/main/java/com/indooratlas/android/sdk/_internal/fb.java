package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface fb
{
  public static final class a
    extends c<a>
  {
    private static volatile a[] e;
    public long b = 0L;
    public byte[] d = s.h;
    
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
      if (this.b != 0L) {
        i = j + b.b(1, this.b);
      }
      j = i;
      if (!Arrays.equals(this.d, s.h)) {
        j = i + b.b(2, this.d);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != 0L) {
        paramb.a(1, this.b);
      }
      if (!Arrays.equals(this.d, s.h)) {
        paramb.a(2, this.d);
      }
      super.a(paramb);
    }
  }
  
  public static final class b
    extends c<b>
  {
    public ey.b[] b = ey.b.d();
    public ew.a d = null;
    
    public b()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int i = super.a();
      int j = i;
      if (this.b != null)
      {
        j = i;
        if (this.b.length > 0)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= this.b.length) {
              break;
            }
            ey.b localb = this.b[k];
            j = i;
            if (localb != null) {
              j = i + b.c(2, localb);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.d != null) {
        i = j + b.c(20, this.d);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if ((this.b != null) && (this.b.length > 0))
      {
        int i = 0;
        while (i < this.b.length)
        {
          ey.b localb = this.b[i];
          if (localb != null) {
            paramb.a(2, localb);
          }
          i += 1;
        }
      }
      if (this.d != null) {
        paramb.a(20, this.d);
      }
      super.a(paramb);
    }
  }
  
  public static final class c
    extends c<c>
  {
    public int b = 0;
    public fb.b d = null;
    public fb.e e = null;
    public ff.h f = null;
    public fb.d g = null;
    public ev.a[] h = ev.a.d();
    public fb.a[] i = fb.a.d();
    public int j = 0;
    
    public c()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int i1 = 0;
      int m = super.a();
      int k = m;
      if (this.b != 0) {
        k = m + b.e(1, this.b);
      }
      m = k;
      if (this.d != null) {
        m = k + b.c(2, this.d);
      }
      int n = m;
      if (this.e != null) {
        n = m + b.c(3, this.e);
      }
      k = n;
      if (this.f != null) {
        k = n + b.c(4, this.f);
      }
      m = k;
      Object localObject;
      if (this.h != null)
      {
        m = k;
        if (this.h.length > 0)
        {
          m = 0;
          while (m < this.h.length)
          {
            localObject = this.h[m];
            n = k;
            if (localObject != null) {
              n = k + b.c(5, (m)localObject);
            }
            m += 1;
            k = n;
          }
          m = k;
        }
      }
      k = m;
      if (this.j != 0) {
        k = m + b.e(6, this.j);
      }
      m = k;
      if (this.i != null)
      {
        m = k;
        if (this.i.length > 0)
        {
          n = i1;
          for (;;)
          {
            m = k;
            if (n >= this.i.length) {
              break;
            }
            localObject = this.i[n];
            m = k;
            if (localObject != null) {
              m = k + b.c(7, (m)localObject);
            }
            n += 1;
            k = m;
          }
        }
      }
      k = m;
      if (this.g != null) {
        k = m + b.c(8, this.g);
      }
      return k;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      int m = 0;
      if (this.b != 0) {
        paramb.b(1, this.b);
      }
      if (this.d != null) {
        paramb.a(2, this.d);
      }
      if (this.e != null) {
        paramb.a(3, this.e);
      }
      if (this.f != null) {
        paramb.a(4, this.f);
      }
      int k;
      Object localObject;
      if ((this.h != null) && (this.h.length > 0))
      {
        k = 0;
        while (k < this.h.length)
        {
          localObject = this.h[k];
          if (localObject != null) {
            paramb.a(5, (m)localObject);
          }
          k += 1;
        }
      }
      if (this.j != 0) {
        paramb.b(6, this.j);
      }
      if ((this.i != null) && (this.i.length > 0))
      {
        k = m;
        while (k < this.i.length)
        {
          localObject = this.i[k];
          if (localObject != null) {
            paramb.a(7, (m)localObject);
          }
          k += 1;
        }
      }
      if (this.g != null) {
        paramb.a(8, this.g);
      }
      super.a(paramb);
    }
  }
  
  public static final class d
    extends c<d>
  {
    public long b = 0L;
    
    public d()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (this.b != 0L) {
        i = j + b.b(1, this.b);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != 0L) {
        paramb.a(1, this.b);
      }
      super.a(paramb);
    }
  }
  
  public static final class e
    extends c<e>
  {
    public byte[][] b = s.g;
    public fb.f[] d = fb.f.d();
    
    public e()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int i1 = 0;
      int i2 = super.a();
      int j;
      int k;
      Object localObject;
      if ((this.b != null) && (this.b.length > 0))
      {
        i = 0;
        j = 0;
        int m;
        for (k = 0; i < this.b.length; k = m)
        {
          localObject = this.b[i];
          int n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + b.a((byte[])localObject);
          }
          i += 1;
          j = n;
        }
      }
      for (int i = i2 + j + k * 1;; i = i2)
      {
        k = i;
        if (this.d != null)
        {
          k = i;
          if (this.d.length > 0)
          {
            j = i1;
            for (;;)
            {
              k = i;
              if (j >= this.d.length) {
                break;
              }
              localObject = this.d[j];
              k = i;
              if (localObject != null) {
                k = i + b.c(2, (m)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        return k;
      }
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
            paramb.a(1, (byte[])localObject);
          }
          i += 1;
        }
      }
      if ((this.d != null) && (this.d.length > 0))
      {
        i = j;
        while (i < this.d.length)
        {
          localObject = this.d[i];
          if (localObject != null) {
            paramb.a(2, (m)localObject);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
  }
  
  public static final class f
    extends c<f>
  {
    private static volatile f[] e;
    public long b = 0L;
    public byte[] d = s.h;
    
    public f()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static f[] d()
    {
      if (e == null) {}
      synchronized (i.c)
      {
        if (e == null) {
          e = new f[0];
        }
        return e;
      }
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (this.b != 0L) {
        i = j + b.b(1, this.b);
      }
      j = i;
      if (!Arrays.equals(this.d, s.h)) {
        j = i + b.b(2, this.d);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != 0L) {
        paramb.a(1, this.b);
      }
      if (!Arrays.equals(this.d, s.h)) {
        paramb.a(2, this.d);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */