package b;

import b.a.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a
{
  final u a;
  final q b;
  final SocketFactory c;
  final b d;
  final List<z> e;
  final List<l> f;
  final ProxySelector g;
  final Proxy h;
  final SSLSocketFactory i;
  final HostnameVerifier j;
  final g k;
  
  public a(String paramString, int paramInt, q paramq, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, g paramg, b paramb, Proxy paramProxy, List<z> paramList, List<l> paramList1, ProxySelector paramProxySelector)
  {
    u.a locala = new u.a();
    if (paramSSLSocketFactory != null) {}
    for (String str = "https";; str = "http")
    {
      this.a = locala.a(str).f(paramString).a(paramInt).c();
      if (paramq != null) {
        break;
      }
      throw new NullPointerException("dns == null");
    }
    this.b = paramq;
    if (paramSocketFactory == null) {
      throw new NullPointerException("socketFactory == null");
    }
    this.c = paramSocketFactory;
    if (paramb == null) {
      throw new NullPointerException("proxyAuthenticator == null");
    }
    this.d = paramb;
    if (paramList == null) {
      throw new NullPointerException("protocols == null");
    }
    this.e = c.a(paramList);
    if (paramList1 == null) {
      throw new NullPointerException("connectionSpecs == null");
    }
    this.f = c.a(paramList1);
    if (paramProxySelector == null) {
      throw new NullPointerException("proxySelector == null");
    }
    this.g = paramProxySelector;
    this.h = paramProxy;
    this.i = paramSSLSocketFactory;
    this.j = paramHostnameVerifier;
    this.k = paramg;
  }
  
  public u a()
  {
    return this.a;
  }
  
  public q b()
  {
    return this.b;
  }
  
  public SocketFactory c()
  {
    return this.c;
  }
  
  public b d()
  {
    return this.d;
  }
  
  public List<z> e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (this.a.equals(((a)paramObject).a))
      {
        bool1 = bool2;
        if (this.b.equals(((a)paramObject).b))
        {
          bool1 = bool2;
          if (this.d.equals(((a)paramObject).d))
          {
            bool1 = bool2;
            if (this.e.equals(((a)paramObject).e))
            {
              bool1 = bool2;
              if (this.f.equals(((a)paramObject).f))
              {
                bool1 = bool2;
                if (this.g.equals(((a)paramObject).g))
                {
                  bool1 = bool2;
                  if (c.a(this.h, ((a)paramObject).h))
                  {
                    bool1 = bool2;
                    if (c.a(this.i, ((a)paramObject).i))
                    {
                      bool1 = bool2;
                      if (c.a(this.j, ((a)paramObject).j))
                      {
                        bool1 = bool2;
                        if (c.a(this.k, ((a)paramObject).k)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public List<l> f()
  {
    return this.f;
  }
  
  public ProxySelector g()
  {
    return this.g;
  }
  
  public Proxy h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    int i2 = 0;
    int i3 = this.a.hashCode();
    int i4 = this.b.hashCode();
    int i5 = this.d.hashCode();
    int i6 = this.e.hashCode();
    int i7 = this.f.hashCode();
    int i8 = this.g.hashCode();
    int m;
    int n;
    if (this.h != null)
    {
      m = this.h.hashCode();
      if (this.i == null) {
        break label185;
      }
      n = this.i.hashCode();
      label91:
      if (this.j == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (int i1 = this.j.hashCode();; i1 = 0)
    {
      if (this.k != null) {
        i2 = this.k.hashCode();
      }
      return (((((((((i3 + 527) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
      m = 0;
      break;
      n = 0;
      break label91;
    }
  }
  
  public SSLSocketFactory i()
  {
    return this.i;
  }
  
  public HostnameVerifier j()
  {
    return this.j;
  }
  
  public g k()
  {
    return this.k;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */