package com.baidu.mobstat;

import android.content.Context;

public class PrefOperate
{
  public static String getAppKey(Context paramContext)
  {
    return CooperService.a().getAppKey(paramContext);
  }
  
  /* Error */
  public static void loadMetaDataConfig(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 29	com/baidu/mobstat/SendStrategyEnum:APP_START	Lcom/baidu/mobstat/SendStrategyEnum;
    //   3: astore 4
    //   5: aload_0
    //   6: ldc 31
    //   8: invokestatic 36	com/baidu/mobstat/de:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_2
    //   12: aload_2
    //   13: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +20 -> 36
    //   19: ldc 44
    //   21: aload_2
    //   22: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +11 -> 36
    //   28: invokestatic 55	com/baidu/mobstat/bt:a	()Lcom/baidu/mobstat/bt;
    //   31: aload_0
    //   32: iconst_0
    //   33: invokevirtual 58	com/baidu/mobstat/bt:a	(Landroid/content/Context;Z)V
    //   36: aload 4
    //   38: astore_2
    //   39: aload_0
    //   40: ldc 60
    //   42: invokestatic 36	com/baidu/mobstat/de:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 5
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: astore_2
    //   53: aload 5
    //   55: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +40 -> 98
    //   61: aload 4
    //   63: astore_2
    //   64: aload 5
    //   66: getstatic 29	com/baidu/mobstat/SendStrategyEnum:APP_START	Lcom/baidu/mobstat/SendStrategyEnum;
    //   69: invokevirtual 64	com/baidu/mobstat/SendStrategyEnum:name	()Ljava/lang/String;
    //   72: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifeq +113 -> 188
    //   78: aload 4
    //   80: astore_2
    //   81: getstatic 29	com/baidu/mobstat/SendStrategyEnum:APP_START	Lcom/baidu/mobstat/SendStrategyEnum;
    //   84: astore_3
    //   85: aload_3
    //   86: astore_2
    //   87: invokestatic 69	com/baidu/mobstat/bj:a	()Lcom/baidu/mobstat/bj;
    //   90: aload_0
    //   91: aload_3
    //   92: invokevirtual 73	com/baidu/mobstat/SendStrategyEnum:ordinal	()I
    //   95: invokevirtual 76	com/baidu/mobstat/bj:a	(Landroid/content/Context;I)V
    //   98: aload_0
    //   99: ldc 78
    //   101: invokestatic 36	com/baidu/mobstat/de:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_2
    //   105: aload_2
    //   106: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +39 -> 148
    //   112: aload_2
    //   113: invokestatic 84	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: istore_1
    //   117: aload_3
    //   118: invokevirtual 73	com/baidu/mobstat/SendStrategyEnum:ordinal	()I
    //   121: getstatic 87	com/baidu/mobstat/SendStrategyEnum:SET_TIME_INTERVAL	Lcom/baidu/mobstat/SendStrategyEnum;
    //   124: invokevirtual 73	com/baidu/mobstat/SendStrategyEnum:ordinal	()I
    //   127: if_icmpne +21 -> 148
    //   130: iload_1
    //   131: ifle +17 -> 148
    //   134: iload_1
    //   135: bipush 24
    //   137: if_icmpgt +11 -> 148
    //   140: invokestatic 69	com/baidu/mobstat/bj:a	()Lcom/baidu/mobstat/bj;
    //   143: aload_0
    //   144: iload_1
    //   145: invokevirtual 90	com/baidu/mobstat/bj:b	(Landroid/content/Context;I)V
    //   148: aload_0
    //   149: ldc 92
    //   151: invokestatic 36	com/baidu/mobstat/de:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_2
    //   155: aload_2
    //   156: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifne +20 -> 179
    //   162: ldc 44
    //   164: aload_2
    //   165: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +132 -> 300
    //   171: invokestatic 69	com/baidu/mobstat/bj:a	()Lcom/baidu/mobstat/bj;
    //   174: aload_0
    //   175: iconst_1
    //   176: invokevirtual 93	com/baidu/mobstat/bj:a	(Landroid/content/Context;Z)V
    //   179: return
    //   180: astore_2
    //   181: aload_2
    //   182: invokestatic 98	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   185: goto -149 -> 36
    //   188: aload 4
    //   190: astore_2
    //   191: aload 5
    //   193: getstatic 101	com/baidu/mobstat/SendStrategyEnum:ONCE_A_DAY	Lcom/baidu/mobstat/SendStrategyEnum;
    //   196: invokevirtual 64	com/baidu/mobstat/SendStrategyEnum:name	()Ljava/lang/String;
    //   199: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +47 -> 249
    //   205: aload 4
    //   207: astore_2
    //   208: getstatic 101	com/baidu/mobstat/SendStrategyEnum:ONCE_A_DAY	Lcom/baidu/mobstat/SendStrategyEnum;
    //   211: astore_3
    //   212: aload_3
    //   213: astore_2
    //   214: invokestatic 69	com/baidu/mobstat/bj:a	()Lcom/baidu/mobstat/bj;
    //   217: aload_0
    //   218: aload_3
    //   219: invokevirtual 73	com/baidu/mobstat/SendStrategyEnum:ordinal	()I
    //   222: invokevirtual 76	com/baidu/mobstat/bj:a	(Landroid/content/Context;I)V
    //   225: aload_3
    //   226: astore_2
    //   227: invokestatic 69	com/baidu/mobstat/bj:a	()Lcom/baidu/mobstat/bj;
    //   230: aload_0
    //   231: bipush 24
    //   233: invokevirtual 90	com/baidu/mobstat/bj:b	(Landroid/content/Context;I)V
    //   236: goto -138 -> 98
    //   239: astore_3
    //   240: aload_3
    //   241: invokestatic 98	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   244: aload_2
    //   245: astore_3
    //   246: goto -148 -> 98
    //   249: aload 4
    //   251: astore_3
    //   252: aload 4
    //   254: astore_2
    //   255: aload 5
    //   257: getstatic 87	com/baidu/mobstat/SendStrategyEnum:SET_TIME_INTERVAL	Lcom/baidu/mobstat/SendStrategyEnum;
    //   260: invokevirtual 64	com/baidu/mobstat/SendStrategyEnum:name	()Ljava/lang/String;
    //   263: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq -168 -> 98
    //   269: aload 4
    //   271: astore_2
    //   272: getstatic 87	com/baidu/mobstat/SendStrategyEnum:SET_TIME_INTERVAL	Lcom/baidu/mobstat/SendStrategyEnum;
    //   275: astore_3
    //   276: aload_3
    //   277: astore_2
    //   278: invokestatic 69	com/baidu/mobstat/bj:a	()Lcom/baidu/mobstat/bj;
    //   281: aload_0
    //   282: aload_3
    //   283: invokevirtual 73	com/baidu/mobstat/SendStrategyEnum:ordinal	()I
    //   286: invokevirtual 76	com/baidu/mobstat/bj:a	(Landroid/content/Context;I)V
    //   289: goto -191 -> 98
    //   292: astore_2
    //   293: aload_2
    //   294: invokestatic 98	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   297: goto -149 -> 148
    //   300: ldc 103
    //   302: aload_2
    //   303: invokevirtual 50	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifeq -127 -> 179
    //   309: invokestatic 69	com/baidu/mobstat/bj:a	()Lcom/baidu/mobstat/bj;
    //   312: aload_0
    //   313: iconst_0
    //   314: invokevirtual 93	com/baidu/mobstat/bj:a	(Landroid/content/Context;Z)V
    //   317: return
    //   318: astore_0
    //   319: aload_0
    //   320: invokestatic 98	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   323: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramContext	Context
    //   116	29	1	i	int
    //   11	154	2	localObject1	Object
    //   180	2	2	localException1	Exception
    //   190	88	2	localObject2	Object
    //   292	11	2	localException2	Exception
    //   49	177	3	localSendStrategyEnum1	SendStrategyEnum
    //   239	2	3	localException3	Exception
    //   245	38	3	localObject3	Object
    //   3	267	4	localSendStrategyEnum2	SendStrategyEnum
    //   45	211	5	str	String
    // Exception table:
    //   from	to	target	type
    //   5	36	180	java/lang/Exception
    //   39	47	239	java/lang/Exception
    //   53	61	239	java/lang/Exception
    //   64	78	239	java/lang/Exception
    //   81	85	239	java/lang/Exception
    //   87	98	239	java/lang/Exception
    //   191	205	239	java/lang/Exception
    //   208	212	239	java/lang/Exception
    //   214	225	239	java/lang/Exception
    //   227	236	239	java/lang/Exception
    //   255	269	239	java/lang/Exception
    //   272	276	239	java/lang/Exception
    //   278	289	239	java/lang/Exception
    //   98	130	292	java/lang/Exception
    //   140	148	292	java/lang/Exception
    //   148	179	318	java/lang/Exception
    //   300	317	318	java/lang/Exception
  }
  
  public static void setAppChannel(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      db.c("设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
    }
    CooperService.a().getHeadObject().m = paramString;
    if ((paramBoolean) && (paramString != null) && (!paramString.equals("")))
    {
      bj.a().c(paramContext, paramString);
      bj.a().b(paramContext, true);
    }
    if (!paramBoolean)
    {
      bj.a().c(paramContext, "");
      bj.a().b(paramContext, false);
    }
  }
  
  public static void setAppChannel(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      db.c("设置的渠道不能为空或者为null || The channel that you have been set is null or empty, please check it.");
    }
    CooperService.a().getHeadObject().m = paramString;
  }
  
  public static void setAppKey(String paramString)
  {
    CooperService.a().getHeadObject().f = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/PrefOperate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */