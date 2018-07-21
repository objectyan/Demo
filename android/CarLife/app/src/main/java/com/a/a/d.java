package com.a.a;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

public final class d
{
  final List<String> a;
  final List<Object> b;
  
  private d(a parama)
  {
    this.a = o.a(parama.a);
    this.b = o.a(parama.b);
  }
  
  public static d a(String paramString, Object... paramVarArgs)
  {
    return new a(null).a(paramString, paramVarArgs).d();
  }
  
  public static a b()
  {
    return new a(null);
  }
  
  public boolean a()
  {
    return this.a.isEmpty();
  }
  
  public a c()
  {
    a locala = new a(null);
    locala.a.addAll(this.a);
    locala.b.addAll(this.b);
    return locala;
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
      new e((Appendable)localObject).c(this);
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
    final List<String> a = new ArrayList();
    final List<Object> b = new ArrayList();
    
    private String a(Object paramObject)
    {
      if ((paramObject instanceof CharSequence)) {
        return paramObject.toString();
      }
      if ((paramObject instanceof j)) {
        return ((j)paramObject).a;
      }
      if ((paramObject instanceof f)) {
        return ((f)paramObject).b;
      }
      if ((paramObject instanceof h)) {
        return ((h)paramObject).c;
      }
      if ((paramObject instanceof m)) {
        return ((m)paramObject).b;
      }
      throw new IllegalArgumentException("expected name but was " + paramObject);
    }
    
    private Object b(Object paramObject)
    {
      return paramObject;
    }
    
    private String c(Object paramObject)
    {
      if (paramObject != null) {
        return String.valueOf(paramObject);
      }
      return null;
    }
    
    private l d(Object paramObject)
    {
      if ((paramObject instanceof l)) {
        return (l)paramObject;
      }
      if ((paramObject instanceof TypeMirror)) {
        return l.a((TypeMirror)paramObject);
      }
      if ((paramObject instanceof Element)) {
        return l.a(((Element)paramObject).asType());
      }
      if ((paramObject instanceof Type)) {
        return l.b((Type)paramObject);
      }
      throw new IllegalArgumentException("expected type but was " + paramObject);
    }
    
    public a a()
    {
      c();
      a("}\n", new Object[0]);
      return this;
    }
    
    public a a(d paramd)
    {
      this.a.addAll(paramd.a);
      this.b.addAll(paramd.b);
      return this;
    }
    
    public a a(String paramString, Object... paramVarArgs)
    {
      int m = 0;
      int n = 0;
      int j = 0;
      int[] arrayOfInt = new int[paramVarArgs.length];
      int i = 0;
      int i1;
      int k;
      while (i < paramString.length()) {
        if (paramString.charAt(i) != '$')
        {
          i1 = paramString.indexOf('$', i + 1);
          k = i1;
          if (i1 == -1) {
            k = paramString.length();
          }
          this.a.add(paramString.substring(i, k));
          i = k;
        }
        else
        {
          i1 = i + 1;
          i = i1;
        }
      }
      label117:
      label252:
      label258:
      label302:
      label317:
      label473:
      label479:
      label711:
      label761:
      label769:
      for (;;)
      {
        k = i;
        char c;
        int i2;
        if (k < paramString.length())
        {
          bool = true;
          o.a(bool, "dangling format characters in '%s'", new Object[] { paramString });
          i = k + 1;
          c = paramString.charAt(k);
          if ((c >= '0') && (c <= '9')) {
            break label769;
          }
          i2 = i - 1;
          if ((c != '$') && (c != '>') && (c != '<') && (c != '[') && (c != ']')) {
            break label258;
          }
          if (i1 != i2) {
            break label252;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          o.a(bool, "$$, $>, $<, $[ and $] may not have an index", new Object[0]);
          this.a.add("$" + c);
          break;
          bool = false;
          break label117;
        }
        if (i1 < i2)
        {
          k = Integer.parseInt(paramString.substring(i1, i2)) - 1;
          n = 1;
          int i3 = k % paramVarArgs.length;
          arrayOfInt[i3] += 1;
          if ((k < 0) || (k >= paramVarArgs.length)) {
            break label473;
          }
          bool = true;
          o.a(bool, "index %d for '%s' not in range (received %s arguments)", new Object[] { Integer.valueOf(k + 1), paramString.substring(i1 - 1, i2 + 1), Integer.valueOf(paramVarArgs.length) });
          if ((n != 0) && (m != 0)) {
            break label479;
          }
        }
        for (bool = true;; bool = false)
        {
          o.a(bool, "cannot mix indexed and positional parameters", new Object[0]);
          switch (c)
          {
          case 'M': 
          case 'O': 
          case 'P': 
          case 'Q': 
          case 'R': 
          default: 
            throw new IllegalArgumentException(String.format("invalid format string: '%s'", new Object[] { paramString }));
            k = j;
            m = 1;
            j += 1;
            break label302;
            bool = false;
            break label317;
          }
        }
        this.b.add(a(paramVarArgs[k]));
        for (;;)
        {
          this.a.add("$" + c);
          break;
          this.b.add(b(paramVarArgs[k]));
          continue;
          this.b.add(c(paramVarArgs[k]));
          continue;
          this.b.add(d(paramVarArgs[k]));
        }
        if (m != 0) {
          if (j < paramVarArgs.length) {
            break label711;
          }
        }
        ArrayList localArrayList;
        for (bool = true;; bool = false)
        {
          o.a(bool, "unused arguments: expected %s, received %s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramVarArgs.length) });
          if (n == 0) {
            break label761;
          }
          localArrayList = new ArrayList();
          i = 0;
          while (i < paramVarArgs.length)
          {
            if (arrayOfInt[i] == 0) {
              localArrayList.add("$" + (i + 1));
            }
            i += 1;
          }
        }
        if (localArrayList.size() == 1) {}
        for (paramString = "";; paramString = "s")
        {
          o.a(localArrayList.isEmpty(), "unused argument%s: %s", new Object[] { paramString, o.a(", ", localArrayList) });
          return this;
        }
      }
    }
    
    public a b()
    {
      this.a.add("$>");
      return this;
    }
    
    public a b(String paramString, Object... paramVarArgs)
    {
      a(paramString + " {\n", paramVarArgs);
      b();
      return this;
    }
    
    public a c()
    {
      this.a.add("$<");
      return this;
    }
    
    public a c(String paramString, Object... paramVarArgs)
    {
      c();
      a("} " + paramString + " {\n", paramVarArgs);
      b();
      return this;
    }
    
    public a d(String paramString, Object... paramVarArgs)
    {
      c();
      a("} " + paramString + ";\n", paramVarArgs);
      return this;
    }
    
    public d d()
    {
      return new d(this, null);
    }
    
    public a e(String paramString, Object... paramVarArgs)
    {
      a("$[", new Object[0]);
      a(paramString, paramVarArgs);
      a(";\n$]", new Object[0]);
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */