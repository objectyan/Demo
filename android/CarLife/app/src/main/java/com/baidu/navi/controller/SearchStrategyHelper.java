package com.baidu.navi.controller;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class SearchStrategyHelper {
    public static final String FIRST_ONLINE_SEARCH = "first_online_search";
    public static final String FIRST_RESULT_ONLINE_SEARCH = "first_result_online_search";
    private static volatile SearchStrategyHelper mInstance;
    private boolean isNeedReloadSearchEngine = false;
    private DistrictInfo mCenterDistrict = new DistrictInfo();
    private Context mContext;

    public SearchStrategyHelper(Context mContext) {
        this.mContext = mContext;
    }

    public static SearchStrategyHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (SearchStrategyHelper.class) {
                if (mInstance == null) {
                    mInstance = new SearchStrategyHelper(context);
                }
            }
        }
        return mInstance;
    }

    public void setIsNeedReloadSearchEngine(boolean isNeed) {
        this.isNeedReloadSearchEngine = isNeed;
    }

    public void reloadSearchEngine() {
        if (this.isNeedReloadSearchEngine) {
            BNaviEngineManager.getInstance().reloadSubSystem(2);
            this.isNeedReloadSearchEngine = false;
        }
    }

    public int getCurrentDistrictId() {
        if (this.mCenterDistrict == null) {
            return -1;
        }
        return this.mCenterDistrict.mId;
    }

    public int getPoiMaxCountByNetMode(int netMode) {
        if (netMode == 0) {
            return 100;
        }
        return 20;
    }

    public boolean checkCanSearchByNetMode(int netMode) {
        if (netMode == 0 || NetworkUtils.isNetworkAvailable(this.mContext)) {
            return true;
        }
        TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.space_search_network_unavailable);
        return false;
    }

    public boolean checkCanSearchBySet() {
        if (getNetModeBySet() == 0 || NetworkUtils.isNetworkAvailable(this.mContext)) {
            return true;
        }
        TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.space_search_network_unavailable);
        return false;
    }

    public int getNetModeBySet() {
        if (hasDataDownloadedBySet()) {
            return 0;
        }
        return 1;
    }

    public int getNetModeBySet(DistrictInfo districtInfo) {
        if (districtInfo == null) {
            return getNetModeBySet();
        }
        if (hasDataDownloadedByDistrictInfo(districtInfo)) {
            return 0;
        }
        return 1;
    }

    public int getNetModeByPoint(GeoPoint point) {
        if (hasDataDownloadedByPoint(point)) {
            return 0;
        }
        return 1;
    }

    public boolean hasDataDownloadedByPoint(GeoPoint point) {
        if (point == null || !BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            return false;
        }
        this.mCenterDistrict = BNPoiSearcher.getInstance().getDistrictByPoint(point, 0);
        if (this.mCenterDistrict == null) {
            return false;
        }
        int provinceId;
        if (this.mCenterDistrict.mType == 2) {
            provinceId = this.mCenterDistrict.mId;
        } else {
            this.mCenterDistrict = BNPoiSearcher.getInstance().getParentDistrict(this.mCenterDistrict.mId);
            provinceId = this.mCenterDistrict.mId;
        }
        return BNOfflineDataManager.getInstance().isProvinceDataDownload(provinceId);
    }

    public boolean hasDataDownloadedByDistrictInfo(DistrictInfo districtInfo) {
        if (districtInfo == null) {
            return false;
        }
        int provinceId;
        if (districtInfo.mType == 2) {
            provinceId = districtInfo.mId;
        } else {
            this.mCenterDistrict = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
            if (this.mCenterDistrict == null) {
                return false;
            }
            provinceId = this.mCenterDistrict.mId;
        }
        return BNOfflineDataManager.getInstance().isProvinceDataDownload(provinceId);
    }

    public boolean hasDataDownloadedBySet() {
        int provinceId = 0;
        this.mCenterDistrict = GeoLocateModel.getInstance().getCurrentDistrict();
        if (this.mCenterDistrict == null) {
            return false;
        }
        if (this.mCenterDistrict.mType == 2) {
            provinceId = this.mCenterDistrict.mId;
        } else {
            this.mCenterDistrict = BNPoiSearcher.getInstance().getParentDistrict(this.mCenterDistrict.mId);
            if (this.mCenterDistrict != null) {
                provinceId = this.mCenterDistrict.mId;
            }
        }
        return BNOfflineDataManager.getInstance().isProvinceDataDownload(provinceId);
    }

    public boolean isFirstOnlineSearch(int netMode) {
        return false;
    }

    public boolean isFirstResultOnlineSearch(int netMode) {
        return false;
    }
}
