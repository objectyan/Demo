package com.a.a;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Types;

public final class h
{
  static final String a = "<init>";
  static final c b = c.a(Override.class);
  public final String c;
  public final d d;
  public final List<a> e;
  public final Set<Modifier> f;
  public final List<n> g;
  public final l h;
  public final List<j> i;
  public final boolean j;
  public final List<l> k;
  public final d l;
  public final d m;
  
  private h(a parama)
  {
    d locald = a.a(parama).d();
    if ((locald.a()) || (!a.b(parama).contains(Modifier.ABSTRACT)))
    {
      bool = true;
      o.a(bool, "abstract method %s cannot have code", new Object[] { a.c(parama) });
      if ((a.d(parama)) && (!a(a.e(parama)))) {
        break label211;
      }
    }
    label211:
    for (boolean bool = true;; bool = false)
    {
      o.a(bool, "last parameter of varargs method %s must be an array", new Object[] { a.c(parama) });
      this.c = ((String)o.a(a.c(parama), "name == null", new Object[0]));
      this.d = a.f(parama).d();
      this.e = o.a(a.g(parama));
      this.f = o.b(a.b(parama));
      this.g = o.a(a.h(parama));
      this.h = a.i(parama);
      this.i = o.a(a.e(parama));
      this.j = a.d(parama);
      this.k = o.a(a.j(parama));
      this.m = a.k(parama);
      this.l = locald;
      return;
      bool = false;
      break;
    }
  }
  
  public static a a(String paramString)
  {
    return new a(paramString, null);
  }
  
  public static a a(ExecutableElement paramExecutableElement)
  {
    o.a(paramExecutableElement, "method == null", new Object[0]);
    Object localObject1 = paramExecutableElement.getModifiers();
    if ((((Set)localObject1).contains(Modifier.PRIVATE)) || (((Set)localObject1).contains(Modifier.FINAL)) || (((Set)localObject1).contains(Modifier.STATIC))) {
      throw new IllegalArgumentException("cannot override method with modifiers: " + localObject1);
    }
    a locala = a(paramExecutableElement.getSimpleName().toString());
    locala.a(b);
    Object localObject2 = paramExecutableElement.getAnnotationMirrors().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = a.a((AnnotationMirror)((Iterator)localObject2).next());
      if (!((a)localObject3).a.equals(b)) {
        locala.a((a)localObject3);
      }
    }
    localObject1 = new LinkedHashSet((Collection)localObject1);
    ((Set)localObject1).remove(Modifier.ABSTRACT);
    locala.b((Iterable)localObject1);
    localObject1 = paramExecutableElement.getTypeParameters().iterator();
    while (((Iterator)localObject1).hasNext()) {
      locala.a(n.a((TypeVariable)((TypeParameterElement)((Iterator)localObject1).next()).asType()));
    }
    locala.a(l.a(paramExecutableElement.getReturnType()));
    localObject1 = paramExecutableElement.getParameters().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VariableElement)((Iterator)localObject1).next();
      localObject3 = l.a(((VariableElement)localObject2).asType());
      String str = ((VariableElement)localObject2).getSimpleName().toString();
      Set localSet = ((VariableElement)localObject2).getModifiers();
      localObject3 = j.a((l)localObject3, str, new Modifier[0]).a((Modifier[])localSet.toArray(new Modifier[localSet.size()]));
      localObject2 = ((VariableElement)localObject2).getAnnotationMirrors().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((j.a)localObject3).a(a.a((AnnotationMirror)((Iterator)localObject2).next()));
      }
      locala.a(((j.a)localObject3).a());
    }
    locala.a(paramExecutableElement.isVarArgs());
    paramExecutableElement = paramExecutableElement.getThrownTypes().iterator();
    while (paramExecutableElement.hasNext()) {
      locala.b(l.a((TypeMirror)paramExecutableElement.next()));
    }
    return locala;
  }
  
  public static a a(ExecutableElement paramExecutableElement, DeclaredType paramDeclaredType, Types paramTypes)
  {
    paramTypes = (ExecutableType)paramTypes.asMemberOf(paramDeclaredType, paramExecutableElement);
    paramDeclaredType = paramTypes.getParameterTypes();
    paramTypes = paramTypes.getReturnType();
    paramExecutableElement = a(paramExecutableElement);
    paramExecutableElement.a(l.a(paramTypes));
    int n = 0;
    int i1 = a.e(paramExecutableElement).size();
    while (n < i1)
    {
      paramTypes = (j)a.e(paramExecutableElement).get(n);
      l locall = l.a((TypeMirror)paramDeclaredType.get(n));
      a.e(paramExecutableElement).set(n, paramTypes.a(locall, paramTypes.a).a());
      n += 1;
    }
    return paramExecutableElement;
  }
  
  private boolean a(List<j> paramList)
  {
    return (!paramList.isEmpty()) && (l.b(((j)paramList.get(paramList.size() - 1)).d) != null);
  }
  
  public static a b()
  {
    return new a("<init>", null);
  }
  
  void a(e parame, String paramString, Set<Modifier> paramSet)
    throws IOException
  {
    parame.b(this.d);
    parame.a(this.e, false);
    parame.a(this.f, paramSet);
    if (!this.g.isEmpty())
    {
      parame.a(this.g);
      parame.b(" ");
    }
    int n;
    if (a())
    {
      parame.a("$L(", new Object[] { paramString });
      n = 1;
      paramString = this.i.iterator();
      label90:
      if (!paramString.hasNext()) {
        break label189;
      }
      paramSet = (j)paramString.next();
      if (n == 0) {
        parame.b(", ");
      }
      if ((paramString.hasNext()) || (!this.j)) {
        break label183;
      }
    }
    label183:
    for (boolean bool = true;; bool = false)
    {
      paramSet.a(parame, bool);
      n = 0;
      break label90;
      parame.a("$T $L(", new Object[] { this.h, this.c });
      break;
    }
    label189:
    parame.b(")");
    if ((this.m != null) && (!this.m.a()))
    {
      parame.b(" default ");
      parame.c(this.m);
    }
    if (!this.k.isEmpty())
    {
      parame.b(" throws");
      n = 1;
      paramString = this.k.iterator();
      while (paramString.hasNext())
      {
        paramSet = (l)paramString.next();
        if (n == 0) {
          parame.b(",");
        }
        parame.a(" $T", new Object[] { paramSet });
        n = 0;
      }
    }
    if (a(Modifier.ABSTRACT))
    {
      parame.b(";\n");
      return;
    }
    if (a(Modifier.NATIVE))
    {
      parame.c(this.l);
      parame.b(";\n");
      return;
    }
    parame.b(" {\n");
    parame.b();
    parame.c(this.l);
    parame.c();
    parame.b("}\n");
  }
  
  public boolean a()
  {
    return this.c.equals("<init>");
  }
  
  public boolean a(Modifier paramModifier)
  {
    return this.f.contains(paramModifier);
  }
  
  public a c()
  {
    a locala = new a(this.c, null);
    a.f(locala).a(this.d);
    a.g(locala).addAll(this.e);
    a.b(locala).addAll(this.f);
    a.h(locala).addAll(this.g);
    a.a(locala, this.h);
    a.e(locala).addAll(this.i);
    a.j(locala).addAll(this.k);
    a.a(locala).a(this.l);
    a.a(locala, this.j);
    a.a(locala, this.m);
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
      a(new e((Appendable)localObject), "Constructor", Collections.emptySet());
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
    private final String a;
    private final d.a b = d.b();
    private final List<a> c = new ArrayList();
    private final List<Modifier> d = new ArrayList();
    private List<n> e = new ArrayList();
    private l f;
    private final List<j> g = new ArrayList();
    private final Set<l> h = new LinkedHashSet();
    private final d.a i = d.b();
    private boolean j;
    private d k;
    
    private a(String paramString)
    {
      boolean bool;
      if ((paramString.equals("<init>")) || (SourceVersion.isName(paramString)))
      {
        bool = true;
        o.a(bool, "not a valid name: %s", new Object[] { paramString });
        this.a = paramString;
        if (!paramString.equals("<init>")) {
          break label132;
        }
      }
      label132:
      for (paramString = null;; paramString = l.d)
      {
        this.f = paramString;
        return;
        bool = false;
        break;
      }
    }
    
    public a a()
    {
      return a(true);
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
    
    public a a(d paramd)
    {
      this.i.a(paramd);
      return this;
    }
    
    public a a(j paramj)
    {
      this.g.add(paramj);
      return this;
    }
    
    public a a(l paraml)
    {
      if (!this.a.equals("<init>")) {}
      for (boolean bool = true;; bool = false)
      {
        o.b(bool, "constructor cannot have return type.", new Object[0]);
        this.f = paraml;
        return this;
      }
    }
    
    public a a(l paraml, String paramString, Modifier... paramVarArgs)
    {
      return a(j.a(paraml, paramString, paramVarArgs).a());
    }
    
    public a a(n paramn)
    {
      this.e.add(paramn);
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
    
    public a a(String paramString, Object... paramVarArgs)
    {
      this.b.a(paramString, paramVarArgs);
      return this;
    }
    
    public a a(Type paramType)
    {
      return a(l.b(paramType));
    }
    
    public a a(Type paramType, String paramString, Modifier... paramVarArgs)
    {
      return a(l.b(paramType), paramString, paramVarArgs);
    }
    
    public a a(boolean paramBoolean)
    {
      this.j = paramBoolean;
      return this;
    }
    
    public a a(Modifier... paramVarArgs)
    {
      Collections.addAll(this.d, paramVarArgs);
      return this;
    }
    
    public a b()
    {
      this.i.a();
      return this;
    }
    
    public a b(d paramd)
    {
      if (this.k == null) {}
      for (boolean bool = true;; bool = false)
      {
        o.b(bool, "defaultValue was already set", new Object[0]);
        this.k = ((d)o.a(paramd, "codeBlock == null", new Object[0]));
        return this;
      }
    }
    
    public a b(l paraml)
    {
      this.h.add(paraml);
      return this;
    }
    
    public a b(Iterable<Modifier> paramIterable)
    {
      o.a(paramIterable, "modifiers == null", new Object[0]);
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Modifier localModifier = (Modifier)paramIterable.next();
        this.d.add(localModifier);
      }
      return this;
    }
    
    public a b(String paramString, Object... paramVarArgs)
    {
      this.i.a(paramString, paramVarArgs);
      return this;
    }
    
    public a b(Type paramType)
    {
      return b(l.b(paramType));
    }
    
    public a c(Iterable<n> paramIterable)
    {
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "typeVariables == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          n localn = (n)paramIterable.next();
          this.e.add(localn);
        }
      }
      return this;
    }
    
    public a c(String paramString, Object... paramVarArgs)
    {
      return b(d.a(paramString, paramVarArgs));
    }
    
    public h c()
    {
      return new h(this, null);
    }
    
    public a d(Iterable<j> paramIterable)
    {
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "parameterSpecs == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          j localj = (j)paramIterable.next();
          this.g.add(localj);
        }
      }
      return this;
    }
    
    public a d(String paramString, Object... paramVarArgs)
    {
      this.i.b(paramString, paramVarArgs);
      return this;
    }
    
    public a e(Iterable<? extends l> paramIterable)
    {
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "exceptions == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          l locall = (l)paramIterable.next();
          this.h.add(locall);
        }
      }
      return this;
    }
    
    public a e(String paramString, Object... paramVarArgs)
    {
      this.i.c(paramString, paramVarArgs);
      return this;
    }
    
    public a f(String paramString, Object... paramVarArgs)
    {
      this.i.d(paramString, paramVarArgs);
      return this;
    }
    
    public a g(String paramString, Object... paramVarArgs)
    {
      this.i.e(paramString, paramVarArgs);
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */