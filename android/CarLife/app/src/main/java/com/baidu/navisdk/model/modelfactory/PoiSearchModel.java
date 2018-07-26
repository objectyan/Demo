package com.baidu.navisdk.model.modelfactory;

import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.datastruct.SearchSugData;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class PoiSearchModel extends BaseModel {
    private SearchPoi mAntiGeoPoi = new SearchPoi();
    private GeoPoint mAntiGeoPoint;
    private SearchPoi mMapSearchPoi;
    private ArrayList<SearchParkPoi> mParkPoiList = new ArrayList(0);
    private ArrayList<SearchPoi> mPoiList = new ArrayList();
    private byte[] mSearchPBData = null;
    private List<SearchPoiPager> mSearchPoiPageraList = new ArrayList();
    private SearchPoi mSpaceSearchPoi;
    private ArrayList<SearchSugData> mSugList = new ArrayList();
    private GeoPoint myPositionPoint;

    public void setPoiList(List<SearchPoi> poiList) {
        this.mPoiList.clear();
        if (poiList != null) {
            this.mPoiList.addAll(poiList);
        }
    }

    public List<SearchPoi> getPoiList() {
        return this.mPoiList;
    }

    public void setMyPositionGeo(GeoPoint point) {
        if (point != null) {
            this.myPositionPoint = point;
        }
    }

    public GeoPoint getMyPositionGeo() {
        return this.myPositionPoint;
    }

    public void setSugList(ArrayList<SearchSugData> sugList) {
        this.mSugList.clear();
        if (sugList != null) {
            this.mSugList.addAll(sugList);
        }
    }

    public ArrayList<SearchSugData> getSugList() {
        return this.mSugList;
    }

    public void setAntiGeoPoi(SearchPoi poi) {
        if (poi != null) {
            this.mAntiGeoPoi = new SearchPoi();
            this.mAntiGeoPoi.copy(poi);
        }
    }

    public SearchPoi getAntiGeoPoi() {
        return this.mAntiGeoPoi;
    }

    public void setAntiGeoPoint(GeoPoint geoPt) {
        if (geoPt != null) {
            this.mAntiGeoPoint = geoPt;
        }
    }

    public GeoPoint getAntiGeoPoint() {
        return this.mAntiGeoPoint;
    }

    public SearchPoi getMapSearchPoi() {
        return this.mMapSearchPoi;
    }

    public void setMapSearchPoi(SearchPoi searchPoi) {
        this.mMapSearchPoi = searchPoi;
    }

    public void setSpaceSearchPoi(SearchPoi poi) {
        if (poi != null) {
            this.mSpaceSearchPoi = poi;
        }
    }

    public SearchPoi getSpaceSearchPoi() {
        return this.mSpaceSearchPoi;
    }

    public void addSearchPoiPager(SearchPoiPager searchPoiPager) {
        if (searchPoiPager != null) {
            SearchPoiPager prevPager = searchPoiPager.getPrevPager();
            if (prevPager == null) {
                this.mSearchPoiPageraList.clear();
            } else if (this.mSearchPoiPageraList.size() > 0 && !prevPager.equals((SearchPoiPager) this.mSearchPoiPageraList.get(this.mSearchPoiPageraList.size() - 1))) {
                this.mSearchPoiPageraList.clear();
            }
            this.mSearchPoiPageraList.add(searchPoiPager);
        }
    }

    public List<SearchPoiPager> getSearchPoiPagerList() {
        return this.mSearchPoiPageraList;
    }

    public void setSearchParkPoi(ArrayList<SearchParkPoi> poiList) {
        this.mParkPoiList.clear();
        if (poiList != null) {
            this.mParkPoiList.addAll(poiList);
        }
    }

    public ArrayList<SearchParkPoi> getSearchParkPoi() {
        return this.mParkPoiList;
    }

    public void clearSearchParkPoi() {
        if (this.mParkPoiList != null) {
            try {
                this.mParkPoiList.clear();
            } catch (Exception e) {
            }
        }
    }

    public void setSearchPBData(byte[] searchPBData) {
        this.mSearchPBData = searchPBData;
    }

    public byte[] getSearchPBData() {
        return this.mSearchPBData;
    }
}
