package com.indooratlas.android.sdk._internal;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class go
{
  public final fn a;
  public final Proxy b;
  public final InetSocketAddress c;
  
  public go(fn paramfn, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (paramfn == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    this.a = paramfn;
    this.b = paramProxy;
    this.c = paramInetSocketAddress;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof go))
    {
      paramObject = (go)paramObject;
      bool1 = bool2;
      if (this.a.equals(((go)paramObject).a))
      {
        bool1 = bool2;
        if (this.b.equals(((go)paramObject).b))
        {
          bool1 = bool2;
          if (this.c.equals(((go)paramObject).c)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return ((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */