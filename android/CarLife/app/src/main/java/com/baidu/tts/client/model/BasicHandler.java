package com.baidu.tts.client.model;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f.l;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BasicHandler<T>
{
  private FutureTask<T> a;
  
  public BasicHandler(FutureTask<T> paramFutureTask)
  {
    this.a = paramFutureTask;
  }
  
  public boolean cancel()
  {
    return this.a.cancel(true);
  }
  
  public T get()
  {
    try
    {
      LoggerProxy.d("BasicHandler", "before get");
      Object localObject = this.a.get(l.a.a(), TimeUnit.MILLISECONDS);
      return (T)localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      LoggerProxy.d("BasicHandler", localInterruptedException.toString());
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      LoggerProxy.d("BasicHandler", localExecutionException.getCause().toString());
      return null;
    }
    catch (TimeoutException localTimeoutException)
    {
      LoggerProxy.d("BasicHandler", localTimeoutException.toString());
    }
    return null;
  }
  
  public void start()
  {
    new Thread(this.a).start();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/client/model/BasicHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */