package com.indooratlas.android.sdk._internal;

import android.os.Bundle;

public final class dd
  implements cy
{
  public int a;
  public dc[] b = new dc[0];
  public Bundle c = new Bundle();
  private int d;
  
  public final void a(cx paramcx)
  {
    this.d = 0;
    b((cx)eg.a(paramcx, "event must not be null", new Object[0]));
  }
  
  public final void a(dc paramdc)
  {
    if (this.a == this.b.length)
    {
      arrayOfdc = new dc[this.a + 1];
      System.arraycopy(this.b, 0, arrayOfdc, 0, this.a);
      this.b = arrayOfdc;
    }
    dc[] arrayOfdc = this.b;
    int i = this.a;
    this.a = (i + 1);
    arrayOfdc[i] = paramdc;
  }
  
  public final void b(cx paramcx)
  {
    while (this.d < this.a)
    {
      Object localObject = this.b;
      int i = this.d;
      this.d = (i + 1);
      localObject = localObject[i];
      if (((dc)localObject).a()) {
        ((dc)localObject).a(paramcx, this);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */