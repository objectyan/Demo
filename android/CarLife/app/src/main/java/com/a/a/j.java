package com.a.a;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

public final class j
{
  public final String a;
  public final List<a> b;
  public final Set<Modifier> c;
  public final l d;
  
  private j(a parama)
  {
    this.a = ((String)o.a(a.a(parama), "name == null", new Object[0]));
    this.b = o.a(a.b(parama));
    this.c = o.b(a.c(parama));
    this.d = ((l)o.a(a.d(parama), "type == null", new Object[0]));
  }
  
  public static a a(l paraml, String paramString, Modifier... paramVarArgs)
  {
    o.a(paraml, "type == null", new Object[0]);
    o.a(SourceVersion.isName(paramString), "not a valid name: %s", new Object[] { paramString });
    return new a(paraml, paramString, null).a(paramVarArgs);
  }
  
  public static a a(Type paramType, String paramString, Modifier... paramVarArgs)
  {
    return a(l.b(paramType), paramString, paramVarArgs);
  }
  
  public a a()
  {
    return a(this.d, this.a);
  }
  
  a a(l paraml, String paramString)
  {
    paraml = new a(paraml, paramString, null);
    a.b(paraml).addAll(this.b);
    a.c(paraml).addAll(this.c);
    return paraml;
  }
  
  void a(e parame, boolean paramBoolean)
    throws IOException
  {
    parame.a(this.b, true);
    parame.a(this.c);
    if (paramBoolean)
    {
      parame.a("$T... $L", new Object[] { l.b(this.d), this.a });
      return;
    }
    parame.a("$T $L", new Object[] { this.d, this.a });
  }
  
  public boolean a(Modifier paramModifier)
  {
    return this.c.contains(paramModifier);
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
      a(new e((Appendable)localObject), false);
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
    private final String b;
    private final List<a> c = new ArrayList();
    private final List<Modifier> d = new ArrayList();
    
    private a(l paraml, String paramString)
    {
      this.a = paraml;
      this.b = paramString;
    }
    
    public a a(a parama)
    {
      this.c.add(parama);
      return this;
    }
    
    public a a(c paramc)
    {
      this.c.add(a.a(paramc).a());
      return this;
    }
    
    public a a(Class<?> paramClass)
    {
      return a(c.a(paramClass));
    }
    
    public a a(Iterable<a> paramIterable)
    {
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "annotationSpecs == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          a locala = (a)paramIterable.next();
          this.c.add(locala);
        }
      }
      return this;
    }
    
    public a a(Modifier... paramVarArgs)
    {
      Collections.addAll(this.d, paramVarArgs);
      return this;
    }
    
    public j a()
    {
      return new j(this, null);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */