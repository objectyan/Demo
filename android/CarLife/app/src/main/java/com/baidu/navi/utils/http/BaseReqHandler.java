package com.baidu.navi.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class BaseReqHandler
  implements Runnable
{
  private final AbstractHttpClient mClient;
  private final HttpContext mHttpContext;
  private final HttpUriRequest mRequest;
  private final BaseRspHandler mResponseHandler;
  
  public BaseReqHandler(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, BaseRspHandler paramBaseRspHandler)
  {
    this.mClient = paramAbstractHttpClient;
    this.mHttpContext = paramHttpContext;
    this.mRequest = paramHttpUriRequest;
    this.mResponseHandler = paramBaseRspHandler;
    if ((paramBaseRspHandler instanceof FileRspHandler))
    {
      long l = ((FileRspHandler)paramBaseRspHandler).getPreviousFileSize();
      if (l > 0L) {
        this.mRequest.setHeader("RANGE", "bytes=" + l + "-");
      }
    }
  }
  
  private void makeRequest()
    throws Exception
  {
    if (!Thread.currentThread().isInterrupted()) {}
    try
    {
      HttpResponse localHttpResponse = this.mClient.execute(this.mRequest, this.mHttpContext);
      if ((!Thread.currentThread().isInterrupted()) && (this.mResponseHandler != null)) {
        this.mResponseHandler.handleResponse(localHttpResponse);
      }
      return;
    }
    catch (Exception localException)
    {
      while (Thread.currentThread().isInterrupted()) {}
      throw localException;
    }
  }
  
  public void run()
  {
    if (this.mResponseHandler != null) {
      this.mResponseHandler.handleStartMessage(null);
    }
    try
    {
      makeRequest();
      if (this.mResponseHandler != null) {
        this.mResponseHandler.handleFinishMessage(null);
      }
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (this.mResponseHandler != null)
        {
          Exception localException1;
          if (localException2 != null)
          {
            localException1 = localException2;
            if (localException2.getMessage() != null) {}
          }
          else
          {
            localException1 = new Exception("unknow error");
          }
          this.mResponseHandler.handleFailureMessage(localException1);
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/http/BaseReqHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */