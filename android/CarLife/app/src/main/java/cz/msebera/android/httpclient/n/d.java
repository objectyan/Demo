package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.o.a;

@Deprecated
public final class d
  implements g
{
  private final g a;
  private final g b;
  
  public d(g paramg1, g paramg2)
  {
    this.a = ((g)a.a(paramg1, "HTTP context"));
    this.b = paramg2;
  }
  
  public g a()
  {
    return this.b;
  }
  
  public Object a(String paramString)
  {
    Object localObject2 = this.a.a(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.b.a(paramString);
    }
    return localObject1;
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.a.a(paramString, paramObject);
  }
  
  public Object b(String paramString)
  {
    return this.a.b(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[local: ").append(this.a);
    localStringBuilder.append("defaults: ").append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/n/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */