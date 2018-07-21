package com.a.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

public final class c
  extends l
  implements Comparable<c>
{
  public static final c a = a(Object.class);
  final List<String> b;
  final String c;
  
  private c(List<String> paramList)
  {
    this(paramList, new ArrayList());
  }
  
  private c(List<String> paramList, List<a> paramList1)
  {
    super(paramList1);
    int i = 1;
    while (i < paramList.size())
    {
      o.a(SourceVersion.isName((CharSequence)paramList.get(i)), "part '%s' is keyword", new Object[] { paramList.get(i) });
      i += 1;
    }
    this.b = o.a(paramList);
    if (((String)paramList.get(0)).isEmpty()) {}
    for (paramList = o.a(".", paramList.subList(1, paramList.size()));; paramList = o.a(".", paramList))
    {
      this.c = paramList;
      return;
    }
  }
  
  public static c a(Class<?> paramClass)
  {
    boolean bool2 = true;
    o.a(paramClass, "clazz == null", new Object[0]);
    boolean bool1;
    label44:
    label63:
    ArrayList localArrayList;
    if (!paramClass.isPrimitive())
    {
      bool1 = true;
      o.a(bool1, "primitive types cannot be represented as a ClassName", new Object[0]);
      if (Void.TYPE.equals(paramClass)) {
        break label157;
      }
      bool1 = true;
      o.a(bool1, "'void' type cannot be represented as a ClassName", new Object[0]);
      if (paramClass.isArray()) {
        break label162;
      }
      bool1 = bool2;
      o.a(bool1, "array types cannot be represented as a ClassName", new Object[0]);
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      localArrayList.add(paramClass.getSimpleName());
      Class localClass = paramClass.getEnclosingClass();
      if (localClass == null)
      {
        int i = paramClass.getName().lastIndexOf('.');
        if (i != -1) {
          localArrayList.add(paramClass.getName().substring(0, i));
        }
        Collections.reverse(localArrayList);
        return new c(localArrayList);
        bool1 = false;
        break;
        label157:
        bool1 = false;
        break label44;
        label162:
        bool1 = false;
        break label63;
      }
      paramClass = localClass;
    }
  }
  
  public static c a(String paramString1, String paramString2, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    localArrayList.add(paramString2);
    Collections.addAll(localArrayList, paramVarArgs);
    return new c(localArrayList);
  }
  
  public static c a(TypeElement paramTypeElement)
  {
    o.a(paramTypeElement, "element == null", new Object[0]);
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramTypeElement;
    if (a((Element)localObject))
    {
      if ((paramTypeElement.getNestingKind() == NestingKind.TOP_LEVEL) || (paramTypeElement.getNestingKind() == NestingKind.MEMBER)) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "unexpected type testing", new Object[0]);
        localArrayList.add(((Element)localObject).getSimpleName().toString());
        localObject = ((Element)localObject).getEnclosingElement();
        break;
      }
    }
    localArrayList.add(b(paramTypeElement).getQualifiedName().toString());
    Collections.reverse(localArrayList);
    return new c(localArrayList);
  }
  
  private static boolean a(Element paramElement)
  {
    return (paramElement.getKind().isClass()) || (paramElement.getKind().isInterface());
  }
  
  private static PackageElement b(Element paramElement)
  {
    while (paramElement.getKind() != ElementKind.PACKAGE) {
      paramElement = paramElement.getEnclosingElement();
    }
    return (PackageElement)paramElement;
  }
  
  public static c c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if ((i < paramString.length()) && (Character.isLowerCase(paramString.codePointAt(i))))
    {
      i = paramString.indexOf('.', i) + 1;
      if (i != 0) {}
      for (bool = true;; bool = false)
      {
        o.a(bool, "couldn't make a guess for %s", new Object[] { paramString });
        break;
      }
    }
    Object localObject1;
    label111:
    Object localObject2;
    if (i != 0)
    {
      localObject1 = paramString.substring(0, i - 1);
      localArrayList.add(localObject1);
      localObject1 = paramString.substring(i).split("\\.", -1);
      int j = localObject1.length;
      i = 0;
      if (i >= j) {
        break label187;
      }
      localObject2 = localObject1[i];
      if ((((String)localObject2).isEmpty()) || (!Character.isUpperCase(((String)localObject2).codePointAt(0)))) {
        break label182;
      }
    }
    label182:
    for (boolean bool = true;; bool = false)
    {
      o.a(bool, "couldn't make a guess for %s", new Object[] { paramString });
      localArrayList.add(localObject2);
      i += 1;
      break label111;
      localObject1 = "";
      break;
    }
    label187:
    if (localArrayList.size() >= 2) {}
    for (bool = true;; bool = false)
    {
      o.a(bool, "couldn't make a guess for %s", new Object[] { paramString });
      return new c(localArrayList);
    }
  }
  
  public int a(c paramc)
  {
    return this.c.compareTo(paramc.c);
  }
  
  public c a(String paramString)
  {
    o.a(paramString, "name == null", new Object[0]);
    ArrayList localArrayList = new ArrayList(this.b.size() + 1);
    localArrayList.addAll(this.b);
    localArrayList.add(paramString);
    return new c(localArrayList);
  }
  
  public c a(List<a> paramList)
  {
    return new c(this.b, c(paramList));
  }
  
  e a(e parame)
    throws IOException
  {
    return parame.c(parame.a(this));
  }
  
  public l a()
  {
    return new c(this.b);
  }
  
  public c b(String paramString)
  {
    ArrayList localArrayList = new ArrayList(this.b);
    localArrayList.set(localArrayList.size() - 1, paramString);
    return new c(localArrayList);
  }
  
  public String b()
  {
    return (String)this.b.get(0);
  }
  
  public c c()
  {
    if (this.b.size() == 2) {
      return null;
    }
    return new c(this.b.subList(0, this.b.size() - 1));
  }
  
  public c d()
  {
    return new c(this.b.subList(0, 2));
  }
  
  public List<String> e()
  {
    return this.b.subList(1, this.b.size());
  }
  
  public String f()
  {
    return (String)this.b.get(this.b.size() - 1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */