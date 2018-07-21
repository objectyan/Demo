package com.baidu.tts.loopj;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class MySSLSocketFactory
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext sslContext = SSLContext.getInstance("TLS");
  
  public MySSLSocketFactory(KeyStore paramKeyStore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(paramKeyStore);
    paramKeyStore = new X509TrustManager()
    {
      public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {}
      
      public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
        throws CertificateException
      {}
      
      public X509Certificate[] getAcceptedIssuers()
      {
        return null;
      }
    };
    this.sslContext.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  public static org.apache.http.conn.ssl.SSLSocketFactory getFixedSocketFactory()
  {
    try
    {
      MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(getKeystore());
      return localMySSLSocketFactory;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
  }
  
  public static KeyStore getKeystore()
  {
    try
    {
      localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localKeyStore.load(null, null);
        return localKeyStore;
      }
      catch (Throwable localThrowable2)
      {
        KeyStore localKeyStore;
        for (;;) {}
      }
      localThrowable1 = localThrowable1;
      localKeyStore = null;
    }
    return localKeyStore;
  }
  
  /* Error */
  public static KeyStore getKeystoreOfCA(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 80
    //   4: invokestatic 85	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   7: astore_3
    //   8: new 87	java/io/BufferedInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 90	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: aload_3
    //   20: aload_1
    //   21: invokevirtual 94	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_0
    //   27: aload_1
    //   28: ifnull +9 -> 37
    //   31: aload_1
    //   32: invokevirtual 99	java/io/InputStream:close	()V
    //   35: aload_2
    //   36: astore_0
    //   37: invokestatic 63	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   40: astore_1
    //   41: aload_1
    //   42: invokestatic 66	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   45: astore_1
    //   46: aload_1
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 70	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   52: aload_1
    //   53: ldc 101
    //   55: aload_0
    //   56: invokevirtual 105	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   66: aload_2
    //   67: astore_0
    //   68: goto -31 -> 37
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 107	java/security/cert/CertificateException:printStackTrace	()V
    //   80: aload_1
    //   81: ifnull +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 99	java/io/InputStream:close	()V
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -53 -> 37
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   98: aconst_null
    //   99: astore_0
    //   100: goto -63 -> 37
    //   103: astore_0
    //   104: aload_2
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 99	java/io/InputStream:close	()V
    //   114: aload_0
    //   115: athrow
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   121: goto -7 -> 114
    //   124: astore_1
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   131: aload_0
    //   132: areturn
    //   133: astore_2
    //   134: aload_1
    //   135: astore_0
    //   136: aload_2
    //   137: astore_1
    //   138: goto -11 -> 127
    //   141: astore_2
    //   142: aload_0
    //   143: astore_1
    //   144: aload_2
    //   145: astore_0
    //   146: goto -40 -> 106
    //   149: astore_2
    //   150: goto -76 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramInputStream	java.io.InputStream
    //   16	95	1	localObject1	Object
    //   116	2	1	localIOException	IOException
    //   124	11	1	localException1	Exception
    //   137	7	1	localObject2	Object
    //   1	66	2	localCertificate	java.security.cert.Certificate
    //   71	34	2	localCertificateException1	CertificateException
    //   133	4	2	localException2	Exception
    //   141	4	2	localObject3	Object
    //   149	1	2	localCertificateException2	CertificateException
    //   7	13	3	localCertificateFactory	java.security.cert.CertificateFactory
    // Exception table:
    //   from	to	target	type
    //   31	35	61	java/io/IOException
    //   2	17	71	java/security/cert/CertificateException
    //   84	88	93	java/io/IOException
    //   2	17	103	finally
    //   110	114	116	java/io/IOException
    //   41	46	124	java/lang/Exception
    //   46	59	133	java/lang/Exception
    //   19	25	141	finally
    //   76	80	141	finally
    //   19	25	149	java/security/cert/CertificateException
  }
  
  public static DefaultHttpClient getNewHttpClient(KeyStore paramKeyStore)
  {
    try
    {
      Object localObject = new MySSLSocketFactory(paramKeyStore);
      paramKeyStore = new SchemeRegistry();
      paramKeyStore.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      paramKeyStore.register(new Scheme("https", (SocketFactory)localObject, 443));
      localObject = new BasicHttpParams();
      HttpProtocolParams.setVersion((HttpParams)localObject, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset((HttpParams)localObject, "UTF-8");
      paramKeyStore = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject, paramKeyStore), (HttpParams)localObject);
      return paramKeyStore;
    }
    catch (Exception paramKeyStore) {}
    return new DefaultHttpClient();
  }
  
  public Socket createSocket()
    throws IOException
  {
    return this.sslContext.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return this.sslContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public void fixHttpsURLConnection()
  {
    HttpsURLConnection.setDefaultSSLSocketFactory(this.sslContext.getSocketFactory());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/MySSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */