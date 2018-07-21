package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e.b.d;
import cz.msebera.android.httpclient.e.c.f;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Deprecated
@NotThreadSafe
public class ah
  implements d
{
  protected final cz.msebera.android.httpclient.e.c.j a;
  protected ProxySelector b;
  
  public ah(cz.msebera.android.httpclient.e.c.j paramj, ProxySelector paramProxySelector)
  {
    a.a(paramj, "SchemeRegistry");
    this.a = paramj;
    this.b = paramProxySelector;
  }
  
  public cz.msebera.android.httpclient.e.b.b a(r paramr, u paramu, g paramg)
    throws p
  {
    a.a(paramu, "HTTP request");
    Object localObject = cz.msebera.android.httpclient.e.a.j.b(paramu.getParams());
    if (localObject != null) {
      return (cz.msebera.android.httpclient.e.b.b)localObject;
    }
    cz.msebera.android.httpclient.o.b.a(paramr, "Target host");
    localObject = cz.msebera.android.httpclient.e.a.j.c(paramu.getParams());
    paramu = b(paramr, paramu, paramg);
    boolean bool = this.a.a(paramr.c()).e();
    if (paramu == null) {}
    for (paramr = new cz.msebera.android.httpclient.e.b.b(paramr, (InetAddress)localObject, bool);; paramr = new cz.msebera.android.httpclient.e.b.b(paramr, (InetAddress)localObject, paramu, bool)) {
      return paramr;
    }
  }
  
  protected String a(InetSocketAddress paramInetSocketAddress)
  {
    if (paramInetSocketAddress.isUnresolved()) {
      return paramInetSocketAddress.getHostName();
    }
    return paramInetSocketAddress.getAddress().getHostAddress();
  }
  
  protected Proxy a(List<Proxy> paramList, r paramr, u paramu, g paramg)
  {
    a.a(paramList, "List of proxies");
    paramr = null;
    int i = 0;
    if ((paramr == null) && (i < paramList.size()))
    {
      paramu = (Proxy)paramList.get(i);
      switch (ah.1.a[paramu.type().ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramr = paramu;
      }
    }
    paramList = paramr;
    if (paramr == null) {
      paramList = Proxy.NO_PROXY;
    }
    return paramList;
  }
  
  public ProxySelector a()
  {
    return this.b;
  }
  
  public void a(ProxySelector paramProxySelector)
  {
    this.b = paramProxySelector;
  }
  
  protected r b(r paramr, u paramu, g paramg)
    throws p
  {
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ProxySelector.getDefault();
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return null;
      try
      {
        localObject2 = new URI(paramr.e());
        paramr = a(((ProxySelector)localObject1).select((URI)localObject2), paramr, paramu, paramg);
        if (paramr.type() == Proxy.Type.HTTP) {
          if (!(paramr.address() instanceof InetSocketAddress)) {
            throw new p("Unable to handle non-Inet proxy address: " + paramr.address());
          }
        }
      }
      catch (URISyntaxException paramu)
      {
        throw new p("Cannot convert host to URI: " + paramr, paramu);
      }
    }
    paramr = (InetSocketAddress)paramr.address();
    return new r(a(paramr), paramr.getPort());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */