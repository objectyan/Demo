package cz.msebera.android.httpclient.e.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;

@Deprecated
@Immutable
public final class e
  implements c
{
  public static final int d = 20;
  private static final f e = new e.1();
  
  @Deprecated
  public static long a(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.conn-manager.timeout", 0L);
  }
  
  public static void a(j paramj, int paramInt)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.conn-manager.max-total", paramInt);
  }
  
  @Deprecated
  public static void a(j paramj, long paramLong)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.conn-manager.timeout", paramLong);
  }
  
  public static void a(j paramj, f paramf)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.conn-manager.max-per-route", paramf);
  }
  
  public static f b(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    f localf = (f)paramj.a("http.conn-manager.max-per-route");
    paramj = localf;
    if (localf == null) {
      paramj = e;
    }
    return paramj;
  }
  
  public static int c(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.conn-manager.max-total", 20);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */