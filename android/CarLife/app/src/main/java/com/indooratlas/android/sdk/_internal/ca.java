package com.indooratlas.android.sdk._internal;

import android.os.SystemClock;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public final class ca
{
  public ConcurrentLinkedQueue<bz> a;
  LinkedBlockingQueue<bz> b;
  cb c;
  public HashMap<String, bz> d;
  public a e;
  public volatile boolean f;
  public CountDownLatch g;
  
  public ca(cb paramcb)
  {
    this.c = paramcb;
    this.a = new ConcurrentLinkedQueue();
    this.b = new LinkedBlockingQueue();
    this.d = new HashMap(30);
    this.e = new a();
    this.e.start();
  }
  
  public final boolean a(String paramString)
  {
    bz localbz = new bz(paramString, SystemClock.elapsedRealtime());
    return this.d.put(paramString, localbz) != null;
  }
  
  public final boolean b(String paramString)
  {
    paramString = (bz)this.d.remove(paramString);
    if (paramString != null)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = paramString.b;
      paramString.b = System.currentTimeMillis();
      paramString.h = new long[] { l1 - l2 };
      if (this.f) {}
      for (;;)
      {
        return true;
        this.b.offer(paramString);
      }
    }
    return false;
  }
  
  public final class a
    extends Thread
  {
    a() {}
    
    public final void run()
    {
      for (;;)
      {
        if (!ca.this.f) {}
        try
        {
          bz localbz = (bz)ca.this.b.take();
          ca.this.c.a(new bz[] { localbz });
        }
        catch (IOException localIOException1)
        {
          ee.a("IACore", localIOException1, "saving event failed, skipped", new Object[0]);
          continue;
          if (ca.this.g != null) {
            ca.this.g.countDown();
          }
          cb localcb = ca.this.c;
          if (localcb != null) {}
          try
          {
            localcb.close();
            return;
          }
          catch (IOException localIOException2)
          {
            return;
          }
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */