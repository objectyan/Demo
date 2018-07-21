package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class gq
{
  public boolean a;
  public boolean b;
  private final List<fx> c;
  private int d = 0;
  
  public gq(List<fx> paramList)
  {
    this.c = paramList;
  }
  
  private boolean b(SSLSocket paramSSLSocket)
  {
    int i = this.d;
    while (i < this.c.size())
    {
      if (((fx)this.c.get(i)).a(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final fx a(SSLSocket paramSSLSocket)
    throws IOException
  {
    int i = this.d;
    int j = this.c.size();
    fx localfx;
    if (i < j)
    {
      localfx = (fx)this.c.get(i);
      if (localfx.a(paramSSLSocket)) {
        this.d = (i + 1);
      }
    }
    for (;;)
    {
      if (localfx == null)
      {
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.b + ", modes=" + this.c + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
        i += 1;
        break;
      }
      this.a = b(paramSSLSocket);
      gs.b.a(localfx, paramSSLSocket, this.b);
      return localfx;
      localfx = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */