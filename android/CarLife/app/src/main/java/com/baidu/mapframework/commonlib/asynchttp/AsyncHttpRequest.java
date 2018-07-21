package com.baidu.mapframework.commonlib.asynchttp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class AsyncHttpRequest
  implements Runnable
{
  private final AbstractHttpClient a;
  private final HttpContext b;
  private final HttpUriRequest c;
  private final ResponseHandlerInterface d;
  private final AtomicBoolean e = new AtomicBoolean();
  private int f;
  private boolean g;
  private volatile boolean h;
  private boolean i;
  
  public AsyncHttpRequest(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    this.a = ((AbstractHttpClient)Utils.notNull(paramAbstractHttpClient, "client"));
    this.b = ((HttpContext)Utils.notNull(paramHttpContext, "context"));
    this.c = ((HttpUriRequest)Utils.notNull(paramHttpUriRequest, "request"));
    this.d = ((ResponseHandlerInterface)Utils.notNull(paramResponseHandlerInterface, "responseHandler"));
  }
  
  private void a()
    throws IOException
  {
    if (isCancelled()) {}
    HttpResponse localHttpResponse;
    do
    {
      do
      {
        do
        {
          return;
          if (this.c.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
          }
          if ((this.d instanceof RangeFileAsyncHttpResponseHandler)) {
            ((RangeFileAsyncHttpResponseHandler)this.d).updateRequestHeaders(this.c);
          }
          localHttpResponse = this.a.execute(this.c, this.b);
        } while (isCancelled());
        this.d.onPreProcessResponse(this.d, localHttpResponse);
      } while (isCancelled());
      this.d.sendResponseMessage(localHttpResponse);
    } while (isCancelled());
    this.d.onPostProcessResponse(this.d, localHttpResponse);
  }
  
  /* Error */
  private void b()
    throws IOException
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 44	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:a	Lorg/apache/http/impl/client/AbstractHttpClient;
    //   6: invokevirtual 118	org/apache/http/impl/client/AbstractHttpClient:getHttpRequestRetryHandler	()Lorg/apache/http/client/HttpRequestRetryHandler;
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_3
    //   13: iload_2
    //   14: ifeq +203 -> 217
    //   17: aload_0
    //   18: invokespecial 120	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:a	()V
    //   21: return
    //   22: astore 5
    //   24: new 65	java/io/IOException
    //   27: dup
    //   28: new 122	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   35: ldc 125
    //   37: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 5
    //   42: invokevirtual 132	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   45: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 136	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 138	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:f	I
    //   59: ifle +54 -> 113
    //   62: aload_0
    //   63: getfield 138	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:f	I
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: aload_0
    //   70: iload_1
    //   71: putfield 138	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:f	I
    //   74: aload 4
    //   76: aload 5
    //   78: iload_1
    //   79: aload_0
    //   80: getfield 50	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:b	Lorg/apache/http/protocol/HttpContext;
    //   83: invokeinterface 144 4 0
    //   88: ifeq +25 -> 113
    //   91: iconst_1
    //   92: istore_2
    //   93: iload_2
    //   94: ifeq +176 -> 270
    //   97: aload_0
    //   98: getfield 62	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:d	Lcom/baidu/mapframework/commonlib/asynchttp/ResponseHandlerInterface;
    //   101: aload_0
    //   102: getfield 138	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:f	I
    //   105: invokeinterface 148 2 0
    //   110: goto -97 -> 13
    //   113: iconst_0
    //   114: istore_2
    //   115: goto -22 -> 93
    //   118: astore_3
    //   119: new 65	java/io/IOException
    //   122: dup
    //   123: new 122	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   130: ldc -106
    //   132: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 151	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokespecial 136	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   148: astore_3
    //   149: aload_0
    //   150: getfield 138	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:f	I
    //   153: iconst_1
    //   154: iadd
    //   155: istore_1
    //   156: aload_0
    //   157: iload_1
    //   158: putfield 138	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:f	I
    //   161: aload 4
    //   163: aload_3
    //   164: iload_1
    //   165: aload_0
    //   166: getfield 50	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:b	Lorg/apache/http/protocol/HttpContext;
    //   169: invokeinterface 144 4 0
    //   174: istore_2
    //   175: goto -82 -> 93
    //   178: astore_3
    //   179: aload_0
    //   180: invokevirtual 69	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:isCancelled	()Z
    //   183: istore_2
    //   184: iload_2
    //   185: ifne -164 -> 21
    //   188: aload_0
    //   189: getfield 138	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:f	I
    //   192: iconst_1
    //   193: iadd
    //   194: istore_1
    //   195: aload_0
    //   196: iload_1
    //   197: putfield 138	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:f	I
    //   200: aload 4
    //   202: aload_3
    //   203: iload_1
    //   204: aload_0
    //   205: getfield 50	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest:b	Lorg/apache/http/protocol/HttpContext;
    //   208: invokeinterface 144 4 0
    //   213: istore_2
    //   214: goto -121 -> 93
    //   217: aload_3
    //   218: athrow
    //   219: astore_3
    //   220: getstatic 157	com/baidu/mapframework/commonlib/asynchttp/AsyncHttpClient:log	Lcom/baidu/mapframework/commonlib/asynchttp/LogInterface;
    //   223: ldc -97
    //   225: ldc -95
    //   227: aload_3
    //   228: invokeinterface 166 4 0
    //   233: new 65	java/io/IOException
    //   236: dup
    //   237: new 122	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   244: ldc -88
    //   246: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_3
    //   250: invokevirtual 169	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokespecial 136	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   262: astore_3
    //   263: goto -46 -> 217
    //   266: astore_3
    //   267: goto -47 -> 220
    //   270: goto -257 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	AsyncHttpRequest
    //   68	136	1	j	int
    //   1	213	2	bool	boolean
    //   12	43	3	localIOException1	IOException
    //   118	18	3	localNullPointerException	NullPointerException
    //   148	16	3	localIOException2	IOException
    //   178	40	3	localIOException3	IOException
    //   219	31	3	localException1	Exception
    //   262	1	3	localIOException4	IOException
    //   266	1	3	localException2	Exception
    //   9	192	4	localHttpRequestRetryHandler	org.apache.http.client.HttpRequestRetryHandler
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
  
  private void c()
  {
    try
    {
      if ((!this.h) && (this.e.get()) && (!this.g))
      {
        this.g = true;
        this.d.sendCancelMessage();
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
    this.e.set(true);
    this.c.abort();
    return isCancelled();
  }
  
  public Object getTag()
  {
    return this.d.getTag();
  }
  
  public boolean isCancelled()
  {
    boolean bool = this.e.get();
    if (bool) {
      c();
    }
    return bool;
  }
  
  public boolean isDone()
  {
    return (isCancelled()) || (this.h);
  }
  
  public void onPostProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void onPreProcessRequest(AsyncHttpRequest paramAsyncHttpRequest) {}
  
  public void run()
  {
    if (isCancelled()) {}
    for (;;)
    {
      return;
      if (!this.i)
      {
        this.i = true;
        onPreProcessRequest(this);
      }
      if (isCancelled()) {
        continue;
      }
      this.d.sendStartMessage();
      if (isCancelled()) {
        continue;
      }
      try
      {
        b();
        if (isCancelled()) {
          continue;
        }
        this.d.sendFinishMessage();
        if (isCancelled()) {
          continue;
        }
        onPostProcessRequest(this);
        this.h = true;
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (!isCancelled()) {
            this.d.sendFailureMessage(0, null, null, localIOException);
          } else {
            AsyncHttpClient.log.e("AsyncHttpRequest", "makeRequestWithRetries returned error", localIOException);
          }
        }
      }
    }
  }
  
  public AsyncHttpRequest setRequestTag(Object paramObject)
  {
    this.d.setTag(paramObject);
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/AsyncHttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */