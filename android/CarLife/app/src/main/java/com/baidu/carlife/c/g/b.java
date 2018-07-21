package com.baidu.carlife.c.g;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class b
{
  private static final int a = 4;
  private Executor b = Executors.newSingleThreadExecutor();
  private Executor c = Executors.newFixedThreadPool(4);
  private Handler d = new Handler(Looper.getMainLooper());
  
  public static b a()
  {
    return a.a();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.d.post(paramRunnable);
  }
  
  public void b(Runnable paramRunnable)
  {
    this.b.execute(paramRunnable);
  }
  
  public void c(Runnable paramRunnable)
  {
    this.c.execute(paramRunnable);
  }
  
  private static final class a
  {
    private static final b a = new b(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */