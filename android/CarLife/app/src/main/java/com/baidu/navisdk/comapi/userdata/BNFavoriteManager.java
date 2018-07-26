package com.baidu.navisdk.comapi.userdata;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.userdata.FavoriteParams.Key;
import com.baidu.navisdk.jni.control.FavoriteControlBundle;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.FavoriteModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class BNFavoriteManager extends BNLogicController implements Observer {
    private static final String TAG = "Favorite";
    private int mFavPoiInfoSortBy;
    private IBNFavUpdateListener mFavUpdateListener;
    private FavoriteControlBundle mFavoriteControl;
    private MsgHandler mMsgHandler;
    private IBNSyncDataListener mSyncDataListener;

    private static class LazyHolder {
        private static final BNFavoriteManager sInstance = new BNFavoriteManager();

        private LazyHolder() {
        }
    }

    private void handleSyncResult(int type) {
        switch (type) {
            case 200:
                loadAllFavPoisFromEngineDB();
                if (this.mSyncDataListener != null) {
                    this.mSyncDataListener.onSyncFavPoiResult(2);
                    return;
                }
                return;
            case 201:
                if (this.mSyncDataListener != null) {
                    this.mSyncDataListener.onSyncFavPoiResult(3);
                    return;
                }
                return;
            case 202:
                if (this.mSyncDataListener != null) {
                    this.mSyncDataListener.onSyncFavPoiResult(4);
                    return;
                }
                return;
            case 203:
                if (this.mSyncDataListener != null) {
                    this.mSyncDataListener.onSyncFavPoiResult(5);
                    return;
                }
                return;
            case 204:
                if (this.mSyncDataListener != null) {
                    this.mSyncDataListener.onSyncFavPoiResult(5);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private BNFavoriteManager() {
        this.mFavoriteControl = null;
        this.mMsgHandler = new MsgHandler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MsgDefine.MSG_APP_TRAJECTORY_SYNC_RESULT /*4203*/:
                        BNFavoriteManager.this.handleSyncResult(msg.arg1);
                        BNFavoriteManager.this.mSyncDataListener = null;
                        return;
                    default:
                        return;
                }
            }

            public void careAbout() {
                observe((int) MsgDefine.MSG_APP_TRAJECTORY_SYNC_RESULT);
            }
        };
        this.mFavoriteControl = FavoriteControlBundle.getInstance();
        VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
        this.mFavPoiInfoSortBy = getFavSortTypeFromPref();
    }

    public static BNFavoriteManager getInstance() {
        return LazyHolder.sInstance;
    }

    public void setFavSortType(int sortBy) {
        this.mFavPoiInfoSortBy = sortBy;
        PreferenceHelper.getInstance(BNaviModuleManager.getContext()).putInt(Key.SP_SORT_TYPE_PRE_KEY, sortBy);
    }

    public int getCurFavSortType() {
        return this.mFavPoiInfoSortBy;
    }

    private int getFavSortTypeFromPref() {
        return PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getInt(Key.SP_SORT_TYPE_PRE_KEY, 2);
    }

    public void createFavSubSystem() {
        this.mFavoriteControl.createFavSubSystem();
    }

    public synchronized void startSyncFavoritePoi(IBNSyncDataListener listener) {
        this.mSyncDataListener = listener;
        if (NaviAccountUtils.getInstance().isLogin()) {
            JNITrajectoryControl.sInstance.updateUserInfo(NaviAccountUtils.getInstance().syncGetBduss(), NaviAccountUtils.getInstance().getUid(), 1);
        }
        this.mFavoriteControl.startSyncFavoritePoi();
    }

    public synchronized boolean cancelDataSync() {
        this.mSyncDataListener = null;
        return this.mFavoriteControl.cancelSyncFavoritePOI();
    }

    private void loadAllFavPoisFromEngineDB() {
        this.mFavoriteControl.loadAllFavPoisFromEngineDB();
        getAllFavPoisFromEngineCache();
    }

    public synchronized void getAllFavPoisFromEngineCache() {
        if (this.mFavPoiInfoSortBy == 2) {
            StatisticManager.onEvent("410318", "410318");
        } else {
            StatisticManager.onEvent("410317", "410317");
        }
        ArrayList<FavoritePoiInfo> favPoiInfoList = this.mFavoriteControl.getAllFavPoisFromEngineCache(this.mFavPoiInfoSortBy);
        int favCount = getAllFavPoiCnt();
        FavoriteModel.getInstance().setFavDataList(favPoiInfoList);
        FavoriteModel.getInstance().setFavCount(favCount);
    }

    public synchronized int addNewPoiToFavorite(SearchPoi searchPoi, FavoritePoiInfo outFavPoiInfo) {
        int i;
        if (searchPoi != null) {
            if (searchPoi.mViewPoint != null && searchPoi.mViewPoint.isValid()) {
                if (isPoiExistInFavByPoint(searchPoi.mViewPoint)) {
                    i = -1;
                } else {
                    FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
                    favoritePoiInfo = searchPoiToFavPoi(searchPoi);
                    int result = this.mFavoriteControl.addPOI(favoritePoiInfo);
                    if (result == 1) {
                        outFavPoiInfo.setValue(favoritePoiInfo);
                        FavoriteModel.getInstance().addNewFavPoiToMemList(favoritePoiInfo);
                    }
                    i = result;
                }
            }
        }
        LogUtil.m15791e("Favorite", "addFavorite searchPoi is null");
        i = 0;
        return i;
    }

    public synchronized int addNewPoiToFavorite(SearchPoi searchPoi) {
        return addNewPoiToFavorite(searchPoi, new FavoritePoiInfo());
    }

    public synchronized void addNewPoiListToFavorite(List<FavoritePoiInfo> listData) {
        if (listData != null) {
            for (int i = 0; i < listData.size(); i++) {
                FavoritePoiInfo favPoiInfo = (FavoritePoiInfo) listData.get(i);
                if (!isPoiExistInFavByPoint(favPoiInfo.mViewPoint) && this.mFavoriteControl.addPOI(favPoiInfo) == 1) {
                    FavoriteModel.getInstance().addNewFavPoiToMemList(favPoiInfo);
                }
            }
        }
    }

    public synchronized boolean removePoiFromFavorite(SearchPoi searchPoi) {
        boolean z = false;
        synchronized (this) {
            if (searchPoi != null) {
                GeoPoint viewPoint = searchPoi.mViewPoint;
                Point mcPoint = null;
                if (viewPoint != null) {
                    if (viewPoint != null) {
                        mcPoint = gcjToMCPoint(viewPoint);
                    }
                    String key = this.mFavoriteControl.getFavPoiKeyByPoint(mcPoint);
                    if (!StringUtils.isEmpty(key)) {
                        z = removePoiFromFavorite(key);
                    }
                }
            }
        }
        return z;
    }

    public synchronized boolean removePoiFromFavorite(String key) {
        boolean z = false;
        synchronized (this) {
            if (!StringUtils.isEmpty(key)) {
                if (-1 != this.mFavoriteControl.removePOI(key)) {
                    FavoriteModel.getInstance().removeFavPoiFromMemList(key);
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized int updateFavoritePoi(String key, String newName) {
        int i = 0;
        synchronized (this) {
            if (TextUtils.isEmpty(newName)) {
                i = -1;
            } else if (!TextUtils.isEmpty(key) && isPoiExistInFavByKey(key)) {
                FavoritePoiInfo data = FavoriteModel.getInstance().getFavPoiInfoFromMemListByKey(key);
                if (data != null) {
                    FavoritePoiInfo poiItem = new FavoritePoiInfo();
                    poiItem.setValue(data);
                    poiItem.mFavName = newName;
                    i = this.mFavoriteControl.updatePOI(poiItem);
                    if (i == 1) {
                        data.mFavName = newName;
                        if (this.mFavUpdateListener != null) {
                            this.mFavUpdateListener.onFavUpdateComplete();
                        }
                    }
                }
            }
        }
        return i;
    }

    public synchronized void cleanAllFavPois() {
        if (this.mFavoriteControl.clearAllFavPois()) {
            FavoriteModel.getInstance().clearFavDataList();
            FavoriteModel.getInstance().setFavCount(0);
            if (this.mFavUpdateListener != null) {
                this.mFavUpdateListener.onFavUpdateComplete();
            }
        }
    }

    public synchronized FavoritePoiInfo getFavPoiInfoByGeoPoint(GeoPoint geoPoint) {
        FavoritePoiInfo favPoiInfo;
        if (geoPoint != null) {
            if (geoPoint.isValid()) {
                favPoiInfo = this.mFavoriteControl.getFavPoiInfoByPoint(gcjToMCPoint(geoPoint));
            }
        }
        favPoiInfo = null;
        return favPoiInfo;
    }

    public synchronized int getAllFavPoiCnt() {
        return this.mFavoriteControl.getPOICnt();
    }

    public String getFavoriteKey(SearchPoi searchPoi) {
        return null;
    }

    private Point gcjToMCPoint(GeoPoint point) {
        Point mcPoint = new Point();
        Bundle bundle = CoordinateTransformUtil.LLE62MC(point.getLongitudeE6(), point.getLatitudeE6());
        int lonMC = bundle.getInt("MCx");
        int latMC = bundle.getInt("MCy");
        mcPoint.setmPtx(lonMC);
        mcPoint.setmPty(latMC);
        return mcPoint;
    }

    public GeoPoint MCTogcjPoint(Point point) {
        Bundle bundle = CoordinateTransformUtil.MC2LLE6(point.f19727x, point.f19728y);
        return new GeoPoint(bundle.getInt("LLx"), bundle.getInt("LLy"));
    }

    public synchronized boolean isPoiExistInFavByPoint(SearchPoi searchPoi) {
        boolean z = false;
        synchronized (this) {
            if (searchPoi != null) {
                if (searchPoi.mViewPoint != null && searchPoi.mViewPoint.isValid()) {
                    z = isPoiExistInFavByPoint(searchPoi.mViewPoint);
                }
            }
        }
        return z;
    }

    public synchronized boolean isPoiExistInFavByPoint(GeoPoint point) {
        return isPoiExistInFavByPoint(gcjToMCPoint(point));
    }

    public synchronized boolean isPoiExistInFavByPoint(Point point) {
        boolean z;
        if (this.mFavoriteControl.getFavPoiInfoByPoint(point) != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public boolean isPoiExistInFavByKey(String strKey) {
        if (StringUtils.isEmpty(strKey) || this.mFavoriteControl.getFavPoiInfoByKey(strKey) == null) {
            return false;
        }
        return true;
    }

    private FavoritePoiInfo searchPoiToFavPoi(SearchPoi searchPoi) {
        if (searchPoi == null) {
            LogUtil.m15791e("Favorite", "addFavorite searchPoi is null");
            return null;
        }
        FavoritePoiInfo favPoi = new FavoritePoiInfo();
        if (searchPoi.mOriginUID != null) {
            favPoi.mPoiId = searchPoi.mOriginUID;
        }
        if (StringUtils.isEmpty(searchPoi.mName)) {
            favPoi.mFavName = StyleManager.getString(C0965R.string.poi_on_map);
        } else {
            favPoi.mFavName = searchPoi.mName;
        }
        if (StringUtils.isEmpty(searchPoi.mAddress)) {
            favPoi.mFavAddr = StyleManager.getString(C0965R.string.poi_address_defalut);
        } else {
            favPoi.mFavAddr = searchPoi.mAddress;
        }
        if (searchPoi.mPhone != null) {
            favPoi.mFavAlias = searchPoi.mPhone;
        }
        favPoi.mPoiType = searchPoi.mType;
        favPoi.mFavCityId = searchPoi.mDistrictId;
        if (searchPoi.mViewPoint == null) {
            return favPoi;
        }
        favPoi.mViewPoint = gcjToMCPoint(searchPoi.mViewPoint);
        return favPoi;
    }

    public SearchPoi favPoiToSearchPoi(FavoritePoiInfo favPoi) {
        if (favPoi == null) {
            LogUtil.m15791e("Favorite", "addFavorite searchPoi is null");
            return null;
        }
        SearchPoi searchPoi = new SearchPoi();
        if (favPoi.mPoiId != null) {
            searchPoi.mOriginUID = favPoi.mPoiId;
        }
        if (favPoi.mFavName != null) {
            searchPoi.mName = favPoi.mFavName;
        }
        if (favPoi.mFavAddr != null) {
            searchPoi.mAddress = favPoi.mFavAddr;
        }
        if (favPoi.mPhone != null) {
            searchPoi.mPhone = favPoi.mPhone;
        }
        searchPoi.mType = favPoi.mPoiType;
        searchPoi.mViewPoint = MCTogcjPoint(favPoi.mViewPoint);
        searchPoi.mGuidePoint = new GeoPoint(searchPoi.mViewPoint);
        searchPoi.mDistrictId = favPoi.mFavCityId;
        return searchPoi;
    }

    public synchronized SearchPoi getSearchPoibyKey(String favKey) {
        SearchPoi searchPoi;
        if (StringUtils.isEmpty(favKey)) {
            searchPoi = null;
        } else {
            searchPoi = favPoiToSearchPoi(this.mFavoriteControl.getFavPoiInfoByKey(favKey));
        }
        return searchPoi;
    }

    public void update(Observable arg0, Object arg1) {
    }

    public void asyncLoadFavListData(IBNFavUpdateListener listener) {
    }
}
