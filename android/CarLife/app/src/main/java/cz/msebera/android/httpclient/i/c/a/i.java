package cz.msebera.android.httpclient.i.c.a;

import cz.msebera.android.httpclient.o.a;
import java.util.Date;
import java.util.concurrent.locks.Condition;

@Deprecated
public class i
{
  private final Condition a;
  private final g b;
  private Thread c;
  private boolean d;
  
  public i(Condition paramCondition, g paramg)
  {
    a.a(paramCondition, "Condition");
    this.a = paramCondition;
    this.b = paramg;
  }
  
  public final Condition a()
  {
    return this.a;
  }
  
  public boolean a(Date paramDate)
    throws InterruptedException
  {
    if (this.c != null) {
      throw new IllegalStateException("A thread is already waiting on this object.\ncaller: " + Thread.currentThread() + "\nwaiter: " + this.c);
    }
    if (this.d) {
      throw new InterruptedException("Operation interrupted");
    }
    this.c = Thread.currentThread();
    if (paramDate != null) {}
    boolean bool;
    for (;;)
    {
      try
      {
        bool = this.a.awaitUntil(paramDate);
        if (!this.d) {
          break;
        }
        throw new InterruptedException("Operation interrupted");
      }
      finally
      {
        this.c = null;
      }
      this.a.await();
      bool = true;
    }
    this.c = null;
    return bool;
  }
  
  public final g b()
  {
    return this.b;
  }
  
  public final Thread c()
  {
    return this.c;
  }
  
  public void d()
  {
    if (this.c == null) {
      throw new IllegalStateException("Nobody waiting on this object.");
    }
    this.a.signalAll();
  }
  
  public void e()
  {
    this.d = true;
    this.a.signalAll();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */