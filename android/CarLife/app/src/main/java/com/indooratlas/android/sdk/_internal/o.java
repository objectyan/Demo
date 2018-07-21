package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.util.Map;

public final class o
  extends c<o>
{
  public Map<String, r> b = null;
  
  public o()
  {
    this.a = null;
    this.c = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (this.b != null) {
      i = j + i.a(this.b);
    }
    return i;
  }
  
  public final void a(b paramb)
    throws IOException
  {
    if (this.b != null) {
      i.a(paramb, this.b);
    }
    super.a(paramb);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */