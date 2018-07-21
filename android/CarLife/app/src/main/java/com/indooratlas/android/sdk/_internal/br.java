package com.indooratlas.android.sdk._internal;

import java.util.Arrays;

public abstract interface br
{
  public static final class a
  {
    private int a = 0;
    private br[] b = new br[0];
    
    final void a()
    {
      this.a = 0;
      if (this.a < this.b.length) {
        this.a += 1;
      }
    }
    
    public final void a(br parambr)
    {
      Object localObject = this.b;
      if (localObject == null) {
        throw new IllegalArgumentException("array cannot be null");
      }
      int i = localObject.length;
      localObject = Arrays.copyOf((Object[])localObject, i + 1);
      localObject[i] = parambr;
      this.b = ((br[])localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */