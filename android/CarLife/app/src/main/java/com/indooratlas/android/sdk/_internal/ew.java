package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract interface ew
{
  public static final class a
    extends c<a>
  {
    public int b = 0;
    public String d = "";
    public String e = "";
    
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
        i = j + b.d(1, this.b);
      }
      j = i;
      if (!this.d.equals("")) {
        j = i + b.b(2, this.d);
      }
      i = j;
      if (!this.e.equals("")) {
        i = j + b.b(3, this.e);
      }
      return i;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (this.b != 0) {
        paramb.a(1, this.b);
      }
      if (!this.d.equals("")) {
        paramb.a(2, this.d);
      }
      if (!this.e.equals("")) {
        paramb.a(3, this.e);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */