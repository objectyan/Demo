package cz.msebera.android.httpclient.e.e;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

@ThreadSafe
public class f
  implements cz.msebera.android.httpclient.e.d.b
{
  public static final String a = "TLS";
  public static final String b = "SSL";
  public static final String c = "SSLv2";
  public static final n d = new b();
  public static final n e = new c();
  public static final n f = new k();
  private final SSLSocketFactory g;
  private final n h;
  private final String[] i;
  private final String[] j;
  
  public f(SSLContext paramSSLContext)
  {
    this(paramSSLContext, e);
  }
  
  public f(SSLContext paramSSLContext, n paramn)
  {
    this(((SSLContext)a.a(paramSSLContext, "SSL context")).getSocketFactory(), null, null, paramn);
  }
  
  public f(SSLContext paramSSLContext, String[] paramArrayOfString1, String[] paramArrayOfString2, n paramn)
  {
    this(((SSLContext)a.a(paramSSLContext, "SSL context")).getSocketFactory(), paramArrayOfString1, paramArrayOfString2, paramn);
  }
  
  public f(SSLSocketFactory paramSSLSocketFactory, n paramn)
  {
    this(paramSSLSocketFactory, null, null, paramn);
  }
  
  public f(SSLSocketFactory paramSSLSocketFactory, String[] paramArrayOfString1, String[] paramArrayOfString2, n paramn)
  {
    this.g = ((SSLSocketFactory)a.a(paramSSLSocketFactory, "SSL socket factory"));
    this.i = paramArrayOfString1;
    this.j = paramArrayOfString2;
    if (paramn != null) {}
    for (;;)
    {
      this.h = paramn;
      return;
      paramn = e;
    }
  }
  
  public static f a()
    throws i
  {
    return new f(h.a(), e);
  }
  
  private void a(SSLSocket paramSSLSocket, String paramString)
    throws IOException
  {
    try
    {
      this.h.a(paramString, paramSSLSocket);
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
  
  private static String[] a(String paramString)
  {
    if (cz.msebera.android.httpclient.o.k.b(paramString)) {
      return null;
    }
    return paramString.split(" *, *");
  }
  
  public static f b()
    throws i
  {
    return new f((SSLSocketFactory)SSLSocketFactory.getDefault(), a(System.getProperty("https.protocols")), a(System.getProperty("https.cipherSuites")), e);
  }
  
  protected void a(SSLSocket paramSSLSocket)
    throws IOException
  {}
  
  n c()
  {
    return this.h;
  }
  
  public Socket connectSocket(int paramInt, Socket paramSocket, r paramr, InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, g paramg)
    throws IOException
  {
    a.a(paramr, "HTTP host");
    a.a(paramInetSocketAddress1, "Remote address");
    if (paramSocket != null) {}
    for (;;)
    {
      if (paramInetSocketAddress2 != null) {
        paramSocket.bind(paramInetSocketAddress2);
      }
      if (paramInt > 0) {}
      try
      {
        if (paramSocket.getSoTimeout() == 0) {
          paramSocket.setSoTimeout(paramInt);
        }
        paramSocket.connect(paramInetSocketAddress1, paramInt);
        if (!(paramSocket instanceof SSLSocket)) {
          break;
        }
        paramInetSocketAddress1 = (SSLSocket)paramSocket;
        paramInetSocketAddress1.startHandshake();
        a(paramInetSocketAddress1, paramr.a());
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
  
  public Socket createLayeredSocket(Socket paramSocket, String paramString, int paramInt, g paramg)
    throws IOException
  {
    paramSocket = (SSLSocket)this.g.createSocket(paramSocket, paramString, paramInt, true);
    if (this.i != null) {
      paramSocket.setEnabledProtocols(this.i);
    }
    for (;;)
    {
      if (this.j != null) {
        paramSocket.setEnabledCipherSuites(this.j);
      }
      a(paramSocket);
      paramSocket.startHandshake();
      a(paramSocket, paramString);
      return paramSocket;
      paramg = paramSocket.getSupportedProtocols();
      ArrayList localArrayList = new ArrayList(paramg.length);
      int k = paramg.length;
      paramInt = 0;
      while (paramInt < k)
      {
        Object localObject = paramg[paramInt];
        if (!((String)localObject).startsWith("SSL")) {
          localArrayList.add(localObject);
        }
        paramInt += 1;
      }
      paramSocket.setEnabledProtocols((String[])localArrayList.toArray(new String[localArrayList.size()]));
    }
  }
  
  public Socket createSocket(g paramg)
    throws IOException
  {
    return SocketFactory.getDefault().createSocket();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */