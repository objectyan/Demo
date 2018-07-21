package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.lang.reflect.Array;

public final class d<M extends c<M>, T>
{
  protected final int a;
  protected final Class<T> b;
  public final int c;
  protected final boolean d;
  
  private int b(Object paramObject)
  {
    int i = s.b(this.c);
    switch (this.a)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + this.a);
    case 10: 
      return b.b(i, (m)paramObject);
    }
    return b.c(i, (m)paramObject);
  }
  
  private void b(Object paramObject, b paramb)
  {
    for (;;)
    {
      try
      {
        paramb.e(this.c);
        switch (this.a)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.a);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (m)paramObject;
      int i = s.b(this.c);
      ((m)paramObject).a(paramb);
      paramb.g(i, 4);
      return;
      paramb.a((m)paramObject);
      return;
    }
  }
  
  final int a(Object paramObject)
  {
    int i = 0;
    if (this.d)
    {
      int m = Array.getLength(paramObject);
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        k = i;
        if (Array.get(paramObject, j) != null) {
          k = i + b(Array.get(paramObject, j));
        }
        j += 1;
        i = k;
      }
    }
    int k = b(paramObject);
    return k;
  }
  
  final void a(Object paramObject, b paramb)
    throws IOException
  {
    if (this.d)
    {
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        Object localObject = Array.get(paramObject, i);
        if (localObject != null) {
          b(localObject, paramb);
        }
        i += 1;
      }
    }
    b(paramObject, paramb);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */