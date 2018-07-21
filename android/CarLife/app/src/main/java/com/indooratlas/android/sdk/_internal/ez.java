package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface ez
{
  public static final class a
    extends c<a>
  {
    public int b = 0;
    public o d = null;
    public byte[] e = s.h;
    public eu.c f = null;
    
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
      if (this.d != null) {
        j = i + b.c(2, this.d);
      }
      i = j;
      if (!Arrays.equals(this.e, s.h)) {
        i = j + b.b(3, this.e);
      }
      j = i;
      if (this.f != null) {
        j = i + b.c(4, this.f);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != 0) {
        paramb.b(1, this.b);
      }
      if (this.d != null) {
        paramb.a(2, this.d);
      }
      if (!Arrays.equals(this.e, s.h)) {
        paramb.a(3, this.e);
      }
      if (this.f != null) {
        paramb.a(4, this.f);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */