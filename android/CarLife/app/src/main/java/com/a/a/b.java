package com.a.a;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;

public final class b
  extends l
{
  public final l a;
  
  private b(l paraml)
  {
    this(paraml, new ArrayList());
  }
  
  private b(l paraml, List<a> paramList)
  {
    super(paramList);
    this.a = ((l)o.a(paraml, "rawType == null", new Object[0]));
  }
  
  public static b a(l paraml)
  {
    return new b(paraml);
  }
  
  public static b a(GenericArrayType paramGenericArrayType)
  {
    return a(paramGenericArrayType, new LinkedHashMap());
  }
  
  static b a(GenericArrayType paramGenericArrayType, Map<Type, n> paramMap)
  {
    return a(a(paramGenericArrayType.getGenericComponentType(), paramMap));
  }
  
  public static b a(Type paramType)
  {
    return a(l.b(paramType));
  }
  
  public static b a(ArrayType paramArrayType)
  {
    return a(paramArrayType, new LinkedHashMap());
  }
  
  static b a(ArrayType paramArrayType, Map<TypeParameterElement, n> paramMap)
  {
    return new b(a(paramArrayType.getComponentType(), paramMap));
  }
  
  public b a(List<a> paramList)
  {
    return new b(this.a, c(paramList));
  }
  
  e a(e parame)
    throws IOException
  {
    return parame.a("$T[]", new Object[] { this.a });
  }
  
  public l a()
  {
    return new b(this.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */