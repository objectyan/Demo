package com.indooratlas.android.sdk._internal;

import java.net.InetSocketAddress;

public abstract class jk
  implements jm
{
  public final String a(jj paramjj)
    throws ju
  {
    paramjj = paramjj.c();
    if (paramjj == null) {
      throw new jw("socket not bound");
    }
    StringBuffer localStringBuffer = new StringBuffer(90);
    localStringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    localStringBuffer.append(paramjj.getPort());
    localStringBuffer.append("\" /></cross-domain-policy>\000");
    return localStringBuffer.toString();
  }
  
  public void a(jj paramjj, kd paramkd)
  {
    paramkd = new ke(paramkd);
    paramkd.a(kd.a.e);
    paramjj.b(paramkd);
  }
  
  public void a(jj paramjj, kf paramkf)
    throws ju
  {}
  
  public void b(jj paramjj, kd paramkd) {}
  
  public void c(kd paramkd) {}
  
  public final kn g()
    throws ju
  {
    return new kj();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */