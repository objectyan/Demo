package b.a.i;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public abstract class b
{
  public static b a(X509TrustManager paramX509TrustManager)
  {
    return b.a.h.e.b().a(paramX509TrustManager);
  }
  
  public static b a(X509Certificate... paramVarArgs)
  {
    return new a(e.a(paramVarArgs));
  }
  
  public abstract List<Certificate> a(List<Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */