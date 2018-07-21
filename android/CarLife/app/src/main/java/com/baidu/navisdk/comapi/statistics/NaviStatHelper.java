package com.baidu.navisdk.comapi.statistics;

import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class NaviStatHelper
{
  public static final String INIT_STAT = "stat.init";
  private static final int LOCAL_CACHE_SIZE = 10;
  public static String NAVI_URL;
  public static final String NAVI_URL_ONLINE;
  private static final String STAT_COMLOG_FILE = "statComLog.txt";
  private static final String STAT_LOG_FILE = "statLog.txt";
  public static final String UPLOAD_SESSION_STAT = "session.stat.upload";
  public static final String UPLOAD_STAT = "stat.upload";
  public static boolean hasCrashInNavi = false;
  private static boolean hasInitStat;
  private static CommonHandlerThread.Callback mHandlerThreadCallback;
  private static int pushNaviStatisticsRet;
  private static List<NameValuePair> sGlobalStatParamsPrefixs;
  private static ArrayList<NameValuePair> sStatCacheContent;
  private static List<NameValuePair> sStatParamsPrefixs;
  private static int test10Count = 0;
  private static int testCount;
  
  static
  {
    NAVI_URL_ONLINE = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/statistics/send";
    NAVI_URL = NAVI_URL_ONLINE;
    sStatParamsPrefixs = new ArrayList();
    sGlobalStatParamsPrefixs = new ArrayList();
    hasInitStat = false;
    pushNaviStatisticsRet = 0;
    mHandlerThreadCallback = new CommonHandlerThread.Callback()
    {
      public void careAbouts()
      {
        careAbout(12);
        careAbout(14);
        careAbout(13);
        careAbout(11);
      }
      
      public void execute(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          return;
          NaviStatHelper.access$000();
          NaviStatSessionHelper.initSession();
          return;
          if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof String)))
          {
            Object localObject = (String)paramAnonymousMessage.obj;
            switch (paramAnonymousMessage.arg1)
            {
            case 50004: 
            case 50005: 
            default: 
              NaviStatHelper.pushNaviStatistics((String)localObject);
              return;
            case 50001: 
            case 50002: 
            case 50006: 
            case 50007: 
            case 50008: 
              NaviStatSessionHelper.pushNaviStatistics(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, (String)localObject);
              return;
            }
            if (NaviStatHelper.hasCrashInNavi)
            {
              NaviStatSessionHelper.saveSessionCacheInNaviCrash((String)localObject);
              return;
            }
            NaviStatSessionHelper.pushNaviStatistics(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, (String)localObject);
            return;
            if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
            {
              paramAnonymousMessage = NaviStatSessionHelper.getListSessionFromFile();
              if ((paramAnonymousMessage != null) && (paramAnonymousMessage.size() > 0))
              {
                paramAnonymousMessage = paramAnonymousMessage.iterator();
                boolean bool;
                while (paramAnonymousMessage.hasNext())
                {
                  localObject = (NaviStatSessionHelper.Session)paramAnonymousMessage.next();
                  if ((localObject != null) && (((NaviStatSessionHelper.Session)localObject).size() > 0))
                  {
                    bool = NaviStatSessionHelper.pushNaviSessionStatistics((NaviStatSessionHelper.Session)localObject);
                    LogUtil.e("CmdStatisticsUpload", "push SessionStatistics result :" + bool);
                    if (!bool) {
                      NaviStatSessionHelper.writeOfflineComSessionStatLogToFile((NaviStatSessionHelper.Session)localObject);
                    }
                  }
                }
                continue;
                if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
                {
                  paramAnonymousMessage = NaviStatHelper.getOfflineStateListFromLocal();
                  if ((paramAnonymousMessage != null) && (paramAnonymousMessage.size() > 0))
                  {
                    paramAnonymousMessage = paramAnonymousMessage.iterator();
                    while (paramAnonymousMessage.hasNext())
                    {
                      localObject = (ArrayList)paramAnonymousMessage.next();
                      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
                      {
                        bool = NaviStatHelper.pushNaviStatistics((List)localObject);
                        LogUtil.e("CmdStatisticsUpload", "push Statistics result :" + bool);
                        if (!bool) {
                          NaviStatHelper.writeOfflineStatLogToFile((ArrayList)localObject);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    };
    testCount = 0;
  }
  
  private static void deleteTxtFile(String paramString)
  {
    paramString = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + paramString);
    if ((paramString != null) && (paramString.exists())) {
      paramString.delete();
    }
  }
  
  private static int getCityId()
  {
    return BNaviModuleManager.getOutChinaCurrentCityId();
  }
  
  private static int getCountryArea()
  {
    RoutePlanModel localRoutePlanModel = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
    if ((localRoutePlanModel == null) || (localRoutePlanModel.getEnNaviType() == 0)) {
      return 0;
    }
    return 1;
  }
  
  private static File getOfflineStatLogFile(String paramString)
  {
    paramString = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + paramString);
    if (paramString.exists()) {
      return paramString;
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return paramString;
  }
  
  /* Error */
  private static ArrayList<String> getOfflineStateFromFile(String paramString)
  {
    // Byte code:
    //   0: new 78	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 79	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 106	java/io/File
    //   12: dup
    //   13: new 50	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   20: invokestatic 111	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   23: invokevirtual 114	com/baidu/navisdk/util/common/SysOSAPI:GetSDCardCachePath	()Ljava/lang/String;
    //   26: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 116
    //   31: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 122	java/io/File:exists	()Z
    //   49: ifne +7 -> 56
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: areturn
    //   56: aconst_null
    //   57: astore 6
    //   59: aconst_null
    //   60: astore_0
    //   61: aconst_null
    //   62: astore 4
    //   64: new 165	java/io/BufferedReader
    //   67: dup
    //   68: new 167	java/io/FileReader
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 170	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   76: invokespecial 173	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   79: astore_3
    //   80: aload_3
    //   81: invokevirtual 176	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +18 -> 104
    //   89: aload_0
    //   90: ifnull +14 -> 104
    //   93: aload_0
    //   94: ldc -78
    //   96: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: istore_2
    //   100: iload_2
    //   101: ifeq +14 -> 115
    //   104: aload_3
    //   105: ifnull +205 -> 310
    //   108: aload_3
    //   109: invokevirtual 187	java/io/BufferedReader:close	()V
    //   112: aload 5
    //   114: areturn
    //   115: aload_0
    //   116: ldc -67
    //   118: invokevirtual 193	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   121: astore_0
    //   122: iconst_0
    //   123: istore_1
    //   124: iload_1
    //   125: aload_0
    //   126: arraylength
    //   127: if_icmpge -47 -> 80
    //   130: aload_0
    //   131: iload_1
    //   132: aaload
    //   133: ifnull +23 -> 156
    //   136: ldc -78
    //   138: aload_0
    //   139: iload_1
    //   140: aaload
    //   141: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifne +12 -> 156
    //   147: aload 5
    //   149: aload_0
    //   150: iload_1
    //   151: aaload
    //   152: invokevirtual 196	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   155: pop
    //   156: iload_1
    //   157: iconst_1
    //   158: iadd
    //   159: istore_1
    //   160: goto -36 -> 124
    //   163: astore_0
    //   164: ldc -58
    //   166: aload_0
    //   167: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   170: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: goto -61 -> 112
    //   176: astore_0
    //   177: aload 4
    //   179: astore_3
    //   180: aload_0
    //   181: astore 4
    //   183: aload_3
    //   184: astore_0
    //   185: ldc -58
    //   187: aload 4
    //   189: invokevirtual 208	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   192: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 5
    //   197: astore_0
    //   198: aload_3
    //   199: ifnull -145 -> 54
    //   202: aload_3
    //   203: invokevirtual 187	java/io/BufferedReader:close	()V
    //   206: aload 5
    //   208: areturn
    //   209: astore_0
    //   210: ldc -58
    //   212: aload_0
    //   213: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   216: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -13 -> 206
    //   222: astore 4
    //   224: aload 6
    //   226: astore_3
    //   227: aload_3
    //   228: astore_0
    //   229: ldc -58
    //   231: aload 4
    //   233: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   236: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 5
    //   241: astore_0
    //   242: aload_3
    //   243: ifnull -189 -> 54
    //   246: aload_3
    //   247: invokevirtual 187	java/io/BufferedReader:close	()V
    //   250: aload 5
    //   252: areturn
    //   253: astore_0
    //   254: ldc -58
    //   256: aload_0
    //   257: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   260: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -13 -> 250
    //   266: astore_3
    //   267: aload_0
    //   268: ifnull +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 187	java/io/BufferedReader:close	()V
    //   275: aload_3
    //   276: athrow
    //   277: astore_0
    //   278: ldc -58
    //   280: aload_0
    //   281: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   284: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: goto -12 -> 275
    //   290: astore 4
    //   292: aload_3
    //   293: astore_0
    //   294: aload 4
    //   296: astore_3
    //   297: goto -30 -> 267
    //   300: astore 4
    //   302: goto -75 -> 227
    //   305: astore 4
    //   307: goto -124 -> 183
    //   310: aload 5
    //   312: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramString	String
    //   123	37	1	i	int
    //   99	2	2	bool	boolean
    //   44	203	3	localObject1	Object
    //   266	27	3	localObject2	Object
    //   296	1	3	localObject3	Object
    //   62	126	4	str	String
    //   222	10	4	localIOException1	IOException
    //   290	5	4	localObject4	Object
    //   300	1	4	localIOException2	IOException
    //   305	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   7	304	5	localArrayList	ArrayList
    //   57	168	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   108	112	163	java/io/IOException
    //   64	80	176	java/io/FileNotFoundException
    //   202	206	209	java/io/IOException
    //   64	80	222	java/io/IOException
    //   246	250	253	java/io/IOException
    //   64	80	266	finally
    //   185	195	266	finally
    //   229	239	266	finally
    //   271	275	277	java/io/IOException
    //   80	85	290	finally
    //   93	100	290	finally
    //   115	122	290	finally
    //   124	130	290	finally
    //   136	156	290	finally
    //   80	85	300	java/io/IOException
    //   93	100	300	java/io/IOException
    //   115	122	300	java/io/IOException
    //   124	130	300	java/io/IOException
    //   136	156	300	java/io/IOException
    //   80	85	305	java/io/FileNotFoundException
    //   93	100	305	java/io/FileNotFoundException
    //   115	122	305	java/io/FileNotFoundException
    //   124	130	305	java/io/FileNotFoundException
    //   136	156	305	java/io/FileNotFoundException
  }
  
  public static ArrayList<ArrayList<NameValuePair>> getOfflineStateListFromLocal()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = getOfflineStateFromFile("statComLog.txt");
    ArrayList localArrayList2;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int k = ((ArrayList)localObject).size();
      LogUtil.e("NaviStatHelper", "suffixParamList size = " + k);
      localArrayList2 = new ArrayList();
      int j = 0;
      int i = 0;
      while (j < k)
      {
        localArrayList2.add(new BasicNameValuePair("item" + i, (String)((ArrayList)localObject).get(j)));
        i += 1;
        if ((i == 10) || (j + 1 == k))
        {
          localArrayList1.add(new ArrayList(localArrayList2));
          localArrayList2.clear();
          i = 0;
        }
        j += 1;
      }
      deleteTxtFile("statComLog.txt");
    }
    if (LogUtil.LOGGABLE)
    {
      LogUtil.e("NaviStatHelper", "local list size " + localArrayList1.size());
      localObject = localArrayList1.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localArrayList2 = (ArrayList)((Iterator)localObject).next();
        LogUtil.e("NaviStatHelper", "local list " + localArrayList2.toString());
      }
    }
    return localArrayList1;
  }
  
  private static void init()
  {
    if (hasInitStat) {
      return;
    }
    ArrayList localArrayList = getOfflineStateFromFile("statLog.txt");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int j = localArrayList.size();
      LogUtil.e("NaviStatHelper", "statParamList size = " + j);
      sStatCacheContent = new ArrayList();
      int i = 0;
      while (i < j)
      {
        sStatCacheContent.add(new BasicNameValuePair("item" + i, (String)localArrayList.get(i)));
        i += 1;
      }
    }
    if (sStatCacheContent == null) {
      sStatCacheContent = new ArrayList();
    }
    hasInitStat = true;
  }
  
  public static void initGlobalStatParams(List<NameValuePair> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList.clear();
    paramList.add(new BasicNameValuePair("area", getCountryArea() + ""));
    paramList.add(new BasicNameValuePair("cityid", getCityId() + ""));
  }
  
  public static void initNaviStatHelper()
  {
    CommonHandlerThread.getInstance().registerCallback(mHandlerThreadCallback);
    CommonHandlerThread.getInstance().sendMessage(11, -1, -1, null, 0L);
  }
  
  public static void initStatParamsPrefix(List<NameValuePair> paramList)
  {
    LogUtil.e("NaviStatHelper", "initStatParamsPrefix start");
    paramList.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
    paramList.add(new BasicNameValuePair("os", "Android"));
    paramList.add(new BasicNameValuePair("ov", PackageUtil.strOSVersion));
    paramList.add(new BasicNameValuePair("pcn", PackageUtil.getPackageName()));
    paramList.add(new BasicNameValuePair("ch", PackageUtil.getChannel()));
    paramList.add(new BasicNameValuePair("mb", PackageUtil.strPhoneType));
    paramList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
    LogUtil.e("NaviStatHelper", "initStatParamsPrefix end " + paramList.size());
  }
  
  public static void pushNaviStatistics(String paramString)
  {
    if (!hasInitStat) {
      init();
    }
    statisticsTest(paramString, "test1_1.txt");
    ArrayList localArrayList = new ArrayList();
    int i = sStatCacheContent.size();
    sStatCacheContent.add(new BasicNameValuePair("item" + i, paramString));
    writeSynSessionStatLogToFile(paramString);
    LogUtil.e("NaviStatHelper", "push Statistics item" + i + ": " + paramString);
    if (sStatCacheContent.size() >= 10)
    {
      localArrayList.addAll(new ArrayList(sStatCacheContent));
      sStatCacheContent.clear();
    }
    if (localArrayList.size() > 0)
    {
      deleteTxtFile("statLog.txt");
      if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
        break label196;
      }
      boolean bool = pushNaviStatistics(localArrayList);
      LogUtil.e("NaviStatHelper", "Send Statistics result : " + bool);
      if (!bool) {
        writeOfflineStatLogToFile(localArrayList);
      }
    }
    return;
    label196:
    writeOfflineStatLogToFile(localArrayList);
  }
  
  public static boolean pushNaviStatistics(List<NameValuePair> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      LogUtil.e("NaviStatHelper", "push params is null");
    }
    do
    {
      return false;
      pushNaviStatisticsRet = 0;
      NAVI_URL = NAVI_URL_ONLINE;
      Object localObject1 = new ArrayList();
      if (sStatParamsPrefixs.isEmpty())
      {
        initStatParamsPrefix(sStatParamsPrefixs);
        sStatParamsPrefixs.add(new BasicNameValuePair("isSession", "0"));
      }
      initGlobalStatParams(sGlobalStatParamsPrefixs);
      if (sGlobalStatParamsPrefixs != null) {
        ((List)localObject1).addAll(sGlobalStatParamsPrefixs);
      }
      ((List)localObject1).addAll(sStatParamsPrefixs);
      ((List)localObject1).addAll(paramList);
      Object localObject2 = new BNHttpParams();
      ((BNHttpParams)localObject2).isAsync = false;
      HashMap localHashMap = BNHttpCenterHelper.formatParams((List)localObject1);
      BNHttpCenter.getInstance().post(NAVI_URL, localHashMap, new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          LogUtil.e("NaviStatHelper", "onFailure().statusCode=" + paramAnonymousInt);
          NaviStatHelper.access$102(paramAnonymousInt);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          LogUtil.e("NaviStatHelper", "onSuccess().statusCode=" + paramAnonymousInt);
          NaviStatHelper.access$102(paramAnonymousInt);
        }
      }, (BNHttpParams)localObject2);
      if (((pushNaviStatisticsRet == 200) || (pushNaviStatisticsRet == -1)) && (LogUtil.LOGGABLE))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (NameValuePair)((Iterator)localObject1).next();
          LogUtil.e("NaviStatHelper", "push pair name = " + ((NameValuePair)localObject2).getName() + " value = " + ((NameValuePair)localObject2).getValue());
        }
      }
      if ((pushNaviStatisticsRet == 200) || (pushNaviStatisticsRet == -1)) {
        statisticsTest(paramList);
      }
    } while ((pushNaviStatisticsRet != 200) && (pushNaviStatisticsRet != -1));
    return true;
  }
  
  private static void statisticsTest(String paramString1, String paramString2)
  {
    if (!LogUtil.LOGGABLE) {
      return;
    }
    new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + paramString2);
  }
  
  private static void statisticsTest(List<NameValuePair> paramList)
  {
    if (!LogUtil.LOGGABLE) {}
  }
  
  public static void writeCacheToFile() {}
  
  /* Error */
  public static void writeOfflineStatLogToFile(ArrayList<NameValuePair> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 217	java/util/ArrayList:size	()I
    //   8: ifgt +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore_1
    //   14: aconst_null
    //   15: astore_3
    //   16: ldc 20
    //   18: invokestatic 435	com/baidu/navisdk/comapi/statistics/NaviStatHelper:getOfflineStatLogFile	(Ljava/lang/String;)Ljava/io/File;
    //   21: astore_2
    //   22: new 437	java/io/FileOutputStream
    //   25: dup
    //   26: aload_2
    //   27: iconst_1
    //   28: invokespecial 440	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: astore_2
    //   32: ldc -78
    //   34: astore_1
    //   35: aload_0
    //   36: invokevirtual 249	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_3
    //   43: invokeinterface 254 1 0
    //   48: ifeq +58 -> 106
    //   51: aload_3
    //   52: invokeinterface 258 1 0
    //   57: checkcast 417	org/apache/http/NameValuePair
    //   60: invokeinterface 427 1 0
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull -25 -> 42
    //   70: ldc -78
    //   72: aload_1
    //   73: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifne -34 -> 42
    //   79: new 50	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   86: aload_0
    //   87: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc -67
    //   96: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: astore_0
    //   103: goto -61 -> 42
    //   106: aload_2
    //   107: aload_0
    //   108: ldc_w 442
    //   111: invokevirtual 446	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   114: invokevirtual 450	java/io/FileOutputStream:write	([B)V
    //   117: aload_2
    //   118: invokevirtual 453	java/io/FileOutputStream:flush	()V
    //   121: ldc -58
    //   123: ldc_w 454
    //   126: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_2
    //   130: ifnull +95 -> 225
    //   133: aload_2
    //   134: invokevirtual 455	java/io/FileOutputStream:close	()V
    //   137: return
    //   138: astore_0
    //   139: ldc -58
    //   141: aload_0
    //   142: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   145: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -11 -> 137
    //   151: astore_2
    //   152: aload_3
    //   153: astore_0
    //   154: aload_0
    //   155: astore_1
    //   156: ldc -58
    //   158: aload_2
    //   159: invokevirtual 456	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   162: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: ifnull -155 -> 11
    //   169: aload_0
    //   170: invokevirtual 455	java/io/FileOutputStream:close	()V
    //   173: return
    //   174: astore_0
    //   175: ldc -58
    //   177: aload_0
    //   178: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   181: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: goto -11 -> 173
    //   187: astore_0
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 455	java/io/FileOutputStream:close	()V
    //   196: aload_0
    //   197: athrow
    //   198: astore_1
    //   199: ldc -58
    //   201: aload_1
    //   202: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   205: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: goto -12 -> 196
    //   211: astore_0
    //   212: aload_2
    //   213: astore_1
    //   214: goto -26 -> 188
    //   217: astore_1
    //   218: aload_2
    //   219: astore_0
    //   220: aload_1
    //   221: astore_2
    //   222: goto -68 -> 154
    //   225: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramArrayList	ArrayList<NameValuePair>
    //   13	180	1	localObject1	Object
    //   198	4	1	localIOException	IOException
    //   213	1	1	localObject2	Object
    //   217	4	1	localException1	Exception
    //   21	113	2	localObject3	Object
    //   151	68	2	localException2	Exception
    //   221	1	2	localException3	Exception
    //   15	138	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   133	137	138	java/io/IOException
    //   22	32	151	java/lang/Exception
    //   169	173	174	java/io/IOException
    //   22	32	187	finally
    //   156	165	187	finally
    //   192	196	198	java/io/IOException
    //   35	40	211	finally
    //   42	66	211	finally
    //   70	103	211	finally
    //   106	129	211	finally
    //   35	40	217	java/lang/Exception
    //   42	66	217	java/lang/Exception
    //   70	103	217	java/lang/Exception
    //   106	129	217	java/lang/Exception
  }
  
  /* Error */
  private static void writeSynSessionStatLogToFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: ldc 23
    //   7: invokestatic 435	com/baidu/navisdk/comapi/statistics/NaviStatHelper:getOfflineStatLogFile	(Ljava/lang/String;)Ljava/io/File;
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_1
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_2
    //   16: ifnull -12 -> 4
    //   19: new 437	java/io/FileOutputStream
    //   22: dup
    //   23: aload_2
    //   24: iconst_1
    //   25: invokespecial 440	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   28: astore_2
    //   29: new 50	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc -67
    //   42: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore_0
    //   49: aload_2
    //   50: aload_0
    //   51: ldc_w 442
    //   54: invokevirtual 446	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   57: invokevirtual 450	java/io/FileOutputStream:write	([B)V
    //   60: aload_2
    //   61: invokevirtual 453	java/io/FileOutputStream:flush	()V
    //   64: ldc_w 459
    //   67: new 50	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 461
    //   77: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_2
    //   91: ifnull +99 -> 190
    //   94: aload_2
    //   95: invokevirtual 455	java/io/FileOutputStream:close	()V
    //   98: return
    //   99: astore_0
    //   100: ldc_w 459
    //   103: aload_0
    //   104: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -12 -> 98
    //   113: astore_2
    //   114: aload_3
    //   115: astore_0
    //   116: aload_0
    //   117: astore_1
    //   118: ldc_w 459
    //   121: aload_2
    //   122: invokevirtual 456	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   125: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: ifnull -125 -> 4
    //   132: aload_0
    //   133: invokevirtual 455	java/io/FileOutputStream:close	()V
    //   136: return
    //   137: astore_0
    //   138: ldc_w 459
    //   141: aload_0
    //   142: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   145: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -12 -> 136
    //   151: astore_0
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 455	java/io/FileOutputStream:close	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_1
    //   163: ldc_w 459
    //   166: aload_1
    //   167: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   170: invokestatic 207	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: goto -13 -> 160
    //   176: astore_0
    //   177: aload_2
    //   178: astore_1
    //   179: goto -27 -> 152
    //   182: astore_1
    //   183: aload_2
    //   184: astore_0
    //   185: aload_1
    //   186: astore_2
    //   187: goto -71 -> 116
    //   190: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   12	145	1	str	String
    //   162	5	1	localIOException	IOException
    //   178	1	1	localException1	Exception
    //   182	4	1	localException2	Exception
    //   10	85	2	localObject1	Object
    //   113	71	2	localException3	Exception
    //   186	1	2	localObject2	Object
    //   14	101	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   94	98	99	java/io/IOException
    //   19	29	113	java/lang/Exception
    //   132	136	137	java/io/IOException
    //   19	29	151	finally
    //   118	128	151	finally
    //   156	160	162	java/io/IOException
    //   29	90	176	finally
    //   29	90	182	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/statistics/NaviStatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */