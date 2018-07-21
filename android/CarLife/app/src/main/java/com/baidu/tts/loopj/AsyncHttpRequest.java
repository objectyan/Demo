package com.baidu.tts.loopj;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest
  implements Runnable
{
  private boolean cancelIsNotified;
  private final AbstractHttpClient client;
  private final HttpContext context;
  private int executionCount;
  private final AtomicBoolean isCancelled = new AtomicBoolean();
  private volatile boolean isFinished;
  private boolean isRequestPreProcessed;
  private final HttpUriRequest request;
  private final ResponseHandlerInterface responseHandler;
  
  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    this.client = ((AbstractHttpClient)Utils.notNull(paramAbstractHttpClient, "client"));
    this.context = ((HttpContext)Utils.notNull(paramHttpContext, "context"));
    this.request = ((HttpUriRequest)Utils.notNull(paramHttpUriRequest, "request"));
    this.responseHandler = ((ResponseHandlerInterface)Utils.notNull(paramResponseHandlerInterface, "responseHandler"));
  }
  
  private void makeRequest()
    throws IOException
  {
    if (isCancelled()) {}
    HttpResponse localHttpResponse;
    do
    {
      do
      {
        do
        {
          return;
          if (this.request.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
          }
          if ((this.responseHandler instanceof RangeFileAsyncHttpResponseHandler)) {
            ((RangeFileAsyncHttpResponseHandler)this.responseHandler).updateRequestHeaders(this.request);
          }
          localHttpResponse = this.client.execute(this.request, this.context);
        } while (isCancelled());
        this.responseHandler.onPreProcessResponse(this.responseHandler, localHttpResponse);
      } while (isCancelled());
      this.responseHandler.sendResponseMessage(localHttpResponse);
    } while (isCancelled());
    this.responseHandler.onPostProcessResponse(this.responseHandler, localHttpResponse);
  }
  
  private void makeRequestWithRetries()
    throws IOException
  {
    Object localObject1 = null;
    HttpRequestRetryHandler localHttpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
    int j = 1;
    if (j != 0) {}
    label289:
    for (;;)
    {
      try
      {
        makeRequest();
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        IOException localIOException1 = new IOException("UnknownHostException exception: " + localUnknownHostException.getMessage());
        if (this.executionCount >= 0)
        {
          i = this.executionCount + 1;
          this.executionCount = i;
          if (localHttpRequestRetryHandler.retryRequest(localUnknownHostException, i, this.context))
          {
            bool = true;
            break label289;
            localObject2 = localIOException1;
            j = bool;
            if (!bool) {
              break;
            }
            this.responseHandler.sendRetryMessage(this.executionCount);
            localObject2 = localIOException1;
            j = bool;
            break;
          }
        }
      }
      catch (Exception localException)
      {
        AsyncHttpClient.log.e("AsyncHttpRequest", "Unhandled exception origin cause", localException);
        Object localObject2 = new IOException("Unhandled exception: " + localException.getMessage());
        throw ((Throwable)localObject2);
        bool = false;
      }
      catch (NullPointerException localNullPointerException)
      {
        IOException localIOException2 = new IOException("NPE in HttpClient: " + localNullPointerException.getMessage());
        i = this.executionCount + 1;
        this.executionCount = i;
        bool = localHttpRequestRetryHandler.retryRequest(localIOException2, i, this.context);
      }
      catch (IOException localIOException3)
      {
        int i;
        boolean bool;
        if (!isCancelled())
        {
          i = this.executionCount + 1;
          this.executionCount = i;
          bool = localHttpRequestRetryHandler.retryRequest(localIOException3, i, this.context);
        }
      }
    }
  }
  
  private void sendCancelNotification()
  {
    try
    {
      if ((!this.isFinished) && (this.isCancelled.get()) && (!this.cancelIsNotified))
      {
        this.cancelIsNotified = true;
        this.responseHandler.sendCancelMessage();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.isCancelled.set(true);
    this.request.abort();
    return isCancelled();
  }
  
  public Object getTag()
  {
    return this.responseHandler.getTag();
  }
  
  public boolean isCancelled()
  {
    boolean bool = this.isCancelled.get();
    if (bool) {
      sendCancelNotification();
    }
    return bool;
  }
  
  public boolean isDone()
  {
    return (isCancelled()) || (this.isFinished);
  }
  
  public void onPostProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void onPreProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void run()
  {
    if (isCancelled()) {}
    for (;;)
    {
      return;
      if (!this.isRequestPreProcessed)
      {
        this.isRequestPreProcessed = true;
        onPreProcessRequest(this);
      }
      if (isCancelled()) {
        continue;
      }
      this.responseHandler.sendStartMessage();
      if (isCancelled()) {
        continue;
      }
      try
      {
        makeRequestWithRetries();
        if (isCancelled()) {
          continue;
        }
        this.responseHandler.sendFinishMessage();
        if (isCancelled()) {
          continue;
        }
        onPostProcessRequest(this);
        this.isFinished = true;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (!isCancelled()) {
            this.responseHandler.sendFailureMessage(0, null, null, localIOException);
          } else {
            AsyncHttpClient.log.e("AsyncHttpRequest", "makeRequestWithRetries returned error", localIOException);
          }
        }
      }
    }
  }
  
  public AsyncHttpRequest setRequestTag(Object paramObject)
  {
    this.responseHandler.setTag(paramObject);
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/AsyncHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */