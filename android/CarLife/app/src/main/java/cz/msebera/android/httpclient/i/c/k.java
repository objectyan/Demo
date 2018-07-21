package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.e.c.f;
import cz.msebera.android.httpclient.e.e;
import cz.msebera.android.httpclient.e.l;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.l.h;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
@ThreadSafe
public class k
  implements e
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  protected final cz.msebera.android.httpclient.e.c.j b;
  protected final l c;
  
  public k(cz.msebera.android.httpclient.e.c.j paramj)
  {
    a.a(paramj, "Scheme registry");
    this.b = paramj;
    this.c = new ak();
  }
  
  public k(cz.msebera.android.httpclient.e.c.j paramj, l paraml)
  {
    a.a(paramj, "Scheme registry");
    a.a(paraml, "DNS resolver");
    this.b = paramj;
    this.c = paraml;
  }
  
  private cz.msebera.android.httpclient.e.c.j a(cz.msebera.android.httpclient.n.g paramg)
  {
    cz.msebera.android.httpclient.e.c.j localj = (cz.msebera.android.httpclient.e.c.j)paramg.a("http.scheme-registry");
    paramg = localj;
    if (localj == null) {
      paramg = this.b;
    }
    return paramg;
  }
  
  public w a()
  {
    return new j();
  }
  
  public void a(w paramw, cz.msebera.android.httpclient.r paramr, cz.msebera.android.httpclient.n.g paramg, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    a.a(paramw, "Connection");
    a.a(paramr, "Target host");
    a.a(paramj, "Parameters");
    cz.msebera.android.httpclient.o.b.a(paramw.c(), "Connection must be open");
    Object localObject = a(paramg).a(paramr.c());
    cz.msebera.android.httpclient.o.b.a(((f)localObject).c() instanceof cz.msebera.android.httpclient.e.c.g, "Socket factory must implement SchemeLayeredSocketFactory");
    cz.msebera.android.httpclient.e.c.g localg = (cz.msebera.android.httpclient.e.c.g)((f)localObject).c();
    localObject = localg.createLayeredSocket(paramw.t(), paramr.a(), ((f)localObject).a(paramr.b()), paramj);
    a((Socket)localObject, paramg, paramj);
    paramw.a((Socket)localObject, paramr, localg.isSecure((Socket)localObject), paramj);
  }
  
  public void a(w paramw, cz.msebera.android.httpclient.r paramr, InetAddress paramInetAddress, cz.msebera.android.httpclient.n.g paramg, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    a.a(paramw, "Connection");
    a.a(paramr, "Target host");
    a.a(paramj, "HTTP parameters");
    boolean bool;
    Object localObject;
    cz.msebera.android.httpclient.e.c.k localk;
    InetAddress[] arrayOfInetAddress;
    int k;
    int i;
    if (!paramw.c())
    {
      bool = true;
      cz.msebera.android.httpclient.o.b.a(bool, "Connection must not be open");
      localObject = a(paramg).a(paramr.c());
      localk = ((f)localObject).c();
      arrayOfInetAddress = a(paramr.a());
      k = ((f)localObject).a(paramr.b());
      i = 0;
    }
    int j;
    cz.msebera.android.httpclient.e.r localr;
    label279:
    label305:
    label352:
    for (;;)
    {
      if (i < arrayOfInetAddress.length)
      {
        localObject = arrayOfInetAddress[i];
        if (i != arrayOfInetAddress.length - 1) {
          break label279;
        }
      }
      for (j = 1;; j = 0)
      {
        Socket localSocket1 = localk.createSocket(paramj);
        paramw.a(localSocket1, paramr);
        localr = new cz.msebera.android.httpclient.e.r(paramr, (InetAddress)localObject, k);
        localObject = null;
        if (paramInetAddress != null) {
          localObject = new InetSocketAddress(paramInetAddress, 0);
        }
        if (this.a.a()) {
          this.a.a("Connecting to " + localr);
        }
        try
        {
          Socket localSocket2 = localk.connectSocket(localSocket1, localr, (InetSocketAddress)localObject, paramj);
          localObject = localSocket1;
          if (localSocket1 != localSocket2)
          {
            localObject = localSocket2;
            paramw.a((Socket)localObject, paramr);
          }
          a((Socket)localObject, paramg, paramj);
          paramw.a(localk.isSecure((Socket)localObject), paramj);
          return;
        }
        catch (ConnectException localConnectException)
        {
          if (j == 0) {
            break label305;
          }
          throw localConnectException;
        }
        catch (cz.msebera.android.httpclient.e.g localg)
        {
          if (j == 0) {
            break label305;
          }
          throw localg;
          if (!this.a.a()) {
            break label352;
          }
          this.a.a("Connect to " + localr + " timed out. " + "Connection will be retried using another IP address");
          i += 1;
        }
        bool = false;
        break;
      }
    }
  }
  
  protected void a(Socket paramSocket, cz.msebera.android.httpclient.n.g paramg, cz.msebera.android.httpclient.l.j paramj)
    throws IOException
  {
    paramSocket.setTcpNoDelay(h.c(paramj));
    paramSocket.setSoTimeout(h.a(paramj));
    int i = h.e(paramj);
    if (i >= 0) {
      if (i <= 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      paramSocket.setSoLinger(bool, i);
      return;
    }
  }
  
  protected InetAddress[] a(String paramString)
    throws UnknownHostException
  {
    return this.c.a(paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */