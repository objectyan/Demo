package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.h;
import cz.msebera.android.httpclient.o.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@NotThreadSafe
public abstract class b
  implements h
{
  private final Map<String, c> a = new HashMap(10);
  
  protected c a(String paramString)
  {
    return (c)this.a.get(paramString);
  }
  
  public void a(String paramString, c paramc)
  {
    a.a(paramString, "Attribute name");
    a.a(paramc, "Attribute handler");
    this.a.put(paramString, paramc);
  }
  
  protected c b(String paramString)
  {
    c localc = a(paramString);
    if (localc == null) {
      throw new IllegalStateException("Handler not registered for " + paramString + " attribute.");
    }
    return localc;
  }
  
  protected Collection<c> c()
  {
    return this.a.values();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */