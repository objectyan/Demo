package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.b.d.q;
import java.util.concurrent.FutureTask;

public class ai<V>
  extends FutureTask<V>
{
  private final q a;
  private final aj<V> b;
  
  public ai(q paramq, aj<V> paramaj)
  {
    super(paramaj);
    this.a = paramq;
    this.b = paramaj;
  }
  
  public long a()
  {
    return this.b.a();
  }
  
  public long b()
  {
    return this.b.b();
  }
  
  public long c()
  {
    if (isDone()) {
      return this.b.c();
    }
    throw new IllegalStateException("Task is not done yet");
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.b.d();
    if (paramBoolean) {
      this.a.abort();
    }
    return super.cancel(paramBoolean);
  }
  
  public long d()
  {
    if (isDone()) {
      return c() - b();
    }
    throw new IllegalStateException("Task is not done yet");
  }
  
  public long e()
  {
    if (isDone()) {
      return c() - a();
    }
    throw new IllegalStateException("Task is not done yet");
  }
  
  public String toString()
  {
    return this.a.getRequestLine().c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */