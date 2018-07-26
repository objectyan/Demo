package com.baidu.navisdk.jni.control;

import android.os.Bundle;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.jni.nativeif.JNIFavoriteControlNew;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.nplatform.comapi.basestruct.Point;
import java.util.ArrayList;

public class FavoriteControlBundle {
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
    private JNIFavoriteControlNew mJNIFavoriteControl;

    private static class LazyHolder {
        private static FavoriteControlBundle sInstance = new FavoriteControlBundle();

        private LazyHolder() {
        }
    }

    public static FavoriteControlBundle getInstance() {
        return LazyHolder.sInstance;
    }

    private FavoriteControlBundle() {
        this.mJNIFavoriteControl = new JNIFavoriteControlNew();
    }

    public void createFavSubSystem() {
        this.mJNIFavoriteControl.createFavSubSystem();
    }

    public void startSyncFavoritePoi() {
        this.mJNIFavoriteControl.startSyncFavoritePOI();
    }

    public boolean cancelSyncFavoritePOI() {
        if (this.mJNIFavoriteControl.cancelSyncFavoritePOI() == 0) {
            return true;
        }
        return false;
    }

    public void loadAllFavPoisFromEngineDB() {
        this.mJNIFavoriteControl.loadAllFavoritePOISFromDB();
    }

    public ArrayList<FavoritePoiInfo> getAllFavPoisFromEngineCache(int type) {
        ArrayList<Bundle> outPoiList = new ArrayList();
        if (this.mJNIFavoriteControl.getAllFavoritePOIS(type, outPoiList) == 0) {
            return parseBundleToFavPoiInfoList(outPoiList);
        }
        return new ArrayList();
    }

    public int addPOI(FavoritePoiInfo poiItem) {
        if (getPOICnt() >= 500) {
            return -2;
        }
        Bundle input = construct(poiItem);
        Bundle output = new Bundle();
        if (this.mJNIFavoriteControl.addFavoritePOI(input, output) != 0) {
            return 0;
        }
        poiItem.setValue(deconstruct(output));
        return 1;
    }

    public int removePOI(String key) {
        return this.mJNIFavoriteControl.removeFavoritePOI(key);
    }

    public int updatePOI(FavoritePoiInfo poiItem) {
        if (this.mJNIFavoriteControl.updateFavoritePOI(construct(poiItem)) == 0) {
            return 1;
        }
        return 0;
    }

    public boolean clearAllFavPois() {
        if (this.mJNIFavoriteControl.clearAllFavoritePOI() == 0) {
            return true;
        }
        return false;
    }

    public int getPOICnt() {
        Bundle output = new Bundle();
        if (this.mJNIFavoriteControl.getFavoritePoiCnt(output) != 0) {
            return 0;
        }
        return output.getInt("count", 0);
    }

    public FavoritePoiInfo getFavPoiInfoByKey(String key) {
        Bundle output = new Bundle();
        if (this.mJNIFavoriteControl.getFavoritePOIByKey(key, output) == 0) {
            return deconstruct(output);
        }
        return null;
    }

    public FavoritePoiInfo getFavPoiInfoByPoint(Point mcPoint) {
        Bundle input = new Bundle();
        Bundle output = new Bundle();
        input.putInt(KEY_VIEWPOINT_LONGITUDE, mcPoint.f19727x);
        input.putInt(KEY_VIEWPOINT_LATITUDE, mcPoint.f19728y);
        if (this.mJNIFavoriteControl.getFavoritePOIByPoint(input, output) == 0) {
            return deconstruct(output);
        }
        return null;
    }

    public String getFavPoiKeyByPoint(Point mcPoint) {
        Bundle input = new Bundle();
        input.putInt(KEY_VIEWPOINT_LONGITUDE, mcPoint.f19727x);
        input.putInt(KEY_VIEWPOINT_LATITUDE, mcPoint.f19728y);
        Bundle output = new Bundle();
        String key = "";
        if (this.mJNIFavoriteControl.getFavPoiKeyByPoint(input, output) == 0) {
            return output.getString(KEY_POI_KEY);
        }
        return key;
    }

    private ArrayList<FavoritePoiInfo> parseBundleToFavPoiInfoList(ArrayList<Bundle> inBundleList) {
        ArrayList<FavoritePoiInfo> favPoisInfoList = new ArrayList();
        if (!(inBundleList == null || inBundleList.size() == 0)) {
            int size = inBundleList.size();
            for (int i = 0; i < size; i++) {
                favPoisInfoList.add(deconstruct((Bundle) inBundleList.get(i)));
            }
        }
        return favPoisInfoList;
    }

    private Bundle construct(FavoritePoiInfo favPoiInfo) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_POI_KEY, favPoiInfo.mFavKey);
        bundle.putString(KEY_ID, favPoiInfo.mPoiId);
        bundle.putInt("type", favPoiInfo.mPoiType);
        bundle.putInt(KEY_VIEWPOINT_LONGITUDE, favPoiInfo.mViewPoint.f19727x);
        bundle.putInt(KEY_VIEWPOINT_LATITUDE, favPoiInfo.mViewPoint.f19728y);
        bundle.putString("name", favPoiInfo.mFavName);
        bundle.putString(KEY_ALIAS, favPoiInfo.mFavAlias);
        bundle.putString(KEY_DESC, favPoiInfo.mPoiDesc);
        bundle.putString("addr", favPoiInfo.mFavAddr);
        bundle.putString(KEY_TELS, favPoiInfo.mPhone);
        bundle.putInt(KEY_CITY_ID, favPoiInfo.mFavCityId);
        if (favPoiInfo.mFavHasSync) {
            bundle.putInt(KEY_IS_SYNC, 1);
        } else {
            bundle.putInt(KEY_IS_SYNC, 0);
        }
        return bundle;
    }

    private FavoritePoiInfo deconstruct(Bundle bundle) {
        FavoritePoiInfo favPoiItemInfo = new FavoritePoiInfo();
        favPoiItemInfo.mPoiId = bundle.getString(KEY_ID);
        favPoiItemInfo.mPoiType = bundle.getInt("type");
        favPoiItemInfo.mFavKey = bundle.getString(KEY_POI_KEY);
        favPoiItemInfo.mFavName = bundle.getString("name");
        favPoiItemInfo.mFavAddr = bundle.getString("addr");
        favPoiItemInfo.mFavAlias = bundle.getString(KEY_ALIAS);
        favPoiItemInfo.mFavAddTime = String.valueOf(bundle.getLong(KEY_FAV_ADD_TIME));
        favPoiItemInfo.mFavHasSync = bundle.getBoolean(KEY_IS_SYNC);
        favPoiItemInfo.mFavCityId = bundle.getInt(KEY_CITY_ID);
        DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictById(favPoiItemInfo.mFavCityId);
        if (districtInfo != null) {
            favPoiItemInfo.mFavCityName = districtInfo.mName;
        }
        favPoiItemInfo.mPhone = bundle.getString(KEY_TELS);
        Bundle viewPointBundle = bundle.getBundle("stViewPoint");
        favPoiItemInfo.mViewPoint.setmPtx(viewPointBundle.getInt("lon"));
        favPoiItemInfo.mViewPoint.setmPty(viewPointBundle.getInt("lat"));
        return favPoiItemInfo;
    }
}
