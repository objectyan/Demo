package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.net.URI;

@NotThreadSafe
public class i
  extends n
{
  public static final String a = "HEAD";
  
  public i() {}
  
  public i(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public i(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "HEAD";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */