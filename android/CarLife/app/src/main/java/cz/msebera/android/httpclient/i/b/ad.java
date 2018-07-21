package cz.msebera.android.httpclient.i.b;

import java.util.concurrent.atomic.AtomicLong;

public final class ad
{
  private final AtomicLong a = new AtomicLong();
  private final AtomicLong b = new AtomicLong();
  private final a c = new a();
  private final a d = new a();
  private final a e = new a();
  private final a f = new a();
  
  AtomicLong a()
  {
    return this.a;
  }
  
  AtomicLong b()
  {
    return this.b;
  }
  
  a c()
  {
    return this.c;
  }
  
  a d()
  {
    return this.d;
  }
  
  a e()
  {
    return this.e;
  }
  
  a f()
  {
    return this.f;
  }
  
  public long g()
  {
    return this.a.get();
  }
  
  public long h()
  {
    return this.b.get();
  }
  
  public long i()
  {
    return this.c.a();
  }
  
  public long j()
  {
    return this.c.b();
  }
  
  public long k()
  {
    return this.d.a();
  }
  
  public long l()
  {
    return this.d.b();
  }
  
  public long m()
  {
    return this.e.a();
  }
  
  public long n()
  {
    return this.e.b();
  }
  
  public long o()
  {
    return this.f.a();
  }
  
  public long p()
  {
    return this.f.b();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[activeConnections=").append(this.a).append(", scheduledConnections=").append(this.b).append(", successfulConnections=").append(this.c).append(", failedConnections=").append(this.d).append(", requests=").append(this.e).append(", tasks=").append(this.f).append("]");
    return localStringBuilder.toString();
  }
  
  static class a
  {
    private final AtomicLong a = new AtomicLong(0L);
    private final AtomicLong b = new AtomicLong(0L);
    
    public long a()
    {
      return this.a.get();
    }
    
    public void a(long paramLong)
    {
      this.a.incrementAndGet();
      this.b.addAndGet(System.currentTimeMillis() - paramLong);
    }
    
    public long b()
    {
      long l1 = 0L;
      long l2 = this.a.get();
      if (l2 > 0L) {
        l1 = this.b.get() / l2;
      }
      return l1;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[count=").append(a()).append(", averageDuration=").append(b()).append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */