package com.baidu.baidunavis.model;

import android.app.Activity;
import android.content.Context;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.GetOuterActivityListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import java.io.File;

public class NavCommonFuncModel
{
  public static final int NAVI_TIME_TYPE_POI = 2;
  public static final int NAVI_TIME_TYPE_ROUTE_PAGE = 1;
  public static final String TASK_NAVI_BACK = "task_navi_back";
  public static final int WRITING_SETTING_ID = 969;
  public static int mCPUNeonFeature;
  private static NavCommonFuncModel sInstance = null;
  public static boolean sIsAnologNavi;
  public static boolean sIsManullyBack = false;
  public static int sNaviTimeType;
  public static long sPoiToNaviTime1 = 0L;
  public static long sRoutePageToNaviTime1;
  private String mBaiduMapAPPFolderName = null;
  public RoutePlanNode mEndNode = new RoutePlanNode();
  public boolean mHasRequestReadPhoneStatePermission = false;
  public boolean mIsAppForeground = true;
  public boolean mIsOnRestoreInstanceData = false;
  public boolean mMapBrightState;
  public long mMapEnd1Time = -1L;
  public long mMapEnd2Time = -1L;
  public long mMapStartTime = -1L;
  public long mNaviEndTime = -1L;
  public long mNaviStartTime = -1L;
  private String mSDCardBaiduMapBasePath = null;
  private String mSDCardNaviBasePath = null;
  private String mSDCardRootPath = null;
  private Activity sCachedActivity;
  private Context sCachedContext;
  
  static
  {
    sIsAnologNavi = false;
    mCPUNeonFeature = -1;
    sNaviTimeType = -1;
    sRoutePageToNaviTime1 = 0L;
  }
  
  private NavCommonFuncModel()
  {
    initPath();
  }
  
  public static NavCommonFuncModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavCommonFuncModel();
    }
    return sInstance;
  }
  
  private boolean initContextModule(Activity paramActivity)
  {
    try
    {
      BNaviModuleManager.setGetOuterActivityListener(new BNaviModuleManager.GetOuterActivityListener()
      {
        public Activity getNaviActivity()
        {
          return NavCommonFuncModel.getInstance().getNaviActivity();
        }
        
        public Activity getOuterActivity()
        {
          return NavCommonFuncModel.getInstance().getActivity();
        }
      });
      ScreenUtil.getInstance().init(paramActivity);
      BNaviModuleManager.setContext(paramActivity);
      BNaviModuleManager.setActivity(paramActivity);
      BNSettingManager.init(paramActivity);
      return true;
    }
    catch (Throwable paramActivity) {}
    return false;
  }
  
  private boolean initPath()
  {
    boolean bool2 = false;
    try
    {
      this.mSDCardRootPath = SysOSAPIv2.getInstance().getSdcardPath();
      boolean bool1 = bool2;
      if (NavMapAdapter.getInstance().getStorageSettingsInstance() != null)
      {
        bool1 = bool2;
        if (NavMapAdapter.getInstance().getCurrentStorage() != null)
        {
          this.mSDCardBaiduMapBasePath = NavMapAdapter.getInstance().getDataPath();
          this.mSDCardNaviBasePath = (this.mSDCardBaiduMapBasePath + File.separator + "bnav");
          this.mBaiduMapAPPFolderName = NavMapAdapter.getInstance().getDataFolderName();
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  /* Error */
  public static boolean isNeonCpuFeature()
  {
    // Byte code:
    //   0: getstatic 56	com/baidu/baidunavis/model/NavCommonFuncModel:mCPUNeonFeature	I
    //   3: iconst_1
    //   4: if_icmpne +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: getstatic 56	com/baidu/baidunavis/model/NavCommonFuncModel:mCPUNeonFeature	I
    //   12: ifne +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aconst_null
    //   18: astore_2
    //   19: aconst_null
    //   20: astore_3
    //   21: aload_2
    //   22: astore_1
    //   23: sipush 1024
    //   26: newarray <illegal type>
    //   28: astore 4
    //   30: aload_2
    //   31: astore_1
    //   32: new 189	java/io/RandomAccessFile
    //   35: dup
    //   36: ldc -65
    //   38: ldc -63
    //   40: invokespecial 196	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: astore_2
    //   44: aload_2
    //   45: aload 4
    //   47: invokevirtual 200	java/io/RandomAccessFile:read	([B)I
    //   50: pop
    //   51: new 202	java/lang/String
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 205	java/lang/String:<init>	([B)V
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_0
    //   63: invokevirtual 209	java/lang/String:indexOf	(I)I
    //   66: istore_0
    //   67: iload_0
    //   68: iconst_m1
    //   69: if_icmpeq +37 -> 106
    //   72: aload_1
    //   73: iconst_0
    //   74: iload_0
    //   75: invokevirtual 213	java/lang/String:substring	(II)Ljava/lang/String;
    //   78: astore_1
    //   79: aload_2
    //   80: ifnull +105 -> 185
    //   83: aload_2
    //   84: invokevirtual 216	java/io/RandomAccessFile:close	()V
    //   87: aload_1
    //   88: ifnull +75 -> 163
    //   91: aload_1
    //   92: ldc -38
    //   94: invokevirtual 222	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   97: ifne +66 -> 163
    //   100: iconst_0
    //   101: putstatic 56	com/baidu/baidunavis/model/NavCommonFuncModel:mCPUNeonFeature	I
    //   104: iconst_0
    //   105: ireturn
    //   106: goto -27 -> 79
    //   109: astore_2
    //   110: goto -23 -> 87
    //   113: astore_1
    //   114: aload_3
    //   115: astore_2
    //   116: aload_1
    //   117: astore_3
    //   118: ldc -32
    //   120: astore 4
    //   122: aload_2
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 227	java/lang/Exception:printStackTrace	()V
    //   128: aload 4
    //   130: astore_1
    //   131: aload_2
    //   132: ifnull -45 -> 87
    //   135: aload_2
    //   136: invokevirtual 216	java/io/RandomAccessFile:close	()V
    //   139: aload 4
    //   141: astore_1
    //   142: goto -55 -> 87
    //   145: astore_1
    //   146: aload 4
    //   148: astore_1
    //   149: goto -62 -> 87
    //   152: astore_2
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 216	java/io/RandomAccessFile:close	()V
    //   161: aload_2
    //   162: athrow
    //   163: iconst_1
    //   164: putstatic 56	com/baidu/baidunavis/model/NavCommonFuncModel:mCPUNeonFeature	I
    //   167: iconst_1
    //   168: ireturn
    //   169: astore_1
    //   170: goto -9 -> 161
    //   173: astore_3
    //   174: aload_2
    //   175: astore_1
    //   176: aload_3
    //   177: astore_2
    //   178: goto -25 -> 153
    //   181: astore_3
    //   182: goto -64 -> 118
    //   185: goto -98 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	9	0	i	int
    //   22	70	1	localObject1	Object
    //   113	4	1	localException1	Exception
    //   123	19	1	localObject2	Object
    //   145	1	1	localIOException1	java.io.IOException
    //   148	10	1	localObject3	Object
    //   169	1	1	localIOException2	java.io.IOException
    //   175	1	1	localObject4	Object
    //   18	66	2	localRandomAccessFile	java.io.RandomAccessFile
    //   109	1	2	localIOException3	java.io.IOException
    //   115	21	2	localObject5	Object
    //   152	23	2	localObject6	Object
    //   177	1	2	localObject7	Object
    //   20	105	3	localObject8	Object
    //   173	4	3	localObject9	Object
    //   181	1	3	localException2	Exception
    //   28	119	4	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   83	87	109	java/io/IOException
    //   23	30	113	java/lang/Exception
    //   32	44	113	java/lang/Exception
    //   135	139	145	java/io/IOException
    //   23	30	152	finally
    //   32	44	152	finally
    //   124	128	152	finally
    //   157	161	169	java/io/IOException
    //   44	67	173	finally
    //   72	79	173	finally
    //   44	67	181	java/lang/Exception
    //   72	79	181	java/lang/Exception
  }
  
  public Activity getActivity()
  {
    if (NavMapAdapter.getInstance().getContainerActivity() != null) {
      return NavMapAdapter.getInstance().getContainerActivity();
    }
    return this.sCachedActivity;
  }
  
  public Context getContext()
  {
    if (NavMapAdapter.getInstance().getContainerActivity() != null) {
      return NavMapAdapter.getInstance().getContainerActivity();
    }
    return this.sCachedContext;
  }
  
  public Activity getNaviActivity()
  {
    return getActivity();
  }
  
  public String getSDCardBaiduMapBasePath()
  {
    return this.mSDCardBaiduMapBasePath;
  }
  
  public String getSDCardNaviBasePath()
  {
    return this.mSDCardNaviBasePath;
  }
  
  public String getSDCardRootPath()
  {
    return this.mSDCardRootPath;
  }
  
  public boolean initParams(Activity paramActivity)
  {
    if (!initContextModule(paramActivity)) {
      return false;
    }
    return initPath();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/model/NavCommonFuncModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */