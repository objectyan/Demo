package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface ff
{
  public static final class a
    extends c<a>
  {
    private static volatile a[] e;
    public byte[] b = s.h;
    public ff.b[] d = ff.b.d();
    
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
      if (this.d != null)
      {
        j = i;
        if (this.d.length > 0)
        {
          j = 0;
          while (j < this.d.length)
          {
            ff.b localb = this.d[j];
            int k = i;
            if (localb != null) {
              k = i + b.c(2, localb);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (!Arrays.equals(this.b, s.h)) {
        paramb.a(1, this.b);
      }
      if ((this.d != null) && (this.d.length > 0))
      {
        int i = 0;
        while (i < this.d.length)
        {
          ff.b localb = this.d[i];
          if (localb != null) {
            paramb.a(2, localb);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
  }
  
  public static final class b
    extends c<b>
  {
    private static volatile b[] g;
    public byte[] b = s.h;
    public int[] d = s.a;
    public int[] e = s.a;
    public long f = 0L;
    
    public b()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static b[] d()
    {
      if (g == null) {}
      synchronized (i.c)
      {
        if (g == null) {
          g = new b[0];
        }
        return g;
      }
    }
    
    protected final int a()
    {
      int m = 0;
      int j = super.a();
      int i = j;
      if (!Arrays.equals(this.b, s.h)) {
        i = j + b.b(1, this.b);
      }
      j = i;
      int k;
      if (this.d != null)
      {
        j = i;
        if (this.d.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.d.length)
          {
            k += b.f(b.g(this.d[j]));
            j += 1;
          }
          j = i + k + 1 + b.f(k);
        }
      }
      i = j;
      if (this.e != null)
      {
        i = j;
        if (this.e.length > 0)
        {
          k = 0;
          i = m;
          while (i < this.e.length)
          {
            k += b.c(this.e[i]);
            i += 1;
          }
          i = j + k + 1 + b.f(k);
        }
      }
      j = i;
      if (this.f != 0L) {
        j = i + b.b(4, this.f);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      int k = 0;
      if (!Arrays.equals(this.b, s.h)) {
        paramb.a(1, this.b);
      }
      int i;
      int j;
      if ((this.d != null) && (this.d.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.d.length)
        {
          j += b.f(b.g(this.d[i]));
          i += 1;
        }
        paramb.e(18);
        paramb.e(j);
        i = 0;
        while (i < this.d.length)
        {
          paramb.b(this.d[i]);
          i += 1;
        }
      }
      if ((this.e != null) && (this.e.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.e.length)
        {
          j += b.c(this.e[i]);
          i += 1;
        }
        paramb.e(26);
        paramb.e(j);
        i = k;
        while (i < this.e.length)
        {
          paramb.a(this.e[i]);
          i += 1;
        }
      }
      if (this.f != 0L) {
        paramb.a(4, this.f);
      }
      super.a(paramb);
    }
  }
  
  public static final class c
    extends c<c>
  {
    public ff.e[] b = ff.e.d();
    public ff.a[] d = ff.a.d();
    
    public c()
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
              k = i + b.c(3, (m)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      int k = i;
      if (this.d != null)
      {
        k = i;
        if (this.d.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.d.length) {
              break;
            }
            localObject = this.d[j];
            k = i;
            if (localObject != null) {
              k = i + b.c(4, (m)localObject);
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
            paramb.a(3, (m)localObject);
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
            paramb.a(4, (m)localObject);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
  }
  
  public static final class d
    extends c<d>
  {
    private static volatile d[] i;
    public int b = 0;
    public int d = 0;
    public int e = 0;
    public int[] f = s.a;
    public int[] g = s.a;
    public long h = 0L;
    
    public d()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static d[] d()
    {
      if (i == null) {}
      synchronized (i.c)
      {
        if (i == null) {
          i = new d[0];
        }
        return i;
      }
    }
    
    protected final int a()
    {
      int n = 0;
      int k = super.a();
      int j = k;
      if (this.b != 0) {
        j = k + b.e(2, this.b);
      }
      k = j;
      if (this.d != 0) {
        k = j + b.e(3, this.d);
      }
      j = k;
      if (this.e != 0) {
        j = k + b.d(4, this.e);
      }
      k = j;
      int m;
      if (this.f != null)
      {
        k = j;
        if (this.f.length > 0)
        {
          k = 0;
          m = 0;
          while (k < this.f.length)
          {
            m += b.f(b.g(this.f[k]));
            k += 1;
          }
          k = j + m + 1 + b.f(m);
        }
      }
      j = k;
      if (this.g != null)
      {
        j = k;
        if (this.g.length > 0)
        {
          m = 0;
          j = n;
          while (j < this.g.length)
          {
            m += b.c(this.g[j]);
            j += 1;
          }
          j = k + m + 1 + b.f(m);
        }
      }
      k = j;
      if (this.h != 0L) {
        k = j + b.b(7, this.h);
      }
      return k;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      int m = 0;
      if (this.b != 0) {
        paramb.b(2, this.b);
      }
      if (this.d != 0) {
        paramb.b(3, this.d);
      }
      if (this.e != 0) {
        paramb.a(4, this.e);
      }
      int j;
      int k;
      if ((this.f != null) && (this.f.length > 0))
      {
        j = 0;
        k = 0;
        while (j < this.f.length)
        {
          k += b.f(b.g(this.f[j]));
          j += 1;
        }
        paramb.e(42);
        paramb.e(k);
        j = 0;
        while (j < this.f.length)
        {
          paramb.b(this.f[j]);
          j += 1;
        }
      }
      if ((this.g != null) && (this.g.length > 0))
      {
        j = 0;
        k = 0;
        while (j < this.g.length)
        {
          k += b.c(this.g[j]);
          j += 1;
        }
        paramb.e(50);
        paramb.e(k);
        j = m;
        while (j < this.g.length)
        {
          paramb.a(this.g[j]);
          j += 1;
        }
      }
      if (this.h != 0L) {
        paramb.a(7, this.h);
      }
      super.a(paramb);
    }
  }
  
  public static final class e
    extends c<e>
  {
    private static volatile e[] e;
    public String b = "";
    public ff.d[] d = ff.d.d();
    
    public e()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static e[] d()
    {
      if (e == null) {}
      synchronized (i.c)
      {
        if (e == null) {
          e = new e[0];
        }
        return e;
      }
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (!this.b.equals("")) {
        i = j + b.b(1, this.b);
      }
      j = i;
      if (this.d != null)
      {
        j = i;
        if (this.d.length > 0)
        {
          j = 0;
          while (j < this.d.length)
          {
            ff.d locald = this.d[j];
            int k = i;
            if (locald != null) {
              k = i + b.c(2, locald);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (!this.b.equals("")) {
        paramb.a(1, this.b);
      }
      if ((this.d != null) && (this.d.length > 0))
      {
        int i = 0;
        while (i < this.d.length)
        {
          ff.d locald = this.d[i];
          if (locald != null) {
            paramb.a(2, locald);
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
    private static volatile f[] f;
    public long b = 0L;
    public int[] d = s.a;
    public int[] e = s.a;
    
    public f()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static f[] d()
    {
      if (f == null) {}
      synchronized (i.c)
      {
        if (f == null) {
          f = new f[0];
        }
        return f;
      }
    }
    
    protected final int a()
    {
      int m = 0;
      int j = super.a();
      int i = j;
      if (this.b != 0L) {
        i = j + b.b(1, this.b);
      }
      j = i;
      int k;
      if (this.d != null)
      {
        j = i;
        if (this.d.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.d.length)
          {
            k += b.f(b.g(this.d[j]));
            j += 1;
          }
          j = i + k + 1 + b.f(k);
        }
      }
      i = j;
      if (this.e != null)
      {
        i = j;
        if (this.e.length > 0)
        {
          k = 0;
          i = m;
          while (i < this.e.length)
          {
            k += b.c(this.e[i]);
            i += 1;
          }
          i = j + k + 1 + b.f(k);
        }
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      int k = 0;
      if (this.b != 0L) {
        paramb.a(1, this.b);
      }
      int i;
      int j;
      if ((this.d != null) && (this.d.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.d.length)
        {
          j += b.f(b.g(this.d[i]));
          i += 1;
        }
        paramb.e(18);
        paramb.e(j);
        i = 0;
        while (i < this.d.length)
        {
          paramb.b(this.d[i]);
          i += 1;
        }
      }
      if ((this.e != null) && (this.e.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.e.length)
        {
          j += b.c(this.e[i]);
          i += 1;
        }
        paramb.e(26);
        paramb.e(j);
        i = k;
        while (i < this.e.length)
        {
          paramb.a(this.e[i]);
          i += 1;
        }
      }
      super.a(paramb);
    }
  }
  
  public static final class g
    extends c<g>
  {
    public ff.f[] b = ff.f.d();
    
    public g()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int i = super.a();
      int k = i;
      if (this.b != null)
      {
        k = i;
        if (this.b.length > 0)
        {
          int j = 0;
          for (;;)
          {
            k = i;
            if (j >= this.b.length) {
              break;
            }
            ff.f localf = this.b[j];
            k = i;
            if (localf != null) {
              k = i + b.c(1, localf);
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
      if ((this.b != null) && (this.b.length > 0))
      {
        int i = 0;
        while (i < this.b.length)
        {
          ff.f localf = this.b[i];
          if (localf != null) {
            paramb.a(1, localf);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
  }
  
  public static final class h
    extends c<h>
  {
    public long b = 0L;
    public ff.g d = null;
    public ff.g e = null;
    public p f = null;
    public ff.c g = null;
    
    public h()
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
      j = i;
      if (this.d != null) {
        j = i + b.c(2, this.d);
      }
      i = j;
      if (this.e != null) {
        i = j + b.c(3, this.e);
      }
      j = i;
      if (this.f != null) {
        j = i + b.c(4, this.f);
      }
      i = j;
      if (this.g != null) {
        i = j + b.c(5, this.g);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != 0L) {
        paramb.a(1, this.b);
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
      if (this.g != null) {
        paramb.a(5, this.g);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */