package com.a.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

final class e
{
  private static final String b = new String();
  int a = -1;
  private final String c;
  private final Appendable d;
  private int e;
  private boolean f = false;
  private boolean g = false;
  private String h = b;
  private final List<m> i = new ArrayList();
  private final Set<String> j;
  private final Set<String> k;
  private final Map<String, c> l;
  private final Map<String, c> m = new LinkedHashMap();
  private final Set<String> n = new LinkedHashSet();
  private boolean o;
  
  e(Appendable paramAppendable)
  {
    this(paramAppendable, "  ", Collections.emptySet());
  }
  
  e(Appendable paramAppendable, String paramString, Map<String, c> paramMap, Set<String> paramSet)
  {
    this.d = ((Appendable)o.a(paramAppendable, "out == null", new Object[0]));
    this.c = ((String)o.a(paramString, "indent == null", new Object[0]));
    this.l = ((Map)o.a(paramMap, "importedTypes == null", new Object[0]));
    this.k = ((Set)o.a(paramSet, "staticImports == null", new Object[0]));
    this.j = new LinkedHashSet();
    paramAppendable = paramSet.iterator();
    while (paramAppendable.hasNext())
    {
      paramString = (String)paramAppendable.next();
      this.j.add(paramString.substring(0, paramString.lastIndexOf('.')));
    }
  }
  
  e(Appendable paramAppendable, String paramString, Set<String> paramSet)
  {
    this(paramAppendable, paramString, Collections.emptyMap(), paramSet);
  }
  
  private c a(int paramInt, String paramString)
  {
    c localc = c.a(this.h, ((m)this.i.get(0)).b, new String[0]);
    int i1 = 1;
    while (i1 <= paramInt)
    {
      localc = localc.a(((m)this.i.get(i1)).b);
      i1 += 1;
    }
    return localc.a(paramString);
  }
  
  private void a(Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof m))
    {
      ((m)paramObject).a(this, null, Collections.emptySet());
      return;
    }
    if ((paramObject instanceof a))
    {
      ((a)paramObject).a(this, true);
      return;
    }
    if ((paramObject instanceof d))
    {
      c((d)paramObject);
      return;
    }
    c(String.valueOf(paramObject));
  }
  
  private boolean a(String paramString1, String paramString2)
    throws IOException
  {
    paramString2 = paramString2.substring(1);
    if (paramString2.isEmpty()) {}
    String str;
    do
    {
      do
      {
        return false;
      } while (!Character.isJavaIdentifierStart(paramString2.charAt(0)));
      str = paramString1 + "." + d(paramString2);
      paramString1 = paramString1 + ".*";
    } while ((!this.k.contains(str)) && (!this.k.contains(paramString1)));
    c(paramString2);
    return true;
  }
  
  private void b(c paramc)
  {
    if (paramc.b().isEmpty()) {}
    c localc;
    do
    {
      return;
      localc = paramc.d();
      paramc = localc.f();
      localc = (c)this.m.put(paramc, localc);
    } while (localc == null);
    this.m.put(paramc, localc);
  }
  
  private static String d(String paramString)
  {
    o.a(Character.isJavaIdentifierStart(paramString.charAt(0)), "not an identifier: %s", new Object[] { paramString });
    int i1 = 1;
    for (;;)
    {
      String str = paramString;
      if (i1 <= paramString.length())
      {
        if (!SourceVersion.isIdentifier(paramString.substring(0, i1))) {
          str = paramString.substring(0, i1 - 1);
        }
      }
      else {
        return str;
      }
      i1 += 1;
    }
  }
  
  private c e(String paramString)
  {
    int i1 = this.i.size() - 1;
    Object localObject;
    if (i1 >= 0)
    {
      localObject = ((m)this.i.get(i1)).o.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (Objects.equals(((m)((Iterator)localObject).next()).b, paramString)) {
          paramString = a(i1, paramString);
        }
      }
    }
    do
    {
      return paramString;
      i1 -= 1;
      break;
      if ((this.i.size() > 0) && (Objects.equals(((m)this.i.get(0)).b, paramString))) {
        return c.a(this.h, paramString, new String[0]);
      }
      localObject = (c)this.l.get(paramString);
      paramString = (String)localObject;
    } while (localObject != null);
    return null;
  }
  
  private void g()
    throws IOException
  {
    int i1 = 0;
    while (i1 < this.e)
    {
      this.d.append(this.c);
      i1 += 1;
    }
  }
  
  public e a(int paramInt)
  {
    this.e += paramInt;
    return this;
  }
  
  public e a(m paramm)
  {
    this.i.add(paramm);
    return this;
  }
  
  public e a(String paramString)
  {
    if (this.h == b) {}
    for (boolean bool = true;; bool = false)
    {
      o.b(bool, "package already set: %s", new Object[] { this.h });
      this.h = ((String)o.a(paramString, "packageName == null", new Object[0]));
      return this;
    }
  }
  
  public e a(String paramString, Object... paramVarArgs)
    throws IOException
  {
    return c(d.a(paramString, paramVarArgs));
  }
  
  String a(c paramc)
  {
    int i1 = 0;
    for (c localc1 = paramc; localc1 != null; localc1 = localc1.c())
    {
      c localc2 = e(localc1.f());
      if (localc2 != null) {}
      for (i1 = 1; Objects.equals(localc2, localc1); i1 = 0)
      {
        i1 = localc1.e().size();
        return o.a(".", paramc.e().subList(i1 - 1, paramc.e().size()));
      }
    }
    if (i1 != 0) {
      return paramc.c;
    }
    if (Objects.equals(this.h, paramc.b()))
    {
      this.n.add(paramc.d().f());
      return o.a(".", paramc.e());
    }
    if (!this.f) {
      b(paramc);
    }
    return paramc.c;
  }
  
  public Map<String, c> a()
  {
    return this.l;
  }
  
  public void a(d paramd)
    throws IOException
  {
    this.o = true;
    this.g = true;
    try
    {
      c(paramd);
      b("\n");
      return;
    }
    finally
    {
      this.g = false;
    }
  }
  
  public void a(List<n> paramList)
    throws IOException
  {
    if (paramList.isEmpty()) {
      return;
    }
    b("<");
    int i1 = 1;
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      paramList = (n)localIterator1.next();
      if (i1 == 0) {
        b(", ");
      }
      a("$L", new Object[] { paramList.a });
      i1 = 1;
      Iterator localIterator2 = paramList.b.iterator();
      if (localIterator2.hasNext())
      {
        l locall = (l)localIterator2.next();
        if (i1 != 0) {}
        for (paramList = " extends $T";; paramList = " & $T")
        {
          a(paramList, new Object[] { locall });
          i1 = 0;
          break;
        }
      }
      i1 = 0;
    }
    b(">");
  }
  
  public void a(List<a> paramList, boolean paramBoolean)
    throws IOException
  {
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      ((a)localIterator.next()).a(this, paramBoolean);
      if (paramBoolean) {}
      for (paramList = " ";; paramList = "\n")
      {
        b(paramList);
        break;
      }
    }
  }
  
  public void a(Set<Modifier> paramSet)
    throws IOException
  {
    a(paramSet, Collections.emptySet());
  }
  
  public void a(Set<Modifier> paramSet1, Set<Modifier> paramSet2)
    throws IOException
  {
    if (paramSet1.isEmpty()) {}
    for (;;)
    {
      return;
      paramSet1 = EnumSet.copyOf(paramSet1).iterator();
      while (paramSet1.hasNext())
      {
        Modifier localModifier = (Modifier)paramSet1.next();
        if (!paramSet2.contains(localModifier))
        {
          c(localModifier.name().toLowerCase(Locale.US));
          c(" ");
        }
      }
    }
  }
  
  public e b()
  {
    return a(1);
  }
  
  public e b(int paramInt)
  {
    if (this.e - paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      o.a(bool, "cannot unindent %s from %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.e) });
      this.e -= paramInt;
      return this;
    }
  }
  
  public e b(String paramString)
    throws IOException
  {
    return c(paramString);
  }
  
  public void b(d paramd)
    throws IOException
  {
    if (paramd.a()) {
      return;
    }
    b("/**\n");
    this.f = true;
    try
    {
      c(paramd);
      this.f = false;
      b(" */\n");
      return;
    }
    finally
    {
      this.f = false;
    }
  }
  
  public e c()
  {
    return b(1);
  }
  
  public e c(d paramd)
    throws IOException
  {
    int i2 = 0;
    Object localObject1 = null;
    ListIterator localListIterator = paramd.a.listIterator();
    label16:
    while (localListIterator.hasNext())
    {
      Object localObject3 = (String)localListIterator.next();
      int i1 = -1;
      switch (((String)localObject3).hashCode())
      {
      }
      for (;;)
      {
        switch (i1)
        {
        default: 
          localObject2 = localObject1;
          if (localObject1 == null) {
            break label755;
          }
          if ((!((String)localObject3).startsWith(".")) || (!a(((c)localObject1).c, (String)localObject3))) {
            break label745;
          }
          localObject1 = null;
          break label16;
          if (((String)localObject3).equals("$L"))
          {
            i1 = 0;
            continue;
            if (((String)localObject3).equals("$N"))
            {
              i1 = 1;
              continue;
              if (((String)localObject3).equals("$S"))
              {
                i1 = 2;
                continue;
                if (((String)localObject3).equals("$T"))
                {
                  i1 = 3;
                  continue;
                  if (((String)localObject3).equals("$$"))
                  {
                    i1 = 4;
                    continue;
                    if (((String)localObject3).equals("$>"))
                    {
                      i1 = 5;
                      continue;
                      if (((String)localObject3).equals("$<"))
                      {
                        i1 = 6;
                        continue;
                        if (((String)localObject3).equals("$["))
                        {
                          i1 = 7;
                          continue;
                          if (((String)localObject3).equals("$]")) {
                            i1 = 8;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      a(paramd.b.get(i2));
      i2 += 1;
      continue;
      c((String)paramd.b.get(i2));
      i2 += 1;
      continue;
      Object localObject2 = (String)paramd.b.get(i2);
      if (localObject2 != null) {}
      for (localObject2 = o.a((String)localObject2, this.c);; localObject2 = "null")
      {
        c((String)localObject2);
        i2 += 1;
        break;
      }
      localObject2 = paramd.b;
      i1 = i2 + 1;
      localObject3 = (l)((List)localObject2).get(i2);
      localObject2 = localObject3;
      if (((l)localObject3).g())
      {
        ((l)localObject3).b(this);
        localObject2 = ((l)localObject3).a();
      }
      if (((localObject2 instanceof c)) && (localListIterator.hasNext()) && (!((String)paramd.a.get(localListIterator.nextIndex())).startsWith("$")))
      {
        localObject3 = (c)localObject2;
        if (this.j.contains(((c)localObject3).c))
        {
          if (localObject1 == null) {}
          for (bool = true;; bool = false)
          {
            o.b(bool, "pending type for static import?!", new Object[0]);
            localObject1 = localObject3;
            i2 = i1;
            break;
          }
        }
      }
      ((l)localObject2).a(this);
      i2 = i1;
      continue;
      c("$");
      continue;
      b();
      continue;
      c();
      continue;
      if (this.a == -1) {}
      for (boolean bool = true;; bool = false)
      {
        o.b(bool, "statement enter $[ followed by statement enter $[", new Object[0]);
        this.a = 0;
        break;
      }
      if (this.a != -1) {}
      for (bool = true;; bool = false)
      {
        o.b(bool, "statement exit $] has no matching statement enter $[", new Object[0]);
        if (this.a > 0) {
          b(2);
        }
        this.a = -1;
        break;
      }
      label745:
      ((c)localObject1).a(this);
      localObject2 = null;
      label755:
      c((String)localObject3);
      localObject1 = localObject2;
    }
    return this;
  }
  
  e c(String paramString)
    throws IOException
  {
    int i2 = 1;
    String[] arrayOfString = paramString.split("\n", -1);
    int i3 = arrayOfString.length;
    int i1 = 0;
    if (i1 < i3)
    {
      String str = arrayOfString[i1];
      Appendable localAppendable;
      if (i2 == 0) {
        if (((this.f) || (this.g)) && (this.o))
        {
          g();
          localAppendable = this.d;
          if (!this.f) {
            break label151;
          }
        }
      }
      label151:
      for (paramString = " *";; paramString = "//")
      {
        localAppendable.append(paramString);
        this.d.append('\n');
        this.o = true;
        if (this.a != -1)
        {
          if (this.a == 0) {
            a(2);
          }
          this.a += 1;
        }
        i2 = 0;
        if (!str.isEmpty()) {
          break label158;
        }
        i1 += 1;
        break;
      }
      label158:
      if (this.o)
      {
        g();
        if (!this.f) {
          break label209;
        }
        this.d.append(" * ");
      }
      for (;;)
      {
        this.d.append(str);
        this.o = false;
        break;
        label209:
        if (this.g) {
          this.d.append("// ");
        }
      }
    }
    return this;
  }
  
  public e d()
  {
    if (this.h != b) {}
    for (boolean bool = true;; bool = false)
    {
      o.b(bool, "package already set: %s", new Object[] { this.h });
      this.h = b;
      return this;
    }
  }
  
  public e e()
  {
    this.i.remove(this.i.size() - 1);
    return this;
  }
  
  Map<String, c> f()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(this.m);
    localLinkedHashMap.keySet().removeAll(this.n);
    return localLinkedHashMap;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */