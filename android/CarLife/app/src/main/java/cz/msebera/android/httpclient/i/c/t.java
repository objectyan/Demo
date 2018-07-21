package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.f.c;
import cz.msebera.android.httpclient.d.f;
import cz.msebera.android.httpclient.e.l;
import cz.msebera.android.httpclient.e.q;
import cz.msebera.android.httpclient.e.u;
import cz.msebera.android.httpclient.e.x;
import cz.msebera.android.httpclient.e.y;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketTimeoutException;

@Immutable
class t
{
  static final String a = "http.socket-factory-registry";
  public cz.msebera.android.httpclient.h.b b = new cz.msebera.android.httpclient.h.b(getClass());
  private final cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.e.d.a> c;
  private final x d;
  private final l e;
  
  t(cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.e.d.a> paramb, x paramx, l paraml)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Socket factory registry");
    this.c = paramb;
    if (paramx != null)
    {
      this.d = paramx;
      if (paraml == null) {
        break label57;
      }
    }
    for (;;)
    {
      this.e = paraml;
      return;
      paramx = s.a;
      break;
      label57:
      paraml = ak.a;
    }
  }
  
  private cz.msebera.android.httpclient.d.b<cz.msebera.android.httpclient.e.d.a> a(cz.msebera.android.httpclient.n.g paramg)
  {
    cz.msebera.android.httpclient.d.b localb = (cz.msebera.android.httpclient.d.b)paramg.a("http.socket-factory-registry");
    paramg = localb;
    if (localb == null) {
      paramg = this.c;
    }
    return paramg;
  }
  
  public void a(u paramu, r paramr, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    Object localObject = (cz.msebera.android.httpclient.e.d.a)a(c.b(paramg)).c(paramr.c());
    if (localObject == null) {
      throw new y(paramr.c() + " protocol is not supported");
    }
    if (!(localObject instanceof cz.msebera.android.httpclient.e.d.b)) {
      throw new y(paramr.c() + " protocol does not support connection upgrade");
    }
    localObject = (cz.msebera.android.httpclient.e.d.b)localObject;
    Socket localSocket = paramu.t();
    int i = this.d.a(paramr);
    paramu.a(((cz.msebera.android.httpclient.e.d.b)localObject).createLayeredSocket(localSocket, paramr.a(), i, paramg));
  }
  
  public void a(u paramu, r paramr, InetSocketAddress paramInetSocketAddress, int paramInt, f paramf, cz.msebera.android.httpclient.n.g paramg)
    throws IOException
  {
    cz.msebera.android.httpclient.e.d.a locala = (cz.msebera.android.httpclient.e.d.a)a(paramg).c(paramr.c());
    if (locala == null) {
      throw new y(paramr.c() + " protocol is not supported");
    }
    InetAddress[] arrayOfInetAddress;
    int k;
    int i;
    if (paramr.d() != null)
    {
      arrayOfInetAddress = new InetAddress[1];
      arrayOfInetAddress[0] = paramr.d();
      k = this.d.a(paramr);
      i = 0;
    }
    Object localObject;
    int j;
    label119:
    label335:
    label341:
    label400:
    label423:
    label470:
    for (;;)
    {
      Socket localSocket;
      int m;
      if (i < arrayOfInetAddress.length)
      {
        localObject = arrayOfInetAddress[i];
        if (i != arrayOfInetAddress.length - 1) {
          break label335;
        }
        j = 1;
        localSocket = locala.createSocket(paramg);
        localSocket.setSoTimeout(paramf.a());
        localSocket.setReuseAddress(paramf.b());
        localSocket.setTcpNoDelay(paramf.e());
        localSocket.setKeepAlive(paramf.d());
        m = paramf.c();
        if (m >= 0) {
          if (m <= 0) {
            break label341;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localSocket.setSoLinger(bool, m);
        paramu.a(localSocket);
        localObject = new InetSocketAddress((InetAddress)localObject, k);
        if (this.b.a()) {
          this.b.a("Connecting to " + localObject);
        }
        try
        {
          paramu.a(locala.connectSocket(paramInt, localSocket, paramr, (InetSocketAddress)localObject, paramInetSocketAddress, paramg));
          if (this.b.a()) {
            this.b.a("Connection established " + paramu);
          }
          return;
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          if (j == 0) {
            break label423;
          }
          throw new cz.msebera.android.httpclient.e.g(localSocketTimeoutException, paramr, arrayOfInetAddress);
        }
        catch (ConnectException localConnectException)
        {
          if (j == 0) {
            break label423;
          }
          if (!"Connection timed out".equals(localConnectException.getMessage())) {
            break label400;
          }
          throw new cz.msebera.android.httpclient.e.g(localConnectException, paramr, arrayOfInetAddress);
          throw new q(localConnectException, paramr, arrayOfInetAddress);
        }
        catch (NoRouteToHostException localNoRouteToHostException)
        {
          if (j == 0) {
            break label423;
          }
          throw localNoRouteToHostException;
          if (!this.b.a()) {
            break label470;
          }
          this.b.a("Connect to " + localObject + " timed out. " + "Connection will be retried using another IP address");
          i += 1;
        }
        arrayOfInetAddress = this.e.a(paramr.a());
        break;
        j = 0;
        break label119;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */