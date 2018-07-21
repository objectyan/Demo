package com.indooratlas.android.sdk._internal;

import java.io.IOException;

public final class g
  extends c<g>
{
  public float b = 0.0F;
  
  public g()
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
    return i;
  }
  
  public final void a(b paramb)
    throws IOException
  {
    if (Float.floatToIntBits(this.b) != Float.floatToIntBits(0.0F)) {
      paramb.a(1, this.b);
    }
    super.a(paramb);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */