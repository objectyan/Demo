package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import java.util.Date;

@Immutable
class o
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final boolean b;
  private final boolean c;
  private final float d;
  private final long e;
  private final l f;
  
  o(f paramf)
  {
    this(new l(), paramf);
  }
  
  o(l paraml, f paramf)
  {
    this.f = paraml;
    this.b = paramf.k();
    this.c = paramf.h();
    this.d = paramf.i();
    this.e = paramf.j();
  }
  
  private boolean a(d paramd)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.f.c(paramd)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.b);
      if (this.f.d(paramd)) {
        break;
      }
      bool1 = bool2;
    } while (!this.f.a(paramd, "s-maxage"));
    return true;
  }
  
  private boolean a(d paramd, u paramu, Date paramDate)
  {
    if (this.f.b(paramd, paramDate)) {}
    while ((this.c) && (this.f.a(paramd, paramDate, this.d, this.e))) {
      return true;
    }
    if (a(paramd)) {
      return false;
    }
    long l = b(paramu);
    if (l == -1L) {
      return false;
    }
    if (l > this.f.e(paramd, paramDate)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(u paramu, d paramd)
  {
    boolean bool2 = false;
    paramd = paramd.a("ETag");
    boolean bool1;
    int k;
    int i;
    if (paramd != null)
    {
      paramd = paramd.d();
      paramu = paramu.getHeaders("If-None-Match");
      bool1 = bool2;
      if (paramu != null)
      {
        k = paramu.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      g[] arrayOfg;
      int m;
      int j;
      if (i < k)
      {
        arrayOfg = paramu[i].e();
        m = arrayOfg.length;
        j = 0;
      }
      for (;;)
      {
        if (j >= m) {
          break label132;
        }
        String str = arrayOfg[j].toString();
        if ((("*".equals(str)) && (paramd != null)) || (str.equals(paramd)))
        {
          bool1 = true;
          return bool1;
          paramd = null;
          break;
        }
        j += 1;
      }
      label132:
      i += 1;
    }
  }
  
  private boolean a(u paramu, String paramString)
  {
    boolean bool2 = false;
    paramu = paramu.getHeaders(paramString);
    boolean bool1 = bool2;
    if (paramu.length < 0)
    {
      bool1 = bool2;
      if (cz.msebera.android.httpclient.b.g.b.a(paramu[0].d()) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long b(u paramu)
  {
    long l3 = -1L;
    paramu = paramu.getHeaders("Cache-Control");
    int k = paramu.length;
    int i = 0;
    while (i < k)
    {
      g[] arrayOfg = paramu[i].e();
      int m = arrayOfg.length;
      int j = 0;
      if (j < m)
      {
        g localg = arrayOfg[j];
        long l1 = l3;
        if ("max-stale".equals(localg.a()))
        {
          if (((localg.b() != null) && (!"".equals(localg.b().trim()))) || (l3 != -1L)) {
            break label127;
          }
          l1 = Long.MAX_VALUE;
        }
        for (;;)
        {
          j += 1;
          l3 = l1;
          break;
          try
          {
            label127:
            l1 = Long.parseLong(localg.b());
            long l2 = l1;
            if (l1 < 0L) {
              l2 = 0L;
            }
            if (l3 != -1L)
            {
              l1 = l3;
              if (l2 >= l3) {}
            }
            else
            {
              l1 = l2;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            l1 = 0L;
          }
        }
      }
      i += 1;
    }
    return l3;
  }
  
  private boolean b(u paramu, d paramd, Date paramDate)
  {
    Object localObject = paramd.a("Last-Modified");
    paramd = null;
    if (localObject != null) {
      paramd = cz.msebera.android.httpclient.b.g.b.a(((cz.msebera.android.httpclient.f)localObject).d());
    }
    if (paramd == null) {
      return false;
    }
    paramu = paramu.getHeaders("If-Modified-Since");
    int j = paramu.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label101;
      }
      localObject = cz.msebera.android.httpclient.b.g.b.a(paramu[i].d());
      if ((localObject != null) && ((((Date)localObject).after(paramDate)) || (paramd.after((Date)localObject)))) {
        break;
      }
      i += 1;
    }
    label101:
    return true;
  }
  
  private boolean c(u paramu)
  {
    return (paramu.getFirstHeader("If-Range") != null) || (paramu.getFirstHeader("If-Match") != null) || (a(paramu, "If-Unmodified-Since"));
  }
  
  private boolean d(u paramu)
  {
    return paramu.containsHeader("If-None-Match");
  }
  
  private boolean e(u paramu)
  {
    return a(paramu, "If-Modified-Since");
  }
  
  public boolean a(r paramr, u paramu, d paramd, Date paramDate)
  {
    if (!a(paramd, paramu, paramDate))
    {
      this.a.e("Cache entry was not fresh enough");
      return false;
    }
    if (!this.f.i(paramd))
    {
      this.a.a("Cache entry Content-Length and header information do not match");
      return false;
    }
    if (c(paramu))
    {
      this.a.a("Request contained conditional headers we don't handle");
      return false;
    }
    if ((!a(paramu)) && (paramd.d() == 304)) {
      return false;
    }
    if ((a(paramu)) && (!a(paramu, paramd, paramDate))) {
      return false;
    }
    paramr = paramu.getHeaders("Cache-Control");
    int k = paramr.length;
    int i = 0;
    while (i < k)
    {
      paramu = paramr[i].e();
      int m = paramu.length;
      int j = 0;
      while (j < m)
      {
        Object localObject = paramu[j];
        if ("no-cache".equals(((g)localObject).a()))
        {
          this.a.e("Response contained NO CACHE directive, cache was not suitable");
          return false;
        }
        if ("no-store".equals(((g)localObject).a()))
        {
          this.a.e("Response contained NO STORE directive, cache was not suitable");
          return false;
        }
        int n;
        if ("max-age".equals(((g)localObject).a())) {
          try
          {
            n = Integer.parseInt(((g)localObject).b());
            if (this.f.a(paramd, paramDate) > n)
            {
              this.a.e("Response from cache was NOT suitable due to max age");
              return false;
            }
          }
          catch (NumberFormatException paramr)
          {
            this.a.a("Response from cache was malformed" + paramr.getMessage());
            return false;
          }
        }
        if ("max-stale".equals(((g)localObject).a())) {
          try
          {
            n = Integer.parseInt(((g)localObject).b());
            if (this.f.a(paramd) > n)
            {
              this.a.e("Response from cache was not suitable due to Max stale freshness");
              return false;
            }
          }
          catch (NumberFormatException paramr)
          {
            this.a.a("Response from cache was malformed: " + paramr.getMessage());
            return false;
          }
        }
        if ("min-fresh".equals(((g)localObject).a())) {
          try
          {
            long l1 = Long.parseLong(((g)localObject).b());
            if (l1 < 0L) {
              return false;
            }
            long l2 = this.f.a(paramd, paramDate);
            if (this.f.a(paramd) - l2 < l1)
            {
              this.a.e("Response from cache was not suitable due to min fresh freshness requirement");
              return false;
            }
          }
          catch (NumberFormatException paramr)
          {
            this.a.a("Response from cache was malformed: " + paramr.getMessage());
            return false;
          }
        }
        j += 1;
      }
      i += 1;
    }
    this.a.e("Response from cache was suitable");
    return true;
  }
  
  public boolean a(u paramu)
  {
    return (d(paramu)) || (e(paramu));
  }
  
  public boolean a(u paramu, d paramd, Date paramDate)
  {
    boolean bool1 = d(paramu);
    boolean bool2 = e(paramu);
    int i;
    int j;
    if ((bool1) && (a(paramu, paramd)))
    {
      i = 1;
      if ((!bool2) || (!b(paramu, paramd, paramDate))) {
        break label77;
      }
      j = 1;
      label49:
      if ((!bool1) || (!bool2) || ((i != 0) && (j != 0))) {
        break label83;
      }
    }
    label77:
    label83:
    while (((bool1) && (i == 0)) || ((bool2) && (j == 0)))
    {
      return false;
      i = 0;
      break;
      j = 0;
      break label49;
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */