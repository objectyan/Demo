package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract interface fd
{
  public static final class a
    extends c<a>
  {
    public int b = 0;
    public int d = 0;
    public o e = null;
    public o f = null;
    
    public a()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (this.b != 0) {
        i = j + b.e(1, this.b);
      }
      j = i;
      if (this.d != 0) {
        j = i + b.e(2, this.d);
      }
      i = j;
      if (this.e != null) {
        i = j + b.c(5, this.e);
      }
      j = i;
      if (this.f != null) {
        j = i + b.c(20, this.f);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != 0) {
        paramb.b(1, this.b);
      }
      if (this.d != 0) {
        paramb.b(2, this.d);
      }
      if (this.e != null) {
        paramb.a(5, this.e);
      }
      if (this.f != null) {
        paramb.a(20, this.f);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */