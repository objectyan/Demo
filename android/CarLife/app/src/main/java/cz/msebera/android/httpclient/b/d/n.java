package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.b.c;
import cz.msebera.android.httpclient.k.o;
import cz.msebera.android.httpclient.l.m;
import java.net.URI;

@NotThreadSafe
public abstract class n
  extends b
  implements d, q
{
  private c config;
  private URI uri;
  private ak version;
  
  public c getConfig()
  {
    return this.config;
  }
  
  public abstract String getMethod();
  
  public ak getProtocolVersion()
  {
    if (this.version != null) {
      return this.version;
    }
    return m.c(getParams());
  }
  
  public am getRequestLine()
  {
    String str2 = getMethod();
    ak localak = getProtocolVersion();
    Object localObject = getURI();
    String str1 = null;
    if (localObject != null) {
      str1 = ((URI)localObject).toASCIIString();
    }
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      localObject = "/";
    }
    return new o(str2, (String)localObject, localak);
  }
  
  public URI getURI()
  {
    return this.uri;
  }
  
  public void releaseConnection()
  {
    reset();
  }
  
  public void setConfig(c paramc)
  {
    this.config = paramc;
  }
  
  public void setProtocolVersion(ak paramak)
  {
    this.version = paramak;
  }
  
  public void setURI(URI paramURI)
  {
    this.uri = paramURI;
  }
  
  public void started() {}
  
  public String toString()
  {
    return getMethod() + " " + getURI() + " " + getProtocolVersion();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */