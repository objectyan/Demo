package com.baidu.cloudsdk.common.http;

import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

public class BinaryHttpResponseHandler
  extends HttpResponseHandler
{
  private String[] mAllowedContentTypes = { "image/jpeg", "image/png" };
  
  public BinaryHttpResponseHandler() {}
  
  public BinaryHttpResponseHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public BinaryHttpResponseHandler(Looper paramLooper, String[] paramArrayOfString)
  {
    super(paramLooper);
    this.mAllowedContentTypes = paramArrayOfString;
  }
  
  public BinaryHttpResponseHandler(String[] paramArrayOfString)
  {
    this.mAllowedContentTypes = paramArrayOfString;
  }
  
  protected void handleFailureMessage(Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    onFailure(paramThrowable, paramArrayOfByte);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      paramMessage = (Object[])paramMessage.obj;
      handleSuccessMessage(((Integer)paramMessage[0]).intValue(), (byte[])paramMessage[1]);
      return;
      Object[] arrayOfObject = (Object[])paramMessage.obj;
      handleFailureMessage((Throwable)arrayOfObject[0], (byte[])arrayOfObject[1]);
    }
  }
  
  protected void handleSuccessMessage(int paramInt, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOfByte);
  }
  
  protected void onFailure(Throwable paramThrowable, byte[] paramArrayOfByte) {}
  
  protected void onSuccess(int paramInt, byte[] paramArrayOfByte)
  {
    onSuccess(paramArrayOfByte);
  }
  
  protected void onSuccess(byte[] paramArrayOfByte) {}
  
  protected void sendResponseMessage(HttpResponse paramHttpResponse)
  {
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    Object localObject1 = paramHttpResponse.getHeaders("Content-Type");
    if (localObject1.length != 1)
    {
      sendFailureMessage(new HttpResponseException(localStatusLine.getStatusCode(), "None or more than one Content-Type Header found!"), (byte[])null);
      return;
    }
    localObject1 = localObject1[0];
    int k = 0;
    Object localObject2 = this.mAllowedContentTypes;
    int m = localObject2.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (localObject2[i].equalsIgnoreCase(((Header)localObject1).getValue())) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        sendFailureMessage(new HttpResponseException(localStatusLine.getStatusCode(), "Content-Type not allowed!"), (byte[])null);
        return;
      }
      i += 1;
    }
    localObject1 = null;
    localObject2 = paramHttpResponse.getEntity();
    paramHttpResponse = (HttpResponse)localObject1;
    if (localObject2 != null) {}
    try
    {
      paramHttpResponse = EntityUtils.toByteArray((HttpEntity)localObject2);
      AsyncHttpClient.endEntityViaReflection((HttpEntity)localObject2);
      if (localStatusLine.getStatusCode() >= 300)
      {
        sendFailureMessage(new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()), paramHttpResponse);
        return;
      }
    }
    catch (IOException paramHttpResponse)
    {
      sendFailureMessage(paramHttpResponse, (byte[])null);
      return;
    }
    finally
    {
      AsyncHttpClient.endEntityViaReflection((HttpEntity)localObject2);
    }
    sendSuccessMessage(localStatusLine.getStatusCode(), paramHttpResponse);
  }
  
  protected void sendSuccessMessage(int paramInt, byte[] paramArrayOfByte)
  {
    sendMessage(obtainMessage(0, new Object[] { Integer.valueOf(paramInt), paramArrayOfByte }));
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/cloudsdk/common/http/BinaryHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */