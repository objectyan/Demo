package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.e.b.b;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;

@Deprecated
public abstract interface t
  extends j, s, u, cz.msebera.android.httpclient.j
{
  public abstract void a(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void a(b paramb, g paramg, cz.msebera.android.httpclient.l.j paramj)
    throws IOException;
  
  public abstract void a(g paramg, cz.msebera.android.httpclient.l.j paramj)
    throws IOException;
  
  public abstract void a(r paramr, boolean paramBoolean, cz.msebera.android.httpclient.l.j paramj)
    throws IOException;
  
  public abstract void a(Object paramObject);
  
  public abstract void a(boolean paramBoolean, cz.msebera.android.httpclient.l.j paramj)
    throws IOException;
  
  public abstract boolean l();
  
  public abstract b m();
  
  public abstract SSLSession n();
  
  public abstract void o();
  
  public abstract void p();
  
  public abstract boolean q();
  
  public abstract Object r();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */