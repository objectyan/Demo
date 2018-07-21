package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.s;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.x;

@Immutable
public class z
  implements s
{
  private final int a;
  private final long b;
  
  public z()
  {
    this(1, 1000);
  }
  
  public z(int paramInt1, int paramInt2)
  {
    a.a(paramInt1, "Max retries");
    a.a(paramInt2, "Retry interval");
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public boolean a(x paramx, int paramInt, g paramg)
  {
    return (paramInt <= this.a) && (paramx.a().b() == 503);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */