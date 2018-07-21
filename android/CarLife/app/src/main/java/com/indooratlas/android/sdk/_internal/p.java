package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class p
  extends c<p>
{
  public long b = 0L;
  
  public p()
  {
    this.a = null;
    this.c = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.b != 0L) {
      i = j + b.b(1, this.b);
    }
    return i;
  }
  
  public final void a(b paramb)
    throws IOException
  {
    if (this.b != 0L) {
      paramb.a(1, this.b);
    }
    super.a(paramb);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */