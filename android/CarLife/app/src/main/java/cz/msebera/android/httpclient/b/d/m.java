package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.net.URI;

@NotThreadSafe
public class m
  extends f
{
  public static final String a = "PUT";
  
  public m() {}
  
  public m(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public m(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "PUT";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */