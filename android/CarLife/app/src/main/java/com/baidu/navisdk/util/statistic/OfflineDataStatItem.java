package com.baidu.navisdk.util.statistic;

import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.model.datastruct.OfflineDataInfo;
import com.baidu.navisdk.util.common.SDCardUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class OfflineDataStatItem {
    private static final int SIZE_M = 1048576;
    private static final String TAG = OfflineDataStatItem.class.getSimpleName();
    private static OfflineDataStatItem instance = null;
    private StringBuilder mDownloadedProvinces;
    private ArrayList<NameValuePair> mStatPairList = new ArrayList();
    private long mTotalDownloadedSize = 0;

    public static OfflineDataStatItem getInstance() {
        if (instance == null) {
            instance = new OfflineDataStatItem();
        }
        return instance;
    }

    private OfflineDataStatItem() {
    }

    public void onEvent() {
        init();
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_DATAMANAGER_SIZE, Long.toString(this.mTotalDownloadedSize / 1048576)));
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_DATAMANAGER_SDLEFT, Long.toString(SDCardUtils.getSdcardSpace() / 1048576)));
        String provinces = "";
        if (this.mDownloadedProvinces != null) {
            try {
                provinces = URLEncoder.encode(this.mDownloadedProvinces.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.mStatPairList.add(new BasicNameValuePair(NaviStatConstants.K_NSC_KEY_DATAMANAGER_AREA, provinces));
        BNStatisticsManager.getInstance().onEventWithParam(NaviStatConstants.K_NSC_ACTION_DATAMANAGER, null, this.mStatPairList);
    }

    private void init() {
        this.mDownloadedProvinces = new StringBuilder();
        List<OfflineDataInfo> list = BNOfflineDataManager.getInstance().getDownloadedList();
        if (list != null) {
            for (OfflineDataInfo odi : list) {
                if (odi != null) {
                    this.mTotalDownloadedSize += (long) odi.mDownloadSize;
                    this.mDownloadedProvinces.append(odi.mName).append(",");
                }
            }
        }
        if (this.mDownloadedProvinces.length() > 0) {
            this.mDownloadedProvinces.deleteCharAt(this.mDownloadedProvinces.length() - 1);
        }
    }
}
