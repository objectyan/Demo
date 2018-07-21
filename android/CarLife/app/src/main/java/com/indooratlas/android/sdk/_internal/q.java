package com.indooratlas.android.sdk._internal;

import java.util.Arrays;

final class q
{
  final int a;
  final byte[] b;
  
  q(int paramInt, byte[] paramArrayOfByte)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof q)) {
        return false;
      }
      paramObject = (q)paramObject;
    } while ((this.a == ((q)paramObject).a) && (Arrays.equals(this.b, ((q)paramObject).b)));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.a + 527) * 31 + Arrays.hashCode(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */