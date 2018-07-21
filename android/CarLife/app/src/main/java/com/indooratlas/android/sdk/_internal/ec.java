package com.indooratlas.android.sdk._internal;

import android.support.annotation.Nullable;
import java.util.Arrays;

public final class ec
{
  public static int[] a(@Nullable int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[] { paramInt };
    }
    int i = paramArrayOfInt.length;
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, i + 1);
    paramArrayOfInt[i] = paramInt;
    return paramArrayOfInt;
  }
  
  public static final class a
    implements ec.b
  {
    private final Object a;
    
    public a(Object paramObject)
    {
      this.a = paramObject;
    }
    
    public final boolean a(Object paramObject)
    {
      return this.a.equals(paramObject);
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract boolean a(T paramT);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */