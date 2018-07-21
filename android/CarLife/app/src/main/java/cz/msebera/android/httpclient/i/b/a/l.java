package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.g.b;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.u;
import java.util.Date;

@Immutable
class l
{
  public static final long a = 2147483648L;
  
  private boolean a(f[] paramArrayOff, long paramLong)
  {
    boolean bool1 = false;
    int k = paramArrayOff.length;
    int i = 0;
    if (i < k)
    {
      g[] arrayOfg = paramArrayOff[i].e();
      int m = arrayOfg.length;
      int j = 0;
      for (;;)
      {
        boolean bool2 = bool1;
        g localg;
        if (j < m)
        {
          localg = arrayOfg[j];
          if (!"stale-if-error".equals(localg.a())) {}
        }
        else
        {
          try
          {
            int n = Integer.parseInt(localg.b());
            if (paramLong <= n)
            {
              bool2 = true;
              i += 1;
              bool1 = bool2;
            }
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
        j += 1;
      }
    }
    return bool1;
  }
  
  public long a(d paramd)
  {
    long l = o(paramd);
    if (l > -1L) {
      return l;
    }
    Date localDate = paramd.h();
    if (localDate == null) {
      return 0L;
    }
    paramd = p(paramd);
    if (paramd == null) {
      return 0L;
    }
    return (paramd.getTime() - localDate.getTime()) / 1000L;
  }
  
  public long a(d paramd, float paramFloat, long paramLong)
  {
    Date localDate = paramd.h();
    paramd = f(paramd);
    long l = paramLong;
    if (localDate != null)
    {
      l = paramLong;
      if (paramd != null)
      {
        paramLong = localDate.getTime() - paramd.getTime();
        if (paramLong >= 0L) {
          break label50;
        }
        l = 0L;
      }
    }
    return l;
    label50:
    return ((float)(paramLong / 1000L) * paramFloat);
  }
  
  public long a(d paramd, Date paramDate)
  {
    return n(paramd) + d(paramd, paramDate);
  }
  
  public boolean a(d paramd, String paramString)
  {
    boolean bool2 = false;
    paramd = paramd.b("Cache-Control");
    int k = paramd.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      g[] arrayOfg;
      int m;
      int j;
      if (i < k)
      {
        arrayOfg = paramd[i].e();
        m = arrayOfg.length;
        j = 0;
      }
      while (j < m)
      {
        if (paramString.equalsIgnoreCase(arrayOfg[j].a()))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public boolean a(d paramd, Date paramDate, float paramFloat, long paramLong)
  {
    return a(paramd, paramDate) < a(paramd, paramFloat, paramLong);
  }
  
  public boolean a(u paramu, d paramd, Date paramDate)
  {
    long l = e(paramd, paramDate);
    return (a(paramu.getHeaders("Cache-Control"), l)) || (a(paramd.b("Cache-Control"), l));
  }
  
  public boolean b(d paramd)
  {
    return (paramd.a("ETag") != null) || (paramd.a("Last-Modified") != null);
  }
  
  public boolean b(d paramd, Date paramDate)
  {
    return a(paramd, paramDate) < a(paramd);
  }
  
  public boolean c(d paramd)
  {
    return a(paramd, "must-revalidate");
  }
  
  public boolean c(d paramd, Date paramDate)
  {
    f[] arrayOff = paramd.b("Cache-Control");
    int k = arrayOff.length;
    int i = 0;
    while (i < k)
    {
      g[] arrayOfg = arrayOff[i].e();
      int m = arrayOfg.length;
      int j = 0;
      while (j < m)
      {
        g localg = arrayOfg[j];
        if ("stale-while-revalidate".equalsIgnoreCase(localg.a())) {
          try
          {
            int n = Integer.parseInt(localg.b());
            long l = e(paramd, paramDate);
            if (l <= n) {
              return true;
            }
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }
  
  protected long d(d paramd, Date paramDate)
  {
    return (paramDate.getTime() - paramd.f().getTime()) / 1000L;
  }
  
  public boolean d(d paramd)
  {
    return a(paramd, "proxy-revalidate");
  }
  
  public long e(d paramd, Date paramDate)
  {
    long l1 = a(paramd, paramDate);
    long l2 = a(paramd);
    if (l1 <= l2) {
      return 0L;
    }
    return l1 - l2;
  }
  
  @Deprecated
  protected Date e(d paramd)
  {
    return paramd.h();
  }
  
  protected Date f(d paramd)
  {
    paramd = paramd.a("Last-Modified");
    if (paramd == null) {
      return null;
    }
    return b.a(paramd.d());
  }
  
  protected long g(d paramd)
  {
    paramd = paramd.a("Content-Length");
    if (paramd == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramd.d());
      return l;
    }
    catch (NumberFormatException paramd) {}
    return -1L;
  }
  
  protected boolean h(d paramd)
  {
    return paramd.a("Content-Length") != null;
  }
  
  protected boolean i(d paramd)
  {
    return (!h(paramd)) || (g(paramd) == paramd.i().b());
  }
  
  protected long j(d paramd)
  {
    long l1 = 0L;
    Date localDate = paramd.h();
    if (localDate == null) {
      l1 = 2147483648L;
    }
    long l2;
    do
    {
      return l1;
      l2 = paramd.f().getTime() - localDate.getTime();
    } while (l2 < 0L);
    return l2 / 1000L;
  }
  
  protected long k(d paramd)
  {
    long l2 = 0L;
    paramd = paramd.b("Age");
    int j = paramd.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramd[i];
      try
      {
        l3 = Long.parseLong(((f)localObject).d());
        l1 = l3;
        if (l3 < 0L) {
          l1 = 2147483648L;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          long l3;
          long l1 = 2147483648L;
        }
      }
      l3 = l2;
      if (l1 > l2) {
        l3 = l1;
      }
      i += 1;
      l2 = l3;
    }
    return l2;
  }
  
  protected long l(d paramd)
  {
    long l1 = j(paramd);
    long l2 = k(paramd);
    if (l1 > l2) {
      return l1;
    }
    return l2;
  }
  
  protected long m(d paramd)
  {
    return (paramd.f().getTime() - paramd.e().getTime()) / 1000L;
  }
  
  protected long n(d paramd)
  {
    return l(paramd) + m(paramd);
  }
  
  protected long o(d paramd)
  {
    long l2 = -1L;
    paramd = paramd.b("Cache-Control");
    int k = paramd.length;
    int i = 0;
    while (i < k)
    {
      g[] arrayOfg = paramd[i].e();
      int m = arrayOfg.length;
      int j = 0;
      long l1;
      while (j < m)
      {
        g localg = arrayOfg[j];
        if (!"max-age".equals(localg.a()))
        {
          l1 = l2;
          if (!"s-maxage".equals(localg.a())) {
            break label124;
          }
        }
        try
        {
          long l3 = Long.parseLong(localg.b());
          if (l2 != -1L)
          {
            l1 = l2;
            if (l3 >= l2) {}
          }
          else
          {
            l1 = l3;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            label124:
            l1 = 0L;
          }
        }
        j += 1;
        l2 = l1;
      }
      i += 1;
    }
    return l2;
  }
  
  protected Date p(d paramd)
  {
    paramd = paramd.a("Expires");
    if (paramd == null) {
      return null;
    }
    return b.a(paramd.d());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */