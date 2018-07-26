package com.baidu.navisdk.util.logic;

import android.location.GpsStatus.Listener;
import android.os.SystemClock;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import java.util.HashMap;

class BNSysLocationManager$3 implements Listener {
    final /* synthetic */ BNSysLocationManager this$0;

    BNSysLocationManager$3(BNSysLocationManager this$0) {
        this.this$0 = this$0;
    }

    public void onGpsStatusChanged(int event) {
        LogUtil.m15791e("Location", "onGpsStatusChanged event= " + event);
        BNSysLocationManager.access$602(this.this$0, event);
        if (BNSysLocationManager.access$600(this.this$0) == 4) {
            BNSysLocationManager.access$702(this.this$0, SystemClock.elapsedRealtime());
        }
        if (event == 1) {
            LogUtil.m15791e("Location", "onGpsStatusChanged GPS_EVENT_STARTED");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_w_3, "1", null, null);
        } else if (event == 2) {
            LogUtil.m15791e("Location", "onGpsStatusChanged GPS_EVENT_STOPPED");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_w_3, "2", null, null);
        } else if (event == 3) {
            LogUtil.m15791e("Location", "onGpsStatusChanged GPS_EVENT_FIRST_FIX");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_w_3, "3", null, null);
        }
        HashMap<String, Integer> satellitesMap = BNSysLocationManager.access$800(this.this$0);
        if (satellitesMap != null) {
            int fixedNum = ((Integer) satellitesMap.get("fixedSatellitesNum")).intValue();
            int searchedNum = ((Integer) satellitesMap.get("searchedSatellitesNum")).intValue();
            if (fixedNum != BNSysLocationManager.access$300(this.this$0)) {
                BNSysLocationManager.access$302(this.this$0, fixedNum);
                LogUtil.m15791e("Location", "onGpsStatusChanged event=" + event + " FixedSatellitesNum=" + BNSysLocationManager.access$300(this.this$0));
                BNSysLocationManager.access$900(this.this$0, BNSysLocationManager.access$300(this.this$0));
            }
            if (searchedNum != BNSysLocationManager.access$200(this.this$0)) {
                BNSysLocationManager.access$202(this.this$0, searchedNum);
                LogUtil.m15791e("Location", "onGpsStatusChanged event=" + event + " SearchedSatellitesNum=" + BNSysLocationManager.access$200(this.this$0));
                BNSysLocationManager.access$900(this.this$0, BNSysLocationManager.access$200(this.this$0));
            }
            if (this.this$0.mSensorFingerEnable) {
                BNSysLocationManager.access$1000(this.this$0);
            }
        }
    }
}
