package com.baidu.carlife.c;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class g
{
  private static final int a = 5;
  private static final int b = 10;
  private static final int c = 60;
  private Handler d = new Handler(Looper.getMainLooper());
  private ThreadPoolExecutor e = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(5));
  
  public static g a()
  {
    return new g();
  }
  
  public <R> void a(final d.a<R> parama)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        parama.a();
      }
    });
  }
  
  public <R> void a(final R paramR, final d.a<R> parama)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        parama.a(paramR);
      }
    });
  }
  
  public void a(Runnable paramRunnable)
  {
    this.e.submit(paramRunnable);
  }
  
  public <R> void b(final d.a<R> parama)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        parama.b();
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */