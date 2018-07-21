package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.u;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.m.e;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@ThreadSafe
class g
  extends e<cz.msebera.android.httpclient.e.b.b, u>
{
  public cz.msebera.android.httpclient.h.b a;
  private volatile boolean b;
  
  public g(cz.msebera.android.httpclient.h.b paramb, String paramString, cz.msebera.android.httpclient.e.b.b paramb1, u paramu, long paramLong, TimeUnit paramTimeUnit)
  {
    super(paramString, paramb1, paramu, paramLong, paramTimeUnit);
    this.a = paramb;
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = super.a(paramLong);
    if ((bool) && (this.a.a())) {
      this.a.a("Connection " + this + " expired @ " + new Date(n()));
    }
    return bool;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
    throws IOException
  {
    ((j)i()).close();
  }
  
  public void d()
    throws IOException
  {
    ((j)i()).f();
  }
  
  public boolean e()
  {
    return !((j)i()).c();
  }
  
  public void f()
  {
    try
    {
      c();
      return;
    }
    catch (IOException localIOException)
    {
      this.a.a("I/O error closing connection", localIOException);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */