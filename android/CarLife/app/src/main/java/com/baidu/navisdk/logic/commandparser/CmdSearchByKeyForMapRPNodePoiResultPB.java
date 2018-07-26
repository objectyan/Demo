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
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.Locale;

public class CmdSearchByKeyForMapRPNodePoiResultPB extends CommandBase implements JNISearchConst {
    int mDistrictID;
    String mName;
    int mNetMode;
    int mPoiCount;
    HashMap<String, Object> mRetData = null;
    int mRouteNodeCount;
    int mRouteNodeType;
    int mViaRouteNodeIndex;

    public static void packetParams(ReqData reqdata, String name, int districtID, int poiCount, int netMode, int rpNodeCount, int routeNodeType, int viaRouteNodeIndex) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY, name);
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID, Integer.valueOf(districtID));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT, Integer.valueOf(poiCount));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE, Integer.valueOf(netMode));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_ROUTE_NODE_COUNT, Integer.valueOf(rpNodeCount));
        reqdata.mParams.put("route_node_type", Integer.valueOf(routeNodeType));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_VIA_ROUTE_NODE_INDEX, Integer.valueOf(viaRouteNodeIndex));
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mName = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_KEY);
        this.mDistrictID = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_DISTID)).intValue();
        this.mPoiCount = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POICNT)).intValue();
        this.mNetMode = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_NETMODE)).intValue();
        this.mRouteNodeCount = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_ROUTE_NODE_COUNT)).intValue();
        this.mRouteNodeType = ((Integer) reqdata.mParams.get("route_node_type")).intValue();
        this.mViaRouteNodeIndex = ((Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_VIA_ROUTE_NODE_INDEX)).intValue();
    }

    protected CommandResult exec() {
        Bundle bd = new Bundle();
        int ret = nameSearchByKeyForPBData(this.mName, this.mDistrictID, this.mPoiCount, this.mNetMode, this.mRouteNodeCount, this.mRouteNodeType, bd);
        this.mRetData = new HashMap();
        boolean jumpToRoutePlan = false;
        this.mRetData.put("route_node_type", new Integer(this.mRouteNodeType));
        this.mRetData.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_VIA_ROUTE_NODE_INDEX, new Integer(this.mViaRouteNodeIndex));
        if (bd.containsKey(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_JUMP_TO_RP)) {
            jumpToRoutePlan = bd.getInt(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_JUMP_TO_RP) == 1;
        }
        this.mRetData.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_JUMP_TO_RP, new Boolean(jumpToRoutePlan));
        if (jumpToRoutePlan) {
            this.mRetData.put(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_POI, JNISearchControl.sInstance.parsePoiBundle(bd));
        } else if (bd.containsKey("pb_data")) {
            this.mRetData.put("pb_data", bd.getByteArray("pb_data"));
        }
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
            msg.obj = new RspData(this.mReqData, this.mRetData);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    protected void handleError() {
        super.handleError();
        if (!this.mReqData.mHasMsgSent) {
            Message msg = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
            msg.arg1 = -1;
            msg.obj = new RspData(this.mReqData, this.mRetData);
            msg.sendToTarget();
            this.mReqData.mHasMsgSent = true;
        }
    }

    public int nameSearchByKeyForPBData(String key, int districtId, int poiCount, int netMode, int rpNodeCount, int searchRouteNodeType, Bundle data) {
        if (key == null) {
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
        input.putInt(JNISearchConst.JNI_SEARCH_ROUTE_NODE_COUNT, rpNodeCount);
        input.putInt(JNISearchConst.JNI_SEARCH_ROUTE_NODE_TYPE, searchRouteNodeType);
        int ret = JNISearchControl.sInstance.searchByNameForPBData(input, data);
        LogUtil.m15791e("", "searchByName() ret: " + ret);
        if (ret < 0) {
            return -4;
        }
        if (ret > 0) {
            return -ret;
        }
        return ret;
    }
}
