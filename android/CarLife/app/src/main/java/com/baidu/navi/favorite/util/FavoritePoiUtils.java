package com.baidu.navi.favorite.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.core.i;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;

public class FavoritePoiUtils
{
  public static final String TAG = FavoritePoiUtils.class.getSimpleName();
  
  public static String addOrDelFav(SearchPoi paramSearchPoi)
  {
    String str2;
    if (!isHaveFav(paramSearchPoi))
    {
      String str1 = null;
      if (paramSearchPoi != null) {
        str1 = paramSearchPoi.mName;
      }
      if (str1 == null) {
        return "";
      }
      str2 = str1;
      if (str1.length() > 20) {
        str2 = str1.substring(0, 20);
      }
    }
    for (paramSearchPoi = addToFavorite(paramSearchPoi, str2);; paramSearchPoi = delFromFavorite(paramSearchPoi)) {
      return paramSearchPoi;
    }
  }
  
  public static String addToFavorite(SearchPoi paramSearchPoi, String paramString)
  {
    int i = FavoritePois.getPoiInstance().addFavPoiInfo(paramString, parseSearchPoiToSyncPoi(paramSearchPoi));
    paramSearchPoi = null;
    switch (i)
    {
    }
    for (;;)
    {
      i.b(TAG, paramSearchPoi);
      return paramSearchPoi;
      paramSearchPoi = "同名或名称为空";
      continue;
      paramSearchPoi = "添加失败";
      continue;
      paramSearchPoi = "已添加到收藏夹";
    }
  }
  
  public static String delFromFavorite(SearchPoi paramSearchPoi)
  {
    FavoritePois localFavoritePois = FavoritePois.getPoiInstance();
    if (localFavoritePois.deleteFavPoi(localFavoritePois.getExistKeyByInfo(parseSearchPoiToSyncPoi(paramSearchPoi)))) {}
    for (paramSearchPoi = "从收藏夹移除";; paramSearchPoi = "从收藏夹移除失败")
    {
      i.b(TAG, paramSearchPoi);
      return paramSearchPoi;
    }
  }
  
  private static Point gcjToMCPoint(GeoPoint paramGeoPoint)
  {
    Point localPoint = new Point();
    paramGeoPoint = CoordinateTransformUtil.LLE62MC(paramGeoPoint.getLongitudeE6(), paramGeoPoint.getLatitudeE6());
    int i = paramGeoPoint.getInt("MCx");
    int j = paramGeoPoint.getInt("MCy");
    localPoint.setIntX(i);
    localPoint.setIntY(j);
    return localPoint;
  }
  
  public static boolean isHaveFav(SearchPoi paramSearchPoi)
  {
    i.b(TAG, "isHaveFav");
    return !TextUtils.isEmpty(FavoritePois.getPoiInstance().getExistKeyByInfo(parseSearchPoiToSyncPoi(paramSearchPoi)));
  }
  
  public static GeoPoint mcTogcjPoint(Point paramPoint)
  {
    paramPoint = CoordinateTransformUtil.MC2LLE6(paramPoint.getIntX(), paramPoint.getIntY());
    return new GeoPoint(paramPoint.getInt("LLx"), paramPoint.getInt("LLy"));
  }
  
  public static SearchPoi parseFavSyncPoiToSyncPoi(FavSyncPoi paramFavSyncPoi)
  {
    SearchPoi localSearchPoi = new SearchPoi();
    localSearchPoi.mOriginUID = paramFavSyncPoi.poiId;
    localSearchPoi.mAddress = paramFavSyncPoi.content;
    localSearchPoi.mName = paramFavSyncPoi.poiName;
    localSearchPoi.mDistrictId = paramFavSyncPoi.cityid;
    localSearchPoi.mType = paramFavSyncPoi.poiStyle;
    if (paramFavSyncPoi.pt != null) {}
    for (paramFavSyncPoi = mcTogcjPoint(paramFavSyncPoi.pt);; paramFavSyncPoi = new GeoPoint())
    {
      localSearchPoi.mGuidePoint = paramFavSyncPoi;
      localSearchPoi.mViewPoint = paramFavSyncPoi;
      return localSearchPoi;
    }
  }
  
  public static FavSyncPoi parseSearchPoiToSyncPoi(SearchPoi paramSearchPoi)
  {
    i.b(TAG, "cityId:" + paramSearchPoi.mDistrictId + " content:" + paramSearchPoi.mAddress + " poiId:" + paramSearchPoi.mOriginUID + " poiName:" + paramSearchPoi.mName + " poiStyle:" + paramSearchPoi.mType + " mGuidePoint:" + paramSearchPoi.mGuidePoint.getLongitudeE6() + ", " + paramSearchPoi.mGuidePoint.getLatitudeE6());
    FavSyncPoi localFavSyncPoi = new FavSyncPoi();
    localFavSyncPoi.cityid = paramSearchPoi.mDistrictId;
    localFavSyncPoi.content = paramSearchPoi.mAddress;
    localFavSyncPoi.poiId = paramSearchPoi.mOriginUID;
    localFavSyncPoi.poiName = paramSearchPoi.mName;
    if (paramSearchPoi.mGuidePoint != null)
    {
      localFavSyncPoi.pt = new Point(gcjToMCPoint(paramSearchPoi.mGuidePoint));
      localFavSyncPoi.poiType = 0;
      if (!TextUtils.isEmpty(localFavSyncPoi.poiId)) {
        break label238;
      }
    }
    label238:
    for (localFavSyncPoi.poiStyle = 11;; localFavSyncPoi.poiStyle = 10)
    {
      localFavSyncPoi.floorId = "";
      localFavSyncPoi.buildingId = "";
      localFavSyncPoi.poiJsonData = "";
      localFavSyncPoi.bduid = NaviAccountUtils.getInstance().getUid();
      return localFavSyncPoi;
      localFavSyncPoi.pt = new Point(0.0D, 0.0D);
      break;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/util/FavoritePoiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */