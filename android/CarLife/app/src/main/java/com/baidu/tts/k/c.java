package com.baidu.tts.k;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class c<A extends b<A, R>, R extends a>
{
  private final ConcurrentMap<A, Future<R>> a = new ConcurrentHashMap();
  
  private A b(A paramA)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (paramA.compareTo(localb) == 0) {
        return localb;
      }
    }
    return null;
  }
  
  public R a(A paramA)
    throws Exception
  {
    Object localObject2 = b(paramA);
    if (localObject2 != null) {}
    for (Object localObject1 = (Future)this.a.get(localObject2);; localObject1 = null)
    {
      Object localObject4;
      if (localObject1 != null)
      {
        LoggerProxy.d("Memorizer", "+ get f=" + localObject1);
        localObject4 = (a)((Future)localObject1).get();
        LoggerProxy.d("Memorizer", "- get f=" + localObject1);
        if (!((a)localObject4).g())
        {
          LoggerProxy.d("Memorizer", "arg invalid r=" + localObject4);
          this.a.remove(localObject2);
        }
      }
      Object localObject3;
      for (localObject2 = null;; localObject3 = localObject1)
      {
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new FutureTask(paramA);
          localObject4 = (Future)this.a.putIfAbsent(paramA, localObject2);
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            LoggerProxy.d("Memorizer", "+ run f=" + localObject2);
            ((FutureTask)localObject2).run();
            LoggerProxy.d("Memorizer", "- run f=" + localObject2);
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          try
          {
            localObject2 = (a)((Future)localObject1).get();
            return (R)localObject2;
          }
          catch (ExecutionException localExecutionException)
          {
            this.a.remove(paramA, localObject1);
            throw ((Exception)localExecutionException.getCause());
          }
          catch (Exception localException)
          {
            this.a.remove(paramA, localObject1);
            throw localException;
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/k/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */