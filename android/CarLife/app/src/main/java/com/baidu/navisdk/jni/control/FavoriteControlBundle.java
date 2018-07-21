package com.baidu.navisdk.jni.control;

import android.os.Bundle;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.jni.nativeif.JNIFavoriteControlNew;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.nplatform.comapi.basestruct.Point;
import java.util.ArrayList;

public class FavoriteControlBundle
{
  private static final int FAV_POI_SYNC_FALSE = 0;
  private static final int FAV_POI_SYNC_TRUE = 1;
  private static final int JNI_FAILED = -1;
  private static final int JNI_SUCCESS = 0;
  private static final String KEY_ADDR = "addr";
  private static final String KEY_ALIAS = "alias";
  private static final String KEY_CITY_ID = "cityID";
  private static final String KEY_DESC = "desc";
  private static final String KEY_FAV_ADD_TIME = "addtime";
  private static final String KEY_GUIDEPOINT_LATITUDE = "guide_lat";
  private static final String KEY_GUIDEPOINT_LONGITUDE = "guide_lon";
  private static final String KEY_ID = "poiId";
  private static final String KEY_IS_SYNC = "isSync";
  private static final String KEY_NAME = "name";
  private static final String KEY_POI_KEY = "poiKey";
  private static final String KEY_TELS = "tels";
  private static final String KEY_TYPE = "type";
  private static final String KEY_VIEWPOINT_LATITUDE = "view_lat";
  private static final String KEY_VIEWPOINT_LONGITUDE = "view_lon";
  private JNIFavoriteControlNew mJNIFavoriteControl = new JNIFavoriteControlNew();
  
  private Bundle construct(FavoritePoiInfo paramFavoritePoiInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("poiKey", paramFavoritePoiInfo.mFavKey);
    localBundle.putString("poiId", paramFavoritePoiInfo.mPoiId);
    localBundle.putInt("type", paramFavoritePoiInfo.mPoiType);
    localBundle.putInt("view_lon", paramFavoritePoiInfo.mViewPoint.x);
    localBundle.putInt("view_lat", paramFavoritePoiInfo.mViewPoint.y);
    localBundle.putString("name", paramFavoritePoiInfo.mFavName);
    localBundle.putString("alias", paramFavoritePoiInfo.mFavAlias);
    localBundle.putString("desc", paramFavoritePoiInfo.mPoiDesc);
    localBundle.putString("addr", paramFavoritePoiInfo.mFavAddr);
    localBundle.putString("tels", paramFavoritePoiInfo.mPhone);
    localBundle.putInt("cityID", paramFavoritePoiInfo.mFavCityId);
    if (paramFavoritePoiInfo.mFavHasSync)
    {
      localBundle.putInt("isSync", 1);
      return localBundle;
    }
    localBundle.putInt("isSync", 0);
    return localBundle;
  }
  
  private FavoritePoiInfo deconstruct(Bundle paramBundle)
  {
    FavoritePoiInfo localFavoritePoiInfo = new FavoritePoiInfo();
    localFavoritePoiInfo.mPoiId = paramBundle.getString("poiId");
    localFavoritePoiInfo.mPoiType = paramBundle.getInt("type");
    localFavoritePoiInfo.mFavKey = paramBundle.getString("poiKey");
    localFavoritePoiInfo.mFavName = paramBundle.getString("name");
    localFavoritePoiInfo.mFavAddr = paramBundle.getString("addr");
    localFavoritePoiInfo.mFavAlias = paramBundle.getString("alias");
    localFavoritePoiInfo.mFavAddTime = String.valueOf(paramBundle.getLong("addtime"));
    localFavoritePoiInfo.mFavHasSync = paramBundle.getBoolean("isSync");
    localFavoritePoiInfo.mFavCityId = paramBundle.getInt("cityID");
    DistrictInfo localDistrictInfo = BNPoiSearcher.getInstance().getDistrictById(localFavoritePoiInfo.mFavCityId);
    if (localDistrictInfo != null) {
      localFavoritePoiInfo.mFavCityName = localDistrictInfo.mName;
    }
    localFavoritePoiInfo.mPhone = paramBundle.getString("tels");
    paramBundle = paramBundle.getBundle("stViewPoint");
    localFavoritePoiInfo.mViewPoint.setmPtx(paramBundle.getInt("lon"));
    localFavoritePoiInfo.mViewPoint.setmPty(paramBundle.getInt("lat"));
    return localFavoritePoiInfo;
  }
  
  public static FavoriteControlBundle getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private ArrayList<FavoritePoiInfo> parseBundleToFavPoiInfoList(ArrayList<Bundle> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(deconstruct((Bundle)paramArrayList.get(i)));
        i += 1;
      }
    }
  }
  
  public int addPOI(FavoritePoiInfo paramFavoritePoiInfo)
  {
    if (getPOICnt() >= 500) {
      return -2;
    }
    Bundle localBundle1 = construct(paramFavoritePoiInfo);
    Bundle localBundle2 = new Bundle();
    if (this.mJNIFavoriteControl.addFavoritePOI(localBundle1, localBundle2) == 0)
    {
      paramFavoritePoiInfo.setValue(deconstruct(localBundle2));
      return 1;
    }
    return 0;
  }
  
  public boolean cancelSyncFavoritePOI()
  {
    return this.mJNIFavoriteControl.cancelSyncFavoritePOI() == 0;
  }
  
  public boolean clearAllFavPois()
  {
    return this.mJNIFavoriteControl.clearAllFavoritePOI() == 0;
  }
  
  public void createFavSubSystem()
  {
    this.mJNIFavoriteControl.createFavSubSystem();
  }
  
  public ArrayList<FavoritePoiInfo> getAllFavPoisFromEngineCache(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mJNIFavoriteControl.getAllFavoritePOIS(paramInt, localArrayList) == 0) {
      return parseBundleToFavPoiInfoList(localArrayList);
    }
    return new ArrayList();
  }
  
  public FavoritePoiInfo getFavPoiInfoByKey(String paramString)
  {
    FavoritePoiInfo localFavoritePoiInfo = null;
    Bundle localBundle = new Bundle();
    if (this.mJNIFavoriteControl.getFavoritePOIByKey(paramString, localBundle) == 0) {
      localFavoritePoiInfo = deconstruct(localBundle);
    }
    return localFavoritePoiInfo;
  }
  
  public FavoritePoiInfo getFavPoiInfoByPoint(Point paramPoint)
  {
    Object localObject = null;
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    localBundle1.putInt("view_lon", paramPoint.x);
    localBundle1.putInt("view_lat", paramPoint.y);
    paramPoint = (Point)localObject;
    if (this.mJNIFavoriteControl.getFavoritePOIByPoint(localBundle1, localBundle2) == 0) {
      paramPoint = deconstruct(localBundle2);
    }
    return paramPoint;
  }
  
  public String getFavPoiKeyByPoint(Point paramPoint)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("view_lon", paramPoint.x);
    localBundle1.putInt("view_lat", paramPoint.y);
    Bundle localBundle2 = new Bundle();
    paramPoint = "";
    if (this.mJNIFavoriteControl.getFavPoiKeyByPoint(localBundle1, localBundle2) == 0) {
      paramPoint = localBundle2.getString("poiKey");
    }
    return paramPoint;
  }
  
  public int getPOICnt()
  {
    Bundle localBundle = new Bundle();
    if (this.mJNIFavoriteControl.getFavoritePoiCnt(localBundle) != 0) {
      return 0;
    }
    return localBundle.getInt("count", 0);
  }
  
  public void loadAllFavPoisFromEngineDB()
  {
    this.mJNIFavoriteControl.loadAllFavoritePOISFromDB();
  }
  
  public int removePOI(String paramString)
  {
    return this.mJNIFavoriteControl.removeFavoritePOI(paramString);
  }
  
  public void startSyncFavoritePoi()
  {
    this.mJNIFavoriteControl.startSyncFavoritePOI();
  }
  
  public int updatePOI(FavoritePoiInfo paramFavoritePoiInfo)
  {
    paramFavoritePoiInfo = construct(paramFavoritePoiInfo);
    if (this.mJNIFavoriteControl.updateFavoritePOI(paramFavoritePoiInfo) == 0) {
      return 1;
    }
    return 0;
  }
  
  private static class LazyHolder
  {
    private static FavoriteControlBundle sInstance = new FavoriteControlBundle(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/control/FavoriteControlBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */