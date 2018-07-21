package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.t;

@NotThreadSafe
public abstract class a
  implements t
{
  protected s headergroup = new s();
  @Deprecated
  protected j params;
  
  protected a()
  {
    this(null);
  }
  
  @Deprecated
  protected a(j paramj)
  {
    this.params = paramj;
  }
  
  public void addHeader(f paramf)
  {
    this.headergroup.a(paramf);
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    cz.msebera.android.httpclient.o.a.a(paramString1, "Header name");
    this.headergroup.a(new b(paramString1, paramString2));
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
  
  @Deprecated
  public j getParams()
  {
    if (this.params == null) {
      this.params = new cz.msebera.android.httpclient.l.b();
    }
    return this.params;
  }
  
  public i headerIterator()
  {
    return this.headergroup.c();
  }
  
  public i headerIterator(String paramString)
  {
    return this.headergroup.f(paramString);
  }
  
  public void removeHeader(f paramf)
  {
    this.headergroup.b(paramf);
  }
  
  public void removeHeaders(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      i locali = this.headergroup.c();
      while (locali.hasNext()) {
        if (paramString.equalsIgnoreCase(locali.a().c())) {
          locali.remove();
        }
      }
    }
  }
  
  public void setHeader(f paramf)
  {
    this.headergroup.c(paramf);
  }
  
  public void setHeader(String paramString1, String paramString2)
  {
    cz.msebera.android.httpclient.o.a.a(paramString1, "Header name");
    this.headergroup.c(new b(paramString1, paramString2));
  }
  
  public void setHeaders(f[] paramArrayOff)
  {
    this.headergroup.a(paramArrayOff);
  }
  
  @Deprecated
  public void setParams(j paramj)
  {
    this.params = ((j)cz.msebera.android.httpclient.o.a.a(paramj, "HTTP parameters"));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */