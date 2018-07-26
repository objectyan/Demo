package com.baidu.navisdk.comapi.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.CommandConstants;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.commandparser.CmdStatisticsRecord;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.statistic.BNEngineStatistics;
import com.baidu.navisdk.util.statistic.IBNStatisticsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class BNStatisticsManager implements CommandConst {
    private static final String JSONKEY_ACTION = "\"act\":";
    private static final String JSONKEY_ACTPARAM = "\"ActParam\":";
    private static final String JSONKEY_BUPARAM = "\"bu\":";
    private static final String JSONKEY_LT = "\"lt\":";
    private static final String JSONKEY_TM = "\"tm\":";
    private static final int K_TIMEOUT_STATISTICS = 4000;
    private static final String TAG = "~~Statistic";
    private static BNStatisticsManager mInstance;
    private static IBNStatisticsListener mStatisticsListener = null;
    private HashMap<Integer, Long> mEventStartMap = new HashMap();
    private Handler mHandler = new Handler(CommandCenter.getInstance().getLooper());
    private int mLastMapScale;
    @Deprecated
    private Runnable mStatMapScaleTask = new BNStatisticsManager$1(this);
    JNIStatisticsControl mStatisticsControl = JNIStatisticsControl.sInstance;

    public static BNStatisticsManager getInstance() {
        if (mInstance == null) {
            mInstance = new BNStatisticsManager();
        }
        return mInstance;
    }

    private BNStatisticsManager() {
    }

    public void init() {
        BNEngineStatistics.getInstance().init();
        this.mStatisticsControl.init();
    }

    public void exit() {
        if (BNaviEngineManager.getInstance().isEngineInitSucc()) {
            BNEngineStatistics.destory();
            this.mStatisticsControl.exit();
        }
    }

    public void saveStatistics() {
        NaviStatHelper.writeCacheToFile();
        NaviStatSessionHelper.writeCacheToFile();
    }

    public void setStatisticsListener(IBNStatisticsListener l) {
        mStatisticsListener = l;
    }

    public void onEvent(Context context, String eventId, String label) {
        if (mStatisticsListener != null && context != null) {
            mStatisticsListener.onEvent(context, eventId, label);
        }
    }

    public void onEvent(String eventId, String label) {
        if (mStatisticsListener != null) {
            mStatisticsListener.onEvent(eventId, label);
        }
    }

    public void onEventDuration(Context context, String eventId, String label, int milliseconds) {
        if (mStatisticsListener != null && context != null) {
            mStatisticsListener.onEventDuration(context, eventId, label, milliseconds);
        }
    }

    public void onEventDuration(String eventId, String label, int milliseconds) {
        if (mStatisticsListener != null) {
            mStatisticsListener.onEventDuration(eventId, label, milliseconds);
        }
    }

    @Deprecated
    public void onGestureEvent(String gestureEvent) {
        onGestureEvent(gestureEvent, "1");
    }

    @Deprecated
    private void onGestureEvent(String gestureEvent, String value) {
    }

    public void onEventStart(Context context, int eventId) {
        this.mEventStartMap.put(Integer.valueOf(eventId), Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public void onEventEnd(Context context, int eventId) {
        Long start = (Long) this.mEventStartMap.remove(Integer.valueOf(eventId));
        if (start != null) {
            onEventDuration(context, eventId, (int) (SystemClock.elapsedRealtime() - start.longValue()));
        }
    }

    public void onEventDuration(Context context, int eventId, int milliseconds) {
        ArrayList<NameValuePair> params = new ArrayList();
        params.add(new BasicNameValuePair("duration", milliseconds + ""));
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_STATISTICS_RECORD, 4, this.mHandler, 1101, 4000);
        CmdStatisticsRecord.packetParams(reqdata, eventId, null, params, null);
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    public void onEventWithParam(int eventId, String value, ArrayList<NameValuePair> actParams, ArrayList<NameValuePair> buParams) {
        LogUtil.e(TAG, "event " + eventId + ", actParams {" + paramsToString(actParams) + " }, buParams {" + paramsToString(buParams) + "}");
        if (value == null) {
            value = "1";
        }
        String paramJson = getParam(actParams);
        String buJson = getParam(buParams);
        int actionTime = (int) (System.currentTimeMillis() / 1000);
        CommonHandlerThread.getInstance().sendMessage(12, eventId, actionTime, "{\"lt\":" + value + "," + JSONKEY_TM + actionTime + "," + JSONKEY_ACTION + "\"" + eventId + "\"," + JSONKEY_ACTPARAM + "{" + paramJson + "}" + (!TextUtils.isEmpty(buJson) ? ",\"bu\":{" + buJson + "}" : "") + "}", 0);
    }

    private String getParam(ArrayList<NameValuePair> params) {
        if (params == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        ArrayList<NameValuePair> temp = new ArrayList();
        temp.addAll(new ArrayList(params));
        for (int i = 0; i < temp.size(); i++) {
            String value = "";
            if (((NameValuePair) temp.get(i)).getValue() != null) {
                value = ((NameValuePair) temp.get(i)).getValue().trim();
            }
            sb.append("\"" + ((NameValuePair) temp.get(i)).getName() + "\":\"" + value + "\"");
            if (i < temp.size() - 1) {
                sb.append(",");
            }
        }
        String paramJson = sb.toString();
        if (paramJson.endsWith(",")) {
            return paramJson.substring(0, paramJson.length() - 1);
        }
        return paramJson;
    }

    public void onEventWithParam(int eventId, String value, ArrayList<NameValuePair> actParams) {
        onEventWithParam(eventId, value, actParams, null);
    }

    public String paramsToString(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();
        if (params != null) {
            for (NameValuePair pair : params) {
                if (pair != null) {
                    sb.append(pair.getName()).append('=').append(pair.getValue()).append(',');
                }
            }
        }
        return sb.toString();
    }

    public void onEventWithParam(int eventId, String value, NameValuePair param) {
        ArrayList<NameValuePair> params = new ArrayList(1);
        params.add(param);
        onEventWithParam(eventId, value, params, null);
    }

    public void onEventWithParam(int eventId, String paramName, String paramValue) {
        LogUtil.e(TAG, "event " + eventId + ", param " + paramName + " : " + paramValue);
        NameValuePair param = new BasicNameValuePair(paramName, paramValue);
        ArrayList<NameValuePair> params = new ArrayList(1);
        params.add(param);
        onEventWithParam(eventId, paramValue, params, null);
    }

    public void onEventWithValue(int eventId, String value) {
        ReqData reqdata = new ReqData(CommandConstants.K_COMMAND_KEY_STATISTICS_RECORD, 4, this.mHandler, 1101, 4000);
        CmdStatisticsRecord.packetParams(reqdata, eventId, value, null, null);
        CommandCenter.getInstance().sendRequest(reqdata);
    }

    public void upLoadStatistics() {
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            CommonHandlerThread.getInstance().sendMessage(13, -1, -1, null, 0);
        }
        if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
            CommonHandlerThread.getInstance().sendMessage(14, -1, -1, null, 0);
        }
    }

    @Deprecated
    public void onMapScaleSet(int scale) {
        this.mLastMapScale = scale;
    }
}
