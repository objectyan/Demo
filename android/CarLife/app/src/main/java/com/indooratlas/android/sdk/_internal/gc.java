package com.indooratlas.android.sdk._internal;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class gc
{
  public final fu a;
  public final List<Certificate> b;
  private final gp c;
  private final List<Certificate> d;
  
  private gc(gp paramgp, fu paramfu, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.c = paramgp;
    this.a = paramfu;
    this.b = paramList1;
    this.d = paramList2;
  }
  
  public static gc a(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    if (localObject == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    fu localfu = fu.a((String)localObject);
    localObject = paramSSLSession.getProtocol();
    if (localObject == null) {
      throw new IllegalStateException("tlsVersion == null");
    }
    gp localgp = gp.a((String)localObject);
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = gy.a((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label109;
        }
        paramSSLSession = gy.a(paramSSLSession);
        return new gc(localgp, localfu, (List)localObject, paramSSLSession);
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;)
      {
        List localList = null;
        continue;
        localList = Collections.emptyList();
        continue;
        label109:
        paramSSLSession = Collections.emptyList();
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof gc)) {}
    do
    {
      return false;
      paramObject = (gc)paramObject;
    } while ((!gy.a(this.a, ((gc)paramObject).a)) || (!this.a.equals(((gc)paramObject).a)) || (!this.b.equals(((gc)paramObject).b)) || (!this.d.equals(((gc)paramObject).d)));
    return true;
  }
  
  public final int hashCode()
  {
    if (this.c != null) {}
    for (int i = this.c.hashCode();; i = 0) {
      return (((i + 527) * 31 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.d.hashCode();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/gc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */