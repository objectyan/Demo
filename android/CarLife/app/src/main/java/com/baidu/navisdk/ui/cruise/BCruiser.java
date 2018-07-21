package com.baidu.navisdk.ui.cruise;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.control.CruiseDialogManager;
import com.baidu.navisdk.ui.cruise.control.CruiseDialogManager.CruiseDialogManagerInterface;
import com.baidu.navisdk.ui.cruise.control.CruiseMapController;
import com.baidu.navisdk.ui.cruise.model.CruiseCacheStatus;
import com.baidu.navisdk.ui.cruise.model.CruiseCameraType;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.ui.cruise.view.CruiseMapControlPanel.ControlPanelClickListener;
import com.baidu.navisdk.ui.cruise.view.CruiseMapView;
import com.baidu.navisdk.ui.cruise.view.CruiseMapView.IQuitCruiseClickListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.NetworkListener;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNLocateTrackManager;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.CruiseStatItem;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapGLSurfaceView;
import com.baidu.nplatform.comjni.map.basemap.LocationCallback;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BCruiser
{
  private static final int INVALID_ASSIST_REMAIN_DIST = -1;
  private static final String TAG = "Cruise";
  private static volatile BCruiser me = null;
  private Activity mActivity;
  private IBCruiserListener mBCruiserListener;
  private List<OnCruiseBeginListener> mBCruiserListeners = new ArrayList();
  private CruiseMapView.IQuitCruiseClickListener mBCruiserQuitCruiseClickListener = new CruiseMapView.IQuitCruiseClickListener()
  {
    public void onClickQuitCruise()
    {
      BCruiser.this.showQuitDialog();
    }
  };
  private Context mContext;
  private CruiseDialogManager.CruiseDialogManagerInterface mCruiseDialogManagerInterface;
  private ILocationListener mCruiseLocationListener = new ILocationListener()
  {
    public void onGpsStatusChange(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      LogUtil.e("Cruise", "onGpsStatusChange: enabled " + paramAnonymousBoolean1 + ", available " + paramAnonymousBoolean2);
      if (!paramAnonymousBoolean1)
      {
        if ((BCruiser.this.mGPSOpened) && (BCruiser.this.mGPSAvailable) && (BCruiser.this.mStatItem != null))
        {
          localCruiseStatItem = BCruiser.this.mStatItem;
          localCruiseStatItem.mLostGPSCount += 1;
        }
        BCruiser.access$102(BCruiser.this, false);
        BCruiser.access$202(BCruiser.this, false);
        if ((BCruiser.this.mCruiseMapView != null) && (BCruiser.this.mDialogManager != null))
        {
          BCruiser.this.mCruiseMapView.setViewWhenNoGPS();
          BCruiser.this.mDialogManager.showGPSSettingDialog();
        }
      }
      do
      {
        do
        {
          return;
        } while (!paramAnonymousBoolean1);
        BCruiser.access$102(BCruiser.this, true);
        BCruiser.this.mDialogManager.dismissGPSSettingDialog();
        BCruiser.access$202(BCruiser.this, paramAnonymousBoolean2);
        if (BCruiser.this.mGPSAvailable)
        {
          BCruiser.this.mCruiseMapView.setViewWhenGPSRecover();
          return;
        }
        BCruiser.this.mCruiseMapView.setViewWhenNotLocated();
      } while (BCruiser.this.mStatItem == null);
      CruiseStatItem localCruiseStatItem = BCruiser.this.mStatItem;
      localCruiseStatItem.mLostGPSCount += 1;
    }
    
    public void onLocationChange(LocData paramAnonymousLocData) {}
    
    public void onWGS84LocationChange(LocData paramAnonymousLocData1, LocData paramAnonymousLocData2)
    {
      BCruiser.this.startRouteCruise();
      if (BCruiser.this.mBCruiserListener != null) {
        BCruiser.this.mBCruiserListener.notifyLoacteData(paramAnonymousLocData2);
      }
      CruiseUIModel.getInstance().setLastLocationData(paramAnonymousLocData2);
      BCruiser.this.updateLocation(paramAnonymousLocData1, paramAnonymousLocData2);
    }
  };
  private CruiseMapView mCruiseMapView = null;
  private CruiseDialogManager mDialogManager;
  private boolean mGPSAvailable = true;
  private boolean mGPSOpened = true;
  private Handler mHandler;
  private boolean mHasLocation = true;
  private boolean mIsCruiseBegin = false;
  private boolean mIsCruiseTypeShowing = false;
  private boolean mIsCruiserStarted = false;
  private boolean mIsItsOpen = false;
  private boolean mIsNeedShowSettingsMenu = false;
  private boolean mIsTrackLocate = false;
  private MsgHandler mMsgHandler;
  private MapGLSurfaceView mNMapView;
  private BNDialog.OnNaviClickListener mOnDownloadClickListener = new BNDialog.OnNaviClickListener()
  {
    public void onClick()
    {
      BCruiser.this.notifyCruiseFragmentNoData(true);
    }
  };
  private FrameLayout mParentView = null;
  private Vector<OnRGInfoListener> mRGInfoListeners = new Vector(0);
  CruiseStatItem mStatItem;
  
  private void checkCurrentProvinceDataDownloaded()
  {
    Object localObject = GeoLocateModel.getInstance().getLastLocation();
    if ((localObject != null) && (((LocData)localObject).isValid()))
    {
      this.mHasLocation = true;
      if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
        break label54;
      }
      LogUtil.e("Cruise", "no common offline data!");
    }
    label54:
    do
    {
      return;
      this.mHasLocation = false;
      LogUtil.e("Cruise", "checkProvinceData: no valid location!");
      return;
      GeoPoint localGeoPoint = new GeoPoint();
      localGeoPoint.setLatitudeE6((int)(((LocData)localObject).latitude * 100000.0D));
      localGeoPoint.setLongitudeE6((int)(((LocData)localObject).longitude * 100000.0D));
      for (localObject = BNPoiSearcher.getInstance().getDistrictByPoint(localGeoPoint, 0); (localObject != null) && (((DistrictInfo)localObject).mType > 2); localObject = BNPoiSearcher.getInstance().getParentDistrict(((DistrictInfo)localObject).mId)) {}
    } while (localObject == null);
    boolean bool = BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject).mId);
    CruiseUIModel.getInstance().setProvinceDataDownloaded(bool);
  }
  
  private boolean checkDataDownload()
  {
    boolean bool;
    if (GeoLocateModel.getInstance().getLastLocation() != null)
    {
      bool = true;
      this.mHasLocation = bool;
      LogUtil.e("Cruise", "checkDataDownload, hasLocation " + this.mHasLocation);
      if (this.mHasLocation) {
        break label57;
      }
    }
    label57:
    do
    {
      do
      {
        return false;
        bool = false;
        break;
      } while (NetworkUtils.isNetworkAvailable(this.mContext));
      checkCurrentProvinceDataDownloaded();
    } while (CruiseUIModel.getInstance().isProvinceDataDownloaded());
    if (this.mDialogManager != null) {
      this.mDialogManager.showCruiseUnavailableDialog(this.mOnDownloadClickListener);
    }
    return true;
  }
  
  private void createHandler()
  {
    this.mHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool;
        if (paramAnonymousMessage.what == 5555)
        {
          if (paramAnonymousMessage.arg2 != 1) {
            break label102;
          }
          bool = true;
          CruiseUIModel.getInstance().setConnected(bool);
          LogUtil.e("Cruise", "recved MSG_TYPE_NET_WORK_CHANGE, connected " + bool);
          if (!bool) {
            break label107;
          }
          BCruiser.this.mDialogManager.hideCruiseUnavailableDialog();
          if (BCruiser.this.mCruiseMapView != null) {
            BCruiser.this.mCruiseMapView.setNetworkAvailable(true);
          }
        }
        for (;;)
        {
          BCruiser.access$702(BCruiser.this, BCruiser.this.hasLocation());
          return;
          label102:
          bool = false;
          break;
          label107:
          if (!CruiseUIModel.getInstance().isProvinceDataDownloaded())
          {
            BCruiser.this.mDialogManager.showCruiseUnavailableDialog(BCruiser.this.mOnDownloadClickListener);
            if (BCruiser.this.mCruiseMapView != null) {
              BCruiser.this.mCruiseMapView.setNetworkAvailable(false);
            }
          }
        }
      }
    };
  }
  
  private void createMsgHandler()
  {
    this.mMsgHandler = new MsgHandler()
    {
      public void careAbout()
      {
        observe(new int[] { 4116, 4104, 4105, 4106, 4143, 4149, 4150, 4151, 4108, 4171 });
      }
      
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
        label201:
        label215:
        do
        {
          do
          {
            do
            {
              return;
              Object localObject = new StringBuilder().append("recved msg: GPS_STATUS_CHANGE, enable ");
              boolean bool;
              if (paramAnonymousMessage.arg1 == 1)
              {
                bool = true;
                LogUtil.e("Cruise", bool);
                if (paramAnonymousMessage.arg1 != 1) {
                  break label215;
                }
                BCruiser.access$202(BCruiser.this, true);
                if (BCruiser.this.mCruiseMapView != null)
                {
                  if (!BCruiser.this.isCruiserAvailable(BCruiser.this.mActivity)) {
                    break label201;
                  }
                  BCruiser.this.mCruiseMapView.setViewWhenGPSRecover();
                }
              }
              for (;;)
              {
                BCruiser.this.notifyGpsStatusChange(paramAnonymousMessage);
                return;
                bool = false;
                break;
                BCruiser.this.mCruiseMapView.setNetworkAvailable(false);
                continue;
                if (paramAnonymousMessage.arg1 == 0)
                {
                  BCruiser.access$202(BCruiser.this, false);
                  if (BCruiser.this.mCruiseMapView != null) {
                    BCruiser.this.mCruiseMapView.setViewWhenNotLocated();
                  }
                  if (BCruiser.this.mStatItem != null)
                  {
                    localObject = BCruiser.this.mStatItem;
                    ((CruiseStatItem)localObject).mLostGPSCount += 1;
                  }
                }
              }
              BCruiser.access$902(BCruiser.this, true);
              BCruiser.this.onAssistInfoShow(paramAnonymousMessage);
              BCruiser.this.notifyAssistIconShow(paramAnonymousMessage);
              return;
              BCruiser.this.onAssistInfoUpdate(paramAnonymousMessage);
              BCruiser.this.notifyAssistIconUpdate(paramAnonymousMessage);
              return;
              BCruiser.access$902(BCruiser.this, false);
              BCruiser.this.onAssistInfoHide(paramAnonymousMessage);
              BCruiser.this.notifyAssistIconHide(paramAnonymousMessage);
              return;
              LogUtil.e("Cruise", "~~~ MSG_NAVI_CRUISE_YAW received");
              BCruiser.access$902(BCruiser.this, false);
              BCruiser.this.hideCruiseTypeView();
              return;
              LogUtil.e("Cruise", "received MSG_NAVI_CRUISE_SWITCH_NO_DATA");
              CruiseUIModel.getInstance().setProvinceDataDownloaded(false);
            } while (BCruiser.this.mCruiseMapView == null);
            BCruiser.this.mCruiseMapView.setCurrentRoadVisible(false);
            if (NetworkUtils.isNetworkAvailable(BCruiser.this.mActivity))
            {
              BCruiser.this.mCruiseMapView.setNetworkAvailable(true);
              return;
            }
            BCruiser.this.mCruiseMapView.setNetworkAvailable(false);
            return;
            LogUtil.e("Cruise", "received MSG_NAVI_CRUISE_SWITCH_EXIST_DATA");
            BCruiser.access$702(BCruiser.this, BCruiser.this.hasLocation());
            CruiseUIModel.getInstance().setProvinceDataDownloaded(true);
          } while (BCruiser.this.mCruiseMapView == null);
          BCruiser.this.mCruiseMapView.setCurrentRoadVisible(true);
          BCruiser.this.mCruiseMapView.setNetworkAvailable(true);
          return;
          BCruiser.this.onNetSwitchHide();
          return;
          BCruiser.this.onCurrentRoadNameUpdate(paramAnonymousMessage);
          return;
        } while (BCruiser.this.mCruiseMapView == null);
        BCruiser.this.mCruiseMapView.updateSatelliteViews(paramAnonymousMessage.arg2);
      }
    };
  }
  
  public static void destory()
  {
    if (me != null) {}
    try
    {
      if (me != null) {
        me.dispose();
      }
      me = null;
      return;
    }
    finally {}
  }
  
  private void dispose()
  {
    if (this.mParentView != null) {
      this.mParentView.removeAllViews();
    }
    if (this.mActivity != null) {
      this.mActivity = null;
    }
  }
  
  public static BCruiser getInstance()
  {
    if (me == null) {}
    try
    {
      if (me == null) {
        me = new BCruiser();
      }
      return me;
    }
    finally {}
  }
  
  private Bundle getMsgData(Message paramMessage)
  {
    if ((paramMessage != null) && ((paramMessage.obj instanceof Bundle))) {
      return (Bundle)paramMessage.obj;
    }
    return null;
  }
  
  private void hideCruiseTypeView()
  {
    Bundle localBundle = new CruiseCameraType(3, 0, 0).toBundle();
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.updateData(localBundle);
    }
  }
  
  private void initCruise()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("CloseSpeedCamera", PreferenceHelper.getInstance(this.mContext).getInt("CloseSpeedCamera", 0));
    ((Bundle)localObject).putInt("CloseTrafficLightCamera", PreferenceHelper.getInstance(this.mContext).getInt("CloseTrafficLightCamera", 0));
    ((Bundle)localObject).putInt("ClosePeccanryCamera", PreferenceHelper.getInstance(this.mContext).getInt("ClosePeccanryCamera", 0));
    ((Bundle)localObject).putInt("CloseTrafficSign", PreferenceHelper.getInstance(this.mContext).getInt("CloseTrafficSign", 0));
    BNRouteGuider.getInstance().SetCruiseSetting((Bundle)localObject);
    BNRouteGuider.getInstance().setLocateMode(1);
    localObject = GeoLocateModel.getInstance().getLastLocation();
    if (localObject != null)
    {
      localObject = ((LocData)localObject).clone();
      ((LocData)localObject).speed = 0.0F;
      ((LocData)localObject).satellitesNum = 0;
      updateLocation(null, (LocData)localObject);
    }
  }
  
  private void initGpsLocateViews()
  {
    this.mGPSOpened = BNSysLocationManager.getInstance().isGpsEnabled();
    this.mGPSAvailable = BNSysLocationManager.getInstance().isGpsAvailable();
    LogUtil.e("Cruise", "initGps, enable " + this.mGPSOpened + ", available " + this.mGPSAvailable);
    if (this.mCruiseMapView != null)
    {
      if (this.mGPSOpened) {
        break label83;
      }
      this.mCruiseMapView.setViewWhenNoGPS();
    }
    label83:
    while (this.mGPSAvailable) {
      return;
    }
    this.mCruiseMapView.setViewWhenNotLocated();
  }
  
  private void initLocationService()
  {
    if ((BNExtGPSLocationManager.getInstance().isGpsEnabled()) && (BNExtGPSLocationManager.getInstance().isGpsAvailable()))
    {
      BNSysLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
      BNExtGPSLocationManager.getInstance().addLocationListener(this.mCruiseLocationListener);
      return;
    }
    BNExtGPSLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
    BNSysLocationManager.getInstance().startNaviLocate(this.mContext);
    BNSysLocationManager.getInstance().addLocationListener(this.mCruiseLocationListener);
  }
  
  private void initScreenAlwaysOn()
  {
    VDeviceAPI.setScreenAlwaysOn(PreferenceHelper.getInstance(this.mActivity.getApplicationContext()).getBoolean("NAVI_ALWAYS_BRIGHT", true));
  }
  
  private void notifyCruiseBeginListener(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.mBCruiserListeners.size())
    {
      ((OnCruiseBeginListener)this.mBCruiserListeners.get(i)).onCruiseBegin(paramBoolean);
      i += 1;
    }
  }
  
  private void onNetSwitchHide()
  {
    if (this.mCruiseMapView == null) {
      return;
    }
    Bundle localBundle = new CruiseCameraType(3, 0, 0).toBundle();
    this.mCruiseMapView.updateData(localBundle);
  }
  
  private void parseConfigParams(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cruiser_view_mode")) {
      BCruiserConfig.pRGViewMode = paramBundle.getInt("cruiser_view_mode");
    }
  }
  
  private void restoreRGSetting()
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
      return;
    }
    int i = BNSettingManager.getVoiceMode();
    BNRouteGuider.getInstance().setVoiceMode(i);
    boolean bool = BNSettingManager.isElecCameraSpeakEnable();
    BNRouteGuider.getInstance().SetOtherCameraSpeak(bool);
    bool = BNSettingManager.isSpeedCameraSpeakEnable();
    BNRouteGuider.getInstance().SetOverspeedSpeak(bool);
    bool = BNSettingManager.isStraightDirectSpeakEnable();
    BNRouteGuider.getInstance().SetStraightSpeak(bool);
  }
  
  private void restoreScreenAlwaysOn()
  {
    VDeviceAPI.setScreenAlwaysOn(false);
  }
  
  private void setupListener()
  {
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.setBCruiserQuitCruiseClickListener(this.mBCruiserQuitCruiseClickListener);
    }
  }
  
  private void setupUI()
  {
    boolean bool = true;
    if (this.mParentView == null) {
      return;
    }
    this.mParentView.removeAllViews();
    if ((BCruiserConfig.pRGViewMode != 0) || (this.mNMapView != null)) {}
    try
    {
      localObject = (ViewGroup)this.mNMapView.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeAllViews();
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new LinearLayout.LayoutParams(-1, -1);
    this.mParentView.addView(this.mNMapView, (ViewGroup.LayoutParams)localObject);
    this.mParentView.requestLayout();
    this.mCruiseMapView = new CruiseMapView(this.mActivity, this.mParentView, false);
    CruiseMapController.getInstance().setCruiseMapView(this.mCruiseMapView);
    localObject = this.mCruiseMapView;
    if (BNSettingManager.getNaviDayAndNightMode() != 3) {}
    for (;;)
    {
      ((CruiseMapView)localObject).onUpdateStyle(bool);
      return;
      BCruiserConfig.pRGViewMode = 1;
      break;
      bool = false;
    }
  }
  
  public static void showNetworkUnavailableTips(Context paramContext)
  {
    TipTool.onCreateToastDialog(paramContext, JarUtils.getResources().getString(1711669696));
  }
  
  private void startRouteCruise()
  {
    if (!this.mIsCruiserStarted)
    {
      LogUtil.e("Cruise", "startRouteCruise... ");
      BNMapController.getInstance().showLayer(20, true);
      BNMapController.getInstance().showLayer(14, false);
      this.mIsCruiserStarted = true;
      BNRouteGuider.getInstance().startRouteCruise();
      BNRouteGuider.getInstance().setBrowseStatus(false);
      CruiseMapController.getInstance().setCruiseEngineStarted(true);
      CruiseMapController.getInstance().initMapStatus();
      TTSPlayerControl.playTTSText(BNStyleManager.getString(1711669751), 0);
      if (this.mStatItem != null) {
        this.mStatItem.mStartCruiseEngineTime = SystemClock.elapsedRealtime();
      }
      if ((hasLocation()) && (this.mCruiseMapView != null)) {
        this.mCruiseMapView.setViewWhenGPSRecover();
      }
      if (this.mBCruiserListener != null) {
        this.mBCruiserListener.notifyStartCruiser();
      }
      if (this.mBCruiserListeners != null)
      {
        int i = 0;
        while (i < this.mBCruiserListeners.size())
        {
          ((OnCruiseBeginListener)this.mBCruiserListeners.get(i)).onCruiseBegin(true);
          i += 1;
        }
      }
    }
  }
  
  private void stopRouteCruise()
  {
    if (this.mStatItem != null)
    {
      this.mStatItem.mTotalDistance = BNRouteGuider.getInstance().getCurrentRouteDrvieDistance();
      this.mStatItem.onEvent();
    }
    if (this.mIsCruiserStarted)
    {
      BNRouteGuider.getInstance().stopRouteCruise();
      this.mIsCruiserStarted = false;
      CruiseMapController.getInstance().setCruiseEngineStarted(false);
    }
  }
  
  public void addOnCruiseBeginListener(OnCruiseBeginListener paramOnCruiseBeginListener)
  {
    if ((paramOnCruiseBeginListener != null) && (!this.mBCruiserListeners.contains(paramOnCruiseBeginListener))) {
      this.mBCruiserListeners.add(paramOnCruiseBeginListener);
    }
  }
  
  public void addRGInfoListeners(OnRGInfoListener paramOnRGInfoListener)
  {
    if ((paramOnRGInfoListener != null) && (!this.mRGInfoListeners.contains(paramOnRGInfoListener))) {
      this.mRGInfoListeners.add(paramOnRGInfoListener);
    }
  }
  
  public void changeToCar3DView()
  {
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.changeToCar3DView();
    }
  }
  
  public void changeToNorth2DView()
  {
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.changeToNorth2DView();
    }
  }
  
  public int getAssistRemainDist(Bundle paramBundle)
  {
    int i = -1;
    if (paramBundle != null) {
      i = paramBundle.getInt("remain_dist", -1);
    }
    if (i == -1) {
      return CruiseCacheStatus.sAssistRemainDist;
    }
    CruiseCacheStatus.sAssistRemainDist = i;
    return i;
  }
  
  protected Context getContext()
  {
    return this.mContext;
  }
  
  public boolean hasLocation()
  {
    if (this.mIsTrackLocate) {
      return BNLocateTrackManager.getInstance().isGpsTrackFileInstalled();
    }
    if ((BNExtGPSLocationManager.getInstance().isGpsEnabled()) && (BNExtGPSLocationManager.getInstance().isGpsAvailable())) {
      return true;
    }
    return BNSysLocationManager.getInstance().isSysLocationValid();
  }
  
  public View init(Activity paramActivity, Bundle paramBundle, MapGLSurfaceView paramMapGLSurfaceView)
  {
    LogUtil.e("Cruise", "init... ");
    this.mIsCruiseBegin = true;
    this.mActivity = paramActivity;
    this.mContext = paramActivity.getApplicationContext();
    TTSPlayerControl.setNaviMuteState(false);
    BNPowerSaver.getInstance().init(paramActivity);
    CruiseMapController.getInstance().init(this.mContext);
    createHandler();
    createMsgHandler();
    this.mStatItem = CruiseStatItem.getInstance();
    this.mStatItem.mStartCruiseTime = SystemClock.elapsedRealtime();
    this.mDialogManager = new CruiseDialogManager(this.mActivity);
    this.mDialogManager.setCruiseDialogManagerInterface(this.mCruiseDialogManagerInterface);
    CruiseCacheStatus.sOrientation = 2;
    paramActivity = GeoLocateModel.getInstance().getLastLocation();
    CruiseUIModel.getInstance().setLastLocationData(paramActivity);
    checkCurrentProvinceDataDownloaded();
    CruiseUIModel.getInstance().setConnected(NetworkUtils.isNetworkAvailable(this.mContext));
    try
    {
      this.mParentView = ((FrameLayout)JarUtils.inflate(this.mActivity, 1711472659, null));
      this.mNMapView = paramMapGLSurfaceView;
      parseConfigParams(paramBundle);
      setupUI();
      VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
      setupListener();
      CruiseMapController.getInstance().initMapView();
      initCruise();
      initLocationService();
      NetworkListener.registerMessageHandler(this.mHandler);
      initScreenAlwaysOn();
      BNMapController.getInstance().sendCommandToMapEngine(2, null);
      if (PreferenceHelper.getInstance(this.mContext).getBoolean("SP_Cruise_Text_Newer_Guide", true)) {
        PreferenceHelper.getInstance(this.mContext).putBoolean("SP_Cruise_Text_Newer_Guide", false);
      }
      return this.mParentView;
    }
    catch (Exception paramActivity)
    {
      this.mIsCruiseBegin = false;
    }
    return null;
  }
  
  public void innerJumpToOfflineDataManagerPage()
  {
    if (this.mBCruiserListener != null) {
      this.mBCruiserListener.onPageJump(2, Boolean.valueOf(true));
    }
  }
  
  public boolean isCruiseBegin()
  {
    return this.mIsCruiseBegin;
  }
  
  public boolean isCruiseOnline(Context paramContext)
  {
    if (CruiseUIModel.getInstance().isProvinceDataDownloaded()) {
      return false;
    }
    return NetworkUtils.isNetworkAvailable(paramContext);
  }
  
  public boolean isCruiserAvailable(Context paramContext)
  {
    boolean bool1;
    if (NetworkUtils.isNetworkAvailable(paramContext)) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = CruiseUIModel.getInstance().isProvinceDataDownloaded();
      bool1 = bool2;
    } while (bool2);
    return bool2;
  }
  
  public boolean isOfflineDataDownloaded()
  {
    boolean bool = false;
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      Object localObject2 = BNSysLocationManager.getInstance().getCurLocation();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = BNLocationManagerProxy.getInstance().getCurLocation();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          LogUtil.e("Cruise", "isCruiserAvailable: no location data!");
          return false;
        }
      }
      if ((((LocData)localObject1).longitude == -1.0D) && (((LocData)localObject1).latitude == -1.0D))
      {
        localObject2 = CoordinateTransformUtil.MC2LLE6(CruiseCacheStatus.sInitLongitudeMC, CruiseCacheStatus.sInitLatitudeMC);
        if (localObject2 != null)
        {
          ((LocData)localObject1).longitude = (((Bundle)localObject2).getInt("LLx") / 100000.0D);
          ((LocData)localObject1).latitude = (((Bundle)localObject2).getInt("LLy") / 100000.0D);
        }
      }
      localObject2 = new GeoPoint();
      if (localObject1 != null)
      {
        ((GeoPoint)localObject2).setLatitudeE6((int)(((LocData)localObject1).latitude * 100000.0D));
        ((GeoPoint)localObject2).setLongitudeE6((int)(((LocData)localObject1).longitude * 100000.0D));
      }
      for (localObject1 = BNPoiSearcher.getInstance().getDistrictByPoint((GeoPoint)localObject2, 0); (localObject1 != null) && (((DistrictInfo)localObject1).mType > 2); localObject1 = BNPoiSearcher.getInstance().getParentDistrict(((DistrictInfo)localObject1).mId)) {}
      if (localObject1 == null) {
        break label213;
      }
      bool = BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject1).mId);
      CruiseUIModel.getInstance().setProvinceDataDownloaded(bool);
    }
    for (;;)
    {
      return bool;
      label213:
      bool = true;
    }
  }
  
  public boolean isRouteCruiseBegin()
  {
    return this.mIsCruiserStarted;
  }
  
  public void notifyAssistIconHide(Message paramMessage)
  {
    int i = 0;
    while (i < this.mRGInfoListeners.size())
    {
      OnRGInfoListener localOnRGInfoListener = (OnRGInfoListener)this.mRGInfoListeners.get(i);
      if (localOnRGInfoListener == null)
      {
        this.mRGInfoListeners.remove(i);
      }
      else
      {
        localOnRGInfoListener.onAssistInfoHide(paramMessage);
        i += 1;
      }
    }
  }
  
  public void notifyAssistIconShow(Message paramMessage)
  {
    int i = 0;
    while (i < this.mRGInfoListeners.size())
    {
      OnRGInfoListener localOnRGInfoListener = (OnRGInfoListener)this.mRGInfoListeners.get(i);
      if (localOnRGInfoListener == null)
      {
        this.mRGInfoListeners.remove(i);
      }
      else
      {
        localOnRGInfoListener.onAssistInfoShow(paramMessage);
        i += 1;
      }
    }
  }
  
  public void notifyAssistIconUpdate(Message paramMessage)
  {
    int i = 0;
    while (i < this.mRGInfoListeners.size())
    {
      OnRGInfoListener localOnRGInfoListener = (OnRGInfoListener)this.mRGInfoListeners.get(i);
      if (localOnRGInfoListener == null)
      {
        this.mRGInfoListeners.remove(i);
      }
      else
      {
        localOnRGInfoListener.onAssistInfoUpdate(paramMessage);
        i += 1;
      }
    }
  }
  
  public void notifyCruiseFragmentNoData(boolean paramBoolean)
  {
    if (!paramBoolean) {
      quitCruise();
    }
    if (this.mBCruiserListener != null) {
      this.mBCruiserListener.onPageJump(2, Boolean.valueOf(paramBoolean));
    }
  }
  
  public void notifyCruiseFragmentQuitCruise()
  {
    if (this.mBCruiserListener != null) {
      this.mBCruiserListener.onPageJump(1, Integer.valueOf(0));
    }
  }
  
  public void notifyGpsStatusChange(Message paramMessage)
  {
    int i = 0;
    while (i < this.mRGInfoListeners.size())
    {
      OnRGInfoListener localOnRGInfoListener = (OnRGInfoListener)this.mRGInfoListeners.get(i);
      if (localOnRGInfoListener == null)
      {
        this.mRGInfoListeners.remove(i);
      }
      else
      {
        localOnRGInfoListener.onOtherRGInfo(paramMessage);
        i += 1;
      }
    }
  }
  
  public void onAssistInfoHide(Message paramMessage)
  {
    Bundle localBundle = new CruiseCameraType(3, paramMessage.arg1, paramMessage.arg2).toBundle();
    int i = getAssistRemainDist(getMsgData(paramMessage));
    CruiseUIModel.getInstance().setCameraDistance(i);
    LogUtil.e("Cruise", "onAssistInfoHide msg.arg1 = " + paramMessage.arg1 + " msg.arg2 = " + paramMessage.arg2 + " distance = " + CruiseCacheStatus.sAssistRemainDist);
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.updateData(localBundle);
    }
  }
  
  public void onAssistInfoShow(Message paramMessage)
  {
    Bundle localBundle = new CruiseCameraType(1, paramMessage.arg1, paramMessage.arg2).toBundle();
    int i = getAssistRemainDist(getMsgData(paramMessage));
    CruiseUIModel.getInstance().setCameraDistance(i);
    LogUtil.e("Cruise", "onAssistInfoShow msg.arg1 = " + paramMessage.arg1 + " msg.arg2 = " + paramMessage.arg2);
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.updateData(localBundle);
    }
  }
  
  public void onAssistInfoUpdate(Message paramMessage)
  {
    Bundle localBundle = new CruiseCameraType(2, paramMessage.arg1, paramMessage.arg2).toBundle();
    int i = getAssistRemainDist(getMsgData(paramMessage));
    CruiseUIModel.getInstance().setCameraDistance(i);
    LogUtil.e("Cruise", "onAssistInfoUpdate msg.arg1 = " + paramMessage.arg1 + " msg.arg2 = " + paramMessage.arg2);
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.updateData(localBundle);
    }
  }
  
  public boolean onBackPressed()
  {
    LogUtil.e("Cruise", "onBackPressed");
    if ((this.mCruiseMapView != null) && (this.mCruiseMapView.onBackPressed()))
    {
      showQuitDialog();
      return true;
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
      return;
    }
    CruiseCacheStatus.sOrientation = 2;
    LogUtil.e("Cruise", "onConfigurationChanged: portrait " + false);
    if (this.mCruiseMapView != null)
    {
      if (this.mCruiseMapView.isPortrait()) {
        break label97;
      }
      this.mCruiseMapView.onConfigurationChanged();
    }
    for (;;)
    {
      CruiseMapController.getInstance().onUpdateOrientation(false);
      if (!this.mDialogManager.isNewerGuideDialogShowing()) {
        break;
      }
      this.mDialogManager.showNewerGuideDialog(false);
      return;
      label97:
      this.mParentView.removeView(this.mCruiseMapView.getRootView());
      this.mCruiseMapView = new CruiseMapView(this.mActivity, this.mParentView, false);
      setupListener();
      this.mCruiseMapView.onUpdateStyle(BNStyleManager.getDayStyle());
      CruiseMapController.getInstance().setCruiseMapView(this.mCruiseMapView);
    }
  }
  
  public void onCurrentRoadNameUpdate(Message paramMessage)
  {
    LogUtil.e("Cruise", "onCurrentRoadNameUpdate");
    paramMessage = getMsgData(paramMessage);
    if ((paramMessage != null) && (this.mCruiseMapView != null))
    {
      paramMessage = paramMessage.getString("road_name");
      this.mCruiseMapView.setCurrentRoadName(paramMessage);
    }
  }
  
  public void onPause()
  {
    BNMapController.getInstance().onPause();
  }
  
  public void onResume()
  {
    checkCurrentProvinceDataDownloaded();
    boolean bool = checkDataDownload();
    if ((BNExtGPSLocationManager.getInstance().isGpsEnabled()) && (BNExtGPSLocationManager.getInstance().isGpsAvailable()))
    {
      this.mGPSOpened = true;
      this.mGPSAvailable = true;
      if (this.mGPSOpened) {
        break label239;
      }
      if (this.mCruiseMapView != null) {
        this.mCruiseMapView.setViewWhenNoGPS();
      }
      if ((!bool) && (this.mDialogManager != null)) {
        this.mDialogManager.showGPSSettingDialog();
      }
    }
    for (;;)
    {
      if (this.mHandler == null) {
        createHandler();
      }
      BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("onResume-" + getClass().getSimpleName(), null)new BNWorkerConfig
      {
        protected String execute()
        {
          if (BCruiser.this.mDialogManager != null) {
            BCruiser.this.mDialogManager.popDialogAndShow();
          }
          return null;
        }
      }, new BNWorkerConfig(8, 0));
      BNMapController.getInstance().onResume();
      BNMapController.getInstance().setDrawHouse(false);
      if (this.mCruiseMapView != null) {
        this.mCruiseMapView.onResume();
      }
      CruiseMapController.getInstance().initMapStatus();
      bool = BNSettingManager.isRoadCondOnOrOff();
      BNMapController.getInstance().showTrafficMap(bool);
      try
      {
        if (this.mContext != null)
        {
          Configuration localConfiguration = this.mContext.getResources().getConfiguration();
          if (2 != CruiseCacheStatus.sOrientation) {
            onConfigurationChanged(localConfiguration);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        LogUtil.e("Cruise", "onResume e: " + localException.getMessage());
      }
      this.mGPSOpened = BNSysLocationManager.getInstance().isGpsEnabled();
      this.mGPSAvailable = BNSysLocationManager.getInstance().isGpsAvailable();
      break;
      label239:
      if (this.mDialogManager != null) {
        this.mDialogManager.dismissGPSSettingDialog();
      }
      if ((!this.mGPSAvailable) && (this.mCruiseMapView != null)) {
        this.mCruiseMapView.setViewWhenNotLocated();
      }
    }
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.onUpdateStyle(paramBoolean);
    }
  }
  
  public void quitCruise()
  {
    LogUtil.e("ImportantCruiseBug", "quitCruise map onResume");
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.removeLocModeRunnable();
    }
    stopRouteCruise();
    CruiseMapController.getInstance().restoreMapView();
    BNMapController.getInstance().sendCommandToMapEngine(3, null);
    NetworkListener.unRegisterMessageHandler(this.mHandler);
    BNSysLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
    BNSysLocationManager.getInstance().stopNaviLocate();
    BNExtGPSLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
    restoreRGSetting();
    restoreScreenAlwaysOn();
    if (this.mBCruiserListener != null) {
      this.mBCruiserListener.notifyQuitCruiser();
    }
    if (this.mBCruiserListeners != null)
    {
      int i = 0;
      while (i < this.mBCruiserListeners.size())
      {
        ((OnCruiseBeginListener)this.mBCruiserListeners.get(i)).onCruiseBegin(false);
        i += 1;
      }
    }
    BNPowerSaver.getInstance().uninit();
    VMsgDispatcher.unregisterMsgHandler(this.mMsgHandler);
    CruiseUIModel.getInstance().reset();
    if (BNOfflineDataManager.getInstance().getNeedReload())
    {
      BNaviEngineManager.getInstance().reload();
      BNOfflineDataManager.getInstance().resetNeedReload();
    }
    CruiseMapController.getInstance().setCruiseMapView(null);
    this.mIsCruiseBegin = false;
    TTSPlayerControl.setNaviMuteState(false);
  }
  
  public void reInitLocationService()
  {
    if ((BNExtGPSLocationManager.getInstance().isGpsEnabled()) && (BNExtGPSLocationManager.getInstance().isGpsAvailable()))
    {
      BNSysLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
      BNExtGPSLocationManager.getInstance().addLocationListener(this.mCruiseLocationListener);
      return;
    }
    BNExtGPSLocationManager.getInstance().removeLocationListener(this.mCruiseLocationListener);
    BNSysLocationManager.getInstance().startNaviLocate(this.mContext);
    BNSysLocationManager.getInstance().addLocationListener(this.mCruiseLocationListener);
  }
  
  public void removeOnCruiseBeginListener(OnCruiseBeginListener paramOnCruiseBeginListener)
  {
    this.mBCruiserListeners.remove(paramOnCruiseBeginListener);
  }
  
  public void removeRGInfoListeners(OnRGInfoListener paramOnRGInfoListener)
  {
    if ((paramOnRGInfoListener != null) && (this.mRGInfoListeners.contains(paramOnRGInfoListener))) {
      this.mRGInfoListeners.remove(paramOnRGInfoListener);
    }
  }
  
  public void setBatteryStatus(int paramInt, boolean paramBoolean)
  {
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.setBatteryStatus(paramInt, paramBoolean);
    }
  }
  
  public void setCruiseDialogManagerInterface(CruiseDialogManager.CruiseDialogManagerInterface paramCruiseDialogManagerInterface)
  {
    this.mCruiseDialogManagerInterface = paramCruiseDialogManagerInterface;
  }
  
  public void setListener(IBCruiserListener paramIBCruiserListener)
  {
    this.mBCruiserListener = paramIBCruiserListener;
  }
  
  public void setOnControlPanelClickListener(CruiseMapControlPanel.ControlPanelClickListener paramControlPanelClickListener)
  {
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.setOnControlPanelClickListener(paramControlPanelClickListener);
    }
  }
  
  public void setShowMenuFlagOnResume(boolean paramBoolean)
  {
    this.mIsNeedShowSettingsMenu = paramBoolean;
  }
  
  public void showQuitDialog()
  {
    this.mDialogManager.showQuitDialog(new BNDialog.OnNaviClickListener()
    {
      public void onClick()
      {
        BCruiser.this.notifyCruiseFragmentQuitCruise();
      }
    });
  }
  
  public void startCruise() {}
  
  public void updateInitLocation(int paramInt1, int paramInt2)
  {
    LogUtil.e("Cruise", "updateInitLocation: " + paramInt1 + ", " + paramInt2);
    CruiseCacheStatus.sInitLongitudeMC = paramInt1;
    CruiseCacheStatus.sInitLatitudeMC = paramInt2;
    Object localObject = CoordinateTransformUtil.MC2LL(paramInt1, paramInt2);
    LocData localLocData = new LocData();
    localLocData.longitude = ((Bundle)localObject).getDouble("LLx");
    localLocData.latitude = ((Bundle)localObject).getDouble("LLy");
    localObject = new LocData();
    if (localLocData != null)
    {
      Bundle localBundle = CoordinateTransformUtil.transferGCJ02ToWGS84(localLocData.longitude, localLocData.latitude);
      ((LocData)localObject).longitude = localBundle.getDouble("LLx");
      ((LocData)localObject).latitude = localBundle.getDouble("LLy");
    }
    updateLocation((LocData)localObject, localLocData);
  }
  
  public void updateItsBtn()
  {
    if (this.mCruiseMapView != null) {
      this.mCruiseMapView.updateItsBtn();
    }
  }
  
  public void updateLocation(LocData paramLocData1, LocData paramLocData2)
  {
    if ((paramLocData2 == null) || (!paramLocData2.isValid()) || (paramLocData1 == null) || (!paramLocData1.isValid())) {}
    int j;
    do
    {
      return;
      LocationCallback.setData(paramLocData2.toLocationOverlayJsonString(PreferenceHelper.getInstance(this.mContext).getBoolean("SP_Last_Cruise_Map_Status", true)));
      BNRouteGuider.getInstance().triggerGPSDataChange((int)(paramLocData1.longitude * 100000.0D), (int)(paramLocData1.latitude * 100000.0D), paramLocData1.speed, paramLocData1.direction, paramLocData1.accuracy, (float)paramLocData1.altitude, paramLocData1.satellitesNum, paramLocData1.locType);
      paramLocData1 = new Bundle();
      BNRouteGuider.getInstance().getVehicleInfo(paramLocData1);
      float f = (float)paramLocData1.getDouble("vehicle_angle");
      int i = paramLocData1.getInt("vehicle_angle_add_dist");
      j = (int)(paramLocData2.speed * 3.6F);
      new BigDecimal(i / 1000.0F).setScale(1, 4).floatValue();
      LogUtil.e("Cruise", "updateLocation: speed " + j + ", angle " + f + ", " + paramLocData2);
    } while (this.mCruiseMapView == null);
    this.mCruiseMapView.updateCurrentSpeed(j);
  }
  
  public static abstract interface OnCruiseBeginListener
  {
    public abstract void onCruiseBegin(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/cruise/BCruiser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */