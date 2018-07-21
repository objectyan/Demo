package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.e.b.b;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.n.g;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract interface o
{
  public abstract k a(b paramb, Object paramObject);
  
  public abstract void a();
  
  public abstract void a(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void a(j paramj, b paramb, int paramInt, g paramg)
    throws IOException;
  
  public abstract void a(j paramj, b paramb, g paramg)
    throws IOException;
  
  public abstract void a(j paramj, Object paramObject, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void b();
  
  public abstract void b(j paramj, b paramb, g paramg)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */