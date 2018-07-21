package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.k.a;
import cz.msebera.android.httpclient.k.p;
import cz.msebera.android.httpclient.k.s;
import cz.msebera.android.httpclient.l.b;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.x;
import java.util.Locale;

@Immutable
final class ai
  extends a
  implements x
{
  private final an a = new p(ac.d, 501, "");
  private final ak b = ac.d;
  
  public an a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
    throws IllegalStateException
  {}
  
  public void a(ak paramak, int paramInt) {}
  
  public void a(ak paramak, int paramInt, String paramString) {}
  
  public void a(an paraman) {}
  
  public void a(n paramn) {}
  
  public void a(String paramString)
    throws IllegalStateException
  {}
  
  public void a(Locale paramLocale) {}
  
  public void addHeader(f paramf) {}
  
  public void addHeader(String paramString1, String paramString2) {}
  
  public n b()
  {
    return null;
  }
  
  public Locale c()
  {
    return null;
  }
  
  public boolean containsHeader(String paramString)
  {
    return this.headergroup.e(paramString);
  }
  
  public f[] getAllHeaders()
  {
    return this.headergroup.b();
  }
  
  public f getFirstHeader(String paramString)
  {
    return this.headergroup.c(paramString);
  }
  
  public f[] getHeaders(String paramString)
  {
    return this.headergroup.b(paramString);
  }
  
  public f getLastHeader(String paramString)
  {
    return this.headergroup.d(paramString);
  }
  
  public j getParams()
  {
    if (this.params == null) {
      this.params = new b();
    }
    return this.params;
  }
  
  public ak getProtocolVersion()
  {
    return this.b;
  }
  
  public i headerIterator()
  {
    return this.headergroup.c();
  }
  
  public i headerIterator(String paramString)
  {
    return this.headergroup.f(paramString);
  }
  
  public void removeHeader(f paramf) {}
  
  public void removeHeaders(String paramString) {}
  
  public void setHeader(f paramf) {}
  
  public void setHeader(String paramString1, String paramString2) {}
  
  public void setHeaders(f[] paramArrayOff) {}
  
  public void setParams(j paramj) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */