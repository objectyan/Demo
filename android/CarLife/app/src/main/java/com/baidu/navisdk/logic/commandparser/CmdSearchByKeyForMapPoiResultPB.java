package com.baidu.navisdk.logic.commandparser;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Locale;

public class CmdSearchByKeyForMapPoiResultPB extends CommandBase implements JNISearchConst {
    SearchCircle mCircle;
    Bundle mDataBundle = null;
    int mDistrictID;
    String mName;
    int mPageNumber;
    int mPoiCount;

    public static void packetParams(ReqData reqdata, String name, int districtID, SearchCircle circle, int poiCount, int pageNumber) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY, name);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID, Integer.valueOf(districtID));
        if (circle != null) {
            reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE, circle);
        }
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGERNUM, Integer.valueOf(pageNumber));
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mName = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY);
        this.mDistrictID = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID)).intValue();
        if (reqdata.mParams.containsKey(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE)) {
            this.mCircle = (SearchCircle) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_CIRCLE);
        } else {
            this.mCircle = null;
        }
        this.mPoiCount = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT)).intValue();
        this.mPageNumber = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGERNUM)).intValue();
    }

    protected CommandResult exec() {
        this.mDataBundle = new Bundle();
        int ret = nameSearchByKeyForMapPoiResultPB(this.mName, this.mDistrictID, this.mCircle, this.mPoiCount, this.mPageNumber, this.mDataBundle);
        if (ret >= 0) {
            this.mRet.setSuccess();
        } else {
            this.mRet.set(ret);
        }
        return this.mRet;
    }

    protected void handleSuccess() {
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mDataBundle);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected void handleError() {
        super.handleError();
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = -1;
            msg.obj = new RspData(this.mReqData, this.mDataBundle);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    public int nameSearchByKeyForMapPoiResultPB(String key, int districtId, SearchCircle circle, int poiCount, int pageNumber, Bundle data) {
        if (key == null) {
            return -1;
        }
        if (key.length() <= 0) {
            return -2;
        }
        Bundle input = new Bundle();
        input.putString("Name", key.toUpperCase(Locale.getDefault()));
        input.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtId));
        if (circle != null) {
            input.putInt("HasCircle", 1);
            input.putInt("CenterX", circle.mCenter.getLongitudeE6());
            input.putInt("CenterY", circle.mCenter.getLatitudeE6());
            input.putInt("Radius", circle.mRadius);
        }
        input.putInt("PoiCount", poiCount);
        input.putInt(JNISearchConst.JNI_POI_PAGERNUM, pageNumber);
        int ret = JNISearchControl.sInstance.searchByNameForMapPoiResultPB(input, data);
        LogUtil.m15791e("", "nameSearchByKeyForMapPoiResultPB() ret: " + ret);
        if (ret < 0) {
            return -4;
        }
        return ret;
    }
}
