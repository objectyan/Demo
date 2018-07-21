package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public abstract interface fa
{
  public static final class a
    extends c<a>
  {
    public String b = "";
    public String d = "";
    
    public a()
    {
      this.a = null;
      this.c = -1;
    }
    
    protected final int a()
    {
      int j = super.a();
      int i = j;
      if (!this.b.equals("")) {
        i = j + b.b(1, this.b);
      }
      j = i;
      if (!this.d.equals("")) {
        j = i + b.b(2, this.d);
      }
      return j;
    }
    
    public final void a(b paramb)
      throws IOException
    {
      if (!this.b.equals("")) {
        paramb.a(1, this.b);
      }
      if (!this.d.equals("")) {
        paramb.a(2, this.d);
      }
      super.a(paramb);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */