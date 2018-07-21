package cz.msebera.android.httpclient.e.e;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

@Deprecated
@ThreadSafe
public class j
  implements cz.msebera.android.httpclient.e.c.b, cz.msebera.android.httpclient.e.c.c, cz.msebera.android.httpclient.e.c.g, cz.msebera.android.httpclient.e.d.b
{
  public static final n ALLOW_ALL_HOSTNAME_VERIFIER = new b();
  public static final n BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new c();
  public static final String SSL = "SSL";
  public static final String SSLV2 = "SSLv2";
  public static final n STRICT_HOSTNAME_VERIFIER = new k();
  public static final String TLS = "TLS";
  private volatile n hostnameVerifier;
  private final cz.msebera.android.httpclient.e.c.a nameResolver;
  private final SSLSocketFactory socketfactory;
  private final String[] supportedCipherSuites;
  private final String[] supportedProtocols;
  
  public j(m paramm)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(h.c().a(null, paramm).c(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public j(m paramm, n paramn)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(h.c().a(null, paramm).c(), paramn);
  }
  
  public j(String paramString1, KeyStore paramKeyStore1, String paramString2, KeyStore paramKeyStore2, SecureRandom paramSecureRandom, cz.msebera.android.httpclient.e.c.a parama)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {}
  
  public j(String paramString1, KeyStore paramKeyStore1, String paramString2, KeyStore paramKeyStore2, SecureRandom paramSecureRandom, m paramm, n paramn)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {}
  
  public j(String paramString1, KeyStore paramKeyStore1, String paramString2, KeyStore paramKeyStore2, SecureRandom paramSecureRandom, n paramn)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {}
  
  public j(KeyStore paramKeyStore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    this(h.c().a(paramKeyStore).c(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public j(KeyStore paramKeyStore, String paramString)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {}
  
  public j(KeyStore paramKeyStore1, String paramString, KeyStore paramKeyStore2)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {}
  
  public j(SSLContext paramSSLContext)
  {
    this(paramSSLContext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public j(SSLContext paramSSLContext, cz.msebera.android.httpclient.e.c.a parama)
  {
    this.socketfactory = paramSSLContext.getSocketFactory();
    this.hostnameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    this.nameResolver = parama;
    this.supportedProtocols = null;
    this.supportedCipherSuites = null;
  }
  
  public j(SSLContext paramSSLContext, n paramn)
  {
    this(((SSLContext)cz.msebera.android.httpclient.o.a.a(paramSSLContext, "SSL context")).getSocketFactory(), null, null, paramn);
  }
  
  public j(SSLContext paramSSLContext, String[] paramArrayOfString1, String[] paramArrayOfString2, n paramn)
  {
    this(((SSLContext)cz.msebera.android.httpclient.o.a.a(paramSSLContext, "SSL context")).getSocketFactory(), paramArrayOfString1, paramArrayOfString2, paramn);
  }
  
  public j(SSLSocketFactory paramSSLSocketFactory, n paramn)
  {
    this(paramSSLSocketFactory, null, null, paramn);
  }
  
  public j(SSLSocketFactory paramSSLSocketFactory, String[] paramArrayOfString1, String[] paramArrayOfString2, n paramn)
  {
    this.socketfactory = ((SSLSocketFactory)cz.msebera.android.httpclient.o.a.a(paramSSLSocketFactory, "SSL socket factory"));
    this.supportedProtocols = paramArrayOfString1;
    this.supportedCipherSuites = paramArrayOfString2;
    if (paramn != null) {}
    for (;;)
    {
      this.hostnameVerifier = paramn;
      this.nameResolver = null;
      return;
      paramn = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    }
  }
  
  public static j getSocketFactory()
    throws i
  {
    return new j(h.a(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  public static j getSystemSocketFactory()
    throws i
  {
    return new j((SSLSocketFactory)SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  }
  
  private void internalPrepareSocket(SSLSocket paramSSLSocket)
    throws IOException
  {
    if (this.supportedProtocols != null) {
      paramSSLSocket.setEnabledProtocols(this.supportedProtocols);
    }
    if (this.supportedCipherSuites != null) {
      paramSSLSocket.setEnabledCipherSuites(this.supportedCipherSuites);
    }
    prepareSocket(paramSSLSocket);
  }
  
  private static String[] split(String paramString)
  {
    if (cz.msebera.android.httpclient.o.k.b(paramString)) {
      return null;
    }
    return paramString.split(" *, *");
  }
  
  private void verifyHostname(SSLSocket paramSSLSocket, String paramString)
    throws IOException
  {
    try
    {
      this.hostnameVerifier.a(paramString, paramSSLSocket);
      return;
    }
    catch (IOException paramString) {}
    try
    {
      paramSSLSocket.close();
      throw paramString;
    }
    catch (Exception paramSSLSocket)
    {
      for (;;) {}
    }
  }
  
  public Socket connectSocket(int paramInt, Socket paramSocket, cz.msebera.android.httpclient.r paramr, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramr, "HTTP host");
    cz.msebera.android.httpclient.o.a.a(paramInetSocketAddress1, "Remote address");
    if (paramSocket != null) {}
    for (;;)
    {
      if (paramInetSocketAddress2 != null) {
        paramSocket.bind(paramInetSocketAddress2);
      }
      try
      {
        paramSocket.connect(paramInetSocketAddress1, paramInt);
        if (!(paramSocket instanceof SSLSocket)) {
          break;
        }
        paramInetSocketAddress1 = (SSLSocket)paramSocket;
        paramInetSocketAddress1.startHandshake();
        verifyHostname(paramInetSocketAddress1, paramr.a());
        return paramSocket;
      }
      catch (IOException paramr) {}
      paramSocket = createSocket(paramg);
    }
    try
    {
      paramSocket.close();
      throw paramr;
      return createLayeredSocket(paramSocket, paramr.a(), paramInetSocketAddress1.getPort(), paramg);
    }
    catch (IOException paramSocket)
    {
      for (;;) {}
    }
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, cz.msebera.android.httpclient.l.j paramj)
    throws IOException, UnknownHostException, cz.msebera.android.httpclient.e.g
  {
    InetAddress localInetAddress;
    InetSocketAddress localInetSocketAddress;
    if (this.nameResolver != null)
    {
      localInetAddress = this.nameResolver.a(paramString);
      localInetSocketAddress = null;
      if ((paramInetAddress != null) || (paramInt2 > 0)) {
        if (paramInt2 <= 0) {
          break label88;
        }
      }
    }
    for (;;)
    {
      localInetSocketAddress = new InetSocketAddress(paramInetAddress, paramInt2);
      return connectSocket(paramSocket, new cz.msebera.android.httpclient.e.r(new cz.msebera.android.httpclient.r(paramString, paramInt1), localInetAddress, paramInt1), localInetSocketAddress, paramj);
      localInetAddress = InetAddress.getByName(paramString);
      break;
      label88:
      paramInt2 = 0;
    }
  }
  
  public Socket connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, cz.msebera.android.httpclient.l.j paramj)
    throws IOException, UnknownHostException, cz.msebera.android.httpclient.e.g
  {
    cz.msebera.android.httpclient.o.a.a(paramInetSocketAddress1, "Remote address");
    cz.msebera.android.httpclient.o.a.a(paramj, "HTTP parameters");
    if ((paramInetSocketAddress1 instanceof cz.msebera.android.httpclient.e.r)) {}
    for (cz.msebera.android.httpclient.r localr = ((cz.msebera.android.httpclient.e.r)paramInetSocketAddress1).a();; localr = new cz.msebera.android.httpclient.r(paramInetSocketAddress1.getHostName(), paramInetSocketAddress1.getPort(), "https"))
    {
      int i = cz.msebera.android.httpclient.l.h.a(paramj);
      int j = cz.msebera.android.httpclient.l.h.f(paramj);
      paramSocket.setSoTimeout(i);
      return connectSocket(j, paramSocket, localr, paramInetSocketAddress1, paramInetSocketAddress2, null);
    }
  }
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, cz.msebera.android.httpclient.l.j paramj)
    throws IOException, UnknownHostException
  {
    return createLayeredSocket(paramSocket, paramString, paramInt, (cz.msebera.android.httpclient.n.g)null);
  }
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    paramSocket = (SSLSocket)this.socketfactory.createSocket(paramSocket, paramString, paramInt, true);
    internalPrepareSocket(paramSocket);
    paramSocket.startHandshake();
    verifyHostname(paramSocket, paramString);
    return paramSocket;
  }
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return createLayeredSocket(paramSocket, paramString, paramInt, (cz.msebera.android.httpclient.n.g)null);
  }
  
  public Socket createSocket()
    throws IOException
  {
    return createSocket((cz.msebera.android.httpclient.n.g)null);
  }
  
  public Socket createSocket(cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    return createSocket((cz.msebera.android.httpclient.n.g)null);
  }
  
  public Socket createSocket(cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    paramg = (SSLSocket)this.socketfactory.createSocket();
    internalPrepareSocket(paramg);
    return paramg;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return createLayeredSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public n getHostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public boolean isSecure(Socket paramSocket)
    throws IllegalArgumentException
  {
    cz.msebera.android.httpclient.o.a.a(paramSocket, "Socket");
    cz.msebera.android.httpclient.o.b.a(paramSocket instanceof SSLSocket, "Socket not created by this factory");
    if (!paramSocket.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "Socket is closed");
      return true;
    }
  }
  
  protected void prepareSocket(SSLSocket paramSSLSocket)
    throws IOException
  {}
  
  public void setHostnameVerifier(n paramn)
  {
    cz.msebera.android.httpclient.o.a.a(paramn, "Hostname verifier");
    this.hostnameVerifier = paramn;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */