package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher
  extends Thread
{
  private final Cache mCache;
  private final ResponseDelivery mDelivery;
  private final Network mNetwork;
  private final BlockingQueue<Request<?>> mQueue;
  private volatile boolean mQuit = false;
  
  public NetworkDispatcher(BlockingQueue<Request<?>> paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.mQueue = paramBlockingQueue;
    this.mNetwork = paramNetwork;
    this.mCache = paramCache;
    this.mDelivery = paramResponseDelivery;
  }
  
  @TargetApi(14)
  private void addTrafficStatsTag(Request<?> paramRequest)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      TrafficStats.setThreadStatsTag(paramRequest.getTrafficStatsTag());
    }
  }
  
  private void parseAndDeliverNetworkError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramVolleyError = paramRequest.parseNetworkError(paramVolleyError);
    this.mDelivery.postError(paramRequest, paramVolleyError);
  }
  
  private void showCache(Request<?> paramRequest)
  {
    if (!paramRequest.shouldCache()) {}
    do
    {
      return;
      localObject = this.mCache.get(paramRequest.getCacheKey());
    } while (localObject == null);
    Object localObject = paramRequest.parseNetworkResponse(new NetworkResponse(((Cache.Entry)localObject).data, ((Cache.Entry)localObject).responseHeaders));
    this.mDelivery.postResponse(paramRequest, (Response)localObject);
  }
  
  public void quit()
  {
    this.mQuit = true;
    interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 124	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 130	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore_1
    //   9: aload_0
    //   10: getfield 24	com/android/volley/NetworkDispatcher:mQueue	Ljava/util/concurrent/BlockingQueue;
    //   13: invokeinterface 136 1 0
    //   18: checkcast 46	com/android/volley/Request
    //   21: astore_3
    //   22: aload_3
    //   23: ldc -118
    //   25: invokevirtual 142	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   28: aload_3
    //   29: invokevirtual 145	com/android/volley/Request:isCanceled	()Z
    //   32: ifeq +48 -> 80
    //   35: aload_3
    //   36: ldc -109
    //   38: invokevirtual 150	com/android/volley/Request:finish	(Ljava/lang/String;)V
    //   41: goto -36 -> 5
    //   44: astore 4
    //   46: aload 4
    //   48: invokestatic 130	android/os/SystemClock:elapsedRealtime	()J
    //   51: lload_1
    //   52: lsub
    //   53: invokevirtual 154	com/android/volley/VolleyError:setNetworkTimeMs	(J)V
    //   56: aload_0
    //   57: aload_3
    //   58: aload 4
    //   60: invokespecial 156	com/android/volley/NetworkDispatcher:parseAndDeliverNetworkError	(Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   63: aload_0
    //   64: aload_3
    //   65: invokespecial 158	com/android/volley/NetworkDispatcher:showCache	(Lcom/android/volley/Request;)V
    //   68: goto -63 -> 5
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 22	com/android/volley/NetworkDispatcher:mQuit	Z
    //   76: ifeq -71 -> 5
    //   79: return
    //   80: aload_0
    //   81: aload_3
    //   82: invokespecial 160	com/android/volley/NetworkDispatcher:addTrafficStatsTag	(Lcom/android/volley/Request;)V
    //   85: aload_0
    //   86: getfield 26	com/android/volley/NetworkDispatcher:mNetwork	Lcom/android/volley/Network;
    //   89: aload_3
    //   90: invokeinterface 166 2 0
    //   95: astore 4
    //   97: aload_3
    //   98: ldc -88
    //   100: invokevirtual 142	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   103: aload 4
    //   105: getfield 171	com/android/volley/NetworkResponse:notModified	Z
    //   108: ifeq +81 -> 189
    //   111: aload_3
    //   112: invokevirtual 174	com/android/volley/Request:hasHadResponseDelivered	()Z
    //   115: ifeq +74 -> 189
    //   118: aload_3
    //   119: ldc -80
    //   121: invokevirtual 150	com/android/volley/Request:finish	(Ljava/lang/String;)V
    //   124: goto -119 -> 5
    //   127: astore 4
    //   129: aload 4
    //   131: ldc -78
    //   133: iconst_1
    //   134: anewarray 180	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload 4
    //   141: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 189	com/android/volley/VolleyLog:e	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: new 117	com/android/volley/VolleyError
    //   151: dup
    //   152: aload 4
    //   154: invokespecial 192	com/android/volley/VolleyError:<init>	(Ljava/lang/Throwable;)V
    //   157: astore 4
    //   159: aload 4
    //   161: invokestatic 130	android/os/SystemClock:elapsedRealtime	()J
    //   164: lload_1
    //   165: lsub
    //   166: invokevirtual 154	com/android/volley/VolleyError:setNetworkTimeMs	(J)V
    //   169: aload_0
    //   170: getfield 30	com/android/volley/NetworkDispatcher:mDelivery	Lcom/android/volley/ResponseDelivery;
    //   173: aload_3
    //   174: aload 4
    //   176: invokeinterface 69 3 0
    //   181: aload_0
    //   182: aload_3
    //   183: invokespecial 158	com/android/volley/NetworkDispatcher:showCache	(Lcom/android/volley/Request;)V
    //   186: goto -181 -> 5
    //   189: aload_3
    //   190: aload 4
    //   192: invokevirtual 104	com/android/volley/Request:parseNetworkResponse	(Lcom/android/volley/NetworkResponse;)Lcom/android/volley/Response;
    //   195: astore 4
    //   197: aload_3
    //   198: ldc -62
    //   200: invokevirtual 142	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   203: aload_3
    //   204: invokevirtual 75	com/android/volley/Request:shouldCache	()Z
    //   207: ifeq +35 -> 242
    //   210: aload 4
    //   212: getfield 200	com/android/volley/Response:cacheEntry	Lcom/android/volley/Cache$Entry;
    //   215: ifnull +27 -> 242
    //   218: aload_0
    //   219: getfield 28	com/android/volley/NetworkDispatcher:mCache	Lcom/android/volley/Cache;
    //   222: aload_3
    //   223: invokevirtual 79	com/android/volley/Request:getCacheKey	()Ljava/lang/String;
    //   226: aload 4
    //   228: getfield 200	com/android/volley/Response:cacheEntry	Lcom/android/volley/Cache$Entry;
    //   231: invokeinterface 204 3 0
    //   236: aload_3
    //   237: ldc -50
    //   239: invokevirtual 142	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   242: aload_3
    //   243: invokevirtual 209	com/android/volley/Request:markDelivered	()V
    //   246: aload_0
    //   247: getfield 30	com/android/volley/NetworkDispatcher:mDelivery	Lcom/android/volley/ResponseDelivery;
    //   250: aload_3
    //   251: aload 4
    //   253: invokeinterface 108 3 0
    //   258: goto -253 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	NetworkDispatcher
    //   8	157	1	l	long
    //   21	44	3	localRequest	Request
    //   71	180	3	localInterruptedException	InterruptedException
    //   44	15	4	localVolleyError	VolleyError
    //   95	9	4	localNetworkResponse	NetworkResponse
    //   127	26	4	localException	Exception
    //   157	95	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	41	44	com/android/volley/VolleyError
    //   80	124	44	com/android/volley/VolleyError
    //   189	242	44	com/android/volley/VolleyError
    //   242	258	44	com/android/volley/VolleyError
    //   9	22	71	java/lang/InterruptedException
    //   22	41	127	java/lang/Exception
    //   80	124	127	java/lang/Exception
    //   189	242	127	java/lang/Exception
    //   242	258	127	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/android/volley/NetworkDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */