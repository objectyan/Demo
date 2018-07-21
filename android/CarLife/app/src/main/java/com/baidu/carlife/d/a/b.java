package com.baidu.carlife.d.a;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class b
  implements X509TrustManager
{
  private static TrustManager[] a;
  private static final X509Certificate[] b = new X509Certificate[0];
  private static SSLSocketFactory c;
  
  public static void a()
  {
    HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier()
    {
      public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
      {
        return true;
      }
    });
    Object localObject2 = null;
    Object localObject1 = null;
    if (a == null) {
      a = new TrustManager[] { new b() };
    }
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localObject1 = localSSLContext;
      localObject2 = localSSLContext;
      localSSLContext.init(null, a, new SecureRandom());
      localObject1 = localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      for (;;)
      {
        localNoSuchAlgorithmException2.printStackTrace();
      }
    }
    catch (KeyManagementException localKeyManagementException)
    {
      for (;;)
      {
        localKeyManagementException.printStackTrace();
        NoSuchAlgorithmException localNoSuchAlgorithmException1 = localNoSuchAlgorithmException2;
      }
    }
    c = ((SSLContext)localObject1).getSocketFactory();
    HttpsURLConnection.setDefaultSSLSocketFactory(c);
  }
  
  public static SSLSocketFactory b()
  {
    try
    {
      Object localObject = new X509TrustManager()
      {
        public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
          throws CertificateException
        {}
        
        public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
          throws CertificateException
        {}
        
        public X509Certificate[] getAcceptedIssuers()
        {
          return new X509Certificate[0];
        }
      };
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { localObject }, localSecureRandom);
      localObject = localSSLContext.getSocketFactory();
      return (SSLSocketFactory)localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  public boolean a(X509Certificate[] paramArrayOfX509Certificate)
  {
    return true;
  }
  
  public boolean b(X509Certificate[] paramArrayOfX509Certificate)
  {
    return true;
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    throws CertificateException
  {}
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return b;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */