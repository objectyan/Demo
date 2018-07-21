package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.s;
import cz.msebera.android.httpclient.ah;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

@Deprecated
@NotThreadSafe
public class y
  implements cz.msebera.android.httpclient.b.q
{
  public cz.msebera.android.httpclient.h.b a;
  protected final cz.msebera.android.httpclient.e.c b;
  protected final cz.msebera.android.httpclient.e.b.d c;
  protected final cz.msebera.android.httpclient.b d;
  protected final cz.msebera.android.httpclient.e.h e;
  protected final cz.msebera.android.httpclient.n.m f;
  protected final cz.msebera.android.httpclient.n.k g;
  protected final cz.msebera.android.httpclient.b.k h;
  @Deprecated
  protected final cz.msebera.android.httpclient.b.o i;
  protected final cz.msebera.android.httpclient.b.p j;
  @Deprecated
  protected final cz.msebera.android.httpclient.b.b k;
  protected final cz.msebera.android.httpclient.b.c l;
  @Deprecated
  protected final cz.msebera.android.httpclient.b.b m;
  protected final cz.msebera.android.httpclient.b.c n;
  protected final cz.msebera.android.httpclient.b.t o;
  protected final cz.msebera.android.httpclient.l.j p;
  protected cz.msebera.android.httpclient.e.t q;
  protected final cz.msebera.android.httpclient.a.i r;
  protected final cz.msebera.android.httpclient.a.i s;
  private final af t;
  private int u;
  private int v;
  private final int w;
  private r x;
  
  @Deprecated
  public y(cz.msebera.android.httpclient.h.b paramb, cz.msebera.android.httpclient.n.m paramm, cz.msebera.android.httpclient.e.c paramc, cz.msebera.android.httpclient.b paramb1, cz.msebera.android.httpclient.e.h paramh, cz.msebera.android.httpclient.e.b.d paramd, cz.msebera.android.httpclient.n.k paramk, cz.msebera.android.httpclient.b.k paramk1, cz.msebera.android.httpclient.b.p paramp, cz.msebera.android.httpclient.b.b paramb2, cz.msebera.android.httpclient.b.b paramb3, cz.msebera.android.httpclient.b.t paramt, cz.msebera.android.httpclient.l.j paramj)
  {
    this(new cz.msebera.android.httpclient.h.b(y.class), paramm, paramc, paramb1, paramh, paramd, paramk, paramk1, paramp, new d(paramb2), new d(paramb3), paramt, paramj);
  }
  
  public y(cz.msebera.android.httpclient.h.b paramb, cz.msebera.android.httpclient.n.m paramm, cz.msebera.android.httpclient.e.c paramc, cz.msebera.android.httpclient.b paramb1, cz.msebera.android.httpclient.e.h paramh, cz.msebera.android.httpclient.e.b.d paramd, cz.msebera.android.httpclient.n.k paramk, cz.msebera.android.httpclient.b.k paramk1, cz.msebera.android.httpclient.b.p paramp, cz.msebera.android.httpclient.b.c paramc1, cz.msebera.android.httpclient.b.c paramc2, cz.msebera.android.httpclient.b.t paramt, cz.msebera.android.httpclient.l.j paramj)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Log");
    cz.msebera.android.httpclient.o.a.a(paramm, "Request executor");
    cz.msebera.android.httpclient.o.a.a(paramc, "Client connection manager");
    cz.msebera.android.httpclient.o.a.a(paramb1, "Connection reuse strategy");
    cz.msebera.android.httpclient.o.a.a(paramh, "Connection keep alive strategy");
    cz.msebera.android.httpclient.o.a.a(paramd, "Route planner");
    cz.msebera.android.httpclient.o.a.a(paramk, "HTTP protocol processor");
    cz.msebera.android.httpclient.o.a.a(paramk1, "HTTP request retry handler");
    cz.msebera.android.httpclient.o.a.a(paramp, "Redirect strategy");
    cz.msebera.android.httpclient.o.a.a(paramc1, "Target authentication strategy");
    cz.msebera.android.httpclient.o.a.a(paramc2, "Proxy authentication strategy");
    cz.msebera.android.httpclient.o.a.a(paramt, "User token handler");
    cz.msebera.android.httpclient.o.a.a(paramj, "HTTP parameters");
    this.a = paramb;
    this.t = new af(paramb);
    this.f = paramm;
    this.b = paramc;
    this.d = paramb1;
    this.e = paramh;
    this.c = paramd;
    this.g = paramk;
    this.h = paramk1;
    this.j = paramp;
    this.l = paramc1;
    this.n = paramc2;
    this.o = paramt;
    this.p = paramj;
    if ((paramp instanceof x))
    {
      this.i = ((x)paramp).a();
      if (!(paramc1 instanceof d)) {
        break label315;
      }
      this.k = ((d)paramc1).a();
      label232:
      if (!(paramc2 instanceof d)) {
        break label323;
      }
    }
    label315:
    label323:
    for (this.m = ((d)paramc2).a();; this.m = null)
    {
      this.q = null;
      this.u = 0;
      this.v = 0;
      this.r = new cz.msebera.android.httpclient.a.i();
      this.s = new cz.msebera.android.httpclient.a.i();
      this.w = this.p.a("http.protocol.max-redirects", 100);
      return;
      this.i = null;
      break;
      this.k = null;
      break label232;
    }
  }
  
  @Deprecated
  public y(cz.msebera.android.httpclient.n.m paramm, cz.msebera.android.httpclient.e.c paramc, cz.msebera.android.httpclient.b paramb, cz.msebera.android.httpclient.e.h paramh, cz.msebera.android.httpclient.e.b.d paramd, cz.msebera.android.httpclient.n.k paramk, cz.msebera.android.httpclient.b.k paramk1, cz.msebera.android.httpclient.b.o paramo, cz.msebera.android.httpclient.b.b paramb1, cz.msebera.android.httpclient.b.b paramb2, cz.msebera.android.httpclient.b.t paramt, cz.msebera.android.httpclient.l.j paramj)
  {
    this(new cz.msebera.android.httpclient.h.b(y.class), paramm, paramc, paramb, paramh, paramd, paramk, paramk1, new x(paramo), new d(paramb1), new d(paramb2), paramt, paramj);
  }
  
  private as a(u paramu)
    throws aj
  {
    if ((paramu instanceof cz.msebera.android.httpclient.o)) {
      return new ac((cz.msebera.android.httpclient.o)paramu);
    }
    return new as(paramu);
  }
  
  private void a(at paramat, cz.msebera.android.httpclient.n.g paramg)
    throws cz.msebera.android.httpclient.p, IOException
  {
    localb = paramat.b();
    paramat = paramat.a();
    i1 = 0;
    for (;;)
    {
      paramg.a("http.request", paramat);
      i2 = i1 + 1;
      try
      {
        if (!this.q.c()) {
          this.q.a(localb, paramg, this.p);
        }
        for (;;)
        {
          a(localb, paramg);
          return;
          this.q.b(cz.msebera.android.httpclient.l.h.a(this.p));
        }
        try
        {
          this.q.close();
          if (this.h.retryRequest(localIOException1, i2, paramg))
          {
            i1 = i2;
            if (!this.a.d()) {
              continue;
            }
            this.a.d("I/O exception (" + localIOException1.getClass().getName() + ") caught when connecting to " + localb + ": " + localIOException1.getMessage());
            if (this.a.a()) {
              this.a.a(localIOException1.getMessage(), localIOException1);
            }
            this.a.d("Retrying connect to " + localb);
            i1 = i2;
            continue;
          }
          throw localIOException1;
        }
        catch (IOException localIOException2)
        {
          for (;;) {}
        }
      }
      catch (IOException localIOException1) {}
    }
  }
  
  private cz.msebera.android.httpclient.x b(at paramat, cz.msebera.android.httpclient.n.g paramg)
    throws cz.msebera.android.httpclient.p, IOException
  {
    as localas = paramat.a();
    cz.msebera.android.httpclient.e.b.b localb = paramat.b();
    paramat = null;
    for (;;)
    {
      this.u += 1;
      localas.e();
      if (!localas.a())
      {
        this.a.a("Cannot retry non-repeatable request");
        if (paramat != null) {
          throw new cz.msebera.android.httpclient.b.m("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", paramat);
        }
        throw new cz.msebera.android.httpclient.b.m("Cannot retry request with a non-repeatable request entity.");
      }
      try
      {
        if (!this.q.c())
        {
          if (!localb.g())
          {
            this.a.a("Reopening the direct connection.");
            this.q.a(localb, paramg, this.p);
          }
        }
        else
        {
          if (this.a.a()) {
            this.a.a("Attempt " + this.u + " to execute request");
          }
          return this.f.a(localas, this.q, paramg);
        }
        this.a.a("Proxied connection. Need to start over.");
        return null;
      }
      catch (IOException paramat)
      {
        this.a.a("Closing the connection.");
      }
      try
      {
        this.q.close();
        if (this.h.retryRequest(paramat, localas.d(), paramg))
        {
          if (this.a.d()) {
            this.a.d("I/O exception (" + paramat.getClass().getName() + ") caught when processing request to " + localb + ": " + paramat.getMessage());
          }
          if (this.a.a()) {
            this.a.a(paramat.getMessage(), paramat);
          }
          if (this.a.d()) {
            this.a.d("Retrying request to " + localb);
          }
          continue;
        }
        if ((paramat instanceof ah))
        {
          paramg = new ah(localb.a().f() + " failed to respond");
          paramg.setStackTrace(paramat.getStackTrace());
          throw paramg;
        }
        throw paramat;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  private void b()
  {
    cz.msebera.android.httpclient.e.t localt = this.q;
    if (localt != null) {
      this.q = null;
    }
    try
    {
      localt.b();
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        try
        {
          localt.i_();
          return;
        }
        catch (IOException localIOException1)
        {
          this.a.a("Error releasing connection", localIOException1);
        }
        localIOException2 = localIOException2;
        if (this.a.a()) {
          this.a.a(localIOException2.getMessage(), localIOException2);
        }
      }
    }
  }
  
  protected at a(at paramat, cz.msebera.android.httpclient.x paramx, cz.msebera.android.httpclient.n.g paramg)
    throws cz.msebera.android.httpclient.p, IOException
  {
    cz.msebera.android.httpclient.e.b.b localb = paramat.b();
    as localas = paramat.a();
    cz.msebera.android.httpclient.l.j localj = localas.getParams();
    Object localObject2;
    Object localObject1;
    if (cz.msebera.android.httpclient.b.e.g.b(localj))
    {
      localObject2 = (r)paramg.a("http.target_host");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localb.a();
      }
      localObject2 = localObject1;
      if (((r)localObject1).b() < 0)
      {
        localObject2 = this.b.a().a((r)localObject1);
        localObject2 = new r(((r)localObject1).a(), ((cz.msebera.android.httpclient.e.c.f)localObject2).a(), ((r)localObject1).c());
      }
      boolean bool1 = this.t.a((r)localObject2, paramx, this.l, this.r, paramg);
      r localr = localb.e();
      localObject1 = localr;
      if (localr == null) {
        localObject1 = localb.a();
      }
      boolean bool2 = this.t.a((r)localObject1, paramx, this.n, this.s, paramg);
      if ((bool1) && (this.t.c((r)localObject2, paramx, this.l, this.r, paramg))) {}
      while ((bool2) && (this.t.c((r)localObject1, paramx, this.n, this.s, paramg))) {
        return paramat;
      }
    }
    if ((cz.msebera.android.httpclient.b.e.g.a(localj)) && (this.j.a(localas, paramx, paramg)))
    {
      if (this.v >= this.w) {
        throw new cz.msebera.android.httpclient.b.n("Maximum redirects (" + this.w + ") exceeded");
      }
      this.v += 1;
      this.x = null;
      paramx = this.j.b(localas, paramx, paramg);
      paramx.setHeaders(localas.c().getAllHeaders());
      paramat = paramx.getURI();
      localObject1 = cz.msebera.android.httpclient.b.g.i.b(paramat);
      if (localObject1 == null) {
        throw new aj("Redirect URI does not specify a valid host name: " + paramat);
      }
      if (!localb.a().equals(localObject1))
      {
        this.a.a("Resetting target auth state");
        this.r.a();
        localObject2 = this.s.c();
        if ((localObject2 != null) && (((cz.msebera.android.httpclient.a.d)localObject2).c()))
        {
          this.a.a("Resetting proxy auth state");
          this.s.a();
        }
      }
      paramx = a(paramx);
      paramx.setParams(localj);
      paramg = b((r)localObject1, paramx, paramg);
      paramx = new at(paramx, paramg);
      if (this.a.a()) {
        this.a.a("Redirecting to '" + paramat + "' via " + paramg);
      }
      return paramx;
    }
    return null;
  }
  
  public cz.msebera.android.httpclient.x a(r paramr, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws cz.msebera.android.httpclient.p, IOException
  {
    paramg.a("http.auth.target-scope", this.r);
    paramg.a("http.auth.proxy-scope", this.s);
    Object localObject2 = a(paramu);
    ((as)localObject2).setParams(this.p);
    Object localObject3 = b(paramr, (u)localObject2, paramg);
    this.x = ((r)((as)localObject2).getParams().a("http.virtual-host"));
    Object localObject1;
    if ((this.x != null) && (this.x.b() == -1))
    {
      if (paramr == null) {
        break label799;
      }
      localObject1 = paramr;
      i1 = ((r)localObject1).b();
      if (i1 != -1) {
        this.x = new r(this.x.a(), i1, this.x.c());
      }
    }
    localObject3 = new at((as)localObject2, (cz.msebera.android.httpclient.e.b.b)localObject3);
    boolean bool1 = false;
    int i1 = 0;
    localObject2 = null;
    label159:
    if (i1 == 0) {}
    for (;;)
    {
      try
      {
        localObject2 = ((at)localObject3).a();
        localObject4 = ((at)localObject3).b();
        localObject6 = paramg.a("http.user-token");
        if (this.q == null)
        {
          localObject1 = this.b.a((cz.msebera.android.httpclient.e.b.b)localObject4, localObject6);
          if ((paramu instanceof cz.msebera.android.httpclient.b.d.a)) {
            ((cz.msebera.android.httpclient.b.d.a)paramu).setConnectionRequest((cz.msebera.android.httpclient.e.f)localObject1);
          }
          l1 = cz.msebera.android.httpclient.b.e.g.d(this.p);
        }
      }
      catch (cz.msebera.android.httpclient.i.c.i paramr)
      {
        try
        {
          this.q = ((cz.msebera.android.httpclient.e.f)localObject1).a(l1, TimeUnit.MILLISECONDS);
          if ((cz.msebera.android.httpclient.l.h.g(this.p)) && (this.q.c()))
          {
            this.a.a("Stale connection check");
            if (this.q.d())
            {
              this.a.a("Stale connection detected");
              this.q.close();
            }
          }
          if ((paramu instanceof cz.msebera.android.httpclient.b.d.a)) {
            ((cz.msebera.android.httpclient.b.d.a)paramu).setReleaseTrigger(this.q);
          }
        }
        catch (InterruptedException paramr)
        {
          Object localObject6;
          long l1;
          Object localObject5;
          Thread.currentThread().interrupt();
          throw new InterruptedIOException();
        }
        try
        {
          a((at)localObject3, paramg);
          localObject1 = ((as)localObject2).getURI().getUserInfo();
          if (localObject1 != null) {
            this.r.a(new cz.msebera.android.httpclient.i.a.b(), new s((String)localObject1));
          }
          if (this.x == null) {
            continue;
          }
          paramr = this.x;
          localObject1 = paramr;
          if (paramr == null) {
            localObject1 = ((cz.msebera.android.httpclient.e.b.b)localObject4).a();
          }
          ((as)localObject2).b();
          a((as)localObject2, (cz.msebera.android.httpclient.e.b.b)localObject4);
          paramg.a("http.target_host", localObject1);
          paramg.a("http.route", localObject4);
          paramg.a("http.connection", this.q);
          this.f.a((u)localObject2, this.g, paramg);
          localx = b((at)localObject3, paramg);
          localObject2 = localx;
          paramr = (r)localObject1;
          if (localx == null) {
            break label159;
          }
          localx.setParams(this.p);
          this.f.a(localx, this.g, paramg);
          bool2 = this.d.a(localx, paramg);
          if (bool2)
          {
            l1 = this.e.a(localx, paramg);
            if (this.a.a())
            {
              if (l1 <= 0L) {
                break label1153;
              }
              paramr = "for " + l1 + " " + TimeUnit.MILLISECONDS;
              this.a.a("Connection can be kept alive " + paramr);
            }
            this.q.a(l1, TimeUnit.MILLISECONDS);
          }
          localObject4 = a((at)localObject3, localx, paramg);
          if (localObject4 != null) {
            continue;
          }
          i2 = 1;
          localObject4 = localObject3;
          i1 = i2;
          localObject2 = localx;
          bool1 = bool2;
          localObject3 = localObject4;
          paramr = (r)localObject1;
          if (this.q == null) {
            break label159;
          }
          localObject5 = localObject6;
          if (localObject6 == null)
          {
            localObject5 = this.o.a(paramg);
            paramg.a("http.user-token", localObject5);
          }
          i1 = i2;
          localObject2 = localx;
          bool1 = bool2;
          localObject3 = localObject4;
          paramr = (r)localObject1;
          if (localObject5 == null) {
            break label159;
          }
          this.q.a(localObject5);
          i1 = i2;
          localObject2 = localx;
          bool1 = bool2;
          localObject3 = localObject4;
          paramr = (r)localObject1;
        }
        catch (az paramr)
        {
          if (!this.a.a()) {
            continue;
          }
          this.a.a(paramr.getMessage());
          localObject2 = paramr.a();
        }
        paramr = paramr;
        paramu = new InterruptedIOException("Connection has been shut down");
        paramu.initCause(paramr);
        throw paramu;
        localObject1 = ((cz.msebera.android.httpclient.e.b.b)localObject3).a();
      }
      catch (cz.msebera.android.httpclient.p paramr)
      {
        Object localObject4;
        cz.msebera.android.httpclient.x localx;
        boolean bool2;
        b();
        throw paramr;
        if ((localObject2 == null) || (((cz.msebera.android.httpclient.x)localObject2).b() == null) || (!((cz.msebera.android.httpclient.x)localObject2).b().isStreaming()))
        {
          if (bool1) {
            this.q.o();
          }
          a();
          return (cz.msebera.android.httpclient.x)localObject2;
          localObject1 = ((as)localObject2).getURI();
          if (!((URI)localObject1).isAbsolute()) {
            continue;
          }
          paramr = cz.msebera.android.httpclient.b.g.i.b((URI)localObject1);
          continue;
          if (bool2)
          {
            cz.msebera.android.httpclient.o.g.b(localx.b());
            this.q.o();
            if (((at)localObject4).b().equals(((at)localObject3).b())) {
              break label1160;
            }
            a();
            break label1160;
          }
          this.q.close();
          if ((this.s.b().compareTo(cz.msebera.android.httpclient.a.c.b) > 0) && (this.s.c() != null) && (this.s.c().c()))
          {
            this.a.a("Resetting proxy auth state");
            this.s.a();
          }
          if ((this.r.b().compareTo(cz.msebera.android.httpclient.a.c.b) <= 0) || (this.r.c() == null) || (!this.r.c().c())) {
            continue;
          }
          this.a.a("Resetting target auth state");
          this.r.a();
          continue;
        }
      }
      catch (IOException paramr)
      {
        b();
        throw paramr;
        ((cz.msebera.android.httpclient.x)localObject2).a(new cz.msebera.android.httpclient.e.b(((cz.msebera.android.httpclient.x)localObject2).b(), this.q, bool1));
        return (cz.msebera.android.httpclient.x)localObject2;
      }
      catch (RuntimeException paramr)
      {
        label799:
        b();
        throw paramr;
      }
      label1153:
      paramr = "indefinitely";
      continue;
      label1160:
      int i2 = i1;
    }
  }
  
  protected void a()
  {
    try
    {
      this.q.i_();
      this.q = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.a.a("IOException releasing connection", localIOException);
      }
    }
  }
  
  protected void a(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.n.g paramg)
    throws cz.msebera.android.httpclient.p, IOException
  {
    cz.msebera.android.httpclient.e.b.a locala = new cz.msebera.android.httpclient.e.b.a();
    cz.msebera.android.httpclient.e.b.b localb = this.q.m();
    int i1 = locala.a(paramb, localb);
    switch (i1)
    {
    default: 
      throw new IllegalStateException("Unknown step indicator " + i1 + " from RouteDirector.");
    case 1: 
    case 2: 
      this.q.a(paramb, paramg, this.p);
    case 0: 
    case 3: 
    case 4: 
    case 5: 
      while (i1 <= 0)
      {
        return;
        boolean bool = b(paramb, paramg);
        this.a.a("Tunnel to target created.");
        this.q.a(bool, this.p);
        continue;
        int i2 = localb.d() - 1;
        bool = a(paramb, i2, paramg);
        this.a.a("Tunnel to proxy created.");
        this.q.a(paramb.a(i2), bool, this.p);
        continue;
        this.q.a(paramg, this.p);
      }
    }
    throw new cz.msebera.android.httpclient.p("Unable to establish route: planned = " + paramb + "; current = " + localb);
  }
  
  /* Error */
  protected void a(as paramas, cz.msebera.android.httpclient.e.b.b paramb)
    throws aj
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 536	cz/msebera/android/httpclient/i/b/as:getURI	()Ljava/net/URI;
    //   4: astore_3
    //   5: aload_2
    //   6: invokevirtual 401	cz/msebera/android/httpclient/e/b/b:e	()Lcz/msebera/android/httpclient/r;
    //   9: ifnull +41 -> 50
    //   12: aload_2
    //   13: invokevirtual 306	cz/msebera/android/httpclient/e/b/b:g	()Z
    //   16: ifne +34 -> 50
    //   19: aload_3
    //   20: invokevirtual 636	java/net/URI:isAbsolute	()Z
    //   23: ifne +19 -> 42
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 336	cz/msebera/android/httpclient/e/b/b:a	()Lcz/msebera/android/httpclient/r;
    //   31: iconst_1
    //   32: invokestatic 715	cz/msebera/android/httpclient/b/g/i:a	(Ljava/net/URI;Lcz/msebera/android/httpclient/r;Z)Ljava/net/URI;
    //   35: astore_2
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 718	cz/msebera/android/httpclient/i/b/as:a	(Ljava/net/URI;)V
    //   41: return
    //   42: aload_3
    //   43: invokestatic 721	cz/msebera/android/httpclient/b/g/i:a	(Ljava/net/URI;)Ljava/net/URI;
    //   46: astore_2
    //   47: goto -11 -> 36
    //   50: aload_3
    //   51: invokevirtual 636	java/net/URI:isAbsolute	()Z
    //   54: ifeq +13 -> 67
    //   57: aload_3
    //   58: aconst_null
    //   59: iconst_1
    //   60: invokestatic 715	cz/msebera/android/httpclient/b/g/i:a	(Ljava/net/URI;Lcz/msebera/android/httpclient/r;Z)Ljava/net/URI;
    //   63: astore_2
    //   64: goto -28 -> 36
    //   67: aload_3
    //   68: invokestatic 721	cz/msebera/android/httpclient/b/g/i:a	(Ljava/net/URI;)Ljava/net/URI;
    //   71: astore_2
    //   72: goto -36 -> 36
    //   75: astore_2
    //   76: new 178	cz/msebera/android/httpclient/aj
    //   79: dup
    //   80: new 243	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 723
    //   90: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 727	cz/msebera/android/httpclient/i/b/as:getRequestLine	()Lcz/msebera/android/httpclient/am;
    //   97: invokeinterface 730 1 0
    //   102: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aload_2
    //   109: invokespecial 731	cz/msebera/android/httpclient/aj:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	y
    //   0	113	1	paramas	as
    //   0	113	2	paramb	cz.msebera.android.httpclient.e.b.b
    //   4	64	3	localURI	URI
    // Exception table:
    //   from	to	target	type
    //   0	36	75	java/net/URISyntaxException
    //   36	41	75	java/net/URISyntaxException
    //   42	47	75	java/net/URISyntaxException
    //   50	64	75	java/net/URISyntaxException
    //   67	72	75	java/net/URISyntaxException
  }
  
  protected boolean a(cz.msebera.android.httpclient.e.b.b paramb, int paramInt, cz.msebera.android.httpclient.n.g paramg)
    throws cz.msebera.android.httpclient.p, IOException
  {
    throw new cz.msebera.android.httpclient.p("Proxy chains are not supported.");
  }
  
  protected cz.msebera.android.httpclient.e.b.b b(r paramr, u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws cz.msebera.android.httpclient.p
  {
    cz.msebera.android.httpclient.e.b.d locald = this.c;
    if (paramr != null) {}
    for (;;)
    {
      return locald.a(paramr, paramu, paramg);
      paramr = (r)paramu.getParams().a("http.default-host");
    }
  }
  
  protected boolean b(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.n.g paramg)
    throws cz.msebera.android.httpclient.p, IOException
  {
    r localr1 = paramb.e();
    r localr2 = paramb.a();
    Object localObject;
    for (;;)
    {
      if (!this.q.c()) {
        this.q.a(paramb, paramg, this.p);
      }
      localObject = c(paramb, paramg);
      ((u)localObject).setParams(this.p);
      paramg.a("http.target_host", localr2);
      paramg.a("http.route", paramb);
      paramg.a("http.proxy_host", localr1);
      paramg.a("http.connection", this.q);
      paramg.a("http.request", localObject);
      this.f.a((u)localObject, this.g, paramg);
      localObject = this.f.a((u)localObject, this.q, paramg);
      ((cz.msebera.android.httpclient.x)localObject).setParams(this.p);
      this.f.a((cz.msebera.android.httpclient.x)localObject, this.g, paramg);
      if (((cz.msebera.android.httpclient.x)localObject).a().b() < 200) {
        throw new cz.msebera.android.httpclient.p("Unexpected response to CONNECT request: " + ((cz.msebera.android.httpclient.x)localObject).a());
      }
      if (cz.msebera.android.httpclient.b.e.g.b(this.p))
      {
        if ((!this.t.a(localr1, (cz.msebera.android.httpclient.x)localObject, this.n, this.s, paramg)) || (!this.t.c(localr1, (cz.msebera.android.httpclient.x)localObject, this.n, this.s, paramg))) {
          break;
        }
        if (this.d.a((cz.msebera.android.httpclient.x)localObject, paramg))
        {
          this.a.a("Connection kept alive");
          cz.msebera.android.httpclient.o.g.b(((cz.msebera.android.httpclient.x)localObject).b());
        }
        else
        {
          this.q.close();
        }
      }
    }
    if (((cz.msebera.android.httpclient.x)localObject).a().b() > 299)
    {
      paramb = ((cz.msebera.android.httpclient.x)localObject).b();
      if (paramb != null) {
        ((cz.msebera.android.httpclient.x)localObject).a(new cz.msebera.android.httpclient.g.c(paramb));
      }
      this.q.close();
      throw new az("CONNECT refused by proxy: " + ((cz.msebera.android.httpclient.x)localObject).a(), (cz.msebera.android.httpclient.x)localObject);
    }
    this.q.o();
    return false;
  }
  
  protected u c(cz.msebera.android.httpclient.e.b.b paramb, cz.msebera.android.httpclient.n.g paramg)
  {
    paramg = paramb.a();
    paramb = paramg.a();
    int i2 = paramg.b();
    int i1 = i2;
    if (i2 < 0) {
      i1 = this.b.a().a(paramg.c()).a();
    }
    paramg = new StringBuilder(paramb.length() + 6);
    paramg.append(paramb);
    paramg.append(':');
    paramg.append(Integer.toString(i1));
    return new cz.msebera.android.httpclient.k.i("CONNECT", paramg.toString(), cz.msebera.android.httpclient.l.m.c(this.p));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */