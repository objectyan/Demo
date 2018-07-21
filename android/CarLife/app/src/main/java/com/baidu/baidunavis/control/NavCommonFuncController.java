package com.baidu.baidunavis.control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.BaiduNaviParams.NaviEvent;
import com.baidu.baidunavis.ForegroundService;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.tts.AudioUtils;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.ui.NavFragmentManager;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navisdk.BNEventManager;
import com.baidu.navisdk.BNEventManager.NaviMsgListener;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.BNaviModuleManager.NaviCommonCallBackListener;
import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.OfflineDataParams;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.CommonConfig;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.download.BNDownloadUIManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.voice.BNVoice;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.drivertool.BNDrivingToolManager;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.PerformStatisticsController;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.LocalMapManager;
import com.baidu.platform.comapi.map.LocalMapResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NavCommonFuncController
{
  public static final String KEY_USE_LY_TTS = "NAVI_USE_LY_TTS";
  private static final String NAVI_ALWAYS_BRIGHT = "NAVI_ALWAYS_BRIGHT";
  private static final String NAVI_CAMERA_NOTIFY = "NAVI_CAMERA_SPEAK_NOTIFY";
  private static final String NAVI_MODE_DAY_AND_NIGHT = "NAVI_MODE_DAY_AND_NIGHT";
  private static final String NAVI_OVER_SPEED = "NAVI_OVER_SPEED";
  private static final String NAVI_ROUTE_CONDITION = "NAVI_ROUTE_CONDITION";
  private static final String NAVI_STRAIGHT = "NAVI_STRAIGHT";
  private static final String NAVI_VOICE_MODE = "NAVI_VOICE_MODE";
  private static final String NAV_SETTING = "navsetting";
  private static final String PREF_NAVI_FIRST_USE = "PREF_NAVI_FIRST_USE";
  private static final String PREF_NAV_NEED_ADAPTER_SETTING = "nav_need_adapter_setting";
  public static final String TAG = NavCommonFuncController.class.getSimpleName();
  private static NavCommonFuncController sInstance = null;
  boolean[] cityDownLoadFlag = null;
  private final String mBackgroundSpeakMsg = "百度地图将持续为您导航";
  private MainLooperHandler mNavEventHandler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData())
  {
    public void onMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage == null) {
        return;
      }
      synchronized (NavCommonFuncController.this.mNaviEventListeners)
      {
        if (NavCommonFuncController.this.mNaviEventListeners != null)
        {
          Iterator localIterator = NavCommonFuncController.this.mNaviEventListeners.iterator();
          if (localIterator.hasNext()) {
            ((BaiduNaviParams.NaviEvent)localIterator.next()).onOtherAction(paramAnonymousMessage.what, paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, paramAnonymousMessage.obj);
          }
        }
      }
    }
  };
  public BNaviModuleManager.NaviCommonCallBackListener mNaviCommonCallBack = new BNaviModuleManager.NaviCommonCallBackListener()
  {
    public boolean buttomNaviTabHasFocus()
    {
      return NavMapAdapter.getInstance().buttomNaviTabHasFocus();
    }
    
    public boolean isFocusUIenable()
    {
      return NavMapAdapter.getInstance().isFocusUIEnable();
    }
    
    public boolean isMapModuleFragment()
    {
      return NavMapAdapter.getInstance().isMapModuleFragment();
    }
    
    public Bundle onNaviCommonMsg(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (paramAnonymousInt1 == 0) {
        NavMapManager.getInstance().unInit();
      }
      do
      {
        for (;;)
        {
          return null;
          if (1 == paramAnonymousInt1)
          {
            paramAnonymousObject = NavMapAdapter.getInstance().getBduss();
            if (!TextUtils.isEmpty((CharSequence)paramAnonymousObject))
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("bduss", (String)paramAnonymousObject);
              return localBundle;
            }
          }
          else if (6 == paramAnonymousInt1)
          {
            NavRoutePlanModel.getInstance().addSensorChangeListener((ISensorChangeListener)paramAnonymousObject);
          }
          else if (7 == paramAnonymousInt1)
          {
            NavRoutePlanModel.getInstance().removeSensorChangeListener((ISensorChangeListener)paramAnonymousObject);
          }
          else
          {
            if (8 == paramAnonymousInt1)
            {
              paramAnonymousObject = new Bundle();
              ((Bundle)paramAnonymousObject).putInt("KEY_ICON_ID", NavMapAdapter.getInstance().getIconId());
              return (Bundle)paramAnonymousObject;
            }
            if (14 != paramAnonymousInt1) {
              if (19 == paramAnonymousInt1)
              {
                NavCommonFuncController.this.launcherMapsAcitivityFormBackToFront();
              }
              else
              {
                if (22 == paramAnonymousInt1)
                {
                  paramAnonymousObject = new Bundle();
                  ((Bundle)paramAnonymousObject).putInt("KEY_PREFER_VALUE", NavMapAdapter.getInstance().onGetLastPreferValue());
                  return (Bundle)paramAnonymousObject;
                }
                if (23 == paramAnonymousInt1) {
                  NavMapAdapter.getInstance().onSetLastPreferValue(Integer.parseInt(String.valueOf(paramAnonymousObject)));
                } else if (24 != paramAnonymousInt1) {
                  if (25 == paramAnonymousInt1)
                  {
                    if (!NavComponentController.getInstance().invokeCollada()) {
                      NavComponentController.getInstance().loadColladaSo(false);
                    }
                  }
                  else
                  {
                    if (26 != paramAnonymousInt1) {
                      break;
                    }
                    paramAnonymousObject = (Bundle)paramAnonymousObject;
                    if (paramAnonymousObject != null) {
                      NavMapAdapter.getInstance().shareSafety(((Bundle)paramAnonymousObject).getString("LinkUrl"), ((Bundle)paramAnonymousObject).getString("ImgUrl"), ((Bundle)paramAnonymousObject).getString("Title"), ((Bundle)paramAnonymousObject).getString("Desc"), ((Bundle)paramAnonymousObject).getBoolean("OrientationUser"));
                    }
                  }
                }
              }
            }
          }
        }
      } while (paramAnonymousInt1 != 30);
      return new Bundle();
    }
    
    public boolean onNaviCommonMsgForBoolean(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      switch (paramAnonymousInt1)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 12: 
      case 14: 
      case 19: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 30: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      default: 
      case 2: 
      case 3: 
      case 5: 
      case 10: 
      case 11: 
      case 4: 
      case 13: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 20: 
      case 21: 
      case 27: 
      case 28: 
      case 29: 
        do
        {
          for (;;)
          {
            return false;
            return NavCommonFuncModel.getInstance().mIsAppForeground;
            NavMapAdapter.getInstance().removeRequestByType(NavMapAdapter.getInstance().getResultKeyMCarRoute());
            continue;
            if (NavCommonFuncModel.getInstance().mIsAppForeground) {}
          }
          return NavMapAdapter.getInstance().isGooglePlayChannel();
          BaiduNaviManager.getInstance().launchDownloadActivity(NavCommonFuncModel.getInstance().getActivity(), null);
          return true;
          BaseTTSPlayer.getInstance().setTTSStreamType(paramAnonymousInt2);
          return true;
          return NavDrivingCarController.getInstance().isDrvingCar();
          return NavComponentController.getInstance().invokeCollada();
          return false;
          return false;
          if ("android.settings.action.MANAGE_OVERLAY_PERMISSION".equals((String)paramAnonymousObject)) {
            return NavCommonFuncController.this.hasOverlayPermission();
          }
          return false;
          return NavCommonFuncController.this.requestPermission((String)paramAnonymousObject);
          paramAnonymousObject = NavCommonFuncModel.getInstance().getContext();
          if (paramAnonymousObject != null) {
            AudioUtils.releaseAudioFocus((Context)paramAnonymousObject);
          }
          return true;
          BaiduNaviManager.getInstance().initURLData();
          return true;
          if (NavCommonFuncController.this.cityDownLoadFlag == null)
          {
            NavCommonFuncController.this.cityDownLoadFlag = new boolean['Ϩ'];
            Arrays.fill(NavCommonFuncController.this.cityDownLoadFlag, false);
            paramAnonymousObject = LocalMapManager.getInstance().getUserResources();
            NavCommonFuncController.this.mapCitys = ((List)paramAnonymousObject);
            paramAnonymousInt1 = 0;
            for (;;)
            {
              if (paramAnonymousInt1 < ((List)paramAnonymousObject).size()) {
                try
                {
                  NavCommonFuncController.this.cityDownLoadFlag[((LocalMapResource)paramAnonymousObject.get(paramAnonymousInt1)).id] = true;
                  paramAnonymousInt1 += 1;
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localException.printStackTrace();
                  }
                }
              }
            }
          }
          if ((OfflineDataParams.PROVINCE_NAME != null) && (paramAnonymousInt2 >= 0) && (OfflineDataParams.PROVINCE_NAME.length > paramAnonymousInt2))
          {
            paramAnonymousObject = OfflineDataParams.PROVINCE_NAME[paramAnonymousInt2];
            LogUtil.e("DataOffLine:", "current province name is" + (String)paramAnonymousObject);
            paramAnonymousObject = LocalMapManager.getInstance().getCitiesByName((String)paramAnonymousObject);
            if ((paramAnonymousObject != null) && (((List)paramAnonymousObject).size() > 0) && (((List)paramAnonymousObject).get(0) != null))
            {
              if (((LocalMapResource)((List)paramAnonymousObject).get(0)).children == null)
              {
                if (((LocalMapResource)((List)paramAnonymousObject).get(0)).id >= NavCommonFuncController.this.cityDownLoadFlag.length)
                {
                  if (NavCommonFuncController.this.mapCitys == null) {
                    return false;
                  }
                  paramAnonymousInt1 = 0;
                  while (paramAnonymousInt1 < NavCommonFuncController.this.mapCitys.size())
                  {
                    if (((LocalMapResource)NavCommonFuncController.this.mapCitys.get(paramAnonymousInt1)).id == ((LocalMapResource)((List)paramAnonymousObject).get(0)).id) {
                      return true;
                    }
                    paramAnonymousInt1 += 1;
                  }
                  return false;
                }
                return NavCommonFuncController.this.cityDownLoadFlag[((LocalMapResource)paramAnonymousObject.get(0)).id];
              }
              LocalMapResource localLocalMapResource;
              do
              {
                paramAnonymousObject = ((List)paramAnonymousObject).iterator();
                Object localObject;
                while (!((Iterator)localObject).hasNext())
                {
                  do
                  {
                    if (!((Iterator)paramAnonymousObject).hasNext()) {
                      break;
                    }
                    localObject = (LocalMapResource)((Iterator)paramAnonymousObject).next();
                  } while ((localObject == null) || (((LocalMapResource)localObject).children == null));
                  localObject = ((LocalMapResource)localObject).children.iterator();
                }
                localLocalMapResource = (LocalMapResource)((Iterator)localObject).next();
                LogUtil.e("DataOffLine:", "children is not null,cityName is" + localLocalMapResource.name);
              } while ((localLocalMapResource.name.startsWith("所有")) || (NavCommonFuncController.this.cityDownLoadFlag[localLocalMapResource.id] != 0));
              return false;
            }
            return true;
          }
          return true;
          NavCommonFuncController.this.cityDownLoadFlag = new boolean['Ϩ'];
          Arrays.fill(NavCommonFuncController.this.cityDownLoadFlag, false);
          System.currentTimeMillis();
          NavCommonFuncController.this.mapCitys = LocalMapManager.getInstance().getUserResources();
          System.currentTimeMillis();
        } while (NavCommonFuncController.this.mapCitys == null);
        paramAnonymousInt1 = 0;
        while (paramAnonymousInt1 < NavCommonFuncController.this.mapCitys.size()) {
          try
          {
            NavCommonFuncController.this.cityDownLoadFlag[((LocalMapResource)NavCommonFuncController.this.mapCitys.get(paramAnonymousInt1)).id] = true;
            paramAnonymousInt1 += 1;
          }
          catch (Exception paramAnonymousObject)
          {
            for (;;)
            {
              ((Exception)paramAnonymousObject).printStackTrace();
            }
          }
        }
      case 31: 
        return false;
      }
      NavMapAdapter.getInstance().naviDownloadXiJiangSwitch();
      return true;
    }
    
    public void showBottomBar(boolean paramAnonymousBoolean) {}
  };
  private BNEventManager.NaviMsgListener mNaviEventListener = new BNEventManager.NaviMsgListener()
  {
    public void onOtherAction(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, Object paramAnonymousObject)
    {
      if (NavCommonFuncController.this.mNavEventHandler != null)
      {
        Message localMessage = NavCommonFuncController.this.mNavEventHandler.obtainMessage();
        localMessage.what = (paramAnonymousInt1 + 9000);
        localMessage.arg1 = paramAnonymousInt2;
        localMessage.arg2 = paramAnonymousInt3;
        localMessage.obj = paramAnonymousObject;
        localMessage.sendToTarget();
      }
    }
    
    public void onRasterMapHide() {}
    
    public void onRasterMapShow(int paramAnonymousInt, Bitmap paramAnonymousBitmap1, Bitmap paramAnonymousBitmap2) {}
    
    public void onRasterMapUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2) {}
    
    public void onRemainDistanceUpdate(CharSequence paramAnonymousCharSequence, Drawable paramAnonymousDrawable) {}
    
    public void onRemainTimeUpdate(CharSequence paramAnonymousCharSequence, Drawable paramAnonymousDrawable) {}
    
    public void onRoadNameUpdate(String paramAnonymousString) {}
    
    public void onRoadTurnInfoDistanceUpdate(CharSequence paramAnonymousCharSequence) {}
    
    public void onRoadTurnInfoIconUpdate(Drawable paramAnonymousDrawable) {}
    
    public void onSatelliteNumUpdate(int paramAnonymousInt, Drawable paramAnonymousDrawable) {}
  };
  private List<BaiduNaviParams.NaviEvent> mNaviEventListeners = new ArrayList();
  List<LocalMapResource> mapCitys = null;
  private String voiceEnter = "navi";
  
  public static NavCommonFuncController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavCommonFuncController();
    }
    return sInstance;
  }
  
  public static void importSettingToNaviSDK(Context paramContext)
  {
    PreferenceHelper localPreferenceHelper = PreferenceHelper.getInstance(paramContext);
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("navsetting", 0);
      paramContext = localSharedPreferences;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          paramContext = paramContext.getSharedPreferences("navsetting", 0);
        }
        catch (Throwable paramContext)
        {
          paramContext = null;
        }
        continue;
        boolean bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
      }
    }
    if (localPreferenceHelper != null)
    {
      if ((localPreferenceHelper.getBoolean("nav_need_adapter_setting", true)) && (paramContext != null))
      {
        if (paramContext.contains("PREF_NAVI_FIRST_USE")) {
          BNSettingManager.setNaviDisclaimerShow(paramContext.getBoolean("PREF_NAVI_FIRST_USE", true));
        }
        if (paramContext.contains("NAVI_MODE_DAY_AND_NIGHT")) {
          BNSettingManager.setNaviDayAndNightMode(paramContext.getInt("NAVI_MODE_DAY_AND_NIGHT", 0) + 1);
        }
        if (paramContext.contains("NAVI_ALWAYS_BRIGHT")) {
          BNSettingManager.setAlwaysBright(paramContext.getBoolean("NAVI_ALWAYS_BRIGHT", true));
        }
        if (paramContext.contains("NAVI_CAMERA_SPEAK_NOTIFY"))
        {
          if (paramContext.getBoolean("NAVI_CAMERA_SPEAK_NOTIFY", false)) {
            break label297;
          }
          bool = true;
          BNSettingManager.setElecCameraSpeakEnable(bool);
        }
        if (paramContext.contains("NAVI_OVER_SPEED"))
        {
          if (paramContext.getBoolean("NAVI_OVER_SPEED", false)) {
            break label302;
          }
          bool = true;
          BNSettingManager.setSpeedCameraSpeakEnable(bool);
        }
        if (paramContext.contains("NAVI_ROUTE_CONDITION"))
        {
          if (paramContext.getBoolean("NAVI_ROUTE_CONDITION", false)) {
            break label307;
          }
          bool = true;
          BNSettingManager.setRoadCondOnOff(bool);
        }
        if (paramContext.contains("NAVI_STRAIGHT"))
        {
          if (paramContext.getBoolean("NAVI_STRAIGHT", false)) {
            break label312;
          }
          bool = true;
          BNSettingManager.setStraightDirectSpeakEnable(bool);
        }
        if (paramContext.contains("NAVI_USE_LY_TTS")) {
          localPreferenceHelper.putBoolean("NAVI_USE_LY_TTS", paramContext.getBoolean("NAVI_USE_LY_TTS", true));
        }
        if (paramContext.contains("NAVI_VOICE_MODE")) {
          BNSettingManager.setVoiceMode(paramContext.getInt("NAVI_VOICE_MODE", 0));
        }
      }
      localPreferenceHelper.putBoolean("nav_need_adapter_setting", false);
    }
    else
    {
      return;
    }
  }
  
  public static void resetNavConfig(Context paramContext)
  {
    BNSettingManager.setNaviDisclaimerShow(true);
    BNSettingManager.setNaviDayAndNightMode(1);
    BNSettingManager.setAlwaysBright(true);
    BNSettingManager.setElecCameraSpeakEnable(true);
    BNSettingManager.setSpeedCameraSpeakEnable(true);
    BNSettingManager.setSpeedCameraSpeakEnable(true);
    BNSettingManager.setRoadConditionpeakEnable(true);
    BNSettingManager.setPrefRoutePlanMode(0);
    BNSettingManager.setVoiceMode(0);
  }
  
  public void addNaviEventListener(BaiduNaviParams.NaviEvent paramNaviEvent)
  {
    List localList = this.mNaviEventListeners;
    if (paramNaviEvent != null) {}
    try
    {
      if (!this.mNaviEventListeners.contains(paramNaviEvent)) {
        this.mNaviEventListeners.add(paramNaviEvent);
      }
      return;
    }
    finally {}
  }
  
  public void addRoutePlanSuccessLog(long paramLong)
  {
    PerformStatisticsController.getInstance().addRoutePlanSuccessLog(paramLong);
  }
  
  public void addTrimMemoryStat()
  {
    UserOPController.getInstance().add("7.1", "1", null, null);
  }
  
  public boolean checkFactoryMode(String paramString)
  {
    return BNPoiSearcher.getInstance().checkFactoryMode(paramString);
  }
  
  public int downLoadCityMapData(int paramInt)
  {
    return BNOfflineDataManager.getInstance().downLoadCityMapData(paramInt);
  }
  
  public void drivingToolAction()
  {
    int i = getLocationCityId();
    BNDrivingToolManager.getInstance().setCurrentCityID(i);
    String str = NavMapAdapter.getInstance().getBduss();
    if (str != null) {
      BNDrivingToolManager.getInstance().getIssueInfo().mBduss = str;
    }
  }
  
  public boolean getAutoEnterLightNavi()
  {
    return BNSettingManager.getAutoEnterLightNavi();
  }
  
  public int getFormatErrorCode(int paramInt)
  {
    if (((paramInt >= 200) && (paramInt <= 207)) || ((paramInt >= 520) && (paramInt <= 600)) || (paramInt == 9000)) {
      return 112000000 + paramInt;
    }
    if (paramInt < 5000) {
      return 412000000 + paramInt;
    }
    return 512000000 + paramInt;
  }
  
  public int getLocationCityId()
  {
    int k = 0;
    int m = -1;
    int j = k;
    int i = m;
    DistrictInfo localDistrictInfo;
    if (0 == 0)
    {
      i = NavMapAdapter.getInstance().getRoamCityId();
      localDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(i);
      j = k;
      i = m;
      if (localDistrictInfo != null)
      {
        j = k;
        i = m;
        if (localDistrictInfo.mType == 3)
        {
          j = 1;
          i = localDistrictInfo.mId;
        }
      }
    }
    k = i;
    if (j == 0)
    {
      j = NavMapAdapter.getInstance().getCurrentLocalCityId();
      localDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(j);
      k = i;
      if (localDistrictInfo != null)
      {
        k = i;
        if (localDistrictInfo.mType == 3) {
          k = localDistrictInfo.mId;
        }
      }
    }
    return k;
  }
  
  public int getLocationCityIdByPoint()
  {
    if (BNLocationManagerProxy.getInstance().isLocationValid())
    {
      LocData localLocData = BNLocationManagerProxy.getInstance().getCurLocation();
      if (localLocData != null) {
        return getLocationCityIdByPoint(localLocData.toGeoPoint());
      }
    }
    return -1;
  }
  
  public int getLocationCityIdByPoint(GeoPoint paramGeoPoint)
  {
    paramGeoPoint = BNPoiSearcher.getInstance().getDistrictByPoint(paramGeoPoint, 2);
    if ((paramGeoPoint != null) && (paramGeoPoint.mType == 3)) {
      return paramGeoPoint.mId;
    }
    return -1;
  }
  
  public PreferenceHelper getNaviPreferenceHelper(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return PreferenceHelper.getInstance(paramContext);
  }
  
  public String getVoiceEnter()
  {
    return this.voiceEnter;
  }
  
  public boolean hasCurLocationCityOfflineData()
  {
    Object localObject;
    if ((BNSysLocationManager.getInstance().isSysLocationValid()) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)))
    {
      localObject = BNSysLocationManager.getInstance().getCurLocation();
      if ((((LocData)localObject).longitude != -1.0D) || (((LocData)localObject).latitude != -1.0D)) {
        break label50;
      }
    }
    label50:
    do
    {
      return false;
      GeoPoint localGeoPoint = new GeoPoint();
      if (localObject != null)
      {
        localGeoPoint.setLatitudeE6((int)(((LocData)localObject).latitude * 100000.0D));
        localGeoPoint.setLongitudeE6((int)(((LocData)localObject).longitude * 100000.0D));
      }
      for (localObject = BNPoiSearcher.getInstance().getDistrictByPoint(localGeoPoint, 0); (localObject != null) && (((DistrictInfo)localObject).mType > 2); localObject = BNPoiSearcher.getInstance().getParentDistrict(((DistrictInfo)localObject).mId)) {}
    } while (localObject == null);
    return BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject).mId);
  }
  
  public boolean hasCurRouteNodesCityOfflineData()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    int i;
    if (BNavigator.getInstance().isNaviBegin())
    {
      bool1 = bool3;
      if (hasCurLocationCityOfflineData())
      {
        bool1 = bool3;
        if (RoutePlanModel.sNavNodeList != null)
        {
          bool1 = bool3;
          if (RoutePlanModel.sNavNodeList.size() >= 2)
          {
            i = 1;
            bool1 = bool2;
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (i < RoutePlanModel.sNavNodeList.size())
      {
        localObject = ((RoutePlanNode)RoutePlanModel.sNavNodeList.get(i)).mGeoPoint;
        for (localObject = BNPoiSearcher.getInstance().getDistrictByPoint((GeoPoint)localObject, 0); (localObject != null) && (((DistrictInfo)localObject).mType > 2); localObject = BNPoiSearcher.getInstance().getParentDistrict(((DistrictInfo)localObject).mId)) {}
        if (localObject == null) {
          break label142;
        }
      }
      label142:
      for (bool1 = BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject).mId); !bool1; bool1 = false) {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean hasGPSPermission()
  {
    return hasGPSPermission(BNaviModuleManager.getActivity());
  }
  
  public boolean hasGPSPermission(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getPackageManager();
      if ((paramActivity != null) && (-1 == paramActivity.checkPermission("android.permission.ACCESS_FINE_LOCATION", "com.baidu.carlife"))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean hasOverlayPermission()
  {
    return Build.VERSION.SDK_INT < 23;
  }
  
  public boolean isFastDoubleClick()
  {
    return ForbidDaulClickUtils.isFastDoubleClick(1500L);
  }
  
  public boolean isForegroundServiceOpen()
  {
    boolean bool = CloudlConfigDataModel.getInstance().mCommonConfig.foregroundService;
    NavLogUtils.e(TAG, "isForegroundServiceOpen: cloudConfigOpen --> " + bool);
    return bool;
  }
  
  public boolean isNaviBegin()
  {
    return (BNavigator.getInstance().isNaviBegin()) || (BCruiser.getInstance().isRouteCruiseBegin());
  }
  
  public boolean isProvinceDataDownload(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      bool1 = bool2;
      if (BNOfflineDataManager.getInstance().isProvinceDataDownload(paramInt)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void launchDownloadActivity(Context paramContext, String paramString)
  {
    if (paramString != null) {
      new Bundle().putBoolean("KEY_FROM_CRUISER", true);
    }
    h.a().showFragment(554, null);
  }
  
  public void launchUgcMangerActivity(Context paramContext) {}
  
  public void launchUgcPickActivity(Context paramContext, Bundle paramBundle) {}
  
  public void launcherMapsAcitivityFormBackToFront() {}
  
  public boolean onBackPressRCEvent()
  {
    return BNRCEventDetailsViewController.getInstance().onBackPressed();
  }
  
  public void onBackground()
  {
    NavLogUtils.e(TAG, "onBackground()");
    UserOPController.getInstance().add("1.n");
    NavCommonFuncModel.getInstance().mIsAppForeground = false;
    if (!BNavigator.getInstance().isNaviBegin()) {
      BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
    }
    RGViewController.getInstance().onBackground();
    try
    {
      BNStatisticsManager.getInstance().saveStatistics();
      BaiduNaviManager.getInstance().notifyMapGPSEnable(false);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public void onForeground()
  {
    NavLogUtils.e(TAG, "onForeground()");
    UserOPController.getInstance().add("1.m");
    NavCommonFuncModel.getInstance().mIsAppForeground = true;
    RGViewController.getInstance().onForeground();
    BNStatisticsManager.getInstance().upLoadStatistics();
    BaiduNaviManager.getInstance().notifyMapGPSEnable(true);
  }
  
  public void pauseAllDownload() {}
  
  public void registerNaviEventListener()
  {
    BNEventManager.getInstance().setNaviMsgListener(this.mNaviEventListener);
  }
  
  public void removeNaviEventListener(BaiduNaviParams.NaviEvent paramNaviEvent)
  {
    List localList = this.mNaviEventListeners;
    if (paramNaviEvent != null) {}
    try
    {
      if (this.mNaviEventListeners.contains(paramNaviEvent)) {
        this.mNaviEventListeners.remove(paramNaviEvent);
      }
      return;
    }
    finally {}
  }
  
  public boolean requestPermission(String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while ((NavCommonFuncModel.getInstance().getActivity() == null) || (paramString == null)) {
      return false;
    }
    return true;
  }
  
  public void resetLastDoubleClickTime() {}
  
  public void setDrivingToolVisibility(boolean paramBoolean)
  {
    com.baidu.navisdk.util.drivertool.BNDrivingToolUtils.sCanShow = paramBoolean;
  }
  
  public void setExternalCall(boolean paramBoolean, Bundle paramBundle)
  {
    BNVoice.getInstance().setExternalCall(paramBoolean, paramBundle);
  }
  
  public void setVoiceEnter(String paramString)
  {
    this.voiceEnter = paramString;
  }
  
  public void showNavPage(String paramString, Bundle paramBundle)
  {
    NavFragmentManager.getInstance().showNavMapMapPage(paramString, paramBundle);
  }
  
  public void startForegroundService(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if (isForegroundServiceOpen())
        {
          NavLogUtils.e(TAG, "startForegroundService: --> ");
          paramContext.startService(new Intent(paramContext, ForegroundService.class));
          return;
        }
      }
      catch (Throwable paramContext) {}
    }
  }
  
  public void stopForegroundService(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if (isForegroundServiceOpen())
        {
          NavLogUtils.e(TAG, "stopForegroundService: --> ");
          paramContext.stopService(new Intent(paramContext, ForegroundService.class));
          return;
        }
      }
      catch (Throwable paramContext) {}
    }
  }
  
  public void unregisterNaviEventListener()
  {
    BNEventManager.getInstance().setNaviMsgListener(null);
  }
  
  public void updateAccountInfoWhenLoginSuccess()
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("updateAccountInfoWhenLoginSuccess()  updateUserInfo, bduss=").append(NavMapAdapter.getInstance().getBduss()).append(", uid=").append(NavMapAdapter.getInstance().getUid()).append(", islogin=");
    if (NavMapAdapter.getInstance().isLogin()) {}
    for (int i = 1;; i = 0)
    {
      NavLogUtils.e(str, i);
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavCommonFuncController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */