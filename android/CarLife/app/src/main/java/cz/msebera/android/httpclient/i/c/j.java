package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i.q;
import cz.msebera.android.httpclient.j.c;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.l.m;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
@NotThreadSafe
public class j
  extends q
  implements cz.msebera.android.httpclient.e.u, w, g
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  public cz.msebera.android.httpclient.h.b b = new cz.msebera.android.httpclient.h.b("cz.msebera.android.httpclient.headers");
  public cz.msebera.android.httpclient.h.b c = new cz.msebera.android.httpclient.h.b("cz.msebera.android.httpclient.wire");
  private volatile Socket d;
  private r e;
  private boolean f;
  private volatile boolean g;
  private final Map<String, Object> h = new HashMap();
  
  protected c<x> a(h paramh, y paramy, cz.msebera.android.httpclient.l.j paramj)
  {
    return new l(paramh, null, paramy, paramj);
  }
  
  protected h a(Socket paramSocket, int paramInt, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    if (paramInt > 0) {}
    for (;;)
    {
      h localh = super.a(paramSocket, paramInt, paramj);
      paramSocket = localh;
      if (this.c.a()) {
        paramSocket = new ab(localh, new am(this.c), m.a(paramj));
      }
      return paramSocket;
      paramInt = 8192;
    }
  }
  
  public x a()
    throws p, IOException
  {
    x localx = super.a();
    if (this.a.a()) {
      this.a.a("Receiving response: " + localx.a());
    }
    if (this.b.a())
    {
      this.b.a("<< " + localx.a().toString());
      f[] arrayOff = localx.getAllHeaders();
      int j = arrayOff.length;
      int i = 0;
      while (i < j)
      {
        f localf = arrayOff[i];
        this.b.a("<< " + localf.toString());
        i += 1;
      }
    }
    return localx;
  }
  
  public Object a(String paramString)
  {
    return this.h.get(paramString);
  }
  
  public void a(cz.msebera.android.httpclient.u paramu)
    throws p, IOException
  {
    if (this.a.a()) {
      this.a.a("Sending request: " + paramu.getRequestLine());
    }
    super.a(paramu);
    if (this.b.a())
    {
      this.b.a(">> " + paramu.getRequestLine().toString());
      paramu = paramu.getAllHeaders();
      int j = paramu.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramu[i];
        this.b.a(">> " + localObject.toString());
        i += 1;
      }
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.h.put(paramString, paramObject);
  }
  
  public void a(Socket paramSocket)
    throws IOException
  {
    a(paramSocket, new cz.msebera.android.httpclient.l.b());
  }
  
  public void a(Socket paramSocket, r paramr)
    throws IOException
  {
    w();
    this.d = paramSocket;
    this.e = paramr;
    if (this.g)
    {
      paramSocket.close();
      throw new InterruptedIOException("Connection already shutdown");
    }
  }
  
  public void a(Socket paramSocket, r paramr, boolean paramBoolean, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    o();
    a.a(paramr, "Target host");
    a.a(paramj, "Parameters");
    if (paramSocket != null)
    {
      this.d = paramSocket;
      a(paramSocket, paramj);
    }
    this.e = paramr;
    this.f = paramBoolean;
  }
  
  public void a(boolean paramBoolean, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    a.a(paramj, "Parameters");
    w();
    this.f = paramBoolean;
    a(this.d, paramj);
  }
  
  protected i b(Socket paramSocket, int paramInt, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    if (paramInt > 0) {}
    for (;;)
    {
      i locali = super.b(paramSocket, paramInt, paramj);
      paramSocket = locali;
      if (this.c.a()) {
        paramSocket = new ac(locali, new am(this.c), m.a(paramj));
      }
      return paramSocket;
      paramInt = 8192;
    }
  }
  
  public Object b(String paramString)
  {
    return this.h.remove(paramString);
  }
  
  public void close()
    throws IOException
  {
    try
    {
      super.close();
      if (this.a.a()) {
        this.a.a("Connection " + this + " closed");
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.a.a("I/O error closing connection", localIOException);
    }
  }
  
  public void f()
    throws IOException
  {
    this.g = true;
    try
    {
      super.f();
      if (this.a.a()) {
        this.a.a("Connection " + this + " shut down");
      }
      Socket localSocket = this.d;
      if (localSocket != null) {
        localSocket.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      this.a.a("I/O error shutting down connection", localIOException);
    }
  }
  
  public final r l()
  {
    return this.e;
  }
  
  public final boolean m()
  {
    return this.f;
  }
  
  public SSLSession n()
  {
    if ((this.d instanceof SSLSocket)) {
      return ((SSLSocket)this.d).getSession();
    }
    return null;
  }
  
  public String s()
  {
    return null;
  }
  
  public final Socket t()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */