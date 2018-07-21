package com.baidu.platform.comapi.map.config;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

public class Preferences
  extends CachePreference
{
  public static final String SP_NAME = "map_pref";
  private static final ConcurrentHashMap<String, Preferences> cache = new ConcurrentHashMap();
  
  private Preferences(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public static Preferences build(Context paramContext)
  {
    return build(paramContext, "map_pref");
  }
  
  /* Error */
  public static Preferences build(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: astore_2
    //   5: aload_1
    //   6: ifnonnull +6 -> 12
    //   9: ldc 8
    //   11: astore_2
    //   12: aload_0
    //   13: astore_1
    //   14: aload_0
    //   15: ifnonnull +7 -> 22
    //   18: invokestatic 35	com/baidu/platform/comapi/c:f	()Landroid/content/Context;
    //   21: astore_1
    //   22: getstatic 20	com/baidu/platform/comapi/map/config/Preferences:cache	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_2
    //   26: invokevirtual 39	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +19 -> 48
    //   32: getstatic 20	com/baidu/platform/comapi/map/config/Preferences:cache	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_2
    //   36: invokevirtual 43	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 2	com/baidu/platform/comapi/map/config/Preferences
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: areturn
    //   48: new 2	com/baidu/platform/comapi/map/config/Preferences
    //   51: dup
    //   52: aload_1
    //   53: aload_2
    //   54: invokespecial 44	com/baidu/platform/comapi/map/config/Preferences:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   57: astore_0
    //   58: getstatic 20	com/baidu/platform/comapi/map/config/Preferences:cache	Ljava/util/concurrent/ConcurrentHashMap;
    //   61: aload_2
    //   62: aload_0
    //   63: invokevirtual 48	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: goto -24 -> 43
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramContext	Context
    //   0	76	1	paramString	String
    //   4	58	2	str	String
    // Exception table:
    //   from	to	target	type
    //   18	22	70	finally
    //   22	43	70	finally
    //   48	67	70	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/config/Preferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */