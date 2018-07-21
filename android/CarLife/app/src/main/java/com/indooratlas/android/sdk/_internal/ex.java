package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract interface ex
{
  public static final class a
    extends c<a>
  {
    public ey.a b = null;
    public float d = 0.0F;
    public float e = 0.0F;
    public g f = null;
    public h g = null;
    public long h = 0L;
    public double[] i = s.d;
    public float j = 0.0F;
    public float k = 0.0F;
    public g l = null;
    
    public a()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int n = super.a();
      int m = n;
      if (this.b != null) {
        m = n + b.c(1, this.b);
      }
      n = m;
      if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0F)) {
        n = m + (b.d(2) + 4);
      }
      m = n;
      if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0F)) {
        m = n + (b.d(3) + 4);
      }
      n = m;
      if (this.f != null) {
        n = m + b.c(4, this.f);
      }
      int i1 = n;
      if (this.g != null) {
        i1 = n + b.c(5, this.g);
      }
      m = i1;
      if (this.h != 0L) {
        m = i1 + b.b(6, this.h);
      }
      n = m;
      if (this.i != null)
      {
        n = m;
        if (this.i.length > 0)
        {
          n = this.i.length * 8;
          n = m + n + 1 + b.f(n);
        }
      }
      m = n;
      if (Float.floatToIntBits(this.j) != Float.floatToIntBits(0.0F)) {
        m = n + (b.d(8) + 4);
      }
      n = m;
      if (Float.floatToIntBits(this.k) != Float.floatToIntBits(0.0F)) {
        n = m + (b.d(9) + 4);
      }
      m = n;
      if (this.l != null) {
        m = n + b.c(10, this.l);
      }
      return m;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != null) {
        paramb.a(1, this.b);
      }
      if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0F)) {
        paramb.a(2, this.d);
      }
      if (Float.floatToIntBits(this.e) != Float.floatToIntBits(0.0F)) {
        paramb.a(3, this.e);
      }
      if (this.f != null) {
        paramb.a(4, this.f);
      }
      if (this.g != null) {
        paramb.a(5, this.g);
      }
      if (this.h != 0L) {
        paramb.a(6, this.h);
      }
      if ((this.i != null) && (this.i.length > 0))
      {
        int m = this.i.length;
        paramb.e(58);
        paramb.e(m * 8);
        m = 0;
        while (m < this.i.length)
        {
          paramb.a(this.i[m]);
          m += 1;
        }
      }
      if (Float.floatToIntBits(this.j) != Float.floatToIntBits(0.0F)) {
        paramb.a(8, this.j);
      }
      if (Float.floatToIntBits(this.k) != Float.floatToIntBits(0.0F)) {
        paramb.a(9, this.k);
      }
      if (this.l != null) {
        paramb.a(10, this.l);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */