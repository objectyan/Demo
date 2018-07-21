package com.indooratlas.android.sdk._internal;

import android.hardware.Sensor;

public final class de
  implements cw
{
  int a = 0;
  
  public final int a()
  {
    return this.a;
  }
  
  public final Sensor b()
  {
    return null;
  }
  
  public final String toString()
  {
    return "SimpleSensor{mType=" + this.a + '}';
  }
  
  public static final class a
  {
    private de a = new de((byte)0);
    private boolean b;
    
    public final a a(int paramInt)
    {
      this.a.a = paramInt;
      this.b = true;
      return this;
    }
    
    public final de a()
    {
      if (!this.b) {
        throw new IllegalStateException("sensor type must be set");
      }
      return this.a;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */