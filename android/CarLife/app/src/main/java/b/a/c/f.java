package b.a.c;

import b.a;
import b.a.c;
import b.af;
import b.q;
import b.u;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f
{
  private final a a;
  private final d b;
  private Proxy c;
  private InetSocketAddress d;
  private List<Proxy> e = Collections.emptyList();
  private int f;
  private List<InetSocketAddress> g = Collections.emptyList();
  private int h;
  private final List<af> i = new ArrayList();
  
  public f(a parama, d paramd)
  {
    this.a = parama;
    this.b = paramd;
    a(parama.a(), parama.h());
  }
  
  static String a(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private void a(u paramu, Proxy paramProxy)
  {
    if (paramProxy != null)
    {
      this.e = Collections.singletonList(paramProxy);
      this.f = 0;
      return;
    }
    paramu = this.a.g().select(paramu.b());
    if ((paramu != null) && (!paramu.isEmpty())) {}
    for (paramu = c.a(paramu);; paramu = c.a(new Proxy[] { Proxy.NO_PROXY }))
    {
      this.e = paramu;
      break;
    }
  }
  
  private void a(Proxy paramProxy)
    throws IOException
  {
    this.g = new ArrayList();
    Object localObject;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      localObject = this.a.a().i();
    }
    InetSocketAddress localInetSocketAddress;
    for (int j = this.a.a().j(); (j < 1) || (j > 65535); j = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + (String)localObject + ":" + j + "; port is out of range");
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = a(localInetSocketAddress);
    }
    if (paramProxy.type() == Proxy.Type.SOCKS) {
      this.g.add(InetSocketAddress.createUnresolved((String)localObject, j));
    }
    for (;;)
    {
      this.h = 0;
      return;
      paramProxy = this.a.b().a((String)localObject);
      int k = 0;
      int m = paramProxy.size();
      while (k < m)
      {
        localObject = (InetAddress)paramProxy.get(k);
        this.g.add(new InetSocketAddress((InetAddress)localObject, j));
        k += 1;
      }
    }
  }
  
  private boolean c()
  {
    return this.f < this.e.size();
  }
  
  private Proxy d()
    throws IOException
  {
    if (!c()) {
      throw new SocketException("No route to " + this.a.a().i() + "; exhausted proxy configurations: " + this.e);
    }
    Object localObject = this.e;
    int j = this.f;
    this.f = (j + 1);
    localObject = (Proxy)((List)localObject).get(j);
    a((Proxy)localObject);
    return (Proxy)localObject;
  }
  
  private boolean e()
  {
    return this.h < this.g.size();
  }
  
  private InetSocketAddress f()
    throws IOException
  {
    if (!e()) {
      throw new SocketException("No route to " + this.a.a().i() + "; exhausted inet socket addresses: " + this.g);
    }
    List localList = this.g;
    int j = this.h;
    this.h = (j + 1);
    return (InetSocketAddress)localList.get(j);
  }
  
  private boolean g()
  {
    return !this.i.isEmpty();
  }
  
  private af h()
  {
    return (af)this.i.remove(0);
  }
  
  public void a(af paramaf, IOException paramIOException)
  {
    if ((paramaf.b().type() != Proxy.Type.DIRECT) && (this.a.g() != null)) {
      this.a.g().connectFailed(this.a.a().b(), paramaf.b().address(), paramIOException);
    }
    this.b.a(paramaf);
  }
  
  public boolean a()
  {
    return (e()) || (c()) || (g());
  }
  
  public af b()
    throws IOException
  {
    Object localObject;
    if (!e()) {
      if (!c())
      {
        if (!g()) {
          throw new NoSuchElementException();
        }
        localObject = h();
      }
    }
    af localaf;
    do
    {
      return (af)localObject;
      this.c = d();
      this.d = f();
      localaf = new af(this.a, this.c, this.d);
      localObject = localaf;
    } while (!this.b.c(localaf));
    this.i.add(localaf);
    return b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */