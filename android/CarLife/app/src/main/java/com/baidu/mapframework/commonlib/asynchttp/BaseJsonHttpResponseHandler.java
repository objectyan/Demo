package com.baidu.mapframework.commonlib.asynchttp;

import org.apache.http.Header;

public abstract class BaseJsonHttpResponseHandler<JSON_TYPE>
  extends TextHttpResponseHandler
{
  private static final String a = "BaseJsonHttpRH";
  
  public BaseJsonHttpResponseHandler()
  {
    this("UTF-8");
  }
  
  public BaseJsonHttpResponseHandler(String paramString)
  {
    super(paramString);
  }
  
  public final void onFailure(final int paramInt, final Header[] paramArrayOfHeader, final String paramString, final Throwable paramThrowable)
  {
    if (paramString != null)
    {
      paramArrayOfHeader = new Runnable()
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
                BaseJsonHttpResponseHandler.this.onFailure(BaseJsonHttpResponseHandler.2.this.b, BaseJsonHttpResponseHandler.2.this.c, BaseJsonHttpResponseHandler.2.this.d, BaseJsonHttpResponseHandler.2.this.a, localObject);
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
                BaseJsonHttpResponseHandler.this.onFailure(BaseJsonHttpResponseHandler.2.this.b, BaseJsonHttpResponseHandler.2.this.c, BaseJsonHttpResponseHandler.2.this.d, BaseJsonHttpResponseHandler.2.this.a, null);
              }
            });
          }
        }
      };
      if ((!getUseSynchronousMode()) && (!getUsePoolThread()))
      {
        new Thread(paramArrayOfHeader).start();
        return;
      }
      paramArrayOfHeader.run();
      return;
    }
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, null, null);
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, String paramString, JSON_TYPE paramJSON_TYPE);
  
  public final void onSuccess(final int paramInt, final Header[] paramArrayOfHeader, final String paramString)
  {
    if (paramInt != 204)
    {
      paramArrayOfHeader = new Runnable()
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
                BaseJsonHttpResponseHandler.this.onSuccess(BaseJsonHttpResponseHandler.1.this.b, BaseJsonHttpResponseHandler.1.this.c, BaseJsonHttpResponseHandler.1.this.a, localObject);
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
                BaseJsonHttpResponseHandler.this.onFailure(BaseJsonHttpResponseHandler.1.this.b, BaseJsonHttpResponseHandler.1.this.c, localThrowable, BaseJsonHttpResponseHandler.1.this.a, null);
              }
            });
          }
        }
      };
      if ((!getUseSynchronousMode()) && (!getUsePoolThread()))
      {
        new Thread(paramArrayOfHeader).start();
        return;
      }
      paramArrayOfHeader.run();
      return;
    }
    onSuccess(paramInt, paramArrayOfHeader, null, null);
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString, JSON_TYPE paramJSON_TYPE);
  
  protected abstract JSON_TYPE parseResponse(String paramString, boolean paramBoolean)
    throws Throwable;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/BaseJsonHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */