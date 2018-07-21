package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e.x;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.u;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Immutable
public class al
  extends r
{
  private final ProxySelector a;
  
  public al(x paramx, ProxySelector paramProxySelector)
  {
    super(paramx);
    if (paramProxySelector != null) {}
    for (;;)
    {
      this.a = paramProxySelector;
      return;
      paramProxySelector = ProxySelector.getDefault();
    }
  }
  
  public al(ProxySelector paramProxySelector)
  {
    this(null, paramProxySelector);
  }
  
  private String a(InetSocketAddress paramInetSocketAddress)
  {
    if (paramInetSocketAddress.isUnresolved()) {
      return paramInetSocketAddress.getHostName();
    }
    return paramInetSocketAddress.getAddress().getHostAddress();
  }
  
  private Proxy a(List<Proxy> paramList)
  {
    Object localObject = null;
    int i = 0;
    if ((localObject == null) && (i < paramList.size()))
    {
      Proxy localProxy = (Proxy)paramList.get(i);
      switch (1.a[localProxy.type().ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = localProxy;
      }
    }
    paramList = (List<Proxy>)localObject;
    if (localObject == null) {
      paramList = Proxy.NO_PROXY;
    }
    return paramList;
  }
  
  protected cz.msebera.android.httpclient.r b(cz.msebera.android.httpclient.r paramr, u paramu, g paramg)
    throws p
  {
    try
    {
      paramu = new URI(paramr.e());
      paramu = a(this.a.select(paramu));
      paramr = null;
      if (paramu.type() != Proxy.Type.HTTP) {
        return paramr;
      }
      if (!(paramu.address() instanceof InetSocketAddress)) {
        throw new p("Unable to handle non-Inet proxy address: " + paramu.address());
      }
    }
    catch (URISyntaxException paramu)
    {
      throw new p("Cannot convert host to URI: " + paramr, paramu);
    }
    paramr = (InetSocketAddress)paramu.address();
    paramr = new cz.msebera.android.httpclient.r(a(paramr), paramr.getPort());
    return paramr;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */