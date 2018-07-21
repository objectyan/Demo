package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.x;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@NotThreadSafe
public class j
  extends n
{
  public static final String a = "OPTIONS";
  
  public j() {}
  
  public j(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public j(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public Set<String> a(x paramx)
  {
    a.a(paramx, "HTTP response");
    paramx = paramx.headerIterator("Allow");
    HashSet localHashSet = new HashSet();
    while (paramx.hasNext())
    {
      g[] arrayOfg = paramx.a().e();
      int j = arrayOfg.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(arrayOfg[i].a());
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public String getMethod()
  {
    return "OPTIONS";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */