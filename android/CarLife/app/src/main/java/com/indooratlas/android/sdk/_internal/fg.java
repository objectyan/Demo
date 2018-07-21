package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract interface fg
{
  public static final class a
    extends c<a>
  {
    public float b = 0.0F;
    
    public a()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (Float.floatToIntBits(this.b) != Float.floatToIntBits(0.0F)) {
        i = j + (b.d(1) + 4);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (Float.floatToIntBits(this.b) != Float.floatToIntBits(0.0F)) {
        paramb.a(1, this.b);
      }
      super.a(paramb);
    }
  }
  
  public static final class b
    extends c<b>
  {
    public double[] b = s.d;
    public double[] d = s.d;
    public double[] e = s.d;
    public double[] f = s.d;
    public double[] g = s.d;
    
    public b()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (this.b != null)
      {
        i = j;
        if (this.b.length > 0)
        {
          i = this.b.length * 8;
          i = j + i + 1 + b.f(i);
        }
      }
      j = i;
      if (this.d != null)
      {
        j = i;
        if (this.d.length > 0)
        {
          j = this.d.length * 8;
          j = i + j + 1 + b.f(j);
        }
      }
      i = j;
      if (this.e != null)
      {
        i = j;
        if (this.e.length > 0)
        {
          i = this.e.length * 8;
          i = j + i + 1 + b.f(i);
        }
      }
      j = i;
      if (this.f != null)
      {
        j = i;
        if (this.f.length > 0)
        {
          j = this.f.length * 8;
          j = i + j + 1 + b.f(j);
        }
      }
      i = j;
      if (this.g != null)
      {
        i = j;
        if (this.g.length > 0)
        {
          i = this.g.length * 8;
          i = j + i + 1 + b.f(i);
        }
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.b != null) && (this.b.length > 0))
      {
        i = this.b.length;
        paramb.e(10);
        paramb.e(i * 8);
        i = 0;
        while (i < this.b.length)
        {
          paramb.a(this.b[i]);
          i += 1;
        }
      }
      if ((this.d != null) && (this.d.length > 0))
      {
        i = this.d.length;
        paramb.e(18);
        paramb.e(i * 8);
        i = 0;
        while (i < this.d.length)
        {
          paramb.a(this.d[i]);
          i += 1;
        }
      }
      if ((this.e != null) && (this.e.length > 0))
      {
        i = this.e.length;
        paramb.e(26);
        paramb.e(i * 8);
        i = 0;
        while (i < this.e.length)
        {
          paramb.a(this.e[i]);
          i += 1;
        }
      }
      if ((this.f != null) && (this.f.length > 0))
      {
        i = this.f.length;
        paramb.e(34);
        paramb.e(i * 8);
        i = 0;
        while (i < this.f.length)
        {
          paramb.a(this.f[i]);
          i += 1;
        }
      }
      if ((this.g != null) && (this.g.length > 0))
      {
        i = this.g.length;
        paramb.e(42);
        paramb.e(i * 8);
        i = j;
        while (i < this.g.length)
        {
          paramb.a(this.g[i]);
          i += 1;
        }
      }
      super.a(paramb);
    }
  }
  
  public static final class c
    extends c<c>
  {
    public double[] b = s.d;
    public float d = 0.0F;
    public g e = null;
    public float[] f = s.c;
    public float[] g = s.c;
    public double[] h = s.d;
    
    public c()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (this.b != null)
      {
        i = j;
        if (this.b.length > 0)
        {
          i = this.b.length * 8;
          i = j + i + 1 + b.f(i);
        }
      }
      j = i;
      if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0F)) {
        j = i + (b.d(2) + 4);
      }
      i = j;
      if (this.e != null) {
        i = j + b.c(3, this.e);
      }
      j = i;
      if (this.f != null)
      {
        j = i;
        if (this.f.length > 0)
        {
          j = this.f.length * 4;
          j = i + j + 1 + b.f(j);
        }
      }
      i = j;
      if (this.g != null)
      {
        i = j;
        if (this.g.length > 0)
        {
          i = this.g.length * 4;
          i = j + i + 1 + b.f(i);
        }
      }
      j = i;
      if (this.h != null)
      {
        j = i;
        if (this.h.length > 0)
        {
          j = this.h.length * 8;
          j = i + j + 1 + b.f(j);
        }
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.b != null) && (this.b.length > 0))
      {
        i = this.b.length;
        paramb.e(10);
        paramb.e(i * 8);
        i = 0;
        while (i < this.b.length)
        {
          paramb.a(this.b[i]);
          i += 1;
        }
      }
      if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0F)) {
        paramb.a(2, this.d);
      }
      if (this.e != null) {
        paramb.a(3, this.e);
      }
      if ((this.f != null) && (this.f.length > 0))
      {
        i = this.f.length;
        paramb.e(34);
        paramb.e(i * 4);
        i = 0;
        while (i < this.f.length)
        {
          paramb.a(this.f[i]);
          i += 1;
        }
      }
      if ((this.g != null) && (this.g.length > 0))
      {
        i = this.g.length;
        paramb.e(42);
        paramb.e(i * 4);
        i = 0;
        while (i < this.g.length)
        {
          paramb.a(this.g[i]);
          i += 1;
        }
      }
      if ((this.h != null) && (this.h.length > 0))
      {
        i = this.h.length;
        paramb.e(98);
        paramb.e(i * 8);
        i = j;
        while (i < this.h.length)
        {
          paramb.a(this.h[i]);
          i += 1;
        }
      }
      super.a(paramb);
    }
  }
  
  public static final class d
    extends c<d>
  {
    private static volatile d[] g;
    public long b = 0L;
    public double d = 0.0D;
    public double e = 0.0D;
    public double f = 0.0D;
    
    public d()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static d[] d()
    {
      if (g == null) {}
      synchronized (i.c)
      {
        if (g == null) {
          g = new d[0];
        }
        return g;
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
      if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0D)) {
        j = i + (b.d(2) + 8);
      }
      i = j;
      if (Double.doubleToLongBits(this.e) != Double.doubleToLongBits(0.0D)) {
        i = j + (b.d(3) + 8);
      }
      j = i;
      if (Double.doubleToLongBits(this.f) != Double.doubleToLongBits(0.0D)) {
        j = i + (b.d(4) + 8);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != 0L) {
        paramb.a(1, this.b);
      }
      if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0D)) {
        paramb.a(2, this.d);
      }
      if (Double.doubleToLongBits(this.e) != Double.doubleToLongBits(0.0D)) {
        paramb.a(3, this.e);
      }
      if (Double.doubleToLongBits(this.f) != Double.doubleToLongBits(0.0D)) {
        paramb.a(4, this.f);
      }
      super.a(paramb);
    }
  }
  
  public static final class e
    extends c<e>
  {
    public long b = 0L;
    public float[] d = s.c;
    public float e = 0.0F;
    public float f = 0.0F;
    public double[] g = s.d;
    public fg.b h = null;
    public fg.c i = null;
    public float j = 0.0F;
    public float[] k = s.c;
    public float l = 0.0F;
    public float m = 0.0F;
    public int n = 0;
    public float o = 0.0F;
    public fg.a p = null;
    public fg.d[] q = fg.d.d();
    
    public e()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int i2 = super.a();
      int i1 = i2;
      if (this.b != 0L) {
        i1 = i2 + b.b(1, this.b);
      }
      i2 = i1;
      if (this.d != null)
      {
        i2 = i1;
        if (this.d.length > 0)
        {
          i2 = this.d.length * 4;
          i2 = i1 + i2 + 1 + b.f(i2);
        }
      }
      int i3 = i2;
      if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0F)) {
        i3 = i2 + (b.d(3) + 4);
      }
      i1 = i3;
      if (Float.floatToIntBits(this.f) != Float.floatToIntBits(0.0F)) {
        i1 = i3 + (b.d(4) + 4);
      }
      i2 = i1;
      if (this.g != null)
      {
        i2 = i1;
        if (this.g.length > 0)
        {
          i2 = this.g.length * 8;
          i2 = i1 + i2 + 1 + b.f(i2);
        }
      }
      i1 = i2;
      if (this.h != null) {
        i1 = i2 + b.c(6, this.h);
      }
      i2 = i1;
      if (this.i != null) {
        i2 = i1 + b.c(7, this.i);
      }
      i1 = i2;
      if (Float.floatToIntBits(this.j) != Float.floatToIntBits(0.0F)) {
        i1 = i2 + (b.d(8) + 4);
      }
      i2 = i1;
      if (this.k != null)
      {
        i2 = i1;
        if (this.k.length > 0)
        {
          i2 = this.k.length * 4;
          i2 = i1 + i2 + 1 + b.f(i2);
        }
      }
      i1 = i2;
      if (Float.floatToIntBits(this.l) != Float.floatToIntBits(0.0F)) {
        i1 = i2 + (b.d(10) + 4);
      }
      i2 = i1;
      if (Float.floatToIntBits(this.m) != Float.floatToIntBits(0.0F)) {
        i2 = i1 + (b.d(11) + 4);
      }
      i1 = i2;
      if (this.n != 0) {
        i1 = i2 + b.e(12, this.n);
      }
      i2 = i1;
      if (Float.floatToIntBits(this.o) != Float.floatToIntBits(0.0F)) {
        i2 = i1 + (b.d(13) + 4);
      }
      i1 = i2;
      if (this.p != null) {
        i1 = i2 + b.c(14, this.p);
      }
      i2 = i1;
      if (this.q != null)
      {
        i2 = i1;
        if (this.q.length > 0)
        {
          i2 = 0;
          while (i2 < this.q.length)
          {
            fg.d locald = this.q[i2];
            i3 = i1;
            if (locald != null) {
              i3 = i1 + b.c(15, locald);
            }
            i2 += 1;
            i1 = i3;
          }
          i2 = i1;
        }
      }
      return i2;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      int i2 = 0;
      if (this.b != 0L) {
        paramb.a(1, this.b);
      }
      int i1;
      if ((this.d != null) && (this.d.length > 0))
      {
        i1 = this.d.length;
        paramb.e(18);
        paramb.e(i1 * 4);
        i1 = 0;
        while (i1 < this.d.length)
        {
          paramb.a(this.d[i1]);
          i1 += 1;
        }
      }
      if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0F)) {
        paramb.a(3, this.e);
      }
      if (Float.floatToIntBits(this.f) != Float.floatToIntBits(0.0F)) {
        paramb.a(4, this.f);
      }
      if ((this.g != null) && (this.g.length > 0))
      {
        i1 = this.g.length;
        paramb.e(42);
        paramb.e(i1 * 8);
        i1 = 0;
        while (i1 < this.g.length)
        {
          paramb.a(this.g[i1]);
          i1 += 1;
        }
      }
      if (this.h != null) {
        paramb.a(6, this.h);
      }
      if (this.i != null) {
        paramb.a(7, this.i);
      }
      if (Float.floatToIntBits(this.j) != Float.floatToIntBits(0.0F)) {
        paramb.a(8, this.j);
      }
      if ((this.k != null) && (this.k.length > 0))
      {
        i1 = this.k.length;
        paramb.e(74);
        paramb.e(i1 * 4);
        i1 = 0;
        while (i1 < this.k.length)
        {
          paramb.a(this.k[i1]);
          i1 += 1;
        }
      }
      if (Float.floatToIntBits(this.l) != Float.floatToIntBits(0.0F)) {
        paramb.a(10, this.l);
      }
      if (Float.floatToIntBits(this.m) != Float.floatToIntBits(0.0F)) {
        paramb.a(11, this.m);
      }
      if (this.n != 0) {
        paramb.b(12, this.n);
      }
      if (Float.floatToIntBits(this.o) != Float.floatToIntBits(0.0F)) {
        paramb.a(13, this.o);
      }
      if (this.p != null) {
        paramb.a(14, this.p);
      }
      if ((this.q != null) && (this.q.length > 0))
      {
        i1 = i2;
        while (i1 < this.q.length)
        {
          fg.d locald = this.q[i1];
          if (locald != null) {
            paramb.a(15, locald);
          }
          i1 += 1;
        }
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */