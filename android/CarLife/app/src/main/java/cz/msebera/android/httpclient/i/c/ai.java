package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.c.e;
import cz.msebera.android.httpclient.e.c.f;

@Deprecated
@ThreadSafe
public final class ai
{
  public static cz.msebera.android.httpclient.e.c.j a()
  {
    cz.msebera.android.httpclient.e.c.j localj = new cz.msebera.android.httpclient.e.c.j();
    localj.a(new f("http", 80, e.a()));
    localj.a(new f("https", 443, cz.msebera.android.httpclient.e.e.j.getSocketFactory()));
    return localj;
  }
  
  public static cz.msebera.android.httpclient.e.c.j b()
  {
    cz.msebera.android.httpclient.e.c.j localj = new cz.msebera.android.httpclient.e.c.j();
    localj.a(new f("http", 80, e.a()));
    localj.a(new f("https", 443, cz.msebera.android.httpclient.e.e.j.getSystemSocketFactory()));
    return localj;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */