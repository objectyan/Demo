package com.baidu.navisdk.util.statistic.userop;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.GuideStatItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;

public class UserOPController
{
  private static final String CACHE_FILE_NAME = "navi_ops_cache";
  private static final char[] PAGE_PREFIX = { 50, 51, 52, 53, 54 };
  public static final String TAG = "UserOP";
  private static UserOPController sInstance = null;
  private long mBaseTime = -1L;
  private Map<String, UserOP> mCacheOpMap = new HashMap();
  private CommonHandlerThread.Callback mHandlerThreadCB = new CommonHandlerThread.Callback()
  {
    public void careAbouts()
    {
      careAbout(1);
      careAbout(3);
      careAbout(2);
    }
    
    public void execute(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        UserOPController.this.performLoadCacheOPs();
        return;
      case 3: 
        UserOPController.this.performCacheOPs();
        return;
      }
      UserOPController.this.performClearCacheOPs();
    }
    
    public String getName()
    {
      return "UserOP";
    }
  };
  private String mLastContinuousOP = null;
  private int mLastContinuousOPCount = 0;
  private int mLastMapGestureCount = 0;
  private int mLastMapGestureEvent = -1;
  private long mLastOPTime = -1L;
  private int mOPCount = 0;
  private StringBuffer mOPs = new StringBuffer();
  private String mPageParam = "0";
  private String sessionId = null;
  
  private UserOPController()
  {
    CommonHandlerThread.getInstance().registerCallback(this.mHandlerThreadCB);
    loadCacheOPs(0L);
  }
  
  private String addEscapeSeqToSsid(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace("\"", "\\\"");
  }
  
  private void addMapOPInner(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLastMapGestureEvent = -1;
    this.mLastMapGestureCount = 0;
    if ((2 == paramInt1) && (paramInt2 != -1)) {}
    switch (paramInt2)
    {
    case 515: 
    default: 
      return;
    case 513: 
      add("1.c", "" + paramInt3, null, null);
      return;
    case 514: 
      add("1.d", "" + paramInt3, null, null);
      return;
    case 516: 
      add("1.f", "" + paramInt3, null, null);
      return;
    case 517: 
      add("1.g", "" + paramInt3, null, null);
      return;
    case 518: 
    case 519: 
      add("1.7", "" + paramInt3, null, null);
      return;
    case 520: 
      add("1.8", "" + paramInt3, null, null);
      return;
    }
    add("1.b", "" + paramInt3, null, null);
  }
  
  private void appendContinuousOPInner(String paramString, int paramInt)
  {
    this.mLastContinuousOP = null;
    this.mLastContinuousOPCount = 0;
    if ("3.ka".equals(paramString)) {
      add("3.k", String.valueOf(paramInt), null, null);
    }
    while (!"3.kb".equals(paramString)) {
      return;
    }
    add("3.k", null, String.valueOf(paramInt), null);
  }
  
  private void cacheOPs()
  {
    CommonHandlerThread.getInstance().removeMessage(3);
    CommonHandlerThread.getInstance().sendMessage(3, 0, 0, null, 5000L);
  }
  
  private void cacheOPs(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      cacheOPs();
      return;
    }
    CommonHandlerThread.getInstance().removeMessage(3);
    CommonHandlerThread.getInstance().sendMessage(3, 0, 0, null, 0L);
  }
  
  private boolean careAboutMapEvent(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2) {}
    switch (paramInt2)
    {
    case 515: 
    default: 
      return false;
    }
    return true;
  }
  
  private void checkAddContinuousOPInner()
  {
    if ((this.mLastContinuousOP == null) || (this.mLastContinuousOPCount <= 0)) {
      return;
    }
    appendContinuousOPInner(this.mLastContinuousOP, this.mLastContinuousOPCount);
    this.mLastContinuousOP = null;
    this.mLastContinuousOPCount = 0;
  }
  
  private void checkAddMapOPInner()
  {
    if (-1 == this.mLastMapGestureEvent) {
      return;
    }
    addMapOPInner(2, this.mLastMapGestureEvent, this.mLastMapGestureCount);
    this.mLastMapGestureEvent = -1;
    this.mLastMapGestureCount = 0;
  }
  
  private void checkEnd()
  {
    if ((this.mOPCount > 100) || ((this.mLastOPTime > 0L) && (SystemClock.elapsedRealtime() - this.mLastOPTime > 21600000L)))
    {
      LogUtil.e("UserOP", "checkEnd() end");
      end();
    }
  }
  
  private void clearCacheOPs()
  {
    CommonHandlerThread.getInstance().removeMessage(3);
    CommonHandlerThread.getInstance().removeMessage(2);
    CommonHandlerThread.getInstance().sendMessage(2, 0, 0, null, 0L);
  }
  
  public static UserOPController getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new UserOPController();
      }
      return sInstance;
    }
    finally {}
  }
  
  private boolean isNeedUpdatePageParam(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return false;
      int j = paramString.charAt(0);
      paramString = PAGE_PREFIX;
      int k = paramString.length;
      int i = 0;
      while (i < k)
      {
        if (paramString[i] == j) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void loadCacheOPs(long paramLong)
  {
    CommonHandlerThread.getInstance().removeMessage(1);
    CommonHandlerThread.getInstance().sendMessage(1, 0, 0, null, paramLong);
  }
  
  /* Error */
  private void performCacheOPs()
  {
    // Byte code:
    //   0: ldc 15
    //   2: ldc -19
    //   4: invokestatic 216	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore 6
    //   16: aload 4
    //   18: astore_2
    //   19: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   22: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   25: ifnull +20 -> 45
    //   28: aload 4
    //   30: astore_2
    //   31: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   34: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   37: invokevirtual 229	java/lang/String:length	()I
    //   40: istore_1
    //   41: iload_1
    //   42: ifgt +30 -> 72
    //   45: iconst_0
    //   46: ifeq +11 -> 57
    //   49: new 247	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 248	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: return
    //   58: astore_2
    //   59: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   62: ifeq -5 -> 57
    //   65: aload_2
    //   66: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   69: goto -12 -> 57
    //   72: aload 4
    //   74: astore_2
    //   75: new 257	java/io/File
    //   78: dup
    //   79: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   82: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   85: ldc 10
    //   87: invokespecial 259	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: astore 7
    //   92: aload 7
    //   94: astore_3
    //   95: aload 7
    //   97: ifnull +33 -> 130
    //   100: aload 7
    //   102: astore_3
    //   103: aload 4
    //   105: astore_2
    //   106: aload 7
    //   108: invokevirtual 262	java/io/File:exists	()Z
    //   111: ifne +19 -> 130
    //   114: aload 7
    //   116: astore_3
    //   117: aload 4
    //   119: astore_2
    //   120: aload 7
    //   122: invokevirtual 265	java/io/File:createNewFile	()Z
    //   125: ifne +5 -> 130
    //   128: aconst_null
    //   129: astore_3
    //   130: aload 6
    //   132: astore_2
    //   133: aload_3
    //   134: ifnull +106 -> 240
    //   137: aload 4
    //   139: astore_2
    //   140: new 267	java/io/BufferedWriter
    //   143: dup
    //   144: new 269	java/io/FileWriter
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 272	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   152: invokespecial 275	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   155: astore_3
    //   156: aload_3
    //   157: aload_0
    //   158: getfield 67	com/baidu/navisdk/util/statistic/userop/UserOPController:mOPs	Ljava/lang/StringBuffer;
    //   161: invokevirtual 276	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   164: invokevirtual 280	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   167: ldc_w 282
    //   170: invokestatic 287	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   173: astore_2
    //   174: aload_0
    //   175: getfield 52	com/baidu/navisdk/util/statistic/userop/UserOPController:sessionId	Ljava/lang/String;
    //   178: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +16 -> 197
    //   184: aload_3
    //   185: aload_2
    //   186: invokevirtual 280	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   189: aload_3
    //   190: aload_0
    //   191: getfield 52	com/baidu/navisdk/util/statistic/userop/UserOPController:sessionId	Ljava/lang/String;
    //   194: invokevirtual 280	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   197: aload_3
    //   198: invokevirtual 296	java/io/BufferedWriter:flush	()V
    //   201: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   204: ifeq +34 -> 238
    //   207: ldc 15
    //   209: new 131	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 298
    //   219: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_0
    //   223: getfield 67	com/baidu/navisdk/util/statistic/userop/UserOPController:mOPs	Ljava/lang/StringBuffer;
    //   226: invokevirtual 276	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   229: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 216	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_3
    //   239: astore_2
    //   240: aload_2
    //   241: ifnull +7 -> 248
    //   244: aload_2
    //   245: invokevirtual 301	java/io/BufferedWriter:close	()V
    //   248: return
    //   249: astore_2
    //   250: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   253: ifeq -5 -> 248
    //   256: aload_2
    //   257: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   260: goto -12 -> 248
    //   263: astore 4
    //   265: aload 5
    //   267: astore_3
    //   268: aload_3
    //   269: astore_2
    //   270: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   273: ifeq +10 -> 283
    //   276: aload_3
    //   277: astore_2
    //   278: aload 4
    //   280: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   283: aload_3
    //   284: ifnull +7 -> 291
    //   287: aload_3
    //   288: invokevirtual 301	java/io/BufferedWriter:close	()V
    //   291: return
    //   292: astore_2
    //   293: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   296: ifeq -5 -> 291
    //   299: aload_2
    //   300: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   303: goto -12 -> 291
    //   306: astore_3
    //   307: aload_2
    //   308: ifnull +7 -> 315
    //   311: aload_2
    //   312: invokevirtual 301	java/io/BufferedWriter:close	()V
    //   315: aload_3
    //   316: athrow
    //   317: astore_2
    //   318: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   321: ifeq -6 -> 315
    //   324: aload_2
    //   325: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   328: goto -13 -> 315
    //   331: astore 4
    //   333: aload_3
    //   334: astore_2
    //   335: aload 4
    //   337: astore_3
    //   338: goto -31 -> 307
    //   341: astore 4
    //   343: goto -75 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	UserOPController
    //   40	2	1	i	int
    //   18	13	2	localObject1	Object
    //   58	8	2	localException1	Exception
    //   74	171	2	localObject2	Object
    //   249	8	2	localException2	Exception
    //   269	9	2	localObject3	Object
    //   292	20	2	localException3	Exception
    //   317	8	2	localException4	Exception
    //   334	1	2	localObject4	Object
    //   94	194	3	localObject5	Object
    //   306	28	3	localObject6	Object
    //   337	1	3	localObject7	Object
    //   11	127	4	localObject8	Object
    //   263	16	4	localException5	Exception
    //   331	5	4	localObject9	Object
    //   341	1	4	localException6	Exception
    //   8	258	5	localObject10	Object
    //   14	117	6	localObject11	Object
    //   90	31	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   49	57	58	java/lang/Exception
    //   244	248	249	java/lang/Exception
    //   19	28	263	java/lang/Exception
    //   31	41	263	java/lang/Exception
    //   75	92	263	java/lang/Exception
    //   106	114	263	java/lang/Exception
    //   120	128	263	java/lang/Exception
    //   140	156	263	java/lang/Exception
    //   287	291	292	java/lang/Exception
    //   19	28	306	finally
    //   31	41	306	finally
    //   75	92	306	finally
    //   106	114	306	finally
    //   120	128	306	finally
    //   140	156	306	finally
    //   270	276	306	finally
    //   278	283	306	finally
    //   311	315	317	java/lang/Exception
    //   156	197	331	finally
    //   197	238	331	finally
    //   156	197	341	java/lang/Exception
    //   197	238	341	java/lang/Exception
  }
  
  /* Error */
  private void performClearCacheOPs()
  {
    // Byte code:
    //   0: ldc 15
    //   2: ldc_w 303
    //   5: invokestatic 216	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore 6
    //   17: aload 4
    //   19: astore_2
    //   20: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   23: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   26: ifnull +20 -> 46
    //   29: aload 4
    //   31: astore_2
    //   32: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   35: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   38: invokevirtual 229	java/lang/String:length	()I
    //   41: istore_1
    //   42: iload_1
    //   43: ifgt +30 -> 73
    //   46: iconst_0
    //   47: ifeq +11 -> 58
    //   50: new 247	java/lang/NullPointerException
    //   53: dup
    //   54: invokespecial 248	java/lang/NullPointerException:<init>	()V
    //   57: athrow
    //   58: return
    //   59: astore_2
    //   60: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   63: ifeq -5 -> 58
    //   66: aload_2
    //   67: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   70: goto -12 -> 58
    //   73: aload 4
    //   75: astore_2
    //   76: new 257	java/io/File
    //   79: dup
    //   80: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   83: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   86: ldc 10
    //   88: invokespecial 259	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: astore 7
    //   93: aload 6
    //   95: astore_3
    //   96: aload 7
    //   98: ifnull +47 -> 145
    //   101: aload 6
    //   103: astore_3
    //   104: aload 4
    //   106: astore_2
    //   107: aload 7
    //   109: invokevirtual 262	java/io/File:exists	()Z
    //   112: ifeq +33 -> 145
    //   115: aload 4
    //   117: astore_2
    //   118: new 267	java/io/BufferedWriter
    //   121: dup
    //   122: new 269	java/io/FileWriter
    //   125: dup
    //   126: aload 7
    //   128: invokespecial 272	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   131: invokespecial 275	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   134: astore_3
    //   135: aload_3
    //   136: ldc -122
    //   138: invokevirtual 280	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   141: aload_3
    //   142: invokevirtual 296	java/io/BufferedWriter:flush	()V
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 301	java/io/BufferedWriter:close	()V
    //   153: return
    //   154: astore_2
    //   155: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   158: ifeq -5 -> 153
    //   161: aload_2
    //   162: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   165: goto -12 -> 153
    //   168: astore 4
    //   170: aload 5
    //   172: astore_3
    //   173: aload_3
    //   174: astore_2
    //   175: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   178: ifeq +10 -> 188
    //   181: aload_3
    //   182: astore_2
    //   183: aload 4
    //   185: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 301	java/io/BufferedWriter:close	()V
    //   196: return
    //   197: astore_2
    //   198: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   201: ifeq -5 -> 196
    //   204: aload_2
    //   205: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   208: goto -12 -> 196
    //   211: astore_3
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 301	java/io/BufferedWriter:close	()V
    //   220: aload_3
    //   221: athrow
    //   222: astore_2
    //   223: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   226: ifeq -6 -> 220
    //   229: aload_2
    //   230: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   233: goto -13 -> 220
    //   236: astore 4
    //   238: aload_3
    //   239: astore_2
    //   240: aload 4
    //   242: astore_3
    //   243: goto -31 -> 212
    //   246: astore 4
    //   248: goto -75 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	UserOPController
    //   41	2	1	i	int
    //   19	13	2	localObject1	Object
    //   59	8	2	localException1	Exception
    //   75	43	2	localObject2	Object
    //   154	8	2	localException2	Exception
    //   174	9	2	localObject3	Object
    //   197	20	2	localException3	Exception
    //   222	8	2	localException4	Exception
    //   239	1	2	localObject4	Object
    //   95	98	3	localObject5	Object
    //   211	28	3	localObject6	Object
    //   242	1	3	localObject7	Object
    //   12	104	4	localObject8	Object
    //   168	16	4	localException5	Exception
    //   236	5	4	localObject9	Object
    //   246	1	4	localException6	Exception
    //   9	162	5	localObject10	Object
    //   15	87	6	localObject11	Object
    //   91	36	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   50	58	59	java/lang/Exception
    //   149	153	154	java/lang/Exception
    //   20	29	168	java/lang/Exception
    //   32	42	168	java/lang/Exception
    //   76	93	168	java/lang/Exception
    //   107	115	168	java/lang/Exception
    //   118	135	168	java/lang/Exception
    //   192	196	197	java/lang/Exception
    //   20	29	211	finally
    //   32	42	211	finally
    //   76	93	211	finally
    //   107	115	211	finally
    //   118	135	211	finally
    //   175	181	211	finally
    //   183	188	211	finally
    //   216	220	222	java/lang/Exception
    //   135	145	236	finally
    //   135	145	246	java/lang/Exception
  }
  
  /* Error */
  private void performLoadCacheOPs()
  {
    // Byte code:
    //   0: ldc 15
    //   2: ldc_w 305
    //   5: invokestatic 216	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: invokestatic 311	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   11: ifnonnull +11 -> 22
    //   14: aload_0
    //   15: ldc2_w 312
    //   18: invokespecial 101	com/baidu/navisdk/util/statistic/userop/UserOPController:loadCacheOPs	(J)V
    //   21: return
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore 6
    //   31: aload 4
    //   33: astore_3
    //   34: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   37: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   40: ifnull +20 -> 60
    //   43: aload 4
    //   45: astore_3
    //   46: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   49: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   52: invokevirtual 229	java/lang/String:length	()I
    //   55: istore_1
    //   56: iload_1
    //   57: ifgt +27 -> 84
    //   60: iconst_0
    //   61: ifeq -40 -> 21
    //   64: new 247	java/lang/NullPointerException
    //   67: dup
    //   68: invokespecial 248	java/lang/NullPointerException:<init>	()V
    //   71: athrow
    //   72: astore_2
    //   73: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   76: ifeq -55 -> 21
    //   79: aload_2
    //   80: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   83: return
    //   84: aload 4
    //   86: astore_3
    //   87: new 257	java/io/File
    //   90: dup
    //   91: invokestatic 242	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   94: invokevirtual 245	com/baidu/navisdk/util/common/SysOSAPI:getSecondCachePath	()Ljava/lang/String;
    //   97: ldc 10
    //   99: invokespecial 259	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore 7
    //   104: aload 6
    //   106: astore_2
    //   107: aload 7
    //   109: ifnull +311 -> 420
    //   112: aload 6
    //   114: astore_2
    //   115: aload 4
    //   117: astore_3
    //   118: aload 7
    //   120: invokevirtual 262	java/io/File:exists	()Z
    //   123: ifeq +297 -> 420
    //   126: aload 4
    //   128: astore_3
    //   129: new 315	java/io/BufferedReader
    //   132: dup
    //   133: new 317	java/io/FileReader
    //   136: dup
    //   137: aload 7
    //   139: invokespecial 318	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   142: invokespecial 321	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   145: astore_2
    //   146: aconst_null
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_3
    //   151: iconst_0
    //   152: istore_1
    //   153: aload_2
    //   154: invokevirtual 324	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   157: astore 5
    //   159: aload 5
    //   161: ifnull +14 -> 175
    //   164: iload_1
    //   165: ifne +364 -> 529
    //   168: aload 5
    //   170: astore 4
    //   172: goto +350 -> 522
    //   175: aload 4
    //   177: ifnull +243 -> 420
    //   180: aload 4
    //   182: invokevirtual 229	java/lang/String:length	()I
    //   185: ifle +235 -> 420
    //   188: ldc -122
    //   190: astore 5
    //   192: invokestatic 329	com/baidu/navisdk/comapi/setting/BNSettingManager:getQuitForExceptionInNaviMode	()Z
    //   195: ifeq +30 -> 225
    //   198: new 131	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   205: ldc -122
    //   207: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 331
    //   213: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore 5
    //   221: iconst_0
    //   222: invokestatic 334	com/baidu/navisdk/comapi/setting/BNSettingManager:setQuitForExceptionInNaviMode	(Z)V
    //   225: new 131	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   232: aload 5
    //   234: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc_w 336
    //   240: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: astore 5
    //   248: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   251: ifeq +34 -> 285
    //   254: ldc 15
    //   256: new 131	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 338
    //   266: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 4
    //   271: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 5
    //   276: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 216	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: new 340	java/util/ArrayList
    //   288: dup
    //   289: invokespecial 341	java/util/ArrayList:<init>	()V
    //   292: astore 6
    //   294: aload 6
    //   296: new 343	org/apache/http/message/BasicNameValuePair
    //   299: dup
    //   300: ldc_w 345
    //   303: new 131	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   310: aload 4
    //   312: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 5
    //   317: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokespecial 346	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: invokevirtual 348	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   329: pop
    //   330: aload 6
    //   332: new 343	org/apache/http/message/BasicNameValuePair
    //   335: dup
    //   336: ldc_w 350
    //   339: aload_0
    //   340: aload_3
    //   341: invokespecial 352	com/baidu/navisdk/util/statistic/userop/UserOPController:addEscapeSeqToSsid	(Ljava/lang/String;)Ljava/lang/String;
    //   344: invokespecial 346	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: invokevirtual 348	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   350: pop
    //   351: new 354	com/baidu/navisdk/util/statistic/userop/UserOPDataCheckItem
    //   354: dup
    //   355: aload 6
    //   357: invokespecial 357	com/baidu/navisdk/util/statistic/userop/UserOPDataCheckItem:<init>	(Ljava/util/ArrayList;)V
    //   360: invokevirtual 360	com/baidu/navisdk/util/statistic/userop/UserOPDataCheckItem:check	()V
    //   363: invokestatic 365	com/baidu/navisdk/comapi/statistics/BNStatisticsManager:getInstance	()Lcom/baidu/navisdk/comapi/statistics/BNStatisticsManager;
    //   366: ldc_w 366
    //   369: aconst_null
    //   370: aload 6
    //   372: invokevirtual 370	com/baidu/navisdk/comapi/statistics/BNStatisticsManager:onEventWithParam	(ILjava/lang/String;Ljava/util/ArrayList;)V
    //   375: invokestatic 373	com/baidu/navisdk/comapi/setting/BNSettingManager:isShowJavaLog	()Z
    //   378: ifeq +42 -> 420
    //   381: ldc_w 375
    //   384: invokestatic 381	com/baidu/navisdk/debug/SDKDebugFileUtil:get	(Ljava/lang/String;)Lcom/baidu/navisdk/debug/SDKDebugFileUtil;
    //   387: new 131	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   394: aload_3
    //   395: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 383
    //   401: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload 4
    //   406: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 5
    //   411: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokevirtual 385	com/baidu/navisdk/debug/SDKDebugFileUtil:add	(Ljava/lang/String;)V
    //   420: aload_2
    //   421: ifnull -400 -> 21
    //   424: aload_2
    //   425: invokevirtual 386	java/io/BufferedReader:close	()V
    //   428: return
    //   429: astore_2
    //   430: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   433: ifeq -412 -> 21
    //   436: aload_2
    //   437: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   440: return
    //   441: astore 4
    //   443: aload 5
    //   445: astore_2
    //   446: aload_2
    //   447: astore_3
    //   448: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   451: ifeq +10 -> 461
    //   454: aload_2
    //   455: astore_3
    //   456: aload 4
    //   458: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   461: aload_2
    //   462: ifnull -441 -> 21
    //   465: aload_2
    //   466: invokevirtual 386	java/io/BufferedReader:close	()V
    //   469: return
    //   470: astore_2
    //   471: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   474: ifeq -453 -> 21
    //   477: aload_2
    //   478: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   481: return
    //   482: astore_2
    //   483: aload_3
    //   484: ifnull +7 -> 491
    //   487: aload_3
    //   488: invokevirtual 386	java/io/BufferedReader:close	()V
    //   491: aload_2
    //   492: athrow
    //   493: astore_3
    //   494: getstatic 252	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   497: ifeq -6 -> 491
    //   500: aload_3
    //   501: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   504: goto -13 -> 491
    //   507: astore 4
    //   509: aload_2
    //   510: astore_3
    //   511: aload 4
    //   513: astore_2
    //   514: goto -31 -> 483
    //   517: astore 4
    //   519: goto -73 -> 446
    //   522: iload_1
    //   523: iconst_1
    //   524: iadd
    //   525: istore_1
    //   526: goto -373 -> 153
    //   529: iload_1
    //   530: iconst_1
    //   531: if_icmpne -356 -> 175
    //   534: aload 5
    //   536: astore_3
    //   537: goto -15 -> 522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	UserOPController
    //   55	477	1	i	int
    //   72	8	2	localException1	Exception
    //   106	319	2	localObject1	Object
    //   429	8	2	localException2	Exception
    //   445	21	2	str1	String
    //   470	8	2	localException3	Exception
    //   482	28	2	localObject2	Object
    //   513	1	2	localObject3	Object
    //   33	455	3	localObject4	Object
    //   493	8	3	localException4	Exception
    //   510	27	3	localObject5	Object
    //   26	379	4	str2	String
    //   441	16	4	localException5	Exception
    //   507	5	4	localObject6	Object
    //   517	1	4	localException6	Exception
    //   23	512	5	str3	String
    //   29	342	6	localArrayList	ArrayList
    //   102	36	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   64	72	72	java/lang/Exception
    //   424	428	429	java/lang/Exception
    //   34	43	441	java/lang/Exception
    //   46	56	441	java/lang/Exception
    //   87	104	441	java/lang/Exception
    //   118	126	441	java/lang/Exception
    //   129	146	441	java/lang/Exception
    //   465	469	470	java/lang/Exception
    //   34	43	482	finally
    //   46	56	482	finally
    //   87	104	482	finally
    //   118	126	482	finally
    //   129	146	482	finally
    //   448	454	482	finally
    //   456	461	482	finally
    //   487	491	493	java/lang/Exception
    //   153	159	507	finally
    //   180	188	507	finally
    //   192	225	507	finally
    //   225	285	507	finally
    //   285	420	507	finally
    //   153	159	517	java/lang/Exception
    //   180	188	517	java/lang/Exception
    //   192	225	517	java/lang/Exception
    //   225	285	517	java/lang/Exception
    //   285	420	517	java/lang/Exception
  }
  
  public void add(String paramString)
  {
    add(paramString, null, null, null);
  }
  
  public void add(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return;
    }
    String str1 = paramString2;
    String str2 = paramString3;
    String str3 = paramString4;
    long l;
    label87:
    int j;
    if (paramString2 != null)
    {
      if (paramString2.trim().equals("a"))
      {
        str1 = "";
        str3 = paramString4;
        str2 = paramString3;
      }
    }
    else
    {
      checkEnd();
      checkAddMapOPInner();
      checkAddContinuousOPInner();
      if (this.mBaseTime > 0L) {
        break label475;
      }
      this.mBaseTime = SystemClock.elapsedRealtime();
      l = System.currentTimeMillis() / 1000L;
      paramString3 = new StringBuffer();
      paramString3.append(paramString1);
      paramString3.append("-");
      paramString3.append(String.valueOf(l));
      j = 1;
      int i = 1;
      if ((str1 != null) || (str2 != null) || (str3 != null))
      {
        j = i;
        if (str1 != null)
        {
          paramString3.append("-");
          paramString3.append("a");
          if (str1.length() > 0) {
            paramString3.append(str1);
          }
          j = 0;
        }
        i = j;
        if (str2 != null)
        {
          if (j == 0) {
            break label494;
          }
          paramString2 = "-";
          label201:
          paramString3.append(paramString2);
          paramString3.append("b");
          if (str2.length() > 0) {
            paramString3.append(str2);
          }
          i = 0;
        }
        j = i;
        if (str3 != null)
        {
          if (i == 0) {
            break label501;
          }
          paramString2 = "-";
          label251:
          paramString3.append(paramString2);
          paramString3.append("c");
          if (str3.length() > 0) {
            paramString3.append(str3);
          }
          j = 0;
        }
      }
      if (!isNeedUpdatePageParam(paramString1)) {
        break label508;
      }
      this.mPageParam = paramString1.substring(0, 1);
      LogUtil.e("UserOP", "mPageParam=" + this.mPageParam);
    }
    label475:
    label494:
    label501:
    label508:
    while ('1' != paramString1.charAt(0))
    {
      this.mLastOPTime = SystemClock.elapsedRealtime();
      this.mOPCount += 1;
      LogUtil.e("UserOP", "add() ops=" + paramString3.toString());
      if (this.mOPs.length() > 0) {
        this.mOPs.append(":");
      }
      this.mOPs.append(paramString3.toString());
      cacheOPs();
      return;
      if (paramString2.trim().equals("b"))
      {
        str1 = null;
        str2 = "";
        str3 = paramString4;
        break;
      }
      str1 = paramString2;
      str2 = paramString3;
      str3 = paramString4;
      if (!paramString2.trim().equals("c")) {
        break;
      }
      str1 = null;
      str2 = null;
      str3 = "";
      break;
      l = (SystemClock.elapsedRealtime() - this.mBaseTime) / 1000L + 1L;
      break label87;
      paramString2 = "|";
      break label201;
      paramString2 = "|";
      break label251;
    }
    if (j != 0) {}
    for (paramString1 = "-";; paramString1 = "|")
    {
      paramString3.append(paramString1);
      paramString3.append("p");
      if (this.mPageParam != null) {
        paramString3.append(this.mPageParam);
      }
      break;
    }
  }
  
  public void addMapOP(int paramInt1, int paramInt2)
  {
    if (!careAboutMapEvent(paramInt1, paramInt2)) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((520 == this.mLastMapGestureEvent) && (513 == paramInt2));
      i = paramInt2;
      if (519 == paramInt2) {
        i = 518;
      }
    } while (((520 == this.mLastMapGestureEvent) && (518 == i)) || ((521 == this.mLastMapGestureEvent) && (518 == i)) || (2 != paramInt1));
    if (i == this.mLastMapGestureEvent)
    {
      this.mLastMapGestureCount += 1;
      return;
    }
    addMapOPInner(paramInt1, this.mLastMapGestureEvent, this.mLastMapGestureCount);
    this.mLastMapGestureEvent = i;
    this.mLastMapGestureCount = 1;
  }
  
  public void appendContinuousOP(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (this.mLastContinuousOP == null)
    {
      this.mLastContinuousOP = paramString;
      this.mLastContinuousOPCount = 1;
      return;
    }
    if (this.mLastContinuousOP.equals(paramString))
    {
      this.mLastContinuousOPCount += 1;
      return;
    }
    appendContinuousOPInner(this.mLastContinuousOP, this.mLastContinuousOPCount);
    this.mLastContinuousOP = paramString;
    this.mLastContinuousOPCount = 1;
  }
  
  public void cacheOP(UserOP paramUserOP)
  {
    if ((paramUserOP != null) && (paramUserOP.op != null) && (paramUserOP.op.length() > 0)) {
      this.mCacheOpMap.put(paramUserOP.op, paramUserOP);
    }
  }
  
  public void checkQuitForExceptionInNaviMode()
  {
    if (BNSettingManager.getQuitForExceptionInNaviMode())
    {
      add("1.k");
      BNSettingManager.setQuitForExceptionInNaviMode(false);
    }
  }
  
  public boolean end()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("lj", this.mOPs.toString()));
    localArrayList.add(new BasicNameValuePair("ssid", addEscapeSeqToSsid(this.sessionId)));
    GuideStatItem.getInstance().end();
    String str = GuideStatItem.getInstance().getGuideStatString();
    if (str != null) {
      localArrayList.add(new BasicNameValuePair("rg", str));
    }
    new UserOPDataCheckItem(localArrayList).check();
    BNStatisticsManager.getInstance().onEventWithParam(50008, null, localArrayList);
    if (BNSettingManager.isShowJavaLog()) {
      SDKDebugFileUtil.get("userop_debug").add(this.mOPs.toString());
    }
    this.mBaseTime = -1L;
    this.mLastOPTime = -1L;
    this.mPageParam = "0";
    this.mOPs = new StringBuffer();
    this.mOPCount = 0;
    clearCacheOPs();
    return false;
  }
  
  public void removeCacheOP(UserOP paramUserOP)
  {
    if ((paramUserOP != null) && (paramUserOP.op != null) && (paramUserOP.op.length() > 0) && (this.mCacheOpMap.containsKey(paramUserOP.op))) {
      this.mCacheOpMap.remove(paramUserOP.op);
    }
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      cacheOPs(true);
    }
  }
  
  public boolean useAndRemoveCacheOP(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0) && (this.mCacheOpMap.containsKey(paramString)))
    {
      UserOP localUserOP = (UserOP)this.mCacheOpMap.get(paramString);
      if (localUserOP != null)
      {
        add(paramString, localUserOP.a, localUserOP.b, localUserOP.c);
        return true;
      }
      this.mCacheOpMap.remove(paramString);
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/statistic/userop/UserOPController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */