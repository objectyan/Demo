package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.a.d;
import cz.msebera.android.httpclient.a.i;
import cz.msebera.android.httpclient.a.j;
import cz.msebera.android.httpclient.a.m;
import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

public class f
{
  public cz.msebera.android.httpclient.h.b a;
  
  public f()
  {
    this(null);
  }
  
  public f(cz.msebera.android.httpclient.h.b paramb)
  {
    if (paramb != null) {}
    for (;;)
    {
      this.a = paramb;
      return;
      paramb = new cz.msebera.android.httpclient.h.b(getClass());
    }
  }
  
  private cz.msebera.android.httpclient.f a(d paramd, n paramn, u paramu, g paramg)
    throws j
  {
    if ((paramd instanceof m)) {
      return ((m)paramd).a(paramn, paramu, paramg);
    }
    return paramd.a(paramn, paramu);
  }
  
  private void a(d paramd)
  {
    cz.msebera.android.httpclient.o.b.a(paramd, "Auth scheme");
  }
  
  public void a(u paramu, i parami, g paramg)
    throws cz.msebera.android.httpclient.p, IOException
  {
    d locald = parami.c();
    Object localObject = parami.d();
    switch (1.a[parami.b().ordinal()])
    {
    }
    for (;;)
    {
      if (locald != null) {}
      try
      {
        paramu.addHeader(a(locald, (n)localObject, paramu, paramg));
        for (;;)
        {
          return;
          a(locald);
          if (!locald.c()) {
            break;
          }
          return;
          Queue localQueue = parami.e();
          if (localQueue == null) {
            break label260;
          }
          while (!localQueue.isEmpty())
          {
            localObject = (cz.msebera.android.httpclient.a.b)localQueue.remove();
            locald = ((cz.msebera.android.httpclient.a.b)localObject).a();
            localObject = ((cz.msebera.android.httpclient.a.b)localObject).b();
            parami.a(locald, (n)localObject);
            if (this.a.a()) {
              this.a.a("Generating response to an authentication challenge using " + locald.a() + " scheme");
            }
            try
            {
              paramu.addHeader(a(locald, (n)localObject, paramu, paramg));
              return;
            }
            catch (j localj) {}
            if (this.a.c()) {
              this.a.c(locald + " authentication error: " + localj.getMessage());
            }
          }
        }
        label260:
        a(locald);
      }
      catch (j paramu)
      {
        while (!this.a.b()) {}
        this.a.b(locald + " authentication error: " + paramu.getMessage());
      }
    }
  }
  
  public boolean a(r paramr, x paramx, cz.msebera.android.httpclient.b.c paramc, i parami, g paramg)
  {
    if (paramc.a(paramr, paramx, paramg))
    {
      this.a.a("Authentication required");
      if (parami.b() == cz.msebera.android.httpclient.a.c.e) {
        paramc.b(paramr, parami.c(), paramg);
      }
      return true;
    }
    switch (1.a[parami.b().ordinal()])
    {
    default: 
      parami.a(cz.msebera.android.httpclient.a.c.a);
    }
    for (;;)
    {
      return false;
      this.a.a("Authentication succeeded");
      parami.a(cz.msebera.android.httpclient.a.c.e);
      paramc.a(paramr, parami.c(), paramg);
    }
  }
  
  public boolean b(r paramr, x paramx, cz.msebera.android.httpclient.b.c paramc, i parami, g paramg)
  {
    for (;;)
    {
      Map localMap;
      d locald;
      try
      {
        if (this.a.a()) {
          this.a.a(paramr.f() + " requested authentication");
        }
        localMap = paramc.b(paramr, paramx, paramg);
        if (localMap.isEmpty())
        {
          this.a.a("Response contains no authentication challenges");
          return false;
        }
        locald = parami.c();
        switch (1.a[parami.b().ordinal()])
        {
        case 3: 
          paramr = paramc.a(localMap, paramr, paramx, paramg);
          if ((paramr == null) || (paramr.isEmpty())) {
            break label415;
          }
          if (this.a.a()) {
            this.a.a("Selected authentication options: " + paramr);
          }
          parami.a(cz.msebera.android.httpclient.a.c.b);
          parami.a(paramr);
          return true;
        }
      }
      catch (cz.msebera.android.httpclient.a.p paramr)
      {
        if (!this.a.c()) {
          continue;
        }
        this.a.c("Malformed challenge: " + paramr.getMessage());
        parami.a();
        return false;
      }
      parami.a();
      continue;
      if (locald == null)
      {
        this.a.a("Auth scheme is null");
        paramc.b(paramr, null, paramg);
        parami.a();
        parami.a(cz.msebera.android.httpclient.a.c.d);
        return false;
      }
      if (locald != null)
      {
        cz.msebera.android.httpclient.f localf = (cz.msebera.android.httpclient.f)localMap.get(locald.a().toLowerCase(Locale.ENGLISH));
        if (localf != null)
        {
          this.a.a("Authorization challenge processed");
          locald.a(localf);
          if (locald.d())
          {
            this.a.a("Authentication failed");
            paramc.b(paramr, parami.c(), paramg);
            parami.a();
            parami.a(cz.msebera.android.httpclient.a.c.d);
            return false;
          }
          parami.a(cz.msebera.android.httpclient.a.c.c);
          return true;
        }
        parami.a();
        continue;
        label415:
        return false;
      }
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */