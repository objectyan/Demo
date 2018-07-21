package cz.msebera.android.httpclient.b.a;

import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.g.b;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.k.s;
import cz.msebera.android.httpclient.o.a;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Immutable
public class d
  implements Serializable
{
  private static final long a = -6300496422359477413L;
  private final Date b;
  private final Date c;
  private final an d;
  private final s e;
  private final l f;
  private final Map<String, String> g;
  private final Date h;
  
  public d(Date paramDate1, Date paramDate2, an paraman, f[] paramArrayOff, l paraml)
  {
    this(paramDate1, paramDate2, paraman, paramArrayOff, paraml, new HashMap());
  }
  
  public d(Date paramDate1, Date paramDate2, an paraman, f[] paramArrayOff, l paraml, Map<String, String> paramMap)
  {
    a.a(paramDate1, "Request date");
    a.a(paramDate2, "Response date");
    a.a(paraman, "Status line");
    a.a(paramArrayOff, "Response headers");
    this.b = paramDate1;
    this.c = paramDate2;
    this.d = paraman;
    this.e = new s();
    this.e.a(paramArrayOff);
    this.f = paraml;
    if (paramMap != null) {}
    for (paramDate1 = new HashMap(paramMap);; paramDate1 = null)
    {
      this.g = paramDate1;
      this.h = l();
      return;
    }
  }
  
  private Date l()
  {
    f localf = a("Date");
    if (localf == null) {
      return null;
    }
    return b.a(localf.d());
  }
  
  public an a()
  {
    return this.d;
  }
  
  public f a(String paramString)
  {
    return this.e.c(paramString);
  }
  
  public ak b()
  {
    return this.d.a();
  }
  
  public f[] b(String paramString)
  {
    return this.e.b(paramString);
  }
  
  public String c()
  {
    return this.d.c();
  }
  
  public int d()
  {
    return this.d.b();
  }
  
  public Date e()
  {
    return this.b;
  }
  
  public Date f()
  {
    return this.c;
  }
  
  public f[] g()
  {
    return this.e.b();
  }
  
  public Date h()
  {
    return this.h;
  }
  
  public l i()
  {
    return this.f;
  }
  
  public boolean j()
  {
    return a("Vary") != null;
  }
  
  public Map<String, String> k()
  {
    return Collections.unmodifiableMap(this.g);
  }
  
  public String toString()
  {
    return "[request date=" + this.b + "; response date=" + this.c + "; statusLine=" + this.d + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */