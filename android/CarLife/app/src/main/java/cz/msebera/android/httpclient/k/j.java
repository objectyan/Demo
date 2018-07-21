package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.al;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.x;
import java.util.Locale;

@NotThreadSafe
public class j
  extends a
  implements x
{
  private an a;
  private ak b;
  private int c;
  private String d;
  private n e;
  private final al f;
  private Locale g;
  
  public j(ak paramak, int paramInt, String paramString)
  {
    cz.msebera.android.httpclient.o.a.b(paramInt, "Status code");
    this.a = null;
    this.b = paramak;
    this.c = paramInt;
    this.d = paramString;
    this.f = null;
    this.g = null;
  }
  
  public j(an paraman)
  {
    this.a = ((an)cz.msebera.android.httpclient.o.a.a(paraman, "Status line"));
    this.b = paraman.a();
    this.c = paraman.b();
    this.d = paraman.c();
    this.f = null;
    this.g = null;
  }
  
  public j(an paraman, al paramal, Locale paramLocale)
  {
    this.a = ((an)cz.msebera.android.httpclient.o.a.a(paraman, "Status line"));
    this.b = paraman.a();
    this.c = paraman.b();
    this.d = paraman.c();
    this.f = paramal;
    this.g = paramLocale;
  }
  
  public an a()
  {
    Object localObject;
    int i;
    if (this.a == null)
    {
      if (this.b == null) {
        break label55;
      }
      localObject = this.b;
      i = this.c;
      if (this.d == null) {
        break label62;
      }
    }
    label55:
    label62:
    for (String str = this.d;; str = b(this.c))
    {
      this.a = new p((ak)localObject, i, str);
      return this.a;
      localObject = ac.d;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    cz.msebera.android.httpclient.o.a.b(paramInt, "Status code");
    this.a = null;
    this.c = paramInt;
    this.d = null;
  }
  
  public void a(ak paramak, int paramInt)
  {
    cz.msebera.android.httpclient.o.a.b(paramInt, "Status code");
    this.a = null;
    this.b = paramak;
    this.c = paramInt;
    this.d = null;
  }
  
  public void a(ak paramak, int paramInt, String paramString)
  {
    cz.msebera.android.httpclient.o.a.b(paramInt, "Status code");
    this.a = null;
    this.b = paramak;
    this.c = paramInt;
    this.d = paramString;
  }
  
  public void a(an paraman)
  {
    this.a = ((an)cz.msebera.android.httpclient.o.a.a(paraman, "Status line"));
    this.b = paraman.a();
    this.c = paraman.b();
    this.d = paraman.c();
  }
  
  public void a(n paramn)
  {
    this.e = paramn;
  }
  
  public void a(String paramString)
  {
    this.a = null;
    this.d = paramString;
  }
  
  public void a(Locale paramLocale)
  {
    this.g = ((Locale)cz.msebera.android.httpclient.o.a.a(paramLocale, "Locale"));
    this.a = null;
  }
  
  public n b()
  {
    return this.e;
  }
  
  protected String b(int paramInt)
  {
    if (this.f != null)
    {
      al localal = this.f;
      if (this.g != null) {}
      for (Locale localLocale = this.g;; localLocale = Locale.getDefault()) {
        return localal.a(paramInt, localLocale);
      }
    }
    return null;
  }
  
  public Locale c()
  {
    return this.g;
  }
  
  public ak getProtocolVersion()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(' ');
    localStringBuilder.append(this.headergroup);
    if (this.e != null)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(this.e);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */