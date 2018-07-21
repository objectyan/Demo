package b.a.c;

import b.a.f.g.a;
import b.a.f.g.b;
import b.a.f.i;
import b.ab;
import b.ab.a;
import b.ad;
import b.ad.a;
import b.af;
import b.j;
import b.l;
import b.s;
import b.u;
import b.z;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class c
  extends g.b
  implements j
{
  public Socket a;
  public volatile b.a.f.g b;
  public int c;
  public BufferedSource d;
  public BufferedSink e;
  public int f;
  public final List<Reference<g>> g = new ArrayList();
  public boolean h;
  public long i = Long.MAX_VALUE;
  private final af k;
  private Socket l;
  private s m;
  private z n;
  
  public c(af paramaf)
  {
    this.k = paramaf;
  }
  
  private ab a(int paramInt1, int paramInt2, ab paramab, u paramu)
    throws IOException
  {
    Object localObject = null;
    String str = "CONNECT " + b.a.c.a(paramu, true) + " HTTP/1.1";
    ad localad;
    do
    {
      paramu = new b.a.e.a(null, null, this.d, this.e);
      this.d.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.e.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      paramu.a(paramab.c(), str);
      paramu.a();
      localad = paramu.e().a(paramab).a();
      long l2 = b.a.d.e.a(localad);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramab = paramu.b(l1);
      b.a.c.b(paramab, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
      paramab.close();
      switch (localad.c())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + localad.c());
      case 200: 
        if (this.d.buffer().exhausted())
        {
          paramu = (u)localObject;
          if (this.e.buffer().exhausted()) {
            break;
          }
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        paramu = this.k.a().d().a(this.k, localad);
        if (paramu == null) {
          throw new IOException("Failed to authenticate with proxy");
        }
        paramab = paramu;
      }
    } while (!"close".equalsIgnoreCase(localad.b("Connection")));
    return paramu;
  }
  
  private void a(int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject1 = this.k.b();
    localObject2 = this.k.a();
    if ((((Proxy)localObject1).type() == Proxy.Type.DIRECT) || (((Proxy)localObject1).type() == Proxy.Type.HTTP)) {}
    for (localObject1 = ((b.a)localObject2).c().createSocket();; localObject1 = new Socket((Proxy)localObject1))
    {
      this.l = ((Socket)localObject1);
      this.l.setSoTimeout(paramInt2);
      try
      {
        b.a.h.e.b().a(this.l, this.k.c(), paramInt1);
        this.d = Okio.buffer(Okio.source(this.l));
        this.e = Okio.buffer(Okio.sink(this.l));
        return;
      }
      catch (ConnectException localConnectException)
      {
        localObject2 = new ConnectException("Failed to connect to " + this.k.c());
        ((ConnectException)localObject2).initCause(localConnectException);
        throw ((Throwable)localObject2);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, b paramb)
    throws IOException
  {
    ab localab = g();
    u localu = localab.a();
    int j = 0;
    for (;;)
    {
      j += 1;
      if (j > 21) {
        throw new ProtocolException("Too many tunnel connections attempted: " + 21);
      }
      a(paramInt1, paramInt2);
      localab = a(paramInt2, paramInt3, localab, localu);
      if (localab == null)
      {
        a(paramInt2, paramInt3, paramb);
        return;
      }
      b.a.c.a(this.l);
      this.l = null;
      this.e = null;
      this.d = null;
    }
  }
  
  private void a(int paramInt1, int paramInt2, b paramb)
    throws IOException
  {
    if (this.k.a().i() != null) {
      b(paramInt1, paramInt2, paramb);
    }
    while (this.n == z.d)
    {
      this.a.setSoTimeout(0);
      paramb = new g.a(true).a(this.a, this.k.a().a().i(), this.d, this.e).a(this).a();
      paramb.f();
      this.f = paramb.c();
      this.b = paramb;
      return;
      this.n = z.b;
      this.a = this.l;
    }
    this.f = 1;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, b paramb)
    throws IOException
  {
    a(paramInt1, paramInt2);
    a(paramInt2, paramInt3, paramb);
  }
  
  private void b(int paramInt1, int paramInt2, b paramb)
    throws IOException
  {
    b.a locala = this.k.a();
    Object localObject3 = locala.i();
    Object localObject2 = null;
    Object localObject1 = null;
    s locals;
    try
    {
      localObject3 = (SSLSocket)((SSLSocketFactory)localObject3).createSocket(this.l, locala.a().i(), locala.a().j(), true);
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramb = paramb.a((SSLSocket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (paramb.d())
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        b.a.h.e.b().a((SSLSocket)localObject3, locala.a().i(), locala.e());
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      ((SSLSocket)localObject3).startHandshake();
      localObject1 = localObject3;
      localObject2 = localObject3;
      locals = s.a(((SSLSocket)localObject3).getSession());
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (!locala.j().verify(locala.a().i(), ((SSLSocket)localObject3).getSession()))
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        paramb = (X509Certificate)locals.c().get(0);
        localObject1 = localObject3;
        localObject2 = localObject3;
        throw new SSLPeerUnverifiedException("Hostname " + locala.a().i() + " not verified:\n    certificate: " + b.g.a(paramb) + "\n    DN: " + paramb.getSubjectDN().getName() + "\n    subjectAltNames: " + b.a.i.d.a(paramb));
      }
    }
    catch (AssertionError paramb)
    {
      localObject2 = localObject1;
      if (!b.a.c.a(paramb)) {
        break label543;
      }
      localObject2 = localObject1;
      throw new IOException(paramb);
    }
    finally
    {
      if (localObject2 != null) {
        b.a.h.e.b().b((SSLSocket)localObject2);
      }
      if (0 == 0) {
        b.a.c.a((Socket)localObject2);
      }
    }
    localObject1 = localObject3;
    localObject2 = localObject3;
    locala.k().a(locala.a().i(), locals.c());
    localObject1 = localObject3;
    localObject2 = localObject3;
    if (paramb.d())
    {
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramb = b.a.h.e.b().a((SSLSocket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.a = ((Socket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.d = Okio.buffer(Okio.source(this.a));
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.e = Okio.buffer(Okio.sink(this.a));
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.m = locals;
      if (paramb == null) {
        break label528;
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
    }
    for (paramb = z.a(paramb);; paramb = z.b)
    {
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.n = paramb;
      if (localObject3 != null) {
        b.a.h.e.b().b((SSLSocket)localObject3);
      }
      if (1 == 0) {
        b.a.c.a((Socket)localObject3);
      }
      return;
      paramb = null;
      break;
      label528:
      localObject1 = localObject3;
      localObject2 = localObject3;
    }
    label543:
    localObject2 = localObject1;
    throw paramb;
  }
  
  private ab g()
  {
    return new ab.a().a(this.k.a().a()).a("Host", b.a.c.a(this.k.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", b.a.d.a()).d();
  }
  
  public af a()
  {
    return this.k;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, List<l> paramList, boolean paramBoolean)
  {
    if (this.n != null) {
      throw new IllegalStateException("already connected");
    }
    Object localObject2 = null;
    b localb = new b(paramList);
    Object localObject1 = localObject2;
    if (this.k.a().i() == null)
    {
      if (!paramList.contains(l.c)) {
        throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
      }
      paramList = this.k.a().a().i();
      localObject1 = localObject2;
      if (!b.a.h.e.b().b(paramList)) {
        throw new e(new UnknownServiceException("CLEARTEXT communication to " + paramList + " not permitted by network security policy"));
      }
    }
    for (;;)
    {
      if (this.n == null) {
        try
        {
          if (this.k.d()) {
            a(paramInt1, paramInt2, paramInt3, localb);
          }
        }
        catch (IOException localIOException)
        {
          b.a.c.a(this.a);
          b.a.c.a(this.l);
          this.a = null;
          this.l = null;
          this.d = null;
          this.e = null;
          this.m = null;
          this.n = null;
          if (localObject1 == null) {}
          for (paramList = new e(localIOException);; paramList = (List<l>)localObject1)
          {
            if (paramBoolean)
            {
              localObject1 = paramList;
              if (localb.a(localIOException)) {
                break;
              }
            }
            throw paramList;
            b(paramInt1, paramInt2, paramInt3, localb);
            break;
            ((e)localObject1).a(localIOException);
          }
        }
      }
    }
  }
  
  public void a(b.a.f.g paramg)
  {
    this.f = paramg.c();
  }
  
  public void a(i parami)
    throws IOException
  {
    parami.a(b.a.f.b.e);
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.a.isClosed()) || (this.a.isInputShutdown()) || (this.a.isOutputShutdown())) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (this.b == null) {
          break;
        }
      } while (!this.b.g());
      return false;
    } while (!paramBoolean);
    try
    {
      int j = this.a.getSoTimeout();
      try
      {
        this.a.setSoTimeout(1);
        paramBoolean = this.d.exhausted();
        return !paramBoolean;
      }
      finally
      {
        this.a.setSoTimeout(j);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public Socket b()
  {
    return this.a;
  }
  
  public s c()
  {
    return this.m;
  }
  
  public z d()
  {
    if (this.b == null)
    {
      if (this.n != null) {
        return this.n;
      }
      return z.b;
    }
    return z.d;
  }
  
  public void e()
  {
    b.a.c.a(this.l);
  }
  
  public boolean f()
  {
    return this.b != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.k.a().a().i()).append(":").append(this.k.a().a().j()).append(", proxy=").append(this.k.b()).append(" hostAddress=").append(this.k.c()).append(" cipherSuite=");
    if (this.m != null) {}
    for (Object localObject = this.m.b();; localObject = "none") {
      return localObject + " protocol=" + this.n + '}';
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */