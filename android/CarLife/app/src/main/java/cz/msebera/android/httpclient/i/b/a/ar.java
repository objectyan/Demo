package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.a.k;
import cz.msebera.android.httpclient.b.a.l;
import cz.msebera.android.httpclient.b.a.m;
import cz.msebera.android.httpclient.b.d.c;
import cz.msebera.android.httpclient.k.j;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@NotThreadSafe
class ar
{
  private final m a;
  private final long b;
  private final u c;
  private final c d;
  private InputStream e;
  private k f;
  private l g;
  private boolean h;
  
  public ar(m paramm, long paramLong, u paramu, c paramc)
  {
    this.a = paramm;
    this.b = paramLong;
    this.c = paramu;
    this.d = paramc;
  }
  
  private void e()
  {
    if (this.h) {
      throw new IllegalStateException("Response has already been consumed");
    }
  }
  
  private void f()
  {
    if (!this.h) {
      throw new IllegalStateException("Response has not been consumed");
    }
  }
  
  private void g()
    throws IOException
  {
    e();
    this.h = true;
    this.f = new k(this.b);
    n localn = this.d.b();
    if (localn == null) {}
    for (;;)
    {
      return;
      String str = this.c.getRequestLine().c();
      this.e = localn.getContent();
      try
      {
        this.g = this.a.a(str, this.e, this.f);
        return;
      }
      finally
      {
        if (!this.f.c()) {
          this.e.close();
        }
      }
    }
  }
  
  protected void a()
    throws IOException
  {
    if (!this.h) {
      g();
    }
  }
  
  boolean b()
  {
    f();
    return this.f.c();
  }
  
  l c()
  {
    f();
    return this.g;
  }
  
  c d()
    throws IOException
  {
    f();
    Object localObject1 = new j(this.d.a());
    ((x)localObject1).setHeaders(this.d.getAllHeaders());
    Object localObject2 = new s(this.g, this.e);
    n localn = this.d.b();
    if (localn != null)
    {
      ((s)localObject2).a(localn.getContentType());
      ((s)localObject2).b(localn.getContentEncoding());
      ((s)localObject2).a(localn.isChunked());
    }
    ((x)localObject1).a((n)localObject2);
    localObject2 = ap.class.getClassLoader();
    localObject1 = new ap((x)localObject1)
    {
      public void a()
        throws IOException
      {
        ar.a(ar.this).close();
      }
    };
    return (c)Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { c.class }, (InvocationHandler)localObject1);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */