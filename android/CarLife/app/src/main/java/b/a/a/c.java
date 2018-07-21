package b.a.a;

import b.a.a;
import b.a.d.e;
import b.ab;
import b.ab.a;
import b.ad;
import b.ad.a;
import b.t;
import b.t.a;
import b.u;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class c
{
  public final ab a;
  public final ad b;
  
  c(ab paramab, ad paramad)
  {
    this.a = paramab;
    this.b = paramad;
  }
  
  public static boolean a(ad paramad, ab paramab)
  {
    switch (paramad.c())
    {
    }
    do
    {
      return false;
    } while (((paramad.b("Expires") == null) && (paramad.o().c() == -1) && (!paramad.o().f()) && (!paramad.o().e())) || (paramad.o().b()) || (paramab.g().b()));
    return true;
  }
  
  public static class a
  {
    final long a;
    final ab b;
    final ad c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;
    
    public a(long paramLong, ab paramab, ad paramad)
    {
      this.a = paramLong;
      this.b = paramab;
      this.c = paramad;
      if (paramad != null)
      {
        this.i = paramad.p();
        this.j = paramad.q();
        paramab = paramad.g();
        int m = 0;
        int n = paramab.a();
        if (m < n)
        {
          paramad = paramab.a(m);
          String str = paramab.b(m);
          if ("Date".equalsIgnoreCase(paramad))
          {
            this.d = b.a.d.d.a(str);
            this.e = str;
          }
          for (;;)
          {
            m += 1;
            break;
            if ("Expires".equalsIgnoreCase(paramad))
            {
              this.h = b.a.d.d.a(str);
            }
            else if ("Last-Modified".equalsIgnoreCase(paramad))
            {
              this.f = b.a.d.d.a(str);
              this.g = str;
            }
            else if ("ETag".equalsIgnoreCase(paramad))
            {
              this.k = str;
            }
            else if ("Age".equalsIgnoreCase(paramad))
            {
              this.l = e.b(str, -1);
            }
          }
        }
      }
    }
    
    private static boolean a(ab paramab)
    {
      return (paramab.a("If-Modified-Since") != null) || (paramab.a("If-None-Match") != null);
    }
    
    private c b()
    {
      if (this.c == null) {
        return new c(this.b, null);
      }
      if ((this.b.h()) && (this.c.f() == null)) {
        return new c(this.b, null);
      }
      if (!c.a(this.c, this.b)) {
        return new c(this.b, null);
      }
      Object localObject1 = this.b.g();
      if ((((b.d)localObject1).a()) || (a(this.b))) {
        return new c(this.b, null);
      }
      long l5 = d();
      long l2 = c();
      long l1 = l2;
      if (((b.d)localObject1).c() != -1) {
        l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((b.d)localObject1).c()));
      }
      l2 = 0L;
      if (((b.d)localObject1).i() != -1) {
        l2 = TimeUnit.SECONDS.toMillis(((b.d)localObject1).i());
      }
      long l4 = 0L;
      Object localObject2 = this.c.o();
      long l3 = l4;
      if (!((b.d)localObject2).g())
      {
        l3 = l4;
        if (((b.d)localObject1).h() != -1) {
          l3 = TimeUnit.SECONDS.toMillis(((b.d)localObject1).h());
        }
      }
      if ((!((b.d)localObject2).a()) && (l5 + l2 < l1 + l3))
      {
        localObject1 = this.c.i();
        if (l5 + l2 >= l1) {
          ((ad.a)localObject1).b("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if ((l5 > 86400000L) && (e())) {
          ((ad.a)localObject1).b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        }
        return new c(null, ((ad.a)localObject1).a());
      }
      if (this.k != null)
      {
        localObject1 = "If-None-Match";
        localObject2 = this.k;
      }
      for (;;)
      {
        t.a locala = this.b.c().c();
        a.a.a(locala, (String)localObject1, (String)localObject2);
        return new c(this.b.f().a(locala.a()).d(), this.c);
        if (this.f != null)
        {
          localObject1 = "If-Modified-Since";
          localObject2 = this.g;
        }
        else
        {
          if (this.d == null) {
            break;
          }
          localObject1 = "If-Modified-Since";
          localObject2 = this.e;
        }
      }
      return new c(this.b, null);
    }
    
    private long c()
    {
      long l2 = 0L;
      b.d locald = this.c.o();
      if (locald.c() != -1) {
        l1 = TimeUnit.SECONDS.toMillis(locald.c());
      }
      label83:
      do
      {
        do
        {
          return l1;
          if (this.h != null)
          {
            if (this.d != null)
            {
              l1 = this.d.getTime();
              l1 = this.h.getTime() - l1;
              if (l1 <= 0L) {
                break label83;
              }
            }
            for (;;)
            {
              return l1;
              l1 = this.j;
              break;
              l1 = 0L;
            }
          }
          l1 = l2;
        } while (this.f == null);
        l1 = l2;
      } while (this.c.a().a().p() != null);
      if (this.d != null) {}
      for (long l1 = this.d.getTime();; l1 = this.i)
      {
        long l3 = l1 - this.f.getTime();
        l1 = l2;
        if (l3 <= 0L) {
          break;
        }
        return l3 / 10L;
      }
    }
    
    private long d()
    {
      long l1 = 0L;
      if (this.d != null) {
        l1 = Math.max(0L, this.j - this.d.getTime());
      }
      if (this.l != -1) {
        l1 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.l));
      }
      for (;;)
      {
        return l1 + (this.j - this.i) + (this.a - this.j);
      }
    }
    
    private boolean e()
    {
      return (this.c.o().c() == -1) && (this.h == null);
    }
    
    public c a()
    {
      c localc2 = b();
      c localc1 = localc2;
      if (localc2.a != null)
      {
        localc1 = localc2;
        if (this.b.g().j()) {
          localc1 = new c(null, null);
        }
      }
      return localc1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */