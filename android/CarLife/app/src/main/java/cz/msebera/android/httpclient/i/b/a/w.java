package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ThreadSafe
public class w
  implements aq
{
  public static final long a = 10L;
  public static final long b = TimeUnit.SECONDS.toMillis(6L);
  public static final long c = TimeUnit.SECONDS.toMillis(86400L);
  private final long d;
  private final long e;
  private final long f;
  private final ScheduledExecutorService g;
  
  public w(f paramf)
  {
    this(paramf, 10L, b, c);
  }
  
  public w(f paramf, long paramLong1, long paramLong2, long paramLong3)
  {
    this(a(paramf), paramLong1, paramLong2, paramLong3);
  }
  
  w(ScheduledExecutorService paramScheduledExecutorService, long paramLong1, long paramLong2, long paramLong3)
  {
    this.g = ((ScheduledExecutorService)a("executor", paramScheduledExecutorService));
    this.d = a("backOffRate", paramLong1);
    this.e = a("initialExpiryInMillis", paramLong2);
    this.f = a("maxExpiryInMillis", paramLong3);
  }
  
  protected static long a(String paramString, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException(paramString + " may not be negative");
    }
    return paramLong;
  }
  
  protected static <T> T a(String paramString, T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(paramString + " may not be null");
    }
    return paramT;
  }
  
  private static ScheduledThreadPoolExecutor a(f paramf)
  {
    paramf = new ScheduledThreadPoolExecutor(paramf.l());
    paramf.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
    return paramf;
  }
  
  public long a()
  {
    return this.d;
  }
  
  protected long a(int paramInt)
  {
    if (paramInt > 0) {
      return Math.min((this.e * Math.pow(this.d, paramInt - 1)), this.f);
    }
    return 0L;
  }
  
  public void a(a parama)
  {
    a("revalidationRequest", parama);
    long l = a(parama.c());
    this.g.schedule(parama, l, TimeUnit.MILLISECONDS);
  }
  
  public long b()
  {
    return this.e;
  }
  
  public long c()
  {
    return this.f;
  }
  
  public void close()
  {
    this.g.shutdown();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */