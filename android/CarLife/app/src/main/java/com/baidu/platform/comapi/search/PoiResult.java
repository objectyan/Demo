package com.baidu.platform.comapi.search;

import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class PoiResult {
    @Deprecated
    public boolean accFlag;
    @Deprecated
    public String keyWord = "";
    public int locAttr;
    @Deprecated
    private PoiResult$AddrInfo mAddrInfo = new PoiResult$AddrInfo(this);
    @Deprecated
    private ArrayList<PoiInfo> mArrayPoiInfos;
    @Deprecated
    private ArrayList<PoiInfo> mCenterPt;
    @Deprecated
    private int mCountNum;
    @Deprecated
    private CityInfo mCurrentCity = new CityInfo();
    @Deprecated
    private PlaceParam mPlaceParam = new PlaceParam();
    @Deprecated
    private PoiResult$PyCorrect mPy_correct = new PoiResult$PyCorrect(this);
    @Deprecated
    public String mStrFrom;
    @Deprecated
    private PoiResult$SuggestResult mSuggest_query = new PoiResult$SuggestResult(this);
    @Deprecated
    private int mTotalNum;
    public boolean op_addr;
    public boolean op_gel;
    public String qId;
    @Deprecated
    public int radius;
    public int resultType;
    public String rp_strategy;
    @Deprecated
    public String strategy;

    public class ComplexBannerInfo {
        public String actText;
        public String actUrl;
        public String description;
        public String image;
        public String score;
        @Deprecated
        public String star;
        public String title;
    }

    public class PlaceParam {
        public String businessId;
        public String businessType;
        public int filterShowFlag;
        public PoiResult$BannerInfo mBannerInfo = null;
        public ComplexBannerInfo mComplexBannerInfo = null;
        public PoiResult$SearchExt[] mSearchExts = null;
        @Deprecated
        public String mSpecSrc = null;
        public String sortKey;
        public int sortRule;
        public String type;
    }

    public class PoiInfo {
        public static final int POI_TYPE_ADDR = 5;
        public static final int POI_TYPE_BUS_LINE = 2;
        public static final int POI_TYPE_BUS_STATION = 1;
        public static final int POI_TYPE_COMMON = 0;
        public static final int POI_TYPE_FAVS = 11;
        public static final int POI_TYPE_RGC = 10;
        public static final int POI_TYPE_RGC_ADDR = 9;
        public static final int POI_TYPE_SUBWAY_LINE = 4;
        public static final int POI_TYPE_SUBWAY_STATION = 3;
        public int accFlag;
        public String addr;
        @Deprecated
        public boolean detail;
        @Deprecated
        public int distance;
        public String endTime;
        public int has_rtbus;
        public String indoorPano;
        public String name;
        public int pano;
        public HashMap<String, Object> placeParam = new HashMap();
        public int poiType;
        public String poi_type_text;
        public Point pt;
        public ArrayList<String> rec_reason;
        @Deprecated
        public String rp_des;
        public int rtbus_update_time;
        @Deprecated
        public String sep_char;
        public PoiResult$PoiShowTemplet showTemplet;
        public String startTime;
        public String telephone;
        public String tip_rtbus;
        public String uid;
    }

    public void setTotalNum(int totalNum) {
        this.mTotalNum = totalNum;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    public void setCountNum(int countNum) {
        this.mCountNum = countNum;
    }

    public int getCountNum() {
        return this.mCountNum;
    }

    void setAddrInfo(PoiResult$AddrInfo addrinfo) {
        this.mAddrInfo = addrinfo;
    }

    public PoiResult$AddrInfo getAddrInfo() {
        if (this.mAddrInfo != null) {
            return this.mAddrInfo;
        }
        return null;
    }

    void setPy_correct(PoiResult$PyCorrect py_correct) {
        this.mPy_correct = py_correct;
    }

    public PoiResult$PyCorrect getPy_correct() {
        if (this.mPy_correct != null) {
            return this.mPy_correct;
        }
        return null;
    }

    void setSuggest_query(PoiResult$SuggestResult suggest_query) {
        this.mSuggest_query = suggest_query;
    }

    public PoiResult$SuggestResult getSuggest_query() {
        if (this.mSuggest_query != null) {
            return this.mSuggest_query;
        }
        return null;
    }

    void setCurrentCity(CityInfo currentCity) {
        this.mCurrentCity = currentCity;
    }

    public CityInfo getCurrentCity() {
        if (this.mCurrentCity != null) {
            return this.mCurrentCity;
        }
        return CityInfo.DEFAULT_CITYINFO;
    }

    void setPlaceParam(PlaceParam placeParam) {
        this.mPlaceParam = placeParam;
    }

    public PlaceParam getPlaceParam() {
        if (this.mPlaceParam != null) {
            return this.mPlaceParam;
        }
        return null;
    }

    public void setPoiInfos(ArrayList<PoiInfo> poiInfo) {
        this.mArrayPoiInfos = poiInfo;
    }

    public ArrayList<PoiInfo> getAllPois() {
        if (this.mArrayPoiInfos == null || this.mArrayPoiInfos.size() <= 0) {
            return null;
        }
        return this.mArrayPoiInfos;
    }

    void setCenterPoints(ArrayList<PoiInfo> centerPt) {
        this.mCenterPt = centerPt;
    }

    public ArrayList<PoiInfo> getCenterPoints() {
        return this.mCenterPt;
    }
}
