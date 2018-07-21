package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLSocket;
import org.json.JSONObject;

public final class bu
  implements bx
{
  bx.a a = null;
  final Object b = new Object();
  private a c;
  
  @TargetApi(17)
  public bu(bf parambf, URI paramURI, String paramString, int paramInt)
    throws IOException
  {
    int i = parambf.j.b.optInt("positioningPingPongTimeout", 5000);
    this.c = new a(paramURI);
    parambf = this.c;
    parambf.b = 30000L;
    label115:
    String str;
    label140:
    SSLCertificateSocketFactory localSSLCertificateSocketFactory;
    if (parambf.f.d())
    {
      if (parambf.b > 0L) {
        parambf.b();
      }
    }
    else
    {
      this.c.c = i;
      parambf = paramURI.getScheme();
      if ((parambf == null) || (!parambf.startsWith("wss"))) {
        break label235;
      }
      i = 1;
      if (i == 0) {
        break label326;
      }
      str = paramURI.getHost();
      if (paramURI.getPort() == -1) {
        break label241;
      }
      i = paramURI.getPort();
      localSSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(0);
      if ((paramString == null) || (paramInt <= 0)) {
        break label327;
      }
    }
    label235:
    label241:
    label326:
    label327:
    for (parambf = a(localSSLCertificateSocketFactory, str, i, paramString, paramInt);; parambf = null)
    {
      paramURI = parambf;
      if (parambf == null) {
        paramURI = (SSLSocket)localSSLCertificateSocketFactory.createSocket();
      }
      if (Build.VERSION.SDK_INT >= 17) {
        localSSLCertificateSocketFactory.setHostname(paramURI, str);
      }
      for (;;)
      {
        parambf = this.c;
        if (parambf.g != null)
        {
          throw new IllegalStateException("socket has already been set");
          parambf.d.removeMessages(0);
          break;
          i = 0;
          break label115;
          if ("wss".equals(paramURI.getScheme()))
          {
            i = 443;
            break label140;
          }
          i = 80;
          break label140;
          paramURI.getClass().getName();
          try
          {
            paramURI.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramURI, new Object[] { str });
          }
          catch (Exception parambf)
          {
            throw new IllegalStateException(parambf);
          }
        }
      }
      parambf.g = paramURI;
      return;
    }
  }
  
  private static SSLSocket a(SSLCertificateSocketFactory paramSSLCertificateSocketFactory, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    Object localObject = new InetSocketAddress(paramString2, paramInt2);
    try
    {
      localObject = new Socket(new Proxy(Proxy.Type.SOCKS, (SocketAddress)localObject));
      ((Socket)localObject).connect(new InetSocketAddress(paramString1, paramInt1));
      paramSSLCertificateSocketFactory = (SSLSocket)paramSSLCertificateSocketFactory.createSocket((Socket)localObject, paramString2, paramInt2, true);
      return paramSSLCertificateSocketFactory;
    }
    catch (IOException paramSSLCertificateSocketFactory)
    {
      ee.a("IAWire", "IOException when creating proxy socket: " + paramSSLCertificateSocketFactory, new Object[0]);
      return null;
    }
    catch (SecurityException paramSSLCertificateSocketFactory)
    {
      for (;;)
      {
        ee.a("IAWire", "SecurityException when creating proxy socket: " + paramSSLCertificateSocketFactory, new Object[0]);
      }
    }
  }
  
  public final void a()
  {
    a locala = this.c;
    if (locala.h != null) {
      throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }
    locala.h = new Thread(locala);
    locala.h.start();
  }
  
  public final void a(bx.a parama)
  {
    synchronized (this.b)
    {
      this.a = parama;
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    jl localjl = this.c.f;
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }
    jo localjo = localjl.k;
    if (localjl.l == jj.b.a) {}
    for (boolean bool = true;; bool = false)
    {
      localjl.a(localjo.a(paramArrayOfByte, bool));
      return;
    }
  }
  
  public final void b()
  {
    this.c.f.d();
    ??? = this.c;
    if (((jn)???).h != null) {
      ((jn)???).f.a(1000, "", false);
    }
    synchronized (this.b)
    {
      this.a = null;
      this.c = null;
      return;
    }
  }
  
  public final boolean c()
  {
    return (this.c.f.f()) || (this.c.f.e());
  }
  
  final class a
    extends bv
  {
    a(URI paramURI)
    {
      super(new jq());
    }
    
    public final void a() {}
    
    protected final void a(int paramInt)
    {
      super.a(paramInt);
      synchronized (bu.this.b)
      {
        if (bu.this.a != null) {
          bu.this.a.a(paramInt);
        }
        return;
      }
    }
    
    public final void a(int paramInt, String paramString, boolean paramBoolean)
    {
      super.a(paramInt, paramString, paramBoolean);
      synchronized (bu.this.b)
      {
        if (bu.this.a != null)
        {
          bu localbu = bu.this;
          bu.this.a.a(paramInt, paramString, paramBoolean);
          return;
        }
        paramString = bu.this;
      }
    }
    
    public final void a(jj arg1, kf paramkf)
      throws ju
    {
      super.a(???, paramkf);
      synchronized (bu.this.b)
      {
        if (bu.this.a != null) {
          bu.this.a.d();
        }
        return;
      }
    }
    
    public final void a(km arg1)
    {
      super.a(???);
      synchronized (bu.this.b)
      {
        if (bu.this.a != null) {
          bu.this.a.c();
        }
        return;
      }
    }
    
    public final void a(Exception paramException)
    {
      new StringBuilder("onError: ").append(paramException);
    }
    
    public final void a(ByteBuffer paramByteBuffer)
    {
      super.a(paramByteBuffer);
      synchronized (bu.this.b)
      {
        if (bu.this.a != null) {
          bu.this.a.a(paramByteBuffer);
        }
        return;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */