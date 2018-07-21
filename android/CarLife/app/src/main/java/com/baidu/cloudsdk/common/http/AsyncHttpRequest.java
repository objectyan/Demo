package com.baidu.cloudsdk.common.http;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

class AsyncHttpRequest
  implements Runnable
{
  private AbstractHttpClient mHttpClient;
  private HttpContext mHttpContext;
  private boolean mIsBinaryRequest;
  private HttpUriRequest mRequest;
  private HttpResponseHandler mResponseHandler;
  
  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, HttpResponseHandler paramHttpResponseHandler)
  {
    this.mHttpClient = paramAbstractHttpClient;
    this.mHttpContext = paramHttpContext;
    this.mRequest = paramHttpUriRequest;
    this.mResponseHandler = paramHttpResponseHandler;
    this.mIsBinaryRequest = (paramHttpResponseHandler instanceof BinaryHttpResponseHandler);
  }
  
  private void makeRequest()
    throws IOException, InterruptedException
  {
    if (!Thread.currentThread().isInterrupted())
    {
      HttpResponse localHttpResponse = this.mHttpClient.execute(this.mRequest, this.mHttpContext);
      if (Thread.currentThread().isInterrupted()) {
        break label50;
      }
      if (this.mResponseHandler != null) {
        this.mResponseHandler.sendResponseMessage(localHttpResponse);
      }
    }
    return;
    label50:
    throw new InterruptedException("the request has been cancelled");
  }
  
  public void run()
  {
    try
    {
      if (this.mResponseHandler != null) {
        this.mResponseHandler.sendStartMessage();
      }
      makeRequest();
      if (this.mResponseHandler != null) {
        this.mResponseHandler.sendFinishMessage();
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.mResponseHandler == null) {}
      this.mResponseHandler.sendFinishMessage();
      if (this.mIsBinaryRequest)
      {
        this.mResponseHandler.sendFailureMessage(localException, (byte[])null);
        return;
      }
      this.mResponseHandler.sendFailureMessage(localException, (String)null);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/cloudsdk/common/http/AsyncHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */