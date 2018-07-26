package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CmdSearchWithPager extends CommandBase implements JNISearchConst {
    SearchPoiPager mSearchPoiPager;

    public static void packetParams(ReqData reqdata, SearchPoiPager searchPoiPager) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGER, searchPoiPager);
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mSearchPoiPager = (SearchPoiPager) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGER);
    }

    protected CommandResult exec() {
        boolean z;
        boolean z2 = true;
        SearchStatItem statItem = SearchStatItem.getInstance();
        statItem.init();
        long startTime = SystemClock.elapsedRealtime();
        int ret = searchWithPager(this.mSearchPoiPager);
        if (ret >= 0) {
            this.mRet.setSuccess();
        } else {
            this.mRet.set(ret);
        }
        if (ret >= 0) {
            z = true;
        } else {
            z = false;
        }
        statItem.mSearchSucc = z;
        int netMode = BNPoiSearcher.getInstance().getSearchNetworkMode();
        statItem.setSearchType(netMode);
        statItem.setResponseTime(SystemClock.elapsedRealtime() - startTime);
        statItem.onEvent();
        BNPoiSearcher instance = BNPoiSearcher.getInstance();
        if (ret < 0) {
            z2 = false;
        }
        instance.mtjStatSearch(netMode, z2);
        return this.mRet;
    }

    protected void handleSuccess() {
        PoiSearchModel poiSearchModel = (PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH);
        List<SearchPoi> poiList = this.mSearchPoiPager.getPoiList();
        if (poiSearchModel != null && poiList != null && poiList.size() > 0) {
            poiSearchModel.addSearchPoiPager(this.mSearchPoiPager);
        }
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mSearchPoiPager);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    public int searchWithPager(SearchPoiPager searchPoiPager) {
        if (searchPoiPager == null || !searchPoiPager.isVail()) {
            return -1;
        }
        Bundle input = null;
        switch (searchPoiPager.getSearchType()) {
            case 1:
                input = getNameSearchByKeyBundle(searchPoiPager);
                break;
            case 2:
                input = getSpaceSearchByKeyBundle(searchPoiPager);
                break;
            case 3:
                input = getSpaceSearchByKeyWithDistrictIdBundle(searchPoiPager);
                break;
            case 4:
                input = getSpaceSearchByCatalogBundle(searchPoiPager);
                break;
            case 5:
                input = getSpaceSearchByCatalogWithDistrictIdBundle(searchPoiPager);
                break;
            case 6:
                input = getNameSearchByKeyWithRouteBundle(searchPoiPager);
                break;
        }
        if (input == null) {
            return -3;
        }
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = 0;
        switch (searchPoiPager.getSearchType()) {
            case 1:
                ret = JNISearchControl.sInstance.searchByNameWithPager(input, outputList);
                break;
            case 2:
                ret = JNISearchControl.sInstance.searchByNameWithPager(input, outputList);
                break;
            case 3:
                ret = JNISearchControl.sInstance.searchByNameWithPager(input, outputList);
                break;
            case 4:
                ret = JNISearchControl.sInstance.searchByCircleWithPager(input, outputList);
                break;
            case 5:
                ret = JNISearchControl.sInstance.searchByCircleWithPager(input, outputList);
                break;
            case 6:
                ret = JNISearchControl.sInstance.searchByKeyInRouteWithPager(input, outputList);
                break;
        }
        LogUtil.m15791e("", "searchByName() ret: " + ret);
        LogUtil.m15791e("", "outputList count: " + outputList.size());
        if (ret < 0) {
            return -4;
        }
        int outputSize = outputList.size();
        for (int i = 0; i < outputSize; i++) {
            SearchPoi poi = JNISearchControl.sInstance.parsePoiBundle((Bundle) outputList.get(i));
            if (poi != null) {
                searchPoiPager.addSearchPoi(poi);
            }
        }
        boolean isLastPager = false;
        if (outputSize > 0) {
            if (((Bundle) outputList.get(0)).getInt("IsLastPager", 0) > 0) {
                isLastPager = true;
            } else {
                isLastPager = false;
            }
        }
        searchPoiPager.setLastPager(isLastPager);
        return outputSize;
    }

    private Bundle getNameSearchByKeyBundle(SearchPoiPager searchPoiPager) {
        Bundle input = new Bundle();
        input.putString("Name", searchPoiPager.getSearchKey().toUpperCase(Locale.getDefault()));
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(searchPoiPager.getDistrct()));
        int count = searchPoiPager.getCountPerPager();
        if (searchPoiPager.getNetMode() == 1) {
            count = Math.min(count, 20);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, searchPoiPager.getPagerNum());
        return input;
    }

    private Bundle getSpaceSearchByKeyWithDistrictIdBundle(SearchPoiPager searchPoiPager) {
        Bundle input = new Bundle();
        input.putString("Name", searchPoiPager.getSearchKey().toUpperCase(Locale.getDefault()));
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(searchPoiPager.getDistrct()));
        input.putInt("HasCircle", 1);
        SearchCircle circle = searchPoiPager.getSearchCircle();
        input.putInt("CenterX", circle.mCenter.getLongitudeE6());
        input.putInt("CenterY", circle.mCenter.getLatitudeE6());
        input.putInt("Radius", circle.mRadius);
        int count = searchPoiPager.getCountPerPager();
        if (searchPoiPager.getNetMode() == 1) {
            count = Math.min(count, 20);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, searchPoiPager.getPagerNum());
        return input;
    }

    private Bundle getSpaceSearchByKeyBundle(SearchPoiPager searchPoiPager) {
        Bundle input = new Bundle();
        SearchCircle circle = searchPoiPager.getSearchCircle();
        int netMode = searchPoiPager.getNetMode();
        DistrictInfo district = JNISearchControl.sInstance.getDistrictByPoint(circle.mCenter, netMode);
        if (district == null || (district.mType != 2 && district.mType != 3)) {
            return null;
        }
        input.putString("Name", searchPoiPager.getSearchKey().toUpperCase(Locale.getDefault()));
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(district));
        input.putInt("HasCircle", 1);
        input.putInt("CenterX", circle.mCenter.getLongitudeE6());
        input.putInt("CenterY", circle.mCenter.getLatitudeE6());
        input.putInt("Radius", circle.mRadius);
        int count = searchPoiPager.getCountPerPager();
        if (netMode == 1) {
            count = Math.min(count, 20);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, searchPoiPager.getPagerNum());
        return input;
    }

    private Bundle getNameSearchByKeyWithRouteBundle(SearchPoiPager searchPoiPager) {
        Bundle input = new Bundle();
        input.putString("Name", searchPoiPager.getSearchKey().toUpperCase(Locale.getDefault()));
        input.putInt(JNISearchConst.JNI_MODE, searchPoiPager.getSearchMode());
        input.putInt("Range", searchPoiPager.getSearchRange());
        int sortType = searchPoiPager.getSortType();
        if (sortType < 1 || sortType > 3) {
            sortType = 1;
        }
        input.putInt(JNISearchConst.JNI_SORT, sortType);
        int count = searchPoiPager.getCountPerPager();
        if (searchPoiPager.getNetMode() == 1) {
            count = Math.min(count, 30);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, searchPoiPager.getPagerNum());
        return input;
    }

    private Bundle getSpaceSearchByCatalogWithDistrictIdBundle(SearchPoiPager searchPoiPager) {
        Bundle input = new Bundle();
        input.putInt("CatalogId", searchPoiPager.getCatalogId());
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(searchPoiPager.getDistrct()));
        input.putInt("HasCircle", 1);
        SearchCircle circle = searchPoiPager.getSearchCircle();
        input.putInt("CenterX", circle.mCenter.getLongitudeE6());
        input.putInt("CenterY", circle.mCenter.getLatitudeE6());
        input.putInt("Radius", circle.mRadius);
        int count = searchPoiPager.getCountPerPager();
        if (searchPoiPager.getNetMode() == 1) {
            count = Math.min(count, 20);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, searchPoiPager.getPagerNum());
        return input;
    }

    private Bundle getSpaceSearchByCatalogBundle(SearchPoiPager searchPoiPager) {
        SearchCircle circle = searchPoiPager.getSearchCircle();
        int netMode = searchPoiPager.getNetMode();
        DistrictInfo district = JNISearchControl.sInstance.getDistrictByPoint(circle.mCenter, netMode);
        if (district == null || (district.mType != 2 && district.mType != 3)) {
            return null;
        }
        Bundle input = new Bundle();
        input.putInt("CatalogId", searchPoiPager.getCatalogId());
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(district));
        input.putInt("HasCircle", 1);
        input.putInt("CenterX", circle.mCenter.getLongitudeE6());
        input.putInt("CenterY", circle.mCenter.getLatitudeE6());
        input.putInt("Radius", circle.mRadius);
        int count = searchPoiPager.getCountPerPager();
        if (netMode == 1) {
            count = Math.min(count, 20);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, searchPoiPager.getPagerNum());
        return input;
    }

    public int spaceSearchByKeyWithPager(String key, int districtId, SearchCircle circle, int poiCount, int netMode, SearchPoiPager searchPoiPager, int pagerNum) {
        if (key == null || circle == null || searchPoiPager == null) {
            return -1;
        }
        if (key.length() <= 0) {
            return -2;
        }
        if (circle.mCenter == null) {
            return -3;
        }
        Bundle input = new Bundle();
        input.putString("Name", key.toUpperCase(Locale.getDefault()));
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtId));
        input.putInt("HasCircle", 1);
        input.putInt("CenterX", circle.mCenter.getLongitudeE6());
        input.putInt("CenterY", circle.mCenter.getLatitudeE6());
        input.putInt("Radius", circle.mRadius);
        int count = poiCount;
        if (netMode == 1) {
            count = Math.min(count, 20);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, pagerNum);
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = JNISearchControl.sInstance.searchByNameWithPager(input, outputList);
        LogUtil.m15791e("", "searchByName() ret: " + ret);
        LogUtil.m15791e("", "outputList count: " + outputList.size());
        if (ret < 0) {
            return -5;
        }
        int outputSize = outputList.size();
        for (int i = 0; i < outputSize; i++) {
            SearchPoi poi = JNISearchControl.sInstance.parsePoiBundle((Bundle) outputList.get(i));
            if (poi != null) {
                searchPoiPager.addSearchPoi(poi);
            }
        }
        boolean isLastPager = false;
        if (outputSize > 0) {
            isLastPager = ((Bundle) outputList.get(0)).getInt("IsLastPager", 0) > 0;
        }
        searchPoiPager.setLastPager(isLastPager);
        return outputSize;
    }

    public int spaceSearchByKeyWithPager(String key, SearchCircle circle, int poiCount, int netMode, SearchPoiPager searchPoiPager, int pagerNum) {
        if (key == null || circle == null || searchPoiPager == null) {
            return -1;
        }
        if (key.length() <= 0) {
            return -2;
        }
        if (circle.mCenter == null) {
            return -3;
        }
        DistrictInfo district = JNISearchControl.sInstance.getDistrictByPoint(circle.mCenter, netMode);
        if (district == null || (district.mType != 2 && district.mType != 3)) {
            return -5;
        }
        Bundle input = new Bundle();
        input.putString("Name", key.toUpperCase(Locale.getDefault()));
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(district.mId));
        input.putInt("HasCircle", 1);
        input.putInt("CenterX", circle.mCenter.getLongitudeE6());
        input.putInt("CenterY", circle.mCenter.getLatitudeE6());
        input.putInt("Radius", circle.mRadius);
        int count = poiCount;
        if (netMode == 1) {
            count = Math.min(count, 20);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, pagerNum);
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = JNISearchControl.sInstance.searchByNameWithPager(input, outputList);
        LogUtil.m15791e("", "searchByName() ret: " + ret);
        LogUtil.m15791e("", "outputList count: " + outputList.size());
        if (ret < 0) {
            return -6;
        }
        int outputSize = outputList.size();
        for (int i = 0; i < outputSize; i++) {
            SearchPoi poi = JNISearchControl.sInstance.parsePoiBundle((Bundle) outputList.get(i));
            if (poi != null) {
                searchPoiPager.addSearchPoi(poi);
            }
        }
        boolean isLastPager = false;
        if (outputSize > 0) {
            isLastPager = ((Bundle) outputList.get(0)).getInt("IsLastPager", 0) > 0;
        }
        searchPoiPager.setLastPager(isLastPager);
        return outputSize;
    }

    public int spaceSearchByCatalogWith(int catalogId, int districtId, SearchCircle circle, int poiCount, int netMode, ArrayList<SearchPoi> poiList, int pagerNum) {
        if (circle == null || poiList == null) {
            return -1;
        }
        if (circle.mCenter == null) {
            return -2;
        }
        Bundle input = new Bundle();
        input.putInt("CatalogId", catalogId);
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtId));
        input.putInt("HasCircle", 1);
        input.putInt("CenterX", circle.mCenter.getLongitudeE6());
        input.putInt("CenterY", circle.mCenter.getLatitudeE6());
        input.putInt("Radius", circle.mRadius);
        int count = poiCount;
        if (netMode == 1) {
            count = Math.min(count, 20);
        } else {
            count = Math.min(count, 100);
        }
        input.putInt("PoiCount", count);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, pagerNum);
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = JNISearchControl.sInstance.searchByCircle(input, outputList);
        LogUtil.m15791e("", "searchByCircle() ret: " + ret);
        LogUtil.m15791e("", "outputList count: " + outputList.size());
        if (ret < 0) {
            return -4;
        }
        int outputSize = outputList.size();
        for (int i = 0; i < outputSize; i++) {
            ArrayList<SearchPoi> arrayList = poiList;
            arrayList.add(JNISearchControl.sInstance.parsePoiBundle((Bundle) outputList.get(i)));
        }
        return outputSize;
    }
}
