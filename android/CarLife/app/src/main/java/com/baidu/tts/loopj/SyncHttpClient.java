package com.baidu.tts.loopj;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncHttpClient
  extends AsyncHttpClient
{
  private RequestHandle mRequestHandle;
  
  public SyncHttpClient()
  {
    super(false, 80, 443);
  }
  
  public SyncHttpClient(int paramInt)
  {
    super(false, paramInt, 443);
  }
  
  public SyncHttpClient(int paramInt1, int paramInt2)
  {
    super(false, paramInt1, paramInt2);
  }
  
  public SyncHttpClient(SchemeRegistry paramSchemeRegistry)
  {
    super(paramSchemeRegistry);
  }
  
  public SyncHttpClient(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramBoolean, paramInt1, paramInt2);
  }
  
  protected RequestHandle sendRequest(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, ResponseHandlerInterface paramResponseHandlerInterface, Context paramContext)
  {
    if (paramString != null) {
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    }
    paramResponseHandlerInterface.setUseSynchronousMode(true);
    paramDefaultHttpClient = newAsyncHttpRequest(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramString, paramResponseHandlerInterface, paramContext);
    this.mRequestHandle = new RequestHandle(paramDefaultHttpClient);
    paramDefaultHttpClient.run();
    return null;
  }
  
  public void stop()
  {
    if (this.mRequestHandle != null)
    {
      this.mRequestHandle.cancel(true);
      this.mRequestHandle = null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/SyncHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */