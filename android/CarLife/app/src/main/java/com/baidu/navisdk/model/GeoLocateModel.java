package com.baidu.navisdk.model;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class GeoLocateModel
{
  private static final int DIS_INTERVAL_TO_REFRESH_DISTRICT = 10000;
  private static final long TIME_INTERVAL_TO_ANTI_DISTRICT_IN_FIRST = 300000L;
  private boolean hasUpdateDistrictInfo = false;
  private Handler mAntiGeoHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return;
        synchronized (GeoLocateModel.this.mIsAntiGeoing)
        {
          GeoLocateModel.access$002(GeoLocateModel.this, Boolean.valueOf(false));
          if (paramAnonymousMessage.arg1 != 0) {
            continue;
          }
          paramAnonymousMessage = (RspData)paramAnonymousMessage.obj;
          ??? = paramAnonymousMessage.mReq;
          paramAnonymousMessage = (Bundle)paramAnonymousMessage.mData;
          int i = paramAnonymousMessage.getInt("city");
          int j = paramAnonymousMessage.getInt("provice");
          paramAnonymousMessage = BNPoiSearcher.getInstance().getDistrictById(i);
          ??? = BNPoiSearcher.getInstance().getDistrictById(j);
          if (paramAnonymousMessage == null) {
            continue;
          }
          GeoLocateModel.access$102(GeoLocateModel.this, true);
          GeoLocateModel.access$202(GeoLocateModel.this, paramAnonymousMessage);
          GeoLocateModel.this.mCurrentDistrict.mName = GeoLocateModel.this.specialDealWith(GeoLocateModel.this.mCurrentDistrict.mName);
          BNSettingManager.setDistrictId(GeoLocateModel.this.mCurrentDistrict.mId);
          BNSettingManager.setDistrictName(GeoLocateModel.this.mCurrentDistrict.mName);
          GeoLocateModel.access$402(GeoLocateModel.this, (DistrictInfo)???);
          GeoLocateModel.this.notifyDistrictInfoListener(paramAnonymousMessage, (DistrictInfo)???);
          return;
        }
      }
    }
  };
  private DistrictInfo mCurLocationProvinceDistrict = null;
  private DistrictInfo mCurrentDistrict = null;
  private DistrictInfo mCurrentParentDistrict = null;
  public SearchPoi mCurrentPoi = null;
  private List<IDistrictInfoListener> mDistrictInfoListeners = new ArrayList();
  private DistrictInfo mDistrictSetByManMade;
  private Boolean mIsAntiGeoing = Boolean.FALSE;
  private long mLastAntiDistrictTime = -1L;
  public LocData mLastLocation = null;
  public long mLocationUpdatedTime = 0L;
  private LocData mUpdateLacation;
  
  public static GeoLocateModel getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private void notifyDistrictInfoListener(DistrictInfo paramDistrictInfo1, DistrictInfo paramDistrictInfo2)
  {
    int i = 0;
    while (i < this.mDistrictInfoListeners.size())
    {
      IDistrictInfoListener localIDistrictInfoListener = (IDistrictInfoListener)this.mDistrictInfoListeners.get(i);
      if (localIDistrictInfoListener != null) {
        localIDistrictInfoListener.onDistrictUpdated(paramDistrictInfo1, paramDistrictInfo2);
      }
      i += 1;
    }
    this.mDistrictInfoListeners.clear();
  }
  
  private String specialDealWith(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    if (paramString.equals("澳门特别行政区")) {
      paramString = "澳门";
    }
    for (;;)
    {
      return paramString;
      if (paramString.equals("香港特别行政区")) {
        paramString = "香港";
      } else if (paramString.equals("北京市")) {
        paramString = "北京";
      } else if (paramString.equals("重庆市")) {
        paramString = "重庆";
      } else if (paramString.equals("上海市")) {
        paramString = "上海";
      } else if (paramString.equals("天津市")) {
        paramString = "天津";
      } else if (paramString.equals("深圳市")) {
        paramString = "深圳";
      } else if (paramString.equals("广西壮族自治区")) {
        paramString = "广西";
      } else if (paramString.equals("内蒙古自治区")) {
        paramString = "内蒙古";
      } else if (paramString.equals("宁夏回族自治区")) {
        paramString = "宁夏";
      } else if (paramString.equals("青海省")) {
        paramString = "青海";
      } else if (paramString.equals("西藏自治区")) {
        paramString = "西藏";
      } else if (paramString.equals("新疆维吾尔自治区")) {
        paramString = "新疆";
      }
    }
  }
  
  public void addDistrictInfoListener(IDistrictInfoListener paramIDistrictInfoListener)
  {
    if ((paramIDistrictInfoListener != null) && (!this.mDistrictInfoListeners.contains(paramIDistrictInfoListener))) {
      this.mDistrictInfoListeners.add(paramIDistrictInfoListener);
    }
  }
  
  public boolean asyncGetCurrentDistricts()
  {
    if ((this.mLastLocation != null) && (this.mLastLocation.isValid())) {
      synchronized (this.mIsAntiGeoing)
      {
        if (this.mIsAntiGeoing.booleanValue()) {
          return false;
        }
        if (BNPoiSearcher.getInstance().asynGetDistrictByPoint(this.mLastLocation.toGeoPoint(), 10000, this.mAntiGeoHandler)) {
          this.mIsAntiGeoing = Boolean.valueOf(true);
        }
        this.mUpdateLacation = this.mLastLocation;
        return true;
      }
    }
    return true;
  }
  
  public void clearDistrictByManMade()
  {
    this.mDistrictSetByManMade = null;
  }
  
  public String getCurCityName()
  {
    String str = null;
    if (this.mDistrictSetByManMade != null) {}
    for (DistrictInfo localDistrictInfo = this.mDistrictSetByManMade;; localDistrictInfo = getCurrentDistrict())
    {
      if (localDistrictInfo != null) {
        str = specialDealWith(localDistrictInfo.mName);
      }
      return str;
    }
  }
  
  public int getCurrentCityId()
  {
    int i = Integer.MIN_VALUE;
    if (this.mCurrentDistrict != null) {
      i = this.mCurrentDistrict.mId;
    }
    return i;
  }
  
  public DistrictInfo getCurrentDistrict()
  {
    if (this.mCurrentDistrict == null)
    {
      int i = BNSettingManager.getDistrictId();
      String str = BNSettingManager.getDistrictName();
      DistrictInfo localDistrictInfo = new DistrictInfo();
      localDistrictInfo.mId = i;
      localDistrictInfo.mName = str;
      localDistrictInfo.mType = 3;
      return localDistrictInfo;
    }
    return this.mCurrentDistrict;
  }
  
  public DistrictInfo getDistrictByManMade()
  {
    return this.mDistrictSetByManMade;
  }
  
  public GeoPoint getLastGeoPoint()
  {
    if ((this.mLastLocation != null) && (this.mLastLocation.isValid()))
    {
      GeoPoint localGeoPoint = new GeoPoint();
      localGeoPoint.setLatitudeE6((int)(this.mLastLocation.latitude * 100000.0D));
      localGeoPoint.setLongitudeE6((int)(this.mLastLocation.longitude * 100000.0D));
      return localGeoPoint;
    }
    return null;
  }
  
  public LocData getLastLocation()
  {
    return this.mLastLocation;
  }
  
  public DistrictInfo getProvinceDistrict()
  {
    if (this.mCurrentDistrict == null)
    {
      DistrictInfo localDistrictInfo = new DistrictInfo();
      localDistrictInfo.mId = 19;
      localDistrictInfo.mType = 2;
      return localDistrictInfo;
    }
    return this.mCurrentParentDistrict;
  }
  
  public DistrictInfo getProvinceDistrictByPoint(GeoPoint paramGeoPoint)
  {
    Object localObject;
    if (paramGeoPoint == null) {
      localObject = null;
    }
    do
    {
      return (DistrictInfo)localObject;
      paramGeoPoint = BNPoiSearcher.getInstance().getDistrictByPoint(paramGeoPoint, 0);
      int i = 0;
      while ((paramGeoPoint != null) && (paramGeoPoint.mType > 2) && (i < 10))
      {
        paramGeoPoint = BNPoiSearcher.getInstance().getParentDistrict(paramGeoPoint.mId);
        i += 1;
      }
      if (paramGeoPoint == null) {
        break;
      }
      localObject = paramGeoPoint;
    } while (paramGeoPoint.mType == 2);
    return null;
  }
  
  public boolean hasCurLocationCityOfflineData()
  {
    Object localObject;
    if ((BNLocationManagerProxy.getInstance().isLocationValid()) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)))
    {
      localObject = BNLocationManagerProxy.getInstance().getCurLocation();
      if ((localObject != null) && ((((LocData)localObject).longitude != -1.0D) || (((LocData)localObject).latitude != -1.0D))) {
        break label54;
      }
    }
    label54:
    do
    {
      return false;
      localObject = getProvinceDistrict();
    } while ((localObject == null) || (((DistrictInfo)localObject).mType != 2));
    return BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject).mId);
  }
  
  public boolean hasUpdateDistrictInfo()
  {
    return this.hasUpdateDistrictInfo;
  }
  
  public boolean isNeareast(LocData paramLocData1, LocData paramLocData2)
  {
    double d1 = paramLocData1.longitude * 100000.0D - paramLocData2.longitude * 100000.0D;
    double d2 = paramLocData1.latitude * 100000.0D - paramLocData2.latitude * 100000.0D;
    return Math.sqrt(d1 * d1 + d2 * d2) <= 10000.0D;
  }
  
  public boolean isNeareast(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    int i = paramGeoPoint1.getLongitudeE6() - paramGeoPoint2.getLongitudeE6();
    int j = paramGeoPoint1.getLatitudeE6() - paramGeoPoint2.getLatitudeE6();
    return Math.sqrt(i * i + j * j) <= 10000.0D;
  }
  
  public void removeDistrictInfoListener(IDistrictInfoListener paramIDistrictInfoListener)
  {
    if (paramIDistrictInfoListener != null) {
      this.mDistrictInfoListeners.remove(paramIDistrictInfoListener);
    }
  }
  
  public void setDistrictByIdByManMade(int paramInt)
  {
    this.mDistrictSetByManMade = BNPoiSearcher.getInstance().getDistrictById(paramInt);
    if (this.mDistrictSetByManMade != null)
    {
      if (this.mDistrictSetByManMade.mType == 4) {
        this.mDistrictSetByManMade = BNPoiSearcher.getInstance().getParentDistrict(this.mDistrictSetByManMade.mId);
      }
      if (this.mDistrictSetByManMade != null) {
        this.mDistrictSetByManMade.mName = specialDealWith(this.mDistrictSetByManMade.mName);
      }
    }
  }
  
  public void updateDistrict(GeoPoint paramGeoPoint, DistrictInfo paramDistrictInfo1, DistrictInfo paramDistrictInfo2)
  {
    if (isNeareast(paramGeoPoint, getLastGeoPoint()))
    {
      this.mCurrentDistrict = paramDistrictInfo1;
      this.mCurrentParentDistrict = paramDistrictInfo2;
    }
  }
  
  public void updateLocation(LocData paramLocData)
  {
    if (paramLocData != null) {}
    do
    {
      do
      {
        try
        {
          this.mLastLocation = paramLocData;
          this.mLocationUpdatedTime = System.currentTimeMillis();
          if (BNavigator.getInstance().isNaviBegin()) {
            return;
          }
        }
        finally {}
        if (this.mCurrentDistrict != null) {
          break;
        }
      } while ((this.mLastAntiDistrictTime >= 0L) && (SystemClock.elapsedRealtime() - this.mLastAntiDistrictTime <= 300000L));
      this.mLastAntiDistrictTime = SystemClock.elapsedRealtime();
      asyncGetCurrentDistricts();
      return;
    } while ((this.mUpdateLacation == null) || (!this.mUpdateLacation.isValid()) || (this.mLastLocation == null) || (!this.mLastLocation.isValid()) || (isNeareast(this.mUpdateLacation, this.mLastLocation)));
    asyncGetCurrentDistricts();
  }
  
  public static abstract interface IDistrictInfoListener
  {
    public abstract void onDistrictUpdated(DistrictInfo paramDistrictInfo1, DistrictInfo paramDistrictInfo2);
  }
  
  private static class LazyHolder
  {
    private static GeoLocateModel sInstance = new GeoLocateModel();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/GeoLocateModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */