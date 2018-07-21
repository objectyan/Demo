package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.e.b.e.a;
import cz.msebera.android.httpclient.e.b.e.b;
import cz.msebera.android.httpclient.i.a.e;
import cz.msebera.android.httpclient.i.a.l;
import cz.msebera.android.httpclient.i.c.ae;
import cz.msebera.android.httpclient.n.aa;
import cz.msebera.android.httpclient.n.k;
import cz.msebera.android.httpclient.n.m;
import cz.msebera.android.httpclient.n.z;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.w;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.net.Socket;

public class aq
{
  private final cz.msebera.android.httpclient.e.p<cz.msebera.android.httpclient.e.b.b, cz.msebera.android.httpclient.e.u> a;
  private final cz.msebera.android.httpclient.d.a b;
  private final cz.msebera.android.httpclient.b.b.c c;
  private final k d;
  private final m e;
  private final ap f;
  private final cz.msebera.android.httpclient.i.a.f g;
  private final cz.msebera.android.httpclient.a.i h;
  private final cz.msebera.android.httpclient.a.g i;
  private final cz.msebera.android.httpclient.b j;
  
  public aq()
  {
    this(null, null, null);
  }
  
  public aq(cz.msebera.android.httpclient.b.b.c paramc)
  {
    this(null, null, paramc);
  }
  
  public aq(cz.msebera.android.httpclient.e.p<cz.msebera.android.httpclient.e.b.b, cz.msebera.android.httpclient.e.u> paramp, cz.msebera.android.httpclient.d.a parama, cz.msebera.android.httpclient.b.b.c paramc)
  {
    if (paramp != null)
    {
      this.a = paramp;
      if (parama == null) {
        break label198;
      }
      label17:
      this.b = parama;
      if (paramc == null) {
        break label205;
      }
    }
    for (;;)
    {
      this.c = paramc;
      this.d = new cz.msebera.android.httpclient.n.u(new w[] { new z(), new cz.msebera.android.httpclient.b.f.h(), new aa() });
      this.e = new m();
      this.f = new ap();
      this.g = new cz.msebera.android.httpclient.i.a.f();
      this.h = new cz.msebera.android.httpclient.a.i();
      this.i = new cz.msebera.android.httpclient.a.g();
      this.i.a("Basic", new cz.msebera.android.httpclient.i.a.c());
      this.i.a("Digest", new e());
      this.i.a("NTLM", new l());
      this.j = new cz.msebera.android.httpclient.i.i();
      return;
      paramp = ae.a;
      break;
      label198:
      parama = cz.msebera.android.httpclient.d.a.a;
      break label17;
      label205:
      paramc = cz.msebera.android.httpclient.b.b.c.a;
    }
  }
  
  @Deprecated
  public aq(cz.msebera.android.httpclient.l.j paramj)
  {
    this(null, cz.msebera.android.httpclient.l.i.c(paramj), cz.msebera.android.httpclient.b.e.f.a(paramj));
  }
  
  @Deprecated
  public cz.msebera.android.httpclient.l.j a()
  {
    return new cz.msebera.android.httpclient.l.b();
  }
  
  public Socket a(r paramr1, r paramr2, cz.msebera.android.httpclient.a.n paramn)
    throws IOException, cz.msebera.android.httpclient.p
  {
    cz.msebera.android.httpclient.o.a.a(paramr1, "Proxy host");
    cz.msebera.android.httpclient.o.a.a(paramr2, "Target host");
    cz.msebera.android.httpclient.o.a.a(paramn, "Credentials");
    Object localObject2 = paramr2;
    Object localObject1 = localObject2;
    if (((r)localObject2).b() <= 0) {
      localObject1 = new r(((r)localObject2).a(), 80, ((r)localObject2).c());
    }
    cz.msebera.android.httpclient.e.b.b localb = new cz.msebera.android.httpclient.e.b.b((r)localObject1, this.c.c(), paramr1, false, e.b.b, e.a.a);
    localObject2 = (cz.msebera.android.httpclient.e.u)this.a.a(localb, this.b);
    cz.msebera.android.httpclient.n.a locala = new cz.msebera.android.httpclient.n.a();
    localObject1 = new cz.msebera.android.httpclient.k.i("CONNECT", ((r)localObject1).f(), ac.d);
    i locali = new i();
    locali.a(new cz.msebera.android.httpclient.a.h(paramr1), paramn);
    locala.a("http.target_host", paramr2);
    locala.a("http.connection", localObject2);
    locala.a("http.request", localObject1);
    locala.a("http.route", localb);
    locala.a("http.auth.proxy-scope", this.h);
    locala.a("http.auth.credentials-provider", locali);
    locala.a("http.authscheme-registry", this.i);
    locala.a("http.request-config", this.c);
    this.e.a((cz.msebera.android.httpclient.u)localObject1, this.d, locala);
    if (!((cz.msebera.android.httpclient.e.u)localObject2).c()) {
      ((cz.msebera.android.httpclient.e.u)localObject2).a(new Socket(paramr1.a(), paramr1.b()));
    }
    this.g.a((cz.msebera.android.httpclient.u)localObject1, this.h, locala);
    paramr2 = this.e.a((cz.msebera.android.httpclient.u)localObject1, (cz.msebera.android.httpclient.j)localObject2, locala);
    if (paramr2.a().b() < 200) {
      throw new cz.msebera.android.httpclient.p("Unexpected response to CONNECT request: " + paramr2.a());
    }
    if ((this.g.a(paramr1, paramr2, this.f, this.h, locala)) && (this.g.b(paramr1, paramr2, this.f, this.h, locala)))
    {
      if (this.j.a(paramr2, locala)) {
        cz.msebera.android.httpclient.o.g.b(paramr2.b());
      }
      for (;;)
      {
        ((cz.msebera.android.httpclient.u)localObject1).removeHeaders("Proxy-Authorization");
        break;
        ((cz.msebera.android.httpclient.e.u)localObject2).close();
      }
    }
    if (paramr2.a().b() > 299)
    {
      paramr1 = paramr2.b();
      if (paramr1 != null) {
        paramr2.a(new cz.msebera.android.httpclient.g.c(paramr1));
      }
      ((cz.msebera.android.httpclient.e.u)localObject2).close();
      throw new cz.msebera.android.httpclient.i.f.n("CONNECT refused by proxy: " + paramr2.a(), paramr2);
    }
    return ((cz.msebera.android.httpclient.e.u)localObject2).t();
  }
  
  @Deprecated
  public cz.msebera.android.httpclient.a.g b()
  {
    return this.i;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */