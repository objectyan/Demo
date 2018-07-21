package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.k.o;
import cz.msebera.android.httpclient.k.s;
import cz.msebera.android.httpclient.l.m;
import cz.msebera.android.httpclient.u;
import java.net.URI;
import java.net.URISyntaxException;

@Deprecated
@NotThreadSafe
public class as
  extends cz.msebera.android.httpclient.k.a
  implements q
{
  private final u a;
  private URI b;
  private String c;
  private ak d;
  private int e;
  
  public as(u paramu)
    throws aj
  {
    cz.msebera.android.httpclient.o.a.a(paramu, "HTTP request");
    this.a = paramu;
    setParams(paramu.getParams());
    setHeaders(paramu.getAllHeaders());
    if ((paramu instanceof q))
    {
      this.b = ((q)paramu).getURI();
      this.c = ((q)paramu).getMethod();
      this.d = null;
    }
    for (;;)
    {
      this.e = 0;
      return;
      am localam = paramu.getRequestLine();
      try
      {
        this.b = new URI(localam.c());
        this.c = localam.a();
        this.d = paramu.getProtocolVersion();
      }
      catch (URISyntaxException paramu)
      {
        throw new aj("Invalid request URI: " + localam.c(), paramu);
      }
    }
  }
  
  public void a(ak paramak)
  {
    this.d = paramak;
  }
  
  public void a(String paramString)
  {
    cz.msebera.android.httpclient.o.a.a(paramString, "Method name");
    this.c = paramString;
  }
  
  public void a(URI paramURI)
  {
    this.b = paramURI;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void abort()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  }
  
  public void b()
  {
    this.headergroup.a();
    setHeaders(this.a.getAllHeaders());
  }
  
  public u c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public void e()
  {
    this.e += 1;
  }
  
  public String getMethod()
  {
    return this.c;
  }
  
  public ak getProtocolVersion()
  {
    if (this.d == null) {
      this.d = m.c(getParams());
    }
    return this.d;
  }
  
  public am getRequestLine()
  {
    String str3 = getMethod();
    ak localak = getProtocolVersion();
    String str1 = null;
    if (this.b != null) {
      str1 = this.b.toASCIIString();
    }
    String str2;
    if (str1 != null)
    {
      str2 = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      str2 = "/";
    }
    return new o(str3, str2, localak);
  }
  
  public URI getURI()
  {
    return this.b;
  }
  
  public boolean isAborted()
  {
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */