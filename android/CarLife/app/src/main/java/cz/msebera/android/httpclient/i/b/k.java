package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.l.j;

@Deprecated
@NotThreadSafe
public class k
  extends cz.msebera.android.httpclient.l.a
{
  protected final j a;
  protected final j b;
  protected final j c;
  protected final j d;
  
  public k(k paramk)
  {
    this(paramk.a(), paramk.b(), paramk.c(), paramk.d());
  }
  
  public k(k paramk, j paramj1, j paramj2, j paramj3, j paramj4) {}
  
  public k(j paramj1, j paramj2, j paramj3, j paramj4)
  {
    this.a = paramj1;
    this.b = paramj2;
    this.c = paramj3;
    this.d = paramj4;
  }
  
  public final j a()
  {
    return this.a;
  }
  
  public j a(String paramString, Object paramObject)
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
  }
  
  public Object a(String paramString)
  {
    cz.msebera.android.httpclient.o.a.a(paramString, "Parameter name");
    Object localObject2 = null;
    if (this.d != null) {
      localObject2 = this.d.a(paramString);
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.c != null) {
        localObject1 = this.c.a(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.b != null) {
        localObject2 = this.b.a(paramString);
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.a != null) {
        localObject1 = this.a.a(paramString);
      }
    }
    return localObject1;
  }
  
  public final j b()
  {
    return this.b;
  }
  
  public boolean b(String paramString)
  {
    throw new UnsupportedOperationException("Removing parameters in a stack is not supported.");
  }
  
  public final j c()
  {
    return this.c;
  }
  
  public final j d()
  {
    return this.d;
  }
  
  public j e()
  {
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */