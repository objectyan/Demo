package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.net.URI;

@NotThreadSafe
public class k
  extends f
{
  public static final String a = "PATCH";
  
  public k() {}
  
  public k(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public k(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "PATCH";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */