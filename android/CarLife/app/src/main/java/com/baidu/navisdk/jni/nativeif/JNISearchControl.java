package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class JNISearchControl
  implements JNISearchConst
{
  public static JNISearchControl sInstance = new JNISearchControl();
  
  private DistrictInfo parseDistrictBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    DistrictInfo localDistrictInfo = new DistrictInfo();
    localDistrictInfo.mType = paramBundle.getInt("Type", -1);
    localDistrictInfo.mId = paramBundle.getInt("Id", 0);
    localDistrictInfo.mCityId = paramBundle.getInt("CityId", -1);
    localDistrictInfo.mProvinceId = paramBundle.getInt("ProvinceId", -1);
    localDistrictInfo.mName = paramBundle.getString("Name");
    localDistrictInfo.mPoint = new GeoPoint(paramBundle.getInt("CenterX", Integer.MIN_VALUE), paramBundle.getInt("CenterY", Integer.MIN_VALUE));
    localDistrictInfo.mChildCount = paramBundle.getInt("ChildCount", 0);
    return localDistrictInfo;
  }
  
  public native int GetNetMode();
  
  public native int GetNetModeOfLastResult();
  
  public native int RouteSearchForMapPoiResultPB(Bundle paramBundle1, Bundle paramBundle2);
  
  public native int SetNetMode(int paramInt);
  
  public native int UpdateFavPoiCache(ArrayList<Bundle> paramArrayList, int paramInt);
  
  public native int cancelQuery();
  
  public native int clearBkgCache();
  
  public native int clearFavPoiCache();
  
  public native int clearPoiCache();
  
  public native int getChildDistrict(int paramInt, ArrayList<Bundle> paramArrayList);
  
  public int getChildDistrictAndParse(int paramInt, ArrayList<DistrictInfo> paramArrayList)
  {
    int j;
    if (paramArrayList == null)
    {
      j = -1;
      return j;
    }
    ArrayList localArrayList = new ArrayList();
    if (sInstance.getChildDistrict(paramInt, localArrayList) != 0) {
      return -3;
    }
    int k = localArrayList.size();
    paramInt = 0;
    int i = 0;
    for (;;)
    {
      j = paramInt;
      if (i >= k) {
        break;
      }
      DistrictInfo localDistrictInfo = parseDistrictBundle((Bundle)localArrayList.get(i));
      j = paramInt;
      if (localDistrictInfo != null)
      {
        paramArrayList.add(localDistrictInfo);
        j = paramInt + 1;
      }
      i += 1;
      paramInt = j;
    }
  }
  
  public int getCompDistrictId(int paramInt)
  {
    if (paramInt == -1) {
      return paramInt;
    }
    DistrictInfo localDistrictInfo2 = sInstance.getDistrictById(paramInt);
    DistrictInfo localDistrictInfo1 = localDistrictInfo2;
    if (localDistrictInfo2 == null)
    {
      localDistrictInfo1 = new DistrictInfo();
      localDistrictInfo1.mId = paramInt;
    }
    int i = localDistrictInfo1.mId;
    if (localDistrictInfo1.mType == 3)
    {
      localDistrictInfo2 = sInstance.getParentDistrict(localDistrictInfo1.mId);
      paramInt = i;
      if (localDistrictInfo2 != null)
      {
        paramInt = i;
        if (localDistrictInfo2.mType == 2) {
          paramInt = localDistrictInfo2.mId << 16 & 0xFFFF0000 | localDistrictInfo1.mId & 0xFFFF;
        }
      }
    }
    for (;;)
    {
      LogUtil.e("", "compDistrictId: " + paramInt);
      return paramInt;
      paramInt = i;
      if (localDistrictInfo1.mType == 2) {
        paramInt = localDistrictInfo1.mId << 16 & 0xFFFF0000;
      }
    }
  }
  
  public int getCompDistrictId(DistrictInfo paramDistrictInfo)
  {
    int j = paramDistrictInfo.mId;
    int i;
    if (paramDistrictInfo.mType == 3) {
      if (paramDistrictInfo.mProvinceId == -1)
      {
        DistrictInfo localDistrictInfo = sInstance.getParentDistrict(paramDistrictInfo.mId);
        i = j;
        if (localDistrictInfo != null)
        {
          i = j;
          if (localDistrictInfo.mType == 2) {
            i = localDistrictInfo.mId << 16 & 0xFFFF0000 | paramDistrictInfo.mId & 0xFFFF;
          }
        }
      }
    }
    for (;;)
    {
      LogUtil.e("", "compDistrictId: " + i);
      return i;
      i = paramDistrictInfo.mProvinceId << 16 & 0xFFFF0000 | paramDistrictInfo.mId & 0xFFFF;
      continue;
      i = j;
      if (paramDistrictInfo.mType == 2) {
        i = paramDistrictInfo.mId << 16 & 0xFFFF0000;
      }
    }
  }
  
  public DistrictInfo getDistrictById(int paramInt)
  {
    Object localObject = new Bundle();
    try
    {
      if (sInstance.getDistrictInfoById(paramInt, (Bundle)localObject) != 0) {
        return null;
      }
      localObject = parseDistrictBundle((Bundle)localObject);
      return (DistrictInfo)localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public DistrictInfo getDistrictByPoint(GeoPoint paramGeoPoint, int paramInt)
  {
    if (paramGeoPoint == null) {}
    for (;;)
    {
      return null;
      Bundle localBundle = new Bundle();
      localBundle.putInt("CenterX", paramGeoPoint.getLongitudeE6());
      localBundle.putInt("CenterY", paramGeoPoint.getLatitudeE6());
      paramGeoPoint = new Bundle();
      try
      {
        if (sInstance.getDistrictInfoByPoint(localBundle, paramGeoPoint) == 0)
        {
          paramGeoPoint = parseDistrictBundle(paramGeoPoint);
          return paramGeoPoint;
        }
      }
      catch (Throwable paramGeoPoint) {}
    }
    return null;
  }
  
  public native int getDistrictInfoById(int paramInt, Bundle paramBundle);
  
  public native int getDistrictInfoByPoint(Bundle paramBundle1, Bundle paramBundle2);
  
  public DistrictInfo[] getDistrictsByPoint(GeoPoint paramGeoPoint)
  {
    DistrictInfo[] arrayOfDistrictInfo = new DistrictInfo[2];
    if (paramGeoPoint != null) {
      if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
      {
        arrayOfDistrictInfo[0] = sInstance.getDistrictByPoint(paramGeoPoint, 0);
        if (arrayOfDistrictInfo[0] != null)
        {
          if (arrayOfDistrictInfo[0].mType > 2) {
            break label183;
          }
          arrayOfDistrictInfo[0] = null;
        }
      }
    }
    for (;;)
    {
      if (NetworkUtils.getConnectStatus())
      {
        if (arrayOfDistrictInfo[0] == null)
        {
          arrayOfDistrictInfo[0] = sInstance.getDistrictByPoint(paramGeoPoint, 1);
          LogUtil.e("", "get online, district: " + arrayOfDistrictInfo[0]);
          if ((arrayOfDistrictInfo[0] != null) && (arrayOfDistrictInfo[0].mType == 3))
          {
            arrayOfDistrictInfo[1] = getParentDistrict(arrayOfDistrictInfo[0].mId, 1);
            LogUtil.e("", "get online, parent district: " + arrayOfDistrictInfo[1]);
          }
        }
        if ((arrayOfDistrictInfo[1] == null) && (arrayOfDistrictInfo[0] != null)) {
          arrayOfDistrictInfo[1] = getParentDistrict(arrayOfDistrictInfo[0].mId, 1);
        }
      }
      return arrayOfDistrictInfo;
      label183:
      if (arrayOfDistrictInfo[0].mType == 4)
      {
        DistrictInfo localDistrictInfo = getParentDistrict(arrayOfDistrictInfo[0].mId, 0);
        if ((localDistrictInfo != null) && (localDistrictInfo.mType == 3))
        {
          arrayOfDistrictInfo[0] = localDistrictInfo;
          arrayOfDistrictInfo[1] = getParentDistrict(arrayOfDistrictInfo[0].mId, 0);
        }
        else
        {
          arrayOfDistrictInfo[0] = null;
        }
      }
      else
      {
        arrayOfDistrictInfo[1] = getParentDistrict(arrayOfDistrictInfo[0].mId, 0);
        if ((arrayOfDistrictInfo[1] != null) && (arrayOfDistrictInfo[1].mType != 2)) {
          arrayOfDistrictInfo[1] = null;
        }
      }
    }
  }
  
  public native int getInputSug(Bundle paramBundle, ArrayList<Bundle> paramArrayList);
  
  public native int getNearestPoiByPoint(Bundle paramBundle1, Bundle paramBundle2);
  
  public native int getParentDistrict(int paramInt, Bundle paramBundle);
  
  public DistrictInfo getParentDistrict(int paramInt)
  {
    try
    {
      Object localObject = new Bundle();
      if (sInstance.getParentDistrict(paramInt, (Bundle)localObject) != 0) {
        return null;
      }
      localObject = parseDistrictBundle((Bundle)localObject);
      return (DistrictInfo)localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public DistrictInfo getParentDistrict(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new Bundle();
      if (sInstance.getParentDistrict(paramInt1, (Bundle)localObject) != 0) {
        return null;
      }
      localObject = parseDistrictBundle((Bundle)localObject);
      return (DistrictInfo)localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public native int getTopDistrict(Bundle paramBundle);
  
  public DistrictInfo getTopDistrict()
  {
    try
    {
      Object localObject = new Bundle();
      if (sInstance.getTopDistrict((Bundle)localObject) != 0) {
        return null;
      }
      localObject = parseDistrictBundle((Bundle)localObject);
      return (DistrictInfo)localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public native int initSugSubSys(int paramInt);
  
  public native int inputIndex(Bundle paramBundle);
  
  public SearchPoi parseParChildPoiBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    SearchPoi localSearchPoi = new SearchPoi();
    localSearchPoi.mName = StringUtils.trimString(paramBundle.getString("Name"));
    localSearchPoi.mAliasName = StringUtils.trimString(paramBundle.getString("AliasName"));
    localSearchPoi.mAddress = StringUtils.trimString(paramBundle.getString("Address"));
    Bundle localBundle = paramBundle.getBundle("ViewPoint");
    localSearchPoi.mViewPoint = new GeoPoint(localBundle.getInt("lon"), localBundle.getInt("lat"));
    localBundle = paramBundle.getBundle("ViewPoint");
    localSearchPoi.mGuidePoint = new GeoPoint(localBundle.getInt("lon"), localBundle.getInt("lat"));
    localSearchPoi.mDistrictId = paramBundle.getInt("DistrictId", 0);
    localSearchPoi.mType = paramBundle.getInt("Type", 0);
    localSearchPoi.mStreetId = paramBundle.getString("StreetId");
    if ((localSearchPoi.mStreetId != null) && (localSearchPoi.mStreetId.length() <= 0)) {
      localSearchPoi.mStreetId = null;
    }
    localSearchPoi.mId = paramBundle.getInt("Id", 0);
    if (paramBundle.containsKey("PoiOriginUID")) {
      localSearchPoi.mOriginUID = paramBundle.getString("PoiOriginUID");
    }
    if (paramBundle.containsKey("Uid")) {
      localSearchPoi.mUid = String.valueOf(paramBundle.getCharArray("Uid"));
    }
    localSearchPoi.mWeight = paramBundle.getInt("Weight", 0);
    localSearchPoi.mChildCnt = paramBundle.getInt("ChildCnt", 0);
    localSearchPoi.mShowCatalog = paramBundle.getInt("ShowCatalog", 0);
    localSearchPoi.mFCType = paramBundle.getInt("FcType", 0);
    localSearchPoi.mPoiCount = paramBundle.getInt("PoiCount", 0);
    localSearchPoi.mWanda = paramBundle.getInt("enWanda", -1);
    return localSearchPoi;
  }
  
  public SearchPoi parsePoiBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    SearchPoi localSearchPoi = new SearchPoi();
    localSearchPoi.mName = StringUtils.trimString(paramBundle.getString("Name"));
    localSearchPoi.mAddress = StringUtils.trimString(paramBundle.getString("Address"));
    localSearchPoi.mPhone = paramBundle.getString("Phone");
    localSearchPoi.mGuidePoint = new GeoPoint(paramBundle.getInt("GuideLongitude", Integer.MIN_VALUE), paramBundle.getInt("GuideLatitude", Integer.MIN_VALUE));
    localSearchPoi.mViewPoint = new GeoPoint(paramBundle.getInt("ViewLongitude", Integer.MIN_VALUE), paramBundle.getInt("ViewLatitude", Integer.MIN_VALUE));
    localSearchPoi.mDistrictId = paramBundle.getInt("DistrictId", 0);
    localSearchPoi.mType = paramBundle.getInt("Type", 0);
    localSearchPoi.mStreetId = paramBundle.getString("StreetId");
    if ((localSearchPoi.mStreetId != null) && (localSearchPoi.mStreetId.length() <= 0)) {
      localSearchPoi.mStreetId = null;
    }
    localSearchPoi.mId = paramBundle.getInt("Id", 0);
    if (paramBundle.containsKey("PoiOriginUID")) {
      localSearchPoi.mOriginUID = paramBundle.getString("PoiOriginUID");
    }
    localSearchPoi.mWeight = paramBundle.getInt("Weight", 0);
    return localSearchPoi;
  }
  
  public native int releaseSugSubSys();
  
  public native int searchAroundParks(Bundle paramBundle, ArrayList<Bundle> paramArrayList);
  
  public native int searchByCircle(Bundle paramBundle, ArrayList<Bundle> paramArrayList);
  
  public native int searchByCircleForMapPoiResultPB(Bundle paramBundle1, Bundle paramBundle2);
  
  public native int searchByCircleWithPager(Bundle paramBundle, ArrayList<Bundle> paramArrayList);
  
  public native int searchByFather(Bundle paramBundle, int[] paramArrayOfInt, ArrayList<Bundle> paramArrayList);
  
  public native int searchByKeyInRouteWithPager(Bundle paramBundle, ArrayList<Bundle> paramArrayList);
  
  public native int searchByName(Bundle paramBundle, ArrayList<Bundle> paramArrayList);
  
  public native int searchByNameForMapPoiResultPB(Bundle paramBundle1, Bundle paramBundle2);
  
  public native int searchByNameForPBData(Bundle paramBundle1, Bundle paramBundle2);
  
  public native int searchByNameWithPager(Bundle paramBundle, ArrayList<Bundle> paramArrayList);
  
  public native int updateBkgCache(ArrayList<Bundle> paramArrayList, int paramInt);
  
  public boolean updateBkgPoiCache(GeoPoint paramGeoPoint, boolean paramBoolean, int paramInt)
  {
    if (paramGeoPoint == null) {}
    for (;;)
    {
      return false;
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("Id", 0);
        localBundle.putString("Name", "Poi");
        localBundle.putInt("Longitude", paramGeoPoint.getLongitudeE6());
        localBundle.putInt("Latitude", paramGeoPoint.getLatitudeE6());
        localBundle.putBoolean("ismadian", paramBoolean);
        localBundle.putInt("focusindex", paramInt);
        paramInt = sInstance.updatePoiCache(localBundle);
        if (paramInt == 0) {
          return true;
        }
      }
      catch (Throwable paramGeoPoint) {}
    }
    return false;
  }
  
  public native int updatePoiCache(Bundle paramBundle);
  
  public boolean updatePoiCache(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {}
    for (;;)
    {
      return false;
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("Id", 0);
        localBundle.putString("Name", "Poi");
        localBundle.putInt("Longitude", paramGeoPoint.getLongitudeE6());
        localBundle.putInt("Latitude", paramGeoPoint.getLatitudeE6());
        int i = sInstance.updatePoiCache(localBundle);
        if (i == 0) {
          return true;
        }
      }
      catch (Throwable paramGeoPoint) {}
    }
    return false;
  }
  
  public native int updatePoiCacheWithList(ArrayList<Bundle> paramArrayList);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/jni/nativeif/JNISearchControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */