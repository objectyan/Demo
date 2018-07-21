package com.baidu.mapframework.nirvana.network;

import com.baidu.mapframework.nirvana.g;
import org.apache.http.client.methods.HttpUriRequest;

public final class NetworkTask
  extends g
{
  Runnable a;
  private String b;
  private HttpUriRequest c;
  private IResponseHandler d;
  
  public NetworkTask(String paramString, HttpUriRequest paramHttpUriRequest, IResponseHandler paramIResponseHandler, Runnable paramRunnable)
  {
    this.b = paramString;
    this.c = paramHttpUriRequest;
    this.d = paramIResponseHandler;
    this.a = paramRunnable;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/network/NetworkTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */