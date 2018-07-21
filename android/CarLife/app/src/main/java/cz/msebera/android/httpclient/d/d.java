package cz.msebera.android.httpclient.d;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public final class d<I>
  implements b<I>
{
  private final Map<String, I> a;
  
  d(Map<String, I> paramMap)
  {
    this.a = new ConcurrentHashMap(paramMap);
  }
  
  public I c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (I)this.a.get(paramString.toLowerCase(Locale.ENGLISH));
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */