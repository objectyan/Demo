package cz.msebera.android.httpclient.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.d.b;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
@ThreadSafe
public final class g
  implements b<f>
{
  private final ConcurrentHashMap<String, e> a = new ConcurrentHashMap();
  
  public d a(String paramString, j paramj)
    throws IllegalStateException
  {
    a.a(paramString, "Name");
    e locale = (e)this.a.get(paramString.toLowerCase(Locale.ENGLISH));
    if (locale != null) {
      return locale.a(paramj);
    }
    throw new IllegalStateException("Unsupported authentication scheme: " + paramString);
  }
  
  public List<String> a()
  {
    return new ArrayList(this.a.keySet());
  }
  
  public void a(String paramString)
  {
    a.a(paramString, "Name");
    this.a.remove(paramString.toLowerCase(Locale.ENGLISH));
  }
  
  public void a(String paramString, e parame)
  {
    a.a(paramString, "Name");
    a.a(parame, "Authentication scheme factory");
    this.a.put(paramString.toLowerCase(Locale.ENGLISH), parame);
  }
  
  public void a(Map<String, e> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.a.clear();
    this.a.putAll(paramMap);
  }
  
  public f b(String paramString)
  {
    return new g.1(this, paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */