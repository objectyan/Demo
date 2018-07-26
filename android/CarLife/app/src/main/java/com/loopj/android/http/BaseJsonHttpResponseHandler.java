package com.loopj.android.http;

import cz.msebera.android.httpclient.f;

public abstract class BaseJsonHttpResponseHandler<JSON_TYPE>
  extends TextHttpResponseHandler
{
  private static final String LOG_TAG = "BaseJsonHttpRH";
  
  public BaseJsonHttpResponseHandler()
  {
    this("UTF-8");
  }
  
  public BaseJsonHttpResponseHandler(String paramString)
  {
    super(paramString);
  }
  
  public final void onFailure(final int paramInt, final f[] paramArrayOff, final String paramString, final Throwable paramThrowable)
  {
    if (paramString != null)
    {
      paramArrayOff = new Runnable()
      {
        public void run()
        {
          try
          {
            final Object localObject = BaseJsonHttpResponseHandler.this.parseResponse(paramString, true);
            BaseJsonHttpResponseHandler.this.postRunnable(new Runnable()
            {
              public void run()
              {
                BaseJsonHttpResponseHandler.this.onFailure(BaseJsonHttpResponseHandler.2.this.val$statusCode, BaseJsonHttpResponseHandler.2.this.val$headers, BaseJsonHttpResponseHandler.2.this.val$throwable, BaseJsonHttpResponseHandler.2.this.val$responseString, localObject);
              }
            });
            return;
          }
          catch (Throwable localThrowable)
          {
            AsyncHttpClient.log.d("BaseJsonHttpRH", "parseResponse thrown an problem", localThrowable);
            BaseJsonHttpResponseHandler.this.postRunnable(new Runnable()
            {
              public void run()
              {
                BaseJsonHttpResponseHandler.this.onFailure(BaseJsonHttpResponseHandler.2.this.val$statusCode, BaseJsonHttpResponseHandler.2.this.val$headers, BaseJsonHttpResponseHandler.2.this.val$throwable, BaseJsonHttpResponseHandler.2.this.val$responseString, null);
              }
            });
          }
        }
      };
      if ((!getUseSynchronousMode()) && (!getUsePoolThread()))
      {
        new Thread(paramArrayOff).start();
        return;
      }
      paramArrayOff.run();
      return;
    }
    onFailure(paramInt, paramArrayOff, paramThrowable, null, null);
  }
  
  public abstract void onFailure(int paramInt, f[] paramArrayOff, Throwable paramThrowable, String paramString, JSON_TYPE paramJSON_TYPE);
  
  public final void onSuccess(final int paramInt, final f[] paramArrayOff, final String paramString)
  {
    if (paramInt != 204)
    {
      paramArrayOff = new Runnable()
      {
        public void run()
        {
          try
          {
            final Object localObject = BaseJsonHttpResponseHandler.this.parseResponse(paramString, false);
            BaseJsonHttpResponseHandler.this.postRunnable(new Runnable()
            {
              public void run()
              {
                BaseJsonHttpResponseHandler.this.onSuccess(BaseJsonHttpResponseHandler.1.this.val$statusCode, BaseJsonHttpResponseHandler.1.this.val$headers, BaseJsonHttpResponseHandler.1.this.val$responseString, localObject);
              }
            });
            return;
          }
          catch (Throwable localThrowable)
          {
            AsyncHttpClient.log.d("BaseJsonHttpRH", "parseResponse thrown an problem", localThrowable);
            BaseJsonHttpResponseHandler.this.postRunnable(new Runnable()
            {
              public void run()
              {
                BaseJsonHttpResponseHandler.this.onFailure(BaseJsonHttpResponseHandler.1.this.val$statusCode, BaseJsonHttpResponseHandler.1.this.val$headers, localThrowable, BaseJsonHttpResponseHandler.1.this.val$responseString, null);
              }
            });
          }
        }
      };
      if ((!getUseSynchronousMode()) && (!getUsePoolThread()))
      {
        new Thread(paramArrayOff).start();
        return;
      }
      paramArrayOff.run();
      return;
    }
    onSuccess(paramInt, paramArrayOff, null, null);
  }
  
  public abstract void onSuccess(int paramInt, f[] paramArrayOff, String paramString, JSON_TYPE paramJSON_TYPE);
  
  protected abstract JSON_TYPE parseResponse(String paramString, boolean paramBoolean)
    throws Throwable;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/BaseJsonHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */