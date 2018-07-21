package com.baidu.baidunavis.control;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.model.NavRoutePlanModel;
import com.baidu.baidunavis.model.RouteNode;
import com.baidu.baidunavis.model.TrajectoryGPSData;
import com.baidu.baidunavis.model.TrajectorySummaryInfo;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.geolocate.ILocationChangeListener;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectory;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectoryGPSData;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;

public class NavTrajectoryController
{
  private static final int CAR_DISTANCE_MIN_LIMIT = 200;
  public static final int CRUISE = 2;
  public static final int CRUISE_FOLLOW = 3;
  private static final String DefaultTrackName = "未知路";
  public static final int END_RECORD_FAIL = 1;
  public static final int END_RECORD_INVALID = -1;
  public static final int END_RECORD_SUC = 0;
  public static final int ROUTE_GUIDE = 1;
  private static final int SEARCH_POI_TIMEOUT = 120000;
  private static final String TAG = NavTrajectoryController.class.getSimpleName();
  public static boolean hasConnected = false;
  private static NavTrajectoryController mInstance = null;
  private boolean isEndNaviByOpenAPI = false;
  private LocationChangeListener mCarNaviLocChangeListener = null;
  protected HashMap<Handler, String> mEndGeoTrackId = new HashMap();
  private GeoPoint mFinalGeoPoint = null;
  private GeoPoint mFirstGeoPoint = null;
  private boolean mIsNeedRecordTrack = true;
  private boolean mIsStartRecord = false;
  public int mLastestRequestID = 0;
  private ILocationChangeListener mLocChangeListener = null;
  private boolean mNotInputStartEndGeo = false;
  protected HashMap<Handler, String> mStartGeoTrackId = new HashMap();
  private boolean shouldShowNaviResult = false;
  private String trackKeyUrl = null;
  
  private void checkShouldDisplayNaviResultPage(int paramInt)
  {
    if (paramInt != 0)
    {
      this.shouldShowNaviResult = false;
      return;
    }
    if (BNNaviResultModel.getInstance().isDestArrived())
    {
      this.shouldShowNaviResult = true;
      BNNaviResultModel.getInstance().setNaviCompletePercentage(1.0F);
      return;
    }
    String str = JNITrajectoryControl.sInstance.getCurrentUUID();
    long l = JNITrajectoryControl.sInstance.getTrajectoryLength(str);
    paramInt = BNNaviResultModel.getInstance().getEstimatedRemainDist();
    if (paramInt == 0) {}
    for (double d = 0.0D;; d = l / paramInt)
    {
      NavLogUtils.e(TAG, "checkShouldDisplayNaviResultPage: --> curMilea: " + l + ", planedDist: " + paramInt + ", percentage: " + d);
      BNNaviResultModel.getInstance().setNaviCompletePercentage((float)d);
      if (l <= 10000L) {
        break;
      }
      return;
    }
  }
  
  private TrajectoryGPSData convertTo(NaviTrajectoryGPSData paramNaviTrajectoryGPSData)
  {
    if (paramNaviTrajectoryGPSData == null) {
      return null;
    }
    TrajectoryGPSData localTrajectoryGPSData = new TrajectoryGPSData();
    localTrajectoryGPSData.mLongitude = paramNaviTrajectoryGPSData.mLongitude;
    localTrajectoryGPSData.mLatitude = paramNaviTrajectoryGPSData.mLatitude;
    localTrajectoryGPSData.mSpeed = paramNaviTrajectoryGPSData.mSpeed;
    localTrajectoryGPSData.mBearing = paramNaviTrajectoryGPSData.mBearing;
    localTrajectoryGPSData.mAccuracy = paramNaviTrajectoryGPSData.mAccuracy;
    localTrajectoryGPSData.mGpsTime = paramNaviTrajectoryGPSData.mGpsTime;
    localTrajectoryGPSData.unLimitSpeed = paramNaviTrajectoryGPSData.unLimitSpeed;
    localTrajectoryGPSData.fMaxSpeed = paramNaviTrajectoryGPSData.fMaxSpeed;
    localTrajectoryGPSData.bMaxSpeed = paramNaviTrajectoryGPSData.bMaxSpeed;
    localTrajectoryGPSData.bOverSpeed = paramNaviTrajectoryGPSData.bOverSpeed;
    localTrajectoryGPSData.bRapidAcc = paramNaviTrajectoryGPSData.bRapidAcc;
    localTrajectoryGPSData.bBrake = paramNaviTrajectoryGPSData.bBrake;
    localTrajectoryGPSData.bCurve = paramNaviTrajectoryGPSData.bCurve;
    localTrajectoryGPSData.bYaw = paramNaviTrajectoryGPSData.bYaw;
    LogUtil.e("onShowMenu", " NaviTrajectory22 ntd.mGpsTime " + paramNaviTrajectoryGPSData.mGpsTime + " ntd.unLimitSpeed " + paramNaviTrajectoryGPSData.unLimitSpeed + " ntd.fMaxSpeed " + paramNaviTrajectoryGPSData.fMaxSpeed + " ntd.bMaxSpeed " + paramNaviTrajectoryGPSData.bMaxSpeed + " ntd.bOverSpeed " + paramNaviTrajectoryGPSData.bOverSpeed + " ntd.bRapidAcc " + paramNaviTrajectoryGPSData.bRapidAcc + " ntd.bBrake " + paramNaviTrajectoryGPSData.bBrake + " ntd.bCurve " + paramNaviTrajectoryGPSData.bCurve + " ntd.mLongitude " + paramNaviTrajectoryGPSData.mLongitude + " ntd.mLatitude " + paramNaviTrajectoryGPSData.mLatitude + " ntd.mSpeed " + paramNaviTrajectoryGPSData.mSpeed + " ntd.mBearing " + paramNaviTrajectoryGPSData.mBearing + " ntd.mAccuracy " + paramNaviTrajectoryGPSData.mAccuracy);
    return localTrajectoryGPSData;
  }
  
  private TrajectorySummaryInfo convertTo(NaviTrajectory paramNaviTrajectory)
  {
    if (paramNaviTrajectory == null) {
      return null;
    }
    TrajectorySummaryInfo localTrajectorySummaryInfo = new TrajectorySummaryInfo();
    localTrajectorySummaryInfo.mUUID = paramNaviTrajectory.mUUID;
    localTrajectorySummaryInfo.mName = paramNaviTrajectory.mName;
    localTrajectorySummaryInfo.mHasSync = paramNaviTrajectory.mHasSync;
    localTrajectorySummaryInfo.mDistance = paramNaviTrajectory.mDistance;
    localTrajectorySummaryInfo.mDate = paramNaviTrajectory.mDate;
    localTrajectorySummaryInfo.mDuration = paramNaviTrajectory.mDuration;
    localTrajectorySummaryInfo.mAverageSpeed = paramNaviTrajectory.mAverageSpeed;
    localTrajectorySummaryInfo.mMaxSpeed = paramNaviTrajectory.mMaxSpeed;
    localTrajectorySummaryInfo.mFromType = paramNaviTrajectory.mFromType;
    localTrajectorySummaryInfo.mHasGpsMock = RGCacheStatus.sMockGpsGuide;
    localTrajectorySummaryInfo.unMileageDist = paramNaviTrajectory.unMileageDist;
    localTrajectorySummaryInfo.ulCreateTime = paramNaviTrajectory.ulCreateTime;
    localTrajectorySummaryInfo.bIsChangedKey = paramNaviTrajectory.bIsChangedKey;
    localTrajectorySummaryInfo.nKeyVersion = paramNaviTrajectory.nKeyVersion;
    localTrajectorySummaryInfo.clTrackID = paramNaviTrajectory.clTrackID;
    localTrajectorySummaryInfo.clCUID = paramNaviTrajectory.clCUID;
    localTrajectorySummaryInfo.clSessionID = paramNaviTrajectory.clSessionID;
    localTrajectorySummaryInfo.clBduss = paramNaviTrajectory.clBduss;
    localTrajectorySummaryInfo.clPoiID = paramNaviTrajectory.clPoiID;
    localTrajectorySummaryInfo.clDataSign = paramNaviTrajectory.clDataSign;
    localTrajectorySummaryInfo.clSessionSign = paramNaviTrajectory.clSessionSign;
    localTrajectorySummaryInfo.clUrl = paramNaviTrajectory.clUrl;
    localTrajectorySummaryInfo.mLastestRequestID = getInstance().mLastestRequestID;
    Object localObject = NavRoutePlanModel.getInstance().getEndRouteNode();
    if (localObject != null) {
      localTrajectorySummaryInfo.mBusinessPoi = ((RouteNode)localObject).mBusinessPoi;
    }
    RoutePlanNode localRoutePlanNode = NavCommonFuncModel.getInstance().mEndNode;
    if (localRoutePlanNode != null)
    {
      localObject = localRoutePlanNode;
      if (!localRoutePlanNode.isNodeSettedData()) {
        localObject = BNSettingManager.getEndNode();
      }
      localTrajectorySummaryInfo.clEndLatitude = String.valueOf(((RoutePlanNode)localObject).getLatitudeE6());
      localTrajectorySummaryInfo.clEndLongtitude = String.valueOf(((RoutePlanNode)localObject).getLongitudeE6());
      localTrajectorySummaryInfo.clEndName = ((RoutePlanNode)localObject).mName;
      NavLogUtils.e("tag", "walk lat ,long " + localTrajectorySummaryInfo.clEndLatitude + "," + localTrajectorySummaryInfo.clEndLongtitude);
    }
    LogUtil.e("onShowMenu", " NaviTrajectory11 ntd.unMileageDist " + paramNaviTrajectory.unMileageDist + " ntd.ulCreateTime " + paramNaviTrajectory.ulCreateTime + " ntd.bIsChangedKey " + paramNaviTrajectory.bIsChangedKey + " ntd.nKeyVersion " + paramNaviTrajectory.nKeyVersion + " ntd.clTrackID " + paramNaviTrajectory.clTrackID + " ntd.clCUID " + paramNaviTrajectory.clCUID + " ntd.clSessionID " + paramNaviTrajectory.clSessionID + " ntd.clBduss " + paramNaviTrajectory.clBduss + " ntd.clPoiID " + paramNaviTrajectory.clPoiID + " ntd.clDataSign " + paramNaviTrajectory.clDataSign + " ntd.clSessionSign " + paramNaviTrajectory.clSessionSign + " ntd.clUrl " + paramNaviTrajectory.clUrl + " ret.mBusinessPoi " + localTrajectorySummaryInfo.mBusinessPoi);
    return localTrajectorySummaryInfo;
  }
  
  public static NavTrajectoryController getInstance()
  {
    if (mInstance == null) {
      mInstance = new NavTrajectoryController();
    }
    return mInstance;
  }
  
  private void onEndRecord(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {}
    for (;;)
    {
      return;
      try
      {
        paramInt1 = (int)getCurrentTrajectorySummaryInfo().mDistance;
        if (paramInt1 <= 0) {
          continue;
        }
        if (paramInt2 == 1)
        {
          StatisticManager.onEvent("NAVI_0016", "NAVI_0016");
          StatisticManager.onEventMileage(com.baidu.carlife.core.a.a(), "NAVI_0013", "导航使用距离", paramInt1);
          if (!hasConnected) {
            StatisticManager.onEventMileage(com.baidu.carlife.core.a.a(), "NAVI_0030", "导航使用距离", paramInt1);
          }
          if (paramInt1 >= 1800000) {
            StatisticManager.onEvent("NAVI_0014", "NAVI_0014");
          }
        }
        while (paramInt1 > 200)
        {
          NavMapAdapter.getInstance().createCarNaviData();
          return;
          if (paramInt2 == 3)
          {
            StatisticManager.onEventMileage(com.baidu.carlife.core.a.a(), "NAVI_0009", "巡航模式使用距离", paramInt1);
            if (paramInt1 >= 1800000) {
              StatisticManager.onEvent("NAVI_0010", "NAVI_0010");
            }
          }
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private void setTrackKeyUrl(NaviTrajectory paramNaviTrajectory)
  {
    LogUtil.e("onShowMenu", " NaviTrajectory44 trackKeyUrl " + this.trackKeyUrl);
    if (paramNaviTrajectory == null) {
      return;
    }
    LogUtil.e("onShowMenu", " NaviTrajectory55 nt.clPoiID " + paramNaviTrajectory.clPoiID);
    if (paramNaviTrajectory.clPoiID != null) {
      this.trackKeyUrl = paramNaviTrajectory.clUrl;
    }
    LogUtil.e("onShowMenu", " NaviTrajectory33 trackKeyUrl " + this.trackKeyUrl);
  }
  
  private void startAntiGeo(GeoPoint paramGeoPoint, SearchHandler paramSearchHandler)
  {
    BNPoiSearcher.getInstance().asynGetPoiByPoint(paramGeoPoint, 120000, paramSearchHandler);
  }
  
  public void checkRecordEndName(GeoPoint paramGeoPoint, String paramString)
  {
    if ((paramGeoPoint == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    SearchHandler localSearchHandler = new SearchHandler(Looper.getMainLooper());
    this.mEndGeoTrackId.put(localSearchHandler, paramString);
    startAntiGeo(paramGeoPoint, localSearchHandler);
  }
  
  public void checkRecordStartName(GeoPoint paramGeoPoint, String paramString1, String paramString2)
  {
    if ((paramGeoPoint == null) || (paramString2 == null) || (paramString2.length() == 0)) {}
    while ((paramString1 != null) && (paramString1.length() != 0) && (!paramString1.equals("我的位置")) && (!paramString1.equals("地图上的点"))) {
      return;
    }
    paramString1 = new SearchHandler(Looper.getMainLooper());
    this.mStartGeoTrackId.put(paramString1, paramString2);
    startAntiGeo(paramGeoPoint, paramString1);
  }
  
  public int delete(String paramString)
  {
    return 0;
  }
  
  public int endRecord(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramInt == 1) {
      StatisticManager.onEvent("NAVI_0015", "NAVI_0015");
    }
    this.shouldShowNaviResult = false;
    if ((!isNeedRecordTrack()) || (NavMapAdapter.sMonkey) || (!this.mIsStartRecord)) {
      return 0;
    }
    this.mIsStartRecord = false;
    NavLogUtils.e("NavTrajectoryController", "endRecord----" + paramString + " trackRecordOK:" + paramBoolean);
    if (this.mLocChangeListener != null)
    {
      BNSysLocationManager.getInstance().removeLocationListener(this.mLocChangeListener);
      BNExtGPSLocationManager.getInstance().removeLocationListener(this.mLocChangeListener);
      this.mLocChangeListener = null;
    }
    RouteNode localRouteNode = NavRoutePlanModel.getInstance().getEndRouteNode();
    Object localObject2 = "";
    Object localObject1;
    if (BNRoutePlaner.getInstance().getEntry() == 20) {
      localObject1 = "1";
    }
    for (;;)
    {
      int i = -100;
      localObject2 = new Bundle();
      try
      {
        int j = JNITrajectoryControl.sInstance.endRecord(paramString, (String)localObject1, RGCacheStatus.sMockGpsGuide, (Bundle)localObject2);
        i = j;
        if ((localObject2 != null) && (((Bundle)localObject2).containsKey("trajectory_requestid"))) {
          this.mLastestRequestID = ((Bundle)localObject2).getInt("trajectory_requestid");
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          for (;;)
          {
            JNITrajectoryControl.sInstance.updateEndName(getCurrentUUID(), paramString);
            com.baidu.navi.track.TrackCarDataSolveModel.mFirstGeoPoint = this.mFirstGeoPoint;
            com.baidu.navi.track.TrackCarDataSolveModel.mFinalGeoPoint = this.mFinalGeoPoint;
            this.mFirstGeoPoint = null;
            this.mFinalGeoPoint = null;
            if ((paramBoolean) && (!NavCommonFuncModel.sIsAnologNavi))
            {
              NavLogUtils.e(TAG, "endRecord: NaviResultModel --> " + BNNaviResultModel.getInstance().toString());
              checkShouldDisplayNaviResultPage(i);
              NavLogUtils.e(TAG, "endRecord: --> ret: " + i + ", shouldShowNaviResult: " + this.shouldShowNaviResult);
            }
            this.shouldShowNaviResult = false;
            onEndRecord(i, paramInt);
            return i;
            if (BNRoutePlaner.getInstance().getEntry() == 21)
            {
              localObject1 = "2";
              break;
            }
            localObject1 = localObject2;
            if (localRouteNode == null) {
              break;
            }
            localObject1 = localObject2;
            if (localRouteNode.mUID == null) {
              break;
            }
            localObject1 = localObject2;
            if (localRouteNode.mUID.length() <= 0) {
              break;
            }
            localObject1 = localRouteNode.mUID;
            break;
            localThrowable = localThrowable;
            NavLogUtils.e(TAG, "endRecord: Exception --> ");
            continue;
            this.mLastestRequestID = 0;
          }
        }
        catch (Throwable paramString)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public ArrayList<TrajectorySummaryInfo> getAllDisplayTrajectory(String paramString1, String paramString2)
  {
    if (!isNeedRecordTrack())
    {
      paramString1 = null;
      return paramString1;
    }
    ArrayList localArrayList = new ArrayList();
    JNITrajectoryControl.sInstance.getTrajectoryList(paramString1, paramString2, localArrayList);
    paramString2 = new ArrayList();
    int i = 0;
    for (;;)
    {
      paramString1 = paramString2;
      if (localArrayList == null) {
        break;
      }
      paramString1 = paramString2;
      if (i >= localArrayList.size()) {
        break;
      }
      paramString2.add(convertTo((NaviTrajectory)localArrayList.get(i)));
      i += 1;
    }
  }
  
  public Bitmap getCarNaviBusinessImage()
  {
    NavLogUtils.e("Trajectory", "getCarNaviBusinessImage() ");
    if (BusinessActivityManager.getInstance().getModel() != null) {
      return BusinessActivityManager.getInstance().getModel().naviendPicBitmap;
    }
    return null;
  }
  
  public TrajectorySummaryInfo getCurrentTrajectorySummaryInfo()
  {
    if (!isNeedRecordTrack()) {}
    String str;
    do
    {
      return null;
      str = getCurrentUUID();
    } while ((str == null) || (str.length() == 0));
    return getTrajectoryById(getCurrentUUID());
  }
  
  public String getCurrentUUID()
  {
    if (!isNeedRecordTrack()) {
      return null;
    }
    return JNITrajectoryControl.sInstance.getCurrentUUID();
  }
  
  public ArrayList<TrajectoryGPSData> getCurrentUUIDTrajectoryGPSData()
  {
    if (!isNeedRecordTrack()) {}
    String str;
    do
    {
      return null;
      str = getCurrentUUID();
    } while ((str == null) || (str.length() == 0));
    return getTrajectoryGPSList(str);
  }
  
  public String getTrackKeyUrl()
  {
    return this.trackKeyUrl;
  }
  
  public TrajectorySummaryInfo getTrajectoryById(String paramString)
  {
    if ((!BaiduNaviManager.isNaviSoLoadSuccess()) || (!BaiduNaviManager.sIsBaseEngineInitialized)) {}
    while (!isNeedRecordTrack()) {
      return null;
    }
    NaviTrajectory localNaviTrajectory = new NaviTrajectory();
    JNITrajectoryControl.sInstance.getTrajectoryById(paramString, localNaviTrajectory);
    setTrackKeyUrl(localNaviTrajectory);
    return convertTo(localNaviTrajectory);
  }
  
  public ArrayList<TrajectoryGPSData> getTrajectoryGPSList(String paramString)
  {
    if (!isNeedRecordTrack()) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      ArrayList localArrayList2 = new ArrayList();
      JNITrajectoryControl.sInstance.GetTrajectoryGPSListDirect(paramString, localArrayList2);
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      paramString = localArrayList1;
      if (localArrayList2 != null)
      {
        paramString = localArrayList1;
        try
        {
          if (i < localArrayList2.size())
          {
            localArrayList1.add(convertTo((NaviTrajectoryGPSData)localArrayList2.get(i)));
            i += 1;
          }
        }
        catch (Throwable paramString) {}
      }
    }
    return null;
  }
  
  public boolean isNeedRecordTrack()
  {
    return this.mIsNeedRecordTrack;
  }
  
  public int logoutCleanUp()
  {
    if (!isNeedRecordTrack()) {
      return 0;
    }
    return JNITrajectoryControl.sInstance.logoutCleanUp();
  }
  
  public int patchDelete(ArrayList<String> paramArrayList)
  {
    return 0;
  }
  
  public void reInitLocationService()
  {
    if (this.mLocChangeListener == null) {
      return;
    }
    if ((com.baidu.carlife.i.a.a().b()) && (BNExtGPSLocationManager.getInstance().isGpsEnabled()) && (BNExtGPSLocationManager.getInstance().isGpsAvailable()))
    {
      BNSysLocationManager.getInstance().removeLocationListener(this.mLocChangeListener);
      BNExtGPSLocationManager.getInstance().addLocationListener(this.mLocChangeListener);
      return;
    }
    BNExtGPSLocationManager.getInstance().removeLocationListener(this.mLocChangeListener);
    BNSysLocationManager.getInstance().addLocationListener(this.mLocChangeListener);
  }
  
  public int recording(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (!isNeedRecordTrack()) {
      return 0;
    }
    return JNITrajectoryControl.sInstance.recording(paramDouble1, paramDouble2, paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public int rename(String paramString1, String paramString2)
  {
    if (!isNeedRecordTrack()) {
      return 0;
    }
    return JNITrajectoryControl.sInstance.rename(paramString1, paramString2);
  }
  
  public void setEndNaviByOpenApi(boolean paramBoolean)
  {
    this.isEndNaviByOpenAPI = paramBoolean;
  }
  
  public void setNeedRecordTrack(boolean paramBoolean)
  {
    this.mIsNeedRecordTrack = paramBoolean;
  }
  
  public int startRecord(final String paramString1, final String paramString2, final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    if ((!isNeedRecordTrack()) || (NavMapAdapter.sMonkey)) {
      return 0;
    }
    Bundle localBundle = new Bundle();
    if (paramString1 != null) {
      localBundle.putString("userId", paramString1);
    }
    if (paramString2 != null) {
      localBundle.putString("startPointName", paramString2);
    }
    localBundle.putInt("fromType", paramInt);
    localBundle.putBoolean("selfRegisterLocation", paramBoolean1);
    localBundle.putBoolean("notInputStartEndGeo", paramBoolean2);
    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask("CarNavi-StartRecordTraj", null)new BNWorkerConfig
    {
      protected String execute()
      {
        try
        {
          NavTrajectoryController localNavTrajectoryController = NavTrajectoryController.getInstance();
          String str1;
          if (paramString1 == null)
          {
            str1 = "";
            if (paramString2 != null) {
              break label54;
            }
          }
          label54:
          for (String str2 = "";; str2 = paramString2)
          {
            localNavTrajectoryController.startRecordInner(str1, str2, paramInt, paramBoolean1, paramBoolean2);
            break label63;
            str1 = paramString1;
            break;
          }
          return null;
        }
        catch (Throwable localThrowable) {}
      }
    }, new BNWorkerConfig(100, 0));
    return 1;
  }
  
  public void startRecordForNaviResult(int paramInt)
  {
    NavLogUtils.e(TAG, "startRecordForNaviResult: --> naviMode: " + paramInt);
    BNNaviResultController.getInstance().reset();
    BNNaviResultController.getInstance().registerVMsgHandler();
  }
  
  int startRecordInner(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!isNeedRecordTrack()) || (NavMapAdapter.sMonkey)) {
      return 0;
    }
    this.mIsStartRecord = true;
    NavLogUtils.e("NavTrajectoryController", "startRecord---- " + paramString2 + "," + paramInt);
    this.mNotInputStartEndGeo = paramBoolean2;
    String str = NavMapAdapter.getInstance().getNavEnergyPromoteEvent();
    paramBoolean2 = NavMapAdapter.getInstance().isCloudSwitchOn(str);
    paramInt = JNITrajectoryControl.sInstance.startRecord(paramString1, paramString2, paramInt, paramBoolean2);
    if (paramBoolean1)
    {
      if (this.mLocChangeListener == null) {
        this.mLocChangeListener = new ILocationChangeListener()
        {
          public void onLocationChange(LocData paramAnonymousLocData)
          {
            NavTrajectoryController.this.recording(paramAnonymousLocData.longitude, paramAnonymousLocData.latitude, paramAnonymousLocData.speed, paramAnonymousLocData.direction, paramAnonymousLocData.accuracy, paramAnonymousLocData.time);
            if (NavTrajectoryController.this.mNotInputStartEndGeo)
            {
              if (NavTrajectoryController.this.mFirstGeoPoint == null)
              {
                NavTrajectoryController.access$102(NavTrajectoryController.this, paramAnonymousLocData.toGeoPoint());
                NavTrajectoryController.this.checkRecordStartName(NavTrajectoryController.this.mFirstGeoPoint, null, NavTrajectoryController.this.getCurrentUUID());
                return;
              }
              NavTrajectoryController.access$202(NavTrajectoryController.this, paramAnonymousLocData.toGeoPoint());
              return;
            }
            NavTrajectoryController.access$202(NavTrajectoryController.this, paramAnonymousLocData.toGeoPoint());
          }
          
          public void onWGS84LocationChange(LocData paramAnonymousLocData1, LocData paramAnonymousLocData2) {}
        };
      }
      reInitLocationService();
    }
    NavLogUtils.e(TAG, "startRecord: ret --> " + paramInt);
    return paramInt;
  }
  
  public int updateEndName(String paramString1, String paramString2)
  {
    if (!isNeedRecordTrack()) {
      return 0;
    }
    try
    {
      int i = JNITrajectoryControl.sInstance.updateEndName(paramString1, paramString2);
      return i;
    }
    catch (Throwable paramString1) {}
    return 0;
  }
  
  public int updateStartName(String paramString1, String paramString2)
  {
    if (!isNeedRecordTrack()) {
      return 0;
    }
    return JNITrajectoryControl.sInstance.updateStartName(paramString1, paramString2);
  }
  
  class SearchHandler
    extends Handler
  {
    public SearchHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(final Message paramMessage)
    {
      label24:
      String str;
      switch (paramMessage.what)
      {
      default: 
        ;;
      case 1003: 
        if (paramMessage.arg1 == 0)
        {
          paramMessage = (SearchPoi)((RspData)paramMessage.obj).mData;
          if (paramMessage != null)
          {
            if (!NavTrajectoryController.this.mStartGeoTrackId.containsKey(this)) {
              break label172;
            }
            str = (String)NavTrajectoryController.this.mStartGeoTrackId.get(this);
            if (TextUtils.isEmpty(paramMessage.mName)) {
              paramMessage.mName = "未知路";
            }
            JNITrajectoryControl.sInstance.updateStartName(str, paramMessage.mName);
            paramMessage = paramMessage.mName;
            if ((NavLogUtils.LOGGABLE) && (NavCommonFuncModel.getInstance().getActivity() != null)) {
              NavCommonFuncModel.getInstance().getActivity().runOnUiThread(new Runnable()
              {
                public void run()
                {
                  NavTipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), "trackStartName:" + paramMessage);
                }
              });
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (NavTrajectoryController.this.mStartGeoTrackId.remove(this) != null) {
          break label24;
        }
        NavTrajectoryController.this.mEndGeoTrackId.remove(this);
        return;
        label172:
        if (!NavTrajectoryController.this.mEndGeoTrackId.containsKey(this)) {
          break;
        }
        str = (String)NavTrajectoryController.this.mEndGeoTrackId.get(this);
        if (TextUtils.isEmpty(paramMessage.mName)) {
          paramMessage.mName = "未知路";
        }
        try
        {
          JNITrajectoryControl.sInstance.updateEndName(str, paramMessage.mName);
          paramMessage = paramMessage.mName;
          if ((!NavLogUtils.LOGGABLE) || (NavCommonFuncModel.getInstance().getActivity() == null)) {
            continue;
          }
          NavCommonFuncModel.getInstance().getActivity().runOnUiThread(new Runnable()
          {
            public void run()
            {
              NavTipTool.onCreateToastDialog(NavCommonFuncModel.getInstance().getActivity(), "trackEndName:" + paramMessage);
            }
          });
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavTrajectoryController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */