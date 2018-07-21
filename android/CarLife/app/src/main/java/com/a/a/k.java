package com.a.a;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class k
  extends l
{
  public final c a;
  public final List<l> b;
  private final k c;
  
  k(k paramk, c paramc, List<l> paramList)
  {
    this(paramk, paramc, paramList, new ArrayList());
  }
  
  private k(k paramk, c paramc, List<l> paramList, List<a> paramList1)
  {
    super(paramList1);
    this.a = ((c)o.a(paramc, "rawType == null", new Object[0]));
    this.c = paramk;
    this.b = o.a(paramList);
    if ((!this.b.isEmpty()) || (paramk != null))
    {
      bool = true;
      o.a(bool, "no type arguments: %s", new Object[] { paramc });
      paramk = this.b.iterator();
      label80:
      if (!paramk.hasNext()) {
        return;
      }
      paramc = (l)paramk.next();
      if ((paramc.h()) || (paramc == d)) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      o.a(bool, "invalid type parameter: %s", new Object[] { paramc });
      break label80;
      bool = false;
      break;
    }
  }
  
  public static k a(c paramc, l... paramVarArgs)
  {
    return new k(null, paramc, Arrays.asList(paramVarArgs));
  }
  
  public static k a(Class<?> paramClass, Type... paramVarArgs)
  {
    return new k(null, c.a(paramClass), a(paramVarArgs));
  }
  
  public static k a(ParameterizedType paramParameterizedType)
  {
    return a(paramParameterizedType, new LinkedHashMap());
  }
  
  static k a(ParameterizedType paramParameterizedType, Map<Type, n> paramMap)
  {
    c localc = c.a((Class)paramParameterizedType.getRawType());
    if (((paramParameterizedType.getOwnerType() instanceof ParameterizedType)) && (!Modifier.isStatic(((Class)paramParameterizedType.getRawType()).getModifiers()))) {}
    for (ParameterizedType localParameterizedType = (ParameterizedType)paramParameterizedType.getOwnerType();; localParameterizedType = null)
    {
      paramParameterizedType = l.a(paramParameterizedType.getActualTypeArguments(), paramMap);
      if (localParameterizedType == null) {
        break;
      }
      return a(localParameterizedType, paramMap).a(localc.f(), paramParameterizedType);
    }
    return new k(null, localc, paramParameterizedType);
  }
  
  e a(e parame)
    throws IOException
  {
    if (this.c != null)
    {
      this.c.b(parame);
      this.c.a(parame);
      parame.b("." + this.a.f());
    }
    while (!this.b.isEmpty())
    {
      parame.c("<");
      int i = 1;
      Iterator localIterator = this.b.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          l locall = (l)localIterator.next();
          if (i == 0) {
            parame.c(", ");
          }
          locall.b(parame);
          locall.a(parame);
          i = 0;
          continue;
          this.a.b(parame);
          this.a.a(parame);
          break;
        }
      }
      parame.c(">");
    }
    return parame;
  }
  
  public k a(String paramString)
  {
    o.a(paramString, "name == null", new Object[0]);
    return new k(this, this.a.a(paramString), new ArrayList(), new ArrayList());
  }
  
  public k a(String paramString, List<l> paramList)
  {
    o.a(paramString, "name == null", new Object[0]);
    return new k(this, this.a.a(paramString), paramList, new ArrayList());
  }
  
  public k a(List<a> paramList)
  {
    return new k(this.c, this.a, this.b, c(paramList));
  }
  
  public l a()
  {
    return new k(this.c, this.a, this.b, new ArrayList());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */