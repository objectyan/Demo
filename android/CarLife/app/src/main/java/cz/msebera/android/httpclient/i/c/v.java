package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.e.b.f;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.m.e;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Deprecated
class v
  extends e<cz.msebera.android.httpclient.e.b.b, w>
{
  public cz.msebera.android.httpclient.h.b a;
  private final f b;
  
  public v(cz.msebera.android.httpclient.h.b paramb, String paramString, cz.msebera.android.httpclient.e.b.b paramb1, w paramw, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramb1, paramw, paramLong, paramTimeUnit);
    this.a = paramb;
    this.b = new f(paramb1);
  }
  
  f a()
  {
    return this.b;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = super.a(paramLong);
    if ((bool) && (this.a.a())) {
      this.a.a("Connection " + this + " expired @ " + new Date(n()));
    }
    return bool;
  }
  
  cz.msebera.android.httpclient.e.b.b b()
  {
    return (cz.msebera.android.httpclient.e.b.b)h();
  }
  
  cz.msebera.android.httpclient.e.b.b c()
  {
    return this.b.l();
  }
  
  public boolean e()
  {
    return !((w)i()).c();
  }
  
  public void f()
  {
    w localw = (w)i();
    try
    {
      localw.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.a.a("I/O error closing connection", localIOException);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */