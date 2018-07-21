package com.baidu.tts.p;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class b
{
  private c a;
  private Context b;
  private FutureTask<Integer> c;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
    this.a = new c(paramContext);
  }
  
  public void a()
  {
    this.c = this.a.a();
    try
    {
      i = ((Integer)this.c.get()).intValue();
      LoggerProxy.d("StatisticsClient", "Statistics uploade result=" + i);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        i = -1;
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        localExecutionException.printStackTrace();
        int i = -1;
      }
    }
  }
  
  public void b()
  {
    if (this.c != null) {
      this.a.b();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/p/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */