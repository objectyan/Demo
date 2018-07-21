package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class k
  extends c<k>
{
  public r[] b = r.d();
  
  public k()
  {
    this.a = null;
    this.c = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int k = i;
    if (this.b != null)
    {
      k = i;
      if (this.b.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.b.length) {
            break;
          }
          r localr = this.b[j];
          k = i;
          if (localr != null) {
            k = i + b.c(1, localr);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public final void a(b paramb)
    throws IOException
  {
    if ((this.b != null) && (this.b.length > 0))
    {
      int i = 0;
      while (i < this.b.length)
      {
        r localr = this.b[i];
        if (localr != null) {
          paramb.a(1, localr);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */