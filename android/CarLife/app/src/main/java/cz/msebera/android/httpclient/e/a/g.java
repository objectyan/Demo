package cz.msebera.android.httpclient.e.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.b.b;
import cz.msebera.android.httpclient.o.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
@ThreadSafe
public final class g
  implements f
{
  public static final int a = 2;
  private final ConcurrentHashMap<b, Integer> b = new ConcurrentHashMap();
  private volatile int c;
  
  public g()
  {
    this(2);
  }
  
  public g(int paramInt)
  {
    a(paramInt);
  }
  
  public int a()
  {
    return this.c;
  }
  
  public int a(b paramb)
  {
    a.a(paramb, "HTTP route");
    paramb = (Integer)this.b.get(paramb);
    if (paramb != null) {
      return paramb.intValue();
    }
    return this.c;
  }
  
  public void a(int paramInt)
  {
    a.a(paramInt, "Defautl max per route");
    this.c = paramInt;
  }
  
  public void a(b paramb, int paramInt)
  {
    a.a(paramb, "HTTP route");
    a.a(paramInt, "Max per route");
    this.b.put(paramb, Integer.valueOf(paramInt));
  }
  
  public void a(Map<b, Integer> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.b.clear();
    this.b.putAll(paramMap);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */