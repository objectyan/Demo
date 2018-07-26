package com.baidu.navisdk.model.datastruct;

import com.baidu.carlife.C0965R;
import com.baidu.navi.style.StyleManager;
import com.baidu.nplatform.comapi.basestruct.Point;

public class FavoritePoiInfo {
    public String mFavAddTime = "";
    public String mFavAddr = StyleManager.getString(C0965R.string.poi_address_defalut);
    public String mFavAlias = "";
    public int mFavCityId = -1;
    public String mFavCityName = "";
    public boolean mFavHasSync = false;
    public String mFavKey = "";
    public String mFavName = StyleManager.getString(C0965R.string.poi_on_map);
    public String mPhone = "";
    public String mPoiDesc;
    public String mPoiId = "";
    public int mPoiType;
    public Point mViewPoint = new Point();

    public void setValue(FavoritePoiInfo data) {
        this.mPoiId = data.mPoiId;
        this.mPoiType = data.mPoiType;
        this.mFavCityId = data.mFavCityId;
        this.mFavKey = data.mFavKey;
        this.mFavName = data.mFavName;
        this.mFavAlias = data.mFavAlias;
        this.mFavAddr = data.mFavAddr;
        this.mFavCityName = data.mFavCityName;
        this.mPhone = data.mPhone;
        this.mViewPoint.setmPtx(data.mViewPoint.f19727x);
        this.mViewPoint.setmPty(data.mViewPoint.f19728y);
        this.mFavAddTime = data.mFavAddTime;
        this.mFavHasSync = data.mFavHasSync;
    }

    public String toString() {
        return "mFavKey=" + this.mFavKey + ", mFavName=" + this.mFavName + ", mFavAddr=" + this.mFavAddr + ", mFavCityName=" + this.mFavCityName + "mViewPoint.lon=" + this.mViewPoint.f19727x + "mViewPoint.lat=" + this.mViewPoint.f19728y;
    }

    public boolean equals(Object o) {
        if (o instanceof FavoritePoiInfo) {
            if (this.mFavKey.equals(((FavoritePoiInfo) o).mFavKey)) {
                return true;
            }
        }
        return false;
    }
}
