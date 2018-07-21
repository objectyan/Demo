package de.greenrobot.event.util;

import android.app.Activity;
import android.util.Log;
import de.greenrobot.event.EventBus;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncExecutor
{
  private final EventBus eventBus;
  private final Constructor<?> failureEventConstructor;
  private Object scope;
  private final Executor threadPool;
  
  private AsyncExecutor(Executor paramExecutor, EventBus paramEventBus, Class<?> paramClass, Object paramObject)
  {
    this.threadPool = paramExecutor;
    this.eventBus = paramEventBus;
    this.scope = paramObject;
    try
    {
      this.failureEventConstructor = paramClass.getConstructor(new Class[] { Throwable.class });
      return;
    }
    catch (NoSuchMethodException paramExecutor)
    {
      throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", paramExecutor);
    }
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static AsyncExecutor create()
  {
    return new Builder(null).build();
  }
  
  public void execute(final RunnableEx paramRunnableEx)
  {
    this.threadPool.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          paramRunnableEx.run();
          return;
        }
        catch (Exception localException1)
        {
          try
          {
            Object localObject = AsyncExecutor.this.failureEventConstructor.newInstance(new Object[] { localException1 });
            if ((localException1 instanceof HasExecutionScope)) {
              ((HasExecutionScope)localException1).setExecutionScope(AsyncExecutor.this.scope);
            }
            AsyncExecutor.this.eventBus.post(localObject);
            return;
          }
          catch (Exception localException2)
          {
            Log.e(EventBus.TAG, "Original exception:", localException1);
            throw new RuntimeException("Could not create failure event", localException2);
          }
        }
      }
    });
  }
  
  public static class Builder
  {
    private EventBus eventBus;
    private Class<?> failureEventType;
    private Executor threadPool;
    
    public AsyncExecutor build()
    {
      return buildForScope(null);
    }
    
    public AsyncExecutor buildForActivityScope(Activity paramActivity)
    {
      return buildForScope(paramActivity.getClass());
    }
    
    public AsyncExecutor buildForScope(Object paramObject)
    {
      if (this.eventBus == null) {
        this.eventBus = EventBus.getDefault();
      }
      if (this.threadPool == null) {
        this.threadPool = Executors.newCachedThreadPool();
      }
      if (this.failureEventType == null) {
        this.failureEventType = ThrowableFailureEvent.class;
      }
      return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, paramObject, null);
    }
    
    public Builder eventBus(EventBus paramEventBus)
    {
      this.eventBus = paramEventBus;
      return this;
    }
    
    public Builder failureEventType(Class<?> paramClass)
    {
      this.failureEventType = paramClass;
      return this;
    }
    
    public Builder threadPool(Executor paramExecutor)
    {
      this.threadPool = paramExecutor;
      return this;
    }
  }
  
  public static abstract interface RunnableEx
  {
    public abstract void run()
      throws Exception;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/de/greenrobot/event/util/AsyncExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */