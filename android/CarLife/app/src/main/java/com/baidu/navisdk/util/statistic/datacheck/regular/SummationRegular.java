package com.baidu.navisdk.util.statistic.datacheck.regular;

import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;
import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import org.json.JSONException;
import org.json.JSONObject;

public class SummationRegular extends Regular {
    public int curSummation = 0;
    public int summationRegularValue = 0;

    public SummationRegular(GeneralRegularData regularData, int sum) {
        super(regularData, null, null, null);
        this.summationRegularValue = sum;
    }

    public boolean check() {
        int i = this.curSummation + 1;
        this.curSummation = i;
        if (i <= this.summationRegularValue) {
            return true;
        }
        this.mGeneralRegularData.addErrorInfo("[error][summation:" + this.summationRegularValue + "][curSummation:" + this.curSummation + "]");
        this.mGeneralRegularData.addToastErrorInfo(Regular.ATTR_KEY_SUMMATION, "" + this.curSummation);
        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("name", Regular.ATTR_KEY_SUMMATION);
            jsonObj.put(Regular.ATTR_KEY_CATEGORY, this.category);
            jsonObj.put("type", this.type);
            jsonObj.put("regularValue", this.summationRegularValue);
            jsonObj.put("actualvalue", "" + this.curSummation);
            DataCheckHelper.sUpJsonArr.put(jsonObj);
        } catch (JSONException e) {
        }
        return false;
    }
}
