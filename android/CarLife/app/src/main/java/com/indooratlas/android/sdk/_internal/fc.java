package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract interface fc
{
  public static final class a
    extends c<a>
  {
    public ew.a b = null;
    
    public a()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (this.b != null) {
        i = j + b.c(2, this.b);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != null) {
        paramb.a(2, this.b);
      }
      super.a(paramb);
    }
  }
  
  public static final class b
    extends c<b>
  {
    public ex.a b = null;
    public fc.d d = null;
    
    public b()
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
      j = i;
      if (this.d != null) {
        j = i + b.c(2, this.d);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != null) {
        paramb.a(1, this.b);
      }
      if (this.d != null) {
        paramb.a(2, this.d);
      }
      super.a(paramb);
    }
  }
  
  public static final class c
    extends c<c>
  {
    public fc.b b = null;
    public fc.a d = null;
    public fc.a e = null;
    public int f = 0;
    public o g = null;
    
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
      j = i;
      if (this.d != null) {
        j = i + b.c(2, this.d);
      }
      i = j;
      if (this.f != 0) {
        i = j + b.e(3, this.f);
      }
      j = i;
      if (this.e != null) {
        j = i + b.c(4, this.e);
      }
      i = j;
      if (this.g != null) {
        i = j + b.c(16, this.g);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != null) {
        paramb.a(1, this.b);
      }
      if (this.d != null) {
        paramb.a(2, this.d);
      }
      if (this.f != 0) {
        paramb.b(3, this.f);
      }
      if (this.e != null) {
        paramb.a(4, this.e);
      }
      if (this.g != null) {
        paramb.a(16, this.g);
      }
      super.a(paramb);
    }
  }
  
  public static final class d
    extends c<d>
  {
    public float b = 0.0F;
    public float d = 0.0F;
    
    public d()
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
      j = i;
      if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0F)) {
        j = i + (b.d(2) + 4);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (Float.floatToIntBits(this.b) != Float.floatToIntBits(0.0F)) {
        paramb.a(1, this.b);
      }
      if (Float.floatToIntBits(this.d) != Float.floatToIntBits(0.0F)) {
        paramb.a(2, this.d);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */