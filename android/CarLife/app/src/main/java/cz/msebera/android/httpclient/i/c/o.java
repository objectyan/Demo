package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.d.c;
import cz.msebera.android.httpclient.j.d;
import cz.msebera.android.httpclient.j.f;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@NotThreadSafe
public class o
  extends cz.msebera.android.httpclient.i.e
  implements cz.msebera.android.httpclient.e.u, g
{
  private final String a;
  private final Map<String, Object> b;
  private volatile boolean c;
  
  public o(String paramString, int paramInt)
  {
    this(paramString, paramInt, paramInt, null, null, null, null, null, null, null);
  }
  
  public o(String paramString, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, CharsetEncoder paramCharsetEncoder, c paramc, cz.msebera.android.httpclient.g.e parame1, cz.msebera.android.httpclient.g.e parame2, f<cz.msebera.android.httpclient.u> paramf, d<x> paramd)
  {
    super(paramInt1, paramInt2, paramCharsetDecoder, paramCharsetEncoder, paramc, parame1, parame2, paramf, paramd);
    this.a = paramString;
    this.b = new ConcurrentHashMap();
  }
  
  public Object a(String paramString)
  {
    return this.b.get(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.b.put(paramString, paramObject);
  }
  
  public void a(Socket paramSocket)
    throws IOException
  {
    if (this.c)
    {
      paramSocket.close();
      throw new InterruptedIOException("Connection already shutdown");
    }
    super.a(paramSocket);
  }
  
  public Object b(String paramString)
  {
    return this.b.remove(paramString);
  }
  
  public void f()
    throws IOException
  {
    this.c = true;
    super.f();
  }
  
  public SSLSession n()
  {
    Socket localSocket = super.t();
    if ((localSocket instanceof SSLSocket)) {
      return ((SSLSocket)localSocket).getSession();
    }
    return null;
  }
  
  public String s()
  {
    return this.a;
  }
  
  public Socket t()
  {
    return super.t();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */