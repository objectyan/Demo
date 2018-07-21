package com.indooratlas.android.sdk._internal;

import android.hardware.Sensor;

final class dn
  implements cw
{
  Sensor a;
  
  dn(Sensor paramSensor)
  {
    this.a = paramSensor;
  }
  
  public static dn a(Sensor paramSensor)
  {
    return new dn(paramSensor);
  }
  
  public final int a()
  {
    return dm.b(this.a.getType());
  }
  
  public final Sensor b()
  {
    return this.a;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof dn)) {}
    while (this.a.getType() != ((dn)paramObject).a.getType()) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */