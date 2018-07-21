package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class hv
{
  public static final gn a = new gn()
  {
    public final gg a()
    {
      return null;
    }
    
    public final long b()
    {
      return 0L;
    }
    
    public final ip c()
    {
      return new in();
    }
  };
  public final gh b;
  public final ig c;
  public final gm d;
  public hx e;
  public long f = -1L;
  public boolean g;
  public final boolean h;
  public final gk i;
  public gk j;
  public gm k;
  public gm l;
  public jc m;
  public io n;
  public final boolean o;
  public final boolean p;
  public hp q;
  public hq r;
  
  public hv(gh paramgh, gk paramgk, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ig paramig, gm paramgm)
  {
    this.b = paramgh;
    this.i = paramgk;
    this.h = paramBoolean1;
    this.o = paramBoolean2;
    this.p = paramBoolean3;
    if (paramig != null) {}
    for (;;)
    {
      this.c = paramig;
      this.m = null;
      this.d = paramgm;
      return;
      fw localfw = paramgh.q;
      paramig = null;
      HostnameVerifier localHostnameVerifier = null;
      ft localft = null;
      if (paramgk.g())
      {
        paramig = paramgh.l;
        localHostnameVerifier = paramgh.m;
        localft = paramgh.n;
      }
      paramig = new ig(localfw, new fn(paramgk.a.b, paramgk.a.c, paramgh.r, paramgh.k, paramig, localHostnameVerifier, localft, paramgh.o, paramgh.b, paramgh.c, paramgh.d, paramgh.g));
    }
  }
  
  public static gd a(gd paramgd1, gd paramgd2)
    throws IOException
  {
    int i2 = 0;
    gd.a locala = new gd.a();
    int i3 = paramgd1.a.length / 2;
    int i1 = 0;
    while (i1 < i3)
    {
      String str1 = paramgd1.a(i1);
      String str2 = paramgd1.b(i1);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((!hy.a(str1)) || (paramgd2.a(str1) == null))) {
        locala.a(str1, str2);
      }
      i1 += 1;
    }
    i3 = paramgd2.a.length / 2;
    i1 = i2;
    while (i1 < i3)
    {
      paramgd1 = paramgd2.a(i1);
      if ((!"Content-Length".equalsIgnoreCase(paramgd1)) && (hy.a(paramgd1))) {
        locala.a(paramgd1, paramgd2.b(i1));
      }
      i1 += 1;
    }
    return locala.a();
  }
  
  public static gm a(gm paramgm)
  {
    gm localgm = paramgm;
    if (paramgm != null)
    {
      localgm = paramgm;
      if (paramgm.g != null)
      {
        paramgm = paramgm.g();
        paramgm.g = null;
        localgm = paramgm.a();
      }
    }
    return localgm;
  }
  
  public static String a(List<fy> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (i1 > 0) {
        localStringBuilder.append("; ");
      }
      fy localfy = (fy)paramList.get(i1);
      localStringBuilder.append(localfy.a).append('=').append(localfy.b);
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(gk paramgk)
  {
    return hw.b(paramgk.b);
  }
  
  public static boolean a(gm paramgm1, gm paramgm2)
  {
    if (paramgm2.c == 304) {}
    do
    {
      return true;
      paramgm1 = paramgm1.f.b("Last-Modified");
      if (paramgm1 == null) {
        break;
      }
      paramgm2 = paramgm2.f.b("Last-Modified");
    } while ((paramgm2 != null) && (paramgm2.getTime() < paramgm1.getTime()));
    return false;
  }
  
  public static boolean c(gm paramgm)
  {
    if (paramgm.a.b.equals("HEAD")) {}
    do
    {
      return false;
      int i1 = paramgm.c;
      if (((i1 < 100) || (i1 >= 200)) && (i1 != 204) && (i1 != 304)) {
        return true;
      }
    } while ((hy.a(paramgm) == -1L) && (!"chunked".equalsIgnoreCase(paramgm.a("Transfer-Encoding"))));
    return true;
  }
  
  public final hv a(IOException paramIOException)
  {
    int i2 = 1;
    Object localObject = this.c;
    if (((ig)localObject).d != null) {
      ((ig)localObject).a(paramIOException);
    }
    boolean bool;
    if (((ig)localObject).c != null)
    {
      localObject = ((ig)localObject).c;
      if ((!((ie)localObject).c()) && (!((ie)localObject).b()) && (!((ie)localObject).d())) {
        break label92;
      }
      i1 = 1;
      if (i1 == 0) {}
    }
    else
    {
      if (!(paramIOException instanceof ProtocolException)) {
        break label97;
      }
      bool = false;
      label77:
      i1 = i2;
      if (bool) {
        break label86;
      }
    }
    int i1 = 0;
    label86:
    if (i1 == 0) {}
    label92:
    label97:
    while (!this.b.u)
    {
      return null;
      i1 = 0;
      break;
      if ((paramIOException instanceof InterruptedIOException))
      {
        bool = paramIOException instanceof SocketTimeoutException;
        break label77;
      }
      if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException)))
      {
        bool = false;
        break label77;
      }
      if ((paramIOException instanceof SSLPeerUnverifiedException))
      {
        bool = false;
        break label77;
      }
      bool = true;
      break label77;
    }
    paramIOException = b();
    return new hv(this.b, this.i, this.h, this.o, this.p, paramIOException, this.d);
  }
  
  public final void a()
  {
    if (this.f != -1L) {
      throw new IllegalStateException();
    }
    this.f = System.currentTimeMillis();
  }
  
  public final void a(gd paramgd)
    throws IOException
  {
    if (this.b.h == fz.a) {}
    while (fy.a(this.i.a, paramgd).isEmpty()) {
      return;
    }
    this.b.h.a();
  }
  
  public final boolean a(ge paramge)
  {
    ge localge = this.i.a;
    return (localge.b.equals(paramge.b)) && (localge.c == paramge.c) && (localge.a.equals(paramge.a));
  }
  
  public final gm b(gm paramgm)
    throws IOException
  {
    if ((!this.g) || (!"gzip".equalsIgnoreCase(this.l.a("Content-Encoding")))) {}
    while (paramgm.g == null) {
      return paramgm;
    }
    iv localiv = new iv(paramgm.g.c());
    gd localgd = paramgm.f.a().a("Content-Encoding").a("Content-Length").a();
    paramgm = paramgm.g().a(localgd);
    paramgm.g = new hz(localgd, ix.a(localiv));
    return paramgm.a();
  }
  
  public final ig b()
  {
    if (this.n != null)
    {
      gy.a(this.n);
      if (this.l == null) {
        break label53;
      }
      gy.a(this.l.g);
    }
    for (;;)
    {
      return this.c;
      if (this.m == null) {
        break;
      }
      gy.a(this.m);
      break;
      label53:
      this.c.a(null);
    }
  }
  
  public final gm c()
    throws IOException
  {
    this.e.c();
    Object localObject = this.e.b();
    ((gm.a)localObject).a = this.j;
    ((gm.a)localObject).e = this.c.a().d;
    gm localgm = ((gm.a)localObject).a(hy.b, Long.toString(this.f)).a(hy.c, Long.toString(System.currentTimeMillis())).a();
    localObject = localgm;
    if (!this.p)
    {
      localObject = localgm.g();
      ((gm.a)localObject).g = this.e.a(localgm);
      localObject = ((gm.a)localObject).a();
    }
    if (("close".equalsIgnoreCase(((gm)localObject).a.a("Connection"))) || ("close".equalsIgnoreCase(((gm)localObject).a("Connection")))) {
      this.c.a(true, false, false);
    }
    return (gm)localObject;
  }
  
  public final class a
    implements gf.a
  {
    private final int b;
    private final gk c;
    private int d;
    
    public a(int paramInt, gk paramgk)
    {
      this.b = paramInt;
      this.c = paramgk;
    }
    
    public final gk a()
    {
      return this.c;
    }
    
    public final gm a(gk paramgk)
      throws IOException
    {
      this.d += 1;
      Object localObject1;
      Object localObject2;
      if (this.b > 0)
      {
        localObject1 = (gf)hv.this.b.f.get(this.b - 1);
        localObject2 = b().a().a;
        if ((!paramgk.a.b.equals(((fn)localObject2).a.b)) || (paramgk.a.c != ((fn)localObject2).a.c)) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must retain the same host and port");
        }
        if (this.d > 1) {
          throw new IllegalStateException("network interceptor " + localObject1 + " must call proceed() exactly once");
        }
      }
      if (this.b < hv.this.b.f.size())
      {
        localObject1 = new a(hv.this, this.b + 1, paramgk);
        localObject2 = (gf)hv.this.b.f.get(this.b);
        paramgk = ((gf)localObject2).a((gf.a)localObject1);
        if (((a)localObject1).d != 1) {
          throw new IllegalStateException("network interceptor " + localObject2 + " must call proceed() exactly once");
        }
        if (paramgk == null) {
          throw new NullPointerException("network interceptor " + localObject2 + " returned null");
        }
      }
      int i;
      do
      {
        do
        {
          return paramgk;
          hv.a(hv.this).a(paramgk);
          hv.a(hv.this, paramgk);
          if ((hv.a(paramgk)) && (paramgk.d != null))
          {
            localObject1 = ix.a(hv.a(hv.this).a(paramgk, paramgk.d.b()));
            paramgk.d.a((io)localObject1);
            ((io)localObject1).close();
          }
          localObject1 = hv.b(hv.this);
          i = ((gm)localObject1).c;
          if (i == 204) {
            break;
          }
          paramgk = (gk)localObject1;
        } while (i != 205);
        paramgk = (gk)localObject1;
      } while (((gm)localObject1).g.b() <= 0L);
      throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + ((gm)localObject1).g.b());
    }
    
    public final fv b()
    {
      return hv.this.c.a();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */