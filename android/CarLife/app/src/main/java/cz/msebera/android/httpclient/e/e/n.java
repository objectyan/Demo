package cz.msebera.android.httpclient.e.e;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;

public abstract interface n
  extends HostnameVerifier
{
  public abstract void a(String paramString, X509Certificate paramX509Certificate)
    throws SSLException;
  
  public abstract void a(String paramString, SSLSocket paramSSLSocket)
    throws IOException;
  
  public abstract void a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/e/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */