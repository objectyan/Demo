package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ThreadSafe
public class af
  implements aq
{
  private final ExecutorService a;
  
  public af(f paramf)
  {
    this(new ThreadPoolExecutor(paramf.m(), paramf.l(), paramf.n(), TimeUnit.SECONDS, new ArrayBlockingQueue(paramf.o())));
  }
  
  af(ExecutorService paramExecutorService)
  {
    this.a = paramExecutorService;
  }
  
  void a(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    this.a.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException("AsynchronousValidationRequest may not be null");
    }
    this.a.execute(parama);
  }
  
  public void close()
  {
    this.a.shutdown();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */