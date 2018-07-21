package cz.msebera.android.httpclient.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@NotThreadSafe
public final class e<I>
{
  private final Map<String, I> a = new HashMap();
  
  public static <I> e<I> a()
  {
    return new e();
  }
  
  public e<I> a(String paramString, I paramI)
  {
    a.a(paramString, "ID");
    a.a(paramI, "Item");
    this.a.put(paramString.toLowerCase(Locale.ENGLISH), paramI);
    return this;
  }
  
  public d<I> b()
  {
    return new d(this.a);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */