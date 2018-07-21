package cz.msebera.android.httpclient.e.e;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

@Immutable
public class h
{
  public static SSLContext a()
    throws i
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, null, null);
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new i(localNoSuchAlgorithmException.getMessage(), localNoSuchAlgorithmException);
    }
    catch (KeyManagementException localKeyManagementException)
    {
      throw new i(localKeyManagementException.getMessage(), localKeyManagementException);
    }
  }
  
  public static SSLContext b()
    throws i
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("Default");
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return a();
  }
  
  public static g c()
  {
    return new g();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */