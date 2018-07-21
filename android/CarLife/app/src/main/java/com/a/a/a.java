package com.a.a;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

public final class a
{
  public final l a;
  public final Map<String, List<d>> b;
  
  private a(a parama)
  {
    this.a = a.a(parama);
    this.b = o.a(a.b(parama));
  }
  
  public static a a(c paramc)
  {
    o.a(paramc, "type == null", new Object[0]);
    return new a(paramc, null);
  }
  
  public static a a(Class<?> paramClass)
  {
    return a(c.a(paramClass));
  }
  
  public static a a(Annotation paramAnnotation)
  {
    return a(paramAnnotation, false);
  }
  
  public static a a(Annotation paramAnnotation, boolean paramBoolean)
  {
    int i = 0;
    a locala = a(paramAnnotation.annotationType());
    for (;;)
    {
      Method localMethod;
      Object localObject;
      try
      {
        Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
        Arrays.sort(arrayOfMethod, new Comparator()
        {
          public int a(Method paramAnonymousMethod1, Method paramAnonymousMethod2)
          {
            return paramAnonymousMethod1.getName().compareTo(paramAnonymousMethod2.getName());
          }
        });
        int k = arrayOfMethod.length;
        if (i >= k) {
          break label222;
        }
        localMethod = arrayOfMethod[i];
        localObject = localMethod.invoke(paramAnnotation, new Object[0]);
        if ((!paramBoolean) && (Objects.deepEquals(localObject, localMethod.getDefaultValue()))) {
          break label228;
        }
        if (localObject.getClass().isArray())
        {
          int j = 0;
          if (j < Array.getLength(localObject))
          {
            locala.a(localMethod.getName(), Array.get(localObject, j));
            j += 1;
            continue;
          }
        }
        else if ((localObject instanceof Annotation))
        {
          locala.a(localMethod.getName(), "$L", new Object[] { a((Annotation)localObject) });
        }
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Reflecting " + paramAnnotation + " failed!", localException);
      }
      localException.a(localMethod.getName(), localObject);
      break label228;
      label222:
      return localException.a();
      label228:
      i += 1;
    }
  }
  
  public static a a(AnnotationMirror paramAnnotationMirror)
  {
    a locala = a(c.a((TypeElement)paramAnnotationMirror.getAnnotationType().asElement()));
    b localb = new b(locala);
    Iterator localIterator = paramAnnotationMirror.getElementValues().keySet().iterator();
    while (localIterator.hasNext())
    {
      ExecutableElement localExecutableElement = (ExecutableElement)localIterator.next();
      String str = localExecutableElement.getSimpleName().toString();
      ((AnnotationValue)paramAnnotationMirror.getElementValues().get(localExecutableElement)).accept(localb, str);
    }
    return locala.a();
  }
  
  private void a(e parame, String paramString1, String paramString2, List<d> paramList)
    throws IOException
  {
    if (paramList.size() == 1)
    {
      parame.a(2);
      parame.c((d)paramList.get(0));
      parame.b(2);
      return;
    }
    parame.b("{" + paramString1);
    parame.a(2);
    int i = 1;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      if (i == 0) {
        parame.b(paramString2);
      }
      parame.c(locald);
      i = 0;
    }
    parame.b(2);
    parame.b(paramString1 + "}");
  }
  
  public a a()
  {
    a locala = new a(this.a, null);
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a.b(locala).put(localEntry.getKey(), new ArrayList((Collection)localEntry.getValue()));
    }
    return locala;
  }
  
  void a(e parame, boolean paramBoolean)
    throws IOException
  {
    String str1;
    if (paramBoolean)
    {
      str1 = "";
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (String str2 = ", ";; str2 = ",\n")
    {
      if (!this.b.isEmpty()) {
        break label64;
      }
      parame.a("@$T", new Object[] { this.a });
      return;
      str1 = "\n";
      break;
    }
    label64:
    if ((this.b.size() == 1) && (this.b.containsKey("value")))
    {
      parame.a("@$T(", new Object[] { this.a });
      a(parame, str1, str2, (List)this.b.get("value"));
      parame.b(")");
      return;
    }
    parame.a("@$T(" + str1, new Object[] { this.a });
    parame.a(2);
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      parame.a("$L = ", new Object[] { localEntry.getKey() });
      a(parame, str1, str2, (List)localEntry.getValue());
      if (localIterator.hasNext()) {
        parame.b(str2);
      }
    }
    parame.b(2);
    parame.b(str1 + ")");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    return toString().equals(paramObject.toString());
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    Object localObject = new StringWriter();
    try
    {
      new e((Appendable)localObject).a("$L", new Object[] { this });
      localObject = ((StringWriter)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError();
    }
  }
  
  public static final class a
  {
    private final l a;
    private final Map<String, List<d>> b = new LinkedHashMap();
    
    private a(l paraml)
    {
      this.a = paraml;
    }
    
    public a a(String paramString, d paramd)
    {
      List localList = (List)this.b.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.b.put(paramString, localObject);
      }
      ((List)localObject).add(paramd);
      return this;
    }
    
    a a(String paramString, Object paramObject)
    {
      o.a(paramString, "memberName == null", new Object[0]);
      o.a(paramObject, "value == null, constant non-null value expected for %s", new Object[] { paramString });
      if ((paramObject instanceof Class)) {
        return a(paramString, "$T.class", new Object[] { paramObject });
      }
      if ((paramObject instanceof Enum)) {
        return a(paramString, "$T.$L", new Object[] { paramObject.getClass(), ((Enum)paramObject).name() });
      }
      if ((paramObject instanceof String)) {
        return a(paramString, "$S", new Object[] { paramObject });
      }
      if ((paramObject instanceof Float)) {
        return a(paramString, "$Lf", new Object[] { paramObject });
      }
      if ((paramObject instanceof Character)) {
        return a(paramString, "'$L'", new Object[] { o.a(((Character)paramObject).charValue()) });
      }
      return a(paramString, "$L", new Object[] { paramObject });
    }
    
    public a a(String paramString1, String paramString2, Object... paramVarArgs)
    {
      return a(paramString1, d.a(paramString2, paramVarArgs));
    }
    
    public a a()
    {
      return new a(this, null);
    }
  }
  
  private static class b
    extends SimpleAnnotationValueVisitor7<a.a, String>
  {
    final a.a a;
    
    b(a.a parama)
    {
      super();
      this.a = parama;
    }
    
    protected a.a a(Object paramObject, String paramString)
    {
      return this.a.a(paramString, paramObject);
    }
    
    public a.a a(List<? extends AnnotationValue> paramList, String paramString)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((AnnotationValue)paramList.next()).accept(this, paramString);
      }
      return this.a;
    }
    
    public a.a a(AnnotationMirror paramAnnotationMirror, String paramString)
    {
      return this.a.a(paramString, "$L", new Object[] { a.a(paramAnnotationMirror) });
    }
    
    public a.a a(VariableElement paramVariableElement, String paramString)
    {
      return this.a.a(paramString, "$T.$L", new Object[] { paramVariableElement.asType(), paramVariableElement.getSimpleName() });
    }
    
    public a.a a(TypeMirror paramTypeMirror, String paramString)
    {
      return this.a.a(paramString, "$T.class", new Object[] { paramTypeMirror });
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */