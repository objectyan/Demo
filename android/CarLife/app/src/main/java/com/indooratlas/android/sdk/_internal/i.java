package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
{
  protected static final Charset a = Charset.forName("UTF-8");
  protected static final Charset b = Charset.forName("ISO-8859-1");
  public static final Object c = new Object();
  
  public static <K, V> int a(Map<K, V> paramMap)
  {
    int j = b.d(1);
    paramMap = paramMap.entrySet().iterator();
    int k;
    for (int i = 0; paramMap.hasNext(); i = b.f(k) + (j + k) + i)
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((localObject1 == null) || (localObject2 == null)) {
        throw new IllegalStateException("keys and values in maps cannot be null");
      }
      k = b.a(1, 9, localObject1);
      k = b.a(2, 11, localObject2) + k;
    }
    return i;
  }
  
  public static final <K, V> Map<K, V> a(a parama, Map<K, V> paramMap, l.b paramb, V paramV)
    throws IOException
  {
    paramb = paramb.a(paramMap);
    int i = parama.c(parama.f());
    paramMap = null;
    int j;
    do
    {
      for (;;)
      {
        j = parama.a();
        if (j == 0) {
          break label73;
        }
        if (j == 10)
        {
          paramMap = parama.l();
        }
        else
        {
          if (j != 18) {
            break;
          }
          parama.a((m)paramV);
        }
      }
    } while (parama.b(j));
    label73:
    parama.a(0);
    parama.d(i);
    parama = paramMap;
    if (paramMap == null) {
      parama = "";
    }
    paramb.put(parama, paramV);
    return paramb;
  }
  
  public static <K, V> void a(b paramb, Map<K, V> paramMap)
    throws IOException
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if ((localObject1 == null) || (localObject2 == null)) {
        throw new IllegalStateException("keys and values in maps cannot be null");
      }
      int i = b.a(1, 9, localObject1);
      int j = b.a(2, 11, localObject2);
      paramb.g(1, 2);
      paramb.e(i + j);
      paramb.b(1, 9, localObject1);
      paramb.b(2, 11, localObject2);
    }
  }
  
  public static void a(c paramc1, c paramc2)
  {
    if (paramc1.a != null) {
      paramc2.a = paramc1.a.c();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */