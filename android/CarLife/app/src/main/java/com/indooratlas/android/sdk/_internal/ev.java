package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract interface ev
{
  public static final class a
    extends c<a>
  {
    private static volatile a[] o;
    public long b = 0L;
    public double[] d = s.d;
    public float e = 0.0F;
    public float[] f = s.c;
    public float[] g = s.c;
    public boolean h = false;
    public double[] i = s.d;
    public float j = 0.0F;
    public float[] k = s.c;
    public float[] l = s.c;
    public long m = 0L;
    public double[] n = s.d;
    
    public a()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static a[] d()
    {
      if (o == null) {}
      synchronized (i.c)
      {
        if (o == null) {
          o = new a[0];
        }
        return o;
      }
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
          i2 = this.d.length * 8;
          i2 = i1 + i2 + 1 + b.f(i2);
        }
      }
      i1 = i2;
      if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0F)) {
        i1 = i2 + (b.d(3) + 4);
      }
      i2 = i1;
      if (this.f != null)
      {
        i2 = i1;
        if (this.f.length > 0)
        {
          i2 = this.f.length * 4;
          i2 = i1 + i2 + 1 + b.f(i2);
        }
      }
      int i3 = i2;
      if (this.g != null)
      {
        i3 = i2;
        if (this.g.length > 0)
        {
          i1 = this.g.length * 4;
          i3 = i2 + i1 + 1 + b.f(i1);
        }
      }
      i1 = i3;
      if (this.h) {
        i1 = i3 + (b.d(6) + 1);
      }
      i2 = i1;
      if (this.i != null)
      {
        i2 = i1;
        if (this.i.length > 0)
        {
          i2 = this.i.length * 8;
          i2 = i1 + i2 + 1 + b.f(i2);
        }
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
      i3 = i2;
      if (this.l != null)
      {
        i3 = i2;
        if (this.l.length > 0)
        {
          i1 = this.l.length * 4;
          i3 = i2 + i1 + 1 + b.f(i1);
        }
      }
      i1 = i3;
      if (this.m != 0L) {
        i1 = i3 + b.b(11, this.m);
      }
      i2 = i1;
      if (this.n != null)
      {
        i2 = i1;
        if (this.n.length > 0)
        {
          i2 = this.n.length * 8;
          i2 = i1 + i2 + 1 + b.f(i2);
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
        paramb.e(i1 * 8);
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
      if ((this.f != null) && (this.f.length > 0))
      {
        i1 = this.f.length;
        paramb.e(34);
        paramb.e(i1 * 4);
        i1 = 0;
        while (i1 < this.f.length)
        {
          paramb.a(this.f[i1]);
          i1 += 1;
        }
      }
      if ((this.g != null) && (this.g.length > 0))
      {
        i1 = this.g.length;
        paramb.e(42);
        paramb.e(i1 * 4);
        i1 = 0;
        while (i1 < this.g.length)
        {
          paramb.a(this.g[i1]);
          i1 += 1;
        }
      }
      if (this.h) {
        paramb.a(6, this.h);
      }
      if ((this.i != null) && (this.i.length > 0))
      {
        i1 = this.i.length;
        paramb.e(58);
        paramb.e(i1 * 8);
        i1 = 0;
        while (i1 < this.i.length)
        {
          paramb.a(this.i[i1]);
          i1 += 1;
        }
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
      if ((this.l != null) && (this.l.length > 0))
      {
        i1 = this.l.length;
        paramb.e(82);
        paramb.e(i1 * 4);
        i1 = 0;
        while (i1 < this.l.length)
        {
          paramb.a(this.l[i1]);
          i1 += 1;
        }
      }
      if (this.m != 0L) {
        paramb.a(11, this.m);
      }
      if ((this.n != null) && (this.n.length > 0))
      {
        i1 = this.n.length;
        paramb.e(98);
        paramb.e(i1 * 8);
        i1 = i2;
        while (i1 < this.n.length)
        {
          paramb.a(this.n[i1]);
          i1 += 1;
        }
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */