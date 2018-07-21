package com.baidu.baidunavis.navirecover;

import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.platform.comapi.map.config.Preferences;

public class NaviRecoveryModel
{
  private static final String NAVI_CRASH_TIME = "navi_crash_time";
  private static final String NAVI_NA_CRASH_TIME = "navi_na_crash_time";
  private static final String NAVI_RECOVER = "naviRecover";
  private static final String NAVI_RECOVER_TIME = "navi_recover_time";
  private static NaviRecoveryModel instance;
  private boolean mHasCalcRoute = false;
  private Preferences preferences = Preferences.build(NavMapAdapter.getInstance().getBaiduMapApplicationInstance(), "naviRecover");
  
  /* Error */
  public static NaviRecoveryModel getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 51	com/baidu/baidunavis/navirecover/NaviRecoveryModel:instance	Lcom/baidu/baidunavis/navirecover/NaviRecoveryModel;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 51	com/baidu/baidunavis/navirecover/NaviRecoveryModel:instance	Lcom/baidu/baidunavis/navirecover/NaviRecoveryModel;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/baidu/baidunavis/navirecover/NaviRecoveryModel
    //   21: dup
    //   22: invokespecial 52	com/baidu/baidunavis/navirecover/NaviRecoveryModel:<init>	()V
    //   25: putstatic 51	com/baidu/baidunavis/navirecover/NaviRecoveryModel:instance	Lcom/baidu/baidunavis/navirecover/NaviRecoveryModel;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 51	com/baidu/baidunavis/navirecover/NaviRecoveryModel:instance	Lcom/baidu/baidunavis/navirecover/NaviRecoveryModel;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localNaviRecoveryModel	NaviRecoveryModel
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public long getCrashTime()
  {
    return this.preferences.getLong("navi_crash_time", 0L).longValue();
  }
  
  public long getNaCrashTime()
  {
    return this.preferences.getLong("navi_na_crash_time", 0L).longValue();
  }
  
  public long getRecoverTime()
  {
    return this.preferences.getLong("navi_recover_time", 0L).longValue();
  }
  
  public boolean hasCalcRoute()
  {
    return this.mHasCalcRoute;
  }
  
  public boolean markCrashTime(long paramLong)
  {
    return this.preferences.putLong("navi_crash_time", paramLong);
  }
  
  public boolean markNaCrashTime(long paramLong)
  {
    return this.preferences.putLong("navi_na_crash_time", paramLong);
  }
  
  public boolean markRecoverTime(long paramLong)
  {
    return this.preferences.putLong("navi_recover_time", paramLong);
  }
  
  public void setHasCalcRoute(boolean paramBoolean)
  {
    this.mHasCalcRoute = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/navirecover/NaviRecoveryModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */