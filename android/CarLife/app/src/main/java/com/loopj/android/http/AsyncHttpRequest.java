package com.loopj.android.http;

import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.n.g;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;

public class AsyncHttpRequest
  implements Runnable
{
  private boolean cancelIsNotified;
  private final cz.msebera.android.httpclient.i.b.c client;
  private final g context;
  private int executionCount;
  private final AtomicBoolean isCancelled = new AtomicBoolean();
  private volatile boolean isFinished;
  private boolean isRequestPreProcessed;
  private final q request;
  private final ResponseHandlerInterface responseHandler;
  
  public AsyncHttpRequest(cz.msebera.android.httpclient.i.b.c paramc, g paramg, q paramq, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    this.client = ((cz.msebera.android.httpclient.i.b.c)Utils.notNull(paramc, "client"));
    this.context = ((g)Utils.notNull(paramg, "context"));
    this.request = ((q)Utils.notNull(paramq, "request"));
    this.responseHandler = ((ResponseHandlerInterface)Utils.notNull(paramResponseHandlerInterface, "responseHandler"));
  }
  
  private void makeRequest()
    throws IOException
  {
    if (isCancelled()) {}
    cz.msebera.android.httpclient.b.d.c localc;
    do
    {
      do
      {
        do
        {
          return;
          if (this.request.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
          }
          if ((this.responseHandler instanceof RangeFileAsyncHttpResponseHandler)) {
            ((RangeFileAsyncHttpResponseHandler)this.responseHandler).updateRequestHeaders(this.request);
          }
          localc = this.client.b(this.request, this.context);
        } while (isCancelled());
        this.responseHandler.onPreProcessResponse(this.responseHandler, localc);
      } while (isCancelled());
      this.responseHandler.sendResponseMessage(localc);
    } while (isCancelled());
    this.responseHandler.onPostProcessResponse(this.responseHandler, localc);
  }
  
  /* Error */
  private void makeRequestWithRetries()
    throws IOException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 43	com/loopj/android/http/AsyncHttpRequest:client	Lcz/msebera/android/httpclient/i/b/c;
    //   6: invokevirtual 115	cz/msebera/android/httpclient/i/b/c:C	()Lcz/msebera/android/httpclient/b/k;
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: iload_2
    //   14: ifeq +203 -> 217
    //   17: aload_0
    //   18: invokespecial 117	com/loopj/android/http/AsyncHttpRequest:makeRequest	()V
    //   21: return
    //   22: astore 5
    //   24: new 62	java/io/IOException
    //   27: dup
    //   28: new 119	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   35: ldc 122
    //   37: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 5
    //   42: invokevirtual 129	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   45: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 133	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 135	com/loopj/android/http/AsyncHttpRequest:executionCount	I
    //   59: ifle +54 -> 113
    //   62: aload_0
    //   63: getfield 135	com/loopj/android/http/AsyncHttpRequest:executionCount	I
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: aload_0
    //   70: iload_1
    //   71: putfield 135	com/loopj/android/http/AsyncHttpRequest:executionCount	I
    //   74: aload 4
    //   76: aload 5
    //   78: iload_1
    //   79: aload_0
    //   80: getfield 48	com/loopj/android/http/AsyncHttpRequest:context	Lcz/msebera/android/httpclient/n/g;
    //   83: invokeinterface 141 4 0
    //   88: ifeq +25 -> 113
    //   91: iconst_1
    //   92: istore_2
    //   93: iload_2
    //   94: ifeq +176 -> 270
    //   97: aload_0
    //   98: getfield 58	com/loopj/android/http/AsyncHttpRequest:responseHandler	Lcom/loopj/android/http/ResponseHandlerInterface;
    //   101: aload_0
    //   102: getfield 135	com/loopj/android/http/AsyncHttpRequest:executionCount	I
    //   105: invokeinterface 145 2 0
    //   110: goto -97 -> 13
    //   113: iconst_0
    //   114: istore_2
    //   115: goto -22 -> 93
    //   118: astore_3
    //   119: new 62	java/io/IOException
    //   122: dup
    //   123: new 119	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   130: ldc -109
    //   132: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 148	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokespecial 133	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   148: astore_3
    //   149: aload_0
    //   150: getfield 135	com/loopj/android/http/AsyncHttpRequest:executionCount	I
    //   153: iconst_1
    //   154: iadd
    //   155: istore_1
    //   156: aload_0
    //   157: iload_1
    //   158: putfield 135	com/loopj/android/http/AsyncHttpRequest:executionCount	I
    //   161: aload 4
    //   163: aload_3
    //   164: iload_1
    //   165: aload_0
    //   166: getfield 48	com/loopj/android/http/AsyncHttpRequest:context	Lcz/msebera/android/httpclient/n/g;
    //   169: invokeinterface 141 4 0
    //   174: istore_2
    //   175: goto -82 -> 93
    //   178: astore_3
    //   179: aload_0
    //   180: invokevirtual 65	com/loopj/android/http/AsyncHttpRequest:isCancelled	()Z
    //   183: istore_2
    //   184: iload_2
    //   185: ifne -164 -> 21
    //   188: aload_0
    //   189: getfield 135	com/loopj/android/http/AsyncHttpRequest:executionCount	I
    //   192: iconst_1
    //   193: iadd
    //   194: istore_1
    //   195: aload_0
    //   196: iload_1
    //   197: putfield 135	com/loopj/android/http/AsyncHttpRequest:executionCount	I
    //   200: aload 4
    //   202: aload_3
    //   203: iload_1
    //   204: aload_0
    //   205: getfield 48	com/loopj/android/http/AsyncHttpRequest:context	Lcz/msebera/android/httpclient/n/g;
    //   208: invokeinterface 141 4 0
    //   213: istore_2
    //   214: goto -121 -> 93
    //   217: aload_3
    //   218: athrow
    //   219: astore_3
    //   220: getstatic 154	com/loopj/android/http/AsyncHttpClient:log	Lcom/loopj/android/http/LogInterface;
    //   223: ldc -100
    //   225: ldc -98
    //   227: aload_3
    //   228: invokeinterface 164 4 0
    //   233: new 62	java/io/IOException
    //   236: dup
    //   237: new 119	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   244: ldc -90
    //   246: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_3
    //   250: invokevirtual 167	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokespecial 133	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   262: astore_3
    //   263: goto -46 -> 217
    //   266: astore_3
    //   267: goto -47 -> 220
    //   270: goto -257 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	AsyncHttpRequest
    //   68	136	1	i	int
    //   1	213	2	bool	boolean
    //   12	43	3	localIOException1	IOException
    //   118	18	3	localNullPointerException	NullPointerException
    //   148	16	3	localIOException2	IOException
    //   178	40	3	localIOException3	IOException
    //   219	31	3	localException1	Exception
    //   262	1	3	localIOException4	IOException
    //   266	1	3	localException2	Exception
    //   9	192	4	localk	cz.msebera.android.httpclient.b.k
    //   22	55	5	localUnknownHostException	java.net.UnknownHostException
    // Exception table:
    //   from	to	target	type
    //   17	21	22	java/net/UnknownHostException
    //   17	21	118	java/lang/NullPointerException
    //   17	21	178	java/io/IOException
    //   17	21	219	java/lang/Exception
    //   24	55	219	java/lang/Exception
    //   119	149	219	java/lang/Exception
    //   179	184	219	java/lang/Exception
    //   55	91	266	java/lang/Exception
    //   97	110	266	java/lang/Exception
    //   149	175	266	java/lang/Exception
    //   188	214	266	java/lang/Exception
  }
  
  private void sendCancelNotification()
  {
    try
    {
      if ((!this.isFinished) && (this.isCancelled.get()) && (!this.cancelIsNotified))
      {
        this.cancelIsNotified = true;
        this.responseHandler.sendCancelMessage();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.isCancelled.set(true);
    this.request.abort();
    return isCancelled();
  }
  
  public Object getTag()
  {
    return this.responseHandler.getTag();
  }
  
  public boolean isCancelled()
  {
    boolean bool = this.isCancelled.get();
    if (bool) {
      sendCancelNotification();
    }
    return bool;
  }
  
  public boolean isDone()
  {
    return (isCancelled()) || (this.isFinished);
  }
  
  public void onPostProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void onPreProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void run()
  {
    if (isCancelled()) {}
    for (;;)
    {
      return;
      if (!this.isRequestPreProcessed)
      {
        this.isRequestPreProcessed = true;
        onPreProcessRequest(this);
      }
      if (isCancelled()) {
        continue;
      }
      this.responseHandler.sendStartMessage();
      if (isCancelled()) {
        continue;
      }
      try
      {
        makeRequestWithRetries();
        if (isCancelled()) {
          continue;
        }
        this.responseHandler.sendFinishMessage();
        if (isCancelled()) {
          continue;
        }
        onPostProcessRequest(this);
        this.isFinished = true;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (!isCancelled()) {
            this.responseHandler.sendFailureMessage(0, null, null, localIOException);
          } else {
            AsyncHttpClient.log.e("AsyncHttpRequest", "makeRequestWithRetries returned error", localIOException);
          }
        }
      }
    }
  }
  
  public AsyncHttpRequest setRequestTag(Object paramObject)
  {
    this.responseHandler.setTag(paramObject);
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/AsyncHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */