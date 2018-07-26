package com.baidu.navi.favorite.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.carlife.core.C1260i;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.model.FavSyncPoi;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;

public class FavoritePoiUtils {
    public static final String TAG = FavoritePoiUtils.class.getSimpleName();

    public static FavSyncPoi parseSearchPoiToSyncPoi(SearchPoi searchPoi) {
        C1260i.b(TAG, "cityId:" + searchPoi.mDistrictId + " content:" + searchPoi.mAddress + " poiId:" + searchPoi.mOriginUID + " poiName:" + searchPoi.mName + " poiStyle:" + searchPoi.mType + " mGuidePoint:" + searchPoi.mGuidePoint.getLongitudeE6() + ", " + searchPoi.mGuidePoint.getLatitudeE6());
        FavSyncPoi syncPoi = new FavSyncPoi();
        syncPoi.cityid = searchPoi.mDistrictId;
        syncPoi.content = searchPoi.mAddress;
        syncPoi.poiId = searchPoi.mOriginUID;
        syncPoi.poiName = searchPoi.mName;
        if (searchPoi.mGuidePoint != null) {
            syncPoi.pt = new Point(gcjToMCPoint(searchPoi.mGuidePoint));
        } else {
            syncPoi.pt = new Point(0.0d, 0.0d);
        }
        syncPoi.poiType = 0;
        if (TextUtils.isEmpty(syncPoi.poiId)) {
            syncPoi.poiStyle = 11;
        } else {
            syncPoi.poiStyle = 10;
        }
        syncPoi.floorId = "";
        syncPoi.buildingId = "";
        syncPoi.poiJsonData = "";
        syncPoi.bduid = NaviAccountUtils.getInstance().getUid();
        return syncPoi;
    }

    public static SearchPoi parseFavSyncPoiToSyncPoi(FavSyncPoi favSyncPoi) {
        GeoPoint geoPoint;
        SearchPoi searchPoi = new SearchPoi();
        searchPoi.mOriginUID = favSyncPoi.poiId;
        searchPoi.mAddress = favSyncPoi.content;
        searchPoi.mName = favSyncPoi.poiName;
        searchPoi.mDistrictId = favSyncPoi.cityid;
        searchPoi.mType = favSyncPoi.poiStyle;
        if (favSyncPoi.pt != null) {
            geoPoint = mcTogcjPoint(favSyncPoi.pt);
        } else {
            geoPoint = new GeoPoint();
        }
        searchPoi.mGuidePoint = geoPoint;
        searchPoi.mViewPoint = geoPoint;
        return searchPoi;
    }

    public static boolean isHaveFav(SearchPoi poiDetailInfo) {
        C1260i.b(TAG, "isHaveFav");
        return !TextUtils.isEmpty(FavoritePois.getPoiInstance().getExistKeyByInfo(parseSearchPoiToSyncPoi(poiDetailInfo)));
    }

    public static String addOrDelFav(SearchPoi searchPoi) {
        String retmsg = "";
        if (isHaveFav(searchPoi)) {
            retmsg = delFromFavorite(searchPoi);
        } else {
            String favpoiname = null;
            if (searchPoi != null) {
                favpoiname = searchPoi.mName;
            }
            if (favpoiname == null) {
                return retmsg;
            }
            if (favpoiname.length() > 20) {
                favpoiname = favpoiname.substring(0, 20);
            }
            retmsg = addToFavorite(searchPoi, favpoiname);
        }
        return retmsg;
    }

    public static String addToFavorite(SearchPoi searchPoi, String name) {
        String retmsg = null;
        switch (FavoritePois.getPoiInstance().addFavPoiInfo(name, parseSearchPoiToSyncPoi(searchPoi))) {
            case -1:
                retmsg = "同名或名称为空";
                break;
            case 0:
                retmsg = "添加失败";
                break;
            case 1:
                retmsg = "已添加到收藏夹";
                break;
        }
        C1260i.b(TAG, retmsg);
        return retmsg;
    }

    public static String delFromFavorite(SearchPoi searchPoi) {
        String retmsg;
        FavoritePois fav = FavoritePois.getPoiInstance();
        if (fav.deleteFavPoi(fav.getExistKeyByInfo(parseSearchPoiToSyncPoi(searchPoi)))) {
            retmsg = "从收藏夹移除";
        } else {
            retmsg = "从收藏夹移除失败";
        }
        C1260i.b(TAG, retmsg);
        return retmsg;
    }

    private static Point gcjToMCPoint(GeoPoint point) {
        Point mcPoint = new Point();
        Bundle bundle = CoordinateTransformUtil.LLE62MC(point.getLongitudeE6(), point.getLatitudeE6());
        int lonMC = bundle.getInt("MCx");
        int latMC = bundle.getInt("MCy");
        mcPoint.setIntX(lonMC);
        mcPoint.setIntY(latMC);
        return mcPoint;
    }

    public static GeoPoint mcTogcjPoint(Point point) {
        Bundle bundle = CoordinateTransformUtil.MC2LLE6(point.getIntX(), point.getIntY());
        return new GeoPoint(bundle.getInt("LLx"), bundle.getInt("LLy"));
    }
}
