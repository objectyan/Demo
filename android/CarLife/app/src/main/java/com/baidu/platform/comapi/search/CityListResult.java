package com.baidu.platform.comapi.search;

import java.util.ArrayList;

public class CityListResult {
    private ArrayList<Citys> mCities;
    private int mCityCount;
    private CityInfo mCityInfo;
    public boolean mCurrent_null;
    public int mResultType;
    private ArrayList<String> mSuggestQueries;

    public class Citys {
        public String extinfo;
        public int mCode;
        public String mName;
        public int mNum;
        public ArrayList<Pois> poiList;
        public int poiNum;
        public String searchquery;
        public int type;
        public String viewName;
    }

    public class Pois {
        public String addr;
        public String bid;
        public int citycode;
        public String name;
        public String searchpoi;
        public String stdtag;
    }

    public ArrayList<String> getSuggestQueries() {
        return this.mSuggestQueries;
    }

    public void setCityCount(int cityCount) {
        this.mCityCount = cityCount;
    }

    public int getCityCount() {
        return this.mCityCount;
    }

    public void setCityinfo(CityInfo cityInfo) {
        this.mCityInfo = cityInfo;
    }

    public CityInfo getCityInfo() {
        return this.mCityInfo;
    }

    public void setCitys(ArrayList<Citys> citys) {
        this.mCities = citys;
    }

    public void setSuggestQueries(ArrayList<String> sugs) {
        this.mSuggestQueries = sugs;
    }

    public ArrayList<Citys> getCitys() {
        return this.mCities;
    }
}
