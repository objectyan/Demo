package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.i.c.al;
import cz.msebera.android.httpclient.i.d.ac;
import cz.msebera.android.httpclient.i.d.aj;
import cz.msebera.android.httpclient.n.aa;
import java.io.Closeable;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

@NotThreadSafe
public class ag
{
  static final String a;
  private cz.msebera.android.httpclient.b.i A;
  private String B;
  private cz.msebera.android.httpclient.r C;
  private Collection<? extends cz.msebera.android.httpclient.f> D;
  private cz.msebera.android.httpclient.d.f E;
  private cz.msebera.android.httpclient.d.a F;
  private cz.msebera.android.httpclient.b.b.c G;
  private boolean H;
  private boolean I;
  private boolean J;
  private boolean K;
  private boolean L;
  private boolean M;
  private boolean N;
  private int O = 0;
  private int P = 0;
  private List<Closeable> Q;
  private cz.msebera.android.httpclient.n.m b;
  private cz.msebera.android.httpclient.e.e.n c;
  private cz.msebera.android.httpclient.e.d.b d;
  private SSLContext e;
  private cz.msebera.android.httpclient.e.o f;
  private cz.msebera.android.httpclient.e.x g;
  private cz.msebera.android.httpclient.b h;
  private cz.msebera.android.httpclient.e.h i;
  private cz.msebera.android.httpclient.b.c j;
  private cz.msebera.android.httpclient.b.c k;
  private cz.msebera.android.httpclient.b.t l;
  private cz.msebera.android.httpclient.n.k m;
  private LinkedList<cz.msebera.android.httpclient.w> n;
  private LinkedList<cz.msebera.android.httpclient.w> o;
  private LinkedList<cz.msebera.android.httpclient.z> p;
  private LinkedList<cz.msebera.android.httpclient.z> q;
  private cz.msebera.android.httpclient.b.k r;
  private cz.msebera.android.httpclient.e.b.d s;
  private cz.msebera.android.httpclient.b.p t;
  private cz.msebera.android.httpclient.b.g u;
  private cz.msebera.android.httpclient.b.d v;
  private cz.msebera.android.httpclient.b.s w;
  private cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.a.f> x;
  private cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.f.j> y;
  private cz.msebera.android.httpclient.b.h z;
  
  static
  {
    Object localObject = cz.msebera.android.httpclient.o.l.a("cz.msebera.android.httpclient.client", ag.class.getClassLoader());
    if (localObject != null) {}
    for (localObject = ((cz.msebera.android.httpclient.o.l)localObject).c();; localObject = "UNAVAILABLE")
    {
      a = "Apache-HttpClient/" + (String)localObject + " (java 1.5)";
      return;
    }
  }
  
  public static ag a()
  {
    return new ag();
  }
  
  private static String[] b(String paramString)
  {
    if (cz.msebera.android.httpclient.o.k.b(paramString)) {
      return null;
    }
    return paramString.split(" *, *");
  }
  
  public final ag a(int paramInt)
  {
    this.O = paramInt;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.b.c paramc)
  {
    this.G = paramc;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.c paramc)
  {
    this.j = paramc;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.d paramd)
  {
    this.v = paramd;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.g paramg)
  {
    this.u = paramg;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.h paramh)
  {
    this.z = paramh;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.i parami)
  {
    this.A = parami;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.k paramk)
  {
    this.r = paramk;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.p paramp)
  {
    this.t = paramp;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.s params)
  {
    this.w = params;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b.t paramt)
  {
    this.l = paramt;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.b paramb)
  {
    this.h = paramb;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.d.a parama)
  {
    this.F = parama;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.a.f> paramb)
  {
    this.x = paramb;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.d.f paramf)
  {
    this.E = paramf;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.e.b.d paramd)
  {
    this.s = paramd;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.e.d.b paramb)
  {
    this.d = paramb;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.e.e.n paramn)
  {
    this.c = paramn;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.e.h paramh)
  {
    this.i = paramh;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.e.o paramo)
  {
    this.f = paramo;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.e.x paramx)
  {
    this.g = paramx;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.n.k paramk)
  {
    this.m = paramk;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.n.m paramm)
  {
    this.b = paramm;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.r paramr)
  {
    this.C = paramr;
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.w paramw)
  {
    if (paramw == null) {
      return this;
    }
    if (this.n == null) {
      this.n = new LinkedList();
    }
    this.n.addFirst(paramw);
    return this;
  }
  
  public final ag a(cz.msebera.android.httpclient.z paramz)
  {
    if (paramz == null) {
      return this;
    }
    if (this.p == null) {
      this.p = new LinkedList();
    }
    this.p.addFirst(paramz);
    return this;
  }
  
  public final ag a(String paramString)
  {
    this.B = paramString;
    return this;
  }
  
  public final ag a(Collection<? extends cz.msebera.android.httpclient.f> paramCollection)
  {
    this.D = paramCollection;
    return this;
  }
  
  public final ag a(SSLContext paramSSLContext)
  {
    this.e = paramSSLContext;
    return this;
  }
  
  protected cz.msebera.android.httpclient.i.f.b a(cz.msebera.android.httpclient.i.f.b paramb)
  {
    return paramb;
  }
  
  protected void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    if (this.Q == null) {
      this.Q = new ArrayList();
    }
    this.Q.add(paramCloseable);
  }
  
  public final ag b()
  {
    this.N = true;
    return this;
  }
  
  public final ag b(int paramInt)
  {
    this.P = paramInt;
    return this;
  }
  
  public final ag b(cz.msebera.android.httpclient.b.c paramc)
  {
    this.k = paramc;
    return this;
  }
  
  public final ag b(cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.f.j> paramb)
  {
    this.y = paramb;
    return this;
  }
  
  public final ag b(cz.msebera.android.httpclient.w paramw)
  {
    if (paramw == null) {
      return this;
    }
    if (this.o == null) {
      this.o = new LinkedList();
    }
    this.o.addLast(paramw);
    return this;
  }
  
  public final ag b(cz.msebera.android.httpclient.z paramz)
  {
    if (paramz == null) {
      return this;
    }
    if (this.q == null) {
      this.q = new LinkedList();
    }
    this.q.addLast(paramz);
    return this;
  }
  
  protected cz.msebera.android.httpclient.i.f.b b(cz.msebera.android.httpclient.i.f.b paramb)
  {
    return paramb;
  }
  
  public final ag c()
  {
    this.L = true;
    return this;
  }
  
  public final ag d()
  {
    this.K = true;
    return this;
  }
  
  public final ag e()
  {
    this.M = true;
    return this;
  }
  
  public final ag f()
  {
    this.J = true;
    return this;
  }
  
  public final ag g()
  {
    this.I = true;
    return this;
  }
  
  public final ag h()
  {
    this.H = true;
    return this;
  }
  
  public m i()
  {
    Object localObject1 = this.b;
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = new cz.msebera.android.httpclient.n.m();
    }
    localObject1 = this.f;
    Object localObject4 = localObject1;
    label78:
    Object localObject5;
    if (localObject1 == null)
    {
      localObject2 = this.d;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (!this.H) {
          break label503;
        }
        localObject1 = b(System.getProperty("https.protocols"));
        if (!this.H) {
          break label508;
        }
        localObject2 = b(System.getProperty("https.cipherSuites"));
        localObject5 = this.c;
        localObject4 = localObject5;
        if (localObject5 == null) {
          localObject4 = cz.msebera.android.httpclient.e.e.f.e;
        }
        if (this.e == null) {
          break label513;
        }
        localObject1 = new cz.msebera.android.httpclient.e.e.f(this.e, (String[])localObject1, (String[])localObject2, (cz.msebera.android.httpclient.e.e.n)localObject4);
      }
      label121:
      localObject4 = new cz.msebera.android.httpclient.i.c.ag(cz.msebera.android.httpclient.d.e.a().a("http", cz.msebera.android.httpclient.e.d.c.a()).a("https", localObject1).b());
      if (this.E != null) {
        ((cz.msebera.android.httpclient.i.c.ag)localObject4).a(this.E);
      }
      if (this.F != null) {
        ((cz.msebera.android.httpclient.i.c.ag)localObject4).a(this.F);
      }
      if ((this.H) && ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))))
      {
        int i1 = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
        ((cz.msebera.android.httpclient.i.c.ag)localObject4).b(i1);
        ((cz.msebera.android.httpclient.i.c.ag)localObject4).a(i1 * 2);
      }
      if (this.O > 0) {
        ((cz.msebera.android.httpclient.i.c.ag)localObject4).a(this.O);
      }
      if (this.P > 0) {
        ((cz.msebera.android.httpclient.i.c.ag)localObject4).b(this.P);
      }
    }
    Object localObject2 = this.h;
    localObject1 = localObject2;
    label308:
    Object localObject6;
    Object localObject7;
    Object localObject8;
    if (localObject2 == null)
    {
      if (!this.H) {
        break label564;
      }
      if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
        localObject1 = cz.msebera.android.httpclient.i.i.a;
      }
    }
    else
    {
      localObject2 = this.i;
      localObject5 = localObject2;
      if (localObject2 == null) {
        localObject5 = r.a;
      }
      localObject2 = this.j;
      localObject6 = localObject2;
      if (localObject2 == null) {
        localObject6 = ay.b;
      }
      localObject2 = this.k;
      localObject7 = localObject2;
      if (localObject2 == null) {
        localObject7 = ap.b;
      }
      localObject8 = this.l;
      localObject2 = localObject8;
      if (localObject8 == null) {
        if (this.N) {
          break label571;
        }
      }
    }
    label503:
    label508:
    label513:
    label564:
    label571:
    for (localObject2 = ab.a;; localObject2 = an.a)
    {
      localObject3 = a(new cz.msebera.android.httpclient.i.f.e((cz.msebera.android.httpclient.n.m)localObject3, (cz.msebera.android.httpclient.e.o)localObject4, (cz.msebera.android.httpclient.b)localObject1, (cz.msebera.android.httpclient.e.h)localObject5, (cz.msebera.android.httpclient.b.c)localObject6, (cz.msebera.android.httpclient.b.c)localObject7, (cz.msebera.android.httpclient.b.t)localObject2));
      localObject2 = this.m;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label879;
      }
      localObject2 = this.B;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (this.H) {
          localObject2 = System.getProperty("http.agent");
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a;
        }
      }
      localObject2 = cz.msebera.android.httpclient.n.l.a();
      if (this.n == null) {
        break label578;
      }
      localObject5 = this.n.iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((cz.msebera.android.httpclient.n.l)localObject2).a((cz.msebera.android.httpclient.w)((Iterator)localObject5).next());
      }
      localObject1 = null;
      break;
      localObject2 = null;
      break label78;
      if (this.H)
      {
        localObject1 = new cz.msebera.android.httpclient.e.e.f((SSLSocketFactory)SSLSocketFactory.getDefault(), (String[])localObject1, (String[])localObject2, (cz.msebera.android.httpclient.e.e.n)localObject4);
        break label121;
      }
      localObject1 = new cz.msebera.android.httpclient.e.e.f(cz.msebera.android.httpclient.e.e.h.a(), (cz.msebera.android.httpclient.e.e.n)localObject4);
      break label121;
      localObject1 = cz.msebera.android.httpclient.i.p.a;
      break label308;
      localObject1 = cz.msebera.android.httpclient.i.i.a;
      break label308;
    }
    label578:
    if (this.p != null)
    {
      localObject5 = this.p.iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((cz.msebera.android.httpclient.n.l)localObject2).a((cz.msebera.android.httpclient.z)((Iterator)localObject5).next());
      }
    }
    ((cz.msebera.android.httpclient.n.l)localObject2).c(new cz.msebera.android.httpclient.w[] { new cz.msebera.android.httpclient.b.f.i(this.D), new cz.msebera.android.httpclient.n.w(), new cz.msebera.android.httpclient.n.z(), new cz.msebera.android.httpclient.b.f.h(), new aa((String)localObject1), new cz.msebera.android.httpclient.b.f.j() });
    if (!this.L) {
      ((cz.msebera.android.httpclient.n.l)localObject2).c(new cz.msebera.android.httpclient.b.f.e());
    }
    if (!this.K) {
      ((cz.msebera.android.httpclient.n.l)localObject2).c(new cz.msebera.android.httpclient.b.f.d());
    }
    if (!this.M) {
      ((cz.msebera.android.httpclient.n.l)localObject2).c(new cz.msebera.android.httpclient.b.f.f());
    }
    if (!this.L) {
      ((cz.msebera.android.httpclient.n.l)localObject2).c(new cz.msebera.android.httpclient.b.f.o());
    }
    if (!this.K) {
      ((cz.msebera.android.httpclient.n.l)localObject2).c(new cz.msebera.android.httpclient.b.f.n());
    }
    if (this.o != null)
    {
      localObject1 = this.o.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((cz.msebera.android.httpclient.n.l)localObject2).b((cz.msebera.android.httpclient.w)((Iterator)localObject1).next());
      }
    }
    if (this.q != null)
    {
      localObject1 = this.q.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((cz.msebera.android.httpclient.n.l)localObject2).b((cz.msebera.android.httpclient.z)((Iterator)localObject1).next());
      }
    }
    localObject1 = ((cz.msebera.android.httpclient.n.l)localObject2).b();
    label879:
    localObject3 = b(new cz.msebera.android.httpclient.i.f.g((cz.msebera.android.httpclient.i.f.b)localObject3, (cz.msebera.android.httpclient.n.k)localObject1));
    localObject2 = localObject3;
    if (!this.J)
    {
      localObject2 = this.r;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = t.a;
      }
      localObject2 = new cz.msebera.android.httpclient.i.f.l((cz.msebera.android.httpclient.i.f.b)localObject3, (cz.msebera.android.httpclient.b.k)localObject1);
    }
    localObject3 = this.s;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject3 = this.g;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = cz.msebera.android.httpclient.i.c.s.a;
      }
      if (this.C != null) {
        localObject1 = new cz.msebera.android.httpclient.i.c.p(this.C, (cz.msebera.android.httpclient.e.x)localObject1);
      }
    }
    else
    {
      localObject3 = localObject2;
      if (!this.I)
      {
        localObject5 = this.t;
        localObject3 = localObject5;
        if (localObject5 == null) {
          localObject3 = w.c;
        }
        localObject3 = new cz.msebera.android.httpclient.i.f.h((cz.msebera.android.httpclient.i.f.b)localObject2, (cz.msebera.android.httpclient.e.b.d)localObject1, (cz.msebera.android.httpclient.b.p)localObject3);
      }
      localObject5 = this.w;
      localObject2 = localObject3;
      if (localObject5 != null) {
        localObject2 = new cz.msebera.android.httpclient.i.f.m((cz.msebera.android.httpclient.i.f.b)localObject3, (cz.msebera.android.httpclient.b.s)localObject5);
      }
      localObject5 = this.v;
      localObject6 = this.u;
      localObject3 = localObject2;
      if (localObject5 != null)
      {
        localObject3 = localObject2;
        if (localObject6 != null) {
          localObject3 = new cz.msebera.android.httpclient.i.f.a((cz.msebera.android.httpclient.i.f.b)localObject2, (cz.msebera.android.httpclient.b.g)localObject6, (cz.msebera.android.httpclient.b.d)localObject5);
        }
      }
      localObject2 = this.x;
      localObject5 = localObject2;
      if (localObject2 == null) {
        localObject5 = cz.msebera.android.httpclient.d.e.a().a("Basic", new cz.msebera.android.httpclient.i.a.c()).a("Digest", new cz.msebera.android.httpclient.i.a.e()).a("NTLM", new cz.msebera.android.httpclient.i.a.l()).b();
      }
      localObject2 = this.y;
      localObject6 = localObject2;
      if (localObject2 == null) {
        localObject6 = cz.msebera.android.httpclient.d.e.a().a("best-match", new cz.msebera.android.httpclient.i.d.l()).a("standard", new aj()).a("compatibility", new cz.msebera.android.httpclient.i.d.n()).a("netscape", new cz.msebera.android.httpclient.i.d.x()).a("ignoreCookies", new cz.msebera.android.httpclient.i.d.t()).a("rfc2109", new ac()).a("rfc2965", new aj()).b();
      }
      localObject2 = this.z;
      localObject7 = localObject2;
      if (localObject2 == null) {
        localObject7 = new h();
      }
      localObject8 = this.A;
      localObject2 = localObject8;
      if (localObject8 == null)
      {
        if (!this.H) {
          break label1405;
        }
        localObject2 = new aw();
      }
      label1314:
      if (this.G == null) {
        break label1416;
      }
      localObject8 = this.G;
      label1327:
      if (this.Q == null) {
        break label1424;
      }
    }
    label1405:
    label1416:
    label1424:
    for (ArrayList localArrayList = new ArrayList(this.Q);; localArrayList = null)
    {
      return new ak((cz.msebera.android.httpclient.i.f.b)localObject3, (cz.msebera.android.httpclient.e.o)localObject4, (cz.msebera.android.httpclient.e.b.d)localObject1, (cz.msebera.android.httpclient.d.b)localObject6, (cz.msebera.android.httpclient.d.b)localObject5, (cz.msebera.android.httpclient.b.h)localObject7, (cz.msebera.android.httpclient.b.i)localObject2, (cz.msebera.android.httpclient.b.b.c)localObject8, localArrayList);
      if (this.H)
      {
        localObject1 = new al((cz.msebera.android.httpclient.e.x)localObject1, ProxySelector.getDefault());
        break;
      }
      localObject1 = new cz.msebera.android.httpclient.i.c.r((cz.msebera.android.httpclient.e.x)localObject1);
      break;
      localObject2 = new i();
      break label1314;
      localObject8 = cz.msebera.android.httpclient.b.b.c.a;
      break label1327;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */