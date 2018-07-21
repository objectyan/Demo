package com.loopj.android.http;

import android.content.Context;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.e.c.j;
import cz.msebera.android.httpclient.i.b.s;
import cz.msebera.android.httpclient.n.g;

public class SyncHttpClient
  extends AsyncHttpClient
{
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
  
  public SyncHttpClient(j paramj)
  {
    super(paramj);
  }
  
  public SyncHttpClient(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramBoolean, paramInt1, paramInt2);
  }
  
  protected RequestHandle sendRequest(s params, g paramg, q paramq, String paramString, ResponseHandlerInterface paramResponseHandlerInterface, Context paramContext)
  {
    if (paramString != null) {
      paramq.addHeader("Content-Type", paramString);
    }
    paramResponseHandlerInterface.setUseSynchronousMode(true);
    newAsyncHttpRequest(params, paramg, paramq, paramString, paramResponseHandlerInterface, paramContext).run();
    return new RequestHandle(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/SyncHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */