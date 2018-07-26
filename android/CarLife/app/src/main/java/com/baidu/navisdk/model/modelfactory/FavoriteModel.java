package com.baidu.navisdk.model.modelfactory;

import android.os.Bundle;
import com.baidu.navisdk.jni.control.FavoriteControlBundle;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.Point;
import java.util.ArrayList;

public class FavoriteModel extends BaseModel {
    private static final String TAG = "Favorite";
    private int mFavCount;
    private ArrayList<FavoritePoiInfo> mFavDataList;
    private SearchPoi mFavSearchPoi;

    private static class LayerHolder {
        private static final FavoriteModel mInstance = new FavoriteModel();

        private LayerHolder() {
        }
    }

    private FavoriteModel() {
        this.mFavDataList = new ArrayList();
        this.mFavCount = 0;
        this.mFavSearchPoi = null;
    }

    public static FavoriteModel getInstance() {
        return LayerHolder.mInstance;
    }

    public SearchPoi getFavoriteSearchPoi() {
        return this.mFavSearchPoi;
    }

    public void setFavoriteSearchPoi(SearchPoi poi) {
        this.mFavSearchPoi = poi;
    }

    public ArrayList<FavoritePoiInfo> getFavDataList() {
        return this.mFavDataList;
    }

    public synchronized void setFavDataList(ArrayList<FavoritePoiInfo> dataList) {
        clearFavDataList();
        this.mFavDataList.addAll(dataList);
    }

    public int getFavCount() {
        return this.mFavCount;
    }

    public void setFavCount(int count) {
        this.mFavCount = count;
    }

    public void clearFavDataList() {
        if (this.mFavDataList != null) {
            this.mFavDataList.clear();
        }
    }

    public void addNewFavPoiToMemList(FavoritePoiInfo favPoiInfo) {
        if (this.mFavDataList == null) {
            this.mFavDataList = new ArrayList();
        }
        this.mFavDataList.add(favPoiInfo);
        if (this.mFavCount == 0) {
            this.mFavCount = FavoriteControlBundle.getInstance().getPOICnt();
        } else {
            this.mFavCount++;
        }
    }

    public void removeFavPoiFromMemList(String key) {
        if (!StringUtils.isEmpty(key)) {
            for (int i = 0; i < this.mFavDataList.size(); i++) {
                if (key.equals(((FavoritePoiInfo) this.mFavDataList.get(i)).mFavKey)) {
                    this.mFavDataList.remove(i);
                    break;
                }
            }
            if (this.mFavCount > 0) {
                this.mFavCount--;
            }
        }
    }

    public boolean isPoiExistInMemListByGeoPoint(GeoPoint point) {
        if (point == null || !point.isValid()) {
            return false;
        }
        for (int i = 0; i < this.mFavDataList.size(); i++) {
            FavoritePoiInfo data = (FavoritePoiInfo) this.mFavDataList.get(i);
            if (data != null) {
                Point mcViewPoint = data.mViewPoint;
                Bundle mcBundle = CoordinateTransformUtil.MC2LLE6(mcViewPoint.f19727x, mcViewPoint.f19728y);
                GeoPoint tempPoint = new GeoPoint(mcBundle.getInt("LLx"), mcBundle.getInt("LLy"));
                if (Math.abs(tempPoint.getLatitudeE6() - point.getLatitudeE6()) <= 5 && Math.abs(tempPoint.getLongitudeE6() - point.getLongitudeE6()) <= 5) {
                    LogUtil.m15791e("Favorite", "坐标相等");
                    return true;
                }
            }
        }
        return false;
    }

    public FavoritePoiInfo getFavPoiInfoFromMemListByKey(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        for (int i = 0; i < this.mFavDataList.size(); i++) {
            FavoritePoiInfo data = (FavoritePoiInfo) this.mFavDataList.get(i);
            if (key.equals(data.mFavKey)) {
                return data;
            }
        }
        return null;
    }
}
