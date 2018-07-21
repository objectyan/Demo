package com.baidu.tts.loopj;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class BlackholeHttpResponseHandler
  extends AsyncHttpResponseHandler
{
  public void onCancel() {}
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable) {}
  
  public void onFinish() {}
  
  public void onPostProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, HttpResponse paramHttpResponse) {}
  
  public void onPreProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, HttpResponse paramHttpResponse) {}
  
  public void onProgress(long paramLong1, long paramLong2) {}
  
  public void onRetry(int paramInt) {}
  
  public void onStart() {}
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte) {}
  
  public void onUserException(Throwable paramThrowable) {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/BlackholeHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */