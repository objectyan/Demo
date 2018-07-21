package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.k.d;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.x;

@Immutable
public class r
  implements cz.msebera.android.httpclient.e.h
{
  public static final r a = new r();
  
  public long a(x paramx, cz.msebera.android.httpclient.n.g paramg)
  {
    a.a(paramx, "HTTP response");
    paramx = new d(paramx.headerIterator("Keep-Alive"));
    for (;;)
    {
      Object localObject;
      if (paramx.hasNext())
      {
        localObject = paramx.a();
        paramg = ((cz.msebera.android.httpclient.g)localObject).a();
        localObject = ((cz.msebera.android.httpclient.g)localObject).b();
        if ((localObject == null) || (!paramg.equalsIgnoreCase("timeout"))) {}
      }
      else
      {
        try
        {
          long l = Long.parseLong((String)localObject);
          return l * 1000L;
        }
        catch (NumberFormatException paramg) {}
        return -1L;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */