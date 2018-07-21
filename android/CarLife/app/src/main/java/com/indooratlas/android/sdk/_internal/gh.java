package com.indooratlas.android.sdk._internal;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class gh
  implements Cloneable
{
  private static final List<gi> y = gy.a(new gi[] { gi.d, gi.c, gi.b });
  private static final List<fx> z = gy.a(new fx[] { fx.a, fx.b, fx.c });
  final ga a;
  public final Proxy b;
  public final List<gi> c;
  public final List<fx> d;
  final List<gf> e;
  public final List<gf> f;
  public final ProxySelector g;
  public final fz h;
  final fp i;
  final gt j;
  public final SocketFactory k;
  public final SSLSocketFactory l;
  public final HostnameVerifier m;
  public final ft n;
  public final fo o;
  public final fo p;
  public final fw q;
  public final gb r;
  public final boolean s;
  public final boolean t;
  public final boolean u;
  public final int v;
  public final int w;
  public final int x;
  
  static
  {
    gs.b = new gs()
    {
      public final gt a(gh paramAnonymousgh)
      {
        if (paramAnonymousgh.i != null) {
          return paramAnonymousgh.i.a;
        }
        return paramAnonymousgh.j;
      }
      
      public final gx a(fw paramAnonymousfw)
      {
        return paramAnonymousfw.e;
      }
      
      public final ii a(fw paramAnonymousfw, fn paramAnonymousfn, ig paramAnonymousig)
      {
        if ((!fw.g) && (!Thread.holdsLock(paramAnonymousfw))) {
          throw new AssertionError();
        }
        paramAnonymousfw = paramAnonymousfw.d.iterator();
        while (paramAnonymousfw.hasNext())
        {
          ii localii = (ii)paramAnonymousfw.next();
          int j = localii.i.size();
          hc localhc = localii.e;
          if (localhc != null) {}
          for (int i = localhc.a(); (j < i) && (paramAnonymousfn.equals(localii.a.a)) && (!localii.j); i = 1)
          {
            paramAnonymousig.a(localii);
            return localii;
          }
        }
        return null;
      }
      
      public final void a(fx paramAnonymousfx, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        String[] arrayOfString1;
        if (paramAnonymousfx.e != null)
        {
          arrayOfString1 = (String[])gy.a(String.class, paramAnonymousfx.e, paramAnonymousSSLSocket.getEnabledCipherSuites());
          if (paramAnonymousfx.f == null) {
            break label145;
          }
        }
        label145:
        for (String[] arrayOfString2 = (String[])gy.a(String.class, paramAnonymousfx.f, paramAnonymousSSLSocket.getEnabledProtocols());; arrayOfString2 = paramAnonymousSSLSocket.getEnabledProtocols())
        {
          String[] arrayOfString3 = arrayOfString1;
          if (paramAnonymousBoolean)
          {
            arrayOfString3 = arrayOfString1;
            if (gy.a(paramAnonymousSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
              arrayOfString3 = gy.b(arrayOfString1, "TLS_FALLBACK_SCSV");
            }
          }
          paramAnonymousfx = new fx.a(paramAnonymousfx).a(arrayOfString3).b(arrayOfString2).b();
          if (paramAnonymousfx.f != null) {
            paramAnonymousSSLSocket.setEnabledProtocols(paramAnonymousfx.f);
          }
          if (paramAnonymousfx.e != null) {
            paramAnonymousSSLSocket.setEnabledCipherSuites(paramAnonymousfx.e);
          }
          return;
          arrayOfString1 = paramAnonymousSSLSocket.getEnabledCipherSuites();
          break;
        }
      }
      
      public final void a(gd.a paramAnonymousa, String paramAnonymousString)
      {
        int i = paramAnonymousString.indexOf(":", 1);
        if (i != -1)
        {
          paramAnonymousa.b(paramAnonymousString.substring(0, i), paramAnonymousString.substring(i + 1));
          return;
        }
        if (paramAnonymousString.startsWith(":"))
        {
          paramAnonymousa.b("", paramAnonymousString.substring(1));
          return;
        }
        paramAnonymousa.b("", paramAnonymousString);
      }
      
      public final boolean a(fw paramAnonymousfw, ii paramAnonymousii)
      {
        if ((!fw.g) && (!Thread.holdsLock(paramAnonymousfw))) {
          throw new AssertionError();
        }
        if ((paramAnonymousii.j) || (paramAnonymousfw.b == 0))
        {
          paramAnonymousfw.d.remove(paramAnonymousii);
          return true;
        }
        paramAnonymousfw.notifyAll();
        return false;
      }
      
      public final void b(fw paramAnonymousfw, ii paramAnonymousii)
      {
        if ((!fw.g) && (!Thread.holdsLock(paramAnonymousfw))) {
          throw new AssertionError();
        }
        if (!paramAnonymousfw.f)
        {
          paramAnonymousfw.f = true;
          fw.a.execute(paramAnonymousfw.c);
        }
        paramAnonymousfw.d.add(paramAnonymousii);
      }
    };
  }
  
  public gh()
  {
    this(new a());
  }
  
  private gh(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.e = gy.a(parama.e);
    this.f = gy.a(parama.f);
    this.g = parama.g;
    this.h = parama.h;
    this.i = parama.i;
    this.j = parama.j;
    this.k = parama.k;
    if (parama.l != null) {
      this.l = parama.l;
    }
    for (;;)
    {
      this.m = parama.m;
      this.n = parama.n;
      this.o = parama.o;
      this.p = parama.p;
      this.q = parama.q;
      this.r = parama.r;
      this.s = parama.s;
      this.t = parama.t;
      this.u = parama.u;
      this.v = parama.v;
      this.w = parama.w;
      this.x = parama.x;
      return;
      try
      {
        SSLContext localSSLContext = SSLContext.getInstance("TLS");
        localSSLContext.init(null, null, null);
        this.l = localSSLContext.getSocketFactory();
      }
      catch (GeneralSecurityException parama)
      {
        throw new AssertionError();
      }
    }
  }
  
  public final fr a(gk paramgk)
  {
    return new gj(this, paramgk);
  }
  
  public final ga a()
  {
    return this.a;
  }
  
  public final a b()
  {
    return new a(this);
  }
  
  public static final class a
  {
    ga a;
    Proxy b;
    List<gi> c;
    List<fx> d;
    final List<gf> e = new ArrayList();
    final List<gf> f = new ArrayList();
    ProxySelector g;
    fz h;
    fp i;
    gt j;
    SocketFactory k;
    SSLSocketFactory l;
    HostnameVerifier m;
    ft n;
    fo o;
    fo p;
    fw q;
    gb r;
    boolean s;
    boolean t;
    boolean u;
    int v;
    int w;
    int x;
    
    public a()
    {
      this.a = new ga();
      this.c = gh.c();
      this.d = gh.d();
      this.g = ProxySelector.getDefault();
      this.h = fz.a;
      this.k = SocketFactory.getDefault();
      this.m = ik.a;
      this.n = ft.a;
      this.o = fo.a;
      this.p = fo.a;
      this.q = new fw();
      this.r = gb.a;
      this.s = true;
      this.t = true;
      this.u = true;
      this.v = 10000;
      this.w = 10000;
      this.x = 10000;
    }
    
    a(gh paramgh)
    {
      this.a = paramgh.a;
      this.b = paramgh.b;
      this.c = paramgh.c;
      this.d = paramgh.d;
      this.e.addAll(paramgh.e);
      this.f.addAll(paramgh.f);
      this.g = paramgh.g;
      this.h = paramgh.h;
      this.j = paramgh.j;
      this.i = paramgh.i;
      this.k = paramgh.k;
      this.l = paramgh.l;
      this.m = paramgh.m;
      this.n = paramgh.n;
      this.o = paramgh.o;
      this.p = paramgh.p;
      this.q = paramgh.q;
      this.r = paramgh.r;
      this.s = paramgh.s;
      this.t = paramgh.t;
      this.u = paramgh.u;
      this.v = paramgh.v;
      this.w = paramgh.w;
      this.x = paramgh.x;
    }
    
    public final a a(gf paramgf)
    {
      this.e.add(paramgf);
      return this;
    }
    
    public final a a(TimeUnit paramTimeUnit)
    {
      if (10L < 0L) {
        throw new IllegalArgumentException("timeout < 0");
      }
      if (paramTimeUnit == null) {
        throw new IllegalArgumentException("unit == null");
      }
      long l1 = paramTimeUnit.toMillis(10L);
      if (l1 > 2147483647L) {
        throw new IllegalArgumentException("Timeout too large.");
      }
      if ((l1 == 0L) && (10L > 0L)) {
        throw new IllegalArgumentException("Timeout too small.");
      }
      this.v = ((int)l1);
      return this;
    }
    
    public final List<gf> a()
    {
      return this.f;
    }
    
    public final a b(gf paramgf)
    {
      this.f.add(paramgf);
      return this;
    }
    
    public final a b(TimeUnit paramTimeUnit)
    {
      if (30L < 0L) {
        throw new IllegalArgumentException("timeout < 0");
      }
      if (paramTimeUnit == null) {
        throw new IllegalArgumentException("unit == null");
      }
      long l1 = paramTimeUnit.toMillis(30L);
      if (l1 > 2147483647L) {
        throw new IllegalArgumentException("Timeout too large.");
      }
      if ((l1 == 0L) && (30L > 0L)) {
        throw new IllegalArgumentException("Timeout too small.");
      }
      this.w = ((int)l1);
      return this;
    }
    
    public final gh b()
    {
      return new gh(this, (byte)0);
    }
    
    public final a c(TimeUnit paramTimeUnit)
    {
      if (10L < 0L) {
        throw new IllegalArgumentException("timeout < 0");
      }
      if (paramTimeUnit == null) {
        throw new IllegalArgumentException("unit == null");
      }
      long l1 = paramTimeUnit.toMillis(10L);
      if (l1 > 2147483647L) {
        throw new IllegalArgumentException("Timeout too large.");
      }
      if ((l1 == 0L) && (10L > 0L)) {
        throw new IllegalArgumentException("Timeout too small.");
      }
      this.x = ((int)l1);
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */