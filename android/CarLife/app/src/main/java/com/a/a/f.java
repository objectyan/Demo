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

public final class f
{
  public final l a;
  public final String b;
  public final d c;
  public final List<a> d;
  public final Set<Modifier> e;
  public final d f;
  
  private f(a parama)
  {
    this.a = ((l)o.a(a.a(parama), "type == null", new Object[0]));
    this.b = ((String)o.a(a.b(parama), "name == null", new Object[0]));
    this.c = a.c(parama).d();
    this.d = o.a(a.d(parama));
    this.e = o.b(a.e(parama));
    if (a.f(parama) == null) {}
    for (parama = d.b().d();; parama = a.f(parama))
    {
      this.f = parama;
      return;
    }
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
    d locald = null;
    a locala = new a(this.a, this.b, null);
    a.c(locala).a(this.c);
    a.d(locala).addAll(this.d);
    a.e(locala).addAll(this.e);
    if (this.f.a()) {}
    for (;;)
    {
      a.a(locala, locald);
      return locala;
      locald = this.f;
    }
  }
  
  void a(e parame, Set<Modifier> paramSet)
    throws IOException
  {
    parame.b(this.c);
    parame.a(this.d, false);
    parame.a(this.e, paramSet);
    parame.a("$T $L", new Object[] { this.a, this.b });
    if (!this.f.a())
    {
      parame.b(" = ");
      parame.c(this.f);
    }
    parame.b(";\n");
  }
  
  public boolean a(Modifier paramModifier)
  {
    return this.e.contains(paramModifier);
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
      a(new e((Appendable)localObject), Collections.emptySet());
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
    private final d.a c = d.b();
    private final List<a> d = new ArrayList();
    private final List<Modifier> e = new ArrayList();
    private d f = null;
    
    private a(l paraml, String paramString)
    {
      this.a = paraml;
      this.b = paramString;
    }
    
    public a a(a parama)
    {
      this.d.add(parama);
      return this;
    }
    
    public a a(c paramc)
    {
      this.d.add(a.a(paramc).a());
      return this;
    }
    
    public a a(d paramd)
    {
      if (this.f == null) {}
      for (boolean bool = true;; bool = false)
      {
        o.b(bool, "initializer was already set", new Object[0]);
        this.f = ((d)o.a(paramd, "codeBlock == null", new Object[0]));
        return this;
      }
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
          this.d.add(locala);
        }
      }
      return this;
    }
    
    public a a(String paramString, Object... paramVarArgs)
    {
      this.c.a(paramString, paramVarArgs);
      return this;
    }
    
    public a a(Modifier... paramVarArgs)
    {
      Collections.addAll(this.e, paramVarArgs);
      return this;
    }
    
    public f a()
    {
      return new f(this, null);
    }
    
    public a b(String paramString, Object... paramVarArgs)
    {
      return a(d.a(paramString, paramVarArgs));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */