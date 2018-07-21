package b;

import b.a.a.f;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class y
  implements ah.a, e.a, Cloneable
{
  static final List<z> a = b.a.c.a(new z[] { z.d, z.b });
  static final List<l> b = b.a.c.a(new l[] { l.a, l.b, l.c });
  final int A;
  final int B;
  final p c;
  final Proxy d;
  final List<z> e;
  final List<l> f;
  final List<v> g;
  final List<v> h;
  final ProxySelector i;
  final n j;
  final c k;
  final f l;
  final SocketFactory m;
  final SSLSocketFactory n;
  final b.a.i.b o;
  final HostnameVerifier p;
  final g q;
  final b r;
  final b s;
  final k t;
  final q u;
  final boolean v;
  final boolean w;
  final boolean x;
  final int y;
  final int z;
  
  static
  {
    b.a.a.a = new b.a.a()
    {
      public b.a.c.c a(k paramAnonymousk, a paramAnonymousa, b.a.c.g paramAnonymousg)
      {
        return paramAnonymousk.a(paramAnonymousa, paramAnonymousg);
      }
      
      public b.a.c.d a(k paramAnonymousk)
      {
        return paramAnonymousk.a;
      }
      
      public b.a.c.g a(e paramAnonymouse)
      {
        return ((aa)paramAnonymouse).h();
      }
      
      public e a(y paramAnonymousy, ab paramAnonymousab)
      {
        return new aa(paramAnonymousy, paramAnonymousab, true);
      }
      
      public u a(String paramAnonymousString)
        throws MalformedURLException, UnknownHostException
      {
        return u.h(paramAnonymousString);
      }
      
      public void a(l paramAnonymousl, SSLSocket paramAnonymousSSLSocket, boolean paramAnonymousBoolean)
      {
        paramAnonymousl.a(paramAnonymousSSLSocket, paramAnonymousBoolean);
      }
      
      public void a(t.a paramAnonymousa, String paramAnonymousString)
      {
        paramAnonymousa.a(paramAnonymousString);
      }
      
      public void a(t.a paramAnonymousa, String paramAnonymousString1, String paramAnonymousString2)
      {
        paramAnonymousa.b(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void a(y.a paramAnonymousa, f paramAnonymousf)
      {
        paramAnonymousa.a(paramAnonymousf);
      }
      
      public boolean a(k paramAnonymousk, b.a.c.c paramAnonymousc)
      {
        return paramAnonymousk.b(paramAnonymousc);
      }
      
      public void b(k paramAnonymousk, b.a.c.c paramAnonymousc)
      {
        paramAnonymousk.a(paramAnonymousc);
      }
    };
  }
  
  public y()
  {
    this(new a());
  }
  
  y(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.f = parama.d;
    this.g = b.a.c.a(parama.e);
    this.h = b.a.c.a(parama.f);
    this.i = parama.g;
    this.j = parama.h;
    this.k = parama.i;
    this.l = parama.j;
    this.m = parama.k;
    int i1 = 0;
    Object localObject = this.f.iterator();
    if (((Iterator)localObject).hasNext())
    {
      l locall = (l)((Iterator)localObject).next();
      if ((i1 != 0) || (locall.a())) {}
      for (i1 = 1;; i1 = 0) {
        break;
      }
    }
    if ((parama.l != null) || (i1 == 0)) {
      this.n = parama.l;
    }
    for (this.o = parama.m;; this.o = b.a.i.b.a((X509TrustManager)localObject))
    {
      this.p = parama.n;
      this.q = parama.o.a(this.o);
      this.r = parama.p;
      this.s = parama.q;
      this.t = parama.r;
      this.u = parama.s;
      this.v = parama.t;
      this.w = parama.u;
      this.x = parama.v;
      this.y = parama.w;
      this.z = parama.x;
      this.A = parama.y;
      this.B = parama.z;
      return;
      localObject = A();
      this.n = a((X509TrustManager)localObject);
    }
  }
  
  private X509TrustManager A()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length != 1) || (!(localObject[0] instanceof X509TrustManager))) {
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString((Object[])localObject));
      }
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw new AssertionError();
    }
    X509TrustManager localX509TrustManager = (X509TrustManager)localGeneralSecurityException[0];
    return localX509TrustManager;
  }
  
  private SSLSocketFactory a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
      throw new AssertionError();
    }
  }
  
  public int a()
  {
    return this.y;
  }
  
  public ah a(ab paramab, ai paramai)
  {
    paramab = new b.a.j.a(paramab, paramai, new SecureRandom());
    paramab.a(this);
    return paramab;
  }
  
  public e a(ab paramab)
  {
    return new aa(this, paramab, false);
  }
  
  public int b()
  {
    return this.z;
  }
  
  public int c()
  {
    return this.A;
  }
  
  public int d()
  {
    return this.B;
  }
  
  public Proxy e()
  {
    return this.d;
  }
  
  public ProxySelector f()
  {
    return this.i;
  }
  
  public n g()
  {
    return this.j;
  }
  
  public c h()
  {
    return this.k;
  }
  
  f i()
  {
    if (this.k != null) {
      return this.k.a;
    }
    return this.l;
  }
  
  public q j()
  {
    return this.u;
  }
  
  public SocketFactory k()
  {
    return this.m;
  }
  
  public SSLSocketFactory l()
  {
    return this.n;
  }
  
  public HostnameVerifier m()
  {
    return this.p;
  }
  
  public g n()
  {
    return this.q;
  }
  
  public b o()
  {
    return this.s;
  }
  
  public b p()
  {
    return this.r;
  }
  
  public k q()
  {
    return this.t;
  }
  
  public boolean r()
  {
    return this.v;
  }
  
  public boolean s()
  {
    return this.w;
  }
  
  public boolean t()
  {
    return this.x;
  }
  
  public p u()
  {
    return this.c;
  }
  
  public List<z> v()
  {
    return this.e;
  }
  
  public List<l> w()
  {
    return this.f;
  }
  
  public List<v> x()
  {
    return this.g;
  }
  
  public List<v> y()
  {
    return this.h;
  }
  
  public a z()
  {
    return new a(this);
  }
  
  public static final class a
  {
    p a;
    Proxy b;
    List<z> c;
    List<l> d;
    final List<v> e = new ArrayList();
    final List<v> f = new ArrayList();
    ProxySelector g;
    n h;
    c i;
    f j;
    SocketFactory k;
    SSLSocketFactory l;
    b.a.i.b m;
    HostnameVerifier n;
    g o;
    b p;
    b q;
    k r;
    q s;
    boolean t;
    boolean u;
    boolean v;
    int w;
    int x;
    int y;
    int z;
    
    public a()
    {
      this.a = new p();
      this.c = y.a;
      this.d = y.b;
      this.g = ProxySelector.getDefault();
      this.h = n.b;
      this.k = SocketFactory.getDefault();
      this.n = b.a.i.d.a;
      this.o = g.a;
      this.p = b.a;
      this.q = b.a;
      this.r = new k();
      this.s = q.a;
      this.t = true;
      this.u = true;
      this.v = true;
      this.w = 10000;
      this.x = 10000;
      this.y = 10000;
      this.z = 0;
    }
    
    a(y paramy)
    {
      this.a = paramy.c;
      this.b = paramy.d;
      this.c = paramy.e;
      this.d = paramy.f;
      this.e.addAll(paramy.g);
      this.f.addAll(paramy.h);
      this.g = paramy.i;
      this.h = paramy.j;
      this.j = paramy.l;
      this.i = paramy.k;
      this.k = paramy.m;
      this.l = paramy.n;
      this.m = paramy.o;
      this.n = paramy.p;
      this.o = paramy.q;
      this.p = paramy.r;
      this.q = paramy.s;
      this.r = paramy.t;
      this.s = paramy.u;
      this.t = paramy.v;
      this.u = paramy.w;
      this.v = paramy.x;
      this.w = paramy.y;
      this.x = paramy.z;
      this.y = paramy.A;
      this.z = paramy.B;
    }
    
    private static int a(String paramString, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException(paramString + " < 0");
      }
      if (paramTimeUnit == null) {
        throw new NullPointerException("unit == null");
      }
      long l1 = paramTimeUnit.toMillis(paramLong);
      if (l1 > 2147483647L) {
        throw new IllegalArgumentException(paramString + " too large.");
      }
      if ((l1 == 0L) && (paramLong > 0L)) {
        throw new IllegalArgumentException(paramString + " too small.");
      }
      return (int)l1;
    }
    
    public a a(long paramLong, TimeUnit paramTimeUnit)
    {
      this.w = a("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public a a(b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException("authenticator == null");
      }
      this.q = paramb;
      return this;
    }
    
    public a a(c paramc)
    {
      this.i = paramc;
      this.j = null;
      return this;
    }
    
    public a a(g paramg)
    {
      if (paramg == null) {
        throw new NullPointerException("certificatePinner == null");
      }
      this.o = paramg;
      return this;
    }
    
    public a a(k paramk)
    {
      if (paramk == null) {
        throw new NullPointerException("connectionPool == null");
      }
      this.r = paramk;
      return this;
    }
    
    public a a(n paramn)
    {
      if (paramn == null) {
        throw new NullPointerException("cookieJar == null");
      }
      this.h = paramn;
      return this;
    }
    
    public a a(p paramp)
    {
      if (paramp == null) {
        throw new IllegalArgumentException("dispatcher == null");
      }
      this.a = paramp;
      return this;
    }
    
    public a a(q paramq)
    {
      if (paramq == null) {
        throw new NullPointerException("dns == null");
      }
      this.s = paramq;
      return this;
    }
    
    public a a(v paramv)
    {
      this.e.add(paramv);
      return this;
    }
    
    public a a(Proxy paramProxy)
    {
      this.b = paramProxy;
      return this;
    }
    
    public a a(ProxySelector paramProxySelector)
    {
      this.g = paramProxySelector;
      return this;
    }
    
    public a a(List<z> paramList)
    {
      paramList = new ArrayList(paramList);
      if (!paramList.contains(z.b)) {
        throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + paramList);
      }
      if (paramList.contains(z.a)) {
        throw new IllegalArgumentException("protocols must not contain http/1.0: " + paramList);
      }
      if (paramList.contains(null)) {
        throw new IllegalArgumentException("protocols must not contain null");
      }
      if (paramList.contains(z.c)) {
        paramList.remove(z.c);
      }
      this.c = Collections.unmodifiableList(paramList);
      return this;
    }
    
    public a a(SocketFactory paramSocketFactory)
    {
      if (paramSocketFactory == null) {
        throw new NullPointerException("socketFactory == null");
      }
      this.k = paramSocketFactory;
      return this;
    }
    
    public a a(HostnameVerifier paramHostnameVerifier)
    {
      if (paramHostnameVerifier == null) {
        throw new NullPointerException("hostnameVerifier == null");
      }
      this.n = paramHostnameVerifier;
      return this;
    }
    
    public a a(SSLSocketFactory paramSSLSocketFactory)
    {
      if (paramSSLSocketFactory == null) {
        throw new NullPointerException("sslSocketFactory == null");
      }
      X509TrustManager localX509TrustManager = b.a.h.e.b().a(paramSSLSocketFactory);
      if (localX509TrustManager == null) {
        throw new IllegalStateException("Unable to extract the trust manager on " + b.a.h.e.b() + ", sslSocketFactory is " + paramSSLSocketFactory.getClass());
      }
      this.l = paramSSLSocketFactory;
      this.m = b.a.i.b.a(localX509TrustManager);
      return this;
    }
    
    public a a(SSLSocketFactory paramSSLSocketFactory, X509TrustManager paramX509TrustManager)
    {
      if (paramSSLSocketFactory == null) {
        throw new NullPointerException("sslSocketFactory == null");
      }
      if (paramX509TrustManager == null) {
        throw new NullPointerException("trustManager == null");
      }
      this.l = paramSSLSocketFactory;
      this.m = b.a.i.b.a(paramX509TrustManager);
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.t = paramBoolean;
      return this;
    }
    
    public List<v> a()
    {
      return this.e;
    }
    
    void a(f paramf)
    {
      this.j = paramf;
      this.i = null;
    }
    
    public a b(long paramLong, TimeUnit paramTimeUnit)
    {
      this.x = a("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public a b(b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException("proxyAuthenticator == null");
      }
      this.p = paramb;
      return this;
    }
    
    public a b(v paramv)
    {
      this.f.add(paramv);
      return this;
    }
    
    public a b(List<l> paramList)
    {
      this.d = b.a.c.a(paramList);
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.u = paramBoolean;
      return this;
    }
    
    public List<v> b()
    {
      return this.f;
    }
    
    public a c(long paramLong, TimeUnit paramTimeUnit)
    {
      this.y = a("timeout", paramLong, paramTimeUnit);
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.v = paramBoolean;
      return this;
    }
    
    public y c()
    {
      return new y(this);
    }
    
    public a d(long paramLong, TimeUnit paramTimeUnit)
    {
      this.z = a("interval", paramLong, paramTimeUnit);
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */