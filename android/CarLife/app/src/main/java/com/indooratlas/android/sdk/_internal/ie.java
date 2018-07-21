package com.indooratlas.android.sdk._internal;

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

public final class ie
{
  final fn a;
  final gx b;
  private Proxy c;
  private InetSocketAddress d;
  private List<Proxy> e = Collections.emptyList();
  private int f;
  private List<InetSocketAddress> g = Collections.emptyList();
  private int h;
  private final List<go> i = new ArrayList();
  
  public ie(fn paramfn, gx paramgx)
  {
    this.a = paramfn;
    this.b = paramgx;
    paramgx = paramfn.a;
    paramfn = paramfn.h;
    if (paramfn != null) {
      this.e = Collections.singletonList(paramfn);
    }
    for (;;)
    {
      this.f = 0;
      return;
      this.e = new ArrayList();
      paramfn = this.a.g.select(paramgx.a());
      if (paramfn != null) {
        this.e.addAll(paramfn);
      }
      this.e.removeAll(Collections.singleton(Proxy.NO_PROXY));
      this.e.add(Proxy.NO_PROXY);
    }
  }
  
  private void a(Proxy paramProxy)
    throws IOException
  {
    this.g = new ArrayList();
    Object localObject;
    int j;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS))
    {
      localObject = this.a.a.b;
      j = this.a.a.c;
      if ((j <= 0) || (j > 65535)) {
        throw new SocketException("No route to " + (String)localObject + ":" + j + "; port is out of range");
      }
    }
    else
    {
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
      }
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = localInetSocketAddress.getAddress();
      if (localObject == null) {}
      for (localObject = localInetSocketAddress.getHostName();; localObject = ((InetAddress)localObject).getHostAddress())
      {
        j = localInetSocketAddress.getPort();
        break;
      }
    }
    if (paramProxy.type() == Proxy.Type.SOCKS) {
      this.g.add(InetSocketAddress.createUnresolved((String)localObject, j));
    }
    for (;;)
    {
      this.h = 0;
      return;
      paramProxy = this.a.b.a((String)localObject);
      int m = paramProxy.size();
      int k = 0;
      while (k < m)
      {
        localObject = (InetAddress)paramProxy.get(k);
        this.g.add(new InetSocketAddress((InetAddress)localObject, j));
        k += 1;
      }
    }
  }
  
  public final go a()
    throws IOException
  {
    for (;;)
    {
      Object localObject;
      if (!c()) {
        if (!b())
        {
          if (!d()) {
            throw new NoSuchElementException();
          }
          localObject = (go)this.i.remove(0);
        }
      }
      go localgo;
      do
      {
        return (go)localObject;
        if (!b()) {
          throw new SocketException("No route to " + this.a.a.b + "; exhausted proxy configurations: " + this.e);
        }
        localObject = this.e;
        int j = this.f;
        this.f = (j + 1);
        localObject = (Proxy)((List)localObject).get(j);
        a((Proxy)localObject);
        this.c = ((Proxy)localObject);
        if (!c()) {
          throw new SocketException("No route to " + this.a.a.b + "; exhausted inet socket addresses: " + this.g);
        }
        localObject = this.g;
        j = this.h;
        this.h = (j + 1);
        this.d = ((InetSocketAddress)((List)localObject).get(j));
        localgo = new go(this.a, this.c, this.d);
        localObject = localgo;
      } while (!this.b.c(localgo));
      this.i.add(localgo);
    }
  }
  
  final boolean b()
  {
    return this.f < this.e.size();
  }
  
  final boolean c()
  {
    return this.h < this.g.size();
  }
  
  final boolean d()
  {
    return !this.i.isEmpty();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */