package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.net.URI;

@NotThreadSafe
public class p
  extends n
{
  public static final String a = "TRACE";
  
  public p() {}
  
  public p(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public p(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "TRACE";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */