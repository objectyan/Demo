package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class a
  implements g
{
  private final g a;
  private final Map<String, Object> b = new ConcurrentHashMap();
  
  public a()
  {
    this(null);
  }
  
  public a(g paramg)
  {
    this.a = paramg;
  }
  
  public Object a(String paramString)
  {
    cz.msebera.android.httpclient.o.a.a(paramString, "Id");
    Object localObject2 = this.b.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.a != null) {
        localObject1 = this.a.a(paramString);
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(String paramString, Object paramObject)
  {
    cz.msebera.android.httpclient.o.a.a(paramString, "Id");
    if (paramObject != null)
    {
      this.b.put(paramString, paramObject);
      return;
    }
    this.b.remove(paramString);
  }
  
  public Object b(String paramString)
  {
    cz.msebera.android.httpclient.o.a.a(paramString, "Id");
    return this.b.remove(paramString);
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */