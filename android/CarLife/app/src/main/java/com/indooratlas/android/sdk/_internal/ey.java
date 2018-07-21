package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract interface ey
{
  public static final class a
    extends c<a>
  {
    public double b = 0.0D;
    public double d = 0.0D;
    
    public a()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(0.0D)) {
        i = j + (b.d(1) + 8);
      }
      j = i;
      if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0D)) {
        j = i + (b.d(2) + 8);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(0.0D)) {
        paramb.a(1, this.b);
      }
      if (Double.doubleToLongBits(this.d) != Double.doubleToLongBits(0.0D)) {
        paramb.a(2, this.d);
      }
      super.a(paramb);
    }
  }
  
  public static final class b
    extends c<b>
  {
    private static volatile b[] m;
    public ey.a b = null;
    public long d = 0L;
    public long e = 0L;
    public float f = 0.0F;
    public g g = null;
    public g h = null;
    public float i = 0.0F;
    public int j = 0;
    public h k = null;
    public h l = null;
    
    public b()
    {
      this.a = null;
      this.c = -1;
    }
    
    public static b[] d()
    {
      if (m == null) {}
      synchronized (i.c)
      {
        if (m == null) {
          m = new b[0];
        }
        return m;
      }
    }
    
    protected final int a()
    {
      int i1 = super.a();
      int n = i1;
      if (this.b != null) {
        n = i1 + b.c(1, this.b);
      }
      i1 = n;
      if (this.d != 0L) {
        i1 = n + b.b(2, this.d);
      }
      n = i1;
      if (this.e != 0L) {
        n = i1 + b.b(3, this.e);
      }
      i1 = n;
      if (Float.floatToIntBits(this.f) != Float.floatToIntBits(0.0F)) {
        i1 = n + (b.d(4) + 4);
      }
      n = i1;
      if (this.g != null) {
        n = i1 + b.c(5, this.g);
      }
      i1 = n;
      if (this.h != null) {
        i1 = n + b.c(6, this.h);
      }
      n = i1;
      if (Float.floatToIntBits(this.i) != Float.floatToIntBits(0.0F)) {
        n = i1 + (b.d(7) + 4);
      }
      i1 = n;
      if (this.j != 0) {
        i1 = n + b.d(8, this.j);
      }
      n = i1;
      if (this.k != null) {
        n = i1 + b.c(9, this.k);
      }
      i1 = n;
      if (this.l != null) {
        i1 = n + b.c(10, this.l);
      }
      return i1;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != null) {
        paramb.a(1, this.b);
      }
      if (this.d != 0L) {
        paramb.a(2, this.d);
      }
      if (this.e != 0L) {
        paramb.a(3, this.e);
      }
      if (Float.floatToIntBits(this.f) != Float.floatToIntBits(0.0F)) {
        paramb.a(4, this.f);
      }
      if (this.g != null) {
        paramb.a(5, this.g);
      }
      if (this.h != null) {
        paramb.a(6, this.h);
      }
      if (Float.floatToIntBits(this.i) != Float.floatToIntBits(0.0F)) {
        paramb.a(7, this.i);
      }
      if (this.j != 0) {
        paramb.a(8, this.j);
      }
      if (this.k != null) {
        paramb.a(9, this.k);
      }
      if (this.l != null) {
        paramb.a(10, this.l);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */