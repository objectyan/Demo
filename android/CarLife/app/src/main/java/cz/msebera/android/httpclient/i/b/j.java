package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.l;
import cz.msebera.android.httpclient.b.r;
import cz.msebera.android.httpclient.o.g;
import cz.msebera.android.httpclient.x;
import java.io.IOException;

@Immutable
public class j
  implements r<String>
{
  public String b(x paramx)
    throws l, IOException
  {
    an localan = paramx.a();
    paramx = paramx.b();
    if (localan.b() >= 300)
    {
      g.b(paramx);
      throw new l(localan.b(), localan.c());
    }
    if (paramx == null) {
      return null;
    }
    return g.f(paramx);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */