package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.i.k;
import cz.msebera.android.httpclient.j.d;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.k.l;
import cz.msebera.android.httpclient.k.w;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.v;

@Immutable
public class j
  implements d<u>
{
  public static final j a = new j();
  private final w b;
  private final v c;
  
  public j()
  {
    this(null, null);
  }
  
  public j(w paramw, v paramv)
  {
    if (paramw != null)
    {
      this.b = paramw;
      if (paramv == null) {
        break label30;
      }
    }
    for (;;)
    {
      this.c = paramv;
      return;
      paramw = l.b;
      break;
      label30:
      paramv = k.a;
    }
  }
  
  public cz.msebera.android.httpclient.j.c<u> a(h paramh, cz.msebera.android.httpclient.d.c paramc)
  {
    return new i(paramh, this.b, this.c, paramc);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */