package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.m;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;

@NotThreadSafe
class h
  implements cz.msebera.android.httpclient.e.u, cz.msebera.android.httpclient.n.g
{
  private volatile g a;
  
  h(g paramg)
  {
    this.a = paramg;
  }
  
  public static g a(j paramj)
  {
    paramj = c(paramj).l();
    if (paramj == null) {
      throw new i();
    }
    return paramj;
  }
  
  public static j a(g paramg)
  {
    return new h(paramg);
  }
  
  public static g b(j paramj)
  {
    return c(paramj).m();
  }
  
  private static h c(j paramj)
  {
    if (!h.class.isInstance(paramj)) {
      throw new IllegalStateException("Unexpected connection proxy class: " + paramj.getClass());
    }
    return (h)h.class.cast(paramj);
  }
  
  public x a()
    throws p, IOException
  {
    return p().a();
  }
  
  public Object a(String paramString)
  {
    cz.msebera.android.httpclient.e.u localu = p();
    if ((localu instanceof cz.msebera.android.httpclient.n.g)) {
      return ((cz.msebera.android.httpclient.n.g)localu).a(paramString);
    }
    return null;
  }
  
  public void a(o paramo)
    throws p, IOException
  {
    p().a(paramo);
  }
  
  public void a(cz.msebera.android.httpclient.u paramu)
    throws p, IOException
  {
    p().a(paramu);
  }
  
  public void a(x paramx)
    throws p, IOException
  {
    p().a(paramx);
  }
  
  public void a(String paramString, Object paramObject)
  {
    cz.msebera.android.httpclient.e.u localu = p();
    if ((localu instanceof cz.msebera.android.httpclient.n.g)) {
      ((cz.msebera.android.httpclient.n.g)localu).a(paramString, paramObject);
    }
  }
  
  public void a(Socket paramSocket)
    throws IOException
  {
    p().a(paramSocket);
  }
  
  public boolean a(int paramInt)
    throws IOException
  {
    return p().a(paramInt);
  }
  
  public Object b(String paramString)
  {
    cz.msebera.android.httpclient.e.u localu = p();
    if ((localu instanceof cz.msebera.android.httpclient.n.g)) {
      return ((cz.msebera.android.httpclient.n.g)localu).b(paramString);
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    p().b(paramInt);
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    g localg = this.a;
    boolean bool1 = bool2;
    if (localg != null)
    {
      bool1 = bool2;
      if (!localg.e()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void close()
    throws IOException
  {
    g localg = this.a;
    if (localg != null) {
      localg.c();
    }
  }
  
  public boolean d()
  {
    cz.msebera.android.httpclient.e.u localu = o();
    if (localu != null) {
      return localu.d();
    }
    return true;
  }
  
  public int e()
  {
    return p().e();
  }
  
  public void f()
    throws IOException
  {
    g localg = this.a;
    if (localg != null) {
      localg.d();
    }
  }
  
  public m g()
  {
    return p().g();
  }
  
  public InetAddress h()
  {
    return p().h();
  }
  
  public void h_()
    throws IOException
  {
    p().h_();
  }
  
  public int i()
  {
    return p().i();
  }
  
  public InetAddress j()
  {
    return p().j();
  }
  
  public int k()
  {
    return p().k();
  }
  
  g l()
  {
    return this.a;
  }
  
  g m()
  {
    g localg = this.a;
    this.a = null;
    return localg;
  }
  
  public SSLSession n()
  {
    return p().n();
  }
  
  cz.msebera.android.httpclient.e.u o()
  {
    g localg = this.a;
    if (localg == null) {
      return null;
    }
    return (cz.msebera.android.httpclient.e.u)localg.i();
  }
  
  cz.msebera.android.httpclient.e.u p()
  {
    cz.msebera.android.httpclient.e.u localu = o();
    if (localu == null) {
      throw new i();
    }
    return localu;
  }
  
  public String s()
  {
    return p().s();
  }
  
  public Socket t()
  {
    return p().t();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CPoolProxy{");
    cz.msebera.android.httpclient.e.u localu = o();
    if (localu != null) {
      localStringBuilder.append(localu);
    }
    for (;;)
    {
      localStringBuilder.append('}');
      return localStringBuilder.toString();
      localStringBuilder.append("detached");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */