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
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.SearchStatItem;
import java.util.ArrayList;
import java.util.Locale;

public class CmdSearchByKey extends CommandBase implements JNISearchConst {
    Integer mDistrictId;
    String mKey;
    Integer mNetMode;
    Integer mPoiCount;
    ArrayList<SearchPoi> mPoiList = new ArrayList();

    public static void packetParams(ReqData reqdata, String key, int districtId, int poiCount, int netMode) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY, key);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID, Integer.valueOf(districtId));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netMode));
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mKey = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY);
        this.mDistrictId = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID);
        this.mPoiCount = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT);
        this.mNetMode = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE);
    }

    protected CommandResult exec() {
        boolean z;
        boolean z2 = true;
        SearchStatItem statItem = SearchStatItem.getInstance();
        statItem.init();
        long startTime = SystemClock.elapsedRealtime();
        int ret = nameSearchByKey(this.mKey, this.mDistrictId.intValue(), this.mPoiCount.intValue(), this.mNetMode.intValue(), this.mPoiList);
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

    public int nameSearchByKey(String key, int districtId, int poiCount, int netMode, ArrayList<SearchPoi> poiList) {
        if (key == null || poiList == null) {
            return -1;
        }
        if (key.length() <= 0) {
            return -2;
        }
        Bundle input = new Bundle();
        input.putString("Name", key.toUpperCase(Locale.getDefault()));
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtId));
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
