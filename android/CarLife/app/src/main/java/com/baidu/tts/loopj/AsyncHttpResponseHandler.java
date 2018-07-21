package com.baidu.tts.loopj;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

public abstract class AsyncHttpResponseHandler
  implements ResponseHandlerInterface
{
  protected static final int BUFFER_SIZE = 4096;
  protected static final int CANCEL_MESSAGE = 6;
  public static final String DEFAULT_CHARSET = "UTF-8";
  protected static final int FAILURE_MESSAGE = 1;
  protected static final int FINISH_MESSAGE = 3;
  private static final String LOG_TAG = "AsyncHttpRH";
  protected static final int PROGRESS_MESSAGE = 4;
  protected static final int RETRY_MESSAGE = 5;
  protected static final int START_MESSAGE = 2;
  protected static final int SUCCESS_MESSAGE = 0;
  public static final String UTF8_BOM = "﻿";
  private WeakReference<Object> TAG = new WeakReference(null);
  private Handler handler;
  private Looper looper = null;
  private Header[] requestHeaders = null;
  private URI requestURI = null;
  private String responseCharset = "UTF-8";
  private boolean usePoolThread;
  private boolean useSynchronousMode;
  
  public AsyncHttpResponseHandler()
  {
    this(null);
  }
  
  public AsyncHttpResponseHandler(Looper paramLooper)
  {
    Looper localLooper = paramLooper;
    if (paramLooper == null) {
      localLooper = Looper.myLooper();
    }
    this.looper = localLooper;
    setUseSynchronousMode(false);
    setUsePoolThread(false);
  }
  
  public AsyncHttpResponseHandler(boolean paramBoolean)
  {
    setUsePoolThread(paramBoolean);
    if (!getUsePoolThread())
    {
      this.looper = Looper.myLooper();
      setUseSynchronousMode(false);
    }
  }
  
  public String getCharset()
  {
    if (this.responseCharset == null) {
      return "UTF-8";
    }
    return this.responseCharset;
  }
  
  public Header[] getRequestHeaders()
  {
    return this.requestHeaders;
  }
  
  public URI getRequestURI()
  {
    return this.requestURI;
  }
  
  byte[] getResponseData(HttpEntity paramHttpEntity)
    throws IOException
  {
    int i = 4096;
    if (paramHttpEntity != null)
    {
      InputStream localInputStream = paramHttpEntity.getContent();
      if (localInputStream != null)
      {
        long l2 = paramHttpEntity.getContentLength();
        if (l2 > 2147483647L) {
          throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        if (l2 <= 0L) {}
        try
        {
          for (;;)
          {
            ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(i);
            try
            {
              byte[] arrayOfByte = new byte['က'];
              long l1 = 0L;
              label74:
              i = localInputStream.read(arrayOfByte);
              if ((i != -1) && (!Thread.currentThread().isInterrupted()))
              {
                long l3 = i + l1;
                localByteArrayBuffer.append(arrayOfByte, 0, i);
                if (l2 <= 0L) {}
                for (l1 = 1L;; l1 = l2)
                {
                  sendProgressMessage(l3, l1);
                  l1 = l3;
                  break label74;
                  i = (int)l2;
                  break;
                }
              }
              return localByteArrayBuffer.toByteArray();
            }
            finally
            {
              AsyncHttpClient.silentCloseInputStream(localInputStream);
              AsyncHttpClient.endEntityViaReflection(paramHttpEntity);
            }
          }
          return null;
        }
        catch (OutOfMemoryError paramHttpEntity)
        {
          System.gc();
          throw new IOException("File too large to fit into available memory");
        }
      }
    }
  }
  
  public Object getTag()
  {
    return this.TAG.get();
  }
  
  public boolean getUsePoolThread()
  {
    return this.usePoolThread;
  }
  
  public boolean getUseSynchronousMode()
  {
    return this.useSynchronousMode;
  }
  
  protected void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 0: 
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage != null) && (paramMessage.length >= 3))
        {
          onSuccess(((Integer)paramMessage[0]).intValue(), (Header[])paramMessage[1], (byte[])paramMessage[2]);
          return;
        }
        break;
      }
    }
    catch (Throwable paramMessage)
    {
      onUserException(paramMessage);
      return;
    }
    AsyncHttpClient.log.e("AsyncHttpRH", "SUCCESS_MESSAGE didn't got enough params");
    return;
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length >= 4))
    {
      onFailure(((Integer)paramMessage[0]).intValue(), (Header[])paramMessage[1], (byte[])paramMessage[2], (Throwable)paramMessage[3]);
      return;
    }
    AsyncHttpClient.log.e("AsyncHttpRH", "FAILURE_MESSAGE didn't got enough params");
    return;
    onStart();
    return;
    onFinish();
    return;
    paramMessage = (Object[])paramMessage.obj;
    if (paramMessage != null)
    {
      int i = paramMessage.length;
      if (i >= 2) {
        try
        {
          onProgress(((Long)paramMessage[0]).longValue(), ((Long)paramMessage[1]).longValue());
          return;
        }
        catch (Throwable paramMessage)
        {
          AsyncHttpClient.log.e("AsyncHttpRH", "custom onProgress contains an error", paramMessage);
          return;
        }
      }
    }
    AsyncHttpClient.log.e("AsyncHttpRH", "PROGRESS_MESSAGE didn't got enough params");
    return;
    paramMessage = (Object[])paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.length == 1))
    {
      onRetry(((Integer)paramMessage[0]).intValue());
      return;
    }
    AsyncHttpClient.log.e("AsyncHttpRH", "RETRY_MESSAGE didn't get enough params");
    return;
    onCancel();
    return;
  }
  
  protected Message obtainMessage(int paramInt, Object paramObject)
  {
    return Message.obtain(this.handler, paramInt, paramObject);
  }
  
  public void onCancel()
  {
    AsyncHttpClient.log.d("AsyncHttpRH", "Request got cancelled");
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public void onFinish() {}
  
  public void onPostProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, HttpResponse paramHttpResponse) {}
  
  public void onPreProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, HttpResponse paramHttpResponse) {}
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    LogInterface localLogInterface = AsyncHttpClient.log;
    if (paramLong2 > 0L) {}
    for (double d = paramLong1 * 1.0D / paramLong2 * 100.0D;; d = -1.0D)
    {
      localLogInterface.v("AsyncHttpRH", String.format("Progress %d from %d (%2.0f%%)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Double.valueOf(d) }));
      return;
    }
  }
  
  public void onRetry(int paramInt)
  {
    AsyncHttpClient.log.d("AsyncHttpRH", String.format("Request retry no. %d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public void onStart() {}
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte);
  
  public void onUserException(Throwable paramThrowable)
  {
    AsyncHttpClient.log.e("AsyncHttpRH", "User-space exception detected!", paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  protected void postRunnable(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      if ((getUseSynchronousMode()) || (this.handler == null)) {
        paramRunnable.run();
      }
    }
    else {
      return;
    }
    this.handler.post(paramRunnable);
  }
  
  public final void sendCancelMessage()
  {
    sendMessage(obtainMessage(6, null));
  }
  
  public final void sendFailureMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    sendMessage(obtainMessage(1, new Object[] { Integer.valueOf(paramInt), paramArrayOfHeader, paramArrayOfByte, paramThrowable }));
  }
  
  public final void sendFinishMessage()
  {
    sendMessage(obtainMessage(3, null));
  }
  
  protected void sendMessage(Message paramMessage)
  {
    if ((getUseSynchronousMode()) || (this.handler == null)) {
      handleMessage(paramMessage);
    }
    while (Thread.currentThread().isInterrupted()) {
      return;
    }
    if (this.handler != null) {}
    for (boolean bool = true;; bool = false)
    {
      Utils.asserts(bool, "handler should not be null!");
      this.handler.sendMessage(paramMessage);
      return;
    }
  }
  
  public final void sendProgressMessage(long paramLong1, long paramLong2)
  {
    sendMessage(obtainMessage(4, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public void sendResponseMessage(HttpResponse paramHttpResponse)
    throws IOException
  {
    StatusLine localStatusLine;
    byte[] arrayOfByte;
    if (!Thread.currentThread().isInterrupted())
    {
      localStatusLine = paramHttpResponse.getStatusLine();
      arrayOfByte = getResponseData(paramHttpResponse.getEntity());
      if (!Thread.currentThread().isInterrupted())
      {
        if (localStatusLine.getStatusCode() < 300) {
          break label85;
        }
        sendFailureMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), arrayOfByte, new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase()));
      }
    }
    return;
    label85:
    sendSuccessMessage(localStatusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), arrayOfByte);
  }
  
  public final void sendRetryMessage(int paramInt)
  {
    sendMessage(obtainMessage(5, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public final void sendStartMessage()
  {
    sendMessage(obtainMessage(2, null));
  }
  
  public final void sendSuccessMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    sendMessage(obtainMessage(0, new Object[] { Integer.valueOf(paramInt), paramArrayOfHeader, paramArrayOfByte }));
  }
  
  public void setCharset(String paramString)
  {
    this.responseCharset = paramString;
  }
  
  public void setRequestHeaders(Header[] paramArrayOfHeader)
  {
    this.requestHeaders = paramArrayOfHeader;
  }
  
  public void setRequestURI(URI paramURI)
  {
    this.requestURI = paramURI;
  }
  
  public void setTag(Object paramObject)
  {
    this.TAG = new WeakReference(paramObject);
  }
  
  public void setUsePoolThread(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.looper = null;
      this.handler = null;
    }
    this.usePoolThread = paramBoolean;
  }
  
  public void setUseSynchronousMode(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (this.looper == null)
      {
        bool = true;
        AsyncHttpClient.log.w("AsyncHttpRH", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
      }
    }
    if ((!bool) && (this.handler == null)) {}
    for (this.handler = new ResponderHandler(this, this.looper);; this.handler = null) {
      do
      {
        this.useSynchronousMode = bool;
        return;
      } while ((!bool) || (this.handler == null));
    }
  }
  
  private static class ResponderHandler
    extends Handler
  {
    private final AsyncHttpResponseHandler mResponder;
    
    ResponderHandler(AsyncHttpResponseHandler paramAsyncHttpResponseHandler, Looper paramLooper)
    {
      super();
      this.mResponder = paramAsyncHttpResponseHandler;
    }
    
    public void handleMessage(Message paramMessage)
    {
      this.mResponder.handleMessage(paramMessage);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/loopj/AsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */