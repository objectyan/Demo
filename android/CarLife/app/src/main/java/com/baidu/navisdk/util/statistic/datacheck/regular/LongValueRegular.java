package com.baidu.navisdk.util.statistic.datacheck.regular;

import com.baidu.navisdk.util.statistic.datacheck.DataCheckHelper;
import com.baidu.navisdk.util.statistic.datacheck.GeneralRegularData;
import com.facebook.common.p262l.C5361b;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class LongValueRegular extends Regular {
    /* renamed from: a */
    public long f19720a = Long.MIN_VALUE;
    public List<Long> arrValues = null;
    /* renamed from: b */
    public long f19721b = C5361b.f21945a;
    public long fixValue = Long.MIN_VALUE;
    private Pattern pattern = null;
    public String regex = null;

    public LongValueRegular(GeneralRegularData regularData, String n, String c, String t) {
        super(regularData, n, c, t);
    }

    public boolean check() {
        if (this.mGeneralRegularData != null && this.mGeneralRegularData.getDataBundle() != null && !this.mGeneralRegularData.getDataBundle().containsKey(this.name)) {
            return true;
        }
        long actualValue = Long.MIN_VALUE;
        boolean ret = false;
        if (!(this.mGeneralRegularData == null || this.mGeneralRegularData.getDataBundle() == null || !this.mGeneralRegularData.getDataBundle().containsKey(this.name))) {
            actualValue = this.mGeneralRegularData.getDataBundle().getLong(this.name);
            if (Regular.CATEGORY_FIX_VALUE.equals(this.category) && this.fixValue == actualValue) {
                ret = true;
            } else if ("v".equals(this.category)) {
                ret = true;
            } else if (Regular.CATEGORY_ARRAY_VALUE.equals(this.category)) {
                ret = this.arrValues != null && this.arrValues.contains(Long.valueOf(actualValue));
            } else if (Regular.CATEGORY_AREA_VALUE.equals(this.category)) {
                if (this.f19720a != Long.MIN_VALUE && this.f19721b != C5361b.f21945a) {
                    ret = actualValue > this.f19720a && actualValue < this.f19721b;
                } else if (this.f19720a != Long.MIN_VALUE && this.f19721b == C5361b.f21945a) {
                    ret = actualValue > this.f19720a;
                } else if (this.f19720a == Long.MIN_VALUE && this.f19721b != C5361b.f21945a) {
                    ret = actualValue < this.f19721b;
                }
            } else if (Regular.CATEGORY_REGEX_VALUE.equals(this.category)) {
                if (this.pattern == null && this.regex != null && this.regex.length() > 0) {
                    this.pattern = Pattern.compile(this.regex);
                }
                if (this.pattern != null) {
                    ret = this.pattern.matcher("" + actualValue).matches();
                }
            }
        }
        if (ret) {
            return ret;
        }
        String tmpregularValue = "-";
        String msg = "[error][name:" + this.name + "][category:" + this.category + "][type:" + this.type + "][regularValue:";
        if (Regular.CATEGORY_FIX_VALUE.equals(this.category)) {
            msg = msg + this.fixValue;
            tmpregularValue = "" + this.fixValue;
        } else if (!"v".equals(this.category)) {
            if (Regular.CATEGORY_ARRAY_VALUE.equals(this.category)) {
                msg = msg + this.arrValues;
                tmpregularValue = this.arrValues.toString();
            } else if (Regular.CATEGORY_AREA_VALUE.equals(this.category)) {
                msg = msg + this.f19720a + "," + this.f19721b;
                tmpregularValue = this.f19720a + "," + this.f19721b;
            } else if (Regular.CATEGORY_REGEX_VALUE.equals(this.category)) {
                msg = msg + this.regex;
                tmpregularValue = this.regex;
            }
        }
        this.mGeneralRegularData.addErrorInfo(msg + "][actualvalue:" + actualValue + "]");
        this.mGeneralRegularData.addToastErrorInfo(this.name, "" + actualValue);
        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("name", this.name);
            jsonObj.put(Regular.ATTR_KEY_CATEGORY, this.category);
            jsonObj.put("type", this.type);
            jsonObj.put("regularValue", tmpregularValue);
            jsonObj.put("actualvalue", "" + actualValue);
            DataCheckHelper.sUpJsonArr.put(jsonObj);
            return ret;
        } catch (JSONException e) {
            return ret;
        }
    }
}
