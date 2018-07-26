package com.baidu.navisdk.logic.commandparser;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.logic.CommandBase;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.ReqData;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.NameValuePair;

public class CmdStatisticsRecord extends CommandBase {
    private static final String JSONKEY_ACTION = "\"act\":";
    private static final String JSONKEY_ACTPARAM = "\"ActParam\":";
    private static final String JSONKEY_BUPARAM = "\"bu\":";
    private static final String JSONKEY_LT = "\"lt\":";
    private static final String JSONKEY_TM = "\"tm\":";
    private static final String TAG = "CmdStatisticsRecord";
    ArrayList<NameValuePair> mActParams;
    int mActionTime;
    ArrayList<NameValuePair> mBuParams;
    Integer mEventId;
    String mLabel;
    String mValue;

    public static void packetParams(ReqData reqdata, int eventId, String value, ArrayList<NameValuePair> actParams, ArrayList<NameValuePair> buParams) {
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_STATISTICS_EVENTID, Integer.valueOf(eventId));
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_STATISTICS_VALUE, value);
        HashMap<String, ArrayList<NameValuePair>> hashMap = new HashMap();
        if (!(actParams == null || actParams.isEmpty())) {
            hashMap.put(NaviStatConstants.STAT_ACT_PARAM, actParams);
        }
        if (!(buParams == null || buParams.isEmpty())) {
            hashMap.put(NaviStatConstants.STAT_BU_PARAM, buParams);
        }
        reqdata.mParams.put(CommandConst.K_COMMAND_PARAM_KEY_STATISTICS_PAIRS, hashMap);
    }

    protected void unpacketParams(ReqData reqdata) {
        this.mEventId = (Integer) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_STATISTICS_EVENTID);
        this.mValue = (String) reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_STATISTICS_VALUE);
        HashMap<String, ArrayList<NameValuePair>> value = reqdata.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_STATISTICS_PAIRS);
        if (value != null && (value instanceof HashMap)) {
            HashMap<String, ArrayList<NameValuePair>> map = value;
            this.mActParams = (ArrayList) map.get(NaviStatConstants.STAT_ACT_PARAM);
            this.mBuParams = (ArrayList) map.get(NaviStatConstants.STAT_BU_PARAM);
        }
    }

    private String getParam(ArrayList<NameValuePair> params) {
        String paramJson = "";
        if (params == null) {
            return paramJson;
        }
        ArrayList<NameValuePair> temp = new ArrayList();
        temp.addAll(new ArrayList(params));
        for (int i = 0; i < temp.size(); i++) {
            paramJson = paramJson + "\"" + ((NameValuePair) temp.get(i)).getName() + "\":\"" + ((NameValuePair) temp.get(i)).getValue().trim() + "\"";
            if (i < temp.size() - 1) {
                paramJson = paramJson + ",";
            }
        }
        if (paramJson.endsWith(",")) {
            paramJson = paramJson.substring(0, paramJson.length() - 1);
        }
        return paramJson;
    }

    protected CommandResult exec() {
        if (this.mValue == null) {
            this.mValue = "1";
        }
        if (this.mEventId == null) {
            return this.mRet;
        }
        String statisticsString = getStatsStr();
        this.mRet.setSuccess();
        return this.mRet;
    }

    private String getStatsStr() {
        String paramJson = getParam(this.mActParams);
        String buJson = getParam(this.mBuParams);
        int actionTime = (int) (System.currentTimeMillis() / 1000);
        this.mActionTime = actionTime;
        return "{\"lt\":" + this.mValue + "," + JSONKEY_TM + actionTime + "," + JSONKEY_ACTION + "\"" + this.mEventId + "\"," + JSONKEY_ACTPARAM + "{" + paramJson + "}" + (!TextUtils.isEmpty(buJson) ? ",\"bu\":{" + buJson + "}" : "") + "}";
    }

    private boolean isNaviSessionStat() throws IllegalArgumentException {
        if (this.mEventId == null) {
            throw new IllegalArgumentException();
        }
        switch (this.mEventId.intValue()) {
            case NaviStatConstants.K_NSC_ACTION_POISEARCH /*50001*/:
            case NaviStatConstants.K_NSC_ACTION_ROUTEPLAN /*50002*/:
            case NaviStatConstants.K_NSC_ACTION_FINISHNAVI /*50003*/:
            case NaviStatConstants.K_NSC_ACTION_SETTING /*50006*/:
            case NaviStatConstants.K_NSC_ACTION_DATAMANAGER /*50007*/:
            case 50008:
                return true;
            default:
                return false;
        }
    }
}
