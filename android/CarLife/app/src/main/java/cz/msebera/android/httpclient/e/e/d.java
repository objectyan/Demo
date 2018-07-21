package cz.msebera.android.httpclient.e.e;

import cz.msebera.android.httpclient.o.a;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public final class d
{
  private final String a;
  private final X509Certificate[] b;
  
  public d(String paramString, X509Certificate[] paramArrayOfX509Certificate)
  {
    this.a = ((String)a.a(paramString, "Private key type"));
    this.b = paramArrayOfX509Certificate;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public X509Certificate[] b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return this.a + ':' + Arrays.toString(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */