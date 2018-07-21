package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class h
  extends c<h>
{
  public int b = 0;
  
  public h()
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
    return i;
  }
  
  public final void a(b paramb)
    throws IOException
  {
    if (this.b != 0) {
      paramb.a(1, this.b);
    }
    super.a(paramb);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */