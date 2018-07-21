package com.loopj.android.http;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.e.c.e;
import cz.msebera.android.httpclient.e.c.f;
import cz.msebera.android.httpclient.i.b.s;
import cz.msebera.android.httpclient.i.c.a.h;
import cz.msebera.android.httpclient.l.b;
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
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MySSLSocketFactory
  extends cz.msebera.android.httpclient.e.e.j
{
  final SSLContext sslContext = SSLContext.getInstance("TLS");
  
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
  
  public static cz.msebera.android.httpclient.e.e.j getFixedSocketFactory()
  {
    try
    {
      MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(getKeystore());
      localMySSLSocketFactory.setHostnameVerifier(cz.msebera.android.httpclient.e.e.j.ALLOW_ALL_HOSTNAME_VERIFIER);
      return localMySSLSocketFactory;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return cz.msebera.android.httpclient.e.e.j.getSocketFactory();
  }
  
  public static KeyStore getKeystore()
  {
    Object localObject = null;
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localObject = localKeyStore;
      localKeyStore.load(null, null);
      return localKeyStore;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return (KeyStore)localObject;
  }
  
  /* Error */
  public static KeyStore getKeystoreOfCA(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_3
    //   7: aload_2
    //   8: astore_1
    //   9: ldc 88
    //   11: invokestatic 93	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   14: astore 5
    //   16: aload_2
    //   17: astore_1
    //   18: new 95	java/io/BufferedInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_0
    //   27: aload 5
    //   29: aload_0
    //   30: invokevirtual 102	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   33: astore_1
    //   34: aload_0
    //   35: ifnull +7 -> 42
    //   38: aload_0
    //   39: invokevirtual 107	java/io/InputStream:close	()V
    //   42: invokestatic 71	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   45: astore_2
    //   46: aconst_null
    //   47: astore_0
    //   48: aload_2
    //   49: invokestatic 74	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   52: astore_2
    //   53: aload_2
    //   54: astore_0
    //   55: aload_2
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 78	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   61: aload_2
    //   62: astore_0
    //   63: aload_2
    //   64: ldc 109
    //   66: aload_1
    //   67: invokevirtual 113	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   70: aload_2
    //   71: areturn
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   77: goto -35 -> 42
    //   80: astore_2
    //   81: aload 4
    //   83: astore_0
    //   84: aload_0
    //   85: astore_1
    //   86: aload_2
    //   87: invokevirtual 115	java/security/cert/CertificateException:printStackTrace	()V
    //   90: aload_3
    //   91: astore_1
    //   92: aload_0
    //   93: ifnull -51 -> 42
    //   96: aload_0
    //   97: invokevirtual 107	java/io/InputStream:close	()V
    //   100: aload_3
    //   101: astore_1
    //   102: goto -60 -> 42
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   110: aload_3
    //   111: astore_1
    //   112: goto -70 -> 42
    //   115: astore_0
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 107	java/io/InputStream:close	()V
    //   124: aload_0
    //   125: athrow
    //   126: astore_1
    //   127: aload_1
    //   128: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   131: goto -7 -> 124
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   139: aload_0
    //   140: areturn
    //   141: astore_2
    //   142: aload_0
    //   143: astore_1
    //   144: aload_2
    //   145: astore_0
    //   146: goto -30 -> 116
    //   149: astore_2
    //   150: goto -66 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramInputStream	java.io.InputStream
    //   8	113	1	localObject1	Object
    //   126	2	1	localIOException	IOException
    //   134	2	1	localException	Exception
    //   143	1	1	localInputStream	java.io.InputStream
    //   1	70	2	localObject2	Object
    //   80	7	2	localCertificateException1	CertificateException
    //   141	4	2	localObject3	Object
    //   149	1	2	localCertificateException2	CertificateException
    //   6	105	3	localObject4	Object
    //   3	79	4	localObject5	Object
    //   14	14	5	localCertificateFactory	java.security.cert.CertificateFactory
    // Exception table:
    //   from	to	target	type
    //   38	42	72	java/io/IOException
    //   9	16	80	java/security/cert/CertificateException
    //   18	27	80	java/security/cert/CertificateException
    //   96	100	105	java/io/IOException
    //   9	16	115	finally
    //   18	27	115	finally
    //   86	90	115	finally
    //   120	124	126	java/io/IOException
    //   48	53	134	java/lang/Exception
    //   55	61	134	java/lang/Exception
    //   63	70	134	java/lang/Exception
    //   27	34	141	finally
    //   27	34	149	java/security/cert/CertificateException
  }
  
  public static s getNewHttpClient(KeyStore paramKeyStore)
  {
    try
    {
      Object localObject = new MySSLSocketFactory(paramKeyStore);
      paramKeyStore = new cz.msebera.android.httpclient.e.c.j();
      paramKeyStore.a(new f("http", e.a(), 80));
      paramKeyStore.a(new f("https", (cz.msebera.android.httpclient.e.c.m)localObject, 443));
      localObject = new b();
      cz.msebera.android.httpclient.l.m.a((cz.msebera.android.httpclient.l.j)localObject, ac.d);
      cz.msebera.android.httpclient.l.m.b((cz.msebera.android.httpclient.l.j)localObject, "UTF-8");
      paramKeyStore = new s(new h((cz.msebera.android.httpclient.l.j)localObject, paramKeyStore), (cz.msebera.android.httpclient.l.j)localObject);
      return paramKeyStore;
    }
    catch (Exception paramKeyStore) {}
    return new s();
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/MySSLSocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */