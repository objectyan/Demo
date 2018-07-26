package com.baidu.navisdk.util.statistic;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import java.text.DecimalFormat;

public class NetFlowStat {
    private static final String KEY_COUNT_SUM = "count.sum";
    private static final String KEY_DATA_SIZE = "data.size";
    private static final String KEY_PSTDOMAIN_NAME = "pstdomain.name";
    private static final String KEY_TICK_COUNT = "tick.count";
    private static final String NAVI_END_FLAG_KEY = "navi.end.flag.key";
    private static final String TAG = NetFlowStat.class.getName();
    private static NetFlowStat instance = null;
    private StringBuffer httpNetFlowBuffer;

    public static class HttpNetFlowInfo {
        private static DecimalFormat decimalFormat = null;
        private float receiveDataSize = 0.0f;
        private float sendDataSize = 0.0f;
        private long startTime = 0;
        private String url = null;

        public HttpNetFlowInfo() {
            if (decimalFormat == null) {
                decimalFormat = new DecimalFormat(".0");
            }
        }

        public void setSendDataInfo(long startTime, long sendDataSizeByte, String url) {
            this.url = NetFlowStat.getUrlForShort(url);
            this.startTime = startTime;
            this.sendDataSize = ((float) (sendDataSizeByte >> 9)) / 2.0f;
        }

        public void setReceiveDataInfo(long receiveDataSizeByte) {
            this.receiveDataSize = ((float) (receiveDataSizeByte >> 9)) / 2.0f;
        }

        public String toString() {
            if (decimalFormat == null) {
                decimalFormat = new DecimalFormat(".0");
            }
            StringBuffer sb = new StringBuffer();
            sb.append("c;");
            sb.append(this.startTime + ";");
            sb.append(decimalFormat.format((double) (this.sendDataSize + this.receiveDataSize)) + ";");
            if (this.url == null) {
                this.url = "";
            }
            sb.append(this.url);
            return sb.toString();
        }

        public void submit() {
            NetFlowStat.getInstance().addHttpNetFlow(toString());
        }
    }

    private NetFlowStat() {
        this.httpNetFlowBuffer = null;
        this.httpNetFlowBuffer = new StringBuffer();
    }

    public static NetFlowStat getInstance() {
        if (instance == null) {
            instance = new NetFlowStat();
        }
        return instance;
    }

    public String GetAllNetWorkDataSize() {
        Bundle mDataBundle = new Bundle();
        JNIStatisticsControl.sInstance.getAllNetWorkDataSize(mDataBundle);
        return parseBundle(mDataBundle);
    }

    private String parseBundle(Bundle mDataBundle) {
        if (mDataBundle == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        int countSum = mDataBundle.getInt(KEY_COUNT_SUM);
        for (int i = 0; i < countSum; i++) {
            Bundle mBundle = mDataBundle.getBundle(i + "");
            if (mBundle != null) {
                sb.append("e;");
                sb.append(mBundle.getLong(KEY_TICK_COUNT));
                sb.append(";");
                sb.append(mBundle.getDouble(KEY_DATA_SIZE));
                sb.append(";");
                sb.append(getUrlForShort(mBundle.getString(KEY_PSTDOMAIN_NAME)));
                if (i + 1 < countSum) {
                    sb.append("||");
                }
            }
        }
        return sb.toString();
    }

    public void initStat(Context mContext) {
        if (mContext == null) {
            mContext = BNaviModuleManager.getContext();
            if (mContext == null) {
                return;
            }
        }
        if (PreferenceHelper.getInstance(mContext).getBoolean(NAVI_END_FLAG_KEY, false)) {
            NaviMergeStatItem.getInstance().mDft = 1;
        } else {
            NaviMergeStatItem.getInstance().mDft = 0;
        }
        PreferenceHelper.getInstance(mContext).putBoolean(NAVI_END_FLAG_KEY, true);
    }

    public void endStat(Context mContext) {
        if (mContext != null) {
            PreferenceHelper.getInstance(mContext).putBoolean(NAVI_END_FLAG_KEY, false);
            String engineNetFlowStat = GetAllNetWorkDataSize();
            String httpNetFlowStat = "";
            if (this.httpNetFlowBuffer != null) {
                httpNetFlowStat = this.httpNetFlowBuffer.toString();
            }
            LogUtil.m15791e(TAG + "_endStat engine:", engineNetFlowStat);
            LogUtil.m15791e(TAG + "_endStat http:", httpNetFlowStat);
            NaviMergeStatItem.getInstance().setNetFlow(engineNetFlowStat + "||" + httpNetFlowStat);
            clearOldNetWorkDataRecord();
            destroy();
        }
    }

    public void clearOldNetWorkDataRecord() {
        JNIStatisticsControl.sInstance.clearOldNetWorkDataRecord();
    }

    public void addHttpNetFlow(String statContent) {
        if (statContent != null) {
            if (this.httpNetFlowBuffer == null) {
                this.httpNetFlowBuffer = new StringBuffer();
            }
            if (!this.httpNetFlowBuffer.toString().equals("")) {
                this.httpNetFlowBuffer.append("||");
            }
            this.httpNetFlowBuffer.append(statContent);
        }
    }

    public void destroy() {
        instance = null;
        this.httpNetFlowBuffer = null;
    }

    private static String getUrlForShort(String url) {
        if (url == null) {
            return null;
        }
        if (url.startsWith("http://") && url.length() > "http://".length()) {
            return url.substring("http://".length());
        }
        if (!url.startsWith("https://") || url.length() <= "https://".length()) {
            return url;
        }
        return url.substring("https://".length());
    }
}
