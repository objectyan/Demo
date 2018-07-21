package cz.msebera.android.httpclient.i;

import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.al;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.k.j;
import cz.msebera.android.httpclient.k.p;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.y;
import java.util.Locale;

@Immutable
public class l
  implements y
{
  public static final l a = new l();
  protected final al b;
  
  public l()
  {
    this(n.a);
  }
  
  public l(al paramal)
  {
    this.b = ((al)a.a(paramal, "Reason phrase catalog"));
  }
  
  public x a(ak paramak, int paramInt, g paramg)
  {
    a.a(paramak, "HTTP version");
    paramg = a(paramg);
    return new j(new p(paramak, paramInt, this.b.a(paramInt, paramg)), this.b, paramg);
  }
  
  public x a(an paraman, g paramg)
  {
    a.a(paraman, "Status line");
    return new j(paraman, this.b, a(paramg));
  }
  
  protected Locale a(g paramg)
  {
    return Locale.getDefault();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */