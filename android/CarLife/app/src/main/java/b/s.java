package b;

import b.a.c;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class s
{
  private final ag a;
  private final i b;
  private final List<Certificate> c;
  private final List<Certificate> d;
  
  private s(ag paramag, i parami, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.a = paramag;
    this.b = parami;
    this.c = paramList1;
    this.d = paramList2;
  }
  
  public static s a(ag paramag, i parami, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    if (parami == null) {
      throw new NullPointerException("cipherSuite == null");
    }
    return new s(paramag, parami, c.a(paramList1), c.a(paramList2));
  }
  
  public static s a(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    if (localObject == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    i locali = i.a((String)localObject);
    localObject = paramSSLSession.getProtocol();
    if (localObject == null) {
      throw new IllegalStateException("tlsVersion == null");
    }
    ag localag = ag.a((String)localObject);
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = c.a((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label109;
        }
        paramSSLSession = c.a(paramSSLSession);
        return new s(localag, locali, (List)localObject, paramSSLSession);
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
  
  public ag a()
  {
    return this.a;
  }
  
  public i b()
  {
    return this.b;
  }
  
  public List<Certificate> c()
  {
    return this.c;
  }
  
  public Principal d()
  {
    if (!this.c.isEmpty()) {
      return ((X509Certificate)this.c.get(0)).getSubjectX500Principal();
    }
    return null;
  }
  
  public List<Certificate> e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof s)) {}
    do
    {
      return false;
      paramObject = (s)paramObject;
    } while ((!c.a(this.b, ((s)paramObject).b)) || (!this.b.equals(((s)paramObject).b)) || (!this.c.equals(((s)paramObject).c)) || (!this.d.equals(((s)paramObject).d)));
    return true;
  }
  
  public Principal f()
  {
    if (!this.d.isEmpty()) {
      return ((X509Certificate)this.d.get(0)).getSubjectX500Principal();
    }
    return null;
  }
  
  public int hashCode()
  {
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0) {
      return (((i + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */