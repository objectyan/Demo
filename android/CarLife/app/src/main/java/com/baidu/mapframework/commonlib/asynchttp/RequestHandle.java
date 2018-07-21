package com.baidu.mapframework.commonlib.asynchttp;

import android.os.Looper;
import java.lang.ref.WeakReference;

public class RequestHandle
{
  private final WeakReference<AsyncHttpRequest> a;
  
  public RequestHandle(AsyncHttpRequest paramAsyncHttpRequest)
  {
    this.a = new WeakReference(paramAsyncHttpRequest);
  }
  
  public boolean cancel(final boolean paramBoolean)
  {
    final AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.a.get();
    if (localAsyncHttpRequest != null)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            localAsyncHttpRequest.cancel(paramBoolean);
          }
        }).start();
        return true;
      }
      return localAsyncHttpRequest.cancel(paramBoolean);
    }
    return false;
  }
  
  public Object getTag()
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.a.get();
    if (localAsyncHttpRequest == null) {
      return null;
    }
    return localAsyncHttpRequest.getTag();
  }
  
  public boolean isCancelled()
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.a.get();
    return (localAsyncHttpRequest == null) || (localAsyncHttpRequest.isCancelled());
  }
  
  public boolean isFinished()
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.a.get();
    return (localAsyncHttpRequest == null) || (localAsyncHttpRequest.isDone());
  }
  
  public RequestHandle setTag(Object paramObject)
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.a.get();
    if (localAsyncHttpRequest != null) {
      localAsyncHttpRequest.setRequestTag(paramObject);
    }
    return this;
  }
  
  public boolean shouldBeGarbageCollected()
  {
    if ((isCancelled()) || (isFinished())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.a.clear();
      }
      return bool;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/RequestHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */