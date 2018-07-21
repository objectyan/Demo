package com.a.a;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleTypeVisitor7;

public class l
{
  private static final c a = c.a("java.lang", "Void", new String[0]);
  private static final c b = c.a("java.lang", "Boolean", new String[0]);
  private static final c c = c.a("java.lang", "Byte", new String[0]);
  public static final l d = new l("void");
  public static final l e = new l("boolean");
  public static final l f = new l("byte");
  public static final l g = new l("short");
  public static final l h = new l("int");
  public static final l i = new l("long");
  public static final l j = new l("char");
  public static final l k = new l("float");
  public static final l l = new l("double");
  public static final c m = c.a("java.lang", "Object", new String[0]);
  private static final c o = c.a("java.lang", "Short", new String[0]);
  private static final c p = c.a("java.lang", "Integer", new String[0]);
  private static final c q = c.a("java.lang", "Long", new String[0]);
  private static final c r = c.a("java.lang", "Character", new String[0]);
  private static final c s = c.a("java.lang", "Float", new String[0]);
  private static final c t = c.a("java.lang", "Double", new String[0]);
  public final List<a> n;
  private final String u;
  private String v;
  
  private l(String paramString)
  {
    this(paramString, new ArrayList());
  }
  
  private l(String paramString, List<a> paramList)
  {
    this.u = paramString;
    this.n = o.a(paramList);
  }
  
  l(List<a> paramList)
  {
    this(null, paramList);
  }
  
  static l a(Type paramType, Map<Type, n> paramMap)
  {
    if ((paramType instanceof Class))
    {
      Class localClass = (Class)paramType;
      if (paramType == Void.TYPE) {
        return d;
      }
      if (paramType == Boolean.TYPE) {
        return e;
      }
      if (paramType == Byte.TYPE) {
        return f;
      }
      if (paramType == Short.TYPE) {
        return g;
      }
      if (paramType == Integer.TYPE) {
        return h;
      }
      if (paramType == Long.TYPE) {
        return i;
      }
      if (paramType == Character.TYPE) {
        return j;
      }
      if (paramType == Float.TYPE) {
        return k;
      }
      if (paramType == Double.TYPE) {
        return l;
      }
      if (localClass.isArray()) {
        return b.a(a(localClass.getComponentType(), paramMap));
      }
      return c.a(localClass);
    }
    if ((paramType instanceof ParameterizedType)) {
      return k.a((ParameterizedType)paramType, paramMap);
    }
    if ((paramType instanceof java.lang.reflect.WildcardType)) {
      return p.a((java.lang.reflect.WildcardType)paramType, paramMap);
    }
    if ((paramType instanceof java.lang.reflect.TypeVariable)) {
      return n.a((java.lang.reflect.TypeVariable)paramType, paramMap);
    }
    if ((paramType instanceof GenericArrayType)) {
      return b.a((GenericArrayType)paramType, paramMap);
    }
    throw new IllegalArgumentException("unexpected type: " + paramType);
  }
  
  public static l a(TypeMirror paramTypeMirror)
  {
    return a(paramTypeMirror, new LinkedHashMap());
  }
  
  static l a(TypeMirror paramTypeMirror, Map<TypeParameterElement, n> paramMap)
  {
    (l)paramTypeMirror.accept(new SimpleTypeVisitor7()
    {
      public b a(ArrayType paramAnonymousArrayType, Void paramAnonymousVoid)
      {
        return b.a(paramAnonymousArrayType, this.a);
      }
      
      public l a(DeclaredType paramAnonymousDeclaredType, Void paramAnonymousVoid)
      {
        c localc = c.a((TypeElement)paramAnonymousDeclaredType.asElement());
        paramAnonymousVoid = paramAnonymousDeclaredType.getEnclosingType();
        if ((paramAnonymousVoid.getKind() != TypeKind.NONE) && (!paramAnonymousDeclaredType.asElement().getModifiers().contains(Modifier.STATIC))) {}
        for (paramAnonymousVoid = (l)paramAnonymousVoid.accept(this, null); (paramAnonymousDeclaredType.getTypeArguments().isEmpty()) && (!(paramAnonymousVoid instanceof k)); paramAnonymousVoid = null) {
          return localc;
        }
        ArrayList localArrayList = new ArrayList();
        paramAnonymousDeclaredType = paramAnonymousDeclaredType.getTypeArguments().iterator();
        while (paramAnonymousDeclaredType.hasNext()) {
          localArrayList.add(l.a((TypeMirror)paramAnonymousDeclaredType.next(), this.a));
        }
        if ((paramAnonymousVoid instanceof k)) {}
        for (paramAnonymousDeclaredType = ((k)paramAnonymousVoid).a(localc.f(), localArrayList);; paramAnonymousDeclaredType = new k(null, localc, localArrayList)) {
          return paramAnonymousDeclaredType;
        }
      }
      
      public l a(ErrorType paramAnonymousErrorType, Void paramAnonymousVoid)
      {
        return a(paramAnonymousErrorType, paramAnonymousVoid);
      }
      
      public l a(NoType paramAnonymousNoType, Void paramAnonymousVoid)
      {
        if (paramAnonymousNoType.getKind() == TypeKind.VOID) {
          return l.d;
        }
        return (l)super.visitUnknown(paramAnonymousNoType, paramAnonymousVoid);
      }
      
      public l a(PrimitiveType paramAnonymousPrimitiveType, Void paramAnonymousVoid)
      {
        switch (l.2.a[paramAnonymousPrimitiveType.getKind().ordinal()])
        {
        default: 
          throw new AssertionError();
        case 1: 
          return l.e;
        case 2: 
          return l.f;
        case 3: 
          return l.g;
        case 4: 
          return l.h;
        case 5: 
          return l.i;
        case 6: 
          return l.j;
        case 7: 
          return l.k;
        }
        return l.l;
      }
      
      protected l a(TypeMirror paramAnonymousTypeMirror, Void paramAnonymousVoid)
      {
        throw new IllegalArgumentException("Unexpected type mirror: " + paramAnonymousTypeMirror);
      }
      
      public l a(javax.lang.model.type.TypeVariable paramAnonymousTypeVariable, Void paramAnonymousVoid)
      {
        return n.a(paramAnonymousTypeVariable, this.a);
      }
      
      public l a(javax.lang.model.type.WildcardType paramAnonymousWildcardType, Void paramAnonymousVoid)
      {
        return p.a(paramAnonymousWildcardType, this.a);
      }
    }, null);
  }
  
  static List<l> a(Type[] paramArrayOfType)
  {
    return a(paramArrayOfType, new LinkedHashMap());
  }
  
  static List<l> a(Type[] paramArrayOfType, Map<Type, n> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfType.length);
    int i2 = paramArrayOfType.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localArrayList.add(a(paramArrayOfType[i1], paramMap));
      i1 += 1;
    }
    return localArrayList;
  }
  
  static l b(l paraml)
  {
    if ((paraml instanceof b)) {
      return ((b)paraml).a;
    }
    return null;
  }
  
  public static l b(Type paramType)
  {
    return a(paramType, new LinkedHashMap());
  }
  
  e a(e parame)
    throws IOException
  {
    if (this.u == null) {
      throw new AssertionError();
    }
    return parame.c(this.u);
  }
  
  public l a()
  {
    return new l(this.u);
  }
  
  public final l a(a... paramVarArgs)
  {
    return b(Arrays.asList(paramVarArgs));
  }
  
  e b(e parame)
    throws IOException
  {
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      ((a)localIterator.next()).a(parame, true);
      parame.b(" ");
    }
    return parame;
  }
  
  public l b(List<a> paramList)
  {
    o.a(paramList, "annotations == null", new Object[0]);
    return new l(this.u, c(paramList));
  }
  
  protected final List<a> c(List<a> paramList)
  {
    ArrayList localArrayList = new ArrayList(this.n);
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public final boolean equals(Object paramObject)
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
  
  public boolean g()
  {
    return !this.n.isEmpty();
  }
  
  public boolean h()
  {
    return (this.u != null) && (this != d);
  }
  
  public final int hashCode()
  {
    return toString().hashCode();
  }
  
  public boolean i()
  {
    return (equals(b)) || (equals(c)) || (equals(o)) || (equals(p)) || (equals(q)) || (equals(r)) || (equals(s)) || (equals(t));
  }
  
  public l j()
  {
    if (this.u == null) {
      return this;
    }
    if (this == d) {
      return a;
    }
    if (this == e) {
      return b;
    }
    if (this == f) {
      return c;
    }
    if (this == g) {
      return o;
    }
    if (this == h) {
      return p;
    }
    if (this == i) {
      return q;
    }
    if (this == j) {
      return r;
    }
    if (this == k) {
      return s;
    }
    if (this == l) {
      return t;
    }
    throw new AssertionError(this.u);
  }
  
  public l k()
  {
    if (this.u != null) {
      return this;
    }
    if (equals(a)) {
      return d;
    }
    if (equals(b)) {
      return e;
    }
    if (equals(c)) {
      return f;
    }
    if (equals(o)) {
      return g;
    }
    if (equals(p)) {
      return h;
    }
    if (equals(q)) {
      return i;
    }
    if (equals(r)) {
      return j;
    }
    if (equals(s)) {
      return k;
    }
    if (equals(t)) {
      return l;
    }
    throw new UnsupportedOperationException("cannot unbox " + this);
  }
  
  public final String toString()
  {
    Object localObject2 = this.v;
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      localObject1 = new StringBuilder();
      localObject2 = new e((Appendable)localObject1);
      b((e)localObject2);
      a((e)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
      this.v = ((String)localObject1);
      return (String)localObject1;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */