package com.baidu.navisdk.model.datastruct;

import android.text.TextUtils;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class SearchPoiPager {
    public static final int DEFAULT_SEARCH_COUNT_PRE_PAGER = 10;
    public static final int INVAIL_DISTRCTID = -1000;
    public static final int ROUTESEARCH_MODE_BY_KEYWORD = 1;
    public static final int ROUTESEARCH_MODE_BY_TYPE = 0;
    public static final int SEARCH_TYPE_CATALOG = 4;
    public static final int SEARCH_TYPE_CATALOG_WITH_DISTRCTID = 5;
    public static final int SEARCH_TYPE_KEY = 1;
    public static final int SEARCH_TYPE_KEY_WITH_ROUTE = 6;
    public static final int SEARCH_TYPE_SPACE = 2;
    public static final int SEARCH_TYPE_SPACE_WITH_DISTRCTID = 3;
    public static final int SORT_TYPE_DEFAULT = 1;
    public static final int SORT_TYPE_DISTANCE = 2;
    public static final int SORT_TYPE_DISTANCE_WITH_STARTPOINT = 3;
    public static int mSortType = 1;
    private boolean isLastPager;
    private int mCatalogId;
    private int mCountPerPager;
    private int mCurrentPageNum;
    private ArrayList<SearchPoi> mDistanceSortList;
    private DistrictInfo mDistrctInfo;
    private int mNetMode;
    private SearchPoiPager mNextPager;
    private SearchPoiPager mNextPagerForMap;
    private int mPageCnt;
    private int mPagerNum;
    private int mParPoiSize;
    private ArrayList<SearchPoi> mPoiList;
    private SearchPoiPager mPrevPager;
    private SearchPoiPager mPrevPagerForMap;
    private SearchCircle mSearchCircle;
    private String mSearchKey;
    private int mSearchMode;
    private int mSearchRange;
    private int mSearchType;

    private SearchPoiPager() {
        this.mPagerNum = 1;
    }

    public SearchPoiPager(String key, DistrictInfo district, int countPerPager, int netMode) {
        this.mPagerNum = 1;
        this.mSearchType = 1;
        this.mCountPerPager = countPerPager;
        this.mSearchKey = key;
        this.mNetMode = netMode;
        this.mDistrctInfo = district;
        mSortType = 1;
    }

    public SearchPoiPager(String key, DistrictInfo district, SearchCircle searchCircle, int countPerPager, int netMode) {
        this.mPagerNum = 1;
        this.mSearchType = 3;
        this.mCountPerPager = countPerPager;
        this.mSearchKey = key;
        this.mNetMode = netMode;
        this.mDistrctInfo = district;
        this.mSearchCircle = searchCircle;
        mSortType = 1;
    }

    public SearchPoiPager(String key, SearchCircle searchCircle, int countPerPager, int netMode) {
        this.mPagerNum = 1;
        this.mSearchType = 2;
        this.mCountPerPager = countPerPager;
        this.mSearchKey = key;
        this.mNetMode = netMode;
        this.mSearchCircle = searchCircle;
        mSortType = 1;
    }

    public SearchPoiPager(int catalogId, SearchCircle searchCircle, int countPerPager, int netMode) {
        this.mPagerNum = 1;
        this.mSearchType = 4;
        this.mCountPerPager = countPerPager;
        this.mCatalogId = catalogId;
        this.mNetMode = netMode;
        this.mSearchCircle = searchCircle;
        mSortType = 1;
    }

    public SearchPoiPager(int catalogId, DistrictInfo district, SearchCircle searchCircle, int countPerPager, int netMode) {
        this.mPagerNum = 1;
        this.mSearchType = 5;
        this.mCountPerPager = countPerPager;
        this.mCatalogId = catalogId;
        this.mNetMode = netMode;
        this.mDistrctInfo = district;
        this.mSearchCircle = searchCircle;
        mSortType = 1;
    }

    public SearchPoiPager(String key, int searchMode, int searchRange, int countPerPager, int netMode) {
        this.mPagerNum = 1;
        this.mSearchType = 6;
        this.mSearchKey = key;
        this.mSearchMode = searchMode;
        this.mSearchRange = searchRange;
        this.mCountPerPager = countPerPager;
        this.mNetMode = netMode;
        mSortType = 2;
    }

    public SearchPoiPager createNextPager() {
        if (this.isLastPager) {
            return null;
        }
        SearchPoiPager searchPoiPager;
        switch (this.mSearchType) {
            case 1:
                searchPoiPager = new SearchPoiPager(this.mSearchKey, this.mDistrctInfo, this.mCountPerPager, this.mNetMode);
                break;
            case 2:
                searchPoiPager = new SearchPoiPager(this.mSearchKey, this.mSearchCircle, this.mCountPerPager, this.mNetMode);
                break;
            case 3:
                searchPoiPager = new SearchPoiPager(this.mSearchKey, this.mDistrctInfo, this.mSearchCircle, this.mCountPerPager, this.mNetMode);
                break;
            case 4:
                searchPoiPager = new SearchPoiPager(this.mCatalogId, this.mSearchCircle, this.mCountPerPager, this.mNetMode);
                break;
            case 5:
                searchPoiPager = new SearchPoiPager(this.mCatalogId, this.mDistrctInfo, this.mSearchCircle, this.mCountPerPager, this.mNetMode);
                break;
            case 6:
                searchPoiPager = new SearchPoiPager(this.mSearchKey, this.mSearchMode, this.mSearchRange, this.mCountPerPager, this.mNetMode);
                break;
            default:
                searchPoiPager = null;
                break;
        }
        if (searchPoiPager == null) {
            return searchPoiPager;
        }
        searchPoiPager.mPrevPager = this;
        searchPoiPager.mPagerNum = this.mPagerNum + 1;
        this.mNextPager = searchPoiPager;
        return searchPoiPager;
    }

    public void setNetMode(int netMode) {
        this.mNetMode = netMode;
    }

    public ArrayList<SearchPoi> getPoiList() {
        if (mSortType != 2 || this.mSearchType == 6) {
            return this.mPoiList;
        }
        if (this.mDistanceSortList == null && this.mPoiList != null) {
            this.mDistanceSortList = new ArrayList(getCountPerPager());
            int i = 0;
            while (i < getCountPerPager() && i < this.mPoiList.size()) {
                this.mDistanceSortList.add(this.mPoiList.get(i));
                i++;
            }
            GeoPoint center = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getMyPositionGeo();
            if (center != null && center.isValid()) {
                BNPoiSearcher.getInstance().quickSortByDistance(center, this.mDistanceSortList);
            }
            if (this.mPoiList.size() > getCountPerPager()) {
                for (i = 0; i < this.mPoiList.size() - getCountPerPager(); i++) {
                    this.mDistanceSortList.add(this.mPoiList.get(getCountPerPager() + i));
                }
            }
        }
        return this.mDistanceSortList;
    }

    public void setPoiList(ArrayList<SearchPoi> poiList) {
        if (this.mPoiList == null || poiList == null) {
            this.mPoiList = poiList;
        } else {
            this.mPoiList.addAll(poiList);
        }
    }

    public boolean isLastPager() {
        if (this.mPoiList == null) {
            return true;
        }
        return this.isLastPager;
    }

    public void setLastPager(boolean isLastPager) {
        this.isLastPager = isLastPager;
    }

    public int getPagerNum() {
        return this.mPagerNum;
    }

    public int getCountPerPager() {
        return this.mCountPerPager;
    }

    public DistrictInfo getDistrct() {
        return this.mDistrctInfo;
    }

    public int getNetMode() {
        return this.mNetMode;
    }

    public int getSearchType() {
        return this.mSearchType;
    }

    public String getSearchKey() {
        return this.mSearchKey;
    }

    public SearchCircle getSearchCircle() {
        return this.mSearchCircle;
    }

    public int getCatalogId() {
        return this.mCatalogId;
    }

    public int getSearchRange() {
        return this.mSearchRange;
    }

    public int getSearchMode() {
        return this.mSearchMode;
    }

    public void addSearchPoi(Object obj) {
        if (obj != null && (obj instanceof SearchPoi)) {
            if (this.mPoiList == null) {
                this.mPoiList = new ArrayList();
            }
            this.mPoiList.add((SearchPoi) obj);
        }
    }

    public SearchPoiPager getPrevPager() {
        return this.mPrevPager;
    }

    public SearchPoiPager getNextPager() {
        return this.mNextPager;
    }

    public void clearPoiPager() {
        this.mPoiList.clear();
    }

    public boolean isVail() {
        switch (this.mSearchType) {
            case 1:
                if (TextUtils.isEmpty(this.mSearchKey)) {
                    return false;
                }
                return true;
            case 2:
                if (TextUtils.isEmpty(this.mSearchKey) || this.mSearchCircle == null || this.mSearchCircle.mCenter == null) {
                    return false;
                }
                return true;
            case 3:
                if (TextUtils.isEmpty(this.mSearchKey) || this.mSearchCircle == null || this.mSearchCircle.mCenter == null) {
                    return false;
                }
                return true;
            case 4:
                if (this.mSearchCircle == null || this.mSearchCircle.mCenter == null) {
                    return false;
                }
                return true;
            case 5:
                if (this.mSearchCircle == null || this.mSearchCircle.mCenter == null) {
                    return false;
                }
                return true;
            case 6:
                if (TextUtils.isEmpty(this.mSearchKey)) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public void setCountPerPager(int countPerPager) {
        this.mCountPerPager = countPerPager;
    }

    public void setDistrict(DistrictInfo districtInfo) {
        this.mDistrctInfo = districtInfo;
    }

    public void setSortType(int sortType) {
        mSortType = sortType;
    }

    public int getSortType() {
        return mSortType;
    }

    public void setParPoiSize(int parPoiSize) {
        this.mParPoiSize = parPoiSize;
    }

    public int getParPoiSize() {
        return this.mParPoiSize;
    }

    public void setPageCnt(int pageCnt) {
        this.mPageCnt = pageCnt;
    }

    public int getPageCnt() {
        return this.mPageCnt;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.mCurrentPageNum = currentPageNum;
        if (this.mCurrentPageNum == this.mPageCnt) {
            this.isLastPager = true;
        } else {
            this.isLastPager = false;
        }
    }

    public int getCurrentPageNum() {
        return this.mCurrentPageNum;
    }

    public SearchPoiPager copy() {
        SearchPoiPager searchPoiPager = new SearchPoiPager();
        searchPoiPager.isLastPager = this.isLastPager;
        searchPoiPager.mCatalogId = this.mCatalogId;
        searchPoiPager.mCountPerPager = this.mCountPerPager;
        searchPoiPager.mDistrctInfo = this.mDistrctInfo;
        searchPoiPager.mNetMode = this.mNetMode;
        searchPoiPager.mNextPager = null;
        searchPoiPager.mPagerNum = this.mPagerNum;
        searchPoiPager.mPrevPager = null;
        searchPoiPager.mSearchCircle = this.mSearchCircle;
        searchPoiPager.mSearchKey = this.mSearchKey;
        searchPoiPager.mSearchType = this.mSearchType;
        searchPoiPager.mSearchMode = this.mSearchMode;
        searchPoiPager.mSearchRange = this.mSearchRange;
        return searchPoiPager;
    }
}
