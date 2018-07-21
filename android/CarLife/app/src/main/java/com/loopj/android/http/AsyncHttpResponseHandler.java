package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.b.l;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;

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
  private f[] requestHeaders = null;
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
  
  public f[] getRequestHeaders()
  {
    return this.requestHeaders;
  }
  
  public URI getRequestURI()
  {
    return this.requestURI;
  }
  
  /* Error */
  byte[] getResponseData(cz.msebera.android.httpclient.n paramn)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload 10
    //   5: astore 9
    //   7: aload_1
    //   8: ifnull +193 -> 201
    //   11: aload_1
    //   12: invokeinterface 109 1 0
    //   17: astore 11
    //   19: aload 10
    //   21: astore 9
    //   23: aload 11
    //   25: ifnull +176 -> 201
    //   28: aload_1
    //   29: invokeinterface 113 1 0
    //   34: lstore 5
    //   36: lload 5
    //   38: ldc2_w 114
    //   41: lcmp
    //   42: ifle +13 -> 55
    //   45: new 117	java/lang/IllegalArgumentException
    //   48: dup
    //   49: ldc 119
    //   51: invokespecial 122	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   54: athrow
    //   55: lload 5
    //   57: lconst_0
    //   58: lcmp
    //   59: ifgt +113 -> 172
    //   62: sipush 4096
    //   65: istore_2
    //   66: new 124	cz/msebera/android/httpclient/o/c
    //   69: dup
    //   70: iload_2
    //   71: invokespecial 127	cz/msebera/android/httpclient/o/c:<init>	(I)V
    //   74: astore 9
    //   76: sipush 4096
    //   79: newarray <illegal type>
    //   81: astore 10
    //   83: lconst_0
    //   84: lstore_3
    //   85: aload 11
    //   87: aload 10
    //   89: invokevirtual 133	java/io/InputStream:read	([B)I
    //   92: istore_2
    //   93: iload_2
    //   94: iconst_m1
    //   95: if_icmpeq +90 -> 185
    //   98: invokestatic 139	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   101: invokevirtual 142	java/lang/Thread:isInterrupted	()Z
    //   104: ifne +81 -> 185
    //   107: lload_3
    //   108: iload_2
    //   109: i2l
    //   110: ladd
    //   111: lstore 7
    //   113: aload 9
    //   115: aload 10
    //   117: iconst_0
    //   118: iload_2
    //   119: invokevirtual 146	cz/msebera/android/httpclient/o/c:a	([BII)V
    //   122: lload 5
    //   124: lconst_0
    //   125: lcmp
    //   126: ifgt +53 -> 179
    //   129: lconst_1
    //   130: lstore_3
    //   131: aload_0
    //   132: lload 7
    //   134: lload_3
    //   135: invokevirtual 150	com/loopj/android/http/AsyncHttpResponseHandler:sendProgressMessage	(JJ)V
    //   138: lload 7
    //   140: lstore_3
    //   141: goto -56 -> 85
    //   144: astore 9
    //   146: aload 11
    //   148: invokestatic 156	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   151: aload_1
    //   152: invokestatic 160	com/loopj/android/http/AsyncHttpClient:endEntityViaReflection	(Lcz/msebera/android/httpclient/n;)V
    //   155: aload 9
    //   157: athrow
    //   158: astore_1
    //   159: invokestatic 165	java/lang/System:gc	()V
    //   162: new 101	java/io/IOException
    //   165: dup
    //   166: ldc -89
    //   168: invokespecial 168	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   171: athrow
    //   172: lload 5
    //   174: l2i
    //   175: istore_2
    //   176: goto -110 -> 66
    //   179: lload 5
    //   181: lstore_3
    //   182: goto -51 -> 131
    //   185: aload 11
    //   187: invokestatic 156	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   190: aload_1
    //   191: invokestatic 160	com/loopj/android/http/AsyncHttpClient:endEntityViaReflection	(Lcz/msebera/android/httpclient/n;)V
    //   194: aload 9
    //   196: invokevirtual 172	cz/msebera/android/httpclient/o/c:b	()[B
    //   199: astore 9
    //   201: aload 9
    //   203: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	AsyncHttpResponseHandler
    //   0	204	1	paramn	cz.msebera.android.httpclient.n
    //   65	111	2	i	int
    //   84	98	3	l1	long
    //   34	146	5	l2	long
    //   111	28	7	l3	long
    //   5	109	9	localObject1	Object
    //   144	51	9	localObject2	Object
    //   199	3	9	arrayOfByte1	byte[]
    //   1	115	10	arrayOfByte2	byte[]
    //   17	169	11	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   76	83	144	finally
    //   85	93	144	finally
    //   98	107	144	finally
    //   113	122	144	finally
    //   131	138	144	finally
    //   66	76	158	java/lang/OutOfMemoryError
    //   146	158	158	java/lang/OutOfMemoryError
    //   185	201	158	java/lang/OutOfMemoryError
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
          onSuccess(((Integer)paramMessage[0]).intValue(), (f[])paramMessage[1], (byte[])paramMessage[2]);
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
      onFailure(((Integer)paramMessage[0]).intValue(), (f[])paramMessage[1], (byte[])paramMessage[2], (Throwable)paramMessage[3]);
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
  
  public abstract void onFailure(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte, Throwable paramThrowable);
  
  public void onFinish() {}
  
  public void onPostProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, x paramx) {}
  
  public void onPreProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, x paramx) {}
  
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
  
  public abstract void onSuccess(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte);
  
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
  
  public final void sendFailureMessage(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    sendMessage(obtainMessage(1, new Object[] { Integer.valueOf(paramInt), paramArrayOff, paramArrayOfByte, paramThrowable }));
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
  
  public void sendResponseMessage(x paramx)
    throws IOException
  {
    an localan;
    byte[] arrayOfByte;
    if (!Thread.currentThread().isInterrupted())
    {
      localan = paramx.a();
      arrayOfByte = getResponseData(paramx.b());
      if (!Thread.currentThread().isInterrupted())
      {
        if (localan.b() < 300) {
          break label85;
        }
        sendFailureMessage(localan.b(), paramx.getAllHeaders(), arrayOfByte, new l(localan.b(), localan.c()));
      }
    }
    return;
    label85:
    sendSuccessMessage(localan.b(), paramx.getAllHeaders(), arrayOfByte);
  }
  
  public final void sendRetryMessage(int paramInt)
  {
    sendMessage(obtainMessage(5, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public final void sendStartMessage()
  {
    sendMessage(obtainMessage(2, null));
  }
  
  public final void sendSuccessMessage(int paramInt, f[] paramArrayOff, byte[] paramArrayOfByte)
  {
    sendMessage(obtainMessage(0, new Object[] { Integer.valueOf(paramInt), paramArrayOff, paramArrayOfByte }));
  }
  
  public void setCharset(String paramString)
  {
    this.responseCharset = paramString;
  }
  
  public void setRequestHeaders(f[] paramArrayOff)
  {
    this.requestHeaders = paramArrayOff;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/AsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */