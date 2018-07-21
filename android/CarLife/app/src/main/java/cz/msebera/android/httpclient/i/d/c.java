package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f.n;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@NotThreadSafe
public class c
  implements cz.msebera.android.httpclient.f.a, n, Serializable, Cloneable
{
  private static final long k = -3869795591041535538L;
  private final String l;
  private Map<String, String> m;
  private String n;
  private String o;
  private String p;
  private Date q;
  private String r;
  private boolean s;
  private int t;
  
  public c(String paramString1, String paramString2)
  {
    cz.msebera.android.httpclient.o.a.a(paramString1, "Name");
    this.l = paramString1;
    this.m = new HashMap();
    this.n = paramString2;
  }
  
  public String a()
  {
    return this.l;
  }
  
  public String a(String paramString)
  {
    return (String)this.m.get(paramString);
  }
  
  public void a(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.m.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public boolean a(Date paramDate)
  {
    cz.msebera.android.httpclient.o.a.a(paramDate, "Date");
    return (this.q != null) && (this.q.getTime() <= paramDate.getTime());
  }
  
  public String b()
  {
    return this.n;
  }
  
  public void b(Date paramDate)
  {
    this.q = paramDate;
  }
  
  public boolean b(String paramString)
  {
    return this.m.get(paramString) != null;
  }
  
  public String c()
  {
    return this.o;
  }
  
  public void c(String paramString)
  {
    this.n = paramString;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    c localc = (c)super.clone();
    localc.m = new HashMap(this.m);
    return localc;
  }
  
  public String d()
  {
    return null;
  }
  
  public void d(String paramString)
  {
    this.o = paramString;
  }
  
  public Date e()
  {
    return this.q;
  }
  
  public void e(String paramString)
  {
    if (paramString != null)
    {
      this.p = paramString.toLowerCase(Locale.ENGLISH);
      return;
    }
    this.p = null;
  }
  
  public void f(String paramString)
  {
    this.r = paramString;
  }
  
  public boolean f()
  {
    return this.q != null;
  }
  
  public String g()
  {
    return this.p;
  }
  
  public String h()
  {
    return this.r;
  }
  
  public int[] i()
  {
    return null;
  }
  
  public boolean j()
  {
    return this.s;
  }
  
  public int k()
  {
    return this.t;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[version: ");
    localStringBuilder.append(Integer.toString(this.t));
    localStringBuilder.append("]");
    localStringBuilder.append("[name: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("]");
    localStringBuilder.append("[value: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append("]");
    localStringBuilder.append("[domain: ");
    localStringBuilder.append(this.p);
    localStringBuilder.append("]");
    localStringBuilder.append("[path: ");
    localStringBuilder.append(this.r);
    localStringBuilder.append("]");
    localStringBuilder.append("[expiry: ");
    localStringBuilder.append(this.q);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */