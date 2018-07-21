package com.loopj.android.http;

import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.net.URI;

public abstract interface ResponseHandlerInterface
{
  public abstract f[] getRequestHeaders();
  
  public abstract URI getRequestURI();
  
  public abstract Object getTag();
  
  public abstract boolean getUsePoolThread();
  
  public abstract boolean getUseSynchronousMode();
  
  public abstract void onPostProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, x paramx);
  
  public abstract void onPreProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, x paramx);
  
  public abstract void sendCancelMessage();
  
  public abstract void sendFailureMessage(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public abstract void sendFinishMessage();
  
  public abstract void sendProgressMessage(long paramLong1, long paramLong2);
  
  public abstract void sendResponseMessage(x paramx)
    throws IOException;
  
  public abstract void sendRetryMessage(int paramInt);
  
  public abstract void sendStartMessage();
  
  public abstract void sendSuccessMessage(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte);
  
  public abstract void setRequestHeaders(f[] paramArrayOff);
  
  public abstract void setRequestURI(URI paramURI);
  
  public abstract void setTag(Object paramObject);
  
  public abstract void setUsePoolThread(boolean paramBoolean);
  
  public abstract void setUseSynchronousMode(boolean paramBoolean);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/ResponseHandlerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */