package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.m;
import java.util.HashMap;
import java.util.Map;

@NotThreadSafe
public class o
  implements m
{
  public static final String a = "http.request-count";
  public static final String b = "http.response-count";
  public static final String c = "http.sent-bytes-count";
  public static final String d = "http.received-bytes-count";
  private final g e;
  private final g f;
  private long g = 0L;
  private long h = 0L;
  private Map<String, Object> i;
  
  public o(g paramg1, g paramg2)
  {
    this.e = paramg1;
    this.f = paramg2;
  }
  
  public long a()
  {
    return this.g;
  }
  
  public Object a(String paramString)
  {
    Object localObject1 = null;
    if (this.i != null) {
      localObject1 = this.i.get(paramString);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (!"http.request-count".equals(paramString)) {
        break label45;
      }
      localObject2 = Long.valueOf(this.g);
    }
    label45:
    do
    {
      return localObject2;
      if ("http.response-count".equals(paramString)) {
        return Long.valueOf(this.h);
      }
      if ("http.received-bytes-count".equals(paramString))
      {
        if (this.e != null) {
          return Long.valueOf(this.e.a());
        }
        return null;
      }
      localObject2 = localObject1;
    } while (!"http.sent-bytes-count".equals(paramString));
    if (this.f != null) {
      return Long.valueOf(this.f.a());
    }
    return null;
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (this.i == null) {
      this.i = new HashMap();
    }
    this.i.put(paramString, paramObject);
  }
  
  public long b()
  {
    return this.h;
  }
  
  public long c()
  {
    if (this.f != null) {
      return this.f.a();
    }
    return -1L;
  }
  
  public long d()
  {
    if (this.e != null) {
      return this.e.a();
    }
    return -1L;
  }
  
  public void e()
  {
    if (this.f != null) {
      this.f.b();
    }
    if (this.e != null) {
      this.e.b();
    }
    this.g = 0L;
    this.h = 0L;
    this.i = null;
  }
  
  public void f()
  {
    this.g += 1L;
  }
  
  public void g()
  {
    this.h += 1L;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */