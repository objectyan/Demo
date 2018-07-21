package com.baidu.navi.controller;

import android.content.Context;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class SearchStrategyHelper
{
  public static final String FIRST_ONLINE_SEARCH = "first_online_search";
  public static final String FIRST_RESULT_ONLINE_SEARCH = "first_result_online_search";
  private static volatile SearchStrategyHelper mInstance;
  private boolean isNeedReloadSearchEngine = false;
  private DistrictInfo mCenterDistrict = new DistrictInfo();
  private Context mContext;
  
  public SearchStrategyHelper(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static SearchStrategyHelper getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new SearchStrategyHelper(paramContext);
      }
      return mInstance;
    }
    finally {}
  }
  
  public boolean checkCanSearchByNetMode(int paramInt)
  {
    if (paramInt == 0) {}
    while (NetworkUtils.isNetworkAvailable(this.mContext)) {
      return true;
    }
    TipTool.onCreateToastDialog(this.mContext, 2131298924);
    return false;
  }
  
  public boolean checkCanSearchBySet()
  {
    if (getNetModeBySet() == 0) {}
    while (NetworkUtils.isNetworkAvailable(this.mContext)) {
      return true;
    }
    TipTool.onCreateToastDialog(this.mContext, 2131298924);
    return false;
  }
  
  public int getCurrentDistrictId()
  {
    if (this.mCenterDistrict == null) {
      return -1;
    }
    return this.mCenterDistrict.mId;
  }
  
  public int getNetModeByPoint(GeoPoint paramGeoPoint)
  {
    if (hasDataDownloadedByPoint(paramGeoPoint)) {
      return 0;
    }
    return 1;
  }
  
  public int getNetModeBySet()
  {
    if (hasDataDownloadedBySet()) {
      return 0;
    }
    return 1;
  }
  
  public int getNetModeBySet(DistrictInfo paramDistrictInfo)
  {
    if (paramDistrictInfo == null) {
      return getNetModeBySet();
    }
    if (hasDataDownloadedByDistrictInfo(paramDistrictInfo)) {
      return 0;
    }
    return 1;
  }
  
  public int getPoiMaxCountByNetMode(int paramInt)
  {
    if (paramInt == 0) {
      return 100;
    }
    return 20;
  }
  
  public boolean hasDataDownloadedByDistrictInfo(DistrictInfo paramDistrictInfo)
  {
    if (paramDistrictInfo == null) {
      return false;
    }
    if (paramDistrictInfo.mType == 2) {}
    for (int i = paramDistrictInfo.mId;; i = this.mCenterDistrict.mId)
    {
      return BNOfflineDataManager.getInstance().isProvinceDataDownload(i);
      this.mCenterDistrict = BNPoiSearcher.getInstance().getParentDistrict(paramDistrictInfo.mId);
      if (this.mCenterDistrict == null) {
        break;
      }
    }
  }
  
  public boolean hasDataDownloadedByPoint(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {}
    do
    {
      do
      {
        return false;
      } while (!BNOfflineDataManager.getInstance().isProvinceDataDownload(0));
      this.mCenterDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(paramGeoPoint, 0);
    } while (this.mCenterDistrict == null);
    if (this.mCenterDistrict.mType == 2) {}
    for (int i = this.mCenterDistrict.mId;; i = this.mCenterDistrict.mId)
    {
      return BNOfflineDataManager.getInstance().isProvinceDataDownload(i);
      this.mCenterDistrict = BNPoiSearcher.getInstance().getParentDistrict(this.mCenterDistrict.mId);
    }
  }
  
  public boolean hasDataDownloadedBySet()
  {
    int i = 0;
    this.mCenterDistrict = GeoLocateModel.getInstance().getCurrentDistrict();
    if (this.mCenterDistrict == null) {
      return false;
    }
    if (this.mCenterDistrict.mType == 2) {
      i = this.mCenterDistrict.mId;
    }
    for (;;)
    {
      return BNOfflineDataManager.getInstance().isProvinceDataDownload(i);
      this.mCenterDistrict = BNPoiSearcher.getInstance().getParentDistrict(this.mCenterDistrict.mId);
      if (this.mCenterDistrict != null) {
        i = this.mCenterDistrict.mId;
      }
    }
  }
  
  public boolean isFirstOnlineSearch(int paramInt)
  {
    return false;
  }
  
  public boolean isFirstResultOnlineSearch(int paramInt)
  {
    return false;
  }
  
  public void reloadSearchEngine()
  {
    if (this.isNeedReloadSearchEngine)
    {
      BNaviEngineManager.getInstance().reloadSubSystem(2);
      this.isNeedReloadSearchEngine = false;
    }
  }
  
  public void setIsNeedReloadSearchEngine(boolean paramBoolean)
  {
    this.isNeedReloadSearchEngine = paramBoolean;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/SearchStrategyHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */