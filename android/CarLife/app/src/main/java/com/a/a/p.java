package com.a.a;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

public final class p
  extends l
{
  public final List<l> a;
  public final List<l> b;
  
  private p(List<l> paramList1, List<l> paramList2)
  {
    this(paramList1, paramList2, new ArrayList());
  }
  
  private p(List<l> paramList1, List<l> paramList2, List<a> paramList)
  {
    super(paramList);
    this.a = o.a(paramList1);
    this.b = o.a(paramList2);
    if (this.a.size() == 1)
    {
      bool = true;
      o.a(bool, "unexpected extends bounds: %s", new Object[] { paramList1 });
      paramList1 = this.a.iterator();
      label62:
      if (!paramList1.hasNext()) {
        break label128;
      }
      paramList2 = (l)paramList1.next();
      if ((paramList2.h()) || (paramList2 == d)) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      o.a(bool, "invalid upper bound: %s", new Object[] { paramList2 });
      break label62;
      bool = false;
      break;
    }
    label128:
    paramList1 = this.b.iterator();
    if (paramList1.hasNext())
    {
      paramList2 = (l)paramList1.next();
      if ((!paramList2.h()) && (paramList2 != d)) {}
      for (bool = true;; bool = false)
      {
        o.a(bool, "invalid lower bound: %s", new Object[] { paramList2 });
        break;
      }
    }
  }
  
  public static l a(java.lang.reflect.WildcardType paramWildcardType)
  {
    return a(paramWildcardType, new LinkedHashMap());
  }
  
  static l a(java.lang.reflect.WildcardType paramWildcardType, Map<Type, n> paramMap)
  {
    return new p(a(paramWildcardType.getUpperBounds(), paramMap), a(paramWildcardType.getLowerBounds(), paramMap));
  }
  
  public static l a(javax.lang.model.type.WildcardType paramWildcardType)
  {
    return a(paramWildcardType, new LinkedHashMap());
  }
  
  static l a(javax.lang.model.type.WildcardType paramWildcardType, Map<TypeParameterElement, n> paramMap)
  {
    TypeMirror localTypeMirror = paramWildcardType.getExtendsBound();
    if (localTypeMirror == null)
    {
      paramWildcardType = paramWildcardType.getSuperBound();
      if (paramWildcardType == null) {
        return a(Object.class);
      }
      return c(l.a(paramWildcardType, paramMap));
    }
    return a(l.a(localTypeMirror, paramMap));
  }
  
  public static p a(l paraml)
  {
    return new p(Arrays.asList(new l[] { paraml }), Collections.emptyList());
  }
  
  public static p a(Type paramType)
  {
    return a(l.b(paramType));
  }
  
  public static p c(l paraml)
  {
    return new p(Arrays.asList(new l[] { m }), Arrays.asList(new l[] { paraml }));
  }
  
  public static p c(Type paramType)
  {
    return c(l.b(paramType));
  }
  
  e a(e parame)
    throws IOException
  {
    if (this.b.size() == 1) {
      return parame.a("? super $T", new Object[] { this.b.get(0) });
    }
    if (((l)this.a.get(0)).equals(l.m)) {
      return parame.b("?");
    }
    return parame.a("? extends $T", new Object[] { this.a.get(0) });
  }
  
  public l a()
  {
    return new p(this.a, this.b);
  }
  
  public p a(List<a> paramList)
  {
    return new p(this.a, this.b, c(paramList));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */