package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ThreadSafe
public class u
  implements x
{
  static final int a = 1000;
  static final int b = 10;
  private final int c;
  private final ConcurrentMap<String, y> d;
  
  public u()
  {
    this(1000);
  }
  
  public u(int paramInt)
  {
    this.c = paramInt;
    this.d = new ConcurrentHashMap();
  }
  
  private void a()
  {
    if (this.d.size() > this.c)
    {
      y localy = b();
      if (localy != null) {
        this.d.remove(localy.b(), localy);
      }
    }
  }
  
  private y b()
  {
    long l1 = Long.MAX_VALUE;
    y localy = null;
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      long l2 = ((y)localEntry.getValue()).a();
      if (l2 < l1)
      {
        l1 = l2;
        localy = (y)localEntry.getValue();
      }
    }
    return localy;
  }
  
  private void d(String paramString)
  {
    int i = 0;
    for (;;)
    {
      y localy1;
      if (i < 10)
      {
        localy1 = (y)this.d.get(paramString);
        if (localy1 != null) {
          break label55;
        }
        localy1 = new y(paramString, 1);
        if (this.d.putIfAbsent(paramString, localy1) != null) {
          break label97;
        }
      }
      label55:
      y localy2;
      do
      {
        int j;
        do
        {
          return;
          j = localy1.c();
        } while (j == Integer.MAX_VALUE);
        localy2 = new y(paramString, j + 1);
      } while (this.d.replace(paramString, localy1, localy2));
      label97:
      i += 1;
    }
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("identifier may not be null");
    }
    paramString = (y)this.d.get(paramString);
    if (paramString != null) {
      return paramString.c();
    }
    return 0;
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("identifier may not be null");
    }
    this.d.remove(paramString);
  }
  
  public void c(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("identifier may not be null");
    }
    d(paramString);
    a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */