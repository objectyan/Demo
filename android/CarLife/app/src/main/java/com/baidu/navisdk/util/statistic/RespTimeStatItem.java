package com.baidu.navisdk.util.statistic;

import android.os.SystemClock;
import java.util.ArrayList;
import org.apache.http.NameValuePair;

public class RespTimeStatItem
{
  private static final String TAG = RespTimeStatItem.class.getSimpleName();
  private boolean mEngTime = false;
  private boolean mIsCommitted = false;
  public long mLocatedTime;
  public long mSDKInitStartTime;
  public long mSDKInitTime;
  private boolean mSetInitTime = false;
  private boolean mSetLocateTime = false;
  public long mStartAppTime;
  public long mStartInitEngineTime = -1L;
  private ArrayList<NameValuePair> mStatPairList = new ArrayList();
  public long mSumInitEngineTime;
  
  public static RespTimeStatItem getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  public void addSDKInitTime()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.mSDKInitStartTime;
    this.mSDKInitTime += l1 - l2;
    this.mSetInitTime = true;
    if ((this.mSetInitTime) && (this.mSetLocateTime) && (this.mEngTime)) {
      onEvent();
    }
  }
  
  /* Error */
  public void onEvent()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/baidu/navisdk/util/statistic/RespTimeStatItem:mIsCommitted	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 55	com/baidu/navisdk/util/statistic/RespTimeStatItem:mStatPairList	Ljava/util/ArrayList;
    //   18: new 76	org/apache/http/message/BasicNameValuePair
    //   21: dup
    //   22: ldc 78
    //   24: aload_0
    //   25: getfield 71	com/baidu/navisdk/util/statistic/RespTimeStatItem:mSDKInitTime	J
    //   28: invokestatic 84	java/lang/Long:toString	(J)Ljava/lang/String;
    //   31: invokespecial 87	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: ldc2_w 39
    //   41: lstore_2
    //   42: aload_0
    //   43: getfield 93	com/baidu/navisdk/util/statistic/RespTimeStatItem:mLocatedTime	J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifle +13 -> 61
    //   51: aload_0
    //   52: getfield 93	com/baidu/navisdk/util/statistic/RespTimeStatItem:mLocatedTime	J
    //   55: aload_0
    //   56: getfield 95	com/baidu/navisdk/util/statistic/RespTimeStatItem:mStartAppTime	J
    //   59: lsub
    //   60: lstore_2
    //   61: aload_0
    //   62: getfield 55	com/baidu/navisdk/util/statistic/RespTimeStatItem:mStatPairList	Ljava/util/ArrayList;
    //   65: new 76	org/apache/http/message/BasicNameValuePair
    //   68: dup
    //   69: ldc 97
    //   71: lload_2
    //   72: invokestatic 84	java/lang/Long:toString	(J)Ljava/lang/String;
    //   75: invokespecial 87	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: aload_0
    //   83: getfield 55	com/baidu/navisdk/util/statistic/RespTimeStatItem:mStatPairList	Ljava/util/ArrayList;
    //   86: new 76	org/apache/http/message/BasicNameValuePair
    //   89: dup
    //   90: ldc 99
    //   92: aload_0
    //   93: getfield 101	com/baidu/navisdk/util/statistic/RespTimeStatItem:mSumInitEngineTime	J
    //   96: invokestatic 84	java/lang/Long:toString	(J)Ljava/lang/String;
    //   99: invokespecial 87	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: invokestatic 106	com/baidu/navisdk/comapi/statistics/BNStatisticsManager:getInstance	()Lcom/baidu/navisdk/comapi/statistics/BNStatisticsManager;
    //   109: ldc 107
    //   111: aconst_null
    //   112: aload_0
    //   113: getfield 55	com/baidu/navisdk/util/statistic/RespTimeStatItem:mStatPairList	Ljava/util/ArrayList;
    //   116: invokevirtual 111	com/baidu/navisdk/comapi/statistics/BNStatisticsManager:onEventWithParam	(ILjava/lang/String;Ljava/util/ArrayList;)V
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield 44	com/baidu/navisdk/util/statistic/RespTimeStatItem:mIsCommitted	Z
    //   124: goto -113 -> 11
    //   127: astore 4
    //   129: aload_0
    //   130: monitorexit
    //   131: aload 4
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	RespTimeStatItem
    //   6	2	1	bool	boolean
    //   41	31	2	l	long
    //   127	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	127	finally
    //   14	38	127	finally
    //   42	61	127	finally
    //   61	124	127	finally
  }
  
  public void setAppLocatedTime()
  {
    if (0L == this.mLocatedTime)
    {
      this.mLocatedTime = SystemClock.elapsedRealtime();
      this.mSetLocateTime = true;
      if ((this.mSetInitTime) && (this.mSetLocateTime) && (this.mEngTime)) {
        onEvent();
      }
    }
  }
  
  public void setEndEngineTime()
  {
    this.mEngTime = true;
    if (this.mStartInitEngineTime <= -1L) {}
    for (this.mSumInitEngineTime = -1L;; this.mSumInitEngineTime = (SystemClock.elapsedRealtime() - this.mStartInitEngineTime))
    {
      if ((this.mSetInitTime) && (this.mSetLocateTime) && (this.mEngTime)) {
        onEvent();
      }
      return;
    }
  }
  
  public void setStartAppTime()
  {
    this.mStartAppTime = SystemClock.elapsedRealtime();
  }
  
  public void setStartEngineTime()
  {
    this.mStartInitEngineTime = SystemClock.elapsedRealtime();
  }
  
  public void startCountSDKInitTime()
  {
    this.mSDKInitStartTime = SystemClock.elapsedRealtime();
  }
  
  private static class LazyHolder
  {
    private static RespTimeStatItem sInstance = new RespTimeStatItem();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/RespTimeStatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */