package com.baidu.navisdk.util.http;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class NavDNSProxyCompatX509HostnameVerifier
  extends NavX509HostnameVerifierWrapper
{
  public NavDNSProxyCompatX509HostnameVerifier(X509HostnameVerifier paramX509HostnameVerifier)
  {
    super(paramX509HostnameVerifier);
  }
  
  public void verify(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {
    Object localObject = HttpRequestManager.getInstance().getDomains(paramString);
    if ((localObject != null) && (((Set)localObject).size() > 0)) {
      paramString = ((Set)localObject).iterator();
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        super.verify((String)localObject, paramX509Certificate);
        continue;
        super.verify(paramString, paramX509Certificate);
      }
    }
  }
  
  public void verify(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {
    Object localObject = HttpRequestManager.getInstance().getDomains(paramString);
    if ((localObject != null) && (((Set)localObject).size() > 0)) {
      paramString = ((Set)localObject).iterator();
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        super.verify((String)localObject, paramSSLSocket);
        continue;
        super.verify(paramString, paramSSLSocket);
      }
    }
  }
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SSLException
  {
    Object localObject = HttpRequestManager.getInstance().getDomains(paramString);
    if ((localObject != null) && (((Set)localObject).size() > 0)) {
      paramString = ((Set)localObject).iterator();
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        super.verify((String)localObject, paramArrayOfString1, paramArrayOfString2);
        continue;
        super.verify(paramString, paramArrayOfString1, paramArrayOfString2);
      }
    }
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    Object localObject = HttpRequestManager.getInstance().getDomains(paramString);
    if ((localObject != null) && (((Set)localObject).size() > 0))
    {
      paramString = ((Set)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if ((localObject != null) && (!((String)localObject).equals("")) && (!super.verify((String)localObject, paramSSLSession))) {
          return false;
        }
      }
      return true;
    }
    return super.verify(paramString, paramSSLSession);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/NavDNSProxyCompatX509HostnameVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */