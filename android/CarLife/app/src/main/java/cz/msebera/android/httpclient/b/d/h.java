package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.net.URI;

@NotThreadSafe
public class h
  extends n
{
  public static final String a = "GET";
  
  public h() {}
  
  public h(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public h(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "GET";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */