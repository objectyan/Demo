package com.baidu.navisdk.util.statistic.datacheck.regular;

import android.os.SystemClock;
import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;
import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import org.json.JSONException;
import org.json.JSONObject;

public class FrequencyRegular extends Regular {
    private long frequency = 0;
    private long lastCheckTime = -1;

    public FrequencyRegular(GeneralRegularData regularData, long fre) {
        super(regularData, null, null, null);
        this.frequency = fre;
    }

    public boolean check() {
        long curTime = SystemClock.elapsedRealtime();
        if (curTime - this.lastCheckTime <= this.frequency) {
            this.mGeneralRegularData.addErrorInfo("[error][frequency:" + this.frequency + "][lastchecktime:" + this.lastCheckTime + "ms][curchecktime:" + curTime + "ms][timediff:" + (curTime - this.lastCheckTime) + "ms]");
            this.mGeneralRegularData.addToastErrorInfo("frequency", (curTime - this.lastCheckTime) + "ms");
            try {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("name", "frequency");
                jsonObj.put(Regular.ATTR_KEY_CATEGORY, this.category);
                jsonObj.put("type", this.type);
                jsonObj.put("regularValue", this.frequency);
                jsonObj.put("actualvalue", "" + (curTime - this.lastCheckTime));
                DataCheckHelper.sUpJsonArr.put(jsonObj);
            } catch (JSONException e) {
            }
            this.lastCheckTime = curTime;
            return false;
        }
        this.lastCheckTime = curTime;
        return true;
    }
}
