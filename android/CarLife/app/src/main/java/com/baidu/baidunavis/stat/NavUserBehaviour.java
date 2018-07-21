package com.baidu.baidunavis.stat;

import android.app.Fragment;
import android.os.SystemClock;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavCommonFuncController;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.platform.comapi.e.a;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.http.message.BasicNameValuePair;

public class NavUserBehaviour
{
  public static final String APP_KEY = "e9d85b3e5a";
  private static final String Simple_Log_File_Name = "navi_simple.log";
  private static final String TAG = NavUserBehaviour.class.getSimpleName();
  private static volatile NavUserBehaviour mInstance = null;
  private static boolean mIsNeedSendNaviStartMTJLog = false;
  private static boolean sIsInitialized = false;
  private int headNaviStatisticsRet = 0;
  private boolean mIsPropertiesSettingOK = false;
  private ArrayList<String> mOfflineStatInfoList = null;
  private Properties mSimpleLogProperties = new Properties();
  
  /* Error */
  private void cleanOfflineStatLog()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 102	com/baidu/baidunavis/stat/NavUserBehaviour:getDataOfflineStatLogFile	()Ljava/io/File;
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: astore_3
    //   9: new 113	java/io/FileOutputStream
    //   12: dup
    //   13: aload_2
    //   14: iconst_0
    //   15: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   18: astore_2
    //   19: aload_2
    //   20: ldc 118
    //   22: ldc 120
    //   24: invokevirtual 126	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   27: invokevirtual 130	java/io/FileOutputStream:write	([B)V
    //   30: aload_2
    //   31: invokevirtual 133	java/io/FileOutputStream:flush	()V
    //   34: aload_2
    //   35: ifnull +95 -> 130
    //   38: aload_2
    //   39: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   42: return
    //   43: astore_1
    //   44: ldc -118
    //   46: aload_1
    //   47: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   50: invokestatic 147	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: goto -11 -> 42
    //   56: astore_1
    //   57: aload_3
    //   58: astore_2
    //   59: aload_1
    //   60: astore_3
    //   61: aload_2
    //   62: astore_1
    //   63: ldc -118
    //   65: aload_3
    //   66: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   69: invokestatic 147	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_2
    //   73: ifnull -31 -> 42
    //   76: aload_2
    //   77: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   80: return
    //   81: astore_1
    //   82: ldc -118
    //   84: aload_1
    //   85: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   88: invokestatic 147	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: goto -11 -> 80
    //   94: astore_2
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   103: aload_2
    //   104: athrow
    //   105: astore_1
    //   106: ldc -118
    //   108: aload_1
    //   109: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   112: invokestatic 147	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: goto -12 -> 103
    //   118: astore_3
    //   119: aload_2
    //   120: astore_1
    //   121: aload_3
    //   122: astore_2
    //   123: goto -28 -> 95
    //   126: astore_3
    //   127: goto -66 -> 61
    //   130: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	NavUserBehaviour
    //   6	1	1	localObject1	Object
    //   43	4	1	localIOException1	IOException
    //   56	4	1	localException1	Exception
    //   62	1	1	localObject2	Object
    //   81	19	1	localIOException2	IOException
    //   105	4	1	localIOException3	IOException
    //   120	1	1	localObject3	Object
    //   4	73	2	localObject4	Object
    //   94	26	2	localObject5	Object
    //   122	1	2	localObject6	Object
    //   8	58	3	localException2	Exception
    //   118	4	3	localObject7	Object
    //   126	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   38	42	43	java/io/IOException
    //   9	19	56	java/lang/Exception
    //   76	80	81	java/io/IOException
    //   9	19	94	finally
    //   63	72	94	finally
    //   99	103	105	java/io/IOException
    //   19	34	118	finally
    //   19	34	126	java/lang/Exception
  }
  
  public static void destory()
  {
    if (mInstance != null) {}
    try
    {
      if (mInstance != null) {
        mInstance.dispose();
      }
      mInstance = null;
      sIsInitialized = false;
      return;
    }
    finally {}
  }
  
  private void dispose()
  {
    if (com.baidu.navisdk.util.common.LogUtil.LOGGABLE) {
      storeSimpleLog();
    }
  }
  
  private String getCityId(RouteNode paramRouteNode)
  {
    String str2 = "-1";
    String str1 = str2;
    if (paramRouteNode != null)
    {
      if (paramRouteNode.mCityID == -1) {
        break label27;
      }
      str1 = String.valueOf(paramRouteNode.mCityID);
    }
    label27:
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (paramRouteNode.mCityID != -1);
      str1 = str2;
    } while (paramRouteNode.mProvinceID == -1);
    return String.valueOf(paramRouteNode.mProvinceID);
  }
  
  private File getDataOfflineStatLogFile()
  {
    return new File(NavMapAdapter.getInstance().getDataPath() + "/bnav/offlineStatLog.txt");
  }
  
  private String getFragmentName(Fragment paramFragment)
  {
    try
    {
      paramFragment = getClass().getName();
      paramFragment = paramFragment.substring(paramFragment.lastIndexOf(".") + 1);
      return paramFragment;
    }
    catch (Throwable paramFragment) {}
    return "";
  }
  
  public static NavUserBehaviour getInstance()
  {
    if (mInstance == null) {}
    for (;;)
    {
      try
      {
        NavUserBehaviour localNavUserBehaviour = mInstance;
        if (localNavUserBehaviour != null) {}
      }
      finally {}
      try
      {
        mInstance = new NavUserBehaviour();
        NavLogUtils.e(TAG, "mtj inited:");
        if (com.baidu.navisdk.util.common.LogUtil.LOGGABLE) {
          mInstance.loadSimpleLog();
        }
        sIsInitialized = true;
        if ((mInstance != null) && (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) && (mInstance.isExistOfflineStatLogFile())) {
          mInstance.uploadOfflineStatLog();
        }
      }
      catch (Throwable localThrowable) {}
    }
    return mInstance;
  }
  
  private String getPoint(RouteNode paramRouteNode)
  {
    String str2 = "-1,-1";
    String str1 = str2;
    if (paramRouteNode != null)
    {
      str1 = str2;
      if (paramRouteNode.mGeoPoint != null) {
        str1 = String.valueOf(paramRouteNode.mGeoPoint.getLongitudeE6()) + "," + String.valueOf(paramRouteNode.mGeoPoint.getLatitudeE6());
      }
    }
    return str1;
  }
  
  private int headNaviStatistics(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Object localObject = SysOSAPIv2.getInstance();
    String str1 = ((SysOSAPIv2)localObject).getPhoneType();
    String str2 = ((SysOSAPIv2)localObject).getOSVersion();
    String str3 = ((SysOSAPIv2)localObject).getVersionName();
    localObject = ((SysOSAPIv2)localObject).getCuid();
    String str4 = SysOSAPIv2.getInstance().getChannel();
    this.headNaviStatisticsRet = 0;
    try
    {
      paramString1 = NavUserBehaviourDef.NAVI_URL + "&mode=" + URLEncoder.encode("driving", "UTF-8") + "&da_src=" + URLEncoder.encode(paramString7, "UTF-8") + "&mb=" + URLEncoder.encode(str1, "UTF-8") + "&os=" + URLEncoder.encode(str2, "UTF-8") + "&sv=" + URLEncoder.encode(str3, "UTF-8") + "&cuid=" + URLEncoder.encode((String)localObject, "UTF-8") + "&channel=" + URLEncoder.encode(str4, "UTF-8") + "&ctm=" + URLEncoder.encode(String.valueOf(System.currentTimeMillis()), "UTF-8") + "&navi_city=" + URLEncoder.encode(String.valueOf(NavCommonFuncController.getInstance().getLocationCityId()), "UTF-8") + "&sn=" + URLEncoder.encode(paramString1, "UTF-8") + "&en=" + URLEncoder.encode(paramString2, "UTF-8") + "&sc=" + URLEncoder.encode(paramString3, "UTF-8") + "&ec=" + URLEncoder.encode(paramString4, "UTF-8") + "&nav_act=" + URLEncoder.encode(paramString5, "UTF-8") + "&nav_net=" + URLEncoder.encode(paramString6, "UTF-8") + "&nav_enter=" + URLEncoder.encode(paramString7, "UTF-8");
      com.baidu.baidunavis.wrapper.LogUtil.e(TAG, "URL:" + paramString1);
      paramString2 = new BNHttpParams();
      paramString2.isAsync = false;
      BNHttpCenter.getInstance().get(paramString1, null, new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          NavUserBehaviour.access$502(NavUserBehaviour.this, paramAnonymousInt);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          NavUserBehaviour.access$502(NavUserBehaviour.this, paramAnonymousInt);
        }
      }, paramString2);
      com.baidu.baidunavis.wrapper.LogUtil.e(TAG, paramString1 + " HttpHead 服务器返回状态:" + this.headNaviStatisticsRet);
      return this.headNaviStatisticsRet;
    }
    catch (Throwable paramString1)
    {
      for (;;) {}
    }
  }
  
  private boolean isExistOfflineStatLogFile()
  {
    return getDataOfflineStatLogFile().exists();
  }
  
  public static boolean isInitialized()
  {
    return sIsInitialized;
  }
  
  /* Error */
  private void loadSimpleLog()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 382	com/baidu/baidunavis/stat/NavUserBehaviour:makesureSimpleLogFileExists	()Z
    //   4: ifeq +107 -> 111
    //   7: invokestatic 270	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   10: invokevirtual 385	com/baidu/platform/comapi/util/SysOSAPIv2:getOutputCache	()Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +70 -> 85
    //   18: aload_1
    //   19: invokevirtual 388	java/lang/String:length	()I
    //   22: ifle +63 -> 85
    //   25: new 178	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: getstatic 391	java/io/File:separator	Ljava/lang/String;
    //   39: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 17
    //   44: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_3
    //   55: new 393	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 394	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 56	com/baidu/baidunavis/stat/NavUserBehaviour:mSimpleLogProperties	Ljava/util/Properties;
    //   68: aload_1
    //   69: invokevirtual 398	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 58	com/baidu/baidunavis/stat/NavUserBehaviour:mIsPropertiesSettingOK	Z
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 399	java/io/FileInputStream:close	()V
    //   85: return
    //   86: astore_1
    //   87: aload_3
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull -5 -> 85
    //   93: aload_1
    //   94: invokevirtual 399	java/io/FileInputStream:close	()V
    //   97: return
    //   98: astore_1
    //   99: return
    //   100: astore_1
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 399	java/io/FileInputStream:close	()V
    //   109: aload_1
    //   110: athrow
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 58	com/baidu/baidunavis/stat/NavUserBehaviour:mIsPropertiesSettingOK	Z
    //   116: return
    //   117: astore_1
    //   118: return
    //   119: astore_2
    //   120: goto -11 -> 109
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload_3
    //   127: astore_1
    //   128: goto -27 -> 101
    //   131: astore_2
    //   132: goto -43 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	NavUserBehaviour
    //   13	69	1	localObject1	Object
    //   86	1	1	localException1	Exception
    //   88	6	1	localObject2	Object
    //   98	1	1	localIOException1	IOException
    //   100	10	1	localObject3	Object
    //   117	8	1	localIOException2	IOException
    //   127	1	1	localObject4	Object
    //   52	54	2	localObject5	Object
    //   119	1	2	localIOException3	IOException
    //   125	1	2	localIOException4	IOException
    //   131	1	2	localException2	Exception
    //   54	34	3	localObject6	Object
    //   123	4	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   55	64	86	java/lang/Exception
    //   93	97	98	java/io/IOException
    //   55	64	100	finally
    //   81	85	117	java/io/IOException
    //   105	109	119	java/io/IOException
    //   64	77	123	finally
    //   64	77	131	java/lang/Exception
  }
  
  private boolean makesureSimpleLogFileExists()
  {
    boolean bool2 = false;
    Object localObject = SysOSAPIv2.getInstance().getOutputCache();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((String)localObject).length() > 0)
      {
        localObject = new File((String)localObject + File.separator + "navi_simple.log");
        if (!((File)localObject).exists()) {
          break label68;
        }
        bool1 = true;
      }
    }
    return bool1;
    try
    {
      label68:
      bool1 = ((File)localObject).createNewFile();
      return bool1;
    }
    catch (IOException localIOException) {}
    return false;
  }
  
  private void onEventWithParam(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("sn", paramString1));
    localArrayList.add(new BasicNameValuePair("en", paramString2));
    localArrayList.add(new BasicNameValuePair("sc", paramString3));
    localArrayList.add(new BasicNameValuePair("ec", paramString4));
    localArrayList.add(new BasicNameValuePair("nav_act", paramString5));
    localArrayList.add(new BasicNameValuePair("nav_net", paramString6));
    localArrayList.add(new BasicNameValuePair("nav_enter", paramString7));
    localArrayList.add(new BasicNameValuePair("mode", "driving"));
    localArrayList.add(new BasicNameValuePair("da_src", paramString7));
    localArrayList.add(new BasicNameValuePair("ctm", String.valueOf(System.currentTimeMillis())));
    localArrayList.add(new BasicNameValuePair("navi_city", String.valueOf(NavCommonFuncController.getInstance().getLocationCityId())));
    int i = 0;
    if ("navi".equals(paramString5)) {
      i = 50010;
    }
    for (;;)
    {
      com.baidu.baidunavis.wrapper.LogUtil.e(TAG, "NavUserBehaviour,onEventWithParam  naviAction " + paramString5 + " eventId " + i + " naviNet " + paramString6 + " naviEnter " + paramString7);
      BNStatisticsManager.getInstance().onEventWithParam(i, null, localArrayList);
      return;
      if ("edog".equals(paramString5)) {
        i = 50009;
      } else if ("yaw".equals(paramString5)) {
        i = 50011;
      } else if ("route_plan".equals(paramString5)) {
        i = 50012;
      } else if ("download".equals(paramString5)) {
        i = 50013;
      } else if ("settings".equals(paramString5)) {
        i = 50014;
      }
    }
  }
  
  public static void setIsNeedSendNaviStartMTJLog(boolean paramBoolean)
  {
    mIsNeedSendNaviStartMTJLog = paramBoolean;
  }
  
  /* Error */
  private void storeSimpleLog()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/baidu/baidunavis/stat/NavUserBehaviour:mIsPropertiesSettingOK	Z
    //   4: ifeq +83 -> 87
    //   7: invokestatic 270	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   10: invokevirtual 385	com/baidu/platform/comapi/util/SysOSAPIv2:getOutputCache	()Ljava/lang/String;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +72 -> 87
    //   18: aload_1
    //   19: invokevirtual 388	java/lang/String:length	()I
    //   22: ifle +65 -> 87
    //   25: new 178	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   32: aload_1
    //   33: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: getstatic 391	java/io/File:separator	Ljava/lang/String;
    //   39: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 17
    //   44: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_3
    //   55: new 113	java/io/FileOutputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 475	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 56	com/baidu/baidunavis/stat/NavUserBehaviour:mSimpleLogProperties	Ljava/util/Properties;
    //   68: aload_1
    //   69: ldc_w 477
    //   72: invokevirtual 481	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   75: aload_1
    //   76: invokevirtual 133	java/io/FileOutputStream:flush	()V
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   87: return
    //   88: astore_1
    //   89: aload_3
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull -5 -> 87
    //   95: aload_1
    //   96: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   99: return
    //   100: astore_1
    //   101: return
    //   102: astore_1
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   111: aload_1
    //   112: athrow
    //   113: astore_1
    //   114: return
    //   115: astore_2
    //   116: goto -5 -> 111
    //   119: astore_3
    //   120: aload_1
    //   121: astore_2
    //   122: aload_3
    //   123: astore_1
    //   124: goto -21 -> 103
    //   127: astore_2
    //   128: goto -37 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	NavUserBehaviour
    //   13	71	1	localObject1	Object
    //   88	1	1	localException1	Exception
    //   90	6	1	localObject2	Object
    //   100	1	1	localIOException1	IOException
    //   102	10	1	localObject3	Object
    //   113	8	1	localIOException2	IOException
    //   123	1	1	localObject4	Object
    //   52	56	2	localObject5	Object
    //   115	1	2	localIOException3	IOException
    //   121	1	2	localIOException4	IOException
    //   127	1	2	localException2	Exception
    //   54	36	3	localObject6	Object
    //   119	4	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   55	64	88	java/lang/Exception
    //   95	99	100	java/io/IOException
    //   55	64	102	finally
    //   83	87	113	java/io/IOException
    //   107	111	115	java/io/IOException
    //   64	79	119	finally
    //   64	79	127	java/lang/Exception
  }
  
  private void updateSimpleLogCount(String paramString)
  {
    if (this.mIsPropertiesSettingOK) {}
    try
    {
      int i = Integer.parseInt(this.mSimpleLogProperties.getProperty(paramString, "0"));
      this.mSimpleLogProperties.setProperty(paramString, "" + (i + 1));
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void uploadOfflineStatLog()
  {
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-uploadOfflineStatLog", null)new BNWorkerConfig
    {
      /* Error */
      protected String execute()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   4: invokestatic 37	com/baidu/baidunavis/stat/NavUserBehaviour:access$600	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;)Ljava/util/ArrayList;
        //   7: ifnonnull +18 -> 25
        //   10: aload_0
        //   11: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   14: new 39	java/util/ArrayList
        //   17: dup
        //   18: invokespecial 41	java/util/ArrayList:<init>	()V
        //   21: invokestatic 45	com/baidu/baidunavis/stat/NavUserBehaviour:access$602	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;Ljava/util/ArrayList;)Ljava/util/ArrayList;
        //   24: pop
        //   25: aload_0
        //   26: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   29: invokestatic 49	com/baidu/baidunavis/stat/NavUserBehaviour:access$700	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;)Ljava/io/File;
        //   32: astore 7
        //   34: aconst_null
        //   35: astore 8
        //   37: aconst_null
        //   38: astore 6
        //   40: aconst_null
        //   41: astore 9
        //   43: new 51	java/io/BufferedReader
        //   46: dup
        //   47: new 53	java/io/FileReader
        //   50: dup
        //   51: aload 7
        //   53: invokespecial 56	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   56: invokespecial 59	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   59: astore 7
        //   61: aload 7
        //   63: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   66: astore 6
        //   68: aload 6
        //   70: ifnull +106 -> 176
        //   73: ldc 64
        //   75: aload 6
        //   77: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   80: istore 5
        //   82: iload 5
        //   84: ifeq +34 -> 118
        //   87: aload 7
        //   89: ifnull +422 -> 511
        //   92: aload 7
        //   94: invokevirtual 73	java/io/BufferedReader:close	()V
        //   97: aconst_null
        //   98: areturn
        //   99: astore 6
        //   101: ldc 75
        //   103: aload 6
        //   105: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
        //   108: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   111: goto -14 -> 97
        //   114: astore 6
        //   116: aconst_null
        //   117: areturn
        //   118: aload_0
        //   119: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   122: invokestatic 37	com/baidu/baidunavis/stat/NavUserBehaviour:access$600	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;)Ljava/util/ArrayList;
        //   125: aload 6
        //   127: invokevirtual 87	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   130: pop
        //   131: goto -70 -> 61
        //   134: astore 8
        //   136: aload 7
        //   138: astore 6
        //   140: ldc 75
        //   142: aload 8
        //   144: invokevirtual 88	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
        //   147: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   150: aload 7
        //   152: ifnull +8 -> 160
        //   155: aload 7
        //   157: invokevirtual 73	java/io/BufferedReader:close	()V
        //   160: aload_0
        //   161: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   164: invokestatic 37	com/baidu/baidunavis/stat/NavUserBehaviour:access$600	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;)Ljava/util/ArrayList;
        //   167: astore 6
        //   169: aload 6
        //   171: ifnonnull +138 -> 309
        //   174: aconst_null
        //   175: areturn
        //   176: aload 7
        //   178: ifnull +330 -> 508
        //   181: aload 7
        //   183: invokevirtual 73	java/io/BufferedReader:close	()V
        //   186: goto -26 -> 160
        //   189: astore 6
        //   191: ldc 75
        //   193: aload 6
        //   195: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
        //   198: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   201: goto -15 -> 186
        //   204: astore 6
        //   206: ldc 75
        //   208: aload 6
        //   210: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
        //   213: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   216: goto -56 -> 160
        //   219: astore 6
        //   221: aload 8
        //   223: astore 7
        //   225: aload 6
        //   227: astore 8
        //   229: aload 7
        //   231: astore 6
        //   233: ldc 75
        //   235: aload 8
        //   237: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
        //   240: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   243: aload 7
        //   245: ifnull -85 -> 160
        //   248: aload 7
        //   250: invokevirtual 73	java/io/BufferedReader:close	()V
        //   253: goto -93 -> 160
        //   256: astore 6
        //   258: ldc 75
        //   260: aload 6
        //   262: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
        //   265: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   268: goto -15 -> 253
        //   271: astore 8
        //   273: aload 6
        //   275: astore 7
        //   277: aload 8
        //   279: astore 6
        //   281: aload 7
        //   283: ifnull +8 -> 291
        //   286: aload 7
        //   288: invokevirtual 73	java/io/BufferedReader:close	()V
        //   291: aload 6
        //   293: athrow
        //   294: astore 7
        //   296: ldc 75
        //   298: aload 7
        //   300: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
        //   303: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   306: goto -15 -> 291
        //   309: aload_0
        //   310: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   313: invokestatic 92	com/baidu/baidunavis/stat/NavUserBehaviour:access$800	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;)V
        //   316: iconst_0
        //   317: istore_1
        //   318: iload_1
        //   319: aload_0
        //   320: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   323: invokestatic 37	com/baidu/baidunavis/stat/NavUserBehaviour:access$600	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;)Ljava/util/ArrayList;
        //   326: invokevirtual 96	java/util/ArrayList:size	()I
        //   329: if_icmpge -213 -> 116
        //   332: aload_0
        //   333: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   336: invokestatic 37	com/baidu/baidunavis/stat/NavUserBehaviour:access$600	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;)Ljava/util/ArrayList;
        //   339: iload_1
        //   340: invokevirtual 100	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   343: checkcast 66	java/lang/String
        //   346: ldc 102
        //   348: invokevirtual 106	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   351: astore 6
        //   353: aload 6
        //   355: arraylength
        //   356: bipush 7
        //   358: if_icmpne +155 -> 513
        //   361: iconst_0
        //   362: istore 4
        //   364: iconst_3
        //   365: istore_2
        //   366: iload 4
        //   368: istore_3
        //   369: iload_2
        //   370: ifle +55 -> 425
        //   373: aload_0
        //   374: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   377: aload 6
        //   379: iconst_0
        //   380: aaload
        //   381: aload 6
        //   383: iconst_1
        //   384: aaload
        //   385: aload 6
        //   387: iconst_2
        //   388: aaload
        //   389: aload 6
        //   391: iconst_3
        //   392: aaload
        //   393: aload 6
        //   395: iconst_4
        //   396: aaload
        //   397: aload 6
        //   399: iconst_5
        //   400: aaload
        //   401: aload 6
        //   403: bipush 6
        //   405: aaload
        //   406: invokestatic 110	com/baidu/baidunavis/stat/NavUserBehaviour:access$300	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   409: sipush 200
        //   412: if_icmpne +41 -> 453
        //   415: iconst_1
        //   416: istore_3
        //   417: getstatic 114	com/baidu/baidunavis/stat/NavUserBehaviour$3:TAG	Ljava/lang/String;
        //   420: ldc 116
        //   422: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   425: iload_3
        //   426: ifne +87 -> 513
        //   429: aload_0
        //   430: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   433: aload_0
        //   434: getfield 16	com/baidu/baidunavis/stat/NavUserBehaviour$3:this$0	Lcom/baidu/baidunavis/stat/NavUserBehaviour;
        //   437: invokestatic 37	com/baidu/baidunavis/stat/NavUserBehaviour:access$600	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;)Ljava/util/ArrayList;
        //   440: iload_1
        //   441: invokevirtual 100	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   444: checkcast 66	java/lang/String
        //   447: invokestatic 120	com/baidu/baidunavis/stat/NavUserBehaviour:access$400	(Lcom/baidu/baidunavis/stat/NavUserBehaviour;Ljava/lang/String;)V
        //   450: goto +63 -> 513
        //   453: iload_2
        //   454: iconst_1
        //   455: isub
        //   456: istore_3
        //   457: iload_3
        //   458: istore_2
        //   459: iload_3
        //   460: ifle -94 -> 366
        //   463: getstatic 114	com/baidu/baidunavis/stat/NavUserBehaviour$3:TAG	Ljava/lang/String;
        //   466: ldc 122
        //   468: invokestatic 84	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   471: ldc2_w 123
        //   474: invokestatic 130	java/lang/Thread:sleep	(J)V
        //   477: iload_3
        //   478: istore_2
        //   479: goto -113 -> 366
        //   482: astore 7
        //   484: iload_3
        //   485: istore_2
        //   486: goto -120 -> 366
        //   489: astore 6
        //   491: goto -210 -> 281
        //   494: astore 8
        //   496: goto -267 -> 229
        //   499: astore 8
        //   501: aload 9
        //   503: astore 7
        //   505: goto -369 -> 136
        //   508: goto -348 -> 160
        //   511: aconst_null
        //   512: areturn
        //   513: iload_1
        //   514: iconst_1
        //   515: iadd
        //   516: istore_1
        //   517: goto -199 -> 318
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	520	0	this	3
        //   317	200	1	i	int
        //   365	121	2	j	int
        //   368	117	3	k	int
        //   362	5	4	m	int
        //   80	3	5	bool	boolean
        //   38	38	6	str	String
        //   99	5	6	localIOException1	IOException
        //   114	12	6	localException	Exception
        //   138	32	6	localObject1	Object
        //   189	5	6	localIOException2	IOException
        //   204	5	6	localIOException3	IOException
        //   219	7	6	localIOException4	IOException
        //   231	1	6	localObject2	Object
        //   256	18	6	localIOException5	IOException
        //   279	123	6	localObject3	Object
        //   489	1	6	localObject4	Object
        //   32	255	7	localObject5	Object
        //   294	5	7	localIOException6	IOException
        //   482	1	7	localInterruptedException	InterruptedException
        //   503	1	7	localObject6	Object
        //   35	1	8	localObject7	Object
        //   134	88	8	localFileNotFoundException1	java.io.FileNotFoundException
        //   227	9	8	localObject8	Object
        //   271	7	8	localObject9	Object
        //   494	1	8	localIOException7	IOException
        //   499	1	8	localFileNotFoundException2	java.io.FileNotFoundException
        //   41	461	9	localObject10	Object
        // Exception table:
        //   from	to	target	type
        //   92	97	99	java/io/IOException
        //   0	25	114	java/lang/Exception
        //   25	34	114	java/lang/Exception
        //   92	97	114	java/lang/Exception
        //   101	111	114	java/lang/Exception
        //   155	160	114	java/lang/Exception
        //   160	169	114	java/lang/Exception
        //   181	186	114	java/lang/Exception
        //   191	201	114	java/lang/Exception
        //   206	216	114	java/lang/Exception
        //   248	253	114	java/lang/Exception
        //   258	268	114	java/lang/Exception
        //   286	291	114	java/lang/Exception
        //   291	294	114	java/lang/Exception
        //   296	306	114	java/lang/Exception
        //   309	316	114	java/lang/Exception
        //   318	361	114	java/lang/Exception
        //   373	415	114	java/lang/Exception
        //   417	425	114	java/lang/Exception
        //   429	450	114	java/lang/Exception
        //   463	471	114	java/lang/Exception
        //   471	477	114	java/lang/Exception
        //   61	68	134	java/io/FileNotFoundException
        //   73	82	134	java/io/FileNotFoundException
        //   118	131	134	java/io/FileNotFoundException
        //   181	186	189	java/io/IOException
        //   155	160	204	java/io/IOException
        //   43	61	219	java/io/IOException
        //   248	253	256	java/io/IOException
        //   43	61	271	finally
        //   140	150	271	finally
        //   233	243	271	finally
        //   286	291	294	java/io/IOException
        //   471	477	482	java/lang/InterruptedException
        //   61	68	489	finally
        //   73	82	489	finally
        //   118	131	489	finally
        //   61	68	494	java/io/IOException
        //   73	82	494	java/io/IOException
        //   118	131	494	java/io/IOException
        //   43	61	499	java/io/FileNotFoundException
      }
    }, new BNWorkerConfig(102, 0));
  }
  
  /* Error */
  private void writeDataOfflineStatLogToFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 102	com/baidu/baidunavis/stat/NavUserBehaviour:getDataOfflineStatLogFile	()Ljava/io/File;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 4
    //   10: new 113	java/io/FileOutputStream
    //   13: dup
    //   14: aload_3
    //   15: iconst_1
    //   16: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   19: astore_3
    //   20: aload_3
    //   21: aload_1
    //   22: ldc 120
    //   24: invokevirtual 126	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   27: invokevirtual 130	java/io/FileOutputStream:write	([B)V
    //   30: aload_3
    //   31: ldc_w 519
    //   34: invokestatic 522	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 525	java/lang/String:getBytes	()[B
    //   40: invokevirtual 130	java/io/FileOutputStream:write	([B)V
    //   43: aload_3
    //   44: invokevirtual 133	java/io/FileOutputStream:flush	()V
    //   47: aload_3
    //   48: ifnull +96 -> 144
    //   51: aload_3
    //   52: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   55: return
    //   56: astore_1
    //   57: ldc -118
    //   59: aload_1
    //   60: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   63: invokestatic 147	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: goto -11 -> 55
    //   69: astore_3
    //   70: aload 4
    //   72: astore_1
    //   73: aload_1
    //   74: astore_2
    //   75: ldc -118
    //   77: aload_3
    //   78: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   81: invokestatic 147	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_1
    //   85: ifnull -30 -> 55
    //   88: aload_1
    //   89: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   92: return
    //   93: astore_1
    //   94: ldc -118
    //   96: aload_1
    //   97: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   100: invokestatic 147	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: goto -11 -> 92
    //   106: astore_1
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_2
    //   118: ldc -118
    //   120: aload_2
    //   121: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   124: invokestatic 147	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: goto -12 -> 115
    //   130: astore_1
    //   131: aload_3
    //   132: astore_2
    //   133: goto -26 -> 107
    //   136: astore_2
    //   137: aload_3
    //   138: astore_1
    //   139: aload_2
    //   140: astore_3
    //   141: goto -68 -> 73
    //   144: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	NavUserBehaviour
    //   0	145	1	paramString	String
    //   6	106	2	str	String
    //   117	4	2	localIOException	IOException
    //   132	1	2	localException1	Exception
    //   136	4	2	localException2	Exception
    //   4	48	3	localObject1	Object
    //   69	69	3	localException3	Exception
    //   140	1	3	localObject2	Object
    //   8	63	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   51	55	56	java/io/IOException
    //   10	20	69	java/lang/Exception
    //   88	92	93	java/io/IOException
    //   10	20	106	finally
    //   75	84	106	finally
    //   111	115	117	java/io/IOException
    //   20	47	130	finally
    //   20	47	136	java/lang/Exception
  }
  
  public void resetNaviStatItem()
  {
    try
    {
      NaviStatItem.getInstance().init();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void sendBehaviourLog(String paramString)
  {
    com.baidu.baidunavis.wrapper.LogUtil.e(TAG, "MTJ behaviour:" + paramString);
  }
  
  public void sendNaviStatistics(final RouteNode paramRouteNode1, final RouteNode paramRouteNode2, final String paramString1, final String paramString2, final String paramString3)
  {
    try
    {
      BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("sendNaviStatistics", null)new BNWorkerConfig
      {
        protected String execute()
        {
          try
          {
            String str1 = NavUserBehaviour.this.getPoint(paramRouteNode1);
            String str2 = NavUserBehaviour.this.getPoint(paramRouteNode2);
            String str3 = NavUserBehaviour.this.getCityId(paramRouteNode1);
            String str4 = NavUserBehaviour.this.getCityId(paramRouteNode2);
            NavUserBehaviour.this.onEventWithParam(str1, str2, str3, str4, paramString1, paramString2, paramString3);
            int k = 0;
            int i = 3;
            int j = k;
            if (i > 0)
            {
              if (NavUserBehaviour.this.headNaviStatistics(str1, str2, str3, str4, paramString1, paramString2, paramString3) == 200)
              {
                j = 1;
                com.baidu.baidunavis.wrapper.LogUtil.e(TAG, "NETWORK_NORMAL,Send Statistics Success! ");
              }
            }
            else
            {
              if (j != 0) {
                break label404;
              }
              if (!"navi".equals(paramString1)) {
                break label284;
              }
              NavUserBehaviour.this.sendUserdataCollect("navi_enter_offline_navi");
            }
            for (;;)
            {
              NavUserBehaviour.this.writeDataOfflineStatLogToFile(str1 + " " + str2 + " " + str3 + " " + str4 + " " + paramString1 + " " + paramString2 + " " + paramString3);
              break label404;
              j = i - 1;
              i = j;
              if (j <= 0) {
                break;
              }
              com.baidu.baidunavis.wrapper.LogUtil.e(TAG, "NETWORK ERROR, try again! ");
              try
              {
                Thread.sleep(1000L);
                i = j;
              }
              catch (InterruptedException localInterruptedException)
              {
                i = j;
              }
              break;
              label284:
              if ("edog".equals(paramString1)) {
                NavUserBehaviour.this.sendUserdataCollect("navi_enter_edog");
              } else if ("yaw".equals(paramString1)) {
                NavUserBehaviour.this.sendUserdataCollect("navi_enter_yaw");
              } else if ("route_plan".equals(paramString1)) {
                NavUserBehaviour.this.sendUserdataCollect("navi_enter_route_plan");
              } else if ("download".equals(paramString1)) {
                NavUserBehaviour.this.sendUserdataCollect("navi_enter_download");
              } else if ("settings".equals(paramString1)) {
                NavUserBehaviour.this.sendUserdataCollect("navi_enter_settings");
              }
            }
          }
          catch (Exception localException)
          {
            label404:
            for (;;) {}
          }
          return null;
        }
      }, new BNWorkerConfig(102, 0));
      return;
    }
    catch (Throwable paramRouteNode1) {}
  }
  
  public void sendNaviStatisticsTransfer(RoutePlanNode paramRoutePlanNode1, RoutePlanNode paramRoutePlanNode2, String paramString1, String paramString2, String paramString3)
  {
    if ((paramRoutePlanNode1 == null) || (paramRoutePlanNode2 == null)) {
      return;
    }
    RouteNode localRouteNode1 = new RouteNode();
    RouteNode localRouteNode2 = new RouteNode();
    localRouteNode1.mCityID = paramRoutePlanNode1.mDistrictID;
    localRouteNode2.mCityID = paramRoutePlanNode2.mDistrictID;
    localRouteNode1.mGeoPoint = new NavGeoPoint(paramRoutePlanNode1.getLongitudeE6(), paramRoutePlanNode1.getLatitudeE6());
    localRouteNode2.mGeoPoint = new NavGeoPoint(paramRoutePlanNode2.getLongitudeE6(), paramRoutePlanNode2.getLatitudeE6());
    sendNaviStatistics(localRouteNode1, localRouteNode2, paramString1, paramString2, paramString3);
  }
  
  public void sendUserdataCollect(String paramString)
  {
    com.baidu.baidunavis.wrapper.LogUtil.e(TAG, "UserdataCollect behaviour:" + paramString);
    a.a().a("mode", "nav");
    a.a().a(paramString);
  }
  
  public void statNaviIntentTime()
  {
    try
    {
      NaviStatItem.getInstance().setNaviIntentTime(SystemClock.elapsedRealtime());
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void statNaviIntentTime2()
  {
    try
    {
      NaviStatItem.getInstance().init();
      NaviStatItem.getInstance().setNaviIntentTime2(SystemClock.elapsedRealtime());
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/stat/NavUserBehaviour.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */