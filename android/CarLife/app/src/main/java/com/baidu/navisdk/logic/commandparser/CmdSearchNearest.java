package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.CommonParams.Const.ModelName;
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
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Locale;

public class CmdSearchNearest extends CommandBase implements JNISearchConst {
    Integer mCatalogId;
    SearchCircle mCircle;
    Integer mDistrictId;
    String mKey;
    Integer mNetMode;
    Integer mPoiCount;
    ArrayList<SearchPoi> mPoiList = new ArrayList();

    public static void packetParams(ReqData reqdata, String key, int districtId, SearchCircle circle, int poiCount, int netMode) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY, key);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID, Integer.valueOf(districtId));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE, circle);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netMode));
    }

    public static void packetParams(ReqData reqdata, String key, SearchCircle circle, int poiCount, int netMode) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY, key);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE, circle);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netMode));
    }

    public static void packetParams(ReqData reqdata, int catalogId, int districtId, SearchCircle circle, int poiCount, int netMode) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CATALOGID, Integer.valueOf(catalogId));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID, Integer.valueOf(districtId));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE, circle);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netMode));
    }

    public static void packetParams(ReqData reqdata, int catalogId, SearchCircle circle, int poiCount, int netMode) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CATALOGID, Integer.valueOf(catalogId));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE, circle);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netMode));
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mKey = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY);
        this.mCatalogId = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CATALOGID);
        this.mDistrictId = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID);
        this.mCircle = (SearchCircle) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE);
        this.mPoiCount = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT);
        this.mNetMode = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE);
    }

    protected CommandResult exec() {
        int ret;
        if (this.mKey != null) {
            if (this.mDistrictId != null) {
                ret = spaceSearchByKey(this.mKey, this.mDistrictId.intValue(), this.mCircle, this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
            } else {
                ret = spaceSearchByKey(this.mKey, this.mCircle, this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
            }
        } else if (this.mDistrictId != null) {
            ret = spaceSearchByCatalog(this.mCatalogId.intValue(), this.mDistrictId.intValue(), this.mCircle, this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
        } else {
            ret = spaceSearchByCatalog(this.mCatalogId.intValue(), this.mCircle, this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
        }
        if (ret >= 0) {
            this.mRet.setSuccess();
        } else {
            this.mRet.set(ret);
        }
        return this.mRet;
    }

    protected void handleSuccess() {
        PoiSearchModel poiSearchModel = (PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH);
        if (poiSearchModel != null) {
            poiSearchModel.setPoiList(this.mPoiList);
        }
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mPoiList);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    public int spaceSearchByCatalog(int catalogId, SearchCircle circle, int poiCount, int netMode, ArrayList<SearchPoi> poiList) {
        if (circle == null || poiList == null) {
            return -1;
        }
        if (circle.mCenter == null) {
            return -2;
        }
        DistrictInfo district = JNISearchControl.sInstance.getDistrictByPoint(circle.mCenter, netMode);
        if (district == null || (district.mType != 2 && district.mType != 3)) {
            return -4;
        }
        Bundle input = new Bundle();
        input.putInt("CatalogId", catalogId);
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
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = JNISearchControl.sInstance.searchByCircle(input, outputList);
        LogUtil.m15791e("", "searchByCircle() ret: " + ret);
        LogUtil.m15791e("", "outputList count: " + outputList.size());
        if (ret < 0) {
            return -5;
        }
        int outputSize = outputList.size();
        for (int i = 0; i < outputSize; i++) {
            ArrayList<SearchPoi> arrayList = poiList;
            arrayList.add(JNISearchControl.sInstance.parsePoiBundle((Bundle) outputList.get(i)));
        }
        return outputSize;
    }

    public int spaceSearchByCatalog(int catalogId, int districtId, SearchCircle circle, int poiCount, int netMode, ArrayList<SearchPoi> poiList) {
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

    public int spaceSearchByKey(String key, SearchCircle circle, int poiCount, int netMode, ArrayList<SearchPoi> poiList) {
        if (key == null || circle == null || poiList == null) {
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
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = JNISearchControl.sInstance.searchByName(input, outputList);
        LogUtil.m15791e("", "searchByName() ret: " + ret);
        LogUtil.m15791e("", "outputList count: " + outputList.size());
        if (ret < 0) {
            return -6;
        }
        int outputSize = outputList.size();
        for (int i = 0; i < outputSize; i++) {
            ArrayList<SearchPoi> arrayList = poiList;
            arrayList.add(JNISearchControl.sInstance.parsePoiBundle((Bundle) outputList.get(i)));
        }
        return outputSize;
    }

    public int spaceSearchByKey(String key, int districtId, SearchCircle circle, int poiCount, int netMode, ArrayList<SearchPoi> poiList) {
        if (key == null || circle == null || poiList == null) {
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
        ArrayList<Bundle> outputList = new ArrayList();
        int ret = JNISearchControl.sInstance.searchByName(input, outputList);
        LogUtil.m15791e("", "searchByName() ret: " + ret);
        LogUtil.m15791e("", "outputList count: " + outputList.size());
        if (ret < 0) {
            return -5;
        }
        int outputSize = outputList.size();
        for (int i = 0; i < outputSize; i++) {
            ArrayList<SearchPoi> arrayList = poiList;
            arrayList.add(JNISearchControl.sInstance.parsePoiBundle((Bundle) outputList.get(i)));
        }
        return outputSize;
    }
}
