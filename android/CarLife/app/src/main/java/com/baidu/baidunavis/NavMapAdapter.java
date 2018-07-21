package com.baidu.baidunavis;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.baidu.baidunavis.control.MapSearchAPIWrapper;
import com.baidu.baidunavis.control.NavCommonFuncController;
import com.baidu.baidunavis.control.NavInitController;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.model.NavCarInfo;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavGeoPoint;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.d;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.common.mapview.MapViewConfig;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.mapframework.common.util.FileUtils;
import com.baidu.mapframework.common.util.StorageInformation;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.mapframework.widget.MProgressDialog;
import com.baidu.mapframework.widget.MToast;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.track.util.TrackInsertDataBackground;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.download.BNDownloadUIManager;
import com.baidu.navisdk.ui.download.BNDownloadUIManager.OnNewVersionListener;
import com.baidu.navisdk.ui.routeguide.control.RGCarPreferSettingController;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapViewInterface;
import java.io.Closeable;
import java.util.ArrayList;

public class NavMapAdapter
{
  public static final int CAR_NAVI_PERMISSIONS = 8;
  public static final String ENERGY_REQUESTID_BUNDLE_KEY = "energy_requestid_bundle_key";
  public static final int MCarRoute = 18;
  public static final String NAVI_ENERGY_PROMOTE_EVENT = "NaviEnergyOperation";
  public static final String TAG = NavMapAdapter.class.getSimpleName();
  public static final String WEBSHELL_FLAG_KEY = "webshell_flag_key";
  public static final String WEBVIEW_URL_KEY = "webview_url";
  private static NavMapAdapter me;
  public static int nPageTime = 0;
  public static boolean sMonkey = false;
  public static final boolean sPageJumpEnable = false;
  public static boolean showBottomBarSwitch = false;
  private String[] mBNMapTasks = new String[0];
  private int mMapPushState;
  private ArrayList<PageUnit> mPageUnits = null;
  private int nPageindex = 0;
  
  public static Bundle MC2LL(int paramInt1, int paramInt2)
  {
    double d1 = paramInt1;
    double d2 = paramInt2;
    try
    {
      Point localPoint = CoordinateUtil.bd09mcTogcj02ll(d1, d2);
      if (localPoint != null)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putDouble("LLx", localPoint.getDoubleX());
        localBundle2.putDouble("LLy", localPoint.getDoubleY());
        return localBundle2;
      }
    }
    catch (Throwable localThrowable)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putDouble("LLx", 0.0D);
      localBundle1.putDouble("LLy", 0.0D);
      return localBundle1;
    }
  }
  
  public static Bundle MC2LLE6(int paramInt1, int paramInt2)
  {
    Bundle localBundle = MC2LL(paramInt1, paramInt2);
    if (localBundle == null)
    {
      localBundle = new Bundle();
      localBundle.putInt("LLx", 0);
      localBundle.putInt("LLy", 0);
      return localBundle;
    }
    paramInt1 = (int)(localBundle.getDouble("LLx") * 100000.0D);
    paramInt2 = (int)(localBundle.getDouble("LLy") * 100000.0D);
    localBundle.putInt("LLx", paramInt1);
    localBundle.putInt("LLy", paramInt2);
    return localBundle;
  }
  
  public static void destroy() {}
  
  public static NavMapAdapter getInstance()
  {
    if (me == null) {
      me = new NavMapAdapter();
    }
    return me;
  }
  
  public static void importSettingToNaviSDK(Context paramContext)
  {
    NavCommonFuncController.importSettingToNaviSDK(paramContext);
  }
  
  /* Error */
  private ArrayList<PageUnit> readPageUnit()
  {
    // Byte code:
    //   0: new 160	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 161	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 163	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   16: invokestatic 169	com/baidu/mapframework/common/util/StorageSettings:getInstance	()Lcom/baidu/mapframework/common/util/StorageSettings;
    //   19: invokevirtual 173	com/baidu/mapframework/common/util/StorageSettings:getCurrentStorage	()Lcom/baidu/mapframework/common/util/StorageInformation;
    //   22: invokevirtual 178	com/baidu/mapframework/common/util/StorageInformation:getRootPath	()Ljava/lang/String;
    //   25: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc -72
    //   30: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: ldc -67
    //   39: new 163	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   46: ldc -65
    //   48: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc -63
    //   57: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc -61
    //   62: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 201	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: new 203	java/io/File
    //   74: dup
    //   75: aload_2
    //   76: ldc -61
    //   78: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: astore 6
    //   83: aload 6
    //   85: invokevirtual 209	java/io/File:createNewFile	()Z
    //   88: pop
    //   89: invokestatic 215	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   92: astore 4
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: astore_2
    //   98: aload 4
    //   100: ifnull +9 -> 109
    //   103: aload 4
    //   105: invokevirtual 219	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   108: astore_2
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 4
    //   114: astore_3
    //   115: aload_2
    //   116: ifnull +10 -> 126
    //   119: aload_2
    //   120: aload 6
    //   122: invokevirtual 225	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/File;)Lorg/w3c/dom/Document;
    //   125: astore_3
    //   126: aconst_null
    //   127: astore 4
    //   129: aload_3
    //   130: ifnull +11 -> 141
    //   133: aload_3
    //   134: invokeinterface 231 1 0
    //   139: astore 4
    //   141: aconst_null
    //   142: astore_2
    //   143: aload 4
    //   145: ifnull +13 -> 158
    //   148: aload 4
    //   150: ldc -23
    //   152: invokeinterface 239 2 0
    //   157: astore_2
    //   158: iconst_0
    //   159: istore_1
    //   160: aload_2
    //   161: ifnull +178 -> 339
    //   164: iload_1
    //   165: aload_2
    //   166: invokeinterface 245 1 0
    //   171: if_icmpge +168 -> 339
    //   174: aload_2
    //   175: iload_1
    //   176: invokeinterface 249 2 0
    //   181: checkcast 235	org/w3c/dom/Element
    //   184: astore 4
    //   186: new 24	com/baidu/baidunavis/NavMapAdapter$PageUnit
    //   189: dup
    //   190: aload_0
    //   191: invokespecial 252	com/baidu/baidunavis/NavMapAdapter$PageUnit:<init>	(Lcom/baidu/baidunavis/NavMapAdapter;)V
    //   194: astore_3
    //   195: aload_3
    //   196: aload 4
    //   198: ldc -2
    //   200: invokeinterface 258 2 0
    //   205: putfield 260	com/baidu/baidunavis/NavMapAdapter$PageUnit:name	Ljava/lang/String;
    //   208: aload_3
    //   209: aload 4
    //   211: ldc_w 262
    //   214: invokeinterface 258 2 0
    //   219: invokestatic 268	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   222: putfield 270	com/baidu/baidunavis/NavMapAdapter$PageUnit:time	I
    //   225: aload 5
    //   227: aload_3
    //   228: invokevirtual 274	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   231: pop
    //   232: ldc -67
    //   234: aload_3
    //   235: invokevirtual 275	com/baidu/baidunavis/NavMapAdapter$PageUnit:toString	()Ljava/lang/String;
    //   238: invokestatic 201	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: iload_1
    //   242: iconst_1
    //   243: iadd
    //   244: istore_1
    //   245: goto -85 -> 160
    //   248: astore_2
    //   249: ldc -67
    //   251: aload_2
    //   252: invokevirtual 278	java/io/IOException:getMessage	()Ljava/lang/String;
    //   255: invokestatic 201	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto -169 -> 89
    //   261: astore_2
    //   262: ldc -67
    //   264: aload_2
    //   265: invokevirtual 279	javax/xml/parsers/ParserConfigurationException:getMessage	()Ljava/lang/String;
    //   268: invokestatic 201	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_3
    //   272: astore_2
    //   273: goto -164 -> 109
    //   276: astore_2
    //   277: ldc -67
    //   279: aload_2
    //   280: invokevirtual 280	org/xml/sax/SAXException:getMessage	()Ljava/lang/String;
    //   283: invokestatic 201	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload 4
    //   288: astore_3
    //   289: goto -163 -> 126
    //   292: astore_2
    //   293: ldc -67
    //   295: aload_2
    //   296: invokevirtual 281	org/w3c/dom/DOMException:getMessage	()Ljava/lang/String;
    //   299: invokestatic 201	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload 4
    //   304: astore_3
    //   305: goto -179 -> 126
    //   308: astore_2
    //   309: ldc -67
    //   311: aload_2
    //   312: invokevirtual 278	java/io/IOException:getMessage	()Ljava/lang/String;
    //   315: invokestatic 201	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload 4
    //   320: astore_3
    //   321: goto -195 -> 126
    //   324: astore 4
    //   326: ldc -67
    //   328: aload 4
    //   330: invokevirtual 282	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: invokestatic 201	com/baidu/baidunavis/wrapper/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: goto -111 -> 225
    //   339: aload 5
    //   341: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	NavMapAdapter
    //   159	86	1	i	int
    //   36	139	2	localObject1	Object
    //   248	4	2	localIOException1	java.io.IOException
    //   261	4	2	localParserConfigurationException	javax.xml.parsers.ParserConfigurationException
    //   272	1	2	localObject2	Object
    //   276	4	2	localSAXException	org.xml.sax.SAXException
    //   292	4	2	localDOMException	org.w3c.dom.DOMException
    //   308	4	2	localIOException2	java.io.IOException
    //   95	226	3	localObject3	Object
    //   92	227	4	localObject4	Object
    //   324	5	4	localException	Exception
    //   7	333	5	localArrayList	ArrayList
    //   81	40	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   83	89	248	java/io/IOException
    //   103	109	261	javax/xml/parsers/ParserConfigurationException
    //   119	126	276	org/xml/sax/SAXException
    //   119	126	292	org/w3c/dom/DOMException
    //   119	126	308	java/io/IOException
    //   195	225	324	java/lang/Exception
  }
  
  public static void resetNavConfig(Context paramContext) {}
  
  public boolean ReleaseSharedMapData()
  {
    return NavMapManager.getInstance().releaseSharedMapData();
  }
  
  public void addLocationChangeLister(LocationChangeListener paramLocationChangeListener)
  {
    com.baidu.navi.location.LocationManager.getInstance().addLocationChangeLister(paramLocationChangeListener);
  }
  
  public boolean addLog(String paramString)
  {
    return true;
  }
  
  public boolean addPerformLog(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    return com.baidu.platform.comapi.b.c.a().a(paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public void autoJumpPage()
  {
    LogUtil.e("navSDK", "autoJumpPage");
    if (this.mPageUnits == null) {
      this.mPageUnits = readPageUnit();
    }
    Activity localActivity = NavCommonFuncModel.getInstance().getActivity();
    PageUnit localPageUnit;
    if ((this.nPageindex >= 0) && (this.nPageindex < this.mPageUnits.size()))
    {
      localPageUnit = (PageUnit)this.mPageUnits.get(this.nPageindex);
      if (!"BNRouteGuideFragment".equals(localPageUnit.name)) {
        break label147;
      }
      LogUtil.e("navSDK", "JumpPage BNRouteGuideFragment");
      nPageTime = localPageUnit.time;
      BaiduNaviManager.getInstance().launchNavigator(localActivity, new NavGeoPoint(11394118, 2254282), "我的位置", new NavGeoPoint(11396185, 2256679), "地图上的点", 1, true, 2);
    }
    for (;;)
    {
      this.nPageindex += 1;
      return;
      label147:
      if ("BNCruiserFragment".equals(localPageUnit.name))
      {
        LogUtil.e("navSDK", "JumpPage BNCruiserFragment");
        BaiduNaviManager.getInstance().launchCruiser(localActivity, Boolean.valueOf(true));
      }
    }
  }
  
  public boolean buttomNaviTabHasFocus()
  {
    if (com.baidu.carlife.core.screen.presentation.a.g.a().isDialogShown()) {
      return true;
    }
    return com.baidu.carlife.core.screen.presentation.a.g.a().b().j();
  }
  
  public void cancleRequest(MapSearchAPIWrapper paramMapSearchAPIWrapper, int paramInt) {}
  
  public void checkNewVerData(Activity paramActivity)
  {
    BNOfflineDataManager.getInstance();
    BNDownloadUIManager.checkNewVersion(paramActivity, false, new BNDownloadUIManager.OnNewVersionListener()
    {
      public void onNewVersion(int[] paramAnonymousArrayOfInt)
      {
        LogUtil.e("BNDownload", "checkNewVer: onNewVersion");
      }
    });
  }
  
  public void close(Closeable paramCloseable)
  {
    FileUtils.close(paramCloseable);
  }
  
  public void closeCarLifeVR()
  {
    k.b(4160);
  }
  
  public void createCarNaviData() {}
  
  public void dismissMProgressDialog()
  {
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("dismissMProgressDialog", null)new BNWorkerConfig
    {
      protected String execute()
      {
        MProgressDialog.dismiss();
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  public void dismissWaitProgressDialog()
  {
    if (getContainerActivity() == null) {
      return;
    }
    getContainerActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        e.a().c();
      }
    });
  }
  
  public void exceptionLog(Throwable paramThrowable) {}
  
  public void exitCarNav(boolean paramBoolean) {}
  
  public Application getBaiduMapApplicationInstance()
  {
    return BaiduNaviApplication.getInstance();
  }
  
  public SharedPreferences getBaiduMapApplicationSp(String paramString, int paramInt)
  {
    return BaiduNaviApplication.getInstance().getSharedPreferences(paramString, paramInt);
  }
  
  public boolean getBaiduMapTraffic()
  {
    return MapViewConfig.getInstance().isTraffic();
  }
  
  public String getBduss()
  {
    return NaviAccountUtils.getInstance().syncGetBduss();
  }
  
  public NavCarInfo getCarInfoFromMap()
  {
    String str = BNSettingManager.getPlateFromLocal(getContext());
    if ((str != null) && (str.length() > 0)) {
      return new NavCarInfo(str);
    }
    return null;
  }
  
  public int getCarNaviPermissions()
  {
    return 8;
  }
  
  public String getCarRoutePlanMrsl()
  {
    return "";
  }
  
  public Activity getContainerActivity()
  {
    return BaseFragment.getNaviActivity();
  }
  
  public Context getContext()
  {
    return BaseFragment.getNaviActivity();
  }
  
  public Bundle getCurLocation()
  {
    Bundle localBundle = new Bundle();
    LocationManager.LocData localLocData = com.baidu.navi.location.LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09);
    localBundle.putInt("x", (int)localLocData.longitude);
    localBundle.putInt("y", (int)localLocData.latitude);
    return localBundle;
  }
  
  public int getCurrentLocalCityId()
  {
    return GeoLocateModel.getInstance().getCurrentDistrict().mCityId;
  }
  
  public StorageInformation getCurrentStorage()
  {
    return StorageSettings.getInstance().getCurrentStorage();
  }
  
  public String getDataFolderName()
  {
    return "BaiduCarlife";
  }
  
  public String getDataPath()
  {
    return StorageSettings.getInstance().getCurrentStorage().getDataPath();
  }
  
  public boolean getDebugConfigUserTest()
  {
    return false;
  }
  
  public String getEnerGyRequestIDBundleKey()
  {
    return "energy_requestid_bundle_key";
  }
  
  public NavGeoPoint getGeoPoint(Point paramPoint, boolean paramBoolean)
  {
    NavGeoPoint localNavGeoPoint = new NavGeoPoint();
    int i;
    if (paramBoolean)
    {
      paramPoint = com.baidu.navi.location.LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09);
      i = (int)paramPoint.longitude;
    }
    for (int j = (int)paramPoint.latitude;; j = paramPoint.getIntY())
    {
      paramPoint = MC2LLE6(i, j);
      if (paramPoint != null)
      {
        localNavGeoPoint.setLongitudeE6(paramPoint.getInt("LLx"));
        localNavGeoPoint.setLatitudeE6(paramPoint.getInt("LLy"));
      }
      return localNavGeoPoint;
      i = paramPoint.getIntX();
    }
  }
  
  public int getIconId()
  {
    return 2130838698;
  }
  
  public Context getJNIInitializerContext()
  {
    return com.baidu.platform.comapi.c.f();
  }
  
  public String getMapFramePageClassName()
  {
    return "MapFramePage.class";
  }
  
  public String getMengMengDaTTSPath()
  {
    return null;
  }
  
  public String getNavEnergyPromoteEvent()
  {
    return "NaviEnergyOperation";
  }
  
  public NavGeoPoint getNavGeoPoint(Point paramPoint)
  {
    NavGeoPoint localNavGeoPoint = new NavGeoPoint();
    paramPoint = MC2LLE6(paramPoint.getIntX(), paramPoint.getIntY());
    localNavGeoPoint.setLongitudeE6(paramPoint.getInt("LLx"));
    localNavGeoPoint.setLatitudeE6(paramPoint.getInt("LLy"));
    return localNavGeoPoint;
  }
  
  public int getPreferValue()
  {
    return RGRouteSortController.getInstance().getPreferValue();
  }
  
  public int getResultKeyMCarRoute()
  {
    return 18;
  }
  
  public int getRoamCityId()
  {
    return getCurrentLocalCityId();
  }
  
  public RouteNode getRouteNode(NavGeoPoint paramNavGeoPoint, String paramString1, String paramString2)
  {
    RouteNode localRouteNode = new RouteNode();
    localRouteNode.mGeoPoint = paramNavGeoPoint;
    localRouteNode.mName = paramString1;
    localRouteNode.mUID = paramString2;
    return localRouteNode;
  }
  
  public StorageSettings getStorageSettingsInstance()
  {
    return StorageSettings.getInstance();
  }
  
  public String getURLScheme()
  {
    return HttpURLManager.getInstance().getScheme();
  }
  
  public String getUid()
  {
    if (NaviAccountUtils.getInstance().getUid() != null) {
      return NaviAccountUtils.getInstance().getUid();
    }
    return "";
  }
  
  public String getWebShellFlagKey()
  {
    return "webshell_flag_key";
  }
  
  public String getWebViewURLKey()
  {
    return "webview_url";
  }
  
  public int getmCarFocus()
  {
    return 0;
  }
  
  public void gotoNavi(Point paramPoint1, String paramString1, Point paramPoint2, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public boolean hasCurMapLocationCityOfflineData()
  {
    Object localObject2;
    Object localObject1;
    if ((com.baidu.navi.location.LocationManager.getInstance().isLocationValid()) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)))
    {
      localObject2 = com.baidu.navi.location.LocationManager.getInstance().getCurLocation(LocationChangeListener.CoordType.CoordType_BD09LL);
      localObject1 = new LocData();
      ((LocData)localObject1).accuracy = ((LocationManager.LocData)localObject2).accuracy;
      ((LocData)localObject1).direction = ((LocationManager.LocData)localObject2).direction;
      ((LocData)localObject1).satellitesNum = ((LocationManager.LocData)localObject2).satellitesNum;
      ((LocData)localObject1).speed = ((LocationManager.LocData)localObject2).speed;
      ((LocData)localObject1).type = ((LocationManager.LocData)localObject2).type;
      ((LocData)localObject1).longitude = ((LocationManager.LocData)localObject2).longitude;
      ((LocData)localObject1).latitude = ((LocationManager.LocData)localObject2).latitude;
      if ((((LocData)localObject1).longitude != -1.0D) || (((LocData)localObject1).latitude != -1.0D)) {
        break label117;
      }
    }
    label117:
    do
    {
      return false;
      localObject2 = new GeoPoint();
      if (localObject1 != null)
      {
        ((GeoPoint)localObject2).setLatitudeE6((int)(((LocData)localObject1).latitude * 100000.0D));
        ((GeoPoint)localObject2).setLongitudeE6((int)(((LocData)localObject1).longitude * 100000.0D));
      }
      for (localObject1 = BNPoiSearcher.getInstance().getDistrictByPoint((GeoPoint)localObject2, 0); (localObject1 != null) && (((DistrictInfo)localObject1).mType > 2); localObject1 = BNPoiSearcher.getInstance().getParentDistrict(((DistrictInfo)localObject1).mId)) {}
    } while (localObject1 == null);
    return BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject1).mId);
  }
  
  public void importMap()
  {
    com.baidu.baidumaps.base.localmap.f.a().n();
  }
  
  public void initNavGuideListener() {}
  
  public void initNaviEngine(Activity paramActivity, final Handler paramHandler)
  {
    if ((!BaiduNaviManager.sIsBaseEngineInitial) && (paramActivity != null)) {
      NavInitController.getInstance().initBaseEngine(paramActivity, new NaviEngineInitListener()
      {
        public void engineInitFail()
        {
          BaiduNaviManager.sIsEngineInitialFailed = false;
          if (paramHandler != null)
          {
            Message localMessage = new Message();
            localMessage.what = 1301;
            localMessage.arg1 = -1;
            paramHandler.sendMessage(localMessage);
          }
        }
        
        public void engineInitStart() {}
        
        public void engineInitSuccess()
        {
          if (paramHandler != null)
          {
            Message localMessage = new Message();
            localMessage.what = 1301;
            localMessage.arg1 = 0;
            paramHandler.sendMessage(localMessage);
          }
        }
      });
    }
  }
  
  public boolean isAllowNavRecoveryDialogShow()
  {
    return true;
  }
  
  public boolean isCloudSwitchOn(String paramString)
  {
    return false;
  }
  
  public boolean isExternalStorageEnabled()
  {
    return StorageSettings.getInstance().isExternalStorageEnabled();
  }
  
  public boolean isFocusUIEnable()
  {
    return com.baidu.carlife.logic.g.a().c();
  }
  
  public boolean isGPSLocationValid()
  {
    LocationManager.LocData localLocData = com.baidu.navi.location.LocationManager.getInstance().getCurLocation(null);
    return (localLocData != null) && (localLocData.type == 61);
  }
  
  public boolean isGooglePlayChannel()
  {
    return "1012961a".equals(com.baidu.carlife.core.f.jt);
  }
  
  public boolean isGpsEnabled()
  {
    boolean bool2 = false;
    Object localObject = NavCommonFuncModel.getInstance().getContext();
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = (android.location.LocationManager)((Context)localObject).getSystemService("location");
      bool1 = bool2;
      if (localObject == null) {}
    }
    try
    {
      bool1 = ((android.location.LocationManager)localObject).isProviderEnabled("gps");
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean isLightNaviLocationValid()
  {
    LocationManager.LocData localLocData = com.baidu.navi.location.LocationManager.getInstance().getCurLocation(null);
    return (localLocData != null) && (localLocData.type == 61) && (localLocData.type == 161);
  }
  
  public boolean isLogin()
  {
    return NaviAccountUtils.getInstance().isLogin();
  }
  
  public boolean isMapModuleFragment()
  {
    return h.a().d() == 4003;
  }
  
  public boolean isNaviInjectSuccess()
  {
    return true;
  }
  
  public int mapLightSearch(String paramString, MsgHandler paramMsgHandler, int paramInt, MapSearchAPIWrapper paramMapSearchAPIWrapper, long paramLong)
  {
    NavLogUtils.e(TAG, "mapLightSearch() url=" + paramString);
    return 1;
  }
  
  public int mappingPreferValue(int paramInt)
  {
    return RGRouteSortController.getInstance().mappingPreferValue(paramInt);
  }
  
  public void naviDownloadXiJiangSwitch()
  {
    if (BaseFragment.mActivity != null) {
      BaseFragment.mActivity.a(2);
    }
  }
  
  public void navigateTo(Context paramContext, String paramString) {}
  
  public void navigateTo(Context paramContext, String paramString, Bundle paramBundle) {}
  
  public void navigateToCarLogoPage()
  {
    if (BNSettingManager.isUseHttpsOfflineURL()) {}
    for (String str1 = "http://cp01-rdqa04-dev108.cp01.baidu.com:8111/static/webpage/growth/car.html";; str1 = getURLScheme() + "webpagenavi.baidu.com/static/webpage/growth/car.html")
    {
      String str3 = PackageUtil.getVersionName();
      String str4 = PackageUtil.getCuid();
      String str2 = "";
      DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
      if (localDistrictInfo != null) {
        str2 = String.valueOf(localDistrictInfo.mId);
      }
      new StringBuilder().append(str1).append("?cuid=").append(str4).append("&sv=").append(str3).append("&os=").append("0").append("&cid=").append(str2).toString();
      return;
    }
  }
  
  public void onBackground()
  {
    if (!BaiduNaviManager.sIsBaseEngineInitialized) {
      return;
    }
    NavCommonFuncController.getInstance().onBackground();
  }
  
  public void onForeground()
  {
    if ((!BaiduNaviManager.isNaviSoLoadSuccess()) || (!BaiduNaviManager.sIsBaseEngineInitialized)) {
      return;
    }
    NavCommonFuncController.getInstance().onForeground();
  }
  
  public int onGetLastPreferValue()
  {
    return BNRoutePlaner.getInstance().getCalcPreference();
  }
  
  public void onSetLastPreferValue(int paramInt)
  {
    BNRoutePlaner.getInstance().setCalcPrference(paramInt);
  }
  
  public void purgeMapDataForNavi(final Activity paramActivity)
  {
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("calcRouteForPBData", null)new BNWorkerConfig
    {
      protected String execute()
      {
        BNDownloadUIManager.pauseAllDownload();
        com.baidu.baidumaps.base.localmap.f.a().e(0);
        paramActivity.getWindow().clearFlags(128);
        return null;
      }
    }, new BNWorkerConfig(100, 0));
    NavCommonFuncModel.getInstance().mMapBrightState = GlobalConfig.getInstance().isAllBright();
    GlobalConfig.getInstance().setAllBright(Boolean.valueOf(false));
  }
  
  public void removeLocationChangeLister(LocationChangeListener paramLocationChangeListener)
  {
    com.baidu.navi.location.LocationManager.getInstance().removeLocationChangeLister(paramLocationChangeListener);
  }
  
  public void removeRequestByType(int paramInt) {}
  
  public void restoreMapData()
  {
    LogUtil.e("navSDK", "restoreMapData->autoJumpPage");
  }
  
  public void sendLightNavShortCut(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle) {}
  
  public void setBaiduMapTraffic(boolean paramBoolean)
  {
    MapGLSurfaceView localMapGLSurfaceView = MapViewFactory.getInstance().getMapView();
    if (localMapGLSurfaceView != null)
    {
      localMapGLSurfaceView.setTraffic(paramBoolean);
      MapViewConfig.getInstance().setTraffic(paramBoolean);
    }
  }
  
  public void setCalcPrference(int paramInt)
  {
    BNRoutePlaner.getInstance().setCalcPrference(paramInt);
  }
  
  public void setIsSelectPlate()
  {
    RGCarPreferSettingController.getInstance().mIsSelectPlate = BNSettingManager.hasPlateFromLocal(getContext());
  }
  
  public void setIsSupportNoHighway(boolean paramBoolean)
  {
    RGCarPreferSettingController.sIsSupportNoHighway = paramBoolean;
  }
  
  public void setIsfetchCarOwnerData(boolean paramBoolean)
  {
    BNRoutePlaner.sIsfetchCarOwnerData = paramBoolean;
  }
  
  public void setPreferValue(int paramInt)
  {
    RGRouteSortController.getInstance().setPreferValue(paramInt);
  }
  
  public boolean setUgcInfo(String paramString)
  {
    return com.baidu.navi.location.LocationManager.getInstance().setUgcInfo(paramString);
  }
  
  public void shareSafety(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {}
  
  public void showBottomBar(boolean paramBoolean)
  {
    if (showBottomBarSwitch)
    {
      LogUtil.e("navSDK", "showBottomBar" + paramBoolean);
      com.baidu.carlife.core.screen.presentation.a.g.a().b().setBottomBarStatus(paramBoolean);
    }
  }
  
  public void showFragment(int paramInt, Bundle paramBundle)
  {
    h.a().showFragment(paramInt, paramBundle);
  }
  
  public void showMProgressDialog(final FragmentActivity paramFragmentActivity, final String paramString1, final String paramString2)
  {
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("showMProgressDialog", null)new BNWorkerConfig
    {
      protected String execute()
      {
        MProgressDialog.show(paramFragmentActivity, paramString1, paramString2);
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  public void showMProgressDialog(final FragmentActivity paramFragmentActivity, final String paramString1, final String paramString2, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("showMProgressDialog", null)new BNWorkerConfig
    {
      protected String execute()
      {
        MProgressDialog.show(paramFragmentActivity, paramString1, paramString2, paramOnCancelListener);
        return null;
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  public void showMToast(Context paramContext, int paramInt)
  {
    MToast.show(paramContext, paramInt);
  }
  
  public void showMToast(Context paramContext, String paramString)
  {
    MToast.show(paramContext, paramString);
  }
  
  public void showProgressDialog(final String paramString, final b paramb)
  {
    if (getContainerActivity() == null) {
      return;
    }
    getContainerActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        e.a().a(paramString, paramb);
      }
    });
  }
  
  public void showProgressDialog(final String paramString, final b paramb, final d paramd)
  {
    if (getContainerActivity() == null) {
      return;
    }
    getContainerActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        e.a().a(paramString, paramb, paramd);
      }
    });
  }
  
  public void startLogin(Fragment paramFragment, boolean paramBoolean, int paramInt) {}
  
  public boolean updateShareMapData()
  {
    return NavMapManager.getInstance().updateShareMapData();
  }
  
  class PageUnit
  {
    public String name;
    public int time;
    
    PageUnit() {}
    
    public String toString()
    {
      return " PageName:" + this.name + ",time:" + this.time;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/NavMapAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */