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
import com.baidu.navisdk.model.datastruct.SearchSugData;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import java.util.ArrayList;
import java.util.Locale;

public class CmdSearchGetSug extends CommandBase implements JNISearchConst {
    Integer mNetMode;
    String mPrefix;
    private ArrayList<SearchSugData> mSugList = new ArrayList();

    public static void packetParams(ReqData reqdata, String prefix, int netMode) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_SUGPREFIX, prefix);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netMode));
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mPrefix = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_SUGPREFIX);
        this.mNetMode = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE);
    }

    protected CommandResult exec() {
        int ret = getInputSug(this.mPrefix, this.mNetMode.intValue(), this.mSugList);
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
            poiSearchModel.setSugList(this.mSugList);
        }
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = 0;
            msg.obj = new RspData(this.mReqData, this.mSugList);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    public int getInputSug(String prefix, int netMode, ArrayList<SearchSugData> sugList) {
        if (prefix == null || sugList == null) {
            return -1;
        }
        int preLength = prefix.length();
        if (preLength <= 0 || preLength > 40) {
            return -2;
        }
        ArrayList<Bundle> outputList = new ArrayList();
        Bundle input = new Bundle();
        input.putString(JNISearchConst.JNI_SUG_PREFIX, prefix.toUpperCase(Locale.getDefault()));
        if (JNISearchControl.sInstance.getInputSug(input, outputList) != 0) {
            return -4;
        }
        int outputSize = outputList.size();
        int sugSize = 0;
        for (int i = 0; i < outputSize; i++) {
            Bundle outputBundle = (Bundle) outputList.get(i);
            String sug = outputBundle.getString(JNISearchConst.JNI_SUG);
            String sugAddr = outputBundle.getString(JNISearchConst.JNI_SUG_ADDR);
            SearchSugData data = new SearchSugData();
            data.setAddress(sugAddr);
            data.setName(sug);
            if (sug != null) {
                sugList.add(data);
                sugSize++;
            }
        }
        return sugSize;
    }
}
