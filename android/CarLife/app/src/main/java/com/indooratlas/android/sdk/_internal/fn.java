package com.indooratlas.android.sdk._internal;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class fn
{
  public final ge a;
  public final gb b;
  public final SocketFactory c;
  public final fo d;
  public final List<gi> e;
  public final List<fx> f;
  public final ProxySelector g;
  public final Proxy h;
  public final SSLSocketFactory i;
  public final HostnameVerifier j;
  public final ft k;
  
  public fn(String paramString, int paramInt, gb paramgb, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, ft paramft, fo paramfo, Proxy paramProxy, List<gi> paramList, List<fx> paramList1, ProxySelector paramProxySelector)
  {
    ge.a locala = new ge.a();
    if (paramSSLSocketFactory != null)
    {
      str = "https";
      if (!str.equalsIgnoreCase("http")) {
        break label60;
      }
      locala.a = "http";
    }
    for (;;)
    {
      if (paramString == null)
      {
        throw new IllegalArgumentException("host == null");
        str = "http";
        break;
        label60:
        if (str.equalsIgnoreCase("https")) {
          locala.a = "https";
        } else {
          throw new IllegalArgumentException("unexpected scheme: " + str);
        }
      }
    }
    String str = ge.a.a(paramString, 0, paramString.length());
    if (str == null) {
      throw new IllegalArgumentException("unexpected host: " + paramString);
    }
    locala.d = str;
    if ((paramInt <= 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("unexpected port: " + paramInt);
    }
    locala.e = paramInt;
    this.a = locala.b();
    if (paramgb == null) {
      throw new IllegalArgumentException("dns == null");
    }
    this.b = paramgb;
    if (paramSocketFactory == null) {
      throw new IllegalArgumentException("socketFactory == null");
    }
    this.c = paramSocketFactory;
    if (paramfo == null) {
      throw new IllegalArgumentException("proxyAuthenticator == null");
    }
    this.d = paramfo;
    if (paramList == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    this.e = gy.a(paramList);
    if (paramList1 == null) {
      throw new IllegalArgumentException("connectionSpecs == null");
    }
    this.f = gy.a(paramList1);
    if (paramProxySelector == null) {
      throw new IllegalArgumentException("proxySelector == null");
    }
    this.g = paramProxySelector;
    this.h = paramProxy;
    this.i = paramSSLSocketFactory;
    this.j = paramHostnameVerifier;
    this.k = paramft;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof fn))
    {
      paramObject = (fn)paramObject;
      bool1 = bool2;
      if (this.a.equals(((fn)paramObject).a))
      {
        bool1 = bool2;
        if (this.b.equals(((fn)paramObject).b))
        {
          bool1 = bool2;
          if (this.d.equals(((fn)paramObject).d))
          {
            bool1 = bool2;
            if (this.e.equals(((fn)paramObject).e))
            {
              bool1 = bool2;
              if (this.f.equals(((fn)paramObject).f))
              {
                bool1 = bool2;
                if (this.g.equals(((fn)paramObject).g))
                {
                  bool1 = bool2;
                  if (gy.a(this.h, ((fn)paramObject).h))
                  {
                    bool1 = bool2;
                    if (gy.a(this.i, ((fn)paramObject).i))
                    {
                      bool1 = bool2;
                      if (gy.a(this.j, ((fn)paramObject).j))
                      {
                        bool1 = bool2;
                        if (gy.a(this.k, ((fn)paramObject).k)) {
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
  
  public final int hashCode()
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
      return (i1 + (n + (m + ((((((i3 + 527) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31) * 31) * 31 + i2;
      m = 0;
      break;
      n = 0;
      break label91;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */