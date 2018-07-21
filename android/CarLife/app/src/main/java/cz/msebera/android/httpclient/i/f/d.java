package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.util.Locale;

@NotThreadSafe
class d
  implements cz.msebera.android.httpclient.b.d.c
{
  private final x a;
  private final c b;
  
  public d(x paramx, c paramc)
  {
    this.a = paramx;
    this.b = paramc;
    k.a(paramx, paramc);
  }
  
  public an a()
  {
    return this.a.a();
  }
  
  public void a(int paramInt)
    throws IllegalStateException
  {
    this.a.a(paramInt);
  }
  
  public void a(ak paramak, int paramInt)
  {
    this.a.a(paramak, paramInt);
  }
  
  public void a(ak paramak, int paramInt, String paramString)
  {
    this.a.a(paramak, paramInt, paramString);
  }
  
  public void a(an paraman)
  {
    this.a.a(paraman);
  }
  
  public void a(n paramn)
  {
    this.a.a(paramn);
  }
  
  public void a(String paramString)
    throws IllegalStateException
  {
    this.a.a(paramString);
  }
  
  public void a(Locale paramLocale)
  {
    this.a.a(paramLocale);
  }
  
  public void addHeader(f paramf)
  {
    this.a.addHeader(paramf);
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.a.addHeader(paramString1, paramString2);
  }
  
  public n b()
  {
    return this.a.b();
  }
  
  public Locale c()
  {
    return this.a.c();
  }
  
  public void close()
    throws IOException
  {
    if (this.b != null) {
      this.b.b();
    }
  }
  
  public boolean containsHeader(String paramString)
  {
    return this.a.containsHeader(paramString);
  }
  
  public f[] getAllHeaders()
  {
    return this.a.getAllHeaders();
  }
  
  public f getFirstHeader(String paramString)
  {
    return this.a.getFirstHeader(paramString);
  }
  
  public f[] getHeaders(String paramString)
  {
    return this.a.getHeaders(paramString);
  }
  
  public f getLastHeader(String paramString)
  {
    return this.a.getLastHeader(paramString);
  }
  
  @Deprecated
  public j getParams()
  {
    return this.a.getParams();
  }
  
  public ak getProtocolVersion()
  {
    return this.a.getProtocolVersion();
  }
  
  public i headerIterator()
  {
    return this.a.headerIterator();
  }
  
  public i headerIterator(String paramString)
  {
    return this.a.headerIterator(paramString);
  }
  
  public void removeHeader(f paramf)
  {
    this.a.removeHeader(paramf);
  }
  
  public void removeHeaders(String paramString)
  {
    this.a.removeHeaders(paramString);
  }
  
  public void setHeader(f paramf)
  {
    this.a.setHeader(paramf);
  }
  
  public void setHeader(String paramString1, String paramString2)
  {
    this.a.setHeader(paramString1, paramString2);
  }
  
  public void setHeaders(f[] paramArrayOff)
  {
    this.a.setHeaders(paramArrayOff);
  }
  
  @Deprecated
  public void setParams(j paramj)
  {
    this.a.setParams(paramj);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("HttpResponseProxy{");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */