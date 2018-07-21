package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class r
  extends c<r>
{
  private static volatile r[] e;
  public int b = 0;
  public Object d = null;
  
  public r()
  {
    this.a = null;
    this.c = -1;
  }
  
  public static r[] d()
  {
    if (e == null) {}
    synchronized (i.c)
    {
      if (e == null) {
        e = new r[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.b == 1) {
      i = b.f(1, ((Integer)this.d).intValue()) + j;
    }
    j = i;
    if (this.b == 2)
    {
      ((Double)this.d).doubleValue();
      j = i + (b.d(2) + 8);
    }
    i = j;
    if (this.b == 3) {
      i = j + b.b(3, (String)this.d);
    }
    j = i;
    if (this.b == 4)
    {
      ((Boolean)this.d).booleanValue();
      j = i + (b.d(4) + 1);
    }
    i = j;
    if (this.b == 5) {
      i = j + b.c(5, (m)this.d);
    }
    j = i;
    if (this.b == 6) {
      j = i + b.c(6, (m)this.d);
    }
    return j;
  }
  
  public final void a(b paramb)
    throws IOException
  {
    if (this.b == 1) {
      paramb.c(1, ((Integer)this.d).intValue());
    }
    if (this.b == 2) {
      paramb.a(2, ((Double)this.d).doubleValue());
    }
    if (this.b == 3) {
      paramb.a(3, (String)this.d);
    }
    if (this.b == 4) {
      paramb.a(4, ((Boolean)this.d).booleanValue());
    }
    if (this.b == 5) {
      paramb.a(5, (m)this.d);
    }
    if (this.b == 6) {
      paramb.a(6, (m)this.d);
    }
    super.a(paramb);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */