package com.baidu.navisdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatHelper;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SDKDebugUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.listener.PhoneStatusReceiver;
import com.baidu.navisdk.util.listener.SDCardListener;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.RespTimeStatItem;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckCenter;
import com.baidu.navisdk.vi.VDeviceAPI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BNaviModuleManager
{
  public static final String KEY_OUTCHINA_CITYID = "key.outchina.cityid";
  private static final String RES_ID = "52";
  private static NaviCommonCallBackListener mNaviCommonCallBackListener;
  private static NetworkListener mNetworkListener;
  private static SDCardListener mSDCardListener;
  public static String sAppSourceStr = "others";
  private static Activity sCachedActivity;
  private static Context sCachedContext;
  private static GetOuterActivityListener sGetOuterActivityListener = null;
  
  public static void addOrRemoveSensorListener(int paramInt, ISensorChangeListener paramISensorChangeListener)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(paramInt, 0, paramISensorChangeListener);
    }
  }
  
  public static boolean buttomNaviTabHasFocus()
  {
    if (mNaviCommonCallBackListener != null) {
      return mNaviCommonCallBackListener.buttomNaviTabHasFocus();
    }
    return false;
  }
  
  public static boolean checkBaseMapDataExit(int paramInt)
  {
    if (mNaviCommonCallBackListener != null) {
      return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(28, paramInt, null);
    }
    return true;
  }
  
  public static void destory()
  {
    unRegister();
    RespTimeStatItem.getInstance().onEvent();
    BNStatisticsManager.getInstance().saveStatistics();
    BNStatisticsManager.getInstance().exit();
    SDKDebugUtil.getInstance().destory();
    DataCheckCenter.getInstance().uninit();
  }
  
  public static void detoryMapView()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(0, 0, null);
    }
  }
  
  public static void fetchCarOwnerData(Context paramContext)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(34, 0, paramContext);
    }
  }
  
  public static Activity getActivity()
  {
    if ((sGetOuterActivityListener != null) && (sGetOuterActivityListener.getOuterActivity() != null)) {
      return sGetOuterActivityListener.getOuterActivity();
    }
    return sCachedActivity;
  }
  
  public static int getAppIconId()
  {
    if (mNaviCommonCallBackListener != null)
    {
      Bundle localBundle = mNaviCommonCallBackListener.onNaviCommonMsg(8, 0, null);
      if ((localBundle != null) && (localBundle.containsKey("KEY_ICON_ID"))) {
        return localBundle.getInt("KEY_ICON_ID");
      }
    }
    return -1;
  }
  
  public static String getBduss()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (mNaviCommonCallBackListener != null)
    {
      Bundle localBundle = mNaviCommonCallBackListener.onNaviCommonMsg(1, 0, null);
      localObject1 = localObject2;
      if (localBundle != null)
      {
        localObject1 = localObject2;
        if (localBundle.containsKey("bduss")) {
          localObject1 = localBundle.getString("bduss");
        }
      }
    }
    return (String)localObject1;
  }
  
  public static Context getContext()
  {
    if ((sGetOuterActivityListener != null) && (sGetOuterActivityListener.getOuterActivity() != null)) {
      return sGetOuterActivityListener.getOuterActivity();
    }
    return sCachedContext;
  }
  
  public static int getLastPreferValue()
  {
    if (mNaviCommonCallBackListener != null)
    {
      Bundle localBundle = mNaviCommonCallBackListener.onNaviCommonMsg(22, 0, null);
      if ((localBundle != null) && (localBundle.containsKey("KEY_PREFER_VALUE"))) {
        return localBundle.getInt("KEY_PREFER_VALUE");
      }
    }
    return 1;
  }
  
  public static Activity getNaviActivity()
  {
    if ((sGetOuterActivityListener != null) && (sGetOuterActivityListener.getNaviActivity() != null)) {
      return sGetOuterActivityListener.getNaviActivity();
    }
    return sCachedActivity;
  }
  
  public static int getOutChinaCurrentCityId()
  {
    int j = -1;
    int i = j;
    if (mNaviCommonCallBackListener != null)
    {
      Bundle localBundle = mNaviCommonCallBackListener.onNaviCommonMsg(30, -1, null);
      i = j;
      if (localBundle != null)
      {
        i = j;
        if (localBundle.containsKey("key.outchina.cityid")) {
          i = localBundle.getInt("key.outchina.cityid", -1);
        }
      }
    }
    return i;
  }
  
  public static boolean hasPermission(String paramString)
  {
    boolean bool = false;
    if (mNaviCommonCallBackListener != null) {
      bool = mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(18, 0, paramString);
    }
    return bool;
  }
  
  public static void initCollada()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(25, 0, null);
    }
  }
  
  public static void initContext(Context paramContext)
  {
    if (1 != 0) {
      JarUtils.setAsJar(paramContext);
    }
    PackageUtil.readSDKBuildNumber();
  }
  
  public static void initListenersForMap(Context paramContext)
  {
    unRegister();
    sCachedContext = paramContext.getApplicationContext();
    unRegister();
    PackageUtil.init(paramContext);
    initNetworkListener(paramContext);
    initSDCardListener(paramContext);
    initPhoneStateListener(paramContext);
  }
  
  public static void initNetworkListener(Context paramContext)
  {
    mNetworkListener = new NetworkListener(true);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    if (paramContext != null) {}
    try
    {
      paramContext.getApplicationContext().registerReceiver(mNetworkListener, localIntentFilter, null, null);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void initPhoneStateListener(Context paramContext)
  {
    PhoneStatusReceiver.initPhoneStatusReceiver(getContext().getApplicationContext());
  }
  
  public static void initSDCardListener(Context paramContext)
  {
    mSDCardListener = new SDCardListener();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addDataScheme("file");
    if (paramContext != null) {}
    try
    {
      paramContext.getApplicationContext().registerReceiver(mSDCardListener, localIntentFilter);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void initUrl()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(27, 0, null);
    }
  }
  
  public static boolean isAppForeground()
  {
    if (mNaviCommonCallBackListener != null) {
      return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(2, 0, null);
    }
    return true;
  }
  
  public static boolean isCarPlateNumComplete()
  {
    boolean bool = false;
    if (mNaviCommonCallBackListener != null) {
      bool = mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(17, 0, null);
    }
    return bool;
  }
  
  public static boolean isColladaInitSuccess()
  {
    boolean bool = false;
    if (mNaviCommonCallBackListener != null) {
      bool = mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(15, 0, null);
    }
    return bool;
  }
  
  public static boolean isDrivingCar()
  {
    boolean bool = false;
    if (mNaviCommonCallBackListener != null) {
      bool = mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(13, 0, null);
    }
    return bool;
  }
  
  public static boolean isFocusUIenable()
  {
    if (mNaviCommonCallBackListener != null) {
      return mNaviCommonCallBackListener.isFocusUIenable();
    }
    return false;
  }
  
  public static boolean isGooglePlayChannel()
  {
    boolean bool = false;
    if (mNaviCommonCallBackListener != null) {
      bool = mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(10, 0, null);
    }
    return bool;
  }
  
  public static boolean isInternational(long paramLong1, long paramLong2, int paramInt)
  {
    if (mNaviCommonCallBackListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("x", paramLong1);
      localBundle.putLong("y", paramLong2);
      localBundle.putInt("cityId", paramInt);
      return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(31, -1, localBundle);
    }
    return false;
  }
  
  public static boolean isMapModuleFragment()
  {
    if (mNaviCommonCallBackListener != null) {
      return mNaviCommonCallBackListener.isMapModuleFragment();
    }
    return true;
  }
  
  public static boolean isSettingCarPlate()
  {
    boolean bool = false;
    if (mNaviCommonCallBackListener != null) {
      bool = mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(16, 0, null);
    }
    return bool;
  }
  
  public static void launchDownloadPage()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(11, 0, null);
    }
  }
  
  public static void launchMapsActivityToFront()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(19, 0, null);
    }
  }
  
  public static void mapToNaviSaveMode(Context paramContext, int paramInt)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(35, paramInt, paramContext);
    }
  }
  
  public static void naviDownloadXiJiangSwitch()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(36, 0, null);
    }
  }
  
  public static void openCarPlateExplainPage(Context paramContext)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(32, 0, paramContext);
    }
  }
  
  public static void putIP2DomainsRecord(Bundle paramBundle)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(24, 0, paramBundle);
    }
  }
  
  public static boolean releaseAudioFocus()
  {
    if (mNaviCommonCallBackListener != null) {
      return mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(21, 0, null);
    }
    return true;
  }
  
  public static void removeIPO()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(3, 0, null);
    }
  }
  
  public static boolean requstPermission(String paramString)
  {
    boolean bool = false;
    if (mNaviCommonCallBackListener != null) {
      bool = mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(20, 0, paramString);
    }
    return bool;
  }
  
  public static void resetPlateLimitCounter(boolean paramBoolean)
  {
    if (mNaviCommonCallBackListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isOpen", paramBoolean);
      mNaviCommonCallBackListener.onNaviCommonMsg(33, 0, localBundle);
    }
  }
  
  public static void setActivity(Activity paramActivity) {}
  
  public static void setContext(Context paramContext) {}
  
  public static void setGetOuterActivityListener(GetOuterActivityListener paramGetOuterActivityListener)
  {
    sGetOuterActivityListener = paramGetOuterActivityListener;
  }
  
  public static void setIPORCToMap(boolean paramBoolean)
  {
    NaviCommonCallBackListener localNaviCommonCallBackListener;
    if (mNaviCommonCallBackListener != null)
    {
      localNaviCommonCallBackListener = mNaviCommonCallBackListener;
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    for (int i = 1;; i = 0)
    {
      localNaviCommonCallBackListener.onNaviCommonMsgForBoolean(12, i, null);
      return;
    }
  }
  
  public static void setLastPreferValue(int paramInt)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(23, 0, Integer.valueOf(paramInt));
    }
  }
  
  private static void setRoutePlanStatistcsUrl()
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      String str = "&mb=" + URLEncoder.encode(VDeviceAPI.getPhoneType(), "UTF-8");
      localObject1 = str;
      localObject2 = str;
      str = str + "&sv=" + URLEncoder.encode(VDeviceAPI.getAppPackageVersion(), "UTF-8");
      localObject1 = str;
      localObject2 = str;
      str = str + "&pcn=" + URLEncoder.encode(VDeviceAPI.getAppPackageName(), "UTF-8");
      localObject1 = str;
      localObject2 = str;
      str = str + "&kv=" + URLEncoder.encode(VDeviceAPI.getDataVersion(), "UTF-8");
      localObject1 = str;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Exception localException1 = localException2;
      }
    }
    localObject1 = (String)localObject1 + "&os=android";
    localObject1 = (String)localObject1 + "&net=" + VDeviceAPI.getCurrentNetworkType();
    localObject1 = (String)localObject1 + "&resid=52";
    new StringBuilder().append((String)localObject1).append("&channel=").append(PackageUtil.getChannel()).toString();
  }
  
  public static void setTTSStreamType(int paramInt)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(4, paramInt, null);
    }
  }
  
  public static void setup(boolean paramBoolean)
  {
    BNStatisticsManager.getInstance().upLoadStatistics();
    BNSysLocationManager.getInstance().init(getContext());
    BNOfflineDataManager.getInstance().initDownloadInfo(paramBoolean);
    BNRoutePlaner.getInstance().init(getContext());
    statistics();
  }
  
  public static void setupBase(boolean paramBoolean)
  {
    BNOfflineDataManager.getInstance().isProvinceDataDownload(0);
    NaviStatHelper.initNaviStatHelper();
  }
  
  public static void setupGuidance(int paramInt)
  {
    BNSysLocationManager.getInstance().init(getContext());
    BNRoutePlaner.getInstance().init(getContext());
  }
  
  public static void setupNaviCommonCallBackListener(NaviCommonCallBackListener paramNaviCommonCallBackListener)
  {
    mNaviCommonCallBackListener = paramNaviCommonCallBackListener;
  }
  
  public static void shareDrivingToolUrl(String paramString)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(14, 0, paramString);
    }
  }
  
  public static void shareSafety(Bundle paramBundle)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsg(26, 0, paramBundle);
    }
  }
  
  public static void showBottomBar(boolean paramBoolean)
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.showBottomBar(paramBoolean);
    }
  }
  
  public static void statistics() {}
  
  private static void unRegister()
  {
    if ((mNetworkListener != null) && (getContext() != null)) {}
    try
    {
      getContext().getApplicationContext().unregisterReceiver(mNetworkListener);
      mNetworkListener = null;
      if ((mSDCardListener != null) && (getContext() != null)) {}
      try
      {
        getContext().getApplicationContext().unregisterReceiver(mSDCardListener);
        mSDCardListener = null;
        PhoneStatusReceiver.uninitPhoneStatusReceiver();
        return;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public static void unregisterMapSensorListener()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(5, 0, null);
    }
  }
  
  public static void updateAppSource()
  {
    LogUtil.e("dingbin", "updateAppSource is " + sAppSourceStr);
    if ("huawei".equals(sAppSourceStr))
    {
      com.baidu.navisdk.module.offscreen.BNOffScreenManager.sIsModelueActive = true;
      updateAppSource(1);
      return;
    }
    if ("leshi".equals(sAppSourceStr))
    {
      com.baidu.navisdk.module.offscreen.BNOffScreenManager.sIsModelueActive = true;
      updateAppSource(2);
      return;
    }
    com.baidu.navisdk.module.offscreen.BNOffScreenManager.sIsModelueActive = false;
    updateAppSource(0);
  }
  
  private static void updateAppSource(int paramInt)
  {
    BNaviEngineManager.getInstance().updateAppSource(paramInt);
  }
  
  public static void updateMapDataStutas()
  {
    if (mNaviCommonCallBackListener != null) {
      mNaviCommonCallBackListener.onNaviCommonMsgForBoolean(29, -1, null);
    }
  }
  
  public static class AppSourceDefine
  {
    public static final String DEFAULT_SOURCE = "others";
    public static final int DEFAULT_SOURCE_INT = 0;
    public static final String HUAWEI_SOURCE = "huawei";
    public static final int HUAWEI_SOURCE_INT = 1;
    public static final String LESHI_SOURCE = "leshi";
    public static final int LESHI_SOURCE_INT = 2;
  }
  
  public static abstract interface GetOuterActivityListener
  {
    public abstract Activity getNaviActivity();
    
    public abstract Activity getOuterActivity();
  }
  
  public static abstract interface NaviCommonCallBackListener
  {
    public static final String KEY_BDUSS = "bduss";
    public static final String KEY_ICON_ID = "KEY_ICON_ID";
    public static final String KEY_PREFER_VALUE = "KEY_PREFER_VALUE";
    public static final int NAVI_DOWNLOAD_XIJIANG_SWITCH = 36;
    public static final int NAVI_DRIVING_TOOL = 14;
    public static final int NAVI_EVENT_NOTIFY_INIT = 0;
    public static final int NAVI_EVENT_NOTIFY_UNINIT = 2;
    public static final int NAVI_EVENT_NOTIFY_UPDATE = 1;
    public static final int NAVI_REMOVE_IPO = 3;
    public static final int NAVI_SET_TTS_STREAM_TYPE = 4;
    public static final int NAVI_TYPE_CHECK_PERMISSION = 18;
    public static final int NAVI_TYPE_DESTORY_MAP = 0;
    public static final int NAVI_TYPE_DRIVING_CAR = 13;
    public static final int NAVI_TYPE_FETCH_CAR_OWNER_DATA = 34;
    public static final int NAVI_TYPE_GET_BDUSS = 1;
    public static final int NAVI_TYPE_GET_CITY_ID_OUTCHINA = 30;
    public static final int NAVI_TYPE_GET_ICON_ID = 8;
    public static final int NAVI_TYPE_GET_LAST_ROUTE_SEARCH_MCAR_PREFER = 22;
    public static final int NAVI_TYPE_INIT_URL = 27;
    public static final int NAVI_TYPE_IS_APP_FOREGROUND = 2;
    public static final int NAVI_TYPE_IS_CAR_PLATE_NUM_COMPLETE = 17;
    public static final int NAVI_TYPE_IS_COLLADA_INIT_SUCCESS = 15;
    public static final int NAVI_TYPE_IS_GooglePlay_Channel = 10;
    public static final int NAVI_TYPE_IS_INTERNATIONAL = 31;
    public static final int NAVI_TYPE_IS_SETTING_CAR_PLATE = 16;
    public static final int NAVI_TYPE_Init_Collada = 25;
    public static final int NAVI_TYPE_LAUNCH_MAPSACTIVITY_TO_FRONT = 19;
    public static final int NAVI_TYPE_MAP_SENSOR_ADD = 6;
    public static final int NAVI_TYPE_MAP_SENSOR_REMOVE = 7;
    public static final int NAVI_TYPE_OFFLINE_DATA_CLEAR = 29;
    public static final int NAVI_TYPE_OFFLINE_DATA_DOWNLOAD = 28;
    public static final int NAVI_TYPE_OPEN_CAR_PLATE_EXPLAIN_PAGE = 32;
    public static final int NAVI_TYPE_OPEN_DOWNLOAD_PAGE = 11;
    public static final int NAVI_TYPE_PLATE_LIMIT_RESET = 33;
    public static final int NAVI_TYPE_RELEASE_AUDIO_FOCUS = 21;
    public static final int NAVI_TYPE_REQUEST_PERMISSION = 20;
    public static final int NAVI_TYPE_SET_IPO_RC = 12;
    public static final int NAVI_TYPE_SET_LAST_ROUTE_SEARCH_MCAR_PREFER = 23;
    public static final int NAVI_TYPE_SET_SAVEMODE = 35;
    public static final int NAVI_TYPE_Share_Safety = 26;
    public static final int NAVI_TYPE_UNREGISTER_SENSOR = 5;
    public static final int NAVI_TYPE_putIP2DomainsRecord = 24;
    
    public abstract boolean buttomNaviTabHasFocus();
    
    public abstract boolean isFocusUIenable();
    
    public abstract boolean isMapModuleFragment();
    
    public abstract Bundle onNaviCommonMsg(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract boolean onNaviCommonMsgForBoolean(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void showBottomBar(boolean paramBoolean);
  }
  
  public static abstract interface NaviCommonConstant
  {
    public static final String OVERLAY_PERMISSION = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
    public static final int REQUST_CODE_JUMP_VOICE_SETTING = 3002;
    public static final int REQUST_CODE_OVERLAY_PERMISSION = 3001;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/BNaviModuleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */