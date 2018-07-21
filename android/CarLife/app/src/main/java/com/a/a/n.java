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

public final class n
  extends l
{
  public final String a;
  public final List<l> b;
  
  private n(String paramString, List<l> paramList)
  {
    this(paramString, paramList, new ArrayList());
  }
  
  private n(String paramString, List<l> paramList, List<a> paramList1)
  {
    super(paramList1);
    this.a = ((String)o.a(paramString, "name == null", new Object[0]));
    this.b = paramList;
    paramString = this.b.iterator();
    if (paramString.hasNext())
    {
      paramList = (l)paramString.next();
      if ((!paramList.h()) && (paramList != d)) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "invalid bound: %s", new Object[] { paramList });
        break;
      }
    }
  }
  
  public static n a(String paramString)
  {
    return a(paramString, Collections.emptyList());
  }
  
  private static n a(String paramString, List<l> paramList)
  {
    paramList = new ArrayList(paramList);
    paramList.remove(m);
    return new n(paramString, Collections.unmodifiableList(paramList));
  }
  
  public static n a(String paramString, l... paramVarArgs)
  {
    return a(paramString, Arrays.asList(paramVarArgs));
  }
  
  public static n a(String paramString, Type... paramVarArgs)
  {
    return a(paramString, l.a(paramVarArgs));
  }
  
  public static n a(java.lang.reflect.TypeVariable<?> paramTypeVariable)
  {
    return a(paramTypeVariable, new LinkedHashMap());
  }
  
  static n a(java.lang.reflect.TypeVariable<?> paramTypeVariable, Map<Type, n> paramMap)
  {
    Object localObject2 = (n)paramMap.get(paramTypeVariable);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new ArrayList();
      localObject1 = Collections.unmodifiableList((List)localObject2);
      localObject1 = new n(paramTypeVariable.getName(), (List)localObject1);
      paramMap.put(paramTypeVariable, localObject1);
      paramTypeVariable = paramTypeVariable.getBounds();
      int j = paramTypeVariable.length;
      int i = 0;
      while (i < j)
      {
        ((List)localObject2).add(l.a(paramTypeVariable[i], paramMap));
        i += 1;
      }
      ((List)localObject2).remove(m);
    }
    return (n)localObject1;
  }
  
  public static n a(TypeParameterElement paramTypeParameterElement)
  {
    String str = paramTypeParameterElement.getSimpleName().toString();
    Object localObject = paramTypeParameterElement.getBounds();
    paramTypeParameterElement = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramTypeParameterElement.add(l.a((TypeMirror)((Iterator)localObject).next()));
    }
    return a(str, paramTypeParameterElement);
  }
  
  public static n a(javax.lang.model.type.TypeVariable paramTypeVariable)
  {
    return a((TypeParameterElement)paramTypeVariable.asElement());
  }
  
  static n a(javax.lang.model.type.TypeVariable paramTypeVariable, Map<TypeParameterElement, n> paramMap)
  {
    Object localObject2 = (TypeParameterElement)paramTypeVariable.asElement();
    Object localObject1 = (n)paramMap.get(localObject2);
    paramTypeVariable = (javax.lang.model.type.TypeVariable)localObject1;
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      paramTypeVariable = Collections.unmodifiableList((List)localObject1);
      paramTypeVariable = new n(((TypeParameterElement)localObject2).getSimpleName().toString(), paramTypeVariable);
      paramMap.put(localObject2, paramTypeVariable);
      localObject2 = ((TypeParameterElement)localObject2).getBounds().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(l.a((TypeMirror)((Iterator)localObject2).next(), paramMap));
      }
      ((List)localObject1).remove(m);
    }
    return paramTypeVariable;
  }
  
  e a(e parame)
    throws IOException
  {
    return parame.c(this.a);
  }
  
  public l a()
  {
    return new n(this.a, this.b);
  }
  
  public n a(List<a> paramList)
  {
    return new n(this.a, this.b, paramList);
  }
  
  public n a(l... paramVarArgs)
  {
    return d(Arrays.asList(paramVarArgs));
  }
  
  public n b(Type... paramVarArgs)
  {
    return d(l.a(paramVarArgs));
  }
  
  public n d(List<l> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.b);
    localArrayList.addAll(paramList);
    return new n(this.a, localArrayList, this.n);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */