package cz.msebera.android.httpclient.l;

import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class e
  extends a
{
  private final j a;
  private final j b;
  
  public e(j paramj1, j paramj2)
  {
    this.a = ((j)cz.msebera.android.httpclient.o.a.a(paramj1, "Local HTTP parameters"));
    this.b = paramj2;
  }
  
  private Set<String> a(j paramj)
  {
    if ((paramj instanceof k)) {
      return ((k)paramj).f();
    }
    throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
  }
  
  public j a()
  {
    return this.b;
  }
  
  public j a(String paramString, Object paramObject)
  {
    return this.a.a(paramString, paramObject);
  }
  
  public Object a(String paramString)
  {
    Object localObject2 = this.a.a(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.b != null) {
        localObject1 = this.b.a(paramString);
      }
    }
    return localObject1;
  }
  
  public Set<String> b()
  {
    return new HashSet(a(this.b));
  }
  
  public boolean b(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public Set<String> c()
  {
    return new HashSet(a(this.a));
  }
  
  public j e()
  {
    return new e(this.a.e(), this.b);
  }
  
  public Set<String> f()
  {
    HashSet localHashSet = new HashSet(a(this.b));
    localHashSet.addAll(a(this.a));
    return localHashSet;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/l/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */