package cz.msebera.android.httpclient.e.c;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
@ThreadSafe
public final class j
{
  private final ConcurrentHashMap<String, f> a = new ConcurrentHashMap();
  
  public final f a(f paramf)
  {
    a.a(paramf, "Scheme");
    return (f)this.a.put(paramf.d(), paramf);
  }
  
  public final f a(r paramr)
  {
    a.a(paramr, "Host");
    return a(paramr.c());
  }
  
  public final f a(String paramString)
  {
    f localf = b(paramString);
    if (localf == null) {
      throw new IllegalStateException("Scheme '" + paramString + "' not registered.");
    }
    return localf;
  }
  
  public final List<String> a()
  {
    return new ArrayList(this.a.keySet());
  }
  
  public void a(Map<String, f> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    this.a.clear();
    this.a.putAll(paramMap);
  }
  
  public final f b(String paramString)
  {
    a.a(paramString, "Scheme name");
    return (f)this.a.get(paramString);
  }
  
  public final f c(String paramString)
  {
    a.a(paramString, "Scheme name");
    return (f)this.a.remove(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */