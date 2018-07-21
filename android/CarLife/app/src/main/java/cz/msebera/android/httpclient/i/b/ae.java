package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.j;
import cz.msebera.android.httpclient.b.r;
import cz.msebera.android.httpclient.c.c;
import cz.msebera.android.httpclient.n.g;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
public class ae
  implements Closeable
{
  private final j a;
  private final ExecutorService b;
  private final ad c = new ad();
  private final AtomicBoolean d = new AtomicBoolean(false);
  
  public ae(j paramj, ExecutorService paramExecutorService)
  {
    this.a = paramj;
    this.b = paramExecutorService;
  }
  
  public ad a()
  {
    return this.c;
  }
  
  public <T> ai<T> a(q paramq, g paramg, r<T> paramr)
  {
    return a(paramq, paramg, paramr, null);
  }
  
  public <T> ai<T> a(q paramq, g paramg, r<T> paramr, c<T> paramc)
  {
    if (this.d.get()) {
      throw new IllegalStateException("Close has been called on this httpclient instance.");
    }
    this.c.b().incrementAndGet();
    paramq = new ai(paramq, new aj(this.a, paramq, paramg, paramr, paramc, this.c));
    this.b.execute(paramq);
    return paramq;
  }
  
  public void close()
    throws IOException
  {
    this.d.set(true);
    this.b.shutdownNow();
    if ((this.a instanceof Closeable)) {
      ((Closeable)this.a).close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */