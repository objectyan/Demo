package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.h;
import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class i
  implements cz.msebera.android.httpclient.b.i
{
  private final ConcurrentHashMap<h, n> a = new ConcurrentHashMap();
  
  private static n a(Map<h, n> paramMap, h paramh)
  {
    n localn = (n)paramMap.get(paramh);
    Object localObject2 = localn;
    if (localn == null)
    {
      int i = -1;
      Object localObject1 = null;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (h)localIterator.next();
        int j = paramh.a((h)localObject2);
        if (j > i)
        {
          i = j;
          localObject1 = localObject2;
        }
      }
      localObject2 = localn;
      if (localObject1 != null) {
        localObject2 = (n)paramMap.get(localObject1);
      }
    }
    return (n)localObject2;
  }
  
  public n a(h paramh)
  {
    a.a(paramh, "Authentication scope");
    return a(this.a, paramh);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(h paramh, n paramn)
  {
    a.a(paramh, "Authentication scope");
    this.a.put(paramh, paramn);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */