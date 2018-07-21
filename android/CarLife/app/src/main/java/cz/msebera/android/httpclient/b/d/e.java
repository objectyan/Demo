package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.net.URI;

@NotThreadSafe
public class e
  extends n
{
  public static final String a = "DELETE";
  
  public e() {}
  
  public e(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public e(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "DELETE";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */