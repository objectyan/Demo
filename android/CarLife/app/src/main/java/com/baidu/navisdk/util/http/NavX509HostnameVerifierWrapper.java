package com.baidu.navisdk.util.http;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class NavX509HostnameVerifierWrapper
  implements X509HostnameVerifier
{
  private final X509HostnameVerifier verifier;
  
  public NavX509HostnameVerifierWrapper(X509HostnameVerifier paramX509HostnameVerifier)
  {
    this.verifier = paramX509HostnameVerifier;
  }
  
  public void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {
    if (this.verifier != null) {
      this.verifier.verify(paramString, paramX509Certificate);
    }
  }
  
  public void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {
    if (this.verifier != null) {
      this.verifier.verify(paramString, paramSSLSocket);
    }
  }
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {
    if (this.verifier != null) {
      this.verifier.verify(paramString, paramArrayOfString1, paramArrayOfString2);
    }
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return (this.verifier != null) && (this.verifier.verify(paramString, paramSSLSession));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/NavX509HostnameVerifierWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */