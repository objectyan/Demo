package com.a.a;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

public final class m
{
  public final b a;
  public final String b;
  public final d c;
  public final d d;
  public final List<a> e;
  public final Set<Modifier> f;
  public final List<n> g;
  public final l h;
  public final List<l> i;
  public final Map<String, m> j;
  public final List<f> k;
  public final d l;
  public final d m;
  public final List<h> n;
  public final List<m> o;
  public final List<Element> p;
  
  private m(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama).d();
    this.e = o.a(a.e(parama));
    this.f = o.b(a.f(parama));
    this.g = o.a(a.g(parama));
    this.h = a.h(parama);
    this.i = o.a(a.i(parama));
    this.j = o.b(a.j(parama));
    this.k = o.a(a.k(parama));
    this.l = a.l(parama).d();
    this.m = a.m(parama).d();
    this.n = o.a(a.n(parama));
    this.o = o.a(a.o(parama));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(a.p(parama));
    parama = a.o(parama).iterator();
    while (parama.hasNext()) {
      localArrayList.addAll(((m)parama.next()).p);
    }
    this.p = o.a(localArrayList);
  }
  
  public static a a(c paramc)
  {
    return a(((c)o.a(paramc, "className == null", new Object[0])).f());
  }
  
  public static a a(String paramString)
  {
    return new a(b.a, (String)o.a(paramString, "name == null", new Object[0]), null, null);
  }
  
  public static a a(String paramString, Object... paramVarArgs)
  {
    return new a(b.a, null, d.b().a(paramString, paramVarArgs).d(), null);
  }
  
  public static a b(c paramc)
  {
    return b(((c)o.a(paramc, "className == null", new Object[0])).f());
  }
  
  public static a b(String paramString)
  {
    return new a(b.b, (String)o.a(paramString, "name == null", new Object[0]), null, null);
  }
  
  public static a c(c paramc)
  {
    return c(((c)o.a(paramc, "className == null", new Object[0])).f());
  }
  
  public static a c(String paramString)
  {
    return new a(b.c, (String)o.a(paramString, "name == null", new Object[0]), null, null);
  }
  
  public static a d(c paramc)
  {
    return d(((c)o.a(paramc, "className == null", new Object[0])).f());
  }
  
  public static a d(String paramString)
  {
    return new a(b.d, (String)o.a(paramString, "name == null", new Object[0]), null, null);
  }
  
  public a a()
  {
    a locala = new a(this.a, this.b, this.c, null);
    a.d(locala).a(this.d);
    a.e(locala).addAll(this.e);
    a.f(locala).addAll(this.f);
    a.g(locala).addAll(this.g);
    a.a(locala, this.h);
    a.i(locala).addAll(this.i);
    a.j(locala).putAll(this.j);
    a.k(locala).addAll(this.k);
    a.n(locala).addAll(this.n);
    a.o(locala).addAll(this.o);
    a.m(locala).a(this.m);
    a.l(locala).a(this.l);
    return locala;
  }
  
  void a(e parame, String paramString, Set<Modifier> paramSet)
    throws IOException
  {
    int i3 = parame.a;
    parame.a = -1;
    if (paramString != null) {}
    Object localObject1;
    for (;;)
    {
      try
      {
        parame.b(this.d);
        parame.a(this.e, false);
        parame.a("$L", new Object[] { paramString });
        if (!this.c.a.isEmpty())
        {
          parame.b("(");
          parame.c(this.c);
          parame.b(")");
        }
        if ((this.k.isEmpty()) && (this.n.isEmpty()))
        {
          boolean bool = this.o.isEmpty();
          if (bool) {
            return;
          }
        }
        parame.b(" {\n");
        parame.a(this);
        parame.b();
        i1 = 1;
        paramSet = this.j.entrySet().iterator();
        if (!paramSet.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)paramSet.next();
        if (i1 == 0) {
          parame.b("\n");
        }
        ((m)((Map.Entry)localObject1).getValue()).a(parame, (String)((Map.Entry)localObject1).getKey(), Collections.emptySet());
        i1 = 0;
        if (!paramSet.hasNext()) {
          break label698;
        }
        parame.b(",\n");
        continue;
        if (this.c == null) {
          break label337;
        }
      }
      finally
      {
        parame.a = i3;
      }
      if (!this.i.isEmpty()) {}
      for (paramSet = (l)this.i.get(0);; paramSet = this.h)
      {
        parame.a("new $T(", new Object[] { paramSet });
        parame.c(this.c);
        parame.b(") {\n");
        break;
      }
      label337:
      parame.b(this.d);
      parame.a(this.e, false);
      parame.a(this.f, o.a(paramSet, b.a(this.a)));
      if (this.a == b.d) {
        parame.a("$L $L", new Object[] { "@interface", this.b });
      }
      Object localObject2;
      for (;;)
      {
        parame.a(this.g);
        if (this.a != b.b) {
          break;
        }
        localObject1 = this.i;
        paramSet = Collections.emptyList();
        if (((List)localObject1).isEmpty()) {
          break label605;
        }
        parame.b(" extends");
        i1 = 1;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (l)((Iterator)localObject1).next();
          if (i1 == 0) {
            parame.b(",");
          }
          parame.a(" $T", new Object[] { localObject2 });
          i1 = 0;
        }
        parame.a("$L $L", new Object[] { this.a.name().toLowerCase(Locale.US), this.b });
      }
      if (this.h.equals(c.a)) {}
      for (paramSet = Collections.emptyList();; paramSet = Collections.singletonList(this.h))
      {
        localObject2 = this.i;
        localObject1 = paramSet;
        paramSet = (Set<Modifier>)localObject2;
        break;
      }
      label605:
      if (!paramSet.isEmpty())
      {
        parame.b(" implements");
        i1 = 1;
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          localObject1 = (l)paramSet.next();
          if (i1 == 0) {
            parame.b(",");
          }
          parame.a(" $T", new Object[] { localObject1 });
          i1 = 0;
        }
      }
      parame.b(" {\n");
      continue;
      label698:
      if ((!this.k.isEmpty()) || (!this.n.isEmpty()) || (!this.o.isEmpty())) {
        parame.b(";\n");
      } else {
        parame.b("\n");
      }
    }
    paramSet = this.k.iterator();
    while (paramSet.hasNext())
    {
      localObject1 = (f)paramSet.next();
      if (((f)localObject1).a(Modifier.STATIC))
      {
        if (i1 == 0) {
          parame.b("\n");
        }
        ((f)localObject1).a(parame, b.b(this.a));
        i1 = 0;
      }
    }
    int i2 = i1;
    if (!this.l.a())
    {
      if (i1 == 0) {
        parame.b("\n");
      }
      parame.c(this.l);
      i2 = 0;
    }
    paramSet = this.k.iterator();
    while (paramSet.hasNext())
    {
      localObject1 = (f)paramSet.next();
      if (!((f)localObject1).a(Modifier.STATIC))
      {
        if (i2 == 0) {
          parame.b("\n");
        }
        ((f)localObject1).a(parame, b.b(this.a));
        i2 = 0;
      }
    }
    int i1 = i2;
    if (!this.m.a())
    {
      if (i2 == 0) {
        parame.b("\n");
      }
      parame.c(this.m);
      i1 = 0;
    }
    paramSet = this.n.iterator();
    while (paramSet.hasNext())
    {
      localObject1 = (h)paramSet.next();
      if (((h)localObject1).a())
      {
        if (i1 == 0) {
          parame.b("\n");
        }
        ((h)localObject1).a(parame, this.b, b.c(this.a));
        i1 = 0;
      }
    }
    paramSet = this.n.iterator();
    while (paramSet.hasNext())
    {
      localObject1 = (h)paramSet.next();
      if (!((h)localObject1).a())
      {
        if (i1 == 0) {
          parame.b("\n");
        }
        ((h)localObject1).a(parame, this.b, b.c(this.a));
        i1 = 0;
      }
    }
    paramSet = this.o.iterator();
    while (paramSet.hasNext())
    {
      localObject1 = (m)paramSet.next();
      if (i1 == 0) {
        parame.b("\n");
      }
      ((m)localObject1).a(parame, null, b.d(this.a));
      i1 = 0;
    }
    parame.c();
    parame.e();
    parame.b("}");
    if ((paramString == null) && (this.c == null)) {
      parame.b("\n");
    }
    parame.a = i3;
  }
  
  public boolean a(Modifier paramModifier)
  {
    return this.f.contains(paramModifier);
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
      a(new e((Appendable)localObject), null, Collections.emptySet());
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
    private final m.b a;
    private final String b;
    private final d c;
    private final d.a d = d.b();
    private final List<a> e = new ArrayList();
    private final List<Modifier> f = new ArrayList();
    private final List<n> g = new ArrayList();
    private l h = c.a;
    private final List<l> i = new ArrayList();
    private final Map<String, m> j = new LinkedHashMap();
    private final List<f> k = new ArrayList();
    private final d.a l = d.b();
    private final d.a m = d.b();
    private final List<h> n = new ArrayList();
    private final List<m> o = new ArrayList();
    private final List<Element> p = new ArrayList();
    
    private a(m.b paramb, String paramString, d paramd)
    {
      if ((paramString == null) || (SourceVersion.isName(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "not a valid name: %s", new Object[] { paramString });
        this.a = paramb;
        this.b = paramString;
        this.c = paramd;
        return;
      }
    }
    
    public a a(a parama)
    {
      this.e.add(parama);
      return this;
    }
    
    public a a(c paramc)
    {
      return a(a.a(paramc).a());
    }
    
    public a a(d paramd)
    {
      this.l.b("static", new Object[0]).a(paramd).a();
      return this;
    }
    
    public a a(f paramf)
    {
      if (this.a != m.b.d) {}
      for (boolean bool = true;; bool = false)
      {
        o.b(bool, "%s %s cannot have fields", new Object[] { this.a, this.b });
        if (this.a == m.b.b)
        {
          o.a(paramf.e, new Modifier[] { Modifier.PUBLIC, Modifier.PRIVATE });
          EnumSet localEnumSet = EnumSet.of(Modifier.STATIC, Modifier.FINAL);
          o.b(paramf.e.containsAll(localEnumSet), "%s %s.%s requires modifiers %s", new Object[] { this.a, this.b, paramf.b, localEnumSet });
        }
        this.k.add(paramf);
        return this;
      }
    }
    
    public a a(h paramh)
    {
      if (this.a == m.b.b)
      {
        o.a(paramh.f, new Modifier[] { Modifier.ABSTRACT, Modifier.STATIC, o.a });
        o.a(paramh.f, new Modifier[] { Modifier.PUBLIC, Modifier.PRIVATE });
        if (this.a != m.b.d)
        {
          if (paramh.m != null) {
            break label247;
          }
          bool = true;
          label81:
          o.b(bool, "%s %s.%s cannot have a default value", new Object[] { this.a, this.b, paramh.c });
        }
        if (this.a != m.b.b) {
          if (o.c(paramh.f)) {
            break label252;
          }
        }
      }
      label247:
      label252:
      for (boolean bool = true;; bool = false)
      {
        o.b(bool, "%s %s.%s cannot be default", new Object[] { this.a, this.b, paramh.c });
        this.n.add(paramh);
        return this;
        if (this.a != m.b.d) {
          break;
        }
        o.b(paramh.f.equals(m.b.c(this.a)), "%s %s.%s requires modifiers %s", new Object[] { this.a, this.b, paramh.c, m.b.c(this.a) });
        break;
        bool = false;
        break label81;
      }
    }
    
    public a a(l paraml)
    {
      boolean bool2 = true;
      if (this.h == c.a)
      {
        bool1 = true;
        o.b(bool1, "superclass already set to " + this.h, new Object[0]);
        if (paraml.h()) {
          break label75;
        }
      }
      label75:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        o.a(bool1, "superclass may not be a primitive", new Object[0]);
        this.h = paraml;
        return this;
        bool1 = false;
        break;
      }
    }
    
    public a a(l paraml, String paramString, Modifier... paramVarArgs)
    {
      return a(f.a(paraml, paramString, paramVarArgs).a());
    }
    
    public a a(m paramm)
    {
      o.a(paramm.f.containsAll(m.b.d(this.a)), "%s %s.%s requires modifiers %s", new Object[] { this.a, this.b, paramm.b, m.b.d(this.a) });
      this.o.add(paramm);
      return this;
    }
    
    public a a(n paramn)
    {
      if (this.c == null) {}
      for (boolean bool = true;; bool = false)
      {
        o.b(bool, "forbidden on anonymous types.", new Object[0]);
        this.g.add(paramn);
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
          this.e.add(locala);
        }
      }
      return this;
    }
    
    public a a(String paramString)
    {
      return a(paramString, m.a("", new Object[0]).a());
    }
    
    public a a(String paramString, m paramm)
    {
      if (this.a == m.b.c)
      {
        bool = true;
        o.b(bool, "%s is not enum", new Object[] { this.b });
        if (paramm.c == null) {
          break label87;
        }
      }
      label87:
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "enum constants must have anonymous type arguments", new Object[0]);
        o.a(SourceVersion.isName(paramString), "not a valid enum constant: %s", new Object[] { paramString });
        this.j.put(paramString, paramm);
        return this;
        bool = false;
        break;
      }
    }
    
    public a a(String paramString, Object... paramVarArgs)
    {
      this.d.a(paramString, paramVarArgs);
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
    
    public a a(Element paramElement)
    {
      this.p.add(paramElement);
      return this;
    }
    
    public a a(Modifier... paramVarArgs)
    {
      if (this.c == null) {}
      for (boolean bool = true;; bool = false)
      {
        o.b(bool, "forbidden on anonymous types.", new Object[0]);
        Collections.addAll(this.f, paramVarArgs);
        return this;
      }
    }
    
    public m a()
    {
      boolean bool2 = true;
      int i1;
      label72:
      label83:
      h localh;
      if ((this.a != m.b.c) || (!this.j.isEmpty()))
      {
        bool1 = true;
        o.a(bool1, "at least one enum constant is required for %s", new Object[] { this.b });
        if ((!this.f.contains(Modifier.ABSTRACT)) && (this.a == m.b.a)) {
          break label156;
        }
        i1 = 1;
        Iterator localIterator = this.n.iterator();
        if (!localIterator.hasNext()) {
          break label166;
        }
        localh = (h)localIterator.next();
        if ((i1 == 0) && (localh.a(Modifier.ABSTRACT))) {
          break label161;
        }
      }
      label156:
      label161:
      for (boolean bool1 = true;; bool1 = false)
      {
        o.a(bool1, "non-abstract type %s cannot declare abstract method %s", new Object[] { this.b, localh.c });
        break label83;
        bool1 = false;
        break;
        i1 = 0;
        break label72;
      }
      label166:
      if (this.h.equals(c.a))
      {
        i1 = 0;
        int i2 = this.i.size();
        bool1 = bool2;
        if (this.c != null) {
          if (i1 + i2 > 1) {
            break label237;
          }
        }
      }
      label237:
      for (bool1 = bool2;; bool1 = false)
      {
        o.a(bool1, "anonymous type has too many supertypes", new Object[0]);
        return new m(this, null);
        i1 = 1;
        break;
      }
    }
    
    public a b(d paramd)
    {
      if ((this.a != m.b.a) && (this.a != m.b.c)) {
        throw new UnsupportedOperationException(this.a + " can't have initializer blocks");
      }
      this.m.a("{\n", new Object[0]).b().a(paramd).c().a("}\n", new Object[0]);
      return this;
    }
    
    public a b(l paraml)
    {
      this.i.add(paraml);
      return this;
    }
    
    public a b(Iterable<n> paramIterable)
    {
      boolean bool2 = true;
      if (this.c == null)
      {
        bool1 = true;
        o.b(bool1, "forbidden on anonymous types.", new Object[0]);
        if (paramIterable == null) {
          break label86;
        }
      }
      label86:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        o.a(bool1, "typeVariables == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          n localn = (n)paramIterable.next();
          this.g.add(localn);
        }
        bool1 = false;
        break;
      }
      return this;
    }
    
    public a b(Type paramType)
    {
      return b(l.b(paramType));
    }
    
    public a c(Iterable<? extends l> paramIterable)
    {
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "superinterfaces == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext())
        {
          l locall = (l)paramIterable.next();
          this.i.add(locall);
        }
      }
      return this;
    }
    
    public a d(Iterable<f> paramIterable)
    {
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "fieldSpecs == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext()) {
          a((f)paramIterable.next());
        }
      }
      return this;
    }
    
    public a e(Iterable<h> paramIterable)
    {
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "methodSpecs == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext()) {
          a((h)paramIterable.next());
        }
      }
      return this;
    }
    
    public a f(Iterable<m> paramIterable)
    {
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        o.a(bool, "typeSpecs == null", new Object[0]);
        paramIterable = paramIterable.iterator();
        while (paramIterable.hasNext()) {
          a((m)paramIterable.next());
        }
      }
      return this;
    }
  }
  
  public static enum b
  {
    private final Set<Modifier> e;
    private final Set<Modifier> f;
    private final Set<Modifier> g;
    private final Set<Modifier> h;
    
    private b(Set<Modifier> paramSet1, Set<Modifier> paramSet2, Set<Modifier> paramSet3, Set<Modifier> paramSet4)
    {
      this.e = paramSet1;
      this.f = paramSet2;
      this.g = paramSet3;
      this.h = paramSet4;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */