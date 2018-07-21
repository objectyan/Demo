package cz.msebera.android.httpclient.b.e;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.r;
import java.util.Collection;

@Deprecated
@NotThreadSafe
public class d
  extends cz.msebera.android.httpclient.l.f
{
  public d(j paramj)
  {
    super(paramj);
  }
  
  public void a(int paramInt)
  {
    this.a.b("http.protocol.max-redirects", paramInt);
  }
  
  public void a(long paramLong)
  {
    this.a.b("http.conn-manager.timeout", paramLong);
  }
  
  public void a(r paramr)
  {
    this.a.a("http.virtual-host", paramr);
  }
  
  @Deprecated
  public void a(String paramString)
  {
    this.a.a("http.connection-manager.factory-class-name", paramString);
  }
  
  public void a(Collection<cz.msebera.android.httpclient.f> paramCollection)
  {
    this.a.a("http.default-headers", paramCollection);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.b("http.protocol.handle-redirects", paramBoolean);
  }
  
  public void b(r paramr)
  {
    this.a.a("http.default-host", paramr);
  }
  
  public void b(String paramString)
  {
    this.a.a("http.protocol.cookie-policy", paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.b("http.protocol.reject-relative-redirect", paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.b("http.protocol.allow-circular-redirects", paramBoolean);
  }
  
  public void d(boolean paramBoolean)
  {
    this.a.b("http.protocol.handle-authentication", paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */