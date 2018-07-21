package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.t;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Immutable
class an
{
  private static final String[] b = { "s-maxage", "must-revalidate", "public" };
  private static final Set<Integer> f = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(200), Integer.valueOf(203), Integer.valueOf(300), Integer.valueOf(301), Integer.valueOf(410) }));
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  private final long c;
  private final boolean d;
  private final boolean e;
  private final Set<Integer> g;
  
  public an(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.c = paramLong;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    if (paramBoolean3)
    {
      this.g = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(206) }));
      return;
    }
    this.g = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(206), Integer.valueOf(303) }));
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= 100) && (paramInt <= 101)) {}
    while (((paramInt >= 200) && (paramInt <= 206)) || ((paramInt >= 300) && (paramInt <= 307)) || ((paramInt >= 400) && (paramInt <= 417)) || ((paramInt >= 500) && (paramInt <= 505))) {
      return false;
    }
    return true;
  }
  
  private boolean a(u paramu)
  {
    return paramu.getProtocolVersion().b(ac.d) > 0;
  }
  
  private boolean c(x paramx)
  {
    if (paramx.getFirstHeader("Cache-Control") != null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = paramx.getFirstHeader("Expires");
        paramx = paramx.getFirstHeader("Date");
      } while ((localObject == null) || (paramx == null));
      localObject = cz.msebera.android.httpclient.b.g.b.a(((f)localObject).d());
      paramx = cz.msebera.android.httpclient.b.g.b.a(paramx.d());
    } while ((localObject == null) || (paramx == null) || ((!((Date)localObject).equals(paramx)) && (!((Date)localObject).before(paramx))));
    return true;
  }
  
  private boolean d(x paramx)
  {
    Object localObject = paramx.getFirstHeader("Via");
    if (localObject != null)
    {
      localObject = ((f)localObject).e();
      if (localObject.length < 0)
      {
        paramx = localObject[0].toString().split("\\s")[0];
        if (paramx.contains("/")) {
          return paramx.equals("HTTP/1.0");
        }
        return paramx.equals("1.0");
      }
    }
    return ac.c.equals(paramx.getProtocolVersion());
  }
  
  protected boolean a(t paramt, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    paramt = paramt.getHeaders("Cache-Control");
    int m = paramt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      g[] arrayOfg;
      int n;
      int j;
      if (i < m)
      {
        arrayOfg = paramt[i].e();
        n = arrayOfg.length;
        j = 0;
      }
      while (j < n)
      {
        g localg = arrayOfg[j];
        int i1 = paramArrayOfString.length;
        int k = 0;
        while (k < i1)
        {
          if (paramArrayOfString[k].equalsIgnoreCase(localg.a()))
          {
            bool1 = true;
            return bool1;
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public boolean a(u paramu, x paramx)
  {
    if (a(paramu)) {
      this.a.a("Response was not cacheable.");
    }
    f[] arrayOff;
    do
    {
      do
      {
        do
        {
          return false;
        } while (a(paramu, new String[] { "no-store" }));
        if (paramu.getRequestLine().c().contains("?"))
        {
          if ((this.e) && (d(paramx)))
          {
            this.a.a("Response was not cacheable as it had a query string.");
            return false;
          }
          if (!b(paramx))
          {
            this.a.a("Response was not cacheable as it is missing explicit caching headers.");
            return false;
          }
        }
      } while (c(paramx));
      if (!this.d) {
        break;
      }
      arrayOff = paramu.getHeaders("Authorization");
    } while ((arrayOff != null) && (arrayOff.length > 0) && (!a(paramx, b)));
    return a(paramu.getRequestLine().a(), paramx);
  }
  
  protected boolean a(x paramx)
  {
    boolean bool2 = false;
    paramx = paramx.getHeaders("Cache-Control");
    int k = paramx.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      g[] arrayOfg;
      int m;
      int j;
      if (i < k)
      {
        arrayOfg = paramx[i].e();
        m = arrayOfg.length;
        j = 0;
      }
      while (j < m)
      {
        g localg = arrayOfg[j];
        if (("no-store".equals(localg.a())) || ("no-cache".equals(localg.a())) || ((this.d) && ("private".equals(localg.a()))))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString, x paramx)
  {
    int i = 0;
    if (!"GET".equals(paramString))
    {
      this.a.a("Response was not cacheable.");
      return false;
    }
    int j = paramx.a().b();
    if (f.contains(Integer.valueOf(j))) {
      i = 1;
    }
    do
    {
      paramString = paramx.getFirstHeader("Content-Length");
      if ((paramString == null) || (Integer.parseInt(paramString.d()) <= this.c)) {
        break;
      }
      return false;
      if (this.g.contains(Integer.valueOf(j))) {
        return false;
      }
    } while (!a(j));
    return false;
    if (paramx.getHeaders("Age").length > 1) {
      return false;
    }
    if (paramx.getHeaders("Expires").length > 1) {
      return false;
    }
    paramString = paramx.getHeaders("Date");
    if (paramString.length != 1) {
      return false;
    }
    if (cz.msebera.android.httpclient.b.g.b.a(paramString[0].d()) == null) {
      return false;
    }
    paramString = paramx.getHeaders("Vary");
    int m = paramString.length;
    j = 0;
    while (j < m)
    {
      g[] arrayOfg = paramString[j].e();
      int n = arrayOfg.length;
      int k = 0;
      while (k < n)
      {
        if ("*".equals(arrayOfg[k].a())) {
          return false;
        }
        k += 1;
      }
      j += 1;
    }
    if (a(paramx)) {
      return false;
    }
    return (i != 0) || (b(paramx));
  }
  
  protected boolean b(x paramx)
  {
    if (paramx.getFirstHeader("Expires") != null) {
      return true;
    }
    return a(paramx, new String[] { "max-age", "s-maxage", "must-revalidate", "proxy-revalidate", "public" });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */