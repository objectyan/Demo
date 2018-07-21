package com.indooratlas.android.sdk._internal;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

public final class da
{
  @Nullable
  public final Handler a;
  @Nullable
  public final Bundle b;
  public final int c;
  
  private da(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
  }
  
  public static final class a
  {
    public Handler a = null;
    public Bundle b;
    public int c;
    
    public final Bundle a()
    {
      if (this.b == null) {
        this.b = new Bundle(1);
      }
      return this.b;
    }
    
    public final da b()
    {
      return new da(this, (byte)0);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */