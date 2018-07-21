package com.baidu.mapframework.commonlib.http;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class X509HostnameVerifierWrapper
  implements X509HostnameVerifier
{
  private final X509HostnameVerifier a;
  
  public X509HostnameVerifierWrapper(X509HostnameVerifier paramX509HostnameVerifier)
  {
    this.a = paramX509HostnameVerifier;
  }
  
  public void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {
    if (this.a != null) {
      this.a.verify(paramString, paramX509Certificate);
    }
  }
  
  public void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {
    if (this.a != null) {
      this.a.verify(paramString, paramSSLSocket);
    }
  }
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {
    if (this.a != null) {
      this.a.verify(paramString, paramArrayOfString1, paramArrayOfString2);
    }
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return (this.a != null) && (this.a.verify(paramString, paramSSLSession));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/http/X509HostnameVerifierWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */