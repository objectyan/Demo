package cz.msebera.android.httpclient.f;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.d.b;
import cz.msebera.android.httpclient.o.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
@ThreadSafe
public final class k
  implements b<j>
{
  private final ConcurrentHashMap<String, i> a = new ConcurrentHashMap();
  
  public h a(String paramString, cz.msebera.android.httpclient.l.j paramj)
    throws IllegalStateException
  {
    a.a(paramString, "Name");
    i locali = (i)this.a.get(paramString.toLowerCase(Locale.ENGLISH));
    if (locali != null) {
      return locali.a(paramj);
    }
    throw new IllegalStateException("Unsupported cookie spec: " + paramString);
  }
  
  public List<String> a()
  {
    return new ArrayList(this.a.keySet());
  }
  
  public void a(String paramString)
  {
    a.a(paramString, "Id");
    this.a.remove(paramString.toLowerCase(Locale.ENGLISH));
  }
  
  public void a(String paramString, i parami)
  {
    a.a(paramString, "Name");
    a.a(parami, "Cookie spec factory");
    this.a.put(paramString.toLowerCase(Locale.ENGLISH), parami);
  }
  
  public void a(Map<String, i> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.a.clear();
    this.a.putAll(paramMap);
  }
  
  public h b(String paramString)
    throws IllegalStateException
  {
    return a(paramString, null);
  }
  
  public j d(String paramString)
  {
    return new k.1(this, paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/f/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */